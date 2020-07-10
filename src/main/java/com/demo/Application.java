package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dell on 2020/7/6.
 */
@EnableJpaRepositories("com.demo.dao.daointerface")
@EntityScan(basePackages = "com.demo.dao.entity")

@SpringBootApplication
//@RestController
public class Application {

    public  static  void main(String[] args){
        SpringApplication.run(Application.class,args);
    }


//    @RequestMapping("/")
//    public  String home(){
//        return  "hello";
//    }


}
