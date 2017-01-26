package com.example.liebarty.tpfinal.ItemImage;

/**
 * Created by liebarty on 25/01/17.
 */

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Categorie {
    private List<Image> _liste;
    private String _nomCat;

    public Categorie(){
        this._liste = new ArrayList<Image>();
    }

    public Categorie(List<Image> liste_p){
        _liste = liste_p;
    }

    public boolean addImage(String nom, String description, InputStream url){
        Image p = new Image(nom, description, url);
        return _liste.add(p);
    }

    public boolean addAllImage(List<Image> imageList){
        return _liste.addAll(imageList);
    }

    public boolean removeImage(String nom, String description, InputStream url){
        Image p = new Image(nom, description, url);
        return _liste.remove(p);
    }

    public List<Image>getItemImage(){
        return _liste;
    }

}
