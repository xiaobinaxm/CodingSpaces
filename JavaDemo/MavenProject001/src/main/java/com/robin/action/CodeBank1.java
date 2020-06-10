package com.robin.action;

import java.io.File;

/**
 * @Description
 * @Author Robin
 * @Date 2019/9/27 0:24
 */
public class CodeBank1 {
    public static void main(String[] args) {
//        Student s = new Student();
//        s.setId(1);
//        s.setName("Liming");
//        s.setAge(20);
//        System.out.println(s);
        File file = new File("E:\\testFile");
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

}
