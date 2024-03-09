package com.tama.android;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText jobTitle;
    private EditText jobDescription;
    private String jobDate;
    private String jobTime;

    private TextView DatePicker, TimePicker;

    private ListView jobListView;

    private List<JobModel> jobList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jobTitle = findViewById(R.id.titleInput);
        jobDescription = findViewById(R.id.descInput);

        DatePicker = findViewById(R.id.dateOutput);
        TimePicker = findViewById(R.id.hourOutput);

        jobListView = findViewById(R.id.listView);


        findViewById(R.id.btnDatePicker).setOnClickListener(this);
        findViewById(R.id.btnTimePicker).setOnClickListener(this);

        findViewById(R.id.btnAddJob).setOnClickListener(this);

        JobAdapter jobAdapter = new JobAdapter(this, jobList);

        jobListView.setAdapter(jobAdapter);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnDatePicker) {
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view, year, month, dayOfMonth) -> {
                jobDate = dayOfMonth + "/" + (month + 1) + "/" + year;
                DatePicker.setText(jobDate);
            }, 2024, 0, 1);
            datePickerDialog.show();
        }

        if (v.getId() == R.id.btnTimePicker) {
            TimePickerDialog timePickerDialog = new TimePickerDialog(this, (view, hourOfDay, minute) -> {
                jobTime = hourOfDay + ":" + minute;
                TimePicker.setText(jobTime);

            }, 0, 0, true);
            timePickerDialog.show();
        }

        if (v.getId() == R.id.btnAddJob) {
            String title = jobTitle.getText().toString();
            String desc = jobDescription.getText().toString();

//            check if the fields are empty
            if (title.isEmpty() || desc.isEmpty() || jobDate.isEmpty() || jobTime.isEmpty()) {
                Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                if (title.isEmpty()) {
                    jobTitle.setError("Title is required");
                    jobTitle.requestFocus();
                } else if (desc.isEmpty()) {
                    jobDescription.setError("Description is required");
                    jobDescription.requestFocus();
                } else if (jobDate.isEmpty()) {
                    DatePicker.setError("Date is required");
                    DatePicker.requestFocus();
                } else if (jobTime.isEmpty()) {
                    TimePicker.setError("Time is required");
                    TimePicker.requestFocus();
                }
                return;
            }

            JobModel jobModel = new JobModel(title, desc, jobDate, jobTime);
            jobList.add(jobModel);

            jobTitle.setText("");
            jobDescription.setText("");
            DatePicker.setText("Date");
            TimePicker.setText("Time");
            Toast.makeText(this, "Job added successfully", Toast.LENGTH_SHORT).show();

            JobAdapter jobAdapter = new JobAdapter(this, jobList);
            jobListView.setAdapter(jobAdapter);
        }

    }
}