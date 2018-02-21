package com.example.asus.douyinapp;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.douyinapp.attention.view.AttentionPage;
import com.example.asus.douyinapp.home.view.HomePage;
import com.example.asus.douyinapp.message.view.MessagePage;
import com.example.asus.douyinapp.mine.view.MinePage;
import com.example.asus.douyinapp.release.view.ReleaseActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView tvHome;//首页
    private ImageView imgRefresh;//刷新
    private TextView tvAttention;//关注
    private ImageView imgRelease;//发布
    private TextView tvMessage;//消息
    private TextView tvMine;//个人主页
    private LinearLayout lyBottom;//底部栏
    private FrameLayout frameLayout;//FramLayout
    private View line1;
    private View line01;
    private View line02;
    private View line04;
    private View line05;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化默认页面
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new HomePage()).commit();
        //初始化化控件
        initView();
        //点击事件
        tvHome.setOnClickListener(this);
        imgRefresh.setOnClickListener(this);
        tvAttention.setOnClickListener(this);
        imgRelease.setOnClickListener(this);
        tvMessage.setOnClickListener(this);
        tvMine.setOnClickListener(this);
    }

    //初始化控件
    private void initView() {
        tvHome = (TextView) findViewById(R.id.tvHome);
        imgRefresh = (ImageView) findViewById(R.id.imgRefresh);
        tvAttention = (TextView) findViewById(R.id.tvAttention);
        imgRelease = (ImageView) findViewById(R.id.imgRelease);
        tvMessage = (TextView) findViewById(R.id.tvMessage);
        tvMine = (TextView) findViewById(R.id.tvMine);
        lyBottom = (LinearLayout) findViewById(R.id.lyBottom);
        frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
        line1 = (View) findViewById(R.id.line1);
        line01 = (View) findViewById(R.id.line01);
        line02 = (View) findViewById(R.id.line02);
        line04 = (View) findViewById(R.id.line04);
        line05 = (View) findViewById(R.id.line05);
    }

    //点击事件#00000000
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvHome:
                tvHome.setTextColor(Color.parseColor("#FFFFFF"));
                tvAttention.setTextColor(Color.parseColor("#787878"));
                tvMessage.setTextColor(Color.parseColor("#787878"));
                tvMine.setTextColor(Color.parseColor("#787878"));
                /**
                 * 分割线&下划线的显示与隐藏
                 */
                line01.setVisibility(View.VISIBLE);
                line02.setVisibility(View.GONE);
                line04.setVisibility(View.GONE);
                line05.setVisibility(View.GONE);
                line1.setVisibility(View.VISIBLE);
                tvHome.setVisibility(View.GONE);
                imgRefresh.setVisibility(View.VISIBLE);
                lyBottom.setBackgroundColor(00000000000000000000000000000000);
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new HomePage()).commit();
                break;
            case R.id.imgRefresh:
                /**
                 * 分割线&下划线的显示与隐藏
                 */
                line01.setVisibility(View.VISIBLE);
                line02.setVisibility(View.GONE);
                line04.setVisibility(View.GONE);
                line05.setVisibility(View.GONE);
                line1.setVisibility(View.VISIBLE);
                /**
                 * 选中/非选中的字体颜色更换
                 */
                tvHome.setTextColor(Color.parseColor("#FFFFFF"));
                tvAttention.setTextColor(Color.parseColor("#787878"));
                tvMessage.setTextColor(Color.parseColor("#787878"));
                tvMine.setTextColor(Color.parseColor("#787878"));
                Toast.makeText(this, "刷新", Toast.LENGTH_SHORT).show();
                //这个是按照某一点进行旋转，默认是view的
                ObjectAnimator ra = ObjectAnimator.ofFloat(imgRefresh, "rotation", 0, -1080);
                //将动画添加
                ra.setDuration(2000);
                ra.start();
                break;
            case R.id.tvAttention:
                /**
                 * 分割线&下划线的显示与隐藏
                 */
                line01.setVisibility(View.GONE);
                line02.setVisibility(View.VISIBLE);
                line04.setVisibility(View.GONE);
                line05.setVisibility(View.GONE);
                line1.setVisibility(View.GONE);
                tvHome.setTextColor(Color.parseColor("#787878"));
                tvAttention.setTextColor(Color.parseColor("#FFFFFF"));
                tvMessage.setTextColor(Color.parseColor("#787878"));
                tvMine.setTextColor(Color.parseColor("#787878"));
                tvHome.setVisibility(View.VISIBLE);
                imgRefresh.setVisibility(View.GONE);
                lyBottom.setBackgroundColor(Color.BLACK);
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new AttentionPage()).commit();
                break;
            case R.id.imgRelease:
                /**
                 * 跳转Activity
                 */
                line1.setVisibility(View.GONE);
                tvHome.setVisibility(View.VISIBLE);
                imgRefresh.setVisibility(View.GONE);
                lyBottom.setBackgroundColor(Color.BLACK);
                //getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new ReleasePage()).commit();
                Intent intent = new Intent(MainActivity.this, ReleaseActivity.class);
                startActivity(intent);
                //进入退出同事进行动画
                overridePendingTransition(R.anim.in,R.anim.out);
                break;
            case R.id.tvMessage:
                /**
                 * 分割线&下划线的显示与隐藏
                 */
                line01.setVisibility(View.GONE);
                line02.setVisibility(View.GONE);
                line04.setVisibility(View.VISIBLE);
                line05.setVisibility(View.GONE);
                line1.setVisibility(View.GONE);
                tvHome.setTextColor(Color.parseColor("#787878"));
                tvAttention.setTextColor(Color.parseColor("#787878"));
                tvMessage.setTextColor(Color.parseColor("#FFFFFF"));
                tvMine.setTextColor(Color.parseColor("#787878"));
                tvHome.setVisibility(View.VISIBLE);
                imgRefresh.setVisibility(View.GONE);
                lyBottom.setBackgroundColor(Color.BLACK);
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new MessagePage()).commit();
                break;
            case R.id.tvMine:
                /**
                 * 分割线&下划线的显示与隐藏
                 */
                line01.setVisibility(View.GONE);
                line02.setVisibility(View.GONE);
                line04.setVisibility(View.GONE);
                line05.setVisibility(View.VISIBLE);
                line1.setVisibility(View.GONE);
                tvHome.setTextColor(Color.parseColor("#787878"));
                tvAttention.setTextColor(Color.parseColor("#787878"));
                tvMessage.setTextColor(Color.parseColor("#787878"));
                tvMine.setTextColor(Color.parseColor("#FFFFFF"));
                tvHome.setVisibility(View.VISIBLE);
                imgRefresh.setVisibility(View.GONE);
                lyBottom.setBackgroundColor(Color.BLACK);
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new MinePage()).commit();
                break;
        }
    }
}
