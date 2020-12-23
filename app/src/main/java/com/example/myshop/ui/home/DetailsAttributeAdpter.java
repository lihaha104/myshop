package com.example.myshop.ui.home;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.myshop.R;
import com.example.myshop.base.BaseAdapter;
import com.example.myshop.model.home.GoodDetailBean;
import com.example.myshop.utils.TxtUtils;

import java.util.List;

public class DetailsAttributeAdpter extends BaseAdapter<GoodDetailBean.DataBeanX.AttributeBean> {

    public DetailsAttributeAdpter(Context context, List<GoodDetailBean.DataBeanX.AttributeBean> data) {
        super(context, data);
    }

    @Override
    protected int getLayout() {
        return R.layout.adpter_home_item_details_attribute;
    }

    @Override
    protected void bindData(GoodDetailBean.DataBeanX.AttributeBean data, VH vh) {
        TextView name = (TextView) vh.getViewById(R.id.attribute_tv_name);
        TxtUtils.setTextView(name,data.getName());
        TextView desc = (TextView) vh.getViewById(R.id.attribute_tv_desc);
        TxtUtils.setTextView(desc,data.getValue());

    }
}
