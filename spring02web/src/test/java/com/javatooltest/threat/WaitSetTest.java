package com.javatooltest.threat;

import org.junit.Test;

/**
 * Created by dell on 2020/7/30.
 */
public class WaitSetTest {

  static   volatile  Boolean flg =false;

    private static final Object obj = new Object();

    public  void wark(){
        synchronized (obj) {
            System.out.println("1线程的名称："+Thread.currentThread().getName()+"+线程启动+");

            try {
                System.out.println("1线程的名称："+Thread.currentThread().getName()+"+线程wait+");

                obj.wait();
                System.out.println("1线程的名称："+Thread.currentThread().getName()+"+线程wait end+");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("1线程的名称："+Thread.currentThread().getName()+"+线程结束+");
         //   obj.notify();//主线程等待
            flg=true;
            System.out.println("===>"+flg);
            synchronized (WaitSetTest.class) {//这里也是一样
                WaitSetTest.class.notify();//主线程等待
            }
            System.out.println("1线程的名称："+Thread.currentThread().getName()+"+notify+");


        }

    }


    @Test
    public  void Test1() throws InterruptedException {
        System.out.println("===================="+Thread.currentThread().getName());
        new Thread(new T1(), "线程一").start();

        //Thread.sleep(2000);
        new Thread(new T2()).start();
     // Thread.sleep(5000);
        while (!flg) {
            System.out.println("===>"+flg);
               try {

                    synchronized (WaitSetTest.class) {//这里也是一样
                        WaitSetTest.class.wait();//主线程等待
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }




        System.out.println("====================");

    }

     class  T1 implements  Runnable{

        @Override
        public void run() {
            wark();
        }
    }

    class  T2 implements  Runnable{

        @Override
        public void run() {
            synchronized (obj) {
                  System.out.println("2线程的名称："+Thread.currentThread().getName()+"+notify线程启动+");

                    obj.notify();
                    System.out.println("2线程的名称："+Thread.currentThread().getName()+"+notify end+");

//           try{
//               Thread.sleep(2000);
//           } catch (InterruptedException e) {
//               e.printStackTrace();
//           }

                System.out.println("2线程的名称："+Thread.currentThread().getName()+"+notify线程结束+");

            }
        }
    }



}
