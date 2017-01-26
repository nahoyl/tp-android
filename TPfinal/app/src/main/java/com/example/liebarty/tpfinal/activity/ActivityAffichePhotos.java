package com.example.liebarty.tpfinal.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.liebarty.tpfinal.ItemImage.Categorie;
import com.example.liebarty.tpfinal.LecteurXML;
import com.example.liebarty.tpfinal.R;
import com.example.liebarty.tpfinal.RecuperateurPageWeb;
import com.example.liebarty.tpfinal.adapter.ModelAdapter;
import com.example.liebarty.tpfinal.controleur.ControleurCategories;
import com.example.liebarty.tpfinal.thread.AsyncRecuperateur;

import java.io.InputStream;
import java.util.concurrent.ExecutionException;


public class ActivityAffichePhotos extends Activity {

    protected ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_affiche_photos);

        ControleurCategories ci = new ControleurCategories(ActivityAffichePhotos.this);

        String[] urlPageWeb = {"http://public.ave-comics.com/gabriel/iut/images.xml"};

        AsyncRecuperateur ar = new AsyncRecuperateur();
        ar.execute(urlPageWeb);
        InputStream is = null;
        try {
            is = ar.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        LecteurXML lecteur = new LecteurXML(is);

        Categorie liste = lecteur.getListeImage();

        ci.ajouterTousImage(liste.getItemImage());

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
