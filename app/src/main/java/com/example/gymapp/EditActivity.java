package com.example.gymapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class EditActivity extends AppCompatActivity {

    TextView txtvw;
    RecyclerView editrecy;
    editAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        txtvw=findViewById(R.id.day);
        editrecy=findViewById(R.id.recyclered);

        Intent intent=getIntent();
        String day=intent.getStringExtra("day");

        switch (day){
            case "Mon":
                txtvw.setText("Monday");
                adapter=new editAdapter(Utility.getMonActivities(),this,day);
                break;
            case "Tue":
                txtvw.setText("Tuesday");
                adapter=new editAdapter(Utility.getTueActivities(),this,day);
                break;
            case "Wed":
                txtvw.setText("Wednesday");
                adapter=new editAdapter(Utility.getWedActivities(),this,day);
                break;
            case "Thur":
                txtvw.setText("Thursday");
                adapter=new editAdapter(Utility.getThurActivities(),this,day);
                break;
            case "Fri":
                txtvw.setText("Friday");
                adapter=new editAdapter(Utility.getFriActivities(),this,day);
                break;
            case "Sat":
                txtvw.setText("Saturday");
                adapter=new editAdapter(Utility.getSatActivities(),this,day);
                break;
            default:break;
        }



        ArrayList<Activity> activity=intent.getParcelableArrayListExtra("list");
        if(activity ==null){
            Toast.makeText(this, "empty list", Toast.LENGTH_SHORT).show();
        }


        editrecy.setAdapter(adapter);
        editrecy.setLayoutManager(new LinearLayoutManager(this));

    }
}
