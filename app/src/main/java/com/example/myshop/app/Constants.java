package com.example.myshop.app;

import java.io.File;

public class Constants {

    //网络缓存的地址
    public static final String PATH_DATA = MyApp.app.getCacheDir().getAbsolutePath() + File.separator + "data";

    public static final String PATH_IMGS = PATH_DATA + "/client/imgs";


    public static final String ACTION_UPDATEHEADER = "updateheader"; //头像更新的动作
    public static final String ACTION_UPDATENICKNAME = "upatenickname";  //修改昵称

}
