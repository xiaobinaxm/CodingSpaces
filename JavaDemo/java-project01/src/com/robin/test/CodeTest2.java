package com.robin.test;

import com.robin.dao.MyInterface;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @Description
 * @Author Robin
 * @Date 2019/10/3 23:02
 */
public class CodeTest2 {




    //流的操作以及函数式接口都是JDK8之后才有的，对以前的应用没有这个使用，注意老项目的情况。
    @Test
    public void test(){
        ArrayList<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("张马玉");
        list.add("胡歌");
        list.add("靳东");
        list.add("张丽");


        //Lambda表达式运用 stream流  接口函数java.utils.function   方法引用【::】
        //确实使用起来比价简洁   但是对你使用的条件也有要求
        //接口必须只有一个抽象函数   才可以使用Lbmbda表达式
        list.stream().filter(s -> s.startsWith("张")).filter(s -> s.length() == 3).forEach(s -> System.out.println(s));
        System.out.println("===============");
        list.stream().filter(s -> s.startsWith("张")).filter(s -> s.length() == 3).forEach(System.out::println);


        //流的初始化
        Stream<String> stream = list.stream();

        HashMap<String,String> map = new HashMap<>();
        Stream<String> stream1 = map.keySet().stream();
        Stream<String> stream2 = map.values().stream();

        int[] x = {1,2,3,4};
        Stream<int[]> x1 = Stream.of(x);
        String[] s = {"123","asf","asfd4g"};
        Stream<String> s1 = Stream.of(s);
        Stream<Integer> integerStream = Stream.of(10, 20);
        Stream<String> stringStream = Stream.of("123");
        Stream<Integer> integerStream1 = Stream.of(12);

    }

    @Test
    public void test3(){
//        String s = getString(() -> {
//            return "hello";
//        });

        String s = getString(() -> "Hello");
        System.out.println(s);

        int[] arr = {12,354,6,353,5,88};
        int x = getMax(() -> {
            int max = arr[0];

            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > max){
                    max = arr[i];
                }
            }
            return max;
        });
        System.out.println("最大值是：" + x);


    }
    private static int getMax(Supplier<Integer> supplier){
        return supplier.get();
    }

    private static String getString(Supplier<String> supplier){
        return supplier.get();
    }

    public static Comparator<String> getCompatator(){
        //匿名内部类
//        Comparator<String> comparator = new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.length() - o2.length();
//            }
//        };
//        return comparator;
        //使用lambda表达式
        return (s1,s2) -> {
          return s1.length()-s2.length();
        };

    }




    @org.junit.jupiter.api.Test
    public void test2(){
        //匿名内部类
        startThread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "线程启动了....");
            }
        });

        //lambda表达式
        startThread(() -> System.out.println(Thread.currentThread().getName()+"线程启动了..."));



    }
    private static void startThread(Runnable r){
//        Thread t = new Thread(r);
//        t.start();

        new Thread(r).start();
    }


    @Test
    public void test1(){
        //函数式借口就是Lambda表达式接口
        MyInterface m = () -> System.out.println("函数式接口");
        m.show();
    }
}
