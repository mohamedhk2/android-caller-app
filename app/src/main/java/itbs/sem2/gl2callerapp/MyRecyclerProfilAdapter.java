package itbs.sem2.gl2callerapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyRecyclerProfilAdapter extends RecyclerView.Adapter<MyRecyclerProfilAdapter.MyViewHolder> {

    Context con;
    ArrayList<Profil> data;

    @NonNull
    @Override
    public MyRecyclerProfilAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // creation d'un view
        LayoutInflater inf = LayoutInflater.from(con);
        View v = inf.inflate(R.layout.view_profil, null);
        return new MyViewHolder(v);
    }


    public MyRecyclerProfilAdapter(Context con, ArrayList<Profil> data) {
        this.con = con;
        this.data = data;

    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerProfilAdapter.MyViewHolder holder, int position) {
        // Affectation des holders
        Profil p = data.get(position);
        holder.tvnom.setText(p.nom);
        holder.tvprenom.setText(p.prenom);
        holder.tvnumero.setText(p.numero);
    }

    @Override
    public int getItemCount() {
        // retourne le nbre total des elements
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // Decalaration des holders
        TextView tvnom, tvprenom, tvnumero;
        ImageView imgcall, imgdelete, imgedit;

        public MyViewHolder(@NonNull View v) {
            super(v);

            // Recuperation des sous Views/ HOLDERS
            tvnom = v.findViewById(R.id.tvnom_profil);
            tvprenom = v.findViewById(R.id.tvprenom_profil);
            tvnumero = v.findViewById(R.id.tvnumero_profil);

            imgdelete = v.findViewById(R.id.imageViewdelete_profil);
            imgedit = v.findViewById(R.id.imageViewedit_profil);
            imgcall = v.findViewById(R.id.imageViewcall_profil);

            // event
            imgdelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // afficher une boite de dialog
                    AlertDialog.Builder alert = new AlertDialog.Builder(con);
                    alert.setTitle("Confirmation");
                    alert.setMessage("confirmer la suppression?");

                    alert.setPositiveButton("supprimer", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            int indice = getAdapterPosition();// renvoie la position de Lelement selectionnée
                            // A FAIRE: supprimer de la base

                            // supprimer lelement
                            data.remove(indice);
                            notifyDataSetChanged();// MAJ de l'affichage
                        }
                    });
                    alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            // votre code
                        }
                    });
                    alert.setNeutralButton("Exit", null);
                    alert.show();
                }
            });
            imgcall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int indice = getAdapterPosition();
                    Profil p = data.get(indice);

                    Intent i = new Intent(Intent.ACTION_DIAL);
                    i.setData(Uri.parse("tel:" + p.numero));
                    con.startActivity(i);
                }
            });
            imgedit.setOnClickListener(new View.OnClickListener() {
                AlertDialog dialog;
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(con);
                    alert.setTitle("Edition");
                    alert.setMessage("Modifier les informations!");

                    LayoutInflater inf = LayoutInflater.from(con);
                    View vd = inf.inflate(R.layout.view_dialog, null);

                    EditText ednom = vd.findViewById(R.id.ednom_dialog),
                            edprenom = vd.findViewById(R.id.edprenom_dialog),
                            ednumero = vd.findViewById(R.id.ednumero_dialog);
                    Button btnenregistrer = vd.findViewById(R.id.btnenregistrer_dialog),
                            btnannuler = vd.findViewById(R.id.btnannuler_dialog);

                    int indice = getAdapterPosition();
                    Profil p = data.get(indice);

                    ednom.setText(p.nom);
                    edprenom.setText(p.prenom);
                    ednumero.setText(p.numero);

                    btnenregistrer.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String nom = ednom.getText().toString();
                            String prenom = edprenom.getText().toString();
                            String numero = ednumero.getText().toString();

                            Profil p = new Profil(nom, prenom, numero);
                            // Modifier la bdd
                            data.set(indice, p);
                            notifyDataSetChanged();// rafraichir le view
                            dialog.dismiss();
                        }
                    });

                    btnannuler.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                        }
                    });

                    alert.setCancelable(false);
                    alert.setView(vd);
                    dialog = alert.create();
                    dialog.show();
                }
            });
        }
    }
}
