package zookeeper;

import org.apache.zookeeper.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * User: 张月忠
 * Date: 2017/8/6
 * Time: 下午1:43
 * To change this template use File | Settings | File Templates.
 */

public class ZooKeeperTest {

    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    private static final String zkUrl = "localhost:2181,127.0.0.1:2182,127.0.0.1:2183";
    private ZooKeeper zooKeeper = null;
    @Before
    public void initZooKeeper(){

        try {
            zooKeeper = new ZooKeeper(zkUrl, 1000, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    watchedEvent.getState();
                    if(Event.KeeperState.SyncConnected == watchedEvent.getState())
                        countDownLatch.countDown();
                }
            });
            countDownLatch.await();//等待连接成功
        }catch (Exception e){
            System.out.println("获取连接失败:"+e);
        }

    }

    @After
    public void  close(){
        try {
            zooKeeper.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testCreate(){

        try {
            //创建临时节点
            String path1 = zooKeeper.create("/zk_ephemeral", "临时节点".getBytes("UTF-8"), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            String path2 = zooKeeper.create("/zk_ephemeral", "临时节点".getBytes("UTF-8"), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);
            System.out.println("path1:"+path1);
            System.out.println("path2:"+path2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDelete() throws KeeperException, InterruptedException {
        zooKeeper.delete("/zk_ephemeral0000000005",-1);
    }
    @Test
    public void testGetData(){
       // zooKeeper.getData()
    }
}
