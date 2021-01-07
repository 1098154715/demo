package com.commons.util.commons.base.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author cxk
 * @date 2021/1/7 10:39
 */

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Token {
    boolean value() default false;
}
