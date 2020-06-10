package com.robin.testaction;

import org.junit.Test;

import java.io.IOException;
import java.net.*;

/**
 * @Description
 * @Author Robin
 * @Date 2019/10/2 17:36
 */
public class UDPSend {

    public static void main(String[] args) throws IOException {
        //穿件发送端网络套接字Socket
        DatagramSocket ds = new DatagramSocket();
        //创建数据包
        byte[] bytes = "Hello UDP boys ,I'm coming...".getBytes();
        int length = bytes.length;
        InetAddress address = InetAddress.getByName("Robin-pc");
        int port = 10086;
        DatagramPacket dp = new DatagramPacket(bytes,length,address,port);

        //发送
        ds.send(dp);
        //释放资源
        ds.close();

    }

//    static int getLength(Object array)
//    以 int 形式返回指定数组对象的长度。
//    int length()
//    返回此字符序列的长度。

//    length;数据的长度
//    lenght();指定字符序列长度
//    size();集合的长度方法





 /*   public static void main(String[] args) throws IOException {
        //创建发送端Socket对象
        DatagramSocket ds = new DatagramSocket();
        //创建发送端数据包
        byte[] bytes = "Hello udp boy ,i'm coming....".getBytes();
        int length = bytes.length;
        InetAddress address = InetAddress.getByName("192.168.1.103");
        int port = 10086;
        DatagramPacket dp = new DatagramPacket(bytes,length,address,port);

        //发送数据
        ds.send(dp);

        //释放资源
        ds.close();
    }


    @Test
    public void acceptSocket() throws IOException {
        //创建接收端Socket对象
        DatagramSocket ds = new DatagramSocket(10086);
        //创建接收端数据包(接受容器)
        byte[] bytes = new byte[1024];
        int length = bytes.length;
        DatagramPacket dp = new DatagramPacket(bytes,length);
        //接受数据，阻塞式
        ds.receive(dp);
        //接收对象，并解析数据，打印到控制台
        String address = dp.getAddress().getHostAddress();
        int port = dp.getPort();
        byte[] data = dp.getData();
        int length1 = data.length;
        System.out.println(new String(data,0,length1));

        //关闭资源
        ds.close();

    }
*/

}
