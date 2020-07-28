package com.javatooltest.threat;

import java.util.concurrent.*;

/**
 * Created by dell on 2020/7/28.
 */
public class Test0003 {

    public  static  void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService  executorService = Executors.newCachedThreadPool();
        Future<String> future =executorService.submit(new TaskFuture());
        System.out.println("主线程开始执行");
       String result =   future.get();
       System.out.println("4result :"+result);

    }

}

class  TaskFuture implements Callable<String>{

    @Override
    public String call() throws Exception {
        System.out.println("1正在执行任务,需要等待5秒时间,执行任务开始");
        Thread.sleep(5000);//5秒时间，
        System.out.println("2正在执行任务,需要等待5秒时间，执行任务结束");
        return "余胜军";
    }
}


























