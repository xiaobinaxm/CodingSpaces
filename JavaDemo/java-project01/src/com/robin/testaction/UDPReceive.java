package com.robin.testaction;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

/**
 * @Description
 * @Author Robin
 * @Date 2019/10/2 18:04
 */
public class UDPReceive {
    public static void main(String[] args) throws IOException {
        //穿件接收端网络套接字Socket
        DatagramSocket ds = new DatagramSocket(10086);
        //创建接受容器
        byte[] bytes = new byte[1024];
        int length = bytes.length;
        DatagramPacket dp = new DatagramPacket(bytes,length);

        //接受数据，采用阻塞式
        ds.receive(dp);
        //解析接受回来的数据
        String address = dp.getAddress().getHostAddress();
        byte[] data = dp.getData();
        int len = dp.getLength();
        String s = new String(data, 0, len);//这个可以避免NullPointerException
        String s1 = Arrays.toString(bytes);//转后，任然是一个字符数组的样式存在

        System.out.println("从" + address + "获取的数据是：" + s);
        System.out.println("==============");
        System.out.println("从" + address + "获取的数据是：" + s1);


    }
}
