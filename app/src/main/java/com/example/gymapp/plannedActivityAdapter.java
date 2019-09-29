package com.example.gymapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class plannedActivityAdapter extends RecyclerView.Adapter<plannedActivityAdapter.ViewHolder>{

    private ArrayList<Activity> list;
    private Context context;

    public plannedActivityAdapter(ArrayList<Activity> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.plannedactivity_layout,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.tvNm.setText(list.get(position).getActionName());
        holder.tvtim.setText("Timming: "+list.get(position).getMin()+"minutes");
       // holder.tvdscp.setText("Short description of "+list.get(position).getActionName());
        Glide.with(context)
                .asBitmap()
                .load(list.get(position).getImgurl())
                .into(holder.imgVw);

        if(list.get(position).getCheck()==true){
            holder.chkbx.setChecked(true);
        }
        else{
            holder.chkbx.setChecked(false);
        }

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,descriptionActivity.class);
                Activity a=list.get(position);
                intent.putExtra("activity",a);
                context.startActivity(intent);

                Toast.makeText(context, "Welcome "+position+" "+a.getActionName(), Toast.LENGTH_SHORT).show();
            }
        });


        holder.chkbx.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(holder.chkbx.isChecked()){
                    AlertDialog.Builder builder=new AlertDialog.Builder(context);
                    builder.setTitle("Completed?");
                    builder.setMessage("Have you completed the Action?");
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            list.get(position).setCheck(true);
                        }
                    });
                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            holder.chkbx.setChecked(false);
                        }
                    });
                    builder.create().show();
                }
                else{
//                    AlertDialog.Builder builder=new AlertDialog.Builder(context);
//                    builder.setTitle("Not Completed?");
//                    builder.setMessage("Is this task is not completed?");
//                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialogInterface, int i) {
                            list.get(position).setCheck(false);
//                        }
//                    });
//                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialogInterface, int i) {
//                            holder.chkbx.setChecked(true);
//                        }
//                    });
//                    builder.create().show();
                }
            }
        });

//        holder.radbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                AlertDialog.Builder builder=new AlertDialog.Builder(context);
//                builder.setTitle("Completed?");
//                builder.setMessage("Have you completed this Action?");
//                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        holder.radbtn.setChecked(true);
//                    }
//                });
//                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        holder.radbtn.setChecked(false);
//                    }
//                });
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvNm,tvtim;
        ImageView imgVw;
        CardView card;
        //RadioButton radbtn;
        CheckBox chkbx;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNm=itemView.findViewById(R.id.tvNm);
            tvtim=itemView.findViewById(R.id.tvtim);
            //tvdscp=itemView.findViewById(R.id.tvdscp);
            card=itemView.findViewById(R.id.cardplanned);
            imgVw=itemView.findViewById(R.id.imgVw);
            //radbtn=itemView.findViewById(R.id.radbtn);
            chkbx=itemView.findViewById(R.id.chkbx);
        }
    }
}
