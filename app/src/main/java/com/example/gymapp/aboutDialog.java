package com.example.gymapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;

public class aboutDialog extends DialogFragment {

    TextView edtxtNam;
    Spinner spinner;
    EditText edtxtmin;
    Button btnadd,btncncl;

    private Activity activity;

    private Utility util=new Utility();

    private ArrayList<String> days;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view=getActivity().getLayoutInflater().inflate(R.layout.custom_dialoglayout,null);

        edtxtmin=view.findViewById(R.id.edtxtmin);
        edtxtNam=view.findViewById(R.id.edtxtNam);
        spinner=view.findViewById(R.id.spinner);
        btnadd=view.findViewById(R.id.btnok);
        btncncl=view.findViewById(R.id.btncncl);

        AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
        builder.setView(view);

        Bundle bundle=getArguments();
        activity=bundle.getParcelable("activity");
        if(activity!=null){
            edtxtNam.setText(activity.getActionName());

            setSpinner();
            ArrayAdapter<String> spinnerAdapter=new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_dropdown_item,days);
            spinner.setAdapter(spinnerAdapter);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a=edtxtmin.getText().toString();
                Integer min=Integer.parseInt(a);
                String day= spinner.getSelectedItem().toString();
                    if(a==""){
                        dismiss();
                        Toast.makeText(getActivity(), "Nothing in day", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        switch (day){
                            case "Monday":
                                activity.setMin(min);
                                util.addmonActivity(activity);
                                util.noOfActivitiesplanned++;
                                Toast.makeText(getContext(), "added in mon  "+util.noOfActivitiesplanned, Toast.LENGTH_SHORT).show();
                                break;
                            case "Tuesday":
                                activity.setMin(min);
                                util.addtueActivity(activity);
                                util.noOfActivitiesplanned++;
                                Toast.makeText(getContext(), "added in tue  "+util.noOfActivitiesplanned, Toast.LENGTH_SHORT).show();
                                break;
                            case "Wednesday":
                                activity.setMin(min);
                                util.addwedActivity(activity);
                                util.noOfActivitiesplanned++;
                                Toast.makeText(getContext(), "added in wed  "+util.noOfActivitiesplanned, Toast.LENGTH_SHORT).show();
                                break;
                            case "Thrusday":
                                activity.setMin(min);
                                util.addthurActivity(activity);
                                util.noOfActivitiesplanned++;
                                Toast.makeText(getContext(), "added in thur  "+util.noOfActivitiesplanned, Toast.LENGTH_SHORT).show();
                                break;
                            case "Friday":
                                activity.setMin(min);
                                util.addfriActivity(activity);
                                util.noOfActivitiesplanned++;
                                Toast.makeText(getContext(), "added in fri  "+util.noOfActivitiesplanned, Toast.LENGTH_SHORT).show();
                                break;
                            case "Saturday":
                                activity.setMin(min);
                                util.addsatActivity(activity);
                                util.noOfActivitiesplanned++;
                                Toast.makeText(getContext(), "added in sat  "+util.noOfActivitiesplanned, Toast.LENGTH_SHORT).show();
                                break;
                            default:break;
                        }
                        Intent intent=new Intent(getActivity(),SetplanActivity.class);
                        startActivity(intent);
                    }


            }
        });

        btncncl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        }
        else {
            Toast.makeText(getContext(), "Nothing in activity", Toast.LENGTH_SHORT).show();
        }


        return builder.create();
    }

    public void setSpinner(){

        days=new ArrayList<>();
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
        days.add("Saturday");

    }
}
