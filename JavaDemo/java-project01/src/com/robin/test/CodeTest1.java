package com.robin.test;

import com.robin.pojo.Student;
import com.robin.pojo.Teacher;
import com.robin.dao.Inter;
import org.junit.Test;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description
 * @Author Robin
 * @Date 2019/9/28 13:32
 */
public class CodeTest1 {

    @Test
    public void test21(){
        File file = new File("E:\\test");
        delFile(file);
    }

    public static void delFile(File file){
        File[] files = file.listFiles();
        if (files != null && files.length != 0){
            for (File file1 : files){
                delFile(file1);
            }
        }
        System.out.println(file.getName());
        file.delete();
    }

    @Test
    public void test20(){
        int[] arr = {1,2,3,4};
        System.out.println(arr.length);

        char[] c = {'1','2','3'};
        System.out.println(c.length);

        String s = "hello";
        System.out.println(s.length());

        ArrayList list = new ArrayList();
        System.out.println(list.size());


//        注意区分一下区别：
//    length;数据的长度
//    length();指定字符序列长度
//    size();集合的长度方法
//    getLength();返回数组对象长度

    }

    @Test
    public void test19() throws UnknownHostException {
        //ArrayList<String> list = new ArrayList<>();
        //ArrayList<String> list1 = (ArrayList<String>) Collections.synchronizedList(list);

        //处理list集合的线程安全问题
        //Collections.synchronizedList(new ArrayList<>());

        Runtime rt = Runtime.getRuntime();

        InetAddress name = InetAddress.getByName("Robin-pc");
        byte[] address = name.getAddress();
        System.out.println(Arrays.toString(address));//[-64, -88, 1, 103]
        String hostAddress = name.getHostAddress();
        System.out.println(hostAddress);//192.168.1.103
    }

    @Test
    public void test18() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入一个字符串：");
        String s = br.readLine();
        System.out.println("你输入的字符串是：" + s);

