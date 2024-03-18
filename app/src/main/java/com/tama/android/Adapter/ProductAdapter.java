package com.tama.android.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.tama.android.Model.ProductModel;
import com.tama.android.R;

import java.util.ArrayList;

public class ProductAdapter extends ArrayAdapter<ProductModel> {

    public ProductAdapter(@NonNull Context context, ArrayList<ProductModel> resource) {
        super(context, 0, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ProductModel productModel = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.product_listview_layout, parent, false);
        }

        TextView lvID = convertView.findViewById(R.id.lvID);
        TextView lvName = convertView.findViewById(R.id.lvName);

        if (productModel != null) {
            lvID.setText(String.valueOf(productModel.getId()));
            lvName.setText(productModel.getName());
        }

        return convertView;
    }
}
