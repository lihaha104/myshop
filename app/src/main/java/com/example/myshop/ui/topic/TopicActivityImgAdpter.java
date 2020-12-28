package com.example.myshop.ui.topic;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.myshop.R;
import com.example.myshop.base.BaseAdapter;

import java.util.List;

public class TopicActivityImgAdpter extends BaseAdapter<String> {
    public TopicActivityImgAdpter(Context context, List<String> data) {
        super(context, data);
    }

    @Override
    protected int getLayout() {
        return R.layout.adpter_topic_img;
    }

    @Override
    protected void bindData(String data, VH vh) {
        String s=data;
        ImageView img = (ImageView) vh.getViewById(R.id.topic_img);
        Glide.with(context).load(s).into(img);
    }
}
