package com.example.myshop.ui.home;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myshop.R;
import com.example.myshop.base.BaseAdapter;
import com.example.myshop.model.home.NewGoodsTitleBean;
import com.example.myshop.utils.TxtUtils;

import java.util.List;

public class HomeNewGoodsTitleAdpter extends BaseAdapter<NewGoodsTitleBean.DataBeanX.DataBean> {
    public HomeNewGoodsTitleAdpter(Context context, List<NewGoodsTitleBean.DataBeanX.DataBean> data) {
        super(context, data);
    }

    @Override
    protected int getLayout() {
        return R.layout.adpter_home_newgoods_title;
    }

    @Override
    protected void bindData(NewGoodsTitleBean.DataBeanX.DataBean data, VH vh) {
        ImageView imgNewGood = (ImageView) vh.getViewById(R.id.img_newgood_title);
        Glide.with(context).load(data.getList_pic_url()).into(imgNewGood);
        TextView txtName = (TextView) vh.getViewById(R.id.txt_newgood_name_title);
        TxtUtils.setTextView(txtName,data.getName());
        TextView txtPrice = (TextView) vh.getViewById(R.id.txt_newgood_price_title);
        String price = "$"+data.getRetail_price();
        TxtUtils.setTextView(txtPrice,price);
    }
}
