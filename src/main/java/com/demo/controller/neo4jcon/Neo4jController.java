package com.demo.controller.neo4jcon;

import com.demo.dao.daointerface.neo4jsvc.UserRepository;
import com.demo.dao.entity.neo4jentity.base.UserNode;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dell on 2020/7/16.
 */

@RestController
public class Neo4jController {
    Logger logger = LoggerFactory.getLogger(Neo4jController.class);



    @Autowired
    @Qualifier(value = "UserNeo4jRepository")
    UserRepository userRepository;




    @RequestMapping("/creat1")
    public UserNode createUserNode(){

        System.out.println(userRepository);

        UserNode userNode = new UserNode();

        userNode.setName("xupan");

        userNode.setUserId("123");

        UserNode save = userRepository.save(userNode);

        logger.info(save.toString());
            return  save;

    }



    @RequestMapping("/neo4j/delete")
    public void delAll(){
       userRepository.deleteById(new Long(27));
    }
}
