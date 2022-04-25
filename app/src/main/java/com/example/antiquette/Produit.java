package com.example.antiquette;

public class Produit {
    private int id;
    private  String nom;
    private  String  description;
    private String prix ;
    private String  quantite ;


    public Produit(String n, String d, String p, String q )
    { this.nom=n;
        this.description=d;
        this.prix=p;
        this.quantite=q;


    }
    public Produit() {

        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.quantite = quantite;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public String getPrix() {
        return prix;
    }

    public String getQuantite() {
        return quantite;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", prix='" + prix + '\'' +
                ", quantite='" + quantite + '\'' +
                '}';
    }
}


