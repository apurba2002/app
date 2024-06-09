package com.example.ga;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Semester extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester);
        LinearLayout back;
        LinearLayout f1;
        LinearLayout f2;
        LinearLayout f3;
        LinearLayout f4;
        LinearLayout f5;
        LinearLayout f6;
        LinearLayout f7;

        back = findViewById(R.id.back);
        f1 = findViewById(R.id.f1);
        f2 = findViewById(R.id.f2);
        f3 = findViewById(R.id.f3);
        f4 = findViewById(R.id.f4);
        f5 = findViewById(R.id.f5);
        f6 = findViewById(R.id.f6);
        f7 = findViewById(R.id.f7);
        f2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gohome2();
            }
        });
        f3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goform3();
            }
        });
        f4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goform4();
            }
        });
        f5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goform5();
            }
        });
        f6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goform6();
            }
        });
        f7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goform7();
            }
        });
        f1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goform1();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gohome();
            }
        });

    }

    private void goform7() {
        Intent intent = new Intent(this, Form.class);
        intent.putExtra("ref","7th Semester");
        startActivity(intent);
    }

    private void goform6() {
        Intent intent = new Intent(this, Form.class);
        intent.putExtra("ref","6th Semester");
        startActivity(intent);
    }

    private void goform5() {
        Intent intent = new Intent(this, Form.class);
        intent.putExtra("ref","5th Semester");
        startActivity(intent);
    }

    private void goform4() {
        Intent intent = new Intent(this, Form.class);
        intent.putExtra("ref","4th Semester");
        startActivity(intent);
    }

    private void goform3() {
        Intent intent = new Intent(this, Form.class);
        intent.putExtra("ref","3rd Semester");
        startActivity(intent);
    }

    private void gohome2() {
        Intent intent = new Intent(this, Form.class);
        intent.putExtra("ref","2nd Semester");
        startActivity(intent);
    }

    private void goform1() {
        Intent intent = new Intent(this, Form.class);
        intent.putExtra("ref","1st Semester");
        startActivity(intent);
    }

    private void gohome() {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }
}