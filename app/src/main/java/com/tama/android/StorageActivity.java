package com.tama.android;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.tama.android.Adapter.StorageAdapter;
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
        setContentView(R.layout.storage_management_layout);

        Intent intent = getIntent();
        listStorage = (ArrayList<StorageModel>) intent.getSerializableExtra("listStorage");        storageManagement = new StorageManagement(listStorage);

        ListView lvStorage = (ListView) findViewById(R.id.lvStorage);
        StorageAdapter storageAdapter = new StorageAdapter(this, listStorage);

        lvStorage.setAdapter(storageAdapter);

        lvStorage.setOnItemClickListener((parent, view, position, id) -> {
            final Dialog dialog = new Dialog(StorageActivity.this);
            dialog.setContentView(R.layout.update_storage_alert_layout);
            dialog.setTitle("Update Storage");

            final TextView storageId = (TextView) dialog.findViewById(R.id.storage_id_input);
            final EditText storageName = (EditText) dialog.findViewById(R.id.storage_name_input);
            final EditText storageAddress = (EditText) dialog.findViewById(R.id.address_input);
            final EditText storagePhone = (EditText) dialog.findViewById(R.id.phone_input);

            storageId.setText(String.valueOf(listStorage.get(position).getId()));
            storageName.setText(listStorage.get(position).getName());
            storageAddress.setText(listStorage.get(position).getAddress());
            storagePhone.setText(listStorage.get(position).getPhone());

            updateStorage = (Button) dialog.findViewById(R.id.btnUpdateStorage);
            cancelStorage = (Button) dialog.findViewById(R.id.btnCancel);

            updateStorage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name = storageName.getText().toString();
                    String address = storageAddress.getText().toString();
                    String phone = storagePhone.getText().toString();

                    StorageModel storageModel = new StorageModel(name, address, phone);
                    storageModel.setId(Integer.parseInt(storageId.getText().toString()));
                    storageManagement.updateStorage(position, storageModel);
                    storageAdapter.notifyDataSetChanged();
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

        });
    }
}
