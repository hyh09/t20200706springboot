package com.demoweb.singleton;

/**
 * Created by dell on 2020/7/29.
 *
 * 单例的四种实现之 饿汉式
 */
public class SingLetonObject1 {

    private static final SingLetonObject1 instance = new SingLetonObject1();

    private SingLetonObject1() {
        System.out.println("创建饿汉式对象");//会发现两个线程进来的时候
    }


    public static SingLetonObject1 getInstance() {

        return instance;
    }
}
