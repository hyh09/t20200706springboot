import org.apache.zookeeper.*;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by dell on 2020/8/24.
 */
public class ZooKeeper_GetChildren_API_Sync_Usage implements Watcher {

    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);
    private static ZooKeeper zk = null;

    public static void main (String[] args) throws Exception{

        String path = "/huangyi11";
        zk = new ZooKeeper("localhost:2181",
                5000,
                new ZooKeeper_GetChildren_API_Sync_Usage());
        connectedSemaphore.await();

        zk.create(path, "".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        zk.create(path+"/c1", "".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);

        List<String> childrenList = zk.getChildren(path, true);
        System.out.println("===>"+childrenList);

        zk.create(path+"/c2", "".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);

        Thread.sleep( Integer.MAX_VALUE);
    }

    /**
     * 回调方法
     * @param event  事件类型
     *
    事件类型:(znode节点相关的)
    EventType:NodeCreated            //节点创建
    EventType:NodeDataChanged        //节点的数据变更
    EventType:NodeChildrentChanged   //子节点下的数据变更
    EventType:NodeDeleted

    状态类型:(是跟客户端实例相关的)
    KeeperState:Disconneced        //连接失败
    KeeperState:SyncConnected	//连接成功
    KeeperState:AuthFailed         //认证失败
    KeeperState:Expired            //会话过期
     */
    public void process(WatchedEvent event) {
        //KeeperState 通知状态
        if (Watcher.Event.KeeperState.SyncConnected == event.getState()) {

            if (Event.EventType.None == event.getType() && null == event.getPath()) {
                connectedSemaphore.countDown();//
            } else if (event.getType() == Event.EventType.NodeChildrenChanged) {
                try {
                    System.out.println("ReGet Child===>:" + zk.getChildren(event.getPath(), true));
                } catch (Exception e) {}
            }
        }
    }
}
