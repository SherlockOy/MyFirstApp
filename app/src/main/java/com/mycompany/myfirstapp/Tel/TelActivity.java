package com.mycompany.myfirstapp.Tel;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mycompany.myfirstapp.R;

public class TelActivity extends ActionBarActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tel);

        Button tel_btn = (Button) this.findViewById(R.id.tel_btn);
        editText = (EditText) findViewById(R.id.editText_number);
        // 内部类调用外部私有成员
        tel_btn.setOnClickListener(new MyListener());

    }

    private class MyListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            // 内部类调用外部类方法
            // EditText editText = (EditText) findViewById(R.id.editText_number);

            //trim()去除空格
            String number = editText.getText().toString().trim();

            if (TextUtils.isEmpty(number)) {
                Toast.makeText(TelActivity.this, "number should not be empty", Toast.LENGTH_LONG).show();
                return;
            }
            // 设置Intent的各个参数
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + number));

            startActivity(intent);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tel, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
