package com.example.gestionstock2.services;

import com.example.gestionstock2.modele.Article;
import com.example.gestionstock2.repositories.ArticleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ArticleService {
    @Autowired
    private  ArticleRepository articleRepository;


    public List<Article> getAll() {
        return articleRepository.findAll();
    }


    public Optional<Article> getArticle(UUID articleId) {
        return articleRepository.findById(articleId);
    }


    public Article createArticle(Article article) {
        return articleRepository.save(article);
    }


    public void deleteById(UUID articleId) {
        articleRepository.deleteById(articleId);
    }


    public Article update(UUID id, Article article) {
        // Vérification si l'article avec l'ID existe déjà dans la base de données
        Optional<Article> existingArticleOptional = articleRepository.findById(id);
        if (existingArticleOptional.isPresent()) {
            // Mettre à jour les champs de l'article avec les nouvelles valeurs
            Article existingArticle = existingArticleOptional.get();
            existingArticle.setArticleNom(article.getArticleNom());
            existingArticle.setArticleDescription(article.getArticleDescription());
            existingArticle.setArticlePrix(article.getArticlePrix());
            existingArticle.setArticleQuantiteEnStock(article.getArticleQuantiteEnStock());
            existingArticle.setCommande(article.getCommande());
            existingArticle.setCategorie(article.getCategorie());
            existingArticle.setVente(article.getVente());

            // Enregistrer les modifications dans la base de données
            return articleRepository.save(existingArticle);
        } else {
            // Si l'article n'existe pas, retourner null ou gérer l'erreur selon votre cas
            return null;
        }
    }
}
