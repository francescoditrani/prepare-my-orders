package com.droidconuk.frasam.preparemyorders.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.droidconuk.frasam.preparemyorders.R;
import com.droidconuk.frasam.preparemyorders.model.Product;
//import com.squareup.picasso.Picasso;

import java.util.List;



/**
 * Created by fditrani on 25/04/15.
 */
public class ProductListAdapter extends ArrayAdapter<Product> {

    final List<Product> products;
    Context context;

    public ProductListAdapter(Context context, List<Product> objects) {
        super(context, R.layout.product_item, objects);
        this.context = context;
        this.products = objects;
    }


    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Product getItem(int position) {
        return products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.product_item, null);
            setBaseViewholderProperties(convertView, viewHolder);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Product product = products.get(position);
        viewHolder.nome_prodotto.setText(String.valueOf(product.getName()));
        viewHolder.titolo_prodotto.setText(String.valueOf(product.getTitle()));
        viewHolder.descrizione_prodotto.setText(String.valueOf(product.getDescription()));
        viewHolder.textViewPrice.setText(String.valueOf("£"+product.getPrice()));

        return convertView;
    }


    private void setBaseViewholderProperties(View convertView, ViewHolder viewHolder) {
        viewHolder.titolo_prodotto = (TextView) convertView.findViewById(R.id.titolo_prodotto);
        viewHolder.descrizione_prodotto = (TextView) convertView.findViewById(R.id.descrizione_prodotto);
        viewHolder.nome_prodotto = (TextView) convertView.findViewById(R.id.nome_prodotto);
        viewHolder.textViewPrice = (TextView) convertView.findViewById(R.id.textViewPrice);
    }


    static class ViewHolder {
        public TextView nome_prodotto;
        public TextView titolo_prodotto;
        public TextView descrizione_prodotto;
        public TextView textViewPrice;

    }
}
