package com.example.demo.aspect;

import java.lang.annotation.*;

/**
 * @Description: ServiceAnnotion
 * @Author ChenYang
 * @Date 2020/8/17   7:55 下午
 */
@Target(ElementType.METHOD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface ServiceAnnotation {
    String value() default "aaa";
}
