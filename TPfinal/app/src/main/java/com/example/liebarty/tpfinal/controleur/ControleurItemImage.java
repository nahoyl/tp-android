package com.example.liebarty.tpfinal.controleur;

import android.content.Context;

import com.example.liebarty.tpfinal.ItemImage.ItemImage;
import com.example.liebarty.tpfinal.ItemImage.ListeItemImage;

import java.io.InputStream;
import java.util.List;

/**
 * Created by liebarty on 25/01/17.
 */
public class ControleurItemImage {
    protected ListeItemImage listeItemImage;
    protected Context context;

    public ControleurItemImage(Context context){
        this.context = context;
        listeItemImage = new ListeItemImage();

    }

    public boolean ajouterItemImage(String nom, String description, InputStream photo){
        return listeItemImage.addItemImage(nom, description, photo);
    }


    public boolean ajouterTousItemImage(List<ItemImage> itemImageList){
        return listeItemImage.addAllItemImage(itemImageList);
    }

    public boolean supprimerItemImage(String nom, String description, InputStream photo){
        return listeItemImage.removeItemImage(nom, description, photo);
    }

    public List<ItemImage> recupererListe(){
        return listeItemImage.getItemImage();
    }

}
