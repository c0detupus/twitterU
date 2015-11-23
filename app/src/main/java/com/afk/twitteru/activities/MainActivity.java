package com.afk.twitteru.activities;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.AssetManager;
import android.content.res.Configuration;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.afk.twitteru.R;
import com.afk.twitteru.fragments.ListViewFragment;
import com.afk.twitteru.fragments.StaggeredGridFragment;
import com.afk.twitteru.utils.TwitterClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import cz.msebera.android.httpclient.Header;

import static android.content.res.Configuration.ORIENTATION_LANDSCAPE;
import static android.content.res.Configuration.ORIENTATION_PORTRAIT;


public class MainActivity extends Activity {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "brI7DXOJVCDNeUanRVnut410q";
    private static final String TWITTER_SECRET = "7Kl2tOVOhJkZcSeczmtgkgDKKIZ7vrm2Sx2qMr6vrip08XS32C";

    private static String ACCESS_TOKEN;
    private static String ACCESS_TOKEN_SECRET;
    private String log = "LOG";
    private boolean loggedIn;


    private EditText usernameET;
    private EditText passwordET;
    private Button loginButton;

    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Resources resources = this.getResources();
        AssetManager assetManager = resources.getAssets();



        try {
            InputStream rawResource = resources.openRawResource(R.raw.oauth);
            Properties properties = new Properties();
            properties.load(rawResource);


            ACCESS_TOKEN = properties.getProperty("ACCESS_TOKEN");
            ACCESS_TOKEN_SECRET = properties.getProperty("ACCESS_TOKEN_SECRET");



        } catch (Resources.NotFoundException e) {
            System.err.println("Didfind raw resource: "+e);
        } catch (IOException e) {
            System.err.println("Failed to load oauth properties file exception " +e);
        }


        loggedIn = false;

        usernameET = (EditText) findViewById(R.id.userNameET);
        passwordET = (EditText) findViewById(R.id.passwordET);
        loginButton = (Button) findViewById(R.id.login_button);

        if (loggedIn) {

            passwordET.setVisibility(View.GONE);
            usernameET.setVisibility(View.GONE);
            loginButton.setVisibility(View.GONE);

        }


        if (findViewById(R.id.fragment_holder) != null) {

            if (savedInstanceState != null) {
                return;
            }


            if (loggedIn) {
                onConfigurationChanged(getResources().getConfiguration());
            }


        }
    }


    private void getToken() {

        RequestParams params = new RequestParams();

        params.add("oauth_nonce", TWITTER_SECRET);
        params.add("oauth_consumer_key", TWITTER_KEY);
        params.add("oauth_callback","http://twitteru.info");
        params.add("oauth_token", ACCESS_TOKEN);
        params.add("oauth_signature", ACCESS_TOKEN_SECRET);
        params.add("x_auth_access_type", "read");


        System.out.println(params);
//        TwitterClient.post("oauth/request_token", params, new JsonHttpResponseHandler() {
//
//            @Override
//            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
//                super.onFailure(statusCode, headers, throwable, errorResponse);
//                System.out.println(errorResponse);
//            }
////
////            @Override
////            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
////                super.onFailure(statusCode, headers, throwable, errorResponse);
////                System.out.println(errorResponse);
////            }
//
//            @Override
//            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
//                super.onFailure(statusCode, headers, responseString, throwable);
//                System.out.println("FAIL");
//                System.out.println(statusCode);
//                System.out.println(responseString);
//            }
//
//            @Override
//            public void onSuccess(int statusCode, Header[] headers, String responseString) {
//
//            }
//
//            @Override
//            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
//
//                System.out.println("asdasd");
//                JSONObject firstEvent = null;
//
//                try {
//                    firstEvent = (JSONObject) response.get(0);
//
//
//                    String tweetText = firstEvent.getString("text");
//
//                    // Do something with the response
//                    System.out.println(firstEvent);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//
//
//            }
//        });

    }

    public void loginMethod(View view) {

        username = usernameET.getText().toString();
        password = passwordET.getText().toString();


        getToken();
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


}
