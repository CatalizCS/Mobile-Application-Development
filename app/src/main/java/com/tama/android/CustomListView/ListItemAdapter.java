package com.tama.android.CustomListView;

import android.util.Log;
import android.view.View;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tama.android.R;

import java.util.List;

public class ListItemAdapter extends BaseAdapter {
    private Context context;
    private List<ListItemModel> list;
    private int possitionSelected = -1;

    public ListItemAdapter(Context context, List<ListItemModel> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public int getCount() {
         if (list != null) {
             return list.size();
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
           convertView = View.inflate(context, R.layout.listview_layout, null);
       }

        ImageView imageView = convertView.findViewById(R.id.iconList);
        TextView textView = convertView.findViewById(R.id.textList);

        ListItemModel listItemModel = list.get(position);

        if (listItemModel.getTitle().length() <= 3) {
            imageView.setImageResource(android.R.drawable.star_on);
        } else {
            imageView.setImageResource(android.R.drawable.ic_dialog_map);
        }

        Log.i("ListItemAdapter", "getView: " + listItemModel.getTitle());

        textView.setText(listItemModel.getTitle());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Item selected: " + position, Toast.LENGTH_SHORT).show();
                possitionSelected = position;
                notifyDataSetChanged();
            }
        });

        return convertView;
    }
}
