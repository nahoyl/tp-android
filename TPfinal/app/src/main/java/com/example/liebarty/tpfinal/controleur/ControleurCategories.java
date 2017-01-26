package com.example.liebarty.tpfinal.controleur;

import android.content.Context;

import com.example.liebarty.tpfinal.ItemImage.Image;
import com.example.liebarty.tpfinal.ItemImage.Categorie;

import java.io.InputStream;
import java.util.List;

/**
 * Created by liebarty on 25/01/17.
 */
public class ControleurCategories {
    protected Categorie _categorie;
    protected Context _context;

    public ControleurCategories(Context context){
        this._context = context;
        _categorie = new Categorie();

    }

    public boolean ajouterImage(String nom, String description, InputStream url){
        return _categorie.addImage(nom, description, url);
    }


    public boolean ajouterTousImage(List<Image> imageList){
        return _categorie.addAllImage(imageList);
    }

    public boolean supprimerImage(String nom, String description, InputStream url){
        return _categorie.removeImage(nom, description, url);
    }

    public List<Image> recupererListe(){
        return _categorie.getItemImage();
    }

}
