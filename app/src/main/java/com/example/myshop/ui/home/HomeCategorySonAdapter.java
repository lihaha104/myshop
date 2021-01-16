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

public class HomeCategorySonAdapter extends BaseAdapter<HomeModelBean.DataBean.CategoryListBean.GoodsListBean> {
    public HomeCategorySonAdapter(Context context, List<HomeModelBean.DataBean.CategoryListBean.GoodsListBean> data) {
        super(context, data);
    }

    @Override
    protected int getLayout() {
        return R.layout.adpter_home_category_category;
    }

    @Override
    protected void bindData(HomeModelBean.DataBean.CategoryListBean.GoodsListBean data, VH vh) {
        ImageView imgGood = (ImageView) vh.getViewById(R.id.img_good);
        Glide.with(context).load(data.getList_pic_url()).into(imgGood);
        TextView txtName = (TextView) vh.getViewById(R.id.txt_good_name);
        TxtUtils.setTextView(txtName,data.getName());
        TextView txtPrice = (TextView) vh.getViewById(R.id.txt_good_price);
        TxtUtils.setTextView(txtPrice,"$"+data.getRetail_price());

    }
}
