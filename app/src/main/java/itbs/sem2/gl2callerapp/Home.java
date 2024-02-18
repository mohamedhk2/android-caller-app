package itbs.sem2.gl2callerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    public static ArrayList<Profil> data=new ArrayList<Profil>();

    // declaration
    Button btnadd,btnlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Home.this.setContentView(R.layout.activity_home);

        // recuperation
        btnadd=Home.this.findViewById(R.id.btnadd_home);
        btnlist=findViewById(R.id.btnlist_home);

        // event
        btnadd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i=new Intent(Home.this,AddProfil.class);
                startActivity(i);
            }
        });
        btnlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(
                        new Intent(Home.this, ListProfil.class));

            }
        });

    }
}