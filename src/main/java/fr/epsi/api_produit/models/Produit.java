package fr.epsi.api_produit.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Produit {

    @Id
    @Column(length = 36, unique = true, nullable = false)
    private String id;

    private String nom;
    private double prix;

    @ManyToOne
    private Categorie categorie;

    public Produit() {
    }

    public Produit(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                '}';
    }

}