        System.out.println("请输入一个数字：");
        s = br.readLine();
        int i = Integer.parseInt(s);
        System.out.println("你输入的数字是：" + i);


//        BufferedInputStream bif = new BufferedInputStream(new FileInputStream("e:/12.jpg"));
//        BufferedOutputStream bof = new BufferedOutputStream(new FileOutputStream("e:/man.jpg"));
//        byte[] bytes = new byte[1024];
//        int len = 0;
//        while ((len = bif.read(bytes)) != -1){
//            bof.write(bytes,0,len);
//        }
//        bof.close();
//        bif.close();



//        FileInputStream fis = new FileInputStream("e:/fos3.txt");
//        FileOutputStream fos = new FileOutputStream("e:/fos4.txt");
//        byte[] bytes = new byte[1024];
//        int len = 0;
//        while ((len = fis.read(bytes)) != -1){
//            fos.write(bytes,0,len);
//        }
//        fis.close();
//        fos.close();

//        String s = "我爱学些，学习使我快乐！";
//        byte[] bytes = s.getBytes();
//        System.out.println(Arrays.toString(bytes));


//        FileInputStream fis = new FileInputStream("e:/12.jpg");
//        FileOutputStream fos = new FileOutputStream("e:/mm.jpg");
//        int bytes = 0;
//        while ((bytes = fis.read()) != -1){
//            fos.write(bytes);
//        }
//        fis.close();
//        fos.close();

//        FileInputStream fis = new FileInputStream("java-project01.iml");
//        FileOutputStream fos = new FileOutputStream("e:/fos4.txt");
////        int bytes = 0;
////        while ((bytes = fis.read()) != -1) {
////            fos.write(bytes);
////        }
//        byte[] bytes = new byte[1024];
//        int len = 0;
//        while ((len = fis.read(bytes)) != -1){
//            System.out.println(new String(bytes,0,len));
//        }
//        fis.close();
//        fos.close();
    }

    @Test
    public void test17() throws IOException {
        //FileOutputStream fos  = new FileOutputStream("e:/fos2.txt");
//        byte[] bytes = {1,2,3,4,5,6,33};
//        fos.write(bytes,2,4);
//        FileOutputStream fos = new FileOutputStream("e:/fos3.txt",true);
//        for (int i = 0; i < 20; i++) {
//            fos.write(("hello"+i).getBytes());
//            fos.write("\r\n".getBytes());
//        }
//        fos.close();

        FileInputStream fis = new FileInputStream("java-project01.iml");
//        int bytes = 0;
//        while ((bytes = fis.read()) != -1){
//            System.out.println((char)bytes);
//        }
//        fis.close();

        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = fis.read(bytes)) != -1){
            System.out.println(new String(bytes,0,len));
        }
    }

    @Test
    public void test16() throws IOException {
        FileOutputStream fos  = new FileOutputStream("e:/fos.txt");
        fos.write("hello".getBytes());
        fos.write("IO".getBytes());
        fos.close();
    }

    @Test
    public void test15(){
        File file = new File("e:/");
        File[] files = file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir, name).isFile() && name.endsWith(".zip");
            }
        });

        for (File file1 : files) {
            System.out.println(file1);
        }

    }

    @Test
    public void test14() throws IOException {
        File file = new File("e:/test/11/22/33/b.txt");
        System.out.println(file.mkdirs());//创建目录，如果父目录不存在，则自动创建
        //System.out.println(file.mkdir());//父目录不存在是，无法创建

        File file1 = new File("e:/test");
        //System.out.println(file1.createNewFile());//目录不存在，不能创建
        //System.out.println(file.delete());



        String[] files = file1.list();
        for (String file2 : files) {
            System.out.println(file2);
        }
        System.out.println("==========");

        File[] files1 = file1.listFiles();
        for (File file2 : files1) {
            System.out.println(file2.getName());
        }

    }

    @Test
    public void test13(){
        ArrayList<Student> arrayList = new ArrayList<>();
        for (Student student : arrayList) {
            System.out.println(student.getName()+"-----"+student.getAge());
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        int x = 10;
//        System.out.println(x/0);
    }

    @Test
    public void test12(){
        long start = System.currentTimeMillis();
        for (int x =0;x<100000;x++){
            System.out.println("x"+x);
        }
        long end = System.currentTimeMillis();
        System.out.println("共计运用时间是：" + (end-start) + "毫秒");

        int[] arr = {11,22,33,44,55};
        int[] arr2 = {6,7,8,9,10};

        System.arraycopy(arr,1,arr2,2,2);//复制，且会覆盖目标数组对应index处的数据

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
    }
    
    @Test
    public void test11() throws ParseException {

        String s = "da jia ting wo shuo,jin tian yao xia yu,bu shang wan zi xi,gao xing bu?";
        String regex = "\\b\\w{3}\\b";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);
        boolean matches1 = m.matches();
        while (m.find()){
            String group = m.group();
            System.out.println(group);
        }

        String qq = "79898u";
        String regex1 = "[1-9][0-9]{4,14}";
        boolean matches = qq.matches(regex1);
        System.out.println(matches);
        int[] t = {1,2,3,4,5,6};
        System.out.println(qq.substring(5));//u


        int x = (int)(Math.random()*(50-10+1))+10;
        System.out.println(x);

        Date d = new Date();
        long time = d.getTime();
        System.out.println(time);
        //new SimpleDateFormat("yyyyMMdd").parse("19920114").getTime();
        System.out.println(System.currentTimeMillis());

        System.out.println((System.currentTimeMillis()-(new SimpleDateFormat("yyyyMMdd").parse("19920114").getTime()))/1000/60/60/24/365);
        System.out.println((System.currentTimeMillis()-(new SimpleDateFormat("yyyyMMdd").parse("19890607").getTime()))/1000/60/60/24/365);
    }

    @Test
    public void test10(){
        String t = null;
        String s = String.valueOf(t);//这个不会报错
        System.out.println(s);
        //System.out.println(t.toString());//如果字符创是null，会报错:NullPointerException
        String t2 = "qfwegmeeqonvioenbo";
        int index = t2.indexOf("z");
        System.out.println(index);//-1如果在数组中查询的值不存在，返回-1

        Integer x = null;

        Integer i3 = new Integer(128);
        Integer i4 = new Integer(128);
        System.out.println(i3 == i4);//Integer的范围是：-128~127
        System.out.println(i3.equals(i4));


        //StringBuffer是可变字符，返回字符串缓冲区
        StringBuffer sb  = new StringBuffer();
        StringBuffer sbb = sb.append("hello");
        System.out.println(sb == sbb);
        System.out.println(sb.equals(sbb));
        
        String y = "";
        System.out.println(y.toString());

        String y1 = "feqgvferqver";
        System.out.println(new StringBuffer(y1).reverse().toString());
    }

    @Test
    public void test9(){//测试采用包装类组装的基础类，使用equals方法
        //比较对象，对象必须重写equals方法，否者比较的及时地址值，无意义
        Teacher t = new Teacher("Yonyou",30);
        Teacher t1 = new Teacher("Yonyou",30);
        System.out.println(t.equals(t1));
        System.out.println(t == t1);

    }

    @Test
    public void test8(){//解决在idea下不能实现键盘录入情况：-Deditable.java.test.console=true
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        System.out.println(i);
    }

    @Test
    public void test7() throws CloneNotSupportedException {

        Student s = new Student();
        s.setAge(22);
        s.setName("yonyou");
        System.out.println(s.getName() + "---" + s.getAge());

        Student s1 = (Student) s.clone();
        System.out.println(s1.getName() + "---"+s1.getAge());//克隆值得问题就是，克隆后，原有的值变化后，克隆后值是不会变的


        Student s3 = s;
        s3.setName("Robin");
        s3.setAge(234);
        System.out.println(s.getName() + "---"+s.getAge());
        System.out.println(s1.getName() + "---"+s1.getAge());
        System.out.println(s3.getName() + "---"+s3.getAge());
        System.out.println(s1.getName() + "---"+s1.getAge());
    }

    @Test
    public void test6() throws ClassNotFoundException {
        Student s = new Student();
        System.out.println(s.toString());
        System.out.println(s.hashCode());
        System.out.println(Class.forName("com.robin.pojo.Student"));
        System.out.println(s.getClass());

        System.out.println(s.getClass().getName()+"@"+Integer.toHexString(this.hashCode()));


        Student s1 = new Student("liming",12);
        Student s2 = new Student("liming",12);
        System.out.println(s2.equals(s1));//obj=s1   false 引用类型默认情况下比较的是地址值，如果需要比较的话，需要自己重写equals方法，重写后，值为true
        System.out.println(s2 == s1);//false

        String t = "123";
        String t1 = "123";
        System.out.println(t.equals(t1));//true
        int t2 = 123;
        int t3 = 123;
//        System.out.println(t2.equals(t3));//Cannot resolve method 'equals(int)'
        
        Integer i1 = 123;
        Integer i2 =123;
        System.out.println(i1.equals(i2));//true
    }

    @Test
    public void test5(){
        String property = System.getProperty("java.version");
        System.out.println(property);

        System.out.println(System.getProperty("java.version"));
        System.out.println(System.getProperty("java.specification.version"));

        System.out.println(System.getProperty("java.vm.name"));
        System.out.println(System.getProperty("sun.arch.data.model"));
        System.out.println(System.getProperty("os.arch"));


    }

    @Test
    public void test4(){
        //Lambda方法写法
        useInter(s -> System.out.println(s));

        //引用方法
        useInter(System.out::print);
    }

    public static void useInter(Inter x){
//        System.out.println("你们好呀，我是一个接口方法！！！");
        x.show("你们好呀，测试一下吧");
    }
    
    @Test
    public void test3() throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> c = Class.forName("com.robin.pojo.Student");
        Constructor<?>[] constructors = c.getConstructors();
        for (Constructor cc : constructors){
            Object o = cc.newInstance();//这样是不对的，因为构造方法有2个，参数不同而已
//            不能一块循环得到，要跟别去获取

            System.out.println(cc);
            System.out.println(o);
        }

    }

    @Test
    public void test2(){
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);//AppClassLoader

        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);//ExtClassLoader   JDK9返回来的是PlatformClassLoader

        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);//一般是null   理论上应该是BootstrapClassLoader

        String s = UUID.randomUUID().toString();
        System.out.println(s);
        //AppClassLoader-> ExtCLassLoader(JDK9返回来的是PlatformClassLoader) ->Bootstrap Loader
    }

    @Test
    public void test1(){
        long l = System.currentTimeMillis();
        System.out.println(l);
    }

}
