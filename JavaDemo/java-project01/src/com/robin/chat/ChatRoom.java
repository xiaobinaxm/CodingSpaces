package com.robin.chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @Description
 * @Author Robin
 * @Date 2019/10/2 19:42
 */
public class ChatRoom {
    public static void main(String[] args) throws IOException {
        DatagramSocket dsSend = new DatagramSocket();
        DatagramSocket dsReceive = new DatagramSocket(12306);

        SendSocket sendSocket = new SendSocket(dsSend);
        ReceiveSocket receiveSocket = new ReceiveSocket(dsReceive);

        Thread t1 = new Thread(sendSocket);
        Thread t2 = new Thread(receiveSocket);

        t1.start();
        t2.start();


    }
}
