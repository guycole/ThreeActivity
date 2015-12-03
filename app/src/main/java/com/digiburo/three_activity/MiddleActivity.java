package com.digiburo.three_activity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * middle activity for ThreeActivity project
 *
 * <UL>
 * <LI> one button to navigate to EndActivity
 * <LI> one button to return to MainActivity
 * <LI> illustrate use of ImageView
 * <LI> illustrate device orientation
 * <LI> update content w/string from EndActivity (startActivityForResult)
 * <LI> note that background image selection depends upon platform
 * </UL>
 */
public class MiddleActivity extends ActionBarActivity {
    public final String LOG_TAG = getClass().getName();

    public static final String MIDDLE_ACTIVITY_ACTION = "MiddleActivityAction";
    public static final String MIDDLE_ACTIVITY_KEY = "MiddleActivityKey";
    public static final int MIDDLE_ACTIVITY_REQUEST = 222;

    public static final String SAVED_PHRASE = "SAVED_PHRASE";

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG, "onCreate");

        //layout inflation
        setContentView(R.layout.activity_middle);

        //obtain handle (created in XML)
        textView = (TextView) findViewById(R.id.textView);

        //obtain button handle (button created in XML)
        final Button nextButton = (Button) findViewById(R.id.buttonNext);

        //service button press
        nextButton.setOnClickListener(new View.OnClickListener() {

            //invoke next activity
            public void onClick(View view) {
                Log.d(LOG_TAG, "invoke end activity");

                //explicit intent
                Intent intent = new Intent(getBaseContext(), EndActivity.class);
                intent.setAction(MIDDLE_ACTIVITY_ACTION);
                intent.putExtra(MIDDLE_ACTIVITY_KEY, "freshValue");

                startActivityForResult(intent, MIDDLE_ACTIVITY_REQUEST);
            }
        });

        //obtain button handle (button created in XML)
        Button lastButton = (Button) findViewById(R.id.buttonLast);

        //service button press
        lastButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Log.d(LOG_TAG, "kill this activity");
                finish();
            }
        });
    }

    /**
     * invoked when child activity completes
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        Log.d(LOG_TAG, "on activity result:" + requestCode + ":" + resultCode + ":" + intent);

        //which request is this?
        if (requestCode == MIDDLE_ACTIVITY_REQUEST) {
            Log.d(LOG_TAG, "return from EndActivity");
        }

        //what is result status?
        if (resultCode == RESULT_CANCELED) {
            Log.d(LOG_TAG, "cancel noted");
        } else {
            Log.d(LOG_TAG, "not cancelled");
        }

        //any extra information?
        if (intent != null) {
            Log.d(LOG_TAG, "getAction:" + intent.getAction());
            Log.d(LOG_TAG, MIDDLE_ACTIVITY_KEY + ":" + intent.getStringExtra(MIDDLE_ACTIVITY_KEY));

            //update Activity with fresh content
            if (intent.hasExtra(MIDDLE_ACTIVITY_KEY)) {
                textView.setText(intent.getStringExtra(MIDDLE_ACTIVITY_KEY));
            }
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey(SAVED_PHRASE)) {
            textView.setText(savedInstanceState.getString(SAVED_PHRASE));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String temp = textView.getText().toString().trim();
        if (!temp.isEmpty()) {
            outState.putString(SAVED_PHRASE, temp);
        }
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
