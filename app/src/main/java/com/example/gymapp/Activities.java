package com.example.gymapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Activities extends AppCompatActivity {

    allActivityAdapter allActivityAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        recyclerView=findViewById(R.id.rltv);

          Utility util=new Utility();
          ArrayList<Activity> list=util.getAllActivities();
          allActivityAdapter =new allActivityAdapter(list,this);
          recyclerView.setAdapter(allActivityAdapter);
          recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        return super.onOptionsItemSelected(item);
//    }
}
