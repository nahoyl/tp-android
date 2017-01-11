package com.example.liebarty.appcoursun.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.liebarty.appcoursun.adapter.ModelAdapter;
import com.example.liebarty.appcoursun.R;
import com.example.liebarty.appcoursun.controller.ListPersonneController;
import com.example.liebarty.appcoursun.metier.Personne;

import java.util.List;


public class DisplayFrameList extends Activity {

    protected ListView mListView;
    protected ListPersonneController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_frame_list);

        Intent intent = getIntent();

        String messageNom = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_NOM);
        String messagePrenom = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_PRENOM);

        mListView = (ListView) findViewById(R.id.listView);
        controller = new ListPersonneController();
        controller.ajouterPersonne(messageNom, messagePrenom, Color.RED);
        //List<Personne> personnes = genererPersonnes();
        List<Personne> personnes = controller.recupererListe();

        ModelAdapter adapter = new ModelAdapter(DisplayFrameList.this, personnes);
        mListView.setAdapter(adapter);
    }

/*
    private List<Personne> genererPersonnes(){
        List<Personne> personnes = new ArrayList<Personne>();
        personnes.add(new Personne("nom", "prenom", Color.BLACK));
        personnes.add(new Personne("nom1", "prenom2", Color.BLUE));
        personnes.add(new Personne("nom2", "prenom3", Color.RED));

        return personnes;
    }
*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_display_frame_list, menu);
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
