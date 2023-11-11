package com.atguigu05.communication.allenTest;

/**
 * ClassName: ProducerConsumerTest
 * Description: hanyu生产者消费者demo编写测试
 *
 * @ Author: Hanyuye
 * @ Date: 2023/11/11 21:36
 * @ Version: v1.0
 */
public class ProducerConsumerTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Consumer consumer = new Consumer(clerk);
        consumer.setName("消费者");
        Produce produce = new Produce(clerk);
        produce.setName("生产者");

        consumer.start();
        produce.start();
    }
}

class Clerk {
    private int productNum;

    //增加产品数量方法
    public synchronized void addProductNum() {
        while(true){
            if (productNum >= 20) {
                try {
                    wait();//wait(): Object 方法；线程一旦执行此方法，就进入等待状态。同时，会释放对同步监视器的调用
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
                productNum++;
                System.out.println(Thread.currentThread().getName() + "生产了产品，产品号为：" + productNum);
                notify();//一旦执行此方法，就会唤醒被wait()的线程中优先级最高的那一个线程。（如果被wait()的多个线程的优先级相同，则
//            随机唤醒一个）。被唤醒的线程从当初被wait的位置继续执行。
            }
        }
    }

    //减少产品数量方法
    public synchronized void reduceProduct() {
        while (true) {
            if (productNum <= 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + "消费了产品，产品号为：" + productNum);
                productNum--;
                notify();

            }
        }
    }

}

class Produce extends Thread {
    private Clerk clerk;

    public Produce(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        clerk.addProductNum();
    }
}

class Consumer extends Thread {
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        clerk.reduceProduct();
    }
}
