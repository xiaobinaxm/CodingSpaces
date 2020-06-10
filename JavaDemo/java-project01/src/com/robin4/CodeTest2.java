package com.robin4;

/**
 * @Description
 * @Author Robin
 * @Date 2019/12/29 16:07
 */
public class CodeTest2 extends Super{


    public int getLength() {
        return 5;
    }
    public static void main (String[]args) {
        Super sooper = new Super ();
        Super sub = new CodeTest2();
        System.out.println(sooper.getLength()+"," +sub.getLength());
    }

/*    public static void main(String[] args) {
        System.out.println("hello,everyOne 1");
        System.out.println("hello,everyOne 2");
        System.out.println("hello,everyOne 3");
        System.out.println("hello,everyOne 4");
    }*/
}


class Super{
    public int getLength() {
        return 4;
    }
}
 /*class Sub extends Super {
    public long getLength() {
        return 5;
    }
    public static void main (String[]args) {
        Super sooper = new Super ();
        Super sub = new Sub();
        System.out.printIn(sooper.getLength()+"," +sub.getLength();
    }
}*/
