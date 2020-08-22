package com.demo.utilt;

import org.springframework.util.StringUtils;

/**
 * Created by dell on 2020/8/21.
 */
public class StrignUtil {

    /**
     * 首字母大写
     * @param letter
     * @return
     */
    public String upperFirstLatter2(String letter){
        if(StringUtils.isEmpty(letter)){
            return letter;
        }
        return letter.substring(0, 1).toUpperCase()+letter.substring(1);
    }
}
