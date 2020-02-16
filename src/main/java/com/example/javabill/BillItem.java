package com.example.javabill;

/**
 * Reference: https://www.logicbig.com/tutorials/java-ee-tutorial/jpa/one-to-many-foreign-key-mapping.html
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.SQLInsert;

import javax.persistence.*;
import java.io.Serializable;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "bill_item")
//public class BillItem implements Serializable {
public class BillItem{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer bill_item_id;
//    private String item_batch;
    private int bill_id; // fk
    private Double qty;

    @ManyToOne()
    @JoinColumn(name="item", insertable = false, updatable = false, referencedColumnName = "item_id")
    private Item item;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="item_batch", insertable = false, updatable = false, referencedColumnName = "item_batch")
//    private Item item_batch;

//    public Item getItemData() {
//        return itemData;
//    }
//    public void setItemData(Item itemData) {
//        this.itemData = itemData;
//    }



    public Item getItem() {
        return item;
    }
    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getBill_item_id() {
        return bill_item_id;
    }
    public void setBill_item_id(Integer id) {
        this.bill_item_id = id;
    }

//    public Item getItem_batch() {
//        return item_batch;
//    }
//    public void setItem_batch(Item item_batch) {
//        this.item_batch = item_batch;
//    }

    public Double getQty() {
        return qty;
    }
    public void setQty(Double qty) {
        this.qty = qty;
    }


}