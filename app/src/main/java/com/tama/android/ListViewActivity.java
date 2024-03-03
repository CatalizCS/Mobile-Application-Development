package com.tama.android;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class ListViewActivity extends AppCompatActivity {

    private ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_layout);

        arrayList = new ArrayList<>();
        String[] stringArray = getResources().getStringArray(R.array.countries_array);
        arrayList.addAll(Arrays.asList(stringArray));

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

//        set onClick listener for each item in list view
        listView.setOnItemClickListener((parent, view, position, id) -> {
            String itemValue = (String) listView.getItemAtPosition(position);
            Toast.makeText(getApplicationContext(), "Position: " + position + " Item Clicked: " + itemValue, Toast.LENGTH_SHORT).show();
        });
    }
}