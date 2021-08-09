package com.example.casemd4teamwork.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "home_time")
public class Home_Time {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Home home;

    private LocalDateTime first_time;

    private LocalDateTime last_time;

    @OneToOne
    private Status status;

    public Home_Time() {
    }

    public Home_Time(Home home, LocalDateTime first_time, LocalDateTime last_time, Status status) {
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

    public LocalDateTime getFirst_time() {
        return first_time;
    }

    public void setFirst_time(LocalDateTime first_time) {
        this.first_time = first_time;
    }

    public LocalDateTime getLast_time() {
        return last_time;
    }

    public void setLast_time(LocalDateTime last_time) {
        this.last_time = last_time;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
