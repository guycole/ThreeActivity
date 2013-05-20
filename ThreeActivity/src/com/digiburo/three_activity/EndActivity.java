package com.digiburo.three_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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
 * 
 * @author gsc
 */
public class EndActivity extends Activity {
  
  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    LogFacade.entry(LOG_TAG, "onCreate");

    //arguments from whomever invoked this activity
    Intent intent = getIntent();
    LogFacade.debug(LOG_TAG, "getAction:" + intent.getAction());
    LogFacade.debug(LOG_TAG, Constants.MIDDLE_ACTIVITY_KEY + ":" + intent.getStringExtra(Constants.MIDDLE_ACTIVITY_KEY));

    //layout inflation
    setContentView(R.layout.activity_end);

    //obtain EditText (created in XML)
    final EditText editText = (EditText) findViewById(R.id.editText01);
    if (intent != null) {
      //parent Activity sends editText value
      String payload = intent.getStringExtra(Constants.MIDDLE_ACTIVITY_KEY);
      if (payload != null) {
        editText.setText(payload);        
      }
    }
    
    //obtain button handle (button created in XML)
    final Button button = (Button) findViewById(R.id.buttonBack01);

    //service button press 
    button.setOnClickListener(new View.OnClickListener() {

      //handler
      public void onClick(View view) {
        LogFacade.info(LOG_TAG, "kill this activity");
        
        //read from editText, use default if necessary
        String returnArgument = editText.getText().toString().trim();
        if (returnArgument.trim().length() < 1) {
          returnArgument = "empty result";
        }

        //package results for transmission to parent Activity
        Intent intent = new Intent();
        intent.setAction(Constants.END_ACTIVITY_ACTION);
        intent.putExtra(Constants.MIDDLE_ACTIVITY_KEY, returnArgument);

        setResult(RESULT_OK, intent);

        finish();
      }
    });
  }
  
  // life cycle instrumentation
  
  /*
   * (non-Javadoc)
   * @see android.app.Activity#onStart()
   */
  @Override
  protected void onStart() {
    super.onStart();
    LogFacade.entry(LOG_TAG, "onStart");
  }
  
  /*
   * (non-Javadoc)
   * @see android.app.Activity#onRestart()
   */
  @Override
  protected void onRestart() {
    super.onRestart();
    LogFacade.entry(LOG_TAG, "onRestart");
  }
  
  /*
   * (non-Javadoc)
   * @see android.app.Activity#onResume()
   */
  @Override
  protected void onResume() {
    super.onResume();
    LogFacade.entry(LOG_TAG, "onResume");
  }
  
  /*
   * (non-Javadoc)
   * @see android.app.Activity#onPause()
   */
  @Override
  protected void onPause() {
    super.onPause();
    LogFacade.entry(LOG_TAG, "onPause");
  }
  
  /*
   * (non-Javadoc)
   * @see android.app.Activity#onStop()
   */
  @Override
  protected void onStop() {
    super.onStop();
    LogFacade.entry(LOG_TAG, "onStop");
  }
  
  /*
   * (non-Javadoc)
   * @see android.app.Activity#onDestroy()
   */
  @Override
  protected void onDestroy() {
    super.onDestroy();
    LogFacade.entry(LOG_TAG, "onDestroy");
  }

  //
  public final String LOG_TAG = getClass().getName();
}

/*
 * Copyright 2010 Digital Burro, INC
 * Created on Nov 17, 2010 by gsc
 */