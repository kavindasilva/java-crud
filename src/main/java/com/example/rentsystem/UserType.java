package com.example.rentsystem;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_type")
public class UserType implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private String type;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}