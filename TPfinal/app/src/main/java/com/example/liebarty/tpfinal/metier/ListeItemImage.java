package com.example.liebarty.tpfinal.metier;

/**
 * Created by liebarty on 25/01/17.
 */

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ListeItemImage {
    private List<ItemImage> liste;

    public ListeItemImage(){
        this.liste = new ArrayList<ItemImage>();
    }

    public ListeItemImage(List<ItemImage> liste_p){
        liste = liste_p;
    }

    public boolean addItemImage(String nom, String description, InputStream photo){
        ItemImage p = new ItemImage(nom, description, photo);
        return liste.add(p);
    }

    public boolean removeItemImage(String nom, String description, InputStream photo){
        ItemImage p = new ItemImage(nom, description, photo);
        return liste.remove(p);
    }

    public List<ItemImage> getItemImage(){
        return liste;
    }

}
