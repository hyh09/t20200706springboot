package com.utltl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.util.StringUtils;

/**
 * Created by dell on 2020/8/21.
 */
public class Stringtool {



    /**
     * 首字母大写
     * @param letter
     * @return
     */
    public static  String upperFirstLatter2(String letter){
        if(StringUtils.isEmpty(letter)){
            return  letter;
        }
        return letter.substring(0, 1).toUpperCase()+letter.substring(1);
    }

    /**
     * 格式化输出JSON字符串的--- 使用阿里的FastJson
     */
    public  static  String formatbyFastJson(String jsonString){
//        JSONObject object = JSONObject.parseObject(jsonString);
//        String pretty = JSON.toJSONString(object, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue,
//                SerializerFeature.WriteDateUseDateFormat);

//        JSONObject object = JSONObject.parseObject(jsonString);
//
//        String pretty = JSON.toJSONString(object, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
//        return  pretty;
      return   formatJson(jsonString);
    }

    public static String formatJson(String content) {

        StringBuffer sb = new StringBuffer();
        int index = 0;
        int count = 0;
        while(index < content.length()){
            char ch = content.charAt(index);
            if(ch == '{' || ch == '['){
                sb.append(ch);
                sb.append('\n');
                count++;
                for (int i = 0; i < count; i++) {
                    sb.append('\t');
                }
            }
            else if(ch == '}' || ch == ']'){
                sb.append('\n');
                count--;
                for (int i = 0; i < count; i++) {
                    sb.append('\t');
                }
                sb.append(ch);
            }
            else if(ch == ','){
                sb.append(ch);
                sb.append('\n');
                for (int i = 0; i < count; i++) {
                    sb.append('\t');
                }
            }
            else {
                sb.append(ch);
            }
            index ++;
        }
        return sb.toString();
    }
}
