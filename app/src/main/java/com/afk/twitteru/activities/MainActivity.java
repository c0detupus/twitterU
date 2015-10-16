package com.afk.twitteru.activities;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.afk.twitteru.R;
import com.afk.twitteru.enums.Tags;
import com.afk.twitteru.fragments.ListViewFragment;
import com.afk.twitteru.fragments.StaggeredGridFragment;

import static android.content.res.Configuration.ORIENTATION_LANDSCAPE;
import static android.content.res.Configuration.ORIENTATION_PORTRAIT;


public class MainActivity extends Activity {


    private String log = "LOG";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.fragment_holder) != null) {

            if (savedInstanceState != null) {
                return;
            }


            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();


            ListViewFragment listViewFragment = new ListViewFragment();

            ft.add(R.id.fragment_holder, listViewFragment);
            ft.commit();


        }
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        Log.d(log, "orientation changed");


        int currentOrientation = getResources().getConfiguration().orientation;


        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();


        if (currentOrientation == ORIENTATION_LANDSCAPE) {
            StaggeredGridFragment staggeredGridFragment = new StaggeredGridFragment();

            ft.replace(R.id.fragment_holder, staggeredGridFragment);

            ft.commit();
        }


        if (currentOrientation == ORIENTATION_PORTRAIT) {
            ListViewFragment listViewFragment = new ListViewFragment();
            ft.replace(R.id.fragment_holder, listViewFragment);

            ft.commit();
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


}
