package com.syl.demo.util;

import org.junit.Test;

public class FileUtilTest {
    @Test
    public void writeTOFile () throws Exception {
       boolean exec= FileUtil.writeTOFile("this is a test file??成功了没？","D:/LEARN","a.txt");
        if(exec){
            System.out.println("操作成功");
        }
    }

}