package com.example.asus.douyinapp.attention.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.asus.douyinapp.R;
import com.example.asus.douyinapp.home.recommend.bean.RecommendBean;
import com.example.asus.douyinapp.home.recommend.view.Main_startvideo;


import java.util.List;



public class AttentionRvAdapter extends RecyclerView.Adapter<AttentionRvAdapter.ViewHolder> {

    private Context context;
    private List<RecommendBean.CategoryListBean> category_list;

    public AttentionRvAdapter(Context context, List<RecommendBean.CategoryListBean> category_list) {
        this.context = context;
        this.category_list = category_list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.attention_recyclerview_item, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final List<RecommendBean.CategoryListBean.AwemeListBean> aweme_list = category_list.get(position % category_list.size()).getAweme_list();
        String s = aweme_list.get(position % aweme_list.size()).getVideo().getCover().getUrl_list().get(0);
        Glide.with(context).load(s).into(holder.imgRvItem);
        holder.tvRvItem.setText(aweme_list.get(position % aweme_list.size()).getDesc());
        holder.imgRvItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, Main_startvideo.class);
                intent.putExtra("url",aweme_list.get(position%aweme_list.size()).getVideo().getDownload_addr().getUrl_list().get(0));
                intent.putExtra("pic",aweme_list.get(position%aweme_list.size()).getVideo().getCover().getUrl_list().get(0));
                intent.putExtra("desc",aweme_list.get(position%aweme_list.size()).getDesc());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (category_list == null) {
            return 0;
        }
        return Integer.MAX_VALUE;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgRvItem;
        private TextView tvRvItem;

        public ViewHolder(View itemView) {
            super(itemView);
            //itemView一个条目的视图;
            imgRvItem = itemView.findViewById(R.id.imgRvItem);
            tvRvItem = itemView.findViewById(R.id.tvRvItem);
        }
    }
}
