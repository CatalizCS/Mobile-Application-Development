package com.tama.android.CustomListView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tama.android.CustomListView.DataModel;
import com.tama.android.R;

import java.util.List;

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private List<DataModel> dataModelList;
    private int possitionSelect = -1;

    public CustomAdapter(Context context, List<DataModel> dataModelList) {
        this.context = context;
        this.dataModelList = dataModelList;
    }


    @Override
    public int getCount() {
        if (dataModelList != null) {
            return dataModelList.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.row_items, null);
        }

        ImageView imageView = convertView.findViewById(R.id.icon);
        TextView textView = convertView.findViewById(R.id.text);
        DataModel dataModel = dataModelList.get(position);
        imageView.setImageResource(dataModel.getIcon());
        textView.setText(dataModel.getText());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Position: " + position + " Item Clicked: " + dataModel.getText(), Toast.LENGTH_SHORT).show();
                possitionSelect = position;
                notifyDataSetChanged();
            }
        });

        return convertView;
    }
}