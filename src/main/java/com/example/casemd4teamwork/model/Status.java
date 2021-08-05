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
}
