package com.example.liebarty.appcoursun.metier;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liebarty on 11/01/17.
 */
public class ListPersonne {
    private List<Personne> liste;

    public ListPersonne(){
        this.liste = new ArrayList<Personne>();
    }

    public ListPersonne(List<Personne> liste_p){
        liste = liste_p;
    }

    public boolean addPersonne(String nom, String prenom, int color){
        Personne p = new Personne(nom, prenom, color);
        return liste.add(p);
    }

    public boolean removePersonne(String nom, String prenom, int color){
        Personne p = new Personne(nom, prenom, color);
        return liste.remove(p);
    }

    public List<Personne> getPersonne(){
        return liste;
    }

}
