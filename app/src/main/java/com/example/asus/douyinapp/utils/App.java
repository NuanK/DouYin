package com.example.asus.douyinapp.utils;

import android.app.Application;
import android.content.SharedPreferences;



/**
 * 全局的数据库
 */
public class App extends Application {

    public static SharedPreferences config;
    public static SharedPreferences.Editor edit;

    @Override
    public void onCreate() {
        super.onCreate();
        config = getSharedPreferences("config", MODE_PRIVATE);
        edit = config.edit();
    }
}
