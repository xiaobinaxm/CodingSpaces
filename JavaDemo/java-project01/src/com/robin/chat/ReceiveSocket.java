package com.robin.chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @Description
 * @Author Robin
 * @Date 2019/10/2 19:48
 */
public class ReceiveSocket implements Runnable {
    private DatagramSocket ds;

    public ReceiveSocket(DatagramSocket ds) {
        this.ds = ds;
    }

    @Override
    public void run() {

        while (true){

            try {
                //创建接收数据接收池(数据包)
                byte[] bytes = new byte[1024];
                DatagramPacket dp = new DatagramPacket(bytes,bytes.length);
                //接收数据
                ds.receive(dp);
                //解析数据
                String ip = dp.getAddress().getHostAddress();
                byte[] data = dp.getData();
                int len = dp.getLength();
                String s = new String(data, 0, len);
                System.out.println("from " + ip + "data is" + s);


            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}
