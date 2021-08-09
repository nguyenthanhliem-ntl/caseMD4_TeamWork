package com.example.casemd4teamwork.model;

import org.springframework.web.multipart.MultipartFile;

public class Form {

    private Long id;
    private MultipartFile image;

    private Home home;

    public Form() {
    }

    public Form(MultipartFile image, Home home) {
        this.image = image;
        this.home = home;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }
}