package com.tama.android.Model;

import java.io.Serializable;

public class StorageModel implements Serializable {
    private int id;
    private String name;
    private String Address;
    private String phone;

    public StorageModel(String name, String Address, String phone) {
        this.name = name;
        this.Address = Address;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "[" + getId() + " - "  + getName() + " - " + getAddress() + " - " + getPhone() + "]";
    }
}
