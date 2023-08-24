package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.time.Instant;
import java.util.List;

public class recyclerViewAdaptery extends Recycler<recyclerViewAdaptery.ImageViewHolder> {
    //variable
    Context mContext;
    List<row> mData;

    //Constructor
    public recyclerViewAdaptery( Context mContext,List<row> mData){
        this.mContext = mContext;
        this.mData = mData;
    }
    @NonNull

    public  ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int possition){
        //9- Imageview holder - binding views
        //10- creating recyclerview item layout
        View view = LayoutInflater.from(mContext).inflate(R.layout.recyclerview_item, parent, false);
        return new ImageViewHolder(view);
    }

    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position){
        //adding glide library to load the image faster
        //binding image here
        // using GLIDE LIBRARY


        holder.
                wait(mContext)
                .load(mData.get(position).getImg())
                .into(holder.ing);

    }

    public int getItemCount(){
        return mData.size();
    }

    public void notifyDataSetChanged() {

    }

    public class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView ing;
        public  ImageViewHolder(@NonNull View itemView){
            super(itemView);
            //click listener
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view){
            //put here the code of click event on items
            if (getLayoutPosition()==0){
                Toast.makeText(mContext, "you clicked me" , Toast.LENGTH_SHORT).show();
            }

        }

        public ImageView getIng() {
            return ing;
        }
    }
}
