package com.example.gilberto.recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by gilberto on 29/12/2016.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    public static ClickRecyclerView_Interface clickRecyclerViewInterface;
    Context mctx;
    private List<ItemModel> apiList;

    public RecyclerAdapter(Context ctx, List<ItemModel> list, ClickRecyclerView_Interface clickRecyclerViewInterface) {
        this.mctx = ctx;
        this.apiList = list;
        this.clickRecyclerViewInterface = clickRecyclerViewInterface;
    }



    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        return new RecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.RecyclerViewHolder holder, int position) {
        ItemModel item = apiList.get(position);

        System.out.println("Oi?");
        System.out.println(item.getProfile().getName());

//        holder.profilePic.setImageBitmap(pessoa.getProfile().getImage());
//        holder.dishPic.setImageBitmap(pessoa.getImage());


        holder.textNome.setText(item.getProfile().getName());
        holder.textObj.setText(item.getProfile().getGeneral_goal());
        holder.textData.setText(item.getDate());
        holder.textEnergy.setText(String.valueOf(item.getEnergy()));


    }

    @Override
    public int getItemCount() {
        return apiList.size();
    }





    protected class RecyclerViewHolder extends RecyclerView.ViewHolder {

        protected TextView textNome;
        protected ImageView imgProfile;
        protected TextView textObj;
        protected ImageView dishPic;
        protected TextView textData;
        protected TextView textEnergy;
        protected TextView textMeal;

        public RecyclerViewHolder(final View itemView) {
            super(itemView);

            imgProfile = (ImageView) itemView.findViewById(R.id.profilePic);
            textNome = (TextView) itemView.findViewById(R.id.textNome);
            textObj = (TextView) itemView.findViewById(R.id.textObj);

            dishPic = (ImageView) itemView.findViewById(R.id.dishPic);
            textMeal = (TextView) itemView.findViewById(R.id.textMeal);
            textData = (TextView) itemView.findViewById(R.id.textData);
            textEnergy = (TextView) itemView.findViewById(R.id.textCalorias);


            //Setup the click listener
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    clickRecyclerViewInterface.onCustomClick(apiList.get(getLayoutPosition()));

                }
            });
        }
    }


}
