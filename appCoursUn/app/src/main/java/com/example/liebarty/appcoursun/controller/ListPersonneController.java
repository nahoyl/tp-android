package com.example.liebarty.appcoursun.controller;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.liebarty.appcoursun.metier.ListPersonne;
import com.example.liebarty.appcoursun.metier.Personne;

import java.io.IOException;
import java.util.List;

/**
 * Created by liebarty on 11/01/17.
 */
public class ListPersonneController {

    protected ListPersonne listPersonne;
    protected Context context;

    public ListPersonneController(){
        listPersonne = new ListPersonne();
    }

    public ListPersonneController(Context context, String nom, String prenom){
        this.context = context;
        listPersonne = new ListPersonne();
        try {
            String[] listePhoto = context.getAssets().list("mycustomPhoto");
            for(String p : listePhoto){
                //BitmapFactory b = new BitmapFactory();
                //listPersonne.addPersonne(nom, prenom, p);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public boolean ajouterPersonne(String nom, String prenom, Bitmap photo){
        return listPersonne.addPersonne(nom, prenom, photo);
    }

    public boolean supprimerPersonne(String nom, String prenom, Bitmap photo){
        return listPersonne.removePersonne(nom, prenom, photo);
    }

    public List<Personne> recupererListe(){
        return listPersonne.getPersonne();
    }

}
