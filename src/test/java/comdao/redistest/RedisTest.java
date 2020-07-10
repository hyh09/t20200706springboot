package comdao.redistest;

import com.demo.dao.config.RedisConfig;
import com.demo.dao.entity.Deparment;
import com.demo.dao.entity.Role;
import com.demo.dao.entity.User;
import com.demo.reidsdao.redissvc.UserRedis;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by dell on 2020/7/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RedisConfig.class, UserRedis.class})
public class RedisTest {
    private  static Logger logger  = LoggerFactory.getLogger(RedisTest.class);


    @Autowired
    private  UserRedis userRedis;

    @Test
    public  void setup(){
        Deparment  deparment = new Deparment();
        deparment.setName("开发部");

        Role  role = new Role();
        role.setName("admin");

        User  user = new User();
        user.setName("孙悟空");
        user.setCreateDate(new Date());
        user.setDeparment(deparment);
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        user.setRoles(roles);
        String key =this.getClass().getName()+":userByName:"+user.getName();
        userRedis.delete(key);
        userRedis.add(key,10l,user);
       User user1= userRedis.getuserbykey(key);
       logger.info("===>"+user1);

    }


//    @Test
//    public  void  get(){
//        String key =this.getClass().getName()+":userByName:"+user.getName();
//
//    }
















}
