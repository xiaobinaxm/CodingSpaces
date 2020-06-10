package com.robin.test;

/**
 * @Description
 * @Author Robin
 * @Date 2019/10/3 12:46
 */
public class CodeFormat {
    public static void main(String[] args) {

/*

        饿汉式
        public class Student {
    // 构造私有
    private Student() {
    }
 
    // 自己造一个
    // 静态方法只能访问静态成员变量，加静态
    // 为了不让外界直接访问修改这个值，加private
    private static Student s = new Student();
 
    // 提供公共的访问方式
    // 为了保证外界能够直接使用该方法，加静态
    public static Student getStudent() {
        return s;
    }
        }

        饱汉式
        public class Teacher {
    private Teacher() {
    }
 
    private static Teacher t = null;
 
    public synchronized static Teacher getTeacher() {
        if (t == null) {//当t为null时才去创建
            t = new Teacher();
        }
        return t;
    }
        }

































































































    }

    饿汉式
public class Student {
    // 构造私有
    private Student() {}
 
    // 自己造一个
    // 静态方法只能访问静态成员变量，加静态
    // 为了不让外界直接访问修改这个值，加private
    private static Student s = new Student();
 
    // 提供公共的访问方式
    // 为了保证外界能够直接使用该方法，加静态
    public static Student getStudent() {
        return s;
    }
 }

    饱汉式
public class Teacher {
    private Teacher() {}
 
    private static Teacher t = null;
    public synchronized static Teacher getTeacher() {
        if (t == null) {//当t为null时才去创建
            t = new Teacher();
        }
        return t;
    }
}




public static void main(String[] args) throws IOException {
    // 创建发送端Socket对象
    // DatagramSocket()
    DatagramSocket ds = new DatagramSocket();

    // 创建数据，并把数据打包
    // DatagramPacket(byte[] buf, int length, InetAddress address, int port)
    // 创建数据
    byte[] bys = "hello,udp,我来了".getBytes();//巧妙把字符串转换为字节数组
    // 长度
    int length = bys.length;
    // IP地址对象
    InetAddress address = InetAddress.getByName("192.168.12.92");
    // 端口
    int port = 10086;//端口号的选择：一万号开外
    DatagramPacket dp = new DatagramPacket(bys, length, address, port);

    // 调用Socket对象的发送方法发送数据包
    // public void send(DatagramPacket p)
    ds.send(dp);

    // 释放资源
    ds.close();//底层依赖IO流，所以要释放资源
}


public static void main(String[] args) throws IOException {
    // 创建接收端Socket对象
    // DatagramSocket(int port)
    DatagramSocket ds = new DatagramSocket(10086);//端口号的选择：一万号开外

    // 创建一个数据包(接收容器)
    // DatagramPacket(byte[] buf, int length)
    byte[] bys = new byte[1024];
    int length = bys.length;
    DatagramPacket dp = new DatagramPacket(bys, length);

    // 调用Socket对象的接收方法接收数据
    // public void receive(DatagramPacket p)
    ds.receive(dp); // 阻塞式(在没有接收到数据之前等待)

    // 解析数据包，并显示在控制台
    // 获取对方的ip
    // public InetAddress getAddress()
    InetAddress address = dp.getAddress();
    String ip = address.getHostAddress();
    // public byte[] getData():获取数据缓冲区
    // public int getLength():获取数据的实际长度
    byte[] bys2 = dp.getData();
    int len = dp.getLength();
    String s = new String(bys2, 0, len);
    System.out.println(ip + "传递的数据是:" + s);

    // 释放资源
    ds.close();
}



public class ReceiveDemo {
    public static void main(String[] args) throws IOException {
        // 创建接收端的Socket对象
        DatagramSocket ds = new DatagramSocket(12345);

        // 创建一个包裹
        byte[] bys = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bys, bys.length);

        // 接收数据
        ds.receive(dp);

        // 解析数据
        String ip = dp.getAddress().getHostAddress();
        String s = new String(dp.getData(), 0, dp.getLength());
        System.out.println("from " + ip + " data is : " + s);

        // 释放资源
        ds.close();
    }
}




public static void bubbleSort(int[] arr) {
    for(int x=0; x<arr.length-1; x++) {	//外层控制排序的趟数
        for(int y=0; y<arr.length-1-x; y++) {	//内层控制每一趟排序多少次
            if(arr[y] > arr[y+1]) {
                int temp = arr[y];
                arr[y] = arr[y+1];
                arr[y+1] = temp;
            }
        }
    }
}


public static void selectSort(int[] arr) {
    for(int x=0; x<arr.length-1; x++) {
        for(int y=x+1; y<arr.length; y++) {
            if(arr[y] < arr[x]) {
                int temp = arr[x];
                arr[x] = arr[y];
                arr[y] = temp;
            }
        }
    }
}

public static int getIndex(int[] arr,int value) {
    int index = -1;

    for(int x=0; x<arr.length; x++) {
        if(arr[x] == value) {
            index = x;
            break;
        }
    }

    return index;
}


public static int binarySearch(int[] arr,int value) {
    int min = 0;
    int max = arr.length-1;
    int mid = (min+max)/2;

    while(arr[mid] != value) {
        if(arr[mid] > value) {
            max = mid - 1;
        }else if(arr[mid] < value) {
            min = mid + 1;
        }

        if(min > max) {
            return -1;
        }

        mid = (min+max)/2;
    }

    return mid;
}




A:遍历
方式1：
public static void printArray(int[] arr) {
    for(int x=0; x<arr.length; x++) {
        System.out.println(arr[x]);
    }
}
方式2：
public static void printArray(int[] arr) {
    System.out.print("[");
    for(int x=0; x<arr.length; x++) {
        if(x == arr.length-1) {
            System.out.println(arr[x]+"]");
        }else {
            System.out.println(arr[x]+", ");
        }
    }
}
B:最值
最大值：
public static int getMax(int[] arr) {
    int max = arr[0];
    for(int x=1; x<arr.length; x++) {
        if(arr[x] > max) {
            max = arr[x];
        }
    }
    return max;
}
最小值：
public static int getMin(int[] arr) {
    int min = arr[0];
    for(int x=1; x<arr.length; x++) {
        if(arr[x] < min) {
            min = arr[x];
        }
    }
    return min;
}
C:逆序
方式1：
public static void reverse(int[] arr) {
    for(int x=0; x<arr.length/2; x++) {
        int temp = arr[x];
        arr[x] = arr[arr.length-1-x];
        arr[arr.length-1-x] = temp;
    }
}
方式2：
public static void reverse(int[] arr) {
    for(int start=0,end=arr.length-1; start<=end; start++,end--) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
D:查表
public static String getString(String[] strArray,int index) {
    return strArray[index];
}
E:基本查找
方式1：
public static int getIndex(int[] arr,int value) {
    for(int x=0; x<arr.length; x++) {
        if(arr[x] == value) {
            return x;
        }
    }
    return -1;
}
方式2：
public static int getIndex(int[] arr,int value) {
    int index = -1;
    for(int x=0; x<arr.length; x++) {
        if(arr[x] == value) {
            index = x;
            break;
        }
    }
    return index;
}




public static void printArray(int[][] arr){
    for(int x=0;x<arr.length;x++){
        for(int y=0;y<arr[].length;y++){
            System.out.print(arr[x][y]+" ");
        }
        System.out.println();
    }
}



import java.util.Scanner;
class ScannerDemo {
    public static void main(String[] args) {
        //创建键盘录入数据对象
        Scanner sc = new Scanner(System.in);
        System.out.println("请你输入一个数据：");
        int x = sc.nextInt();
        System.out.println("你输入的数据是："+x);
    }
}





class Student {
    //成员变量
    private String name;//姓名
    private int age;//年龄

    //构造方法
    public Student(){} //无参构造方法

    public Student(String name,int age) { //带两个参数的构造方法
        this.name = name;
        this.age = age;
    }

    //成员方法
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}

测试：
class StudentDemo {
    public static void main(String[] args) {
        //方式1给成员变量赋值
        //无参构造+setXxx()
        Student s1 = new Student();
        s1.setName("杜鹃");
        s1.setAge(21);
        //输出值
        System.out.println(s1.getName()+"---"+s1.getAge());
        s1.show();
        System.out.println("----------------------------");

        //方式2给成员变量赋值
        Student s2 = new Student("胡歌",28);
        //输出值
        System.out.println(s2.getName()+"---"+s2.getAge());
        S2.show();
    }
}


for (int x = 0; x < s.length(); x++){
    // char ch = s.charAt(x);
    // System.out.println(ch);
    // 仅仅是输出，我就直接输出了
    System.out.println(s.charAt(x));
}



A:存储字符串并遍历(必须牢记，滚瓜烂熟)
        import java.util.Collection;
        import java.util.ArrayList;
        import java.util.Iterator;

public class CollectionDemo {
    public static void main(String[] args) {
        //创建集合对象
        Collection c = new ArrayList();

        //创建并添加元素
        c.add("hello");
        c.add("world");
        c.add("java");

        //遍历集合
        Iterator it = c.iterator();  // 实际返回的肯定是子类对象，这里是多态。
        while(it.hasNext()) {
            String s =(String) it.next();
            System.out.println(s);
        }
    }
}

B:存储自定义对象并遍历(必须牢记，滚瓜烂熟)
public class Student {
    private String name;
    private int age;

    public Student(){}

    public Student(String name,int age) {
        this.name = name;
        this.age = age;
    }

    //getXxx()/setXxx()
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}

        import java.util.Collection;
        import java.util.ArrayList;
        import java.util.Iterator;

public class StudentDemo {
    public static void main(String[] args) {
        //创建集合对象
        Collection c = new ArrayList();

        //创建学生对象
        Student s1 = new Student("林青霞",27);
        Student s2 = new Student("风清扬",30);
        Student s3 = new Student("刘意",30);
        Student s4 = new Student("武鑫",25);
        Student s5 = new Student("刘晓曲",16);

        //添加元素
        c.add(s1);
        c.add(s2);
        c.add(s3);
        c.add(s4);
        c.add(s5);

        //遍历集合
        Iterator it = c.iterator();
        while(it.hasNext()) {
            Student s = (Student)it.next();
            System.out.println(s.getName()+"---"+s.getAge());
        }
    }
}

*/


    }


















}
