package com.mycompany.myfirstapp.Tel;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mycompany.myfirstapp.R;

import java.util.ArrayList;

public class SMSActivity extends ActionBarActivity implements AdapterView.OnClickListener {

    private EditText mEditTextNumber;
    private EditText mEditTextSms;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);


        mEditTextNumber = (EditText) findViewById(R.id.editTextNumber);
        mEditTextSms = (EditText) findViewById(R.id.editTextContent);

        Button mButtonSend = (Button) findViewById(R.id.buttonSend);
        mButtonSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonSend:
                // phone number
                String number = mEditTextNumber.getText().toString().trim();
                // message content
                String content = mEditTextSms.getText().toString().trim();
                if (TextUtils.isEmpty(number) || TextUtils.isEmpty(content))
                    // remember to show
                    Toast.makeText(SMSActivity.this, "phone number or message should not be empty", Toast.LENGTH_LONG).show();
                else {
                    SmsManager smsManager = SmsManager.getDefault();
                    ArrayList<String> contents = smsManager.divideMessage(content);
                    for (String str : contents) {
                        smsManager.sendTextMessage(number, null, str, null, null);
                    }
                }
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sm, menu);
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
