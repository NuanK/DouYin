package com.example.asus.douyinapp.home.recommend.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.example.asus.douyinapp.R;


import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class Main_startvideo extends AppCompatActivity {
   // private JCVideoPlayer videoplayer;
    private TextView back;
    private VideoView videoview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_startvideo);
       // videoplayer = findViewById(R.id.videoplayer);
        back = findViewById(R.id.go_back);
        videoview = findViewById(R.id.video);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        final String pic = intent.getStringExtra("pic");
        final String desc = intent.getStringExtra("desc");

        WebView webView = new WebView(this);
        webView.loadUrl(url);
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
                    videoplayer.cacheImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    Glide.with(Main_startvideo.this).load(pic).into(videoplayer.cacheImageView);
                }*/
                //videoplayer.HANDLER_PREPARE
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
}
