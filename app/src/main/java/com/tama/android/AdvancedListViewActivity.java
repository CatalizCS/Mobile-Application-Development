package com.tama.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class AdvancedListViewActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.advanced_listview_layout);

        arrayList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);

        // Set the adapter to the listview
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            String itemValue = (String) listView.getItemAtPosition(position);
            // Display the item value in a toast
            android.widget.Toast.makeText(getApplicationContext(), "Position: " + position + " Item Clicked: " + itemValue, android.widget.Toast.LENGTH_SHORT).show();
        });

        findViewById(R.id.btnSubmit).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnSubmit) {
//            get the data from the edittext and display it in the listview
            EditText etName = findViewById(R.id.usernameInput);
            String name = etName.getText().toString();

            if (!name.isEmpty()) {
                arrayList.add(name);
                adapter.notifyDataSetChanged();
                etName.setText("");
            }
        }
    }
}