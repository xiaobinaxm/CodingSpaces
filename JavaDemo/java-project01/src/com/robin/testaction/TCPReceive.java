package com.robin.testaction;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description
 * @Author Robin
 * @Date 2019/10/2 20:16
 */
public class TCPReceive {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8989);

        Socket s = ss.accept();

        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

        String line = null;
        while ((line = br.readLine()) != null){
            System.out.println(line);
        }

        //给出反馈
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        bw.write("数据上传完毕");
        bw.newLine();
        bw.flush();

        br.close();
        s.close();
    }





//    public static void main(String[] args) throws IOException {
//        ServerSocket ss = new ServerSocket(999);
//
//        Socket s = ss.accept();
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
//        String line = null;
//        while ((line = br.readLine()) != null){
//            System.out.println(line);
//        }
//
//        s.close();
//
//
//    }






//    public static void main(String[] args) throws IOException {
//        //获取接收端Socket对象
//        ServerSocket ss = new ServerSocket(12306);
//        //监听客户端连接，返回一个Socket对象
//        Socket accept = ss.accept();
//        //获取输入流，读取数据，在控制台显示
//        InputStream is = accept.getInputStream();
//
//        byte[] bytes = new byte[1024];
//        int len = is.read(bytes);
//        String s = new String(bytes, 0, len);
//        String address = accept.getInetAddress().getHostAddress();
//
//        System.out.println("from" + address + "data is :" + s);
//
//        accept.close();
//
//    }
}
