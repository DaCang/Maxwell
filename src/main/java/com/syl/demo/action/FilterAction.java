package com.syl.demo.action;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebFilter("/*")
public class FilterAction implements Filter {

    protected Logger logger = Logger.getLogger(FilterAction.class);
    @Override
    public void init (FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter (ServletRequest servletRequest,
                          ServletResponse servletResponse,
                          FilterChain chain) throws IOException, ServletException {
        boolean flag = true;
        if(flag){
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            String requestUrl = request.getRequestURL().toString();

            logger.info("requestUrl:"+requestUrl);
            String param =  request.getQueryString();
           // logger.info("param:"+param);
            if(!"".equals(param) && param != null) {
                param = URLDecoder.decode(param, "UTF-8");
                String originalURL = requestUrl +"?"+ param;

                logger.info("originalURL:"+originalURL);
                String sqlParam = param;
                //添加sql注入的判断
                //if(requestURL.endsWith("/askQuestion.html") || requestURL.endsWith("/member/answer.html")){
                    sqlParam = cleanSQLInject(param);
                //}

               // logger.info("sqlParam:"+sqlParam);
                String xssParam = cleanXSS(sqlParam);
                //logger.info("xssParam:"+xssParam);
                requestUrl += "?"+xssParam;


                if(!xssParam.equals(param)){
                    System.out.println("requestURL::::::"+requestUrl);
                    response.sendRedirect(requestUrl);
                    System.out.println("no entered.");
    //                  filterchain.doFilter(new RequestWrapper((HttpServletRequest) servletrequest), servletresponse);
                    return ;
                }
            }
            chain.doFilter(request, response);
        }else{

            //对请求中的所有东西都做校验，包括表单。此功能校验比较严格容易屏蔽表单正常输入，使用此功能请注意。
           // chain.doFilter(new RequestWrapper((HttpServletRequest) servletrequest), servletresponse);
        }


}

    @Override
    public void destroy () {

    }

    public String cleanXSS(String src) {
        String temp =src;

        logger.info("xss---temp-->"+src);
        src = src.replaceAll("<", "<").replaceAll(">", ">");
        // if (src.indexOf("address")==-1)
        //  {
        src = src.replaceAll("\\(", "(").replaceAll("\\)", ")");
        //}

        src = src.replaceAll("'", "'");

        Pattern pattern=Pattern.compile("(eval\\((.*)\\)|script)",Pattern.CASE_INSENSITIVE);
        Matcher matcher=pattern.matcher(src);
        src = matcher.replaceAll("");

        pattern=Pattern.compile("[\\\"\\'][\\s]*javascript:(.*)[\\\"\\']",Pattern.CASE_INSENSITIVE);
        matcher=pattern.matcher(src);
        src = matcher.replaceAll("\"\"");

        //增加脚本
        src = src.replaceAll("script", "").replaceAll(";", "")
                .replaceAll("\"", "").replaceAll("@", "")
                .replaceAll("0x0d", "")
                .replaceAll("0x0a", "").replaceAll(",", "");

        if(!temp.equals(src)){
            logger.info("输入信息存在xss攻击！");
            logger.info("原始输入信息-->"+temp);
            logger.info("处理后信息-->"+src);
        }
        return src;
    }

    //需要增加通配，过滤大小写组合
    public String cleanSQLInject(String src) {
        String temp =src;
        src = src.replaceAll("insert", "forbidI")
                .replaceAll("select", "forbidS")
                .replaceAll("update", "forbidU")
                .replaceAll("delete", "forbidD")
                .replaceAll("and", "forbidA")
                .replaceAll("or", "forbidO");

        if(!temp.equals(src)){
            logger.info("输入信息存在SQL攻击！");
            logger.info("原始输入信息-->"+temp);
            logger.info("处理后信息-->"+src);
        }
        return src;
    }
}
