package com.example.myshop.ui.home;

import android.content.Context;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myshop.R;
import com.example.myshop.base.BaseAdapter;
import com.example.myshop.model.home.HomeModelBean;
import com.example.myshop.utils.TxtUtils;

import java.util.List;

public class HomeCategoryAdpter extends BaseAdapter<HomeModelBean.DataBean.CategoryListBean> {
    public HomeCategoryAdpter(Context context, List<HomeModelBean.DataBean.CategoryListBean> data) {
        super(context, data);
    }

    @Override
    protected int getLayout() {
        return R.layout.adpter_home_category;
    }

    @Override
    protected void bindData(HomeModelBean.DataBean.CategoryListBean data, VH vh) {
        TextView txtTitle = (TextView) vh.getViewById(R.id.txt_category_title);
        TxtUtils.setTextView(txtTitle,data.getName());
        RecyclerView recyclerView = (RecyclerView) vh.getViewById(R.id.recy_category);
        HomeCategorySonAdapter goodAdapter = new HomeCategorySonAdapter(context,data.getGoodsList());
        recyclerView.setLayoutManager(new GridLayoutManager(context,2));
        recyclerView.setAdapter(goodAdapter);
    }
}
