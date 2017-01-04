package com.example.liebarty.appcoursun;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {

    public final static String EXTRA_MESSAGE_NOM = "com.example.liebarty.appcoursun.MESSAGENOM";
    public final static String EXTRA_MESSAGE_PRENOM = "com.example.liebarty.appcoursun.MESSAGEPRENOM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("LifeCycle", "onCreate");
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

    public void sendTextValue(View view){

        Intent intent = new Intent(this, SecondaryActivity.class);


        EditText editTextn = (EditText) findViewById(R.id.editTextNom);
        String messageNom = editTextn.getText().toString();
        Log.i("LifeCycle", messageNom);
        if (messageNom.matches("")) {
            Toast.makeText(this, "Vous n'avez pas entrée votre nom", Toast.LENGTH_SHORT).show();
            return;
        }
        intent.putExtra(EXTRA_MESSAGE_NOM, messageNom);

        EditText editTextp = (EditText) findViewById(R.id.editTextPrenom);
        String messagePrenom = editTextp.getText().toString();
        Log.i("LifeCycle", messagePrenom);
        if (messagePrenom.matches("")) {
            Toast.makeText(this, "Vous n'avez pas entrée votre prénom", Toast.LENGTH_SHORT).show();
            return;
        }
        intent.putExtra(EXTRA_MESSAGE_PRENOM, messagePrenom);


        startActivity(intent);

    }



}
