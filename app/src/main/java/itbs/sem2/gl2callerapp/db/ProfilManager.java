package itbs.sem2.gl2callerapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class ProfilManager {
    Context con;
    SQLiteDatabase mabase;

    // Constructeur
    public ProfilManager(Context con) {
        this.con = con;
    }

    /*La classe SQLiteOpenHelper fournit les méthodes getReadableDatabase() et
    getWriteableDatabase() pour accéder à un objet SQLiteDatabase en lecture,
    respectif en écriture.*/
    public void ouvrir(String fichier) {
        MyProfilHelper helper = new MyProfilHelper(con, fichier, null, 1);
        // declaration d'une base
        // si on modifie la version == appel implicite à onUpgrade
        mabase = helper.getWritableDatabase();
        // permet de ouvrir la base si elle existe
        // si n'existe pas, elle cree le fichier
        // et appel oncreate ==> creation des tables
    }

    public long inserer(Profil profil) {
        // insertion dans la base
        ContentValues v = new ContentValues();
        // v est un hashmap
        v.put(MyProfilHelper.col_nom, profil.nom);
        v.put(MyProfilHelper.col_prenom, profil.prenom);
        v.put(MyProfilHelper.col_numero, profil.numero);
        return mabase.insert(MyProfilHelper.table_name, null, v);
    }

    public ArrayList<Profil> selectionnertout() {
        // initialisation de la valeur de retour
        ArrayList<Profil> data = new ArrayList<Profil>();
        // selection depuis la base
        Cursor cr = mabase.query(MyProfilHelper.table_name
                , new String[]{MyProfilHelper.col_id, MyProfilHelper.col_nom, MyProfilHelper.col_prenom, MyProfilHelper.col_numero}
                , null, null, null, null, null
        );
        // conversion d'un cursor à une arraylist data
        cr.moveToFirst();
        while (!cr.isAfterLast()) {
            int id = cr.getInt(0);
            String nom = cr.getString(1);
            String prenom = cr.getString(2);
            String numero = cr.getString(3);
            Profil profil = new Profil(id);
            profil.setNom(nom);
            profil.setPrenom(prenom);
            profil.setNumero(numero);
            data.add(profil);
            cr.moveToNext();
        }
        return data;
    }

    public long modifier(Profil profil) {
        int a = -1;
        ContentValues v = new ContentValues();
        v.put(MyProfilHelper.col_nom, profil.nom);
        v.put(MyProfilHelper.col_prenom, profil.prenom);
        v.put(MyProfilHelper.col_numero, profil.numero);
        a = mabase.update(MyProfilHelper.table_name, v, MyProfilHelper.col_id + "=" + profil.id, null);
        return a;
    }

    public long supprimer(Profil profil) {
        int a = -1;
        a = mabase.delete(MyProfilHelper.table_name, MyProfilHelper.col_id + " = " + profil.id, null);
        return a;
    }
}