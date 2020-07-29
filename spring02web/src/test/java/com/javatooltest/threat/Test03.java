package com.javatooltest.threat;

import com.demoweb.singleton.SingLetonObject1;
import com.demoweb.singleton.SingLetonObject2;

import java.util.concurrent.Callable;

/**
 * Created by dell on 2020/7/29.
 */
public class Test03 implements Callable<SingLetonObject2> {

//    private  String str;

//    public Test03(String str) {
//        this.str = str;
//    }

    public Test03() {
    }



    @Override
    public    SingLetonObject2 call() throws Exception {

        return SingLetonObject2.getInstance();
    }
}
