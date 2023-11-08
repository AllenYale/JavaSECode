package com.atguigu03.threadsafe.notsafe.allentest;

/**
 * ClassName: SellTicketTest
 * Description:
 *
 * @Author hanyuye
 * @Create 2023/11/8 09:29
 * @Version 1.0
 * @IDE idea_mac_m1
 */
class SellTicket extends Thread{
     private static int ticketNum = 100;
    @Override
    public void run() {
        /*
        //使用同步代码块
        //继承Thread类中，同步监视器，用Class对象是唯一的。this不是唯一的，因为会创建多个thread对象。
        synchronized(SellTicket.class){
            while (ticketNum>0){
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + " - 卖出一张票，票号为：" + ticketNum);
                ticketNum--;
            }
        }*/
        sell();
    }

    //使用同步方法，静态同步方法，同步监视器为：Class对象（当前类本身）
    private static synchronized void sell(){
        while (ticketNum>0){
            try {
                sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " - 卖出一张票，票号为：" + ticketNum);
            ticketNum--;
        }
    }
}

public class SellTicketTest {
    public static void main(String[] args) throws InterruptedException {
        SellTicket sellTicket1 = new SellTicket();
        SellTicket sellTicket2 = new SellTicket();
        SellTicket sellTicket3 = new SellTicket();
//        Thread t1 = new Thread(sellTicket);
//        Thread t2 = new Thread(sellTicket);
//        Thread t3 = new Thread(sellTicket);

        sellTicket1.setName("窗口1");
        sellTicket2.setName("窗口2");
        sellTicket3.setName("窗口3");
        //主线程sleep3 s
//        sellTicket1.sleep(3000);
        sellTicket1.start();
        sellTicket2.start();
        sellTicket3.start();

    }
}
