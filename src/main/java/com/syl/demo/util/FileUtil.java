package com.syl.demo.util;


import org.apache.log4j.Logger;

import java.io.*;

/**
 * 文件处理工具类
 */
public class FileUtil {

    protected static Logger logger = Logger.getLogger(FileUtil.class);

    /**
     * @param str        要写入的字符串
     * @param fileToPath 要写入文件的路径
     * @param fileName   要写入文件的名称
     * @return
     */
    public static boolean writeTOFile(String str,String fileToPath,String fileName) {
        // TODO Auto-generated method stub
        // file(内存)----输入流---->【程序】----输出流---->file(内存)

        if(fileToPath==null||"".equals(fileToPath)){
            logger.error(FileUtil.class+"要写入文件的路径不能为null或者空字符串");
            return false;
        }
        if(fileName==null||"".equals(fileName)){
            logger.error(FileUtil.class+"要写入文件的名称不能为null或者空字符串");
            return false;
        }
        if(str==null){
            logger.error(FileUtil.class+"要写入的字符串不能为null");
            return false;
        }
        File file = new File(fileToPath, fileName);
        boolean isExist=false;
        try {
            isExist = file.createNewFile(); // 创建文件
            if(isExist){
                logger.info(fileToPath+fileName+"文件创建成功！");
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            logger.error(fileToPath+fileName+"文件创建失败！");
        }
        // 向文件写入内容(输出流)
        byte bt[] = new byte[1024];
        try {

            bt = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
        }
        try {
            FileOutputStream in = new FileOutputStream(file);

            in.write(bt, 0, bt.length);
            in.close();
            // boolean success=true;
            logger.info("写入文件成功");
            return true;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            logger.error("写入文件失败");
            return  false;
        }


    }


}
