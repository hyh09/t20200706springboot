package com.utltl.exceltool.excel4j;


//import com.alibaba.druid.util.StringUtils;

import com.alibaba.dubbo.common.utils.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2020/8/11.
 */

public class TxtR
{
    public static List<String> readTxtFile(String filePath)
    {
        List paramList = new ArrayList();
        try
        {
            String encoding = "UTF-8";//GBK
            File file = new File(filePath);
            if ((file.isFile()) && (file.exists())) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    if (!StringUtils.isEmpty(lineTxt)) {
                        paramList.add(lineTxt);
                    }
                    System.out.println("|" + lineTxt + "|");
                }
                read.close();
            } else {
                System.out.println("找不到指定文件！");
            }
            return paramList;
        } catch (Exception e) {
            System.out.println("读取文件内容错误");
            e.printStackTrace();
        }

        return null;
    }

    public static void method2(String file, String conent)
    {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));

            out.write(conent + "\r\n");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void method1()
    {
        FileWriter fw = null;
        try
        {
            File f = new File("E:\\dd.txt");
            fw = new FileWriter(f, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter pw = new PrintWriter(fw);
        pw.println("追加内容");
        pw.flush();
        try {
            fw.flush();
            pw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void fileChaseFW(String filePath, String content)
    {
        try
        {
            FileWriter fw = new FileWriter(filePath, true);
            fw.write(content);
            fw.close();
        } catch (IOException e) {
            System.out.println("文件写入失败！" + e);
        }
    }
}