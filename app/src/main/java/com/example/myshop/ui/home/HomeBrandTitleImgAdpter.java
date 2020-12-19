package com.example.myshop.ui.home;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myshop.R;
import com.example.myshop.base.BaseAdapter;
import com.example.myshop.model.home.BrandTitleImgRcyBean;
import com.example.myshop.utils.TxtUtils;

import java.util.List;

public class HomeBrandTitleImgAdpter  extends BaseAdapter<BrandTitleImgRcyBean.DataBeanX.DataBean> {

    public HomeBrandTitleImgAdpter(Context context, List<BrandTitleImgRcyBean.DataBeanX.DataBean> data) {
        super(context, data);
    }

    @Override
    protected int getLayout() {
        return R.layout.adpter_home_brand_title_img;
    }

    @Override
    protected void bindData(BrandTitleImgRcyBean.DataBeanX.DataBean data, VH vh) {
        ImageView imgNewGood = (ImageView) vh.getViewById(R.id.title_img_adpter_img);
        Glide.with(context).load(data.getList_pic_url()).into(imgNewGood);
        TextView txtName = (TextView) vh.getViewById(R.id.title_img_adpter_name);
        TxtUtils.setTextView(txtName,data.getName());
        TextView txtPrice = (TextView) vh.getViewById(R.id.title_img_adpter_price);
        String price = "$"+data.getRetail_price();
        TxtUtils.setTextView(txtPrice,price);
    }
}
