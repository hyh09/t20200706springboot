package com.demo.dao.service;

import com.demo.dao.daointerface.DepartmentRepository;
import com.demo.dao.daointerface.RoleRepository;
import com.demo.dao.daointerface.UserRepository;
import com.demo.dao.entity.Deparment;
import com.demo.dao.entity.Role;
import com.demo.dao.entity.User;
import com.demo.dao.svc.UserSvc;
import com.sun.istack.internal.logging.Logger;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by dell on 2020/7/7.
 */
@Service
public class MysqlUserService implements UserSvc {

    private static Logger logger = Logger.getLogger(MysqlUserService.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private RoleRepository roleRepository;

    public void ininData() {
        userRepository.deleteAll();
        roleRepository.deleteAll();
        departmentRepository.deleteAll();

        Deparment deparment = new Deparment();
        deparment.setName("西游记部门");
        departmentRepository.save(deparment);

    //    Assert.assertNotNull(deparment.getId());


        Role roloe = new Role();
        roloe.setName("admin");
        roleRepository.save(roloe);
    //    Assert.assertNotNull(roloe.getId());

        User user = new User();
        user.setName("孙悟空");
        user.setCreateDate(new Date());
        user.setDeparment(deparment);
        List<Role> roles = roleRepository.findAll();
        logger.info("查询的结果:" + roles);

        user.setRoles(roles);
        userRepository.save(user);
    }


    public void findPage() {
        PageRequest pageable = new PageRequest(0, 10, new Sort(Sort.Direction.ASC, "id"));

        Page<User> page = userRepository.findAll(pageable);
        logger.info("page:" + page);
        for (User user : page.getContent()) {
            logger.info("======user=======user naem:{}" + user.getName());
        }

    }




}
