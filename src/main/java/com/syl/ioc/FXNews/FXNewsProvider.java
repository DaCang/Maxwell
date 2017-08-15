package com.syl.ioc.FXNews;

/**
 * 实时地为客户提供外汇新闻
 * 1、先从不同的新闻社订阅新闻来源
 * 2、通过批处理程序定时地到指定的新闻服务器抓取最新的外汇新闻
 * 3、将这些新闻存入本地数据库，最后在FX系统的前台界面显示
 */
public class FXNewsProvider {
    private IFXNewsListener newsListener;
    private IFXNewsPersister newPersistener;
    public void getAndPersistNews() {
        String[] newsIds = newsListener.getAvailableNewsIds();
        if (ArrayUtils.isEmpty(newsIds)) {
            return;
        }
        for (String newsId : newsIds) {
            FXNewsBean newsBean = newsListener.getNewsByPK(newsId);
            newPersistener.persistNews(newsBean);
            newsListener.postProcessIfNecessary(newsId);
        }
    }
}
