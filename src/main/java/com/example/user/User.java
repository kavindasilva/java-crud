package com.example.user;

/**
 * Reference: https://auth0.com/blog/implementing-jwt-authentication-on-spring-boot/
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.rentsystem.UserType;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String email;
    private String password;
    private String remember_token;
    private String created_at;
    private String updated_at;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_type", nullable = true)
    private UserType user_type;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return "<<password-hash-protected>>";
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getRemember_token() {
        return remember_token;
    }
    public void setRemember_token(String remember_token) {
        this.remember_token = remember_token;
    }

    public String getCreated_at() {
        return created_at;
    }
    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }
    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public UserType getUser_type() {
        return user_type;
    }
    public void setUser_type(UserType user_type) {
        this.user_type = user_type;
    }

//    public String toString(){
//        return " {}";
//    }
}