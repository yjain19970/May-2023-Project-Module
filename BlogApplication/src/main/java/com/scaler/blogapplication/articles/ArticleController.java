package com.scaler.blogapplication.articles;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @GetMapping("")
    ResponseEntity<String> getAllArticles(){

        return ResponseEntity.ok("All Articles"); // No need of Authentication here.
    }

    @PostMapping("") // need authentication  here.
    ResponseEntity<String> createArticle(@RequestBody ArticleDTO articleDTO){

        return ResponseEntity.ok("Article created Successfully~");
    }
}
