package com.example.liebarty.tpfinal.metier;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.InputStream;

/**
 * Created by liebarty on 25/01/17.
 */
public class ItemImage {
    private String _nom;
    private String _description;
    private Bitmap _image;

    public ItemImage(String nom, String description, InputStream inputStream){
        _nom = nom;
        _description = description;
        _image = BitmapFactory.decodeStream(inputStream);

    }

    public String getNom(){
        return _nom;
    }

    public String getDescription(){
        return _description;
    }

    public Bitmap getImage(){
        return _image;
    }

}
