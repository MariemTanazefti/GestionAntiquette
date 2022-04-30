package com.example.antiquette;

public class Produit {
    private int id;
    private  String nom;
   // private  String  description;
    private String prix ;
    private String image;


    public Produit(int id, String nom, String prix, String image) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.image = image;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prix='" + prix + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Produit() {

        this.nom = nom;
        //this.description = description;
        this.prix = prix;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

  /*  public void setDescription(String description) {
        this.description = description;
    }*/

    public void setPrix(String prix) {
        this.prix = prix;
    }


    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

/*
    public String getDescription() {
        return description;
    }
*/

    public String getPrix() {
        return prix;
    }


}


