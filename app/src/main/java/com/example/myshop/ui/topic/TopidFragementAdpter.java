package com.example.myshop.ui.topic;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myshop.R;
import com.example.myshop.base.BaseAdapter;
import com.example.myshop.model.topic.TopicListBaen;
import com.example.myshop.utils.TxtUtils;

import java.util.List;

import butterknife.BindView;

public class TopidFragementAdpter extends BaseAdapter<TopicListBaen.DataBeanX.DataBean> {
    @BindView(R.id.adptertopic_img)
    ImageView adptertopicImg;
    @BindView(R.id.adptertopic_title)
    TextView adptertopicTitle;
    @BindView(R.id.adptertopic_content)
    TextView adptertopicContent;
    @BindView(R.id.adptertopic_price)
    TextView adptertopicPrice;

    public TopidFragementAdpter(Context context, List<TopicListBaen.DataBeanX.DataBean> data) {
        super(context, data);
    }

    @Override
    protected int getLayout() {
        return R.layout.adpter_topic;
    }

    @Override
    protected void bindData(TopicListBaen.DataBeanX.DataBean data, VH vh) {
        TextView title = (TextView) vh.getViewById(R.id.adptertopic_title);
        TextView content = (TextView) vh.getViewById(R.id.adptertopic_content);
        TextView price = (TextView) vh.getViewById(R.id.adptertopic_price);
        ImageView img = (ImageView) vh.getViewById(R.id.adptertopic_img);
        Glide.with(context).load(data.getScene_pic_url()).into(img);
        TxtUtils.setTextView(title,data.getTitle());
        TxtUtils.setTextView(content,data.getSubtitle());
        TxtUtils.setTextView(price,data.getPrice_info()+"元起");
    }
}
