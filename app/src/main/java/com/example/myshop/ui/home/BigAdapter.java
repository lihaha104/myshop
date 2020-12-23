package com.example.myshop.ui.home;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.myshop.R;
import com.example.myshop.base.BaseAdapter;

import java.util.List;

public class BigAdapter extends BaseAdapter<String> {



    public BigAdapter(Context context, List<String> data) {
        super( context, data );
    }

    @Override
    protected int getLayout() {
        return R.layout.adapter_bigimage;
    }

    @Override
    protected void bindData(String data, VH vh) {
        String s = (String) data;
        ImageView image = (ImageView) vh.getViewById( R.id.image_bigImage );
        Glide.with( context ).load( s ).into( image );
    }



}

