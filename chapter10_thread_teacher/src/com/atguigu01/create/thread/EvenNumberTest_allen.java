package com.atguigu01.create.thread;

/**
 * ClassName: EvenNumberTest_allen
 * Description:
 *
 * @ Author: Hanyuye
 * @ Date: 2023/11/7 22:31
 * @ Version: v1.0
 */
public class EvenNumberTest_allen {
    public static void main(String[] args) {
        EvenNumber evenNumber = new EvenNumber();
        evenNumber.start();

        for(int i=0;i<=10000;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+": "+i);
            }
        }

        new EvenNumber(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if(i%2==1){
                        System.out.println(i);
                    }
                }
            }
        }.start();
    }
}

class EvenNumber extends Thread{
    @Override
    public void run() {
        for(int i=0;i<=10000;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+": "+i);
            }
        }
    }
}
