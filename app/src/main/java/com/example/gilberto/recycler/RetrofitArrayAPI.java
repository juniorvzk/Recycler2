package com.example.gilberto.recycler;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by gilberto on 30/12/2016.
 */

public interface RetrofitArrayAPI {

    @GET("api/RetrofitAndroidArrayResponse")
    Call<List<ItemModel>> getJsonModel();

}
