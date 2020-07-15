//package com.demo.dao.config;
//
//import com.mongodb.Mongo;
//import com.mongodb.MongoClient;
//import com.mongodb.MongoCredential;
//import com.mongodb.ServerAddress;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
//import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by dell on 2020/7/10.
// */
//
//@Configuration
//@EnableMongoRepositories(basePackages = "com.demo.dao.daointerface.mongsvc")
//@PropertySource("classpath:test.properties")
//
//public class TestDataMongodaConfig  extends AbstractMongoConfiguration {
//
//    @Autowired  private Environment environment;
//
//    @Override
//    protected String getDatabaseName() {
//       String mongoname= environment.getRequiredProperty("mongo.name");
//       System.out.println("======>"+mongoname);
//        return mongoname;
//    }
//
//    @Bean
//    @Override
//    public Mongo mongo() throws Exception {
//        ServerAddress  serverAddress = new ServerAddress(environment.getRequiredProperty("mongo.port"));
//        List<MongoCredential> credentialList = new ArrayList<>();
//        return new MongoClient(serverAddress,credentialList);
//    }
//}
