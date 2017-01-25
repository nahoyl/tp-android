package com.example.liebarty.tpfinal.adapter;

        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.ImageView;
        import android.widget.TextView;

        import com.example.liebarty.tpfinal.R;
        import com.example.liebarty.tpfinal.metier.ItemImage;

        import java.util.List;

/**
 * Created by liebarty on 04/01/17.
 */
public class ModelAdapter extends ArrayAdapter<ItemImage> {

    //protected LayoutInflater _layoutInflater;
    //protected Context _context;

    public ModelAdapter(Context context, List<ItemImage> liste){
        super(context, 0 , liste);
        //_context = context;
        //_layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_liste, null);
        }

        PersonneViewHolder viewHolder = (PersonneViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new PersonneViewHolder();
            viewHolder.itemImage = (ImageView)convertView.findViewById(R.id.imageImage);
            viewHolder.itemDescription = (TextView)convertView.findViewById(R.id.descriptionImage);
            viewHolder.itemNom = (TextView)convertView.findViewById(R.id.nomImage);
            convertView.setTag(viewHolder);
        }

        ItemImage itemImage = getItem(position);

        viewHolder.itemNom.setText(itemImage.getNom());
        viewHolder.itemDescription.setText(itemImage.getDescription());
        viewHolder.itemImage.setImageBitmap(itemImage.getImage());

        return convertView;

    }

    private class PersonneViewHolder{
        public TextView itemDescription;
        public TextView itemNom;
        public ImageView itemImage;
    }
}
