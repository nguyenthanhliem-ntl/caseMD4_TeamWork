package com.example.casemd4teamwork.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "home_time")
public class Home_Time {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Home home;

    private Date first_time;

    private Date last_time;

    @ManyToOne
    private Status status;

    public Home_Time() {
    }

    public Home_Time(Home home, Date first_time, Date last_time, Status status) {
        this.home = home;
        this.first_time = first_time;
        this.last_time = last_time;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }

    public Date getFirst_time() {
        return first_time;
    }

    public void setFirst_time(Date first_time) {
        this.first_time = first_time;
    }

    public Date getLast_time() {
        return last_time;
    }

    public void setLast_time(Date last_time) {
        this.last_time = last_time;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
