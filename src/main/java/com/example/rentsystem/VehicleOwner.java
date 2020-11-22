package com.example.rentsystem;

import javax.persistence.*;

@Entity
@Table(name = "vehicle_owner")
public class VehicleOwner {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

//    @JoinColumn()
    private int user_id;
    private String email;
    private String location;
    private String joined_date;
    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public String getJoined_date() {
        return joined_date;
    }
    public void setJoined_date(String joined_date) {
        this.joined_date = joined_date;
    }
}