package com.mycompany.myfirstapp.sendMessage;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.mycompany.myfirstapp.R;


public class SendMessageActivity extends ActionBarActivity {

    // For the next activity to query the extra data, you should define the key for your
    // intent's extra using a public constant.
    // It's generally a good practice to define keys for intent extras using your app's
    // package name as a prefix. This ensures the keys are unique, in case your app interacts
    // with other apps.
    public final static String EXTRA_MESSAGE = "com.mycompany.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);


    }

    public void sendMessage(View view) {

        // this is used because the Activity is a subclass of the Context
        // and here Context is the first parameter the
        // second parameter is the Activity that is to be opened
        Intent intent = new Intent(this, DisplayMessageActivity.class);

        //get the message of the input from the editText View
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();

        // extra message can be carried in the intent
        // The putExtra() method takes the key name in the first parameter
        // and the value in the second parameter.
        intent.putExtra(EXTRA_MESSAGE, message);

        // start the target activity
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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


