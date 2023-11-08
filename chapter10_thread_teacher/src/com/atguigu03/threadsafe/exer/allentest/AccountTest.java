package com.atguigu03.threadsafe.exer.allentest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ClassName: AccountTest
 * Description:
 *
 * @Author hanyuye
 * @Create 2023/11/8 11:01
 * @Version 1.0
 * @IDE idea_mac_m1
 */
public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account();
        Customer customer1 = new Customer(account, "客户1");
        Customer customer2 = new Customer(account, "客户2");

        customer1.start();
        customer2.start();

    }
}
class Account{
    private double balance;//余额

    public double getbalance(){
        return balance;
    }

    public void setbalance(double balance){
        this.balance = balance;
    }

    public synchronized void deposit(){
        balance += 1000;
        System.out.println(Thread.currentThread().getName() + "==========存入1000=======" + "余额为：" + balance);
    }

}
class Customer extends Thread{
    Account account;


    public Customer(Account account, String threadName){
        super(threadName);
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i <3; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            account.deposit();
        }

//        synchronized (Customer.class){
//            for (int i = 0; i < 3; i++) {
//                double balance = account.getbalance();
//                balance += 1000;
//                account.setbalance(balance);
//                System.out.println(Thread.currentThread().getName() + "==========存入1000=======" + "余额为：" + balance);
//            }
//        }
    }
}
