package com.project.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_categorie;

    private String nom_categorie;

    // Constructeurs, getters et setters

    public Categorie() {
    }

    public Categorie(String nom_categorie) {
        this.nom_categorie = nom_categorie;
    }

    public Long getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(Long id_categorie) {
        this.id_categorie = id_categorie;
    }

    public String getNom_categorie() {
        return nom_categorie;
    }

    public void setNom_categorie(String nom_categorie) {
        this.nom_categorie = nom_categorie;
    }
}
