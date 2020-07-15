//package com.demo.dao.mongo.controller;
//
//import com.demo.dao.entity.mondoentity.User;
//import com.sun.istack.internal.logging.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import  org.springframework.data.mongodb.core.query.Query;
//import java.util.Date;
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * Created by dell on 2020/7/13.
// */
//@RestController
//public class MongoConterller {
//
//    private static Logger logger = Logger.getLogger(MongoConterller.class);
//
//
//    //    @SuppressWarnings("SpringJavaAutowiringInspection")
////    @Autowired
////    private UserRepository userRepository;
//
//    @Autowired
//    private MongoTemplate mongoTemplate;
//
//
//    @RequestMapping("/mongo1")
//    public   User  jpaFindUser(){
//        Set<String> roles = new HashSet<>();
//        roles.add("manger");
//        User user = new User("1","user","12345678","44444@qq.com",new Date(),roles);
//        logger.info("====>"+user);
//        mongoTemplate.save(user);
//        Query  query = new Query(Criteria.where("userName").is("user"));
//        User  users=    mongoTemplate.findOne(query,User.class);
//        return  users;
//
//    }
//}
