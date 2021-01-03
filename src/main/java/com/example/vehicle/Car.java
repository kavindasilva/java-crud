package com.example.vehicle;

import com.example.vehicle.Vehicle;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car extends Vehicle{
    @Id
    private Integer id; // this name should be same as Vehicle class's id field

    @Column(columnDefinition="tinyint(1) default 0")
    private boolean wheel4wd;

    @Lob
    private String options;
    private double rate_per_km;
    private double rate_per_day;


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getWheel4wd() {
        return wheel4wd;
    }
    public void setWheel4wd(boolean wheel4wd) {
        this.wheel4wd = wheel4wd;
    }

    public String getOptions() {
        return options;
    }
    public void setOptions(String options) {
        this.options = options;
    }

    public double getRate_per_km() {
        return rate_per_km;
    }
    public void setRate_per_km(double rate_per_km) {
        this.rate_per_km = rate_per_km;
    }

    public double getRate_per_day() {
        return rate_per_day;
    }
    public void setRate_per_day(double rate_per_day) {
        this.rate_per_day = rate_per_day;
    }
}