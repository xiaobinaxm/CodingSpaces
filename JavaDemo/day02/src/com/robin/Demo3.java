package com.robin;

public class Demo3 {

    private int id;
    private int name;
    private int age;
    private String adress;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "com.robin.Demo3{" +
                "id=" + id +
                ", name=" + name +
                ", age=" + age +
                ", adress='" + adress + '\'' +
                '}';
    }
}
