package com.example.gymapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

public class SetplanActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnaddanw;
    RecyclerView remon,retue,rewed,rethur,refri,resat;
    plannedActivityAdapter admon,adtue,adwed,adthur,adfri,adsat;
    TextView txtmon,txttue,txtwed,txtthur,txtfri,txtsat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(Utility.noOfActivitiesplanned==0){
            setContentView(R.layout.activity_setplan);

            btnaddanw=findViewById(R.id.btnaddanw);
            btnaddanw.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(SetplanActivity.this,Activities.class);
                    startActivity(intent);
                }
            });
        }
        else{
            setContentView(R.layout.activity_dayschedule);

            remon=findViewById(R.id.remon);
            retue=findViewById(R.id.retue);
            rewed=findViewById(R.id.rewed);
            rethur=findViewById(R.id.rethur);
            refri=findViewById(R.id.refri);
            resat=findViewById(R.id.resat);

            admon=new plannedActivityAdapter(Utility.getMonActivities(),this);
            adtue=new plannedActivityAdapter(Utility.getTueActivities(),this);
            adwed=new plannedActivityAdapter(Utility.getWedActivities(),this);
            adthur=new plannedActivityAdapter(Utility.getThurActivities(),this);
            adfri=new plannedActivityAdapter(Utility.getFriActivities(),this);
            adsat=new plannedActivityAdapter(Utility.getSatActivities(),this);

            remon.setAdapter(admon);
            remon.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

            retue.setAdapter(adtue);
            retue.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

            rewed.setAdapter(adwed);
            rewed.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

            rethur.setAdapter(adthur);
            rethur.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

            refri.setAdapter(adfri);
            refri.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

            resat.setAdapter(adsat);
            resat.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

            txtmon=findViewById(R.id.txtdedmon);
            txttue=findViewById(R.id.txtedtue);
            txtwed=findViewById(R.id.txtedwed);
            txtthur=findViewById(R.id.txtedthur);
            txtfri=findViewById(R.id.txtedfri);
            txtsat=findViewById(R.id.txtedsat);

            txtsat.setOnClickListener(this);
            txtthur.setOnClickListener(this);
            txttue.setOnClickListener(this);
            txtmon.setOnClickListener(this);
            txtfri.setOnClickListener(this);
            txtwed.setOnClickListener(this);

        }

        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onClick(View view) {
        Intent intent=new Intent(this,com.example.gymapp.EditActivity.class);

        switch (view.getId()){
            case R.id.txtdedmon:
                intent.putParcelableArrayListExtra("list",Utility.getMonActivities());
                intent.putExtra("day","Mon");
                break;
            case R.id.txtedtue:
                intent.putParcelableArrayListExtra("list",Utility.getTueActivities());
                intent.putExtra("day","Tue");
                break;
            case R.id.txtedwed:
                intent.putExtra("list",Utility.getWedActivities());
                intent.putExtra("day","Wed");
                break;
            case R.id.txtedthur:
                intent.putExtra("list",Utility.getThurActivities());
                intent.putExtra("day","Thur");
                break;
            case R.id.txtedfri:
                intent.putExtra("list",Utility.getFriActivities());
                intent.putExtra("day","Fri");
                break;
            case R.id.txtedsat:
                intent.putExtra("list",Utility.getSatActivities());
                intent.putExtra("day","Sat");
                break;
            default:break;
        }

        startActivity(intent);
    }
}
