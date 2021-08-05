package com.example.casemd4teamwork.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "không được để trống!")
    @Size(min = 2, max = 30, message = "độ dài ít nhất là 2 và không vượt quá 30 kí tự")
    @Column(unique = true, nullable = false)
    private String username;
    private String password;
    @Column(nullable = false)
    @NotEmpty(message = "Thiếu địa chỉ")
    private String address;
    @Column(nullable = false)
    @NotEmpty(message = "Sai số điện thoại")
    private String phoneNumber;
    private String fullName;
    private String email;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;

    public User() {
    }

    public User(String username, String password, String address, String phoneNumber, String fullName, String email, Collection<Role> roles) {
        this.username = username;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.fullName = fullName;
        this.email = email;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}
