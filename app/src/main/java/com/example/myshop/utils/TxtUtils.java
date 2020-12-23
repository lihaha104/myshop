package com.example.myshop.utils;

import android.text.TextUtils;
import android.widget.TextView;

public class TxtUtils {

    public static void setTextView(TextView textView,String word){
        if(textView != null && !TextUtils.isEmpty(word)){
            textView.setText(word);
        }
    }
    public static void setTextView(TextView textView,int word){
        if(textView != null ){
            textView.setText(word+"");
        }
    }

}
