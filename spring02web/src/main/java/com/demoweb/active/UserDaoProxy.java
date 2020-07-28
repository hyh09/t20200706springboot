package com.demoweb.active;

import com.demoweb.active.jdkactive.IUserDao;

/**
 * Created by dell on 2020/7/28.
 */
public class UserDaoProxy  implements IUserDao{
    private IUserDao target;

    public UserDaoProxy(IUserDao iuserDao) {
        this.target = iuserDao;
    }

    public void save() {
        System.out.println("开启事物...");
        target.save();
        System.out.println("关闭事物...");
    }

}
