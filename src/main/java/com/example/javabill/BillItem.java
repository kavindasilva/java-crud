package com.example.javabill;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "bill_item")
public class BillItem {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer bill_item_id;
    private String item_batch;
    private int bill_id; // fk
    private Double qty;


    public Integer getBill_item_id() {
        return bill_item_id;
    }
    public void setBill_item_id(Integer id) {
        this.bill_item_id = id;
    }

    public String getItem_batch() {
        return item_batch;
    }
    public void setItem_batch(String item_batch) {
        this.item_batch = item_batch;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "post_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Bill bill;
//    public int getBill_id() {
//        return bill_id;
//    }
//    public void setBill_id(int bill_id) {
//        this.bill_id = bill_id;
//    }

    public Double getQty() {
        return qty;
    }
    public void setQty(Double qty) {
        this.qty = qty;
    }


}