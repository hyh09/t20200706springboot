package com.javatooltest;

import java.util.List;

/**
 * Created by dell on 2020/8/12.
 */
public class BoExcelBo {

    private String active;

    private  String host;

    private List<String> stringList;

    //添加一个Excel的命令
    private String ssh;


    public String getSsh() {
        return ssh;
    }

    public void setSsh(String ssh) {
        this.ssh = ssh;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }


    @Override
    public String toString() {
        return "BoExcelBo{" +
                "active='" + active + '\'' +
                ", host='" + host + '\'' +
                ", stringList=" + stringList +
                ", ssh='" + ssh + '\'' +
                '}';
    }
}
