package com.example.asus.douyinapp.home.recommend.model;



import com.example.asus.douyinapp.home.recommend.bean.BannerBeanlist;
import com.example.asus.douyinapp.home.recommend.bean.RecommendBean;
import com.example.asus.douyinapp.home.recommend.presenter.IHomePre;
import com.example.asus.douyinapp.home.recommend.utils.RetiofitVip;
import com.example.asus.douyinapp.home.recommend.utils.RetrofitHelper;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


public class HomeModel {
    public void getHomeRecommend(int cursor, int count, final IHomePre iHomePre) {
        RetiofitVip retiofitVip = RetrofitHelper.getRetrofit("http://aweme.snssdk.com/").create(RetiofitVip.class);
        retiofitVip.homeRecommend(cursor, count, "retry_http", "a1d5cde6323a5afecf8801", "dca3a65724f665e2e1ozlj", "003ac66b7da856e99985ae2fe9a5d661ce8c0c1c1c66c6a66686ac")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<RecommendBean>() {
                    @Override
                    public void accept(RecommendBean recommendBean) throws Exception {
                        if (recommendBean != null) {
                            iHomePre.onHomeSuccess(recommendBean);
                        } else {
                            iHomePre.onHomeFailed("数据错误");
                        }
                    }
                });
    }

    //请求轮播图
    public void getHomeBanner(final IHomePre iHomePre) {
        RetiofitVip retiofitVip = RetrofitHelper.getRetrofit("http://api.amemv.com/").create(RetiofitVip.class);
        retiofitVip.homeBanner("1128","no_retry","23028350734","42386607829")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BannerBeanlist>() {
                    @Override
                    public void accept(BannerBeanlist bannerBean) throws Exception {
                        if (bannerBean != null) {
                            iHomePre.onBannerSuccess(bannerBean);
                        } else {
                            iHomePre.onBannerFailed("数据错误");
                        }
                    }
                });
    }
}
