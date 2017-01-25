package com.example.liebarty.appcoursun.metier;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by liebarty on 11/01/17.
 */
public class Personne {
    private String prenom;
    private String nom;
    private Bitmap photo;


    public Personne(String nom, String prenom, Bitmap photo){
        this.nom = nom;
        this.prenom = prenom;
        this.photo = photo;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Bitmap getPhoto() {
        return photo;
    }

    public void setColor(Bitmap photo){
        this.photo = photo;
    }
}
