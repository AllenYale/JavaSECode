package com.atguigu03.threadsafe.notsafe.allentest;

/**
 * ClassName: SellTicketTest2
 * Description:
 *
 * @Author hanyuye
 * @Create 2023/11/8 09:36
 * @Version 1.0
 * @IDE idea_mac_m1
 */
class SellTicket2 implements Runnable{
    private int ticketNum = 100;
    boolean flag = true;
    @Override
    public void run() {
        while(flag){
            /*
            //使用同步代码块
            synchronized (this){
                if(ticketNum>0){
                    System.out.println(Thread.currentThread().getName() + " - 卖出一张票，票号为：" + ticketNum);
                    ticketNum --;
                }else {
                    break;
                }
            }*/
            sell();
        }
    }

    //同步方法
    private synchronized void sell(){
        if(ticketNum>0){
            System.out.println(Thread.currentThread().getName() + " - 卖出一张票，票号为：" + ticketNum);
            ticketNum --;
        }else{
            flag = false;
        }
    }
}

public class SellTicketTest2 {
    public static void main(String[] args) {
        SellTicket2 sellTicket2 = new SellTicket2();

        Thread t1 = new Thread(sellTicket2);
        Thread t2 = new Thread(sellTicket2);
        Thread t3 = new Thread(sellTicket2);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();

    }
}
