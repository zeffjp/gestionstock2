package com.example.gestionstock2.modele;

import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;

@Data
@Entity
@Table(name = "Article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "article_id", columnDefinition = "CHAR(36)")
    private UUID articleId;

    @Column(name = "article_nom", length = 255)
    private String articleNom;

    @Column(name = "article_description", length = 255)
    private String articleDescription;

    @Column(name = "article_prix")
    private Double articlePrix;

    @Column(name = "article_quantiteEnStock")
    private Integer articleQuantiteEnStock;

    @ManyToOne
    @JoinColumn(name = "commande_id", referencedColumnName = "commande_id")
    private Commande commande;

    @ManyToOne
    @JoinColumn(name = "categorie_id", referencedColumnName = "categorie_id")
    private Categorie categorie;

    @ManyToOne
    @JoinColumn(name = "vente_id", referencedColumnName = "vente_id")
    private Vente vente;

    public UUID getArticleId() {
        return articleId;
    }

    public void setArticleId(UUID articleId) {
        this.articleId = articleId;
    }

    public String getArticleNom() {
        return articleNom;
    }

    public void setArticleNom(String articleNom) {
        this.articleNom = articleNom;
    }

    public String getArticleDescription() {
        return articleDescription;
    }

    public void setArticleDescription(String articleDescription) {
        this.articleDescription = articleDescription;
    }

    public Double getArticlePrix() {
        return articlePrix;
    }

    public void setArticlePrix(Double articlePrix) {
        this.articlePrix = articlePrix;
    }

    public Integer getArticleQuantiteEnStock() {
        return articleQuantiteEnStock;
    }

    public void setArticleQuantiteEnStock(Integer articleQuantiteEnStock) {
        this.articleQuantiteEnStock = articleQuantiteEnStock;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Vente getVente() {
        return vente;
    }

    public void setVente(Vente vente) {
        this.vente = vente;
    }
}
