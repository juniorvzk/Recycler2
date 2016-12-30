package com.example.gilberto.recycler;

import android.graphics.Bitmap;

/**
 * Created by gilberto on 29/12/2016.
 */

public class ProfileModel {

    private String name;
    private Bitmap image;
    private String general_goal;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getGeneral_goal() {
        return general_goal;
    }

    public void setGeneral_goal(String general_goal) {
        this.general_goal = general_goal;
    }
}
