package com.robin.testaction;

/**
 * @Description
 * @Author Robin
 * @Date 2019/10/2 12:21
 */
public class SellTicket implements Runnable {
    //定义票数
    private int tickets = 100;
    //定义锁对象
    private Object obj = new Object();


    @Override
    public void run() {
        while (true){
            //解决出现票数为负数的情况
            synchronized (obj){
                if (tickets>0){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"   ：正在售出的票数还剩："+(tickets--)+"张票了");
                }
                if (tickets == 0){
                    System.out.println(Thread.currentThread().getName() + "票已售罄，欢迎下次光临，谢谢！！！");
                    System.exit(0);
                }
            }
        }
    }
}
