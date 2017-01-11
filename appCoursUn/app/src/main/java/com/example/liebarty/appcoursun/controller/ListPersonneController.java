package com.example.liebarty.appcoursun.controller;

import com.example.liebarty.appcoursun.metier.ListPersonne;
import com.example.liebarty.appcoursun.metier.Personne;

import java.util.List;

/**
 * Created by liebarty on 11/01/17.
 */
public class ListPersonneController {

    protected ListPersonne listPersonne;

    public ListPersonneController(){
        listPersonne = new ListPersonne();
    }

    public boolean ajouterPersonne(String nom, String prenom, int color){
        return listPersonne.addPersonne(nom, prenom, color);
    }

    public boolean supprimerPersonne(String nom, String prenom, int color){
        return listPersonne.removePersonne(nom, prenom, color);
    }

    public List<Personne> recupererListe(){
        return listPersonne.getPersonne();
    }

}
