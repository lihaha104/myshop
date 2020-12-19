package com.example.myshop.ui.home;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myshop.R;
import com.example.myshop.base.BaseAdapter;
import com.example.myshop.model.home.ChannelRcyBean;
import com.example.myshop.utils.TxtUtils;

import java.util.List;

public class HomeItemFragmentAdpter extends BaseAdapter<ChannelRcyBean.DataBeanX.DataBean> {

    public HomeItemFragmentAdpter(Context context, List<ChannelRcyBean.DataBeanX.DataBean> data) {
        super(context, data);
    }

    @Override
    protected int getLayout() {
        return R.layout.adpter_home_homeitem;
    }

    @Override
    protected void bindData(ChannelRcyBean.DataBeanX.DataBean data, VH vh) {
        ImageView imgGood = (ImageView) vh.getViewById(R.id.img_homeitem);
        Glide.with(context).load(data.getList_pic_url()).into(imgGood);
        TextView txtName = (TextView) vh.getViewById(R.id.txt_homeitem);
        TxtUtils.setTextView(txtName,data.getName());
        TextView txtPrice = (TextView) vh.getViewById(R.id.txt_money_homeitem);
        TxtUtils.setTextView(txtPrice,"$"+data.getRetail_price());
    }
}
