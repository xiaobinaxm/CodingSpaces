package com.robin.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @Description
 * @Author Robin
 * @Date 2019/10/2 19:47
 */
public class SendSocket implements Runnable {
    private DatagramSocket ds;

    public SendSocket(DatagramSocket ds) {
        this.ds = ds;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            while ((line = br.readLine()) != null){
                if ("886".equals(line)){
                    break;
                }
            }
            //封装数据
            byte[] bytes = line.getBytes();
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("192.168.1.103"), 12306);

            ds.send(packet);

            ds.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
