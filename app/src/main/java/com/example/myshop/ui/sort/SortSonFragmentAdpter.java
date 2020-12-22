package com.example.myshop.ui.sort;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.myshop.R;
import com.example.myshop.base.BaseAdapter;
import com.example.myshop.model.sort.SortModelBean;
import com.example.myshop.model.sort.SortModelRcyBean;
import com.example.myshop.utils.TxtUtils;

import java.util.List;

public class SortSonFragmentAdpter extends BaseAdapter<SortModelRcyBean.DataBean.CurrentCategoryBean.SubCategoryListBean> {
    private int a;
    public SortSonFragmentAdpter(int i,Context context, List<SortModelRcyBean.DataBean.CurrentCategoryBean.SubCategoryListBean> data) {
        super(context, data);
        a=i;
    }

    @Override
    protected int getLayout() {
        return R.layout.adpter_sort_son_fragment;
    }

    @Override
    protected void bindData(SortModelRcyBean.DataBean.CurrentCategoryBean.SubCategoryListBean data, VH vh) {
        String name = data.getName();
        String icon_url = data.getWap_banner_url();
        ImageView imgGood = (ImageView) vh.getViewById(R.id.sort_son_img_good);
        Glide.with(context).load(icon_url).into(imgGood);
        TextView txtName = (TextView) vh.getViewById(R.id.sort_son_tv_name);
        TxtUtils.setTextView(txtName,name);
    }



}
