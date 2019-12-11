package com.example.gymapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnstactvt,btnstpln,btnabt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnabt=findViewById(R.id.btnabt);
        btnstactvt=findViewById(R.id.btnstactvt);
        btnstpln=findViewById(R.id.btnstpln);

        IntiateDatabase intiateDatabase=new IntiateDatabase();
        intiateDatabase.execute();

        btnstactvt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Activities.class);
                startActivity(intent);
            }
        });

        btnstpln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SetplanActivity.class);
                startActivity(intent);
            }
        });

        btnabt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    private class IntiateDatabase extends AsyncTask<Void,Void,Void>{

        ActivityDatabase db;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            Utility.setContext(MainActivity.this);
            Utility.initDatabase();
            db=Utility.getDb();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            Utility.setAllActivities(db.AllActivityDAO().getAllActivities());
            Utility.setSetActivities(db.setActivitiesDAO().getsetActivities());
            return null;
        }
    }
}
