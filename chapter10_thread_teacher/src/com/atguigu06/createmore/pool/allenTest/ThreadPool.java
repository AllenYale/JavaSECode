package com.atguigu06.createmore.pool.allenTest;

import java.math.BigInteger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * ClassName: ThreadPool
 * Description:
 *
 * @ Author: Hanyuye
 * @ Date: 2023/11/11 22:33
 * @ Version: v1.0
 */
public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service = (ThreadPoolExecutor) executorService;

        service.setMaximumPoolSize(50);

        service.execute(new NumberThread());
        service.execute(new NumberThread2());

        //关闭连接池
        service.shutdown();
    }
}

class NumberThread implements Runnable{
    @Override
    public void run() {
        System.out.println(1111111);
    }
}

class NumberThread2 implements Runnable{
    BigInteger bigInteger = new BigInteger("122222222222222222222222");
    @Override
    public void run() {
        System.out.println(bigInteger);
    }
}
