package com.imooc.bigdata.hbase.api;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Table;

import java.io.IOException;

/**
 * Created by dell on 2020/8/10.
 * 用于Hbase的数据库链接  --java
 */
public class Hbaseconn {

    private static final Hbaseconn INSTANCE = new Hbaseconn();

    private static Configuration configuration; //hbase配置
    private static Connection connection; //hbase connection


    private  Hbaseconn() {
        try{
            if (configuration==null){
                configuration = HBaseConfiguration.create();
                configuration.set("hbase.zookeeper.quorum","92.168.146.200::2181");
                //configuration.set
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    /**
     * 获取链接
     * @return
     */
    private  Connection getConnection(){
        if (connection==null || connection.isClosed()){
            try{
                connection = ConnectionFactory.createConnection(configuration);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return connection;
    }

    // 提供外部调用的获取链接
    public static Connection getHBaseConn(){
        return INSTANCE.getConnection();
    }
    public static Table getTable(String tableName) throws IOException {
        return INSTANCE.getConnection().getTable(TableName.valueOf(tableName));
    }
    public static void closeConn(){
        if (connection!=null){
            try {
                connection.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
