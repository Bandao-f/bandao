package com.ccsu.service.impl;

import com.ccsu.common.Article;
import com.ccsu.dal.ArticleMapper;
import com.ccsu.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

    ArticleMapper articleMapper;

    @Autowired
    public ArticleServiceImpl(ArticleMapper userMapper) {
        this.articleMapper = userMapper;
    }
    @Override
    public void saveArticle(Article article) {
        articleMapper.createArticle(article);
    }

    @Override
    public Article getArticleById(int id) {
        return articleMapper.getArticleById((long) id);
    }

    @Override
    public List<Article> getArticlesByType(Integer type) {
        return articleMapper.getArticlesByType(type);
    }
}
