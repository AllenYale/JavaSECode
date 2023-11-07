package com.atguigu11.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName: AllenAnnotationTest
 * Description:
 *
 * @Author hanyuye
 * @Create 2023/11/7 14:59
 * @Version 1.0
 * @IDE idea_mac_m1
 */
@Target({ElementType.TYPE,ElementType.FIELD,ElementType.CONSTRUCTOR,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AllenAnnotationTest {
    String value() default "allen";
}
