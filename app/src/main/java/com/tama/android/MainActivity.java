package com.tama.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tama.android.Model.ProductManagement;
import com.tama.android.Model.ProductModel;
import com.tama.android.Model.StorageManagement;
import com.tama.android.Model.StorageModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<StorageModel> listStorage;
    private ArrayList<ProductModel> listProducts;
    private ProductManagement productManagement;
    private StorageManagement storageManagement;

    private Button btnStorageManagement;
    private Button btnProductManagement;
    private Button btnViewProduct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        listStorage = new ArrayList<>();
        listProducts = new ArrayList<>();
        productManagement = new ProductManagement(listProducts);
        storageManagement = new StorageManagement(listStorage);

        btnStorageManagement = (Button) findViewById(R.id.btnStorageManagement);
        btnProductManagement = (Button) findViewById(R.id.btnProductManagement);
        btnViewProduct = (Button) findViewById(R.id.btnViewProduct);

        btnViewProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProductActivity.class);
                intent.putExtra("listProducts", listProducts);
                startActivity(intent);
            }
        });

    }
}