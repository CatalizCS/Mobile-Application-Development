package com.tama.android.Model;

import java.io.Serializable;

public class ProductModel {
    private int id;
    private int storageId;
    private String name;
    private int amount;
    private Double SellPrice;
    private Double BuyPrice;

    public ProductModel(int storageId, String name, int amount, Double sellPrice, Double buyPrice) {
        this.storageId = storageId;
        this.name = name;
        this.amount = amount;
        SellPrice = sellPrice;
        BuyPrice = buyPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStorageId() {
        return storageId;
    }

    public void setStorageId(int storageId) {
        this.storageId = storageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Double getSellPrice() {
        return SellPrice;
    }

    public void setSellPrice(Double sellPrice) {
        SellPrice = sellPrice;
    }

    public Double getBuyPrice() {
        return BuyPrice;
    }

    public void setBuyPrice(Double buyPrice) {
        BuyPrice = buyPrice;
    }

    @Override
    public String toString() {
        return "[" + getName() + " - " + getAmount() + " - " + getSellPrice() + " - " + getBuyPrice() + "]";
    }

}
