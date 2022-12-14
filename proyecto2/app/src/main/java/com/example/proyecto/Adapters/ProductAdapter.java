package com.example.proyecto.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.proyecto.Entities.Product;
import com.example.proyecto.R;

import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Product> arrayProduct;

    public ProductAdapter(Context context, ArrayList<Product> arrayProduct) {
        this.context = context;
        this.arrayProduct = arrayProduct;
    }

    @Override
    public int getCount() {
        return arrayProduct.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayProduct.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        //referenciar el template de producto
        view = layoutInflater.inflate(R.layout.product_template, null);

        ImageView imgProduct = (ImageView) view.findViewById(R.id.imgProduct);
        TextView tvName = (TextView) view.findViewById(R.id.tvName);
        TextView tvDescription = (TextView) view.findViewById(R.id.tvDescription);
        TextView tvPrice = (TextView) view.findViewById(R.id.tvPrice);

        Product product = arrayProduct.get(i);
        imgProduct.setImageResource(product.getImage());
        tvName.setText(product.getName());
        tvDescription.setText(product.getDescription());
        //convirtiendo de int a String
        tvPrice.setText(String.valueOf(product.getPrice()));


        return view;
    }
}
