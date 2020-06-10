package com.robin;

/**
 * @Description:泛型
 * @author:Robin
 * @date:2017/10/3 0003 3:29:09
 */
public class Generic {

    //泛型
    private Object object;


    public Object getObject() {
        System.out.println(object.getClass().getName());
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }


    public static void main(String[] args) {

        Generic generic = new Generic();
        generic.object = new Integer(2444);
        generic.getObject();

        Generic generic1 = new Generic();
        generic1.object = "Robin";
        generic1.getObject();
    }
}
