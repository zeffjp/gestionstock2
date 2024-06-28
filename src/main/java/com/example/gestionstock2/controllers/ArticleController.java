package com.example.gestionstock2.controllers;

import com.example.gestionstock2.modele.Article;
import com.example.gestionstock2.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/read")
    public List<Article> getAll() {
        return articleService.getAll();
    }

    @PostMapping("/create")
    public Article create(@RequestBody Article article) {
        return articleService.createArticle(article);
    }

    @GetMapping("/read/{id}")
    public Optional<Article> getById(@PathVariable UUID id) {
        return articleService.getArticle(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable UUID id) {
        articleService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Article> update(@PathVariable UUID id, @RequestBody Article article) {
        Article updatedArticle = articleService.update(id, article);
        if (updatedArticle != null) {
            return ResponseEntity.ok(updatedArticle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
