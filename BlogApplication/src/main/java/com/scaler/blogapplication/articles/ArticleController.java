package com.scaler.blogapplication.articles;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @GetMapping("")
    ResponseEntity<List<Article>> getAllArticles(){

        return null;
    }

    @PostMapping("")
    ResponseEntity<Article> createArticle(@RequestBody ArticleDTO articleDTO){
        return null;
    }
}
