package com.example.ga;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Baner extends AppCompatActivity {
    FirebaseAuth mAuth;
    GoogleSignInClient mGoogleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baner);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                gohome();
                finish();
            }
        },3000);
    }

    private void gohome() {


        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}