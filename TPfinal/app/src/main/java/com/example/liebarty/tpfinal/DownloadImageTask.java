package com.example.liebarty.tpfinal;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;

// classe récupéré sur StackOverFlow pour charger une image avec le AsyncTask ...
// à avoir si c'est utile

// <uses-permission android:name="android.permission.INTERNET"/> a mettre dans le manisfest

// new DownloadImageTask((ImageView) findViewById(R.id.imageView1)).execute(MY_URL_STRING); appel

/**
 * Created by liebarty on 25/01/17.
 */
public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
    ImageView bmImage;

    public DownloadImageTask(ImageView bmImage) {
        this.bmImage = bmImage;
    }

    protected Bitmap doInBackground(String... urls) {
        String urldisplay = urls[0];
        Bitmap mIcon11 = null;
        try {
            InputStream in = new java.net.URL(urldisplay).openStream();
            mIcon11 = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return mIcon11;
    }

    protected void onPostExecute(Bitmap result) {
        bmImage.setImageBitmap(result);
    }
}
