package com.example.myshop.app;

import android.os.Build;
import android.os.Environment;

import androidx.annotation.RequiresApi;

import java.io.File;

@RequiresApi(api = Build.VERSION_CODES.R)
public class Constants {

    //网络缓存的地址
    public static final String PATH_DATA = MyApp.app.getCacheDir().getAbsolutePath() + File.separator + "data";

    public static final String PATH_IMGS = PATH_DATA + "/client/imgs";

    public static final String APK_PATH = Environment.getStorageDirectory()+File.separator+"apk/";


    public static final String ACTION_UPDATEHEADER = "updateheader"; //头像更新的动作
    public static final String ACTION_UPDATENICKNAME = "upatenickname";  //修改昵称

    public static final int HEAD_WIDTH = 160;
    public static final int HEAD_HEIGHT = 160;
}
