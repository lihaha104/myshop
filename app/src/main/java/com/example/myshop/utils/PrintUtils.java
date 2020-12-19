package com.example.myshop.utils;

import android.util.Log;
import android.view.MotionEvent;

public class PrintUtils {

    /**
     *
     * @param tag 当前响应事件对象
     * @param status  事件的内容
     *        action  事件类型
     */
    public static void printInfo(String tag,String status,int action){
        String str = "";
        switch (action){
            case MotionEvent.ACTION_DOWN:
                str = "Down";
                break;
            case MotionEvent.ACTION_UP:
                str = "Up";
                break;
            case MotionEvent.ACTION_MOVE:
                str = "Move";
            break;case MotionEvent.ACTION_CANCEL:
                str = "Cancel";
                break;

        }
        Log.i(tag,status+"  "+str);
    }

}
