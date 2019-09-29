package com.example.gymapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class allActivityAdapter extends RecyclerView.Adapter<allActivityAdapter.ViewHolder> {

    private ArrayList<Activity> list;
    private Context context;

    public allActivityAdapter(ArrayList<Activity> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public allActivityAdapter() {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_layoutallact,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.edtxtnm.setText(list.get(position).getActionName());
        Glide.with(context)
                .asBitmap()
                .load(list.get(position).getImgurl())
                .into(holder.imgvw);
        holder.edtxtdscrp.setText("Short description of "+list.get(position).getActionName());


        holder.crd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,descriptionActivity.class);
                Activity a=list.get(position);
                intent.putExtra("activity",a);
                context.startActivity(intent);

                Toast.makeText(context, "Welcome "+position+" "+a.getActionName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView edtxtnm,edtxtdscrp;
        ImageView imgvw;
        CardView crd;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgvw=itemView.findViewById(R.id.imgvw);
            edtxtdscrp=itemView.findViewById(R.id.edtxtdscrp);
            edtxtnm=itemView.findViewById(R.id.edtxtNm);
            crd=itemView.findViewById(R.id.crd);

        }
    }
}
