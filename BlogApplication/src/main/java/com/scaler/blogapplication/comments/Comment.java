package com.scaler.blogapplication.comments;


import com.scaler.blogapplication.articles.Article;
import com.scaler.blogapplication.commons.BaseEntity;
import com.scaler.blogapplication.users.Users;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "comments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comment extends BaseEntity {
    String title;
    String body;

    @ManyToOne
    Users author;
    @ManyToOne
    Article articleComment;
}
