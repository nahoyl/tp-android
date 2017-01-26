package com.example.liebarty.tpfinal.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.liebarty.tpfinal.ItemImage.ListeItemImage;
import com.example.liebarty.tpfinal.LecteurXML;
import com.example.liebarty.tpfinal.R;
import com.example.liebarty.tpfinal.RecuperateurPageWeb;
import com.example.liebarty.tpfinal.adapter.ModelAdapter;
import com.example.liebarty.tpfinal.controleur.ControleurItemImage;

import java.io.InputStream;
import java.net.URL;


public class ActivityAffichePhotos extends Activity {

    protected ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_affiche_photos);

        ControleurItemImage ci = new ControleurItemImage(ActivityAffichePhotos.this);

        String urlPageWeb = "http://public.ave-comics.com/gabriel/iut/images.xml";

        RecuperateurPageWeb rpw = new RecuperateurPageWeb(urlPageWeb);

        LecteurXML lecteur = new LecteurXML(rpw.getInputStream());
        /*
        ListeItemImage liste = lecteur.getListeItemImage();

        ci.ajouterTousItemImage(liste.getItemImage());
        */
        mListView = (ListView)findViewById(R.id.mlistView);
        ModelAdapter adapter = new ModelAdapter(ActivityAffichePhotos.this, ci.recupererListe());
        mListView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_affiche_photos, menu);
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