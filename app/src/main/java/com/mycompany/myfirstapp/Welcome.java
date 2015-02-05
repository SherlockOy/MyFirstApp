package com.mycompany.myfirstapp;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.mycompany.myfirstapp.Tel.SMSActivity;
import com.mycompany.myfirstapp.Tel.TelActivity;
import com.mycompany.myfirstapp.connection.Connection;
import com.mycompany.myfirstapp.drawer.CustomDrawerAdapter;
import com.mycompany.myfirstapp.drawer.DrawerItem;
import com.mycompany.myfirstapp.sendMessage.SendMessageActivity;

import java.util.ArrayList;
import java.util.List;


public class Welcome extends ActionBarActivity {

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;

    private CharSequence mTitle;
    private CharSequence mDrawerTitle;
    CustomDrawerAdapter adapter;

    List<DrawerItem> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        mTitle = mDrawerTitle = getTitle();

        dataList = new ArrayList<DrawerItem>();
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        // Add Drawer Item to dataList
        dataList.add(new DrawerItem(true, R.drawable.bg_blue));
        dataList.add(new DrawerItem("Not implemented..."));
        dataList.add(new DrawerItem("Connection", R.drawable.ic_action_web_site));
        dataList.add(new DrawerItem("Already Finished..."));
        dataList.add(new DrawerItem("To Next", R.drawable.ic_action_forward));
        dataList.add(new DrawerItem("Call Phone", R.drawable.ic_action_call));
        dataList.add(new DrawerItem("Send SMS", R.drawable.ic_action_email));
        dataList.add(new DrawerItem("To be continued..."));


        mDrawerToggle = new ActionBarDrawerToggle(
                this,                      /* host Activity */
                mDrawerLayout,             /* DrawerLayout object */
                R.string.drawer_open,  /* "open drawer" description */
                R.string.drawer_close  /* "close drawer" description */
        ) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                // in android studio use getSupportActionBar() instead of getActionBar()
                // the ActionBarActivity is under the v7 support
                getSupportActionBar().setTitle(mTitle);
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle(mDrawerTitle);
            }
        };

        // Set the drawer toggle as the DrawerListener
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        // set the value of adapter
        adapter = new CustomDrawerAdapter(this, R.layout.drawer_list_item, dataList);

        // Set the adapter for the list view
        mDrawerList.setAdapter(adapter);

        // Set the list's click listener
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    // handle navigation click events
    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id) {

            selectItem(position);
        }
    }

    /**
     * Swaps activities in the main content view
     */
    private void selectItem(int position) {
        // to turn to each corresponding activity
        switch (position) {
            case 2:
                Intent intent_0 = new Intent(Welcome.this, Connection.class);
                startActivity(intent_0);
                break;
            case 4:
                Intent intent_1 = new Intent(Welcome.this, SendMessageActivity.class);
                startActivity(intent_1);
                break;
            case 5:
                Intent intent_2 = new Intent(Welcome.this, TelActivity.class);
                startActivity(intent_2);
                break;
            case 6:
                Intent intent_3 = new Intent(Welcome.this, SMSActivity.class);
                startActivity(intent_3);
                break;

            default:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_welcome, menu);
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

        // Handle your other action bar items...

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
