package itbs.sem2.gl2callerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import itbs.sem2.gl2callerapp.db.Profil;

public class HomeActivity extends AppCompatActivity {

    public static ArrayList<Profil> data = new ArrayList<Profil>();

    // declaration
    Button btnadd, btnlist, btnlogout, btnexit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HomeActivity.this.setContentView(R.layout.activity_home);

        // recuperation
        btnadd = HomeActivity.this.findViewById(R.id.btnadd_home);
        btnlist = findViewById(R.id.btnlist_home);
        btnlogout = findViewById(R.id.btnlogout_home);
        btnexit = findViewById(R.id.btnexit_home);

        // event
        btnadd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this, AddProfilActivity.class);
                startActivity(i);
            }
        });
        btnlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, ListProfilsActivity.class));

            }
        });

        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPref = getSharedPreferences("CallerApp", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putBoolean("remember-me", false);
                editor.apply();
                startActivity(new Intent(HomeActivity.this, LoginActivity.class));
                finish();
            }
        });

        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}