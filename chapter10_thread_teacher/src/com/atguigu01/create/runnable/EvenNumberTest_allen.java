package com.atguigu01.create.runnable;

/**
 * ClassName: EvenNumberTest_allen
 * Description:
 *
 * @ Author: Hanyuye
 * @ Date: 2023/11/7 23:03
 * @ Version: v1.0
 */
class EvenNumber implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 1) {
                System.out.println(Thread.currentThread().getName()+": "+i);
            }

        }
    }
}

public class EvenNumberTest_allen {
    public static void main(String[] args) {
        Thread thread = new Thread(new EvenNumber());
        thread.start();
    }

}
