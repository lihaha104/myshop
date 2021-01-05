package com.example.myshop.ui.me;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myshop.R;
import com.example.myshop.base.BaseAdapter;
import com.example.myshop.model.shop.CollcationsListBean;
import com.example.myshop.utils.TxtUtils;

import java.util.List;

public class CollcationAdpter extends BaseAdapter<CollcationsListBean> {
    public CollcationAdpter(Context context, List<CollcationsListBean> data) {
        super(context, data);
    }

    @Override
    protected int getLayout() {
        return R.layout.adpter_collcation;
    }

    @Override
    protected void bindData(CollcationsListBean data, VH vh) {
        ImageView img = (ImageView) vh.getViewById(R.id.pic);
        Glide.with(context).load(data.getPic()).into(img);
        TextView name = (TextView) vh.getViewById(R.id.name);
        TxtUtils.setTextView(name,data.getName());
        TextView content = (TextView) vh.getViewById(R.id.collcation_content);
        TxtUtils.setTextView(content,data.getContent());
        TextView price = (TextView) vh.getViewById(R.id.price);
        TxtUtils.setTextView(price,data.getPrice());
    }


}
