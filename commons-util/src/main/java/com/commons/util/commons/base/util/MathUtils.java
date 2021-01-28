package com.commons.util.commons.base.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 数字工具类
 *
 * @author cxk
 * @date 2021/1/13 11:14
 */
public class MathUtils {

    /**
     * 求比例根据List<Integer>
     */
    public static String getScale(List<Integer> list) {

        //连续整数检测算法：
       Integer min=Collections.min(list, (o1, o2) -> {
           if(o1==0||o2==0){
               return 1;
           }
           return o1-o2;
       });

        for (int i = min; i > 0; i--) {
            boolean c = isMaxList(i, list);
            if (c) {
                min = i;
                break;
            }
        }
        Integer finalMin = min;
        List<Integer> collect = list.stream().map(num -> num / finalMin).collect(Collectors.toList());
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer str : collect) {
            stringBuilder.append(str + ":");
        }
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }

    private static boolean isMaxList(int i, List<Integer> list) {
        for (Integer num : list) {
            if (num!=0&&num % i != 0) {
                return false;
            }
        }
        return true;
    }
    //判断一个数是不是完全平方数
  public static Boolean pingfang(int num){
        for(int i=0;i<num/2;i++){
            if(i*i==num){
                return true;
            }
        }
        return false;
  }

    public static void main(String[] args) {

        for(int i=0;i<100;i++){
            if(pingfang(i)){
                System.out.print("平方数有："+i+"\t");
            }
        }
    }

}
