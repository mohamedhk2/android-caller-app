package itbs.sem2.gl2callerapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListProfil extends AppCompatActivity {

    RecyclerView rv_list;
    EditText edrech;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_profil);

        rv_list = findViewById(R.id.rv_list);
        edrech = findViewById(R.id.edrech);

        //Affichage des données
       /* ArrayAdapter ad=new ArrayAdapter(ListProfil.this,
                android.R.layout.simple_list_item_1,
                Home.data);*/

        MyRecyclerProfilAdapter ad = new MyRecyclerProfilAdapter(ListProfil.this, Home.data);
        rv_list.setAdapter(ad);

        /*LinearLayoutManager layoutManager = new LinearLayoutManager(ListProfil.this, LinearLayoutManager.VERTICAL, false);
        rv_list.setLayoutManager(layoutManager);*/

        GridLayoutManager layoutManager = new GridLayoutManager(ListProfil.this, 1, GridLayoutManager.VERTICAL, false);
        rv_list.setLayoutManager(layoutManager);

        edrech.addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                    }

                    @Override
                    public void afterTextChanged(android.text.Editable s) {
                        //Recherche selon Le nom, prenom ou numero de la chaine saisie
                    }
                }
        );
    }
}