package com.example.liebarty.tpfinal.ItemImage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.InputStream;

/**
 * Created by liebarty on 25/01/17.
 */
public class Image {
    private String _nom;
    private String _description;
    private Bitmap _url;

    public Image(String nom, String description, InputStream url){
        _nom = nom;
        _description = description;
        _url = BitmapFactory.decodeStream(url);

    }

    public String getNom(){
        return _nom;
    }

    public String getDescription(){
        return _description;
    }

    public Bitmap getUrl(){
        return _url;
    }

}
