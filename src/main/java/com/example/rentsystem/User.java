package com.example.rentsystem;

/**
 * Reference: https://www.logicbig.com/tutorials/java-ee-tutorial/jpa/one-to-many-foreign-key-mapping.html
 */

//import jdk.nashorn.internal.objects.annotations.Getter;
//import jdk.nashorn.internal.objects.annotations.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private int cashier;
    private String bill_time; // mysql datetime
    private Double bill_total;
    


}