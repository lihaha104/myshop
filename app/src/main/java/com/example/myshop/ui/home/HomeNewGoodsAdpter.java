package com.example.myshop.ui.home;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myshop.R;
import com.example.myshop.base.BaseAdapter;
import com.example.myshop.model.home.HomeModelBean;
import com.example.myshop.utils.TxtUtils;

import java.util.List;

public class HomeNewGoodsAdpter extends BaseAdapter<HomeModelBean.DataBean.NewGoodsListBean> {
    public HomeNewGoodsAdpter(Context context, List<HomeModelBean.DataBean.NewGoodsListBean> data) {
        super(context, data);
    }

    @Override
    protected int getLayout() {
        return R.layout.adpter_home_newgoods;
    }

    @Override
    protected void bindData(HomeModelBean.DataBean.NewGoodsListBean data, VH vh) {
        ImageView imgNewGood = (ImageView) vh.getViewById(R.id.img_newgood);
        Glide.with(context).load(data.getList_pic_url()).into(imgNewGood);
        TextView txtName = (TextView) vh.getViewById(R.id.txt_newgood_name);
        TxtUtils.setTextView(txtName,data.getName());
        TextView txtPrice = (TextView) vh.getViewById(R.id.txt_newgood_price);
        String price = "$"+data.getRetail_price();
        TxtUtils.setTextView(txtPrice,price);
    }
}
