package com.demo.dao.entity;

import javax.persistence.*;

/**
 * Created by dell on 2020/7/6.
 */
@Entity
@Table(name = "deparment")
public class Deparment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private  String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Deparment() {
    }

    @Override
    public String toString() {
        return "Deparment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
