package com.example.javabill;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "bill")
public class Bill {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer bill_id;
    private int cashier;
    private String bill_time; // mysql datetime
    private Double bill_total;


    public Integer getBill_id() {
        return bill_id;
    }
    public void setBill_id(Integer id) {
        this.bill_id = id;
    }

    public int getCashier() {
        return cashier;
    }

    public void setCashier(int cashier) {
        this.cashier = cashier;
    }

    public String getBill_time() {
        return bill_time;
    }
    public void setBill_time(String bill_time) {
        this.bill_time = bill_time;
    }

    public Double getBill_total() {
        return bill_total;
    }
    public void setBill_total(Double bill_total) {
        this.bill_total = bill_total;
    }

}