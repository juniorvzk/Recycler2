package com.example.gilberto.recycler;

import android.graphics.Bitmap;

/**
 * Created by gilberto on 29/12/2016.
 */

public class ItemModel {

    private ProfileModel profile;
    private Bitmap image;
    private String meal;
    private String date;
    private String energy;


    public ProfileModel getProfile() {
        return profile;
    }

    public void setProfile(ProfileModel profile) {
        this.profile = profile;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEnergy() {
        return energy;
    }

    public void setEnergy(String energy) {
        this.energy = energy;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

}
