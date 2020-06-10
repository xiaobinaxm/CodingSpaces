package com.robin.testaction;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @Description
 * @Author Robin
 * @Date 2019/10/2 20:16
 */
public class TCPSend {

    public static void main(String[] args) throws IOException {
        Socket s = new Socket(InetAddress.getByName("192.168.1.103"),8989);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//采用穿上文件的方式，效果会更加好的

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        String line = null;
        while ((line = br.readLine()) != null){
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        //Socket提供的一个终止
        s.shutdownOutput();

        //接收反馈
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String s1 = bufferedReader.readLine();
        System.out.println(s1);

        br.close();
        s.close();

    }





//    public static void main(String[] args) throws IOException {
//        Socket s = new Socket(InetAddress.getByName("Robin-pc"),999);
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
//        String line = null;
//        while ((line = br.readLine()) != null){
//            if ("over".equals(line)){//人为的创建一个结束条件
//                break;
//            }
//            bw.write(line);
//            bw.newLine();
//            bw.flush();
//        }
//        s.close();
//
//    }






//    public static void main(String[] args) throws IOException {
//        //创建发送端的Socket对象
//        Socket s = new Socket("192.168.1.103",12306);
//        //获取输出流写数据
//        OutputStream os = s.getOutputStream();
//        os.write("Hello TCP boys ,I'm coming...".getBytes());
//        //发送数据
//
//        //关闭资源
//        s.close();
//    }
}
