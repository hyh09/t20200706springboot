package com.javatooltest.threat;

import com.demoweb.singleton.SingLetonObject1;

import java.util.concurrent.*;

/**
 * Created by dell on 2020/7/28.
 */
public class Test02 implements Callable<SingLetonObject1> {

     @Override
    public SingLetonObject1 call() throws Exception {
        return SingLetonObject1.getInstance();
    }
}




