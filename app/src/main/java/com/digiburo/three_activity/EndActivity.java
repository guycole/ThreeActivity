package com.digiburo.three_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * end activity for ThreeActivity project
 *
 * <UL>
 * <LI> one button to kill EndActivity (and return to MiddleActivity)
 * <LI> illustrate use of EditText
 * <LI> illustrate sending arguments via intent (accept and return)
 * </UL>
 */
public class EndActivity extends AppCompatActivity {
    public final String LOG_TAG = getClass().getName();

    public static final String END_ACTIVITY_ACTION = "EndActivityAction";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG, "onCreate");

        //arguments from whomever invoked this activity
        Intent intent = getIntent();
        Log.d(LOG_TAG, "getAction:" + intent.getAction());
        Log.d(LOG_TAG, MiddleActivity.MIDDLE_ACTIVITY_KEY + ":" + intent.getStringExtra(MiddleActivity.MIDDLE_ACTIVITY_KEY));

        //layout inflation
        setContentView(R.layout.activity_end);

        //obtain EditText (created in XML)
        final EditText editText = (EditText) findViewById(R.id.editText);
        if (intent != null) {
            //parent Activity sends editText value
            String payload = intent.getStringExtra(MiddleActivity.MIDDLE_ACTIVITY_KEY);
            if (payload != null) {
                editText.setText(payload);
            }
        }

        //obtain button handle (button created in XML)
        Button lastButton = (Button) findViewById(R.id.buttonLast);

        //service button press
        lastButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Log.d(LOG_TAG, "kill this activity");

                //read from editText, use default if necessary
                String returnArgument = editText.getText().toString().trim();
                if (returnArgument.trim().length() < 1) {
                    returnArgument = "empty result";
                }

                //package results for transmission to parent Activity
                Intent intent = new Intent();
                intent.setAction(END_ACTIVITY_ACTION);
                intent.putExtra(MiddleActivity.MIDDLE_ACTIVITY_KEY, returnArgument);
                setResult(RESULT_OK, intent);
                finish();
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
