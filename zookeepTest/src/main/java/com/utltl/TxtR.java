package com.utltl;

import org.apache.commons.lang.StringUtils;

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
            String encoding = "GBK";
            File file = new File(filePath);
            if ((file.isFile()) && (file.exists())) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    if (StringUtils.isNotEmpty(lineTxt)) {
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
        String path="d:\\workbook\\"+file+"\\"+file+".txt";

        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path, true)));

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

    public static void method1(String file, String conent)
    {
        FileWriter fw = null;
        try
        {
            File f = new File(file);
            fw = new FileWriter(f, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter pw = new PrintWriter(fw);
        pw.println(conent);
        pw.flush();
        try {
            fw.flush();
            pw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void method3(String filename, String conent)  {
        FileWriter fw = null;
        String path="d:\\workbook\\"+filename+".txt";
        File file = new File(path);
        if(file.exists()){
            file.delete();
            System.out.println("文件存在删除！");
        }
        try {
            fw = new FileWriter(file, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter pw = new PrintWriter(fw);
        pw.println(conent);
        pw.flush();
        try {
            fw.flush();
            pw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }



    public static void method31(String filename, String conent)  {
        FileWriter fw = null;
        String path="d:\\workbook\\"+filename+".txt";
        File file = new File(path);
//        if(file.exists()){
//            file.delete();
//            System.out.println("文件存在删除！");
//        }
        try {
            fw = new FileWriter(file, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter pw = new PrintWriter(fw);
        pw.println(conent);
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