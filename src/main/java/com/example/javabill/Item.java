package com.example.javabill;

/**
 * Reference: https://www.logicbig.com/tutorials/java-ee-tutorial/jpa/one-to-many-foreign-key-mapping.html
 */

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int item_id;

//    @OneToMany()
//    @JoinColumn(name="item_batch")
//    @Id
    @Column(unique = true, name = "item_batch")
    private String item_batch;

    private String item_name;
    private double buy_price;
    private double sell_price;

    public int getItem_id() {
        return item_id;
    }
    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getItem_batch() {
        return item_batch;
    }
    public void setItem_batch(String item_batch) {
        this.item_batch = item_batch;
    }

    public String getItem_name() {
        return item_name;
    }
    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public double getBuy_price() {
        return buy_price;
    }
    public void setBuy_price(double buy_price) {
        this.buy_price = buy_price;
    }

    public double getSell_price() {
        return sell_price;
    }
    public void setSell_price(double sell_price) {
        this.sell_price = sell_price;
    }

    public String toString(){
        return "item: {id: "+this.item_id+", batch:"+this.item_batch+", name:"+this.item_name+" }";
    }

}