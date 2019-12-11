package com.example.gymapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.TextUtils;
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
    Button btnadd, btncncl;

    private Activity activity;

    private ArrayList<String> days;

    private ActivityDatabase db = Utility.getDb();

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.custom_dialoglayout, null);

        edtxtmin = view.findViewById(R.id.edtxtmin);
        edtxtNam = view.findViewById(R.id.edtxtNam);
        spinner = view.findViewById(R.id.spinner);
        btnadd = view.findViewById(R.id.btnok);
        btncncl = view.findViewById(R.id.btncncl);

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setView(view);

        Bundle bundle = getArguments();
        activity = bundle.getParcelable("activity");
        if (activity != null) {
            edtxtNam.setText(activity.getActionName());

            setSpinner();
            ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, days);
            spinner.setAdapter(spinnerAdapter);

            btnadd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int min;
                    String a = edtxtmin.getText().toString();
                    if (TextUtils.isEmpty(a)) {
                        Toast.makeText(getContext(), "please enter the time", Toast.LENGTH_SHORT).show();

                    } else {
                        min = Integer.parseInt(a);
                        String day = spinner.getSelectedItem().toString();

                        setActivities act = new setActivities();
                        act.setActionName(activity.getActionName());
                        act.setImgurl(activity.getImgurl());
                        act.setDesciption(activity.getDesciption());
                        act.setMin(min);
                        switch (day) {
                            case "Monday":
                                act.setDay("Monday");
                                Toast.makeText(getContext(), "added in mon  " + Utility.noOfActivitiesplanned, Toast.LENGTH_SHORT).show();
                                break;
                            case "Tuesday":
                                act.setDay("Tuesday");
                                Toast.makeText(getContext(), "added in tue  " + Utility.noOfActivitiesplanned, Toast.LENGTH_SHORT).show();
                                break;
                            case "Wednesday":
                                act.setDay("Wednesday");
                                Toast.makeText(getContext(), "added in wed  " + Utility.noOfActivitiesplanned, Toast.LENGTH_SHORT).show();
                                break;
                            case "Thursday":
                                act.setDay("Thrusday");
                                Toast.makeText(getContext(), "added in thur  " + Utility.noOfActivitiesplanned, Toast.LENGTH_SHORT).show();
                                break;
                            case "Friday":
                                act.setDay("Friday");
                                Toast.makeText(getContext(), "added in fri  " + Utility.noOfActivitiesplanned, Toast.LENGTH_SHORT).show();
                                break;
                            case "Saturday":
                                act.setDay("Saturday");
                                Toast.makeText(getContext(), "added in sat  " + Utility.noOfActivitiesplanned, Toast.LENGTH_SHORT).show();
                                break;
                            default:
                                break;
                        }
                        db.setActivitiesDAO().insert(act);
                        Utility.addsetActivity(act);
                        Utility.noOfActivitiesplanned++;
                        Intent intent = new Intent(getActivity(), SetplanActivity.class);
                        startActivity(intent);
                        Toast.makeText(getContext(), "add button clicked", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            btncncl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dismiss();
                }
            });
        } else {
            Toast.makeText(getContext(), "Nothing in activity", Toast.LENGTH_SHORT).show();
        }


        return builder.create();
    }

    public void setSpinner() {

        days = new ArrayList<>();
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
        days.add("Saturday");

    }
}
