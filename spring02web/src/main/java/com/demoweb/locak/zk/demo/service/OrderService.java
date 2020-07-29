package com.demoweb.locak.zk.demo.service;

import com.demoweb.locak.zk.demo.OrderNumGenerator;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by dell on 2020/7/27.
 */
public class OrderService implements  Runnable {

    private OrderNumGenerator orderNumGenerator = new OrderNumGenerator();

    // 使用lock锁
    private java.util.concurrent.locks.Lock lock = new ReentrantLock();

    @Override
    public void run() {
        getNumber();
    }

    public void getNumber() {
      //  try {
            lock.lock();
            String number = orderNumGenerator.getNumber();
            System.out.println(Thread.currentThread().getName() + ",生成订单ID:" + number);
     //   }

    }

    public static void main(String[] args) {
        System.out.println("####生成唯一订单号###");
        for (int i = 0; i < 100; i++) {
            new Thread(new OrderService()).start();
        }

    }




}
