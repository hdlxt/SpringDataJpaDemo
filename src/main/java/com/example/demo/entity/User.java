package com.example.demo.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * @author 刘小通
 * @Copy Right Information: 中科软科技股份有限公司
 * @Project: GTS4
 * @CreateDate: 2019/1/22 21:03
 * @history Sr Date Modified By Why & What is modified
 * 1.2019/1/22 刘小通 & new
 */
@Entity
@Table(name = "t_user")
public class User {


    private Long id;
    private String name;
    private String number;

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
