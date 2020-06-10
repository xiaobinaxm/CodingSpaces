package com.robin;

import org.junit.Test;

public class Demo {
    /**
     * main 方法
     * @param args
     */
    public static void main(String[] args){
        System.out.println("Today is the two days to study java,it is very good");
    }

    @Test
    public void test(){
        int x = 1;
        int y = 3;
        int z = x*y;
        int w = x+y;

        System.out.println(z);
        System.out.println(w);
    }

}
