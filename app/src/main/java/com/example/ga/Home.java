package com.example.ga;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Home extends AppCompatActivity {

    TextView tt ;
    GoogleSignInClient mGoogleSignInClient;
    TextView name;
    TextView email;
    ImageView img;
    ImageView gallery;
    LinearLayout about;

    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        LinearLayout attendence;
        LinearLayout database;

        name= findViewById(R.id.name);
        email = findViewById(R.id.email);
        img = findViewById(R.id.img);
        about = findViewById(R.id.about);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goabout();
            }
        });
        name.setText(user.getDisplayName());
        email.setText(user.getEmail());

        gallery = findViewById(R.id.gallery);

        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gogallery();
            }
        });
        Glide.with(this)
                .load(user.getPhotoUrl().toString())
                .into(img);




        database = findViewById(R.id.database);
        attendence = findViewById(R.id.attendence);
        tt = findViewById(R.id.tt);

        tt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signout();
            }
        });

        database.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                godatabase();
            }
        });

        attendence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gosemester();
            }
        });
    }

    private void goabout() {
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }

    private void gogallery() {
        Intent intent = new Intent(this, Gallery.class);
        startActivity(intent);
    }

    private void signout() {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail().build();

        mGoogleSignInClient = GoogleSignIn.getClient(this,gso);
        mGoogleSignInClient.revokeAccess();
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    private void godatabase() {
        Intent intent = new Intent(this, Database.class);
        startActivity(intent);
    }

    private void gosemester() {
        Intent intent = new Intent(this, Semester.class);
        startActivity(intent);
    }
}