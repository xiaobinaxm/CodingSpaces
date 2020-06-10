package com.robin.test;

/**
 * @Description 多线程问题
 * @Author Robin
 * @Date 2019/10/2 11:48
 */
public class MyThread extends Thread {

    //为了让多个线程对象访问同一个成员变量100张票，定义为静态
    private static int tickets = 100;
    public static void main(String[] args) {
        while (tickets>0){
            System.out.println(currentThread().getName()+"正在售出："+(tickets--)+"张票");
        }



//        Thread t1 = new Thread();
//        Thread t2 = new Thread();
//        t1.setName("robin");
//        t2.setName("Tony");
//
//        //设置守护线程
//        t1.setDaemon(true);
//        t2.setDaemon(true);
//
//        t1.start();
//        t2.start();
//
//        Thread.currentThread().setName("肖斌");
//        for (int i = 0; i < 10; i++) {
//            System.out.println(Thread.currentThread().getName());
//        }
//
//        System.out.println(currentThread().getName());
//        System.out.println(Thread.currentThread().getName());//最开始是main  而不是线程的名字，是因为没有启动线程
//
//        System.out.println();

    }
}
