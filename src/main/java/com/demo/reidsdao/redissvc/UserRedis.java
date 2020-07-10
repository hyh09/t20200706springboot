package com.demo.reidsdao.redissvc;

import com.demo.dao.entity.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import com.sun.istack.internal.logging.Logger;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by dell on 2020/7/8.
 */
@Repository
public class UserRedis {

    private  Logger  logger = Logger.getLogger(UserRedis.class);


    @Autowired
    private RedisTemplate<String,String> redisTemplate;



    public  void add(String key,Long time, User user){
        logger.info("===user==="+user);
        Gson  gson  = new Gson();
        String strvalur = gson.toJson(user);
        logger.info("===toJson(User)===="+strvalur);

        /**
         * 设置 key 的值为 value
         * 其它规则与 set(K key, V value)一样
         * @param key 不能为空
         * @param value 设置的值
         * @param timeout 设置过期的时间
         * @param unit 时间单位。不能为空
         * @see <a href="http://redis.io/commands/setex">Redis Documentation: SETEX</a>
         */
        redisTemplate.opsForValue().set(key,strvalur,time, TimeUnit.MINUTES);

    }



    public  void add(String key,Long time,List<User> userList){
        Gson   gson = new Gson();
        redisTemplate.opsForValue().set(key,gson.toJson(userList),time,TimeUnit.MINUTES);
    }


    /**
     * 根据key查询valure
     */
    public  User  getuserbykey(String key){
        Gson  gson = new Gson();
        User  user = null;
      String  userJson=  redisTemplate.opsForValue().get(key);
      if(!StringUtils.isEmpty(userJson)){
          user =  gson.fromJson(userJson,User.class);
      }
      return  user;

    }


    /**
     * 返回一个list
     */
    public  List<User>  getUserList(String key){
        Gson   gson = new Gson();
        List<User>  users = null;
        String  userList = redisTemplate.opsForValue().get(key);
        if(!StringUtils.isEmpty(userList)){
            users =gson.fromJson(userList,new TypeToken<List<User>>(){}.getType());
        }
        return  users;
    }


    /**
     * 删除
     */

     public  void  delete(String key){
         redisTemplate.opsForValue().getOperations().delete(key);
     }








}
