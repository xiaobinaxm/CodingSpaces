package com.robin.testaction;

import com.robin.test.MyThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description
 * @Author Robin
 * @Date 2019/10/2 12:58
 */
public class Executor {
    public static void main(String[] args) {
        //创建线程池对象，控制要创建的几个线程对象
        ExecutorService pool = Executors.newFixedThreadPool(2);

        //pool可以执行Runnable和Callable线程对象
       // pool.submit(new MyThread());
        //pool.submit(new MyThread());

        pool.submit(new myCall());
        pool.submit(new myCall());

        pool.shutdown();

    }

}


class myThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}


class myCall implements Callable {

    @Override
    public Object call() throws Exception {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
        return null;
    }
}
