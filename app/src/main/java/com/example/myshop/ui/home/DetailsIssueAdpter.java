package com.example.myshop.ui.home;

import android.content.Context;
import android.widget.TextView;

import com.example.myshop.R;
import com.example.myshop.base.BaseAdapter;
import com.example.myshop.model.home.GoodDetailBean;
import com.example.myshop.utils.TxtUtils;

import java.util.List;

public class DetailsIssueAdpter extends BaseAdapter<GoodDetailBean.DataBeanX.IssueBean> {
    public DetailsIssueAdpter(Context context, List<GoodDetailBean.DataBeanX.IssueBean> data) {
        super(context, data);
    }

    @Override
    protected int getLayout() {
        return R.layout.adpter_home_item_details_issue;
    }

    @Override
    protected void bindData(GoodDetailBean.DataBeanX.IssueBean data, VH vh) {
        TextView name = (TextView) vh.getViewById(R.id.issue_tv_name);
        TxtUtils.setTextView(name,data.getQuestion());
        TextView desc = (TextView) vh.getViewById(R.id.issue_tv_desc);
        TxtUtils.setTextView(desc,data.getAnswer());
    }
}
