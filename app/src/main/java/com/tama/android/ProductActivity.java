package com.tama.android;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.tama.android.Adapter.ProductAdapter;
import com.tama.android.Model.ProductManagement;
import com.tama.android.Model.ProductModel;
import com.tama.android.Model.StorageModel;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {
    private ArrayList<ProductModel> listProducts;
    private ArrayList<StorageModel> listStorage;
    private ProductAdapter productAdapter;
    private ProductManagement productManagement;
    private ListView lvProduct;
    private Button btnAddProduct;
    private EditText productName, productAmount, productSellPrice, productBuyPrice;

    private Spinner spinnerStorage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_management_layout);

        lvProduct = (ListView) findViewById(R.id.lvProduct);
        btnAddProduct = (Button) findViewById(R.id.btnAddProduct);

        productName = (EditText) findViewById(R.id.etProductName);
        productAmount = (EditText) findViewById(R.id.etQuantity);
        productSellPrice = (EditText) findViewById(R.id.etSellPrice);
        productBuyPrice = (EditText) findViewById(R.id.etBuyPrice);

        spinnerStorage = (Spinner) findViewById(R.id.spinnerStorage);

        Intent intent = getIntent();
        listProducts = (ArrayList<ProductModel>) intent.getSerializableExtra("listProducts");
        listStorage = (ArrayList<StorageModel>) intent.getSerializableExtra("listStorages");

        if (listStorage != null) {
            ArrayAdapter<StorageModel> storageAdapter = new ArrayAdapter<StorageModel>(ProductActivity.this, android.R.layout.simple_spinner_item, listStorage);
            storageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerStorage.setAdapter(storageAdapter);
        }

        if (listProducts != null) {
            productManagement = new ProductManagement(listProducts);
            lvProduct = (ListView) findViewById(R.id.lvProduct);
            productAdapter = new ProductAdapter(ProductActivity.this, listProducts);
            lvProduct.setAdapter(productAdapter);

            lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    ProductModel selectedProduct = (ProductModel) parent.getItemAtPosition(position);
                    LayoutInflater li = LayoutInflater.from(ProductActivity.this);
                    View promptsView = li.inflate(R.layout.update_product_alert_layout, null);

                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ProductActivity.this);
                    alertDialogBuilder.setView(promptsView);

                    AlertDialog alertDialog = alertDialogBuilder.create();

                    TextView productID = promptsView.findViewById(R.id.product_id_input);
                    EditText productName = promptsView.findViewById(R.id.product_name_input);
                    EditText productAmount = promptsView.findViewById(R.id.product_amount_input);
                    EditText productSellPrice = promptsView.findViewById(R.id.sellPrice_input);
                    EditText productBuyPrice = promptsView.findViewById(R.id.buyPrice_input);

                    Button updateProduct = promptsView.findViewById(R.id.btnUpdateProduct);
                    Button cancelProduct = promptsView.findViewById(R.id.btnCancelProduct);

                    productID.setText(String.valueOf(selectedProduct.getId()));
                    productName.setText(selectedProduct.getName());
                    productAmount.setText(String.valueOf(selectedProduct.getAmount()));
                    productSellPrice.setText(String.valueOf(selectedProduct.getSellPrice()));
                    productBuyPrice.setText(String.valueOf(selectedProduct.getBuyPrice()));

                    cancelProduct.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            productID.setText("");
                            productName.setText("");
                            productAmount.setText("");
                            productSellPrice.setText("");
                            productBuyPrice.setText("");
                        }
                    });

                    updateProduct.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int id = Integer.parseInt(productID.getText().toString());
                            String name = productName.getText().toString();
                            int amount = Integer.parseInt(productAmount.getText().toString());
                            double sellPrice = Double.parseDouble(productSellPrice.getText().toString());
                            double buyPrice = Double.parseDouble(productBuyPrice.getText().toString());

                            ProductModel productModel = new ProductModel(id, name, amount, sellPrice, buyPrice);
                            productManagement.editProduct(productModel);
                            productAdapter.notifyDataSetChanged();

                            alertDialog.dismiss();

                            Toast.makeText(ProductActivity.this, "Cập nhật sản phẩm thành công", Toast.LENGTH_SHORT).show();
                        }
                    });

                    alertDialog.show();
                }
            });

            lvProduct.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                    ProductModel selectedProduct = (ProductModel) parent.getItemAtPosition(position);
                    productManagement.removeProduct(selectedProduct.getId());
                    productAdapter.notifyDataSetChanged();
                    Toast.makeText(ProductActivity.this, "Xóa sản phẩm thành công", Toast.LENGTH_SHORT).show();
                    return true;
                }
            });
        }

        btnAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = productName.getText().toString();
                int amount = Integer.parseInt(productAmount.getText().toString());
                double sellPrice = Double.parseDouble(productSellPrice.getText().toString());
                double buyPrice = Double.parseDouble(productBuyPrice.getText().toString());

               if (name.isEmpty() || amount == 0 || sellPrice == 0 || buyPrice == 0) {
                    Toast.makeText(ProductActivity.this, "Chưa nhập đủ thông tin sản phẩm", Toast.LENGTH_SHORT).show();
                    return;
                }

                int storageId = 0;
                if (spinnerStorage.getSelectedItem() != null) {
                    storageId = ((StorageModel) spinnerStorage.getSelectedItem()).getId();
                }

                if (storageId == 0) {
                    Toast.makeText(ProductActivity.this, "Chưa chọn kho", Toast.LENGTH_SHORT).show();
                    return;
                }

                ProductModel productModel = new ProductModel(storageId, name, amount, sellPrice, buyPrice);
                productManagement.addProduct(productModel);
                productAdapter.notifyDataSetChanged();

                productName.setText("");
                productAmount.setText("");
                productSellPrice.setText("");
                productBuyPrice.setText("");

                Toast.makeText(ProductActivity.this, "Thêm sản phẩm thành công", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
