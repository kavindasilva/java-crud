package com.example.rentsystem;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle_id;

    private String wheel4wd;
    private String options;
    private double rate_per_km;
    private double rate_per_day;


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

//    public Vehicle getVehicle_id() {
//        return vehicle_id;
//    }
//    public void setVehicle_id(Vehicle vehicle_id) {
//        this.vehicle_id = vehicle_id;
//    }

    public String getWheel4wd() {
        return wheel4wd;
    }
    public void setWheel4wd(String wheel4wd) {
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