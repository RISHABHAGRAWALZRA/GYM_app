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

import java.util.ArrayList;
import java.util.List;

public class SetplanActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnaddanw;
    RecyclerView remon,retue,rewed,rethur,refri,resat;
    plannedActivityAdapter admon,adtue,adwed,adthur,adfri,adsat;
    TextView txtmon,txttue,txtwed,txtthur,txtfri,txtsat;


    List<setActivities> setActivities0=Utility.getSetActivities();


    List<setActivities> MonActivities;
    List<setActivities> TueActivities;
    List<setActivities> WedActivities;
    List<setActivities> ThurActivities;
    List<setActivities> FriActivities;
    List<setActivities> SatActivities;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(setActivities0.isEmpty()){
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

             MonActivities=new ArrayList<>();
             TueActivities=new ArrayList<>();
             WedActivities=new ArrayList<>();
             ThurActivities=new ArrayList<>();
             FriActivities=new ArrayList<>();
             SatActivities=new ArrayList<>();


            
            for(int i=0;i<setActivities0.size();i++){
                switch (setActivities0.get(i).getDay()){
                    case "Monday":
                        MonActivities.add(setActivities0.get(i));
                        break;
                    case "Tuesday":
                        TueActivities.add(setActivities0.get(i));
                        break;
                    case "Wednesday":
                        WedActivities.add(setActivities0.get(i));
                        break;
                    case "Thursday":
                        ThurActivities.add(setActivities0.get(i));
                        break;
                    case "Friday":
                        FriActivities.add(setActivities0.get(i));
                        break;
                    case "Saturday":
                        SatActivities.add(setActivities0.get(i));
                        break;
                    default:
                        break;
                }
            }

            admon=new plannedActivityAdapter(MonActivities,this);
            adtue=new plannedActivityAdapter(TueActivities,this);
            adwed=new plannedActivityAdapter(WedActivities,this);
            adthur=new plannedActivityAdapter(ThurActivities,this);
            adfri=new plannedActivityAdapter(FriActivities,this);
            adsat=new plannedActivityAdapter(SatActivities,this);

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
//                intent.putParcelableArrayListExtra("list",MonActivities);
                Utility.setActivity(MonActivities);
                intent.putExtra("day","Mon");
                break;
            case R.id.txtedtue:
//                intent.putParcelableArrayListExtra("list",TueActivities);
                Utility.setActivity(TueActivities);
                intent.putExtra("day","Tue");
                break;
            case R.id.txtedwed:
//                intent.putExtra("list",WedActivities);
                Utility.setActivity(WedActivities);
                intent.putExtra("day","Wed");
                break;
            case R.id.txtedthur:
//                intent.putExtra("list",ThurActivities);
                Utility.setActivity(ThurActivities);
                intent.putExtra("day","Thur");
                break;
            case R.id.txtedfri:
//                intent.putExtra("list",FriActivities);
                Utility.setActivity(FriActivities);
                intent.putExtra("day","Fri");
                break;
            case R.id.txtedsat:
//                intent.putExtra("list",SatActivities);
                Utility.setActivity(SatActivities);
                intent.putExtra("day","Sat");
                break;
            default:break;
        }

        startActivity(intent);
    }
}
