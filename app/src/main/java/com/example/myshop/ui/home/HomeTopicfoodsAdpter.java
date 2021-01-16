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

public class HomeTopicfoodsAdpter extends BaseAdapter<HomeModelBean.DataBean.TopicListBean> {
    public HomeTopicfoodsAdpter(Context context, List<HomeModelBean.DataBean.TopicListBean> data) {
        super(context, data);
    }

    @Override
    protected int getLayout() {
        return R.layout.adpter_home_topic;
    }

    @Override
    protected void bindData(HomeModelBean.DataBean.TopicListBean data, VH vh) {
        ImageView imgTopic = (ImageView) vh.getViewById(R.id.img_topic);
        Glide.with(context).load(data.getItem_pic_url()).into(imgTopic);
        TextView txtName = (TextView) vh.getViewById(R.id.txt_topic_name);
        String name = data.getTitle() + "   ￥" + data.getPrice_info()+"元起";
        TxtUtils.setTextView(txtName,name);
        TextView txtDes = (TextView) vh.getViewById(R.id.txt_topic_des);
        TxtUtils.setTextView(txtDes,data.getSubtitle());
    }
}
