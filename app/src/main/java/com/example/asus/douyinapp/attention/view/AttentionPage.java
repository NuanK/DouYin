package com.example.asus.douyinapp.attention.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.asus.douyinapp.R;
import com.example.asus.douyinapp.attention.adapter.AttentionRvAdapter;
import com.example.asus.douyinapp.home.recommend.bean.BannerBeanlist;
import com.example.asus.douyinapp.home.recommend.bean.RecommendBean;
import com.example.asus.douyinapp.home.recommend.presenter.HomePresenter;
import com.example.asus.douyinapp.home.recommend.view.IHomeView;

import java.util.List;

/**
 * 关注Fragment
 */
public class AttentionPage extends Fragment implements SwipeRefreshLayout.OnRefreshListener,IHomeView {

    private View view;
    private SwipeRefreshLayout srAttention;
    private RecyclerView rvAttention;
    private int cursor=0;
    private int count=5;
    private HomePresenter homePresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_attention, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        homePresenter = new HomePresenter(this);
        homePresenter.getHomeRecommend(cursor,count);
    }

    /**
     * 初始化控件
     */
    private void initView() {
        srAttention = view.findViewById(R.id.srAttention);
        rvAttention = view.findViewById(R.id.rvAttention);
        // 线性布局管理器   VERTICAL默认样式/竖向显示       第三个参数是数据是否到过来显示
        GridLayoutManager manager = new GridLayoutManager(getActivity(),2,LinearLayoutManager.VERTICAL,false);
        rvAttention.setLayoutManager(manager);
        srAttention.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light, android.R.color.holo_orange_light, android.R.color.holo_green_light);
        srAttention.setOnRefreshListener(this);
    }

    /**
     * 下拉刷新
     */
    @Override
    public void onRefresh() {

    }

    /**
     * 请求成功
     * @param recommendBean
     */
    @Override
    public void onHomeSuccess(RecommendBean recommendBean) {
        List<RecommendBean.CategoryListBean> category_list = recommendBean.getCategory_list();
        AttentionRvAdapter attentionRvAdapter = new AttentionRvAdapter(getActivity(), category_list);
        rvAttention.setAdapter(attentionRvAdapter);
    }

    /**
     * 请求失败
     * @param 数据错误
     */
    @Override
    public void onHomeFailed(String 数据错误) {
        Log.e("Attention",数据错误);
    }

    @Override
    public void onBannerSuccess(BannerBeanlist bannerBean) {

    }

    @Override
    public void onBannerFailed(String 数据错误) {

    }

    /**
     * 解绑
     */
}
