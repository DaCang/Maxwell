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
            System.out.println(filedName);//属性的名字+回车  .);
            System.out.println(filedType);
           String methodName =upCase(filedName);
            try {
                Method method=c.getDeclaredMethod(methodName,filedType);
                try {
                    method.invoke(o,request.getParameter(stringInsert_(field.getName())));
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
    public static String upCase(String name) {
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        return  "set"+name;

    }
    /**
     *
     * @param s 传入一个字符串
     * @return 返回一个字符串中的大写字母
     */
    public static String stringInsert_(String s) {


        StringBuilder sb = new StringBuilder();
        sb.append(s);
        for (int i = 0; i < s.length(); i++) {

            if (Character.isUpperCase(s.charAt(i))) {

                sb.insert(i, "_");
               // System.out.println(i);
            }
        }
       System.out.println(sb.toString().toLowerCase());
        return sb.toString().toLowerCase();
    }

}
