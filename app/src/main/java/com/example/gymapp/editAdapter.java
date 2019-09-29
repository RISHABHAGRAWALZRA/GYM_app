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

public class editAdapter extends RecyclerView.Adapter<editAdapter.ViewHolder>{

    private ArrayList<Activity> list;
    private Context context;
    private String day;

    public editAdapter(ArrayList<Activity> list, Context context, String day) {
        this.list = list;
        this.context = context;
        this.day = day;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.edit_layout,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.edtvNm.setText(list.get(position).getActionName());
        Glide.with(context)
                .asBitmap()
                .load(list.get(position).getImgurl())
                .into(holder.edimgVw);

        holder.edtvtim.setText("Timeing "+list.get(position).getMin()+"minutes");

        holder.edchkbx.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (holder.edchkbx.isChecked()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle("Delete?");
                    builder.setMessage("Want to delete this Action?");
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Utility util=new Utility();
                            switch (day){
                                case "Mon":
                                    util.removemonActivity(list.get(position));
                                    Utility.noOfActivitiesplanned--;
                                    notifyDataSetChanged();
                                    break;
                                case "Tue":
                                    util.removetueActivity(list.get(position));
                                    Utility.noOfActivitiesplanned--;
                                    notifyDataSetChanged();
                                    break;
                                case "Wed":
                                    util.removewedActivity(list.get(position));
                                    Utility.noOfActivitiesplanned--;
                                    notifyDataSetChanged();
                                    break;
                                case "Thur":
                                    util.removethurActivity(list.get(position));
                                    Utility.noOfActivitiesplanned--;
                                    notifyDataSetChanged();
                                    break;
                                case "Fri":
                                    util.removefriActivity(list.get(position));
                                    Utility.noOfActivitiesplanned--;
                                    notifyDataSetChanged();
                                    break;
                                case "Sat":
                                    util.removesatActivity(list.get(position));
                                    Utility.noOfActivitiesplanned--;
                                    notifyDataSetChanged();
                                    break;
                                default:break;
                            }
                        }
                    });
                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            holder.edchkbx.setChecked(false);
                        }
                    });
                    builder.create().show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView edtvNm,edtvtim;
        ImageView edimgVw;
        CardView cardedit;
        CheckBox edchkbx;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            edtvNm=itemView.findViewById(R.id.edtvnm);
            edtvtim=itemView.findViewById(R.id.edtvtim);
            cardedit=itemView.findViewById(R.id.cardedit);
            edimgVw=itemView.findViewById(R.id.edimgVw);
            edchkbx=itemView.findViewById(R.id.edchkbx);
        }
    }
}

