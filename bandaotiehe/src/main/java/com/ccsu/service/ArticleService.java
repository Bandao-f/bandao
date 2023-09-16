package com.ccsu.service;

import com.ccsu.common.Article;

import java.util.List;

public interface ArticleService {
    public void saveArticle(Article article);
    public Article getArticleById(int id);
    public List<Article> getArticlesByType(Integer type);
}