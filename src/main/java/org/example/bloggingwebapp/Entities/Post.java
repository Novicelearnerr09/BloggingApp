package org.example.bloggingwebapp.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Post {

    @Id
    @GeneratedValue
    private Long post_id;
    private String title;
    private String content;
    private String image;
    private Long user_id;

}
