package com.example.casemd4teamwork.model;



import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@SuppressWarnings("JpaAttributeTypeInspection")
@Entity
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private MultipartFile[] files;

    @ManyToOne(targetEntity = Home.class)
    @JoinColumn(name = "home_id")
    private Home home;

    public Image() {
    }

    public Image(Long id, String description, MultipartFile[] files, Home home) {
        this.id = id;
        this.description = description;
        this.files = files;
        this.home = home;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipartFile[] getFiles() {
        return files;
    }

    public void setFiles(MultipartFile[] files) {
        this.files = files;
    }

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }
}
