package com.example.liebarty.tpfinal.thread;

import android.os.AsyncTask;

import com.example.liebarty.tpfinal.RecuperateurPageWeb;

import java.io.InputStream;

/**
 * Created by liebarty on 26/01/17.
 */
public class AsyncRecuperateur extends AsyncTask<String, Void, InputStream>
{

    @Override
    protected InputStream doInBackground(String... params) {

        String urlFichier = params[0];
        RecuperateurPageWeb rpw = new RecuperateurPageWeb(urlFichier);
        InputStream resultat;
        if(rpw.estConnecte())
            resultat = rpw.getInputStream();
        else resultat = null;
        return resultat;
    }
}
