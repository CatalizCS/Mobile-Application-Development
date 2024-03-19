package com.tama.android.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.tama.android.Model.StorageModel;
import com.tama.android.R;

import java.util.ArrayList;

public class StorageAdapter extends ArrayAdapter<StorageModel> {


    public StorageAdapter(@NonNull Context context, ArrayList<StorageModel> resource) {
        super(context, 0, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        StorageModel storageModel = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.storage_listview_layout, parent, false);
        }

        TextView lvID = convertView.findViewById(R.id.lvID);
        TextView lvName = convertView.findViewById(R.id.lvName);
        TextView lvPhone = convertView.findViewById(R.id.lvPhone);

        if (storageModel != null) {
            lvID.setText(String.valueOf(storageModel.getId()));
            lvName.setText(storageModel.getName());
            lvPhone.setText(storageModel.getPhone());
        }

        return convertView;
    }
}
