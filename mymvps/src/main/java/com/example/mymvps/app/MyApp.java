package com.example.mymvps.app;

import android.app.Application;

import java.util.HashMap;

public class MyApp extends Application {
    public static Application application;

    public void initApp(Application application){
        this.application=application;
    }
}
