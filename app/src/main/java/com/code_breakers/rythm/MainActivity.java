package com.code_breakers.rythm;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Checking User Session
        ParseUser currentUser = ParseUser.getCurrentUser();

//        ShortcutIcon();

        if (currentUser != null) {
            // do stuff with the user
            Intent i = new Intent(getApplicationContext(),Dashboard.class);
            startActivity(i);
            finish();
        } else {
            // show the signup or login screen
            Intent i = new Intent(getApplicationContext(),login.class);
            startActivity(i);
            finish();
        }


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

    //Creating Shortcut at homescreen
//    private void ShortcutIcon(){
//
//        Intent shortcutIntent = new Intent(getApplicationContext(), MainActivity.class);
//        shortcutIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        shortcutIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//
//        Intent addIntent = new Intent();
//        addIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
//        addIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, "Test");
//        addIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, Intent.ShortcutIconResource.fromContext(getApplicationContext(), R.mipmap.ic_launcher));
//        addIntent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
//        getApplicationContext().sendBroadcast(addIntent);
//    }
}
