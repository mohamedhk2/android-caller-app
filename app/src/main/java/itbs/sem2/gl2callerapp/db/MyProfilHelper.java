package itbs.sem2.gl2callerapp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyProfilHelper extends SQLiteOpenHelper {
    // declaration de nom de la table, titre des champs
    public static final String table_name = "Profils";
    public static final String col_id = "id";
    public static final String col_nom = "nom";
    public static final String col_prenom = "prenom";
    public static final String col_numero = "numero";
    String createTable = "create table " + table_name + "("
            + col_id + " Integer primary Key autoincrement,"
            + col_nom + " Text not null,"
            + col_prenom + " Text not null,"
            + col_numero + " Text not null"
            + ")";
    private final int mNewVersion = 2;

    public MyProfilHelper(@Nullable Context context, @Nullable String name,
                          @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" drop table " + table_name);
        onCreate(db);
    }
}
