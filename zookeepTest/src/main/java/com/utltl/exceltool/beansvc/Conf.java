package com.utltl.exceltool.beansvc;

import java.lang.annotation.*;

/**
 * Created by dell on 2020/8/21.
 *
 * 初始化默认值
 */
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Conf {
    String value() default "";
}