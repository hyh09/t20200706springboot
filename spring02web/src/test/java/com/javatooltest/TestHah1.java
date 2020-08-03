package com.javatooltest;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by dell on 2020/7/21.
 */
public class TestHah1 {
    /**
     * //评测题目: 请对指定的一段英文进行按单词进行逆转，
     // 比如：Hello world！逆转结果为：world Hello！
     // 又如：Hello everybody，I am just a simple example.
     // 逆转后为：everybody Hello, example simple a just am I.
     */

    public static void main(String[] args) {

        String str="hello world";

        StringBuffer sbf=new StringBuffer();

//字符串分割

        String [] arr=str.split(" ");

        for(int i=arr.length-1;i>=0;i--){

            sbf.append(arr[i]+" ");

        }

        System.out.println(sbf.toString());

    }


    @Test
    public  void Test1202(){
        String  str1="Hello everybody,I am just a simple example ";
        //1.先逗号分隔
        String[] split = str1.split(",");
        StringBuffer stringBuffer = new StringBuffer("");
        System.out.println("===>"+Arrays.toString(split));
        System.out.println("===>"+split.length);

        for(int i=0;i<split.length;i++){

            stringBuffer.append(Test12(split[i]+""));
        }
        System.out.print("===>"+stringBuffer);
//everybody Hello, example simple a just am I.
    }

    public  String Test12( String str){
        System.out.println("入参"+str);
       // String str="hello world";
        StringBuffer sbf=new StringBuffer();
        String [] arr=str.split(" ");
        for(int i=arr.length-1;i>=0;i--){
            sbf.append(arr[i]+" ");
        }
    System.out.println("===1>"+sbf.toString());
        return sbf.toString();

    }



}
