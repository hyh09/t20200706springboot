package com.sinovate.ngrms.gcbscsvr.das.support.Utils;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.*;

/**
 * @author liu.heng
 * @date 2015/9/4 17:02
 * @desc
 * @see
 */
public class BeanMapUtils {

    protected static final Logger LOGGER = LoggerFactory.getLogger(BeanMapUtils.class);

    /**
     * bean转为map
     * @param thisObj
     * @return
     */

    public static Map<String, Object> getValue(Object thisObj)
    {
        Field[] sFields = thisObj.getClass().getDeclaredFields();
        Method sGetMethod;
        Object sValue = null;
        Map<String,Object> attrsMap = new HashMap<String,Object>();
        String getMethodName;
        Map<String, Object> map = null;
        for (Field f : sFields) {
            if("serialVersionUID".equals(f.getName()) || f.getName().startsWith("COL") || f.getName().startsWith("TABLE")){
                continue;
            }
            getMethodName = getGetMethodName(f.getName());
            try {
                sGetMethod =  thisObj.getClass().getMethod(getMethodName);
                sValue = sGetMethod.invoke(thisObj);
            }catch(NoSuchMethodException e) {
                LOGGER.debug("源类中不包含" + getMethodName +"方法，请检查该类！");
            }catch(IllegalAccessException e){
                LOGGER.debug("源类" + getMethodName +"方法调用异常，请检查该类！");
            }catch(InvocationTargetException e1) {
                LOGGER.debug("源类" + getMethodName +"方法调用异常，请检查该类！");
            }
            if ((f.getName().contains("Map")) && "java.util.Map".equals(f.getType().getName())) {
                map = (Map)sValue;
                continue;
            }
            //所有的属性及值的对应关系都存放在attrsMap中
            attrsMap.put(f.getName(), sValue);
        }
        if(map != null && map.size() > 0){
            attrsMap.putAll(map);
        }
        return attrsMap;
    }

    /**
     * map转为bean
     * @param map
     * @param clazz
     */
    public static<T> T setValue(Map<String,Object> map, Class<T> clazz)
    {
        if( null == map )		{
            LOGGER.warn("map转换为类时，map为空，直接返回null值！");
            return null;
        }
        T obj = ClassUtil.createBean(clazz);
        if( null == obj )			{
            LOGGER.warn("根据clazz创建对象失败，导致map2Object返回null值！");
            return null;
        }

        List<String> directSetFieldNames = new ArrayList<String>();
        Map<String,Object> tempMap = new HashMap<String,Object>();
        Field mapField = null;

        //获取对象所有属性
        List<Field> fields = FieldUtil.getAllFields(clazz);
        String fieldName;
        String fieldTypeSimpleName;
        for( Field field : fields ) {
            if ((field.getName().contains("Map")) && "java.util.Map".equals(field.getType().getName())) {
                //如果对象属性为Map类型，记录下此属性，暂不赋值
                mapField = field;
            }else{
                fieldName = field.getName();
                fieldTypeSimpleName = field.getType().getSimpleName();
                if("String".equals(fieldTypeSimpleName))
                    try {
                        FieldUtil.setFieldValue(obj, field, map.get(fieldName));
                    } catch (Exception e) {
//                        LOGGER.warn("结果集给对象字段【" + fieldName + "】赋值失败：" + e.getMessage());
                    }
                else if("Double".equals(fieldTypeSimpleName))
                    try {
                        FieldUtil.setFieldValue(obj, field, map.get(fieldName) == null?null: Double.valueOf(map.get(fieldName).toString()));
                    } catch (Exception e) {
//                        LOGGER.warn("结果集给对象字段【" + fieldName + "】赋值失败：" + e.getMessage());
                    }
                else if("BigInteger".equals(fieldTypeSimpleName))
                    try {
                        FieldUtil.setFieldValue(obj, field, map.get(fieldName) == null ? null : new BigInteger(map.get(fieldName).toString()));
                    } catch (Exception e) {
//                        LOGGER.warn("结果集给对象字段【" + fieldName + "】赋值失败：" + e.getMessage());
                    }
                else if("Integer".equals(fieldTypeSimpleName))
                    try {
                        FieldUtil.setFieldValue(obj, field,  map.get(fieldName) == null?null: Integer.valueOf(map.get(fieldName).toString()));
                    } catch (Exception e) {
//                        LOGGER.warn("结果集给对象字段【" + fieldName + "】赋值失败：" + e.getMessage());
                    }
                else if("Date".equals(fieldTypeSimpleName))
                    try {
                        FieldUtil.setFieldValue(obj, field, map.get(fieldName) == null?null:(Date)map.get(fieldName));
                    } catch (Exception e) {
//                        LOGGER.warn("结果集给对象字段【" + fieldName + "】赋值失败：" + e.getMessage());
                    }
                else if("Long".equals(fieldTypeSimpleName))
                    try {
                        FieldUtil.setFieldValue(obj, field, map.get(fieldName) == null?null: Long.valueOf(map.get(fieldName).toString()));
                    } catch (Exception e) {
//                        LOGGER.warn("结果集给对象字段【" + fieldName + "】赋值失败：" + e.getMessage());
                    }
                else if("Boolean".equals(fieldTypeSimpleName))
                    try {
                        FieldUtil.setFieldValue(obj, field, map.get(fieldName) == null?null:(Boolean)map.get(fieldName));
                    } catch (Exception e) {
//                        LOGGER.warn("结果集给对象字段【" + fieldName + "】赋值失败：" + e.getMessage());
                    }
            }
//                FieldUtil.setFieldValue(obj, field, map.get(field.getName()));
                //记录下直接赋值的属性名
                directSetFieldNames.add(field.getName());
        }
        //是否存在直接赋值的属性，true存在，false不存在
        boolean directSetFieldExist = CollectionUtils.isNotEmpty(directSetFieldNames);

        Set<Map.Entry<String, Object>> entrySet = map.entrySet();
        boolean addFlag;
        for(Map.Entry<String, Object> entry : entrySet){
            addFlag = true;
            //如果存在直接赋值的属性
            if(directSetFieldExist){
                for(String attr : directSetFieldNames){
                    if(attr.equals(entry.getKey())){
                        //如果已经直接赋值，此处忽略
                        addFlag = false;
                        break;
                    }
                }
            }
            //没有直接赋值的属性加入tempMap
            if(addFlag){
                tempMap.put(entry.getKey(), entry.getValue());
            }
        }
        //tempMap加入到对象的map属性中
        FieldUtil.setFieldValue(obj, mapField, tempMap);
        return obj;
    }

    public static void setMethod(Object method, Object value , Object thisObj)
    {
        Class c;
        try
        {
            c = Class.forName(thisObj.getClass().getName());
            String met = (String) method;
            met = met.trim();
            if (!met.substring(0, 1).equals(met.substring(0, 1).toUpperCase()))
            {
                met = met.substring(0, 1).toUpperCase() + met.substring(1);
            }
            if (!String.valueOf(method).startsWith("set"))
            {
                met = "set" + met;
            }
            Class types[] = new Class[1];
            types[0] = Class.forName("java.lang.String");
            Method m = c.getMethod(met, types);
            m.invoke(thisObj, value);
        } catch (Exception e)
        {
            LOGGER.error("获取和执行setter方法失败！");
        }
    }

    private static String getGetMethodName(String fieldName) {
        return "get" + fieldName.substring(0, 1).toUpperCase()+ fieldName.substring(1);
    }
    private static String getSetMethodName(String fieldName) {
        return "set" + fieldName.substring(0, 1).toUpperCase()+ fieldName.substring(1);
    }
}
