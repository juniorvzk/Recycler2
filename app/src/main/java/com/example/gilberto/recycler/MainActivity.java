package com.example.gilberto.recycler;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity implements ClickRecyclerView_Interface {


    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    RecyclerAdapter adapter;
    private List<APIModel> apiList = new ArrayList<>();
    private List<ItemModel> itemList = new ArrayList<>();
    private APIModel apiModel;
    private FloatingActionButton floatingActionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRecyclerView();

        setButtons();
        listenersButtons();

    }

    public void setRecyclerView() {

        //Aqui é instanciado o Recyclerview
        mRecyclerView = (RecyclerView) findViewById(R.id.myRView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        adapter = new RecyclerAdapter(this,itemList, this);
        mRecyclerView.setAdapter(adapter);


    }

    @Override
    public void onCustomClick(Object object) {

    }

    public void setButtons() {

        floatingActionButton = (FloatingActionButton) findViewById(R.id.myFButton);

    }

    String myAPI = "http://api.tecnonutri.com.br/api/v4/";

    public void getRetrofitObject() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(myAPI)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitObjectAPI service = retrofit.create(RetrofitObjectAPI.class);

        Call<APIModel> call = service.getAPIModel();


        call.enqueue(new Callback<APIModel>() {
            @Override
            public void onResponse(Response<APIModel> response, Retrofit retrofit) {

                //apiModel = response.body();
               // apiList = response.body();

                itemList.add(response.body().getItems());

                if(response.body()!= null){
                    System.out.println("body not null");
                }
                else{
                    System.out.println("null");
                }

//                apiModelList.add(response.body());

                //itemModelList.add(response.body().getItems());
                //System.out.println(response.body().getItems().getProfile().getName());

            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("onFailure", t.toString());
            }
        });
    }

    public void getRetrofitArray() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(myAPI)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitArrayAPI service = retrofit.create(RetrofitArrayAPI.class);

        Call<List<ItemModel>> call = service.getJsonModel();

        call.enqueue(new Callback<List<ItemModel>>() {
            @Override
            public void onResponse(Response<List<ItemModel>> response, Retrofit retrofit) {

                try {

                    List<ItemModel> StudentData = response.body();
/*
                    for (int i = 0; i < StudentData.size(); i++) {

                        if (i == 0) {
                            text_id_1.setText("StudentId  :  " + StudentData.get(i).getStudentId());
                            text_name_1.setText("StudentName  :  " + StudentData.get(i).getStudentName());
                            text_marks_1.setText("StudentMarks  : " + StudentData.get(i).getStudentMarks());
                        } else if (i == 1) {
                            text_id_2.setText("StudentId  :  " + StudentData.get(i).getStudentId());
                            text_name_2.setText("StudentName  :  " + StudentData.get(i).getStudentName());
                            text_marks_2.setText("StudentMarks  : " + StudentData.get(i).getStudentMarks());
                        }
                    }
*/

                } catch (Exception e) {
                    Log.d("onResponse", "There is an error");
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("onFailure", t.toString());
            }
        });
    }




    public void listenersButtons() {

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getRetrofitObject();
                adapter.notifyDataSetChanged();

                // Cria uma nova pessoa chamada Renan Teles
/*                ItemModel myItem = new ItemModel();



                ProfileModel profile = new ProfileModel();
                profile.setName("Joyce Pereira");
                profile.setGeneral_goal("Perder peso");

                pessoa1.setDate("2016-12-29");
                pessoa1.setEnergy("191");

//                pessoa1.setMeal(3);
//                profile.setImage(pessoa1.getBitmapFromURL("https://tnapp.blob.core.windows.net/profiles/3274588.jpg"));


//                pessoa1.setProfile(profile);
//                pessoa1.setImage(pessoa1.getBitmapFromURL("https://tnapp.blob.core.windows.net/meals/3274588-2016-12-29-3.jpg"));


                //Adiciona a pessoa1 e avisa o adapter que o conteúdo
                //da lista foi alterado
//                itemModelList.add(pessoa1);
*/


            }


        });
    }

}
