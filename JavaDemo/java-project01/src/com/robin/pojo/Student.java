package com.robin.pojo;

import java.util.Objects;

/**
 * @Description
 * @Author Robin
 * @Date 2019/9/28 22:43
 */
public class Student implements Cloneable {

    private String name;
    private int age;

    public Student() {
        super();
    }

    public Student(String name, int age) {
        this.name = name;//形参name赋值给成员变量name，二者命名一样的话，this不能省略，如果命名不一样，this是可以省略的
        this.age = age;
    }

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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    //重写equals方法，用于比较引用类型的值是否相等
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }


    @Override
    public Object clone() throws CloneNotSupportedException {//protected导致别人无法使用clone方法，在创建类的时候分包了。此处改为public
//        Student s = (Student) super.clone();
//        return s;
        return super.clone();
    }
}
