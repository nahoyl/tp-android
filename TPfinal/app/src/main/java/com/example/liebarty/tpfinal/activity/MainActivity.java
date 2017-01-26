package com.example.liebarty.tpfinal.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;

import com.example.liebarty.tpfinal.R;
import com.example.liebarty.tpfinal.activity.ActivityAffichePhotos;


public class MainActivity extends Activity {

    private ProgressBar mProgress;
    private int mProgressStatus = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, ActivityAffichePhotos.class);
        /*
        mProgress = (ProgressBar) findViewById(R.id.progressBar);

        // Start lengthy operation in a background thread
        new Thread(new Runnable() {
            public void run() {
                int jumpTime = 0;
                while (mProgressStatus < 100) {
                    try {

                        jumpTime += 1;
                        mProgress.setProgress(jumpTime);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }


            }
        }).start();
        */
        startActivity(intent);
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
