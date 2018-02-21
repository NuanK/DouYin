package com.example.asus.douyinapp.home.recommend.presenter;


import com.example.asus.douyinapp.home.recommend.bean.BannerBeanlist;
import com.example.asus.douyinapp.home.recommend.bean.RecommendBean;

public interface IHomePre {
    void onHomeSuccess(RecommendBean recommendBean);
    void onHomeFailed(String 数据错误);
    //轮播图请求
    void onBannerSuccess(BannerBeanlist bannerBean);
    void onBannerFailed(String 数据错误);
}
