package com.commons.util.commons.oos.service.customannotation;

import java.lang.annotation.*;

/**
 * @author cxk
 * @date 2021/2/19 11:07
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface LoginAuth {
    /**
     * 表示是否需要用户认证
     *
     * @return Boolean value.
     */
    boolean authorized() default false;
}
