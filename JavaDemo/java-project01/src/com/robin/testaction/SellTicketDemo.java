package com.robin.testaction;

/**
 * @Description
 * @Author Robin
 * @Date 2019/10/2 12:27
 */
public class SellTicketDemo {
    public static void main(String[] args) {
        //创建资源对象
        SellTicket st = new SellTicket();

        //创建3个线程
        Thread t1 = new Thread(st,"窗口1");
        Thread t2 = new Thread(st,"窗口2");
        Thread t3 = new Thread(st,"窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
