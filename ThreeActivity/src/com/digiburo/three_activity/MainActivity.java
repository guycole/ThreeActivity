package com.digiburo.three_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * default (main) activity for ThreeActivity project
 * 
 * demonstrate multi-activity application
 * this activity displays a single button to invoke next Activity
 * 
 * @author gsc
 */
public class MainActivity extends Activity {
  
  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    if (Constants.DEBUG_APPLICATION_MODE) {
      LogFacade.info(LOG_TAG, "----start w/debug mode true----");
    } else {
      LogFacade.info(LOG_TAG, "----start w/debug mode false----");
    }

    //layout inflation
    setContentView(R.layout.activity_main);

    //obtain button handle (button created in XML)
    Button nextButton = (Button) findViewById(R.id.buttonNext01);

    //service button press 
    nextButton.setOnClickListener(new View.OnClickListener() {

      //invoke next activity
      public void onClick(View view) {
        LogFacade.info(LOG_TAG, "invoke next activity");
        startActivity(new Intent(getBaseContext(), MiddleActivity.class));
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