package com.utltl.exceltool.excel4j.othertool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.regex.Pattern;

/**
 * @单位名称：科大国创—电信资源事业部
 * @创建人：hu.yunhui
 * @创建时间: on 2019/5/31.
 * @by: DELL)
 */
public class ExclesrcToollcheck {


    private final static Logger LOGGER = LoggerFactory.getLogger(ExclesrcToollcheck.class);


    /***
     * 对入参的变量进行是否sql注入判断
     * 适用 表名传入的场景下
     * @param tableName
     * @return
     */
    public static boolean isNotPramisSql(String tableName){
        String reg = "(?:')|(?:--)|(/\\*(?:.|[\\n\\r])*?\\*/)|"+
                "(\\b(select|update|union|and|or|delete|insert|trancate|char|into|substr|ascii|declare|exec|count|master|into|drop|execute)\\b)";
        Pattern sqlPattern = Pattern.compile(reg, Pattern.CASE_INSENSITIVE);
        if (sqlPattern.matcher(tableName).find()){
            LOGGER.error("未能通过的sql！！！警告sql注入了;" + tableName);
            return false;
        }
        return true;
    }



    public static String filenameFilter(String path) {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("a", "a");
        map.put("b", "b");
        map.put("c", "c");
        map.put("d", "d");
        map.put("e", "e");
        map.put("f", "f");
        map.put("g", "g");
        map.put("h", "h");
        map.put("i", "i");
        map.put("j", "j");
        map.put("k", "k");
        map.put("l", "l");
        map.put("m", "m");
        map.put("n", "n");
        map.put("o", "o");
        map.put("p", "p");
        map.put("q", "q");
        map.put("r", "r");
        map.put("s", "s");
        map.put("t", "t");
        map.put("u", "u");
        map.put("v", "v");
        map.put("w", "w");
        map.put("x", "x");
        map.put("y", "y");
        map.put("z", "z");

        map.put("A", "A");
        map.put("B", "B");
        map.put("C", "C");
        map.put("D", "D");
        map.put("E", "E");
        map.put("F", "F");
        map.put("G", "G");
        map.put("H", "H");
        map.put("I", "I");
        map.put("J", "J");
        map.put("K", "K");
        map.put("L", "L");
        map.put("M", "M");
        map.put("N", "N");
        map.put("O", "O");
        map.put("P", "P");
        map.put("Q", "Q");
        map.put("R", "R");
        map.put("S", "S");
        map.put("T", "T");
        map.put("U", "U");
        map.put("V", "V");
        map.put("W", "W");
        map.put("X", "X");
        map.put("Y", "Y");
        map.put("Z", "Z");

        map.put(":", ":");
        map.put("/", "/");
        map.put("\\", "\\");
        map.put(".", ".");
        map.put("-", "-");
        map.put("_", "_");

        map.put("0", "0");
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");
        map.put("5", "5");
        map.put("6", "6");
        map.put("7", "7");
        map.put("8", "8");
        map.put("9", "9");

//        StringBuilder temp = new StringBuilder();
//        for (int i = 0; i < path.length(); i++) {
//            String tmpStr = map.get(String.valueOf(path.charAt(i)));
//            if (tmpStr != null) {
//                temp.append(tmpStr);
////                temp += map.get(path.charAt(i) + "");
//            }
//        }
//
//        String resultPath = temp.toString();
//
//        if(resultPath.length() != path.length()){
//            LOGGER.error("发现路径操纵嫌疑：原路径{}，过滤后路径{}",path,resultPath);
//
//        }
//
//        return resultPath;

        String temp = new String();

        temp =   path.replace("*","").replace("？","").replace("?","").replace("../","./");
        String resultPath = temp.toString();
        return resultPath;

    }
}
