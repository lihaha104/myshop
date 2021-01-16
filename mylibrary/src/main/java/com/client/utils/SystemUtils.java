package com.client.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.RequiresApi;
import androidx.core.content.FileProvider;

import com.youth.banner.BuildConfig;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;


public class SystemUtils {

    /**
     * 关闭键盘
     * @param context
     */
    public static void closeSoftKeyBoard(Activity context)
    {
        View view = context.getWindow().peekDecorView();
        if (view != null)
        {
            InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
    /**
     * 打开键盘
     * @param context
     */
    public static void openSoftKeyBoard(Activity context)
    {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }

    /**
     * 获取pg对应的版本号
     * @param pg
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.P)
    public static long getApkVersionCodeByPg(Context context, String pg){
        long versionCode=-1;
        try{
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(pg,0);
            versionCode = packageInfo.getLongVersionCode();
        }catch (PackageManager.NameNotFoundException e){
            e.printStackTrace();
        }
        return versionCode;
    }

    /**
     * 安装apk
     */
    public static void installApk(Context context, File file){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        if (Build.VERSION.SDK_INT >= 24)
        { // Android7.0及以上版本 Log.d("-->最新apk下载完毕","Android N及以上版本");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            Uri contentUri = FileProvider.getUriForFile(context, BuildConfig.APPLICATION_ID + ".fileProvider", file);
            //参数二:应用包名+".fileProvider"(和步骤二中的Manifest文件中的provider节点下的authorities对应)
            intent.setDataAndType(contentUri, "application/vnd.android.package-archive");
        } else {
            // Android7.0以下版本 Log.d("-->最新apk下载完毕","Android N以下版本");
            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        context.startActivity(intent);
    }

    /**
     * 静默安装
     */
    public static boolean installNewApk(String apkPath){
        Process process = null;
        BufferedReader successResult = null;
        BufferedReader errorResult = null;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder errorMsg = new StringBuilder();
        try {
//            //7.0以前版本使用
//            process = new ProcessBuilder("pm", "install", "-r", apkPath).start();
            //7.0以后版本使用
            if(Build.VERSION.SDK_INT < Build.VERSION_CODES.N){
                process = new ProcessBuilder("pm", "install", "-r", apkPath).start();
            }else{
                process = new ProcessBuilder("pm", "install","-i",BuildConfig.APPLICATION_ID, "-r", apkPath).start();
            }
            successResult = new BufferedReader(new InputStreamReader(process.getInputStream()));
            errorResult = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String s;
            while ((s = successResult.readLine()) != null) {
                successMsg.append(s);
            }
            while ((s = errorResult.readLine()) != null) {
                errorMsg.append(s);
            }
        } catch (Exception e) {

        } finally {
            try {
                if (successResult != null) {
                    successResult.close();
                }
                if (errorResult != null) {
                    errorResult.close();
                }
            } catch (Exception e) {

            }
            if (process != null) {
                process.destroy();
            }
        }

        //如果含有“success”单词则认为安装成功
        return successMsg.toString().equalsIgnoreCase("success");

    }

}
