package itbs.sem2.gl2callerapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * @deprecated
 */
public class MyProfilAdapter extends BaseAdapter {
    //creation des views
    Context con;
    ArrayList<Profil> data;
    MyProfilAdapter(Context con, ArrayList<Profil> data)
    {
        this.con=con;
        this.data=data;
    }
    @Override
    public int getCount() {
        // retourne le nbre des views à créer
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        // renvoie le view à afficher

        // creation d'un view
        LayoutInflater inf=LayoutInflater.from(con);
        View v=inf.inflate(R.layout.view_profil,null);

        // Recuperation des sous Views/ HOLDERS
        TextView tvnom=v.findViewById(R.id.tvnom_profil);
        TextView tvprenom=v.findViewById(R.id.tvprenom_profil);
        TextView tvnumero=v.findViewById(R.id.tvnumero_profil);

        ImageView imgdelete=v.findViewById(R.id.imageViewdelete_profil);
        ImageView imgedit=v.findViewById(R.id.imageViewedit_profil);
        ImageView imgcall=v.findViewById(R.id.imageViewcall_profil);

        // Affectation des holders
        Profil p=data.get(position);
        tvnom.setText(p.nom);
        tvprenom.setText(p.prenom);
        tvnumero.setText(p.numero);

        // event
        imgdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // afficher une boite de dialog
                AlertDialog.Builder alert=new AlertDialog.Builder(con);
                alert.setTitle("Confirmation");
                alert.setMessage("confirmer la suppression?");

                alert.setPositiveButton("supprimer", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        // A FAIRE: supprimer de la base

                        // supprimer lelement
                        data.remove(position);
                        notifyDataSetChanged();// MAJ de l'affichage
                    }
                });
                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // votre code
                    }
                });
                alert.setNeutralButton("Exit",null);
                alert.show();
            }
        });

        imgcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:"+p.numero));
                con.startActivity(i);
            }
        });

        return v;
    }
}
