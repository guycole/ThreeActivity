package com.digiburo.three_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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
 * <LI> update content w/string from EndActivity (startActivityForResult)
 * <LI> note that background image selection depends upon platform
 * </UL>
 *
 * @author gsc
 */
public class MiddleActivity extends Activity {

  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    LogFacade.entry(LOG_TAG, "onCreate");

    //layout inflation
    setContentView(R.layout.activity_middle);

    //obtain handle (created in XML)
    textView = (TextView) findViewById(R.id.textView01);
    
    //obtain button handle (button created in XML)
    final Button buttonNext = (Button) findViewById(R.id.buttonNext01);
 
    //service button press 
    buttonNext.setOnClickListener(new View.OnClickListener() {

      //invoke next activity w/extra arguments
      public void onClick(View view) {
        LogFacade.info(LOG_TAG, "invoke next activity");

        //explicit intent
        Intent intent = new Intent(getBaseContext(), EndActivity.class);
        intent.setAction(Constants.MIDDLE_ACTIVITY_ACTION);
        intent.putExtra(Constants.MIDDLE_ACTIVITY_KEY, "FreshValue");

        startActivityForResult(intent, Constants.MIDDLE_ACTIVITY_REQUEST);
      }
    });

    //obtain button handle (button created in XML)
    Button buttonBack = (Button) findViewById(R.id.buttonBack01);
    
    //service button press
    buttonBack.setOnClickListener(new View.OnClickListener() {
      public void onClick(View view) {
        LogFacade.info(LOG_TAG, "kill this activity");
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

    LogFacade.debug(LOG_TAG, "on activity result:" + requestCode + ":" + resultCode + ":" + intent);
    
    //which request is this?
    if (requestCode == Constants.MIDDLE_ACTIVITY_REQUEST) {
      LogFacade.debug(LOG_TAG, "return from EndActivity");
    }

    //what is result status?
    if (resultCode == RESULT_CANCELED) {
      LogFacade.debug(LOG_TAG, "cancel noted");
    } else {
      LogFacade.debug(LOG_TAG, "not cancelled");
    }
    
    //any extra information?
    if (intent != null) {
      LogFacade.debug(LOG_TAG, "getAction:" + intent.getAction());
      LogFacade.debug(LOG_TAG, Constants.MIDDLE_ACTIVITY_KEY + ":" + intent.getStringExtra(Constants.MIDDLE_ACTIVITY_KEY));
      
      //update Activity with fresh content
      textView.setText(intent.getStringExtra(Constants.MIDDLE_ACTIVITY_KEY));
    }
  }

  //
  private TextView textView;

  //
  public final String LOG_TAG = getClass().getName();
}

/*
 * Copyright 2010 Digital Burro, INC
 * Created on Nov 17, 2010 by gsc
 */