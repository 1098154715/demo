package com.commons.util.commons.base.algorithm;

import cn.hutool.core.date.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 排序算法
 * @author cxk
 * @date 2021/2/19 16:27
 */
public class SortDemo {
   public static int[] arr=new int[]{19,2,22,33,26,2,44,75,84,33};

    /**
     * 插入排序
     * @param
     */
    public static void testInsert(){
        int indexnum;
        for(int i=0;i<arr.length-1;i++){
            indexnum=arr[i+1];
            int j=i;
            while (j>=0&&indexnum<arr[j]){
              arr[j+1]=arr[j];
              j--;
            }
            arr[j+1]=indexnum;
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 选择排序
     * @param
     */
    public static void select(){
        int num=arr[0];
        for(int i=0;i<arr.length;i++){
            num=arr[i];
            for(int j=i;j<arr.length;j++){
                if(num>arr[j]){
                    int temp= arr[j];
                    arr[j]=arr[i];
                    arr[i]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 冒泡排序
     * @param
     */
    public static void maopao(){

        for(int i=0;i<arr.length;i++){

            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public static List<String> monthList(String year){
        List<String> list=new ArrayList<>();
        for(int i=1;i<=12;i++){
            if(i<10){
                list.add(year+"-0"+i);
            }else {
                list.add(year+"-"+i);
            }

        }
        return list;
    }


    public static void main(String[] args) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String str1 = "2021-01-30 12:30:41";
        String str2 = "2021-03-30 12:30:41";
        String str3 = "2021-04-30 12:30:41";
        LocalDateTime d1 = LocalDateTime.parse(str1, df);
        LocalDateTime d2 = LocalDateTime.parse(str2, df);
        LocalDateTime d3 = LocalDateTime.parse(str3, df);
      boolean flag2=d2.isAfter(d1);
      boolean flag3=d2.isBefore(d3);

        System.out.println(d3);
        System.out.println(d3.minusMonths(1L));
        System.out.println(flag2);
        System.out.println(flag3);
        System.out.println(flag2&&flag3);


    }
}
