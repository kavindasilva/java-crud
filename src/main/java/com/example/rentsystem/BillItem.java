//package com.example.rentsystem;
//
///**
// * Reference: https://www.logicbig.com/tutorials/java-ee-tutorial/jpa/one-to-many-foreign-key-mapping.html
// */
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import org.hibernate.annotations.OnDelete;
//import org.hibernate.annotations.OnDeleteAction;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.util.Objects;
//
//@Entity // This tells Hibernate to make a table out of this class
//@Table(name = "bill_item")
////public class BillItem implements Serializable {
//public class BillItem implements Serializable{
//    @Id
//    @GeneratedValue(strategy=GenerationType.IDENTITY)
//    private Integer bill_item_id;
////    private String item_batch; // not used
//    private int bill_id; // fk
//    private Double qty;
//
////    @ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
////    @JoinColumn(name="item", insertable = false, updatable = false, referencedColumnName = "item_id")
//
////    @JoinColumn(nullable = true, name = "item")
////    @ManyToOne(optional = true)
////    private Item item;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "item", nullable = true)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    private Item item;
//
//    @JsonIgnore
//    public Item getItem() {
//        return item;
//    }
//    @JsonIgnore
//    public void setItem(Item item) {
//        this.item = item;
//    }
////    public void setItem(int item) {
////        Optional<Item> this.item = itemRepository.findById(item);
////    }
//
//
//    public Integer getBill_item_id() {
//        return bill_item_id;
//    }
//    public void setBill_item_id(Integer id) {
//        this.bill_item_id = id;
//    }
//
//    public Double getQty() {
//        return qty;
//    }
//    public void setQty(Double qty) {
//        this.qty = qty;
//    }
//
//    public int getBill_id() {
//        return bill_id;
//    }
//    public void setBill_id(int bill_id) {
//        this.bill_id = bill_id;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if ( this == o ) {
//            return true;
//        }
//        if ( o == null || getClass() != o.getClass() ) {
//            return false;
//        }
//        BillItem phone = (BillItem) o;
//        return Objects.equals( bill_item_id, phone.bill_item_id );
//    }
//
//    public String toString(){
//        return "{ bill_item_id: "+this.bill_item_id+"," +
//                "bill_id: "+this.bill_id+"," +
//                "quantity: "+this.qty+","+
////                "item: "+this.item+
////                "item: "+this.item.toString()+
//                " }";
//    }
//}