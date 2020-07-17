//package com.demo.dao.config.eno4jcof;
//
//import org.neo4j.ogm.session.SessionFactory;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.neo4j.config.Neo4jConfiguration;
//import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
//import org.springframework.data.neo4j.server.Neo4jServer;
//import org.springframework.data.neo4j.server.RemoteServer;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
///**
// * Created by dell on 2020/7/16.
// */
//@Configuration
//@EnableTransactionManagement
//@EnableNeo4jRepositories(basePackages = {"com.demo.dao.daointerface.neo4jsvc"})
//public class Eeo4jConfig  extends Neo4jConfiguration {
//    @Override
//    public Neo4jServer neo4jServer() {
//        String url="http://192.168.146.200:7474";
//        String  username="neo4j";
//        String password="1234567";
//
//        return new RemoteServer(url,username,password);
//    }
//
//    @Override
//    public SessionFactory getSessionFactory() {
//        return new SessionFactory("com.demo.dao.config.eno4jcof");
//    }
//}
