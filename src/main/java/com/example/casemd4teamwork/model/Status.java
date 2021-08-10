package com.example.casemd4teamwork.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name_status;

    @OneToMany(targetEntity = Home.class)
    private List<Home> home;

    public Status() {
    }

    public Status(Integer id, String name_status, List<Home> home) {
        this.id = id;
        this.name_status = name_status;
        this.home = home;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName_status() {
        return name_status;
    }

    public void setName_status(String name_status) {
        this.name_status = name_status;
    }

    public List<Home> getHome() {
        return home;
    }

    public void setHome(List<Home> home) {
        this.home = home;
    }
}
