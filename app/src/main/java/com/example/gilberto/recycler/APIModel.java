package com.example.gilberto.recycler;

/**
 * Created by gilberto on 30/12/2016.
 */

public class APIModel {

    boolean success;
    int t;
    int p;
    ItemModel items;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }

    public ItemModel getItems() {
        return items;
    }

    public void setItems(ItemModel items) {
        this.items = items;
    }
}
