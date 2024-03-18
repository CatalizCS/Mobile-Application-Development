package com.tama.android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.tama.android.Model.ProductManagement;
import com.tama.android.Model.ProductModel;
import com.tama.android.Model.StorageManagement;
import com.tama.android.Model.StorageModel;

import java.util.ArrayList;

public class StorageActivity extends AppCompatActivity {
    private ArrayList<StorageModel> listStorage;
    private StorageManagement storageManagement;
    private Button updateStorage;
    private Button cancelStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.storage_management_layout);
//
//        listStorage = new ArrayList<>();
//        storageManagement = new StorageManagement(listStorage);
//
//        updateStorage = (Button) findViewById(R.id.updateStorage);
//        cancelStorage = (Button) findViewById(R.id.cancelStorage);
    }
}
