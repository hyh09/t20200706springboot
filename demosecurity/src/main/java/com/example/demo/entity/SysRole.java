package com.example.demo.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 * Created by dell on 2020/8/28.
 *
 * Caused by: org.hibernate.AnnotationException: No identifier specified for entity:
 * 要映入 javax 包下的
 */

@Entity
@Table(name="Sys_Role")
public class SysRole {

    @Id
    @GeneratedValue
    private Long id;
    private String name;


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


    @Override
    public String toString() {
        return "SysRole{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
