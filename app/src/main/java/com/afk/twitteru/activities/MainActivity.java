package com.afk.twitteru.activities;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.afk.twitteru.R;
import com.afk.twitteru.fragments.ListViewFragment;
import com.afk.twitteru.fragments.LoginFragment;
import com.afk.twitteru.fragments.StaggeredGridFragment;

import static android.content.res.Configuration.ORIENTATION_LANDSCAPE;
import static android.content.res.Configuration.ORIENTATION_PORTRAIT;


public class MainActivity extends Activity implements LoginFragment.OnFragmentInteractionListener {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "brI7DXOJVCDNeUanRVnut410q";
    private static final String TWITTER_SECRET = "7Kl2tOVOhJkZcSeczmtgkgDKKIZ7vrm2Sx2qMr6vrip08XS32C";



    private String log = "LOG";
    private boolean loggedIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        loggedIn = false;
        if (findViewById(R.id.fragment_holder) != null) {

            if (savedInstanceState != null) {
                return;
            }


            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();


//            ListViewFragment listViewFragment = new ListViewFragment();
            LoginFragment loginFragment = new LoginFragment();

            if(loggedIn){
               onConfigurationChanged(getResources().getConfiguration());
            }else{
                ft.add(R.id.fragment_holder, loginFragment);
                ft.commit();

            }

//            ft.add(R.id.fragment_holder, loginFragment);
//            ft.commit();


        }
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        Log.d(log, "orientation changed");


        int currentOrientation = newConfig.orientation;


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


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
