package itbs.sem2.gl2callerapp;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import itbs.sem2.gl2callerapp.db.Profil;
import itbs.sem2.gl2callerapp.db.ProfilManager;

public class AddProfilActivity extends AppCompatActivity {

    Button btnsave;
    EditText edname, edlastname, ednumber;
    Button btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_profil);

        edname = findViewById(R.id.edname_add);
        edlastname = findViewById(R.id.edlastname_add);
        ednumber = findViewById(R.id.edphone_add);

        btnback = findViewById(R.id.btnback_add);
        btnsave = findViewById(R.id.btnsave_add);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nom = edname.getText().toString();
                String prenom = edlastname.getText().toString();
                String numero = ednumber.getText().toString();
                if (nom.trim().isEmpty() || prenom.trim().isEmpty() || numero.trim().isEmpty()) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(AddProfilActivity.this);
                    alert.setTitle("Erreur");
                    alert.setMessage("Veuillez remplir tous les champs");
                    //ok button
                    alert.setPositiveButton("OK", null);
                    alert.show();
                    return;
                }

                Profil p = new Profil();
                p.setNom(nom);
                p.setPrenom(prenom);
                p.setNumero(numero);

                ProfilManager pm = new ProfilManager(AddProfilActivity.this);
                pm.ouvrir("caller.db");
                long inserer = pm.inserer(p);
                if (inserer != -1) {
                    p.setId((int) inserer);
                    HomeActivity.data.add(p);
                    AlertDialog.Builder alert = new AlertDialog.Builder(AddProfilActivity.this);
                    alert.setTitle("Succès");
                    alert.setMessage("Insertion réussie");
                    alert.setPositiveButton("OK", (dialogInterface, i) -> btnback.performClick());
                    alert.show();
                } else {
                    AlertDialog.Builder alert = new AlertDialog.Builder(AddProfilActivity.this);
                    alert.setTitle("Erreur");
                    alert.setMessage("Erreur d'ajout");
                    alert.setPositiveButton("OK", null);
                    alert.show();
                }
            }
        });

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}