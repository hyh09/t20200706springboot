package com.javatooltest;

import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;

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
}
