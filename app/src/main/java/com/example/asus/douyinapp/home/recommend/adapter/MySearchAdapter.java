package com.example.asus.douyinapp.home.recommend.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import com.example.asus.douyinapp.R;
import com.example.asus.douyinapp.home.recommend.bean.BannerBeanlist;
import com.example.asus.douyinapp.home.recommend.bean.RecommendBean;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Transformer;



public class MySearchAdapter extends XRecyclerView.Adapter<XRecyclerView.ViewHolder> {
    private Context context;
    private List<RecommendBean.CategoryListBean> reco_list;
    private List<BannerBeanlist.BannerBean> banner_list;
    private boolean flag;
    private ArrayList<String> listimg;

    public MySearchAdapter(Context context, List<RecommendBean.CategoryListBean> reco_list, List<BannerBeanlist.BannerBean> banner_list) {
        this.context = context;
        this.reco_list = reco_list;
        this.banner_list = banner_list;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public XRecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view = LayoutInflater.from(context).inflate(R.layout.layout_banner, null);
            ViewHolder0 viewHolder0 = new ViewHolder0(view);
            return viewHolder0;
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.layout_user, null);
            ViewHolder1 viewHolder1 = new ViewHolder1(view);
            return viewHolder1;
        }
    }

    @Override
    public void onBindViewHolder(XRecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder0) {
            ViewHolder0 v0 = (ViewHolder0) holder;
            listimg = new ArrayList<>();
            ArrayList<String> listtitle = new ArrayList<>();
            //listimg.clear();
            //listtitle.clear();
            for (int i = 0; i < banner_list.size(); i++) {
                String s = banner_list.get(i).getBanner_url().getUrl_list().get(0);
                String title = banner_list.get(i).getTitle();
                listimg.add(s);
                listtitle.add(title);
            }
            if (!flag){
                v0.banner.setData(listimg, listtitle);
                v0.banner.setmAdapter(new XBanner.XBannerAdapter() {
                    @Override
                    public void loadBanner(XBanner banner, View view, int position) {
                        Glide.with(context).load(listimg.get(position)).into((ImageView) view);
                    }
                });
               // v0.banner.setPageTransformer(Transformer);
                v0.banner.setPageChangeDuration(1000);
                flag=true;
            }else {

            }

        } else {
            ViewHolder1 viewHolder1 = (ViewHolder1) holder;
            viewHolder1.user_rc.setLayoutManager(new GridLayoutManager(context, 1, GridLayoutManager.VERTICAL, false));
            MyUserAdapter myUserAdapter = new MyUserAdapter(context, reco_list);
            viewHolder1.user_rc.setAdapter(myUserAdapter);
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    class ViewHolder0 extends XRecyclerView.ViewHolder {
        XBanner banner;

        public ViewHolder0(View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.banner);
        }
    }

    class ViewHolder1 extends XRecyclerView.ViewHolder {
          RecyclerView user_rc;

        public ViewHolder1(View itemView) {
            super(itemView);
            user_rc = (RecyclerView) itemView.findViewById(R.id.user_rc);
        }
    }
}
