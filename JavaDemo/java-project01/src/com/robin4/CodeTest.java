package com.robin4;

import com.robin.dao.MyInterface;
import com.robin.pojo.Student;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description：测试
 * @Author:Robin
 * @Date:2019/10/27 15:00
 */
public class CodeTest {
    //定义一个成员变量：
    private Student student;

    public CodeTest(){}

    public CodeTest(Student student){
        System.out.println("构造方法，传递对象作为形参");
    }



    public static void main(String[] args) {
        //t1();//报错：静态方法不能调用非静态方法Non-static method 't1()' cannot be referenced from a static context
        //如果非要调用非静态方法，可以通过对象直接调用
        CodeTest cd = new CodeTest();//当出现有参构造器的时候，无参构造器就必须自己写，没有有参构造器的话，无参构造器可以不写，使用默认的
        cd.t1();//此时就不会才出现调用出错了
        t2();//静态方法只能调用静态方法
    }
    @Test
    public void test3(){
        //非静态方法可以调用静态和非静态方法
        t1();
        t2();
    }

    public static void t2(){
        System.out.println("静态方法");
    }

    public void t1(){
        System.out.println("普通方法");
    }

    //静态代理
    @Test
    public void test1(){
        UserDao ud = new UserDaoImpl();
        UserDao udp = new UserDaoProxy(ud);
        udp.say();
    }

    //接口
    interface UserDao{
        void say();
    }
    //实现类，目标类
    class UserDaoImpl implements UserDao{
        @Override
        public void say() {
            System.out.println("UserDaoImpl say...");
        }
    }
    //代理类
    class UserDaoProxy implements UserDao {
        private UserDao udp;

        public UserDaoProxy(UserDao udp) {
            this.udp = udp;
        }

        @Override
        public void say() {
            udp.say();
            System.out.println("........UserDaoProxy say....");
        }
    }

    ///////////////////////////////////
    //委托类2
    class UserDaoImpl2 implements UserDao{

        @Override
        public void say() {
            System.out.println("UserDaoImpl2......");
        }
    }


    //代理类
    class MyInvocationHandler implements InvocationHandler{
        private UserDao ud;
        public MyInvocationHandler(UserDao ud){
            this.ud = ud;
        }
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("proxy......");
            Object result = method.invoke(ud, args);
            return result;
        }
    }


    @Test
    public void test2(){
        UserDao up = new UserDaoImpl2();
        MyInvocationHandler handler = new MyInvocationHandler(up);
        UserDao udp = (UserDao) Proxy.newProxyInstance(up.getClass().getClassLoader(), up.getClass().getInterfaces(), handler);
        udp.say();

    }


}
