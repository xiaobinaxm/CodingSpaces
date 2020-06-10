package com.robin.testaction;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @Description
 * @Author Robin
 * @Date 2019/10/2 13:15
 */
public class MyTimerDemo {
    public static void main(String[] args) {
        Timer t = new Timer();
        t.schedule(new myTimerTask(),1000);
    }
}


class myTimerTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("beng，爆炸了。。。");
        System.exit(0);
    }

}