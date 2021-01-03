package com.example.vehicle;

import javax.persistence.*;

@Entity
@Table(name = "lorry")
public class Lorry extends Vehicle{
    @Id
    private Integer id;

    @Lob
    private String options;

    private double lengthFt;
    private double rate_per_hour;
    private int wheels;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public double getLengthFt() {
        return lengthFt;
    }
    public void setLengthFt(double lengthFt) {
        this.lengthFt = lengthFt;
    }

    public String getOptions() {
        return options;
    }
    public void setOptions(String options) {
        this.options = options;
    }

    public double getRate_per_hour() {
        return rate_per_hour;
    }
    public void setRate_per_hour(double rate_per_hour) {
        this.rate_per_hour = rate_per_hour;
    }

    public int getWheels() {
        return wheels;
    }
    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

}