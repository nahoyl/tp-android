package com.example.liebarty.appcoursun;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by liebarty on 14/12/16.
 */
public class SecondaryActivity extends Activity{

    public final static String EXTRA_MESSAGE_NOM = "com.example.liebarty.appcoursun.MESSAGENOM";
    public final static String EXTRA_MESSAGE_PRENOM = "com.example.liebarty.appcoursun.MESSAGEPRENOM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);
        Log.i("LifeCycle", "onCreate");

        Intent intent = getIntent();

        String messageNom = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_NOM);
        String messagePrenom = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_PRENOM);
        Log.i("LifeCycle", messageNom);
        Log.i("LifeCycle", messagePrenom);

        TextView textViewNom = (TextView) findViewById(R.id.textViewNom);
        textViewNom.setText(messageNom);

        TextView textViewPrenom = (TextView) findViewById(R.id.textViewPrenom);
        textViewPrenom.setText(messagePrenom);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("LifeCycle", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("LifeCycle", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("LifeCycle", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("LifeCycle", "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("LifeCycle", "onRestart");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();  // Always call the superclass
        Log.i("LifeCycle", "onDestroy");
        // Stop method tracing that the activity started during onCreate()
        android.os.Debug.stopMethodTracing();
    }

    public void launchDisplay(View view){

        Intent intent = new Intent(this, DisplayFrameList.class);


        TextView TVNom = (TextView) findViewById(R.id.textViewNom);
        String messageNom = TVNom.getText().toString();
        intent.putExtra(EXTRA_MESSAGE_NOM, messageNom);

        TextView TVPrenom = (TextView) findViewById(R.id.textViewPrenom);
        String messagePrenom = TVPrenom.getText().toString();
        intent.putExtra(EXTRA_MESSAGE_PRENOM, messagePrenom);


        startActivity(intent);

    }

}
