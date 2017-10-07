package com.syl.demo.util;

import javax.servlet.http.HttpServletResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ResponseUtil {

    public static void  setResponse(HttpServletResponse response, String jsonStr){

        try {
            response.setContentType("text/plain;charset=UTF-8");
            response.setContentType("text/plain; charset=gbk");
            response.getWriter().print(jsonStr);
            response.getWriter().flush();
            response.getWriter().close();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                response.setContentType("text/html; charset=gbk");

                response.getWriter().print(
                        "{\"code\":\"500\" , \"msg\":\""
                                + replaceBlank(e.getMessage()).replaceAll("\"",
                                "") + "\" }");
                response.getWriter().flush();
                response.getWriter().close();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }

    }

    public static String setCodeAndMsg(int code,String msg){
        return "{\"code\":\""+code+"\",\"msg\":\""+msg+"\"}";

    }
    private static String replaceBlank(String str) {
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }


}
