package com.demo.dao.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by dell on 2020/7/6.
 */
@Entity
@Table(name = "user")
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private  String name ;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private   Date createDate;

     //多对一的情况
   @ManyToOne
   @JoinColumn(name = "did")
   @JsonBackReference
    private  Deparment deparment;


   @ManyToMany(cascade = {},fetch = FetchType.EAGER)
    @JoinTable(name="user_role",joinColumns = {@JoinColumn(name ="user_id")},
                inverseJoinColumns = {@JoinColumn(name = "roles_id")})
    private List<Role> roles;


    public User() {
    }


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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Deparment getDeparment() {
        return deparment;
    }

    public void setDeparment(Deparment deparment) {
        this.deparment = deparment;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createDate=" + createDate +
                ", deparment=" + deparment +
                ", roles=" + roles +
                '}';
    }
}
