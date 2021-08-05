package com.example.casemd4teamwork.model;

import javax.persistence.*;

@Entity
@Table(name = "home")
public class Home {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String home_Name;

    private String type_Room;

    private String type_Home;

    private String address;

    private int num_Bedroom;

    private int num_Bathroom;

    private String description;

    private Long price;

    public Home() {
    }

    public Home(Long id, String home_Name, String type_Room, String type_Home, String address, int num_Bedroom, int num_Bathroom, String description, Long price) {
        this.id = id;
        this.home_Name = home_Name;
        this.type_Room = type_Room;
        this.type_Home = type_Home;
        this.address = address;
        this.num_Bedroom = num_Bedroom;
        this.num_Bathroom = num_Bathroom;
        this.description = description;
        this.price = price;
    }

    public Home(String home_Name, String type_Room, String type_Home, String address, int num_Bedroom, int num_Bathroom, String description, Long price) {
        this.home_Name = home_Name;
        this.type_Room = type_Room;
        this.type_Home = type_Home;
        this.address = address;
        this.num_Bedroom = num_Bedroom;
        this.num_Bathroom = num_Bathroom;
        this.description = description;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHome_Name() {
        return home_Name;
    }

    public void setHome_Name(String home_Name) {
        this.home_Name = home_Name;
    }

    public String getType_Room() {
        return type_Room;
    }

    public void setType_Room(String type_Room) {
        this.type_Room = type_Room;
    }

    public String getType_Home() {
        return type_Home;
    }

    public void setType_Home(String type_Home) {
        this.type_Home = type_Home;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNum_Bedroom() {
        return num_Bedroom;
    }

    public void setNum_Bedroom(int num_Bedroom) {
        this.num_Bedroom = num_Bedroom;
    }

    public int getNum_Bathroom() {
        return num_Bathroom;
    }

    public void setNum_Bathroom(int num_Bathroom) {
        this.num_Bathroom = num_Bathroom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
