package com.example.gestionstock2.modele;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "Categorie")
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "categorie_id", columnDefinition = "CHAR(36)")
    private UUID categorieId;

    @Column(name = "categorie_nom", length = 255)
    private String categorieNom;

    @Column(name = "categorie_description", length = 255)
    private String categorieDescription;

    // Exemple de relation OneToMany vers Article
    @ManyToOne
    @JoinColumn(name= "article_id", nullable = true)
    private Article article;

    public Categorie() {}
    public Categorie(String categorieNom, String categorieDescription, Article article) {
        this.categorieNom = categorieNom;
        this.categorieDescription = categorieDescription;
        this.article = article;
    }

    public UUID getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(UUID categorieId) {
        this.categorieId = categorieId;
    }

    public String getCategorieNom() {
        return categorieNom;
    }

    public void setCategorieNom(String categorieNom) {
        this.categorieNom = categorieNom;
    }

    public String getCategorieDescription() {
        return categorieDescription;
    }

    public void setCategorieDescription(String categorieDescription) {
        this.categorieDescription = categorieDescription;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
