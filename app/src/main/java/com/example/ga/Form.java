package com.example.ga;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.HashMap;

public class Form extends AppCompatActivity {

    EditText name;
    EditText roll;
    EditText code;

    Button submit;
    DatabaseReference databaseReference;
    Button date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        LinearLayout back;

        LinearLayout submit;

        submit = findViewById(R.id.submit);
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        String ref = getIntent().getStringExtra("ref");
        databaseReference = firebaseDatabase.getReference(ref);
        name = findViewById(R.id.name);
        roll = findViewById(R.id.roll);
        code = findViewById(R.id.code);




        date= findViewById(R.id.date);
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gohome();
            }
        });
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                senddata();
            }
        });



    }



    public void showDatePickerDialog() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        Button date;
                        date= findViewById(R.id.date);
                        // Handle the date selected by the user
                        String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
                        date.setHint(selectedDate);

                        String nameout = name.getText().toString().trim();
                        String rollout = roll.getText().toString().trim();
                        String codeout = code.getText().toString().trim();
                         Data data = new Data(nameout,rollout,codeout , selectedDate);

                        databaseReference.child(codeout).child(rollout).child(databaseReference.push().getKey()).setValue(selectedDate);









                    }
                }, year, month, day);
        datePickerDialog.show();
    }




    private void gohome() {
        Intent intent = new Intent(this, Semester.class);
        startActivity(intent);
    }
    public void senddata() {

        name.setText("");
        roll.setText("");
        code.setText("");
        date.setHint("");



    }

}