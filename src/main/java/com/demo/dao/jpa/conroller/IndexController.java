package com.demo.dao.jpa.conroller;

import com.demo.dao.daointerface.RoleDao;
import com.demo.dao.daointerface.UserRepository;
import com.demo.dao.entity.Role;
import com.demo.dao.entity.User;
import com.demo.dao.service.MysqlUserService;
import com.demo.dao.svc.UserSvc;
//import com.sun.istack.internal.logging.Logger;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * Created by dell on 2020/7/7.
 */
@RestController
public class IndexController {

    private static Logger logger = Logger.getLogger(IndexController.class);

    @Autowired
    private RoleDao roleDao;


    @Autowired
    private UserRepository userRepository;


    @Autowired
    private UserSvc userSvc;

    @RequestMapping("/jpaFindUser")
    public  User jpaIndex(String name) {
           logger.info("入参为："+name);
           if(StringUtils.isEmpty(name)){
               return  null;
           }
           name = "%"+name+"%";
        return    userRepository.findByNameLike(name);
    }



    @RequestMapping("/user")
    public  String  init(){
        userSvc.ininData();
        userSvc.findPage();
        System.out.println("=====");
        return  "======";
    }




}
