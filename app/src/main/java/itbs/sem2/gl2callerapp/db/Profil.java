package itbs.sem2.gl2callerapp.db;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Profil {

    String nom, prenom, numero;

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNumero() {
        return numero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int id = 0;

    public Profil() {
    }

    public Profil(int id) {
        this.id = id;
    }

    public Profil setNom(String nom) {
        this.nom = nom;
        return this;
    }

    public Profil setPrenom(String prenom) {
        this.prenom = prenom;
        return this;
    }

    public Profil setNumero(String numero) {
        this.numero = numero;
        return this;
    }


    @Override
    public String toString() {
        return "Profil{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }
}
