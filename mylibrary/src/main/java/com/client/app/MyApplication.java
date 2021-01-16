package com.client.app;

import android.app.Application;

import com.tencent.rtmp.TXLiveBase;

public class MyApplication {
    public static Application myapp;
    /**
     * 初始化Application
     * @param application
     */
    public void initApp(Application application) {
        String licenceURL = "http://license.vod2.myqcloud.com/license/v1/e3f298c63da6696b658aa2f0951304d5/TXLiveSDK.licence";
        String licenceKey = "2f1c8c5bee6b1376164f82e491e4a801";
        TXLiveBase.getInstance().setLicence(application,licenceURL,licenceKey);
        myapp=application;
    }
}
