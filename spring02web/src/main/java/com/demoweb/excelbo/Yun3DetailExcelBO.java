package com.demoweb.excelbo;

import java.io.Serializable;

/**
 * Created by dell on 2020/8/12.
 */
public class Yun3DetailExcelBO implements Serializable{

   // 省份	规划主机用户	密码
    private  String  province;

    private  String userName;

    private  String  password;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Yun3DetailExcelBO{" +
                "province='" + province + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
