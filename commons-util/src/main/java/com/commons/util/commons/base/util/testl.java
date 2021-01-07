package com.commons.util.commons.base.util;

import java.math.BigDecimal;

/**
 * @author cxk
 * @date 2021/1/6 9:18
 */
public class testl {
    public static void main(String[] args) {
        BigDecimal price=new BigDecimal("1.0294555");
        BigDecimal c=new BigDecimal("1");
        price = price.multiply(c).setScale(2,BigDecimal.ROUND_FLOOR);
        System.out.println(price);
    }

}
