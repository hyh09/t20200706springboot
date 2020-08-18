package com.imooc.bigdata.phoenix;

import java.sql.*;

/**
 * Created by dell on 2020/8/17.
 */
public class PhoenixTest {
    public  static  void main(String[] args) throws  Exception {
        Class.forName("org.apache.phoenix.jdbc.PhoenixDriver");
        String url = "jdbc:phoenix:192.168.146.200:2181";
        Connection conn = DriverManager.getConnection(url);
        String sql="select *  from  PERSION ";
        PreparedStatement  preparedStatement =  conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
             System.out.println(resultSet.getString("NAME")+"===>"+resultSet.getString("AGE"));
            System.out.println("=================="+resultSet.getString("ID"));

        }
        preparedStatement.close();
        conn.close();
       // Connection connetion=
    }
}
