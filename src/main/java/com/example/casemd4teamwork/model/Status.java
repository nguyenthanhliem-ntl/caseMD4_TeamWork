package com.example.casemd4teamwork.model;

import javax.persistence.*;

@Entity
@Table(name = "status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name_Status;

    @ManyToOne(targetEntity = Home.class)
    @JoinColumn(name = "home_id")
    private Home home;

    public Status(String name_Status, Home home) {
        this.name_Status = name_Status;
        this.home = home;
    }

    public Status() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName_Status() {
        return name_Status;
    }

    public void setName_Status(String name_Status) {
        this.name_Status = name_Status;
    }

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }
}
