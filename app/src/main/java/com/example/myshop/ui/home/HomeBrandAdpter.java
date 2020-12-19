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

public class HomeBrandAdpter extends BaseAdapter<HomeModelBean.DataBean.BrandListBean> {
    public HomeBrandAdpter(Context context, List<HomeModelBean.DataBean.BrandListBean> data) {
        super(context, data);
    }

    @Override
    protected int getLayout() {
        return R.layout.adpter_home_brand;
    }

    @Override
    protected void bindData(HomeModelBean.DataBean.BrandListBean data, VH vh) {
        ImageView imgBrand = (ImageView) vh.getViewById(R.id.img_brand);
        Glide.with(context).load(data.getNew_pic_url()).into(imgBrand);

        TextView txtName = (TextView)vh.getViewById(R.id.txt_brand_name);
        TxtUtils.setTextView(txtName,data.getName());

        TextView txtPrice = (TextView) vh.getViewById(R.id.txt_brand_price);
        String price = data.getFloor_price()+"元起";
        TxtUtils.setTextView(txtPrice,price);
    }
}
