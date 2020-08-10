package com.imooc.threatrunabl;

/**
 * Created by dell on 2020/8/10.
 *
 * 模拟取票窗口取票
 */
public class Runablesta  implements  Runnable {

    private  String name;

    /**
     * 使用static 实例化一次;
     * 但是static的生命周期很长，因为存在
     */
    private   static   int stacount=1;

    private  static final   int  maxcount=50;

    public Runablesta(String name) {
        this.name = name;
    }

    @Override
    public void run() {
            while (stacount <= maxcount) {
                    System.out.println("==>" + name + "==>" + (stacount++));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }
}
