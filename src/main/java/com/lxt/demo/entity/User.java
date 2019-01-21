package com.lxt.demo.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_user")
public class User implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String number;

//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", number='" + number + '\'' +
//                '}';
//    }

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public User setNumber(String number) {
        this.number = number;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
