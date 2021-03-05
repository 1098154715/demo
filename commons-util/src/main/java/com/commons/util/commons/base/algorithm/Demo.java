package com.commons.util.commons.base.algorithm;

/**
 * @author cxk
 * @date 2021/2/19 11:24
 */
public class Demo {
    /**
     * 题目：古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，
     * 假如兔子都不死，问每个月的兔子总数为多少？
     * 1 2 3 4 5  6  7 8 :
     * 1,1,2,3,5,8,13,21
     * */
    /**
    *请输入月份 num
    * */
    public static Integer test1(Integer num){
        return fib(num);
    }

    /**
     * 求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字。例如2+22+222+2222+22222(此时共有5个数相加)，几个数相加有键盘控制。
     * @param num
     * @return
     */
    public static long test2(Integer num){
        long total=0;
        long next=num;
        for(long i=0;i<5;i++){
            total+=next;
            System.out.println("第"+(i+1)+"次:"+total);
            next=next*10+num;

        }
       return total;
    }

    /**
     * 题目：一球从100米高度自由落下，每次落地后反跳回原高度的一半；再落下，求它在第10次落地时，共经过多少米？第10次反弹多高？
     * @param num
     * @return
     */
    public static double test3(double num){
        double total=100.0;
        for(int i=0;i<10;i++){
            System.out.println("第"+(i+1)+"次落地反弹："+num+"米！一共经过"+total);
            num=num/2.0;
            total+=2*num;

        }


        return total;
    }

    /**
     * 题目：输出9*9口诀。
     * @param
     * @return
     */
    public static void test4(){
        for(int i=1;i<=9;i++){
            for (int j = 1; j <=i ; j++) {
                System.out.print(j+"*"+i+"="+i*j+"\t");
            }
            System.out.println();
        }
    }

    /**
     * 题目猴子吃桃问题：猴子第一天摘下若干个桃子，当即吃了一半，还不瘾，又多吃了一个 第二天早上又将剩下的桃子吃掉一半，
     * 又多吃了一个。以后每天早上都吃了前一天  　　　　
     * 剩下的一半零一个。到第10天早上想再吃时，见只剩下一个桃子了。求第一天共摘了多少。
     * @param
     * @return
     */
    public static void test5(){
        int num=1;
        for(int i=1;i<=10;i++){
            System.out.println("第"+i+"天：猴子有"+num+"个");
            num=num*2+1;
        }
    }

    /**
     * 　题目：有一分数序列：2/1，3/2，5/3，8/5，13/8，21/13...求出这个数列的前20项之和。
     * @param
     * @return
     */
    public static void test6(){
        double num1=1.0,num2=2.0,total=0.0;
        for(int i=1;i<=20;i++){
            total+=num2/num1;
            System.out.println("第"+i+"次的计算结果为"+num2+"/"+num1+"："+total);
            double t=num1;
            num1=num2;
            num2=t+num2;
        }
    }

    /**
     * 　题目：有5个人坐在一起，问第五个人多少岁？他说比第4个人大2岁。
     * 问第4个人岁数，他说比第3个人大2岁。问第三个人，又说比第2人大两岁。问第2个人，说比第一个人大  　
     * 两岁。最后问第一个人，他说是10岁。请问第五个人多大？
     * @param
     * @return
     */
    public static Integer test8(Integer age){
      if(age==1){
          return 10;
      }
      age--;
      return test8(age)+2;
    }

    /**
     * 　题目：求1+2!+3!+...+20!的和
     * @param
     * @return
     */
    public static void test7(){
       long num=0;
        for(int i=1;i<=10;i++){
            long c=num111(i);
            num+=c;
            System.out.println(i+"!的阶层为："+c+"\t总和为："+num);

        }
    }

    /**
     * 求num的阶乘
     * @param num
     * @return
     */

    public static long num111(int num){
       if(num==1){
           return 1;
       }
        num--;
       return num111(num)*(num+1);
    }


    private static Integer fib(Integer num) {
       if(num==1||num==2){
           return 1;
       }
       return fib(num-1)+fib(num-2);
    }


    public static void main(String[] args) {
       /* for(int i=1; i<10;i++){
            System.out.println("第"+i+"月：一共有："+test1(i)+"只");
        }
       test2(1);
        System.out.println("------1----");
        test2(2);
        System.out.println("-----2-----");
       test2(3);
        System.out.println("----3------");
        test3(100);
        double a = 100;
        double sum = 100;

       test4();
       test5();
       test6();
       test7();*/
        Integer eger = test8(5);
        System.out.println(eger);

    }


}
