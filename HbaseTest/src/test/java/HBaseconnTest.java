import com.imooc.bigdata.hbase.api.Hbaseconn;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by dell on 2020/8/10.
 */
public class HBaseconnTest {

    @Test
    public  void getconnTest(){
        Connection  connection = Hbaseconn.getHBaseConn();
        System.out.println("connection is closed:"+connection.isClosed());
        Hbaseconn.closeConn();
        System.out.println(connection.isClosed());
    }



}
