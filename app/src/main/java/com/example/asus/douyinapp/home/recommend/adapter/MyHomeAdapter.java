package com.example.asus.douyinapp.home.recommend.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.example.asus.douyinapp.R;
import com.example.asus.douyinapp.home.recommend.bean.RecommendBean;


import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;



public class MyHomeAdapter extends PagerAdapter {
    private Context context;
    private List<RecommendBean.CategoryListBean.AwemeListBean> list;

    public MyHomeAdapter(Context context, List<RecommendBean.CategoryListBean.AwemeListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View view = View.inflate(context, R.layout.layout_home_recommend_video, null);
        ImageView reco_dislike = view.findViewById(R.id.reco_dislike);
        TextView reco_like_title = view.findViewById(R.id.reco_like_title);
        ImageView reco_talks = view.findViewById(R.id.reco_talks);
        TextView reco_talks_title = view.findViewById(R.id.reco_talks_title);
        ImageView reco_send = view.findViewById(R.id.reco_send);
        //赋值
        reco_like_title.setText(list.get(position % list.size()).getStatistics().getDigg_count() + "");
        reco_talks_title.setText(list.get(position % list.size()).getStatistics().getComment_count() + "");

       // final JCVideoPlayerStandard videoplayer = view.findViewById(R.id.videoplayer);
        final VideoView videoview = view.findViewById(R.id.video);
        TextView title = view.findViewById(R.id.recommend_title);
        WebView webView = new WebView(context);
        webView.loadUrl(list.get(position % list.size()).getVideo().getDownload_addr().getUrl_list().get(0));
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            //页面加载开始
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            //页面加载完成
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                String realUrl = url;
                Uri uri = Uri.parse(realUrl);
                videoview.setVideoURI(uri);
                videoview.start();

                videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        //         mp.setLooping(true);
                        mp.start();// 播放
                        //Toast.makeText(MainActivity.this, "开始播放！", Toast.LENGTH_LONG).show();
                    }
                });
                //这个realUrl即为重定向之后的地址
                /*boolean setUp = videoplayer.setUp(realUrl, JCVideoPlayer.SCREEN_LAYOUT_LIST, "");
                if (setUp) {
                    videoplayer.thumbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    Glide.with(context).load(list.get(position % list.size()).getVideo().getCover().getUrl_list().get(0)).into(videoplayer.thumbImageView);
                }*/
            }
        });
        //给视频文字
        title.setText(list.get(position % list.size()).getDesc());
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
