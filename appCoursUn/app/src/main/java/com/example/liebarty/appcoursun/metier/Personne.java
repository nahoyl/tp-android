package com.example.liebarty.appcoursun.metier;

/**
 * Created by liebarty on 11/01/17.
 */
public class Personne {
    private String prenom;
    private String nom;
    private int color;

    public Personne(String nom, String prenom, int color){
        this.nom = nom;
        this.prenom = prenom;
        this.color = color;
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

    public int getColor() {
        return color;
    }

    public void setColor(int color){
        this.color = color;
    }
}
