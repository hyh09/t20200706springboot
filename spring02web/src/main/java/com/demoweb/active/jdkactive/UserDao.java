package com.demoweb.active.jdkactive;

/**
 * Created by dell on 2020/7/28.
 */
public class UserDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("已经保存数据...");
    }
}
