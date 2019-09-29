package com.example.gymapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class descriptionActivity extends AppCompatActivity {

    Button btnset;
    TextView edtxtnm,edtxtdscrp;
    ImageView imgvw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        imgvw=findViewById(R.id.img);
        btnset=findViewById(R.id.btnset);
        edtxtnm=findViewById(R.id.edtxtnm);
        edtxtdscrp=findViewById(R.id.edtxtdsp);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Intent intent=getIntent();
        final Activity activity=intent.getParcelableExtra("activity");
        if(activity!=null) {
            Glide.with(this)
                    .asBitmap()
                    .load(activity.getImgurl())
                    .into(imgvw);

            edtxtnm.setText(activity.getActionName());
            edtxtdscrp.setText(activity.getDesciption());

            btnset.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    aboutDialog aboutDialog = new aboutDialog();
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("activity",activity);
                    aboutDialog.setArguments(bundle);
                    aboutDialog.show(getSupportFragmentManager(),"about dialog");
                }
            });
        }
        else {
            Toast.makeText(this, "Nothing in activity", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
