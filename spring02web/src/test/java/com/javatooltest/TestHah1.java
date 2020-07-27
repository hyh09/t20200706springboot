package com.javatooltest;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by dell on 2020/7/21.
 */
public class TestHah1 {

    @Test
    public  void Test1(){
//        #hashMap允许空键值，而hashTable不允许
        HashMap  hashMap = new HashMap();
        hashMap.put(null,null);
        hashMap.put("1","1");
        System.out.println("====>"+hashMap);

       Hashtable   hashTable = new Hashtable();
       hashTable.put(null,null);
       hashTable.put("1","1");
        System.out.println("====>"+hashTable);


    }



    @Test
    public  void Test12(){
      //  List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, prov);
      System.out.print( genKey("41"));
    }


    private String genKey(String domain) {

        StringBuilder keyBuilder = new StringBuilder("");
        // 获得时间（8位），年月日（yyyyMMdd）
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        keyBuilder.append(sdf.format(new Date()));
        // 调度者被执行的时间（2位）
        keyBuilder.append("20");
        // 省编码（2位）
        keyBuilder.append(domain);

        return keyBuilder.toString();
    }
}
