package itbs.sem2.gl2callerapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.SharedPreferences;
import android.content.Context;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    // DEclaration des composantes
    Button btnexit, btnlogin;
    EditText edemail, edpwd;
    Switch switch_connected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //mettre un fichier xml interface sur l'ecran
        LoginActivity.this.setContentView(R.layout.activity_login);

        // Recupertion des composantes
        btnexit = findViewById(R.id.btnexit_auth);
        btnlogin = findViewById(R.id.btnlogin_auth);
        edemail = findViewById(R.id.edemail_auth);
        edpwd = findViewById(R.id.edpwd_auth);
        switch_connected = findViewById(R.id.switch_connected_auth);

        //Evenement

        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // recuperer les chaines saisies
                String email = edemail.getText().toString();
                String pwd = edpwd.getText().toString();
                if (email.equals("azer") && pwd.equals("111")) {
                    // passage entre activite
                    /**
                     * intent: intention de lancer qlq chose
                     * params: activité courante.this, Activite_cible.class
                     * pour lancer l'intent => startActivity
                     */
                    /*Intent i=new Intent(Intent.ACTION_DIAL);
                    i.setData(Uri.parse("tel:22222222"));
                    startActivity(i);*/

                    SharedPreferences sharedPref = getSharedPreferences("CallerApp", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putBoolean("remember-me", switch_connected.isChecked());
                    editor.apply();

                    startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                    finish();
                } else {
                    // message d'erreur
                    Toast.makeText(LoginActivity.this, "erreur de saisie", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}