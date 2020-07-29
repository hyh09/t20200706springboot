package com.demoweb.singleton;

/**
 * Created by dell on 2020/7/29.
 *
 *
 */
public class SingLetonObject2 {

    private static  SingLetonObject2 instance;

    private static   volatile int a=0;

  //  private  String str1;

    private SingLetonObject2() {
       // this.str1=str;
        a=a+1;
        System.out.println("创建饿汉式对象SingLetonObject2:===>"+a);//会发现两个线程进来的时候
    }

    /**
     * 性能差每次都要阻塞
     * @return
     */
//    public synchronized  static  SingLetonObject2  getInstance(){
//        if(null == instance){
//            instance = new SingLetonObject2();
//        }
//
//        return  instance;
//    }



 public   static  SingLetonObject2  getInstance(){
        if(null == instance){
            synchronized (SingLetonObject2.class){
                if(null ==instance){
                    instance = new SingLetonObject2();
                }
            }

        }

        return  instance;
    }






}
