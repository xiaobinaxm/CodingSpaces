package com.robin;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description:
 * @author:Robin
 * @date:2017/10/3 0003 4:31:33
 */
public class Collections {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("lishi");//添加
        list.add("xiaoming");
        list.add("wang");
        list.add("ddd");

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));

        list.remove(3);//删除 移除

        list.set(2, "Robin");//设置

        System.out.println(list.get(2));



        if (list.contains("Robin")) {
            System.out.println(true);
        }

        int[] a = new int[5];


        /**
         * List ArrayList LinkList Set都是单列集合
         * List ArrayList是有序的，查询很快，但是插入以及删除比较慢
         * LinkList是有序的，查询比较慢，但是增删快，是链表
         * set是无序集合   根据HashCode 和equals 判断是否一样
         */

        Set<String> set = new HashSet<String>();
        set.add("meimei");
        set.add("xiaomei");
        set.add("zhouming");
        set.add("xioaz");

        System.out.println(set.getClass().getName());
        for (int i = 0; i < set.size(); i++) {
            System.out.println(set);
        }
      //  System.out.println(set);
    }



}
