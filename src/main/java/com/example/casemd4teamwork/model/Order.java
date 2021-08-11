package com.example.casemd4teamwork.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Home home;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date order_time;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date start_date;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date end_date;

    public Order() {
    }

    public Order(User user, Home home, Date order_time, Date start_date, Date end_date) {
        this.user = user;
        this.home = home;
        this.order_time = order_time;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }

    public Date getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Date order_time) {
        this.order_time = order_time;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }


}
