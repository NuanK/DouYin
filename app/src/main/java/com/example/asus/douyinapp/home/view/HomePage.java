package com.example.asus.douyinapp.home.view;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus.douyinapp.R;
import com.example.asus.douyinapp.attention.view.AttentionPage;
import com.example.asus.douyinapp.home.recommend.view.RecommendPage;


/**
 * 首页Fragment
 */
public class HomePage extends Fragment implements View.OnClickListener {

    private View view;
    private TextView tvRecommend;
    private TextView tvNearby;
    private ImageView home_search;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_home, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tvNearby = view.findViewById(R.id.tvNearby);
        tvRecommend = view.findViewById(R.id.tvRecommend);
        FrameLayout homeFramLayout = view.findViewById(R.id.homeFramLayout);
        home_search = getView().findViewById(R.id.home_search);
        tvRecommend.setTextColor(Color.WHITE);
        tvNearby.setTextColor(Color.parseColor("#cccccc"));
        tvNearby.setOnClickListener(this);
        tvRecommend.setOnClickListener(this);
        home_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Main_search.class);
                startActivity(intent);
            }
        });
        //初始化默认页面
        getChildFragmentManager().beginTransaction().replace(R.id.homeFramLayout, new RecommendPage()).commit();
        //照片
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tvRecommend://推荐
                tvRecommend.setTextColor(Color.WHITE);
                tvNearby.setTextColor(Color.parseColor("#cccccc"));
                getChildFragmentManager().beginTransaction().replace(R.id.homeFramLayout, new RecommendPage()).commit();
                break;
            case R.id.tvNearby://附近
                tvNearby.setTextColor(Color.WHITE);
                tvRecommend.setTextColor(Color.parseColor("#cccccc"));
                getChildFragmentManager().beginTransaction().replace(R.id.homeFramLayout, new AttentionPage()).commit();
                break;
        }
    }
}
