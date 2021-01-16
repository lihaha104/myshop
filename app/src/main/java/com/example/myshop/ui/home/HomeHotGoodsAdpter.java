package com.example.myshop.ui.home;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mymvps.base.BaseAdapter;
import com.example.myshop.R;

import com.example.myshop.model.home.HomeModelBean;
import com.example.myshop.utils.TxtUtils;

import java.util.List;

public class HomeHotGoodsAdpter extends BaseAdapter<HomeModelBean.DataBean.HotGoodsListBean> {
    public HomeHotGoodsAdpter(Context context, List<HomeModelBean.DataBean.HotGoodsListBean> data) {
        super(context, data);
    }

    @Override
    protected int getLayout() {
        return R.layout.adpter_home_hotgoods;
    }

    @Override
    protected void bindData(HomeModelBean.DataBean.HotGoodsListBean data, VH vh) {
        ImageView imgHotGood = (ImageView) vh.getViewById(R.id.img_hotgood);
        Glide.with(context).load(data.getList_pic_url()).into(imgHotGood);
        TextView txtName = (TextView) vh.getViewById(R.id.txt_hotgood_name);
        TxtUtils.setTextView(txtName,data.getName());
        TextView txtDes = (TextView) vh.getViewById(R.id.txt_hotgood_des);
        TxtUtils.setTextView(txtDes,data.getGoods_brief());
        String price = "$"+data.getRetail_price();
        TextView txtPrice = (TextView) vh.getViewById(R.id.txt_hotgood_price);
        TxtUtils.setTextView(txtPrice,price);
    }
}
