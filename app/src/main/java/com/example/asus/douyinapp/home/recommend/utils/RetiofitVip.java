package com.example.asus.douyinapp.home.recommend.utils;



import com.example.asus.douyinapp.home.recommend.bean.BannerBeanlist;
import com.example.asus.douyinapp.home.recommend.bean.RecommendBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetiofitVip {
    @GET("aweme/v1/category/list/")
    Observable<RecommendBean> homeRecommend(@Query("cursor") int cursor,
                                            @Query("count") int count,
                                            @Query("retry_type") String retry_type,
                                            @Query("as") String as,
                                            @Query("cp") String cp,
                                            @Query("mas") String mas);
    @GET("aweme/v1/find/")
    Observable<BannerBeanlist> homeBanner(@Query("aid") String aid,
                                          @Query("retry_type") String retry_type,
                                          @Query("iid") String iid,
                                          @Query("device_id") String device_id);

}
