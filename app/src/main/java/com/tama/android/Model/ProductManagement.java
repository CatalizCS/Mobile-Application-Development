package com.tama.android.Model;

import java.util.ArrayList;

public class ProductManagement {
    public static int count = 0;
    private ArrayList<ProductModel> listProducts;


    public ProductManagement(ArrayList<ProductModel> listProducts) {
        this.listProducts = listProducts;
    }

    public void addProduct(ProductModel product) {
        count++;
        product.setId(count);
        listProducts.add(product);
    }

    public void removeProduct(int productId) {
        for (int index = 0; index < listProducts.size(); index++) {
            ProductModel product = listProducts.get(index);

            if (product.getId() == productId) {
                listProducts.remove(index);
            }
        }
    }

    public void editProduct(ProductModel newProduct) {
        for (int index = 0; index < listProducts.size(); index++) {
            ProductModel currentProduct = listProducts.get(index);

            if (currentProduct.getId() == newProduct.getId())
                listProducts.set(index, newProduct);
        }
    }

    public ProductModel getProduct(int productId) {
        for (int index = 0; index < listProducts.size(); index++) {
            ProductModel currentProduct = listProducts.get(index);

            if (currentProduct.getId() == productId)
                return currentProduct;
        }

        // Not found
        return null;
    }

    public void updateProduct(ProductModel productModel) {
        for (int index = 0; index < listProducts.size(); index++) {
            ProductModel currentProduct = listProducts.get(index);

            if (currentProduct.getId() == productModel.getId())
                listProducts.set(index, productModel);
        }
    }

    public ArrayList<ProductModel> getProducts() {
        return this.listProducts;
    }


}
