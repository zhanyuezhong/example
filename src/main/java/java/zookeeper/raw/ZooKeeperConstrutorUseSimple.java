package java.zookeeper.raw;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * User: 张月忠
 * Date: 2017/8/6
 * Time: 下午1:10
 * To change this template use File | Settings | File Templates.
 */

public class ZooKeeperConstrutorUseSimple implements Watcher{
    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    private static final String zkUrl = "localhost:2181,127.0.0.1:2182,127.0.0.1:2183";

    public static void main(String[] args) throws IOException, InterruptedException {

        ZooKeeper zooKeeper = new ZooKeeper(zkUrl,1000,new ZooKeeperConstrutorUseSimple());
        System.out.println("connecting ..."+zooKeeper.getState());
        countDownLatch.await();//等待连接成功
        System.out.println("connected ..."+zooKeeper.getState());

    }
    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println("received event:"+watchedEvent.getState());
        if(watchedEvent.getState() == Event.KeeperState.SyncConnected){
            //连接成功
            countDownLatch.countDown();

        }
    }
}
