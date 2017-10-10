package com.syl.demo.util;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RequestUtil {
    public static Object getObjectByRequest(HttpServletRequest request,Class c){




        Object o = null;
        //创建此Class 对象所表示的类的一个新实例
        try {
            o = c.newInstance(); //调用了Employee的无参数构造方法.
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        //获取所有的属性?
        Field[] fs = c.getDeclaredFields();
        for (Field field:fs) {

            String filedName=field.getName();
            Class filedType = field.getType();
            //System.out.println(filedName);//属性的名字+回车  .);
            //System.out.println(filedType);
           String methodName =upCase(filedName);
            try {
                Method method=c.getDeclaredMethod(methodName,filedType);
                try {
                    method.invoke(o,request.getParameter(stringInsert_(filedName)));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }

        }

        return o;
    }

    /**
     *
     * @param filedName 对象的属性
     *                  如User对象的userId属性
     * @return 返回对象属性相对应的set方法名称
     *         如User对象的userId属性对应的setUserId方法名称
     */
    public static String upCase(String filedName) {

        return  "set"+filedName.substring(0, 1).toUpperCase() + filedName.substring(1);

    }
    /**
     *
     * @param filedName 对象的属性
     *                  如User对象的userId属性
     * @return 返回对象属性相对应的数据库列名或jsp中input标签的name
     *          如User对象的userId属性对应的user表的user_id和jsp中的input name="user_id"
     */
    public static String stringInsert_(String filedName) {


        StringBuilder sb = new StringBuilder();
        sb.append(filedName);
        for (int i = 0; i < filedName.length(); i++) {

            if (Character.isUpperCase(filedName.charAt(i))) {

                sb.insert(i, "_");
               // System.out.println(i);
            }
        }
       //System.out.println(sb.toString().toLowerCase());
        return sb.toString().toLowerCase();
    }

}
