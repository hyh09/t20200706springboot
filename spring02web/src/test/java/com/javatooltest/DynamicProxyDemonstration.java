package com.javatooltest;

import com.demoweb.active.InvocationHandlerImpl;
import com.demoweb.active.jdkactive.IUserDao;
import com.demoweb.active.jdkactive.UserDao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by dell on 2020/7/28.
 */
public class DynamicProxyDemonstration {

    public  static  void  main(String[] args){
        //代理的真实对象
        IUserDao realSubject = new UserDao();

        InvocationHandler handler = new InvocationHandlerImpl(realSubject);
        ClassLoader loader = realSubject.getClass().getClassLoader();
        Class[] interfaces = realSubject.getClass().getInterfaces();

        IUserDao  subject = (IUserDao) Proxy.newProxyInstance(loader, interfaces, handler);
        System.out.println("动态代理对象的类型："+subject.getClass().getName());
        String hello = subject.SayHello("jiankunking");
        System.out.println(hello);


    }
}
