package com.example.myshop.app;

import android.app.Application;

import java.util.HashMap;

public class MyApp extends Application {
    public static MyApp app;
    public static HashMap<String,Object> map;
    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        map=new HashMap<>();
    }

    public static MyApp getApp() {
        return app;
    }

    public static HashMap<String, Object> getMap() {
        return map;
    }
}
