package com.client.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;

import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.example.mymvps.app.Constants;
import com.example.mymvps.app.MyApp;


public class ImageLoaderUtils {

    //url 图片地址
    public static void loadImage(String url, ImageView img){
        //用key为image的值的时候来判断当前时无图还有有图模式
        if(SpUtils.getInstance().getBoolean("image") && img != null){
            Glide.with(MyApp.application).load(url).into(img);
        }
    }

    /**
     * 解析图片的路径
     * @param url
     * @return
     */
    public static String[] splitUrl(String url){
        String[] arr = new String[3];
        int end = url.lastIndexOf("/")+1;
        String baseUrl = url.substring(0,end);
        String imgName = url.substring(end,url.length());
        String path = Constants.PATH_IMGS+"/"+imgName;
        arr[0] = baseUrl;
        arr[1] = imgName;
        arr[2] = path;
        return arr;
    }

    public static Bitmap getIconBitmap(Context context, int iconId) {
        try {
            Drawable icon = ContextCompat.getDrawable(context, iconId);
            if (icon == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O && icon instanceof AdaptiveIconDrawable) {
                Bitmap bitmap = Bitmap.createBitmap(icon.getIntrinsicWidth(), icon.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                icon.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                icon.draw(canvas);
                return bitmap;
            } else {
                return ((BitmapDrawable) icon).getBitmap();
            }
        } catch (Exception e) {
            return null;
        }
    }

}
