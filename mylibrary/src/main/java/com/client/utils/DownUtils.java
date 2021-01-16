package com.client.utils;

import android.text.TextUtils;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownUtils {

    /**
     * 下载对应的apk
     * @param netUrl  apk的网络地址
     * @param path  本地保存apk的路径
     * @param callback
     */
    public static void downApk(String netUrl,String path,Callback callback) throws IOException {
        if(TextUtils.isEmpty(netUrl)){
            throw new IOException("当前的apk的下载地址不正确");
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                URL url;
                HttpURLConnection connection;
                int fileSize;
                try {
                    url = new URL(netUrl);
                    // 打开链接
                    connection = (HttpURLConnection) url.openConnection();
                    // 设置链接超时
                    connection.setConnectTimeout(30000);
                    fileSize = connection.getContentLength();
                    //connection.setRequestMethod("POST");
                    connection.connect();

                    File file = new File(path);
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    // 创建一个文件输出流
                    FileOutputStream outputStream = new FileOutputStream(file);
                    // 得到链接的响应码 200为成功
                    int responseCode = connection.getResponseCode();

                    if (responseCode == HttpURLConnection.HTTP_OK) {

                        // 得到服务器响应的输入流
                        InputStream inputStream = connection.getInputStream();
                        // 获取请求的内容总长度
                        int contentLength = connection.getContentLength();
                        // 设置progressBar的Max
                        // mPb.setMax(contentLength);
                        // 创建缓冲输入流对象，相对于inputStream效率要高一些
                        BufferedInputStream bfi = new BufferedInputStream(inputStream);
                        // 此处的len表示每次循环读取的内容长度
                        int len;
                        // 已经读取的总长度
                        int totle = 0;
                        // bytes是用于存储每次读取出来的内容
                        byte[] bytes = new byte[1024 * 10];
                        while ((len = bfi.read(bytes)) != -1) {
                            // 每次读取完了都将len累加在totle里
                            Log.d("lenTAG", "run:读取速度 " + len);
                            totle += len;
                            // 每次读取的都更新一次progressBar
                            // mPb.setProgress(totle);
                            // 通过文件输出流写入从服务器中读取的数据
                            outputStream.write(bytes, 0, len);
                            //下载文件的进度的计算
                            float loading = Float.valueOf(totle)/Float.valueOf(contentLength)*100;
                            String progress = ((int)loading)+"%";
                            callback.progress(progress);
                        }
                        // 关闭打开的流对象
                        outputStream.close();
                        //                        dest.close();
                        inputStream.close();
                        bfi.close();
                        if(callback != null){
                            callback.success();
                        }
                        Log.i("Down", "下載成功");
                    }

                } catch (Exception e) {
                    // 這裏
                    Log.i("Down", "下載失敗:" + e.getMessage());
                    if (callback != null){
                        callback.fail("下载失败");
                    }
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public interface Callback{
        void success();
        void progress(String loadding);
        void fail(String err);
    }

}
