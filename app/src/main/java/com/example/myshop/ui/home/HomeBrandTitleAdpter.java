package com.example.myshop.ui.home;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mymvps.base.BaseAdapter;
import com.example.myshop.R;

import com.example.myshop.model.home.BrandTitleBean;
import com.example.myshop.utils.TxtUtils;

import java.util.List;

public class HomeBrandTitleAdpter extends BaseAdapter<BrandTitleBean.DataBeanX.DataBean> {
    public HomeBrandTitleAdpter(Context context, List<BrandTitleBean.DataBeanX.DataBean> data) {
        super(context, data);
    }

    @Override
    protected int getLayout() {
        return R.layout.adpter_home_brand_title;
    }

    @Override
    protected void bindData(BrandTitleBean.DataBeanX.DataBean data, VH vh) {
        ImageView titleimg = (ImageView) vh.getViewById(R.id.title_img);
        Glide.with(context).load(data.getApp_list_pic_url()).into(titleimg);
        //跳转
        titleimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, HomeBrandTitleImgActivity.class);
                intent.putExtra("id",data.getId());
                context.startActivity(intent);
            }
        });
        TextView titlename = (TextView) vh.getViewById(R.id.title_name);
        TxtUtils.setTextView(titlename,data.getName()+" | ");
        TextView titlemoney = (TextView) vh.getViewById(R.id.title_money);
        TxtUtils.setTextView(titlemoney,data.getFloor_price()+"元起");

    }

}
