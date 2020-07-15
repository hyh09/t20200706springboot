//package com.demo.dao.entity.mondoentity;
//
//import org.springframework.data.mongodb.core.index.Indexed;
//import org.springframework.data.mongodb.core.mapping.Document;
//
//import javax.persistence.Id;
//import javax.validation.constraints.NotNull;
//import java.util.Date;
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * Created by dell on 2020/7/10.
// * 操作mongodb的实体
// */
//@Document(collection = "user")
//public class User {
//
//    @Id
//    private  String userId;
//
//    @NotNull @Indexed(unique = true)
//    private  String userName;
//
//    @NotNull
//    private  String password;
//
//    @NotNull
//    private String name;
//    @NotNull
//    private  String email;
//    @NotNull
//    private Date  createDate =new Date();
//
//
//    private Set<String> roles = new HashSet<String>();
//
//    public User() {
//    }
//
//    public User(String userId, @NotNull String userName, @NotNull String password, @NotNull String name, @NotNull Date createDate, Set<String> roles) {
//        this.userId = userId;
//        this.userName = userName;
//        this.password = password;
//        this.name = name;
//        this.email = email;
//        this.createDate = createDate;
//        this.roles = roles;
//    }
//
//
//    public String getUserId() {
//        return userId;
//    }
//
//    public void setUserId(String userId) {
//        this.userId = userId;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public Date getCreateDate() {
//        return createDate;
//    }
//
//    public void setCreateDate(Date createDate) {
//        this.createDate = createDate;
//    }
//
//    public Set<String> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Set<String> roles) {
//        this.roles = roles;
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "userId='" + userId + '\'' +
//                ", userName='" + userName + '\'' +
//                ", password='" + password + '\'' +
//                ", name='" + name + '\'' +
//                ", email='" + email + '\'' +
//                ", createDate=" + createDate +
//                ", roles=" + roles +
//                '}';
//    }
//}
