package com.example.asus.douyinapp.home.recommend.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.asus.douyinapp.R;
import com.example.asus.douyinapp.home.recommend.bean.RecommendBean;

import java.util.List;



public class MyUserAdapter extends RecyclerView.Adapter<MyUserAdapter.ViewHolder> {
    private Context context;
    private List<RecommendBean.CategoryListBean> list;

    public MyUserAdapter(Context context, List<RecommendBean.CategoryListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_user_news, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.text.setText(list.get(position).getDesc());
        List<RecommendBean.CategoryListBean.AwemeListBean> aweme_list = list.get(position).getAweme_list();
        for (int i = 0; i < aweme_list.size(); i++) {
            String desc = aweme_list.get(i).getDesc();
            holder.content.setText(desc);
        }
        List<RecommendBean.CategoryListBean.AwemeListBean> aweme_list1 = list.get(position).getAweme_list();
        MyUserPhoneAdapter myVideoAdapter2 = new MyUserPhoneAdapter(context, aweme_list1);
        holder.rc_video.setAdapter(myVideoAdapter2);
        holder.rc_video.setLayoutManager(new GridLayoutManager(context, 1, GridLayoutManager.HORIZONTAL, false));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        RecyclerView rc_video;
        TextView text;
        TextView content;
        public ViewHolder(View itemView) {
            super(itemView);
            rc_video =  itemView.findViewById(R.id.rc_video);
            text =  itemView.findViewById(R.id.user_text);
            content =  itemView.findViewById(R.id.user_content);
        }
    }
}
