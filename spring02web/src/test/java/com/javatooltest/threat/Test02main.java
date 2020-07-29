package com.javatooltest.threat;

import com.demoweb.singleton.SingLetonObject1;
import com.demoweb.singleton.SingLetonObject2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by dell on 2020/7/29.
 */
public  class  Test02main{
    public  static  void main(String[] args) throws ExecutionException, InterruptedException {
       //
        FutureTask<SingLetonObject2> futureTask1 = new FutureTask<SingLetonObject2>(new Test03());
        Thread t1 = new Thread(futureTask1,"name1");
        t1.start();
        FutureTask<SingLetonObject2> futureTask2 = new FutureTask<SingLetonObject2>(new Test03());
        Thread t2 = new Thread(futureTask2,"name2");
        t2.start();
        System.out.println("返回值："+futureTask1.get()+"===>"+t1.getName());
        System.out.println("返回值："+futureTask2.get()+"====>"+t2.getName());

        SingLetonObject2  object1=futureTask1.get();
        System.out.println("=object1==>"+object1);
        SingLetonObject2  object2=futureTask2.get();
        System.out.println("=object2==>"+object2);

        if(object1==object2){
            System.out.println("====================");
        }
        if(object1.equals(object2)){
            System.out.println("=========equese===========");
        }





    }
}
