package itbs.sem2.gl2callerapp;

public class Profil {
    String nom,prenom,numero;

    public Profil(String nom, String prenom, String numero) {
        this.nom = nom;
        this.prenom = prenom;
        this.numero = numero;
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
