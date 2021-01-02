package com.example.vehicle;

import javax.persistence.*;

@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private String reg_no;
    private int owner_id; // @TODO: make a fk to owner table. until that default 1 (user_id 10)
    private String license_expiry_date;
    private String color;
    private String make;
    private String model;
    private String transmission;
    private boolean available;
    private boolean deleted;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_type", nullable = true)
//    private UserType user_type;


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getReg_no() {
        return reg_no;
    }
    public void setReg_no(String reg_no) {
        this.reg_no = reg_no;
    }

    public int getOwner_id() {
        return owner_id;
    }
    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public String getLicense_expiry_date() {
        return license_expiry_date;
    }
    public void setLicense_expiry_date(String license_expiry_date) {
        this.license_expiry_date = license_expiry_date;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public String getMake() {
        return make;
    }
    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public String getTransmission() {
        return transmission;
    }
    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public boolean isAvailable() {
        return available;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isDeleted() {
        return deleted;
    }
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}