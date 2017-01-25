package com.example.liebarty.tpfinal.controleur;

import android.content.Context;

import com.example.liebarty.tpfinal.metier.ItemImage;
import com.example.liebarty.tpfinal.metier.ListeItemImage;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by liebarty on 25/01/17.
 */
public class ControleurItemImage {
    protected ListeItemImage listeItemImage;
    protected Context context;

    public ControleurItemImage(){
        listeItemImage = new ListeItemImage();
    }

    public ControleurItemImage(Context context, String nom, String description, InputStream photo){
        this.context = context;
        listeItemImage = new ListeItemImage();

    }

    public boolean ajouterPersonne(String nom, String description, InputStream photo){
        return listeItemImage.addItemImage(nom, description, photo);
    }

    public boolean supprimerPersonne(String nom, String description, InputStream photo){
        return listeItemImage.removeItemImage(nom, description, photo);
    }

    public List<ItemImage> recupererListe(){
        return listeItemImage.getItemImage();
    }

}
