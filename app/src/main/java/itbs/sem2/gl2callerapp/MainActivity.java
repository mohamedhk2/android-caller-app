package itbs.sem2.gl2callerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // DEclaration des composantes
    Button btnexit,btnlogin;
    EditText edemail,edpwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //mettre un fichier xml interface sur l'ecran
        MainActivity.this.setContentView(R.layout.activity_main);

        // Recupertion des composantes
        btnexit=findViewById(R.id.btnexit_auth);
        btnlogin=findViewById(R.id.btnlogin_auth);
        edemail=findViewById(R.id.edemail_auth);
        edpwd=findViewById(R.id.edpwd_auth);

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
                String email=edemail.getText().toString();
                String pwd=edpwd.getText().toString();
               // if(email.equals("azer")&& pwd.equals("111"))
                {
                    // passage entre activite
                    /**
                     * intent: intention de lancer qlq chose
                     * params: activité courante.this, Activite_cible.class
                     * pour lancer l'intent => startActivity
                     */
                    /*Intent i=new Intent(Intent.ACTION_DIAL);
                    i.setData(Uri.parse("tel:22222222"));
                    startActivity(i);*/
                    Intent i=new Intent(MainActivity.this,Home.class);

                    startActivity(i);
                    finish();

                }
               //else {
                    // message d'erreur
                    //Toast.makeText(MainActivity.this, "erreur de saisie", Toast.LENGTH_SHORT).show();
                //}
            }
        });
    }
}