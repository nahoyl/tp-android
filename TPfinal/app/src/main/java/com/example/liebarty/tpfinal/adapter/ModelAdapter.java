package com.example.liebarty.tpfinal.adapter;

        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.ImageView;
        import android.widget.TextView;

        import com.example.liebarty.tpfinal.R;
        import com.example.liebarty.tpfinal.ItemImage.Image;

        import java.util.List;

/**
 * Created by liebarty on 04/01/17.
 */
public class ModelAdapter extends ArrayAdapter<Image> {

    //protected LayoutInflater _layoutInflater;
    //protected Context _context;

    public ModelAdapter(Context context, List<Image> liste){
        super(context, 0 , liste);
        //_context = _context;
        //_layoutInflater = LayoutInflater.from(_context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_liste, null);
        }

        ItemImageViewHolder viewHolder = (ItemImageViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new ItemImageViewHolder();
            viewHolder.itemImage = (ImageView)convertView.findViewById(R.id.imageImage);
            viewHolder.itemDescription = (TextView)convertView.findViewById(R.id.descriptionImage);
            viewHolder.itemNom = (TextView)convertView.findViewById(R.id.nomImage);
            convertView.setTag(viewHolder);
        }

        Image image = getItem(position);

        viewHolder.itemNom.setText(image.getNom());
        viewHolder.itemDescription.setText(image.getDescription());
        //Convertir to bitmap
        viewHolder.itemImage.setImageBitmap(image.getUrl());

        return convertView;

    }

    private class ItemImageViewHolder {
        public TextView itemDescription;
        public TextView itemNom;
        public ImageView itemImage;
    }
}
