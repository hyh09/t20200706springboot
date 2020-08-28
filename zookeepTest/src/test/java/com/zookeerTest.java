package com;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by dell on 2020/8/24.
 */
public class zookeerTest {

    /**
     * 集群连接地址
     */
    private static final String CONNECT_ADDR = "localhost:2181";

    /**
     * session超时时间
     */
    private static final int SESSION_OUTTIME = 2000;

    /**
     * 信号量,阻塞程序执行,用户等待zookeeper连接成功,发送成功信号，
     */
    private static final CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        ZooKeeper zk = new ZooKeeper(CONNECT_ADDR, SESSION_OUTTIME, new Watcher() {

            public void process(WatchedEvent event) {
                // 获取时间的状态
                Watcher.Event.KeeperState keeperState = event.getState();
                Event.EventType tventType = event.getType();
                // 如果是建立连接
                if (Event.KeeperState.SyncConnected == keeperState) {
                    if (Event.EventType.None == tventType) {
                        // 如果建立连接成功,则发送信号量,让后阻塞程序向下执行
                        countDownLatch.countDown();
                        System.out.println("zk 建立连接");
                    }
                }
            }

        });
        // 进行阻塞
        countDownLatch.await();
        //创建父节点
//		String result = zk.create("/testRott", "12245465".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//		System.out.println("result:" + result);
        //创建子节点
//        String result = zk.create("/test", "children 12245465".getBytes(),
//                ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//        System.out.println("result:"+result);
       List<String> stringList= zk.getChildren("/",true);
       for(String str:stringList){
           System.out.println("--->"+str);
       }
        zk.close();
    }



}
