package com.example.myshop.ui.shop;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myshop.R;
import com.example.myshop.base.BaseAdapter;
import com.example.myshop.model.shop.ShopCarDataBean;
import com.example.myshop.utils.ImageLoaderUtils;

import java.util.List;

public class OrderGoodsAdapter extends BaseAdapter<ShopCarDataBean.DataBean.CartListBean> {
    public OrderGoodsAdapter(Context context, List<ShopCarDataBean.DataBean.CartListBean> data) {
        super(context, data);
    }

    @Override
    protected int getLayout() {
        return R.layout.adpter_address;
    }

    @Override
    protected void bindData(ShopCarDataBean.DataBean.CartListBean data, VH vh) {
        ImageView img = (ImageView) vh.getViewById(R.id.iv_address_item_img);
        TextView Name = (TextView) vh.getViewById(R.id.tv_address_item_name);
        TextView Price = (TextView) vh.getViewById(R.id.tv_address_item_price);
        TextView Number = (TextView) vh.getViewById(R.id.tv_address_item_count);

        ImageLoaderUtils.loadImage(data.getList_pic_url(),img);
        Price.setText("￥"+data.getRetail_price());
        Name.setText(data.getGoods_name());
        Number.setText(String.valueOf(data.getNumber()));
    }
}
