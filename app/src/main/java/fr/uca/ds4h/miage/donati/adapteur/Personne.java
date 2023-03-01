package fr.uca.ds4h.miage.donati.adapteur;

/**
 * Created by Rosa Lecat on 03/02/2020.
 */

public class Personne {
    private String nom;
    private String prenom;
    private int genre;

    public Personne(String aNom, String aPrenom, int aGenre) {
        nom = aNom;
        prenom = aPrenom;
        genre = aGenre;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getGenre() {
        return genre;
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }
}
