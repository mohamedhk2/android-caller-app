package itbs.sem2.gl2callerapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddProfil extends AppCompatActivity {

    Button btnsave;
    EditText edname,edlastname,ednumber;
    Button btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_profil);

        edname=findViewById(R.id.edname_add);
        edlastname=findViewById(R.id.edlastname_add);
        ednumber=findViewById(R.id.edphone_add);

        btnback=findViewById(R.id.btnback_add);
        btnsave=findViewById(R.id.btnsave_add);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nom=edname.getText().toString();
                String prenom=edlastname.getText().toString();
                String numero=ednumber.getText().toString();

                Profil p=new Profil(nom,prenom,numero);
                Home.data.add(p);

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