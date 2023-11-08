package com.atguigu02.method_lifecycle.exer.allentest;

/**
 * ClassName: HappyNewYesr
 * Description:
 *
 * @Author hanyuye
 * @Create 2023/11/8 10:49
 * @Version 1.0
 * @IDE idea_mac_m1
 */
public class HappyNewYesr {
    public static void main(String[] args) throws InterruptedException {
        for(int i =10;i>=0;i--){
            Thread.sleep(1000);
            if(i==0){
                System.out.println("Happpy New Year...");
            }else{
                System.out.println(i);
            }
        }
    }
}
