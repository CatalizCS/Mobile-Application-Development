package com.tama.android.Model;

import java.util.ArrayList;

public class StorageManagement {
    public static int count = 0;
    private ArrayList<StorageModel> listStorage;

    public StorageManagement(ArrayList<StorageModel> listStorage) {
        this.listStorage = listStorage;
    }

    public void addStorage(StorageModel storage) {
        count++;
        storage.setId(count);
        listStorage.add(storage);
    }

    public void removeStorage(int storageId) {
        for (int index = 0; index < listStorage.size(); index++) {
            StorageModel storage = listStorage.get(index);

            if (storage.getId() == storageId) {
                listStorage.remove(index);
            }
        }
    }

    public void editStorage(StorageModel newStorage) {
        for (int index = 0; index < listStorage.size(); index++) {
            StorageModel currentStorage = listStorage.get(index);

            if (currentStorage.getId() == newStorage.getId())
                listStorage.set(index, newStorage);
        }
    }

    public StorageModel getStorage(int storageId) {
        for (int index = 0; index < listStorage.size(); index++) {
            StorageModel currentStorage = listStorage.get(index);

            if (currentStorage.getId() == storageId)
                return currentStorage;
        }

        // Not found
        return null;
    }

    public ArrayList<StorageModel> getStorages() {
        return this.listStorage;
    }
}
