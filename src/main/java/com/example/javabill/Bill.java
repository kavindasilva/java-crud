package com.example.javabill;

/**
 * Reference: https://www.logicbig.com/tutorials/java-ee-tutorial/jpa/one-to-many-foreign-key-mapping.html
 */

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    @OneToMany(
//            mappedBy = "bill",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
    )
    @JoinColumn(name="bill_id")
    private List<BillItem> items = new ArrayList<>();

    public void setItems(List<BillItem> it){
        this.items = it;
    }
    public List<BillItem> getItems(){
        return this.items;
    }


}