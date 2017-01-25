package com.example.liebarty.appcoursun.adapter;

import android.app.LauncherActivity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.liebarty.appcoursun.R;
import com.example.liebarty.appcoursun.metier.Personne;

import java.util.List;

/**
 * Created by liebarty on 04/01/17.
 */
public class ModelAdapter extends ArrayAdapter<Personne> {

    //protected LayoutInflater _layoutInflater;
    //protected Context _context;

    public ModelAdapter(Context context, List<Personne> liste){
        super(context, 0 , liste);
        //_context = context;
        //_layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_personne, null);
        }

        PersonneViewHolder viewHolder = (PersonneViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new PersonneViewHolder();
            viewHolder.itemPhoto = (ImageView)convertView.findViewById(R.id.avatarItem);
            viewHolder.itemText = (TextView)convertView.findViewById(R.id.textItem);
            viewHolder.itemPseudo = (TextView)convertView.findViewById(R.id.pseudoItem);
            convertView.setTag(viewHolder);
        }

        Personne personne = getItem(position);

        viewHolder.itemPseudo.setText(personne.getNom());
        viewHolder.itemText.setText(personne.getPrenom());
        viewHolder.itemPhoto.setImageDrawable(new ColorDrawable(personne.getColor()));

        return convertView;

    }

    private class PersonneViewHolder{
        public TextView itemText;
        public TextView itemPseudo;
        public ImageView itemPhoto;
    }
}
