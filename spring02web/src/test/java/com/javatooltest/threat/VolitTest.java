package com.javatooltest.threat;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by dell on 2020/7/30.
 */
public class VolitTest {

      private  volatile   static int INIT_VALUE=0;

      private final  static  int MAX_LIMT=3;

   private static  volatile  Boolean flg = false;


    // 1.new Thread(() -> { 需要实现的方法}).start();    内部类实现方式
    public  static  void  main(String[] args) throws InterruptedException {
        new Thread(() -> {
            System.out.println("-------------" + flg);
            while (true) {

                if (!flg) {
                    INIT_VALUE++;
                    System.out.println("生产者存数据" + INIT_VALUE);
                    if (INIT_VALUE > 5) {
                        flg = true;
                    }
                }
            }


        }, "Thread-001").start();


        new Thread(() -> {
            System.out.println("-----2-------" + INIT_VALUE);

            while (true) {
                if (flg) {
                    INIT_VALUE--;
                    System.out.println("---->开始消费" + INIT_VALUE);
                    if (INIT_VALUE < 3) {
                        flg = false;
                    }
                }

            }


        }, "Thread-002").start();

        Thread.sleep(1000);
    }
}
