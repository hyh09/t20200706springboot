package com.demo.dao.jpa.conroller;

import com.demo.dao.entity.Deparment;
import com.demo.dao.entity.Role;
import com.demo.dao.entity.User;
import com.demo.reidsdao.redissvc.UserRedis;
//import com.sun.istack.internal.logging.Logger;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by dell on 2020/7/9.
 */

@RestController
public class RedisController {
    private Logger logger = Logger.getLogger(RedisController.class);


    @Autowired
    private UserRedis userRedis;

    @RequestMapping("/redis1")
    public  User setup(){
        Deparment deparment = new Deparment();
        deparment.setName("开发部");

        Role role = new Role();
        role.setName("admin");

        User user = new User();
        user.setName("孙悟空1");
        user.setCreateDate(new Date());
        user.setDeparment(deparment);
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        user.setRoles(roles);
        String key =this.getClass().getName()+":userByName:"+user.getName();
        logger.info("===key==>"+key);
        userRedis.delete(key);
        userRedis.add(key,10l,user);
        User user1= userRedis.getuserbykey(key);


        return user1;



    }

}
