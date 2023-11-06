package com.atguigu2.two.exer2;

import java.util.Scanner;

/**
 * ClassName: ArrayTestExer2
 * Description:
 *
 案例：输出英文星期几

 用一个数组，保存星期一到星期天的7个英语单词，从键盘输入1-7，显示对应的单词
 {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"}

 * @ Author: Hanyuye
 * @ Date: 2023/11/6 22:40
 * @ Version: v1.0
 */
public class ArrayTestExer2 {
    public static void main(String[] args) {
        String[] strArr = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数值（1-7）：");

        int nextInt = scanner.nextInt();
        if(nextInt>7||nextInt<1){
            System.out.println("wrong input number");
        }else {
            System.out.println(strArr[nextInt-1]);
        }

        scanner.close();
    }
}
