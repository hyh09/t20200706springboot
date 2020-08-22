package com.utltl.exceltool.beansvc;

/**
 * Created by luyangran on 2019/8/27.
 */

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class JsonDateValueProcessor implements JsonValueProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonDateValueProcessor.class);

    private String format ="yyyy/MM/dd HH:mm:ss";

    public Object processArrayValue(Object value, JsonConfig config) {
        return process(value);
    }

    public Object processObjectValue(String key, Object value, JsonConfig config) {
        return process(value);
    }

    private Object process(Object value){

        if(value instanceof Date){
            SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.UK);
            return sdf.format(value);
        }

        if(value instanceof BigInteger){
            return value == null ? "" : value.toString();
        }
        return value == null ? "" : value.toString();
    }
}
