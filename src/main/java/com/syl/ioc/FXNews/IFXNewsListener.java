package com.syl.ioc.FXNews;
/*
* 抓取新闻内容
* */
public class IFXNewsListener {


    public String[] getAvailableNewsIds() {


        return new String[0];
    }

    public FXNewsBean getNewsByPK(String newsId) {

        return null;
    }

    public void postProcessIfNecessary(String newsId) {
    }
}
