package com.imooc.threatrunabl;

import org.junit.Test;

/**
 * Created by dell on 2020/8/10.
 */
public class RunablestaTest {


     public  static  void  main(String[] args){

        Thread  thread1 = new Thread(new Runablesta("窗口1"));
        Thread  thread2 = new Thread(new Runablesta("窗口2"));
        Thread  thread3 = new Thread(new Runablesta("窗口3"));
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
