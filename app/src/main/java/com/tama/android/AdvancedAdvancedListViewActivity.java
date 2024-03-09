package com.tama.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.tama.android.CustomListView.CustomAdapter;
import com.tama.android.CustomListView.DataModel;

import java.util.ArrayList;
import java.util.List;

    public class AdvancedAdvancedListViewActivity extends AppCompatActivity {

    private List<DataModel> dataModelList;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.advanced_advanced_listview_layout);

        listView = findViewById(R.id.listView);
        dataModelList = new ArrayList<>();
        dataModelList.add(new DataModel( "Item 1"));
        dataModelList.add(new DataModel( "Item 2"));
        dataModelList.add(new DataModel( "Item 3"));
        dataModelList.add(new DataModel( "Item 4"));
        dataModelList.add(new DataModel( "Item 5"));

        CustomAdapter adapter = new CustomAdapter(this, dataModelList);
        listView.setAdapter(adapter);
    }
}