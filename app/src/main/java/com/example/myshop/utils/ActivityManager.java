package com.example.myshop.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;

public class ActivityManager {

    public static void startActivity(Context context,Class cls){
        Intent intent = new Intent(context,cls);
        context.startActivity(intent);
    }

    public static void startActivityForResult(Activity activity,int code, Class cls){
        Intent intent = new Intent(activity,cls);
        activity.startActivityForResult(intent,code);
    }

    public static void startFragmentForResult(Fragment fragment, int code, Class cls){
        Intent intent = new Intent(fragment.getContext(),cls);
        fragment.startActivityForResult(intent,code);
    }
}
