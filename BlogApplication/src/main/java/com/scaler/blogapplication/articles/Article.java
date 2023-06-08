package com.scaler.blogapplication.articles;

import com.scaler.blogapplication.commons.BaseEntity;
import com.scaler.blogapplication.users.Users;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "articles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Article extends BaseEntity {
    String title;
    String slug;
    String subTitle;
    String body;

    @ManyToOne
    Users author;

}


