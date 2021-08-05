package com.example.casemd4teamwork.model;

import javax.persistence.*;

@Entity
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String image;

    @ManyToOne(targetEntity = Home.class)
    @JoinColumn(name = "home_id")
    private Home home;

}
