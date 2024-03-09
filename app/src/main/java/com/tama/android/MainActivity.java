package com.tama.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.tama.android.CustomListView.ListItemAdapter;
import com.tama.android.CustomListView.ListItemModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final List<ListItemModel> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner);
        ListView listView = findViewById(R.id.Lists);

        list.add(new ListItemModel("Điện thoại", "Samsung"));
        list.add(new ListItemModel("Điện thoại", "Iphone"));
        list.add(new ListItemModel("Điện thoại", "Oppo"));
        list.add(new ListItemModel("Điện thoại", "Xiaomi"));

        list.add(new ListItemModel("Máy tính", "Dell"));
        list.add(new ListItemModel("Máy tính", "HP"));
        list.add(new ListItemModel("Máy tính", "Asus"));
        list.add(new ListItemModel("Máy tính", "Lenovo"));

        list.add(new ListItemModel("Máy ảnh", "Canon"));
        list.add(new ListItemModel("Máy ảnh", "Nikon"));
        list.add(new ListItemModel("Máy ảnh", "Sony"));

        ListItemAdapter listAdapter = new ListItemAdapter(this, list);
        listView.setAdapter(listAdapter);

        List<String> typeList = new ArrayList<>();
        for (ListItemModel item : list) {
            if (!typeList.contains(item.getType())) {
                typeList.add(item.getType());
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, typeList);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                filterList(typeList.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void filterList(String type) {
        List<ListItemModel> filterList = new ArrayList<>();
        for (ListItemModel item : list) {
            if (item.getType().equals(type)) {
                filterList.add(item);
            }
        }
        ListItemAdapter listAdapter = new ListItemAdapter(this, filterList);
        ListView listView = findViewById(R.id.Lists);
        listView.setAdapter(listAdapter);

    }
}