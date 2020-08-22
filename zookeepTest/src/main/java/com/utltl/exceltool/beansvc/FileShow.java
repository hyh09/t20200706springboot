package com.utltl.exceltool.beansvc;

import java.lang.annotation.*;

/**
 * Created by dell on 2020/8/21.
 *
 * 用于文档的说明
 * 字段名称	技术字段名	数据类型	字段长度	是否必填	字段解释
 转固单据ID	ZGDJ	CHAR	255	必输	　

 */
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FileShow {
    //字段名称
    String fieldName() default "";



    String  datatype() default "";

    //字段长度
    //
    String fieldSize() default "";
    //是否必填
    String selectType() default "";
    //字段解释
    String notes() default "";



}