package com.example.too_all_recipe.Entity;

import jakarta.persistence.*;

@Entity
public class RecipeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private String filename;

    @Column
    private String filepath;




}
