package com.digiburo.three_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public final String LOG_TAG = getClass().getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG, "onCreate");

        //layout inflation
        setContentView(R.layout.activity_main);

        WebView webView = (WebView) findViewById(R.id.webView);
        webView.setWebViewClient(new DemoWebViewClient());
        webView.loadUrl("file:///android_asset/html/about.html");

        //obtain button handle (button created in XML)
        final Button nextButton = (Button) findViewById(R.id.buttonNext);

        //service button press
        nextButton.setOnClickListener(new View.OnClickListener() {

            //invoke next activity
            public void onClick(View view) {
                Log.d(LOG_TAG, "invoke middle activity");
                startActivity(new Intent(getBaseContext(), MiddleActivity.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }
}
