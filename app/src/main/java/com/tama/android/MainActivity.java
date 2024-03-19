package com.tama.android;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

//        add some default storage
        StorageModel storageModel1 = new StorageModel("Kho 1", "Hà Nội", "0123456789");
        StorageModel storageModel2 = new StorageModel("Kho 2", "Hà Nội", "0123456789");
        StorageModel storageModel3 = new StorageModel("Kho 3", "Hà Nội", "0123456789");
        storageManagement.addStorage(storageModel1);
        storageManagement.addStorage(storageModel2);
        storageManagement.addStorage(storageModel3);

        btnStorageManagement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StorageActivity.class);
                intent.putExtra("listStorage", listStorage);
                intent.putExtra("listProducts", listProducts);
                startActivity(intent);
            }
        });

        btnProductManagement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProductActivity.class);
                intent.putExtra("listProducts", listProducts);
                intent.putExtra("listStorages", listStorage);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.topbar_layout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.add_storage) {
//            dialog layout add storage
            Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.add_storage_alert_layout);

            EditText storageName = dialog.findViewById(R.id.storage_name_input);
            EditText address = dialog.findViewById(R.id.address_input);
            EditText storagePhone = dialog.findViewById(R.id.phone_input);


            Button addStorage = dialog.findViewById(R.id.btnAddStorage);
            Button cancelStorage = dialog.findViewById(R.id.btnCancel);

            addStorage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (storageName.getText().toString().isEmpty() || address.getText().toString().isEmpty() || storagePhone.getText().toString().isEmpty()) {
                        Toast.makeText(MainActivity.this, "Vui lòng không để trống thông tin", Toast.LENGTH_SHORT).show();
                    }


                    StorageModel storageModel = new StorageModel(storageName.getText().toString(), address.getText().toString(), storagePhone.getText().toString());
                    storageManagement.addStorage(storageModel);

                    Toast.makeText(MainActivity.this, "Thêm kho thành công", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            });

            cancelStorage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });

            dialog.show();
        }

        return super.onOptionsItemSelected(item);
    }
}