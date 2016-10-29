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
        int type = getItemViewType(position);
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
//        viewHolder.price_prodotto.setText(String.valueOf(product.getPrice()));
        viewHolder.descrizione_prodotto.setText(String.valueOf(product.getDescription()));
//        setBasePropertyValue(viewHolder, product);
//        if (type == TYPE_ASSOCIATED) {
//            if (product.bmProductCode != null && !product.bmProductCode.isEmpty()) {
//                viewHolder.associated_with.setText("Associato con prodotto " + product.bmProductCode);
//            } else {
//                viewHolder.associated_with.setText("");
//            }
//
//            if (product.bmName != null && !product.bmName.isEmpty()) {
//                viewHolder.associated_name.setText(product.bmName);
//            } else {
//                viewHolder.associated_name.setText("");
//            }
//        }
        return convertView;
    }

//    private void setBasePropertyValue(ViewHolder viewHolder, LMProduct lmProduct) {
//        viewHolder.referenza_prodotto.setText(String.valueOf(lmProduct._id));
//        viewHolder.titoloweb_prodotto.setText(String.valueOf(lmProduct.titoloWeb));
//        viewHolder.nome_prodotto.setText(String.valueOf(lmProduct.descrizioneCommerciale));
//        if (lmProduct.urlImmagine != null && !lmProduct.urlImmagine.equals("")) {
//            Picasso.with(context).load(lmProduct.urlImmagine + "/75/75/PNG").into(viewHolder.productImage);
//        }
//    }
//
//    private void setAssociatesViewholderProperties(View convertView, ViewHolder viewHolder) {
//        viewHolder.associated_with = (TextView) convertView.findViewById(R.id.associated_with);
//        viewHolder.associated_name = (TextView) convertView.findViewById(R.id.associated_name);
//    }
//
    private void setBaseViewholderProperties(View convertView, ViewHolder viewHolder) {
        viewHolder.titolo_prodotto = (TextView) convertView.findViewById(R.id.titolo_prodotto);
        viewHolder.descrizione_prodotto = (TextView) convertView.findViewById(R.id.descrizione_prodotto);
        viewHolder.nome_prodotto = (TextView) convertView.findViewById(R.id.nome_prodotto);
    }


    static class ViewHolder {
        public TextView nome_prodotto;
        public TextView titolo_prodotto;
        public TextView descrizione_prodotto;
//        public TextView price_prodotto;

//        public ImageView productImage;
//        public TextView associated_with;
//        public TextView associated_name;

    }
}
