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

public class TopicActivityReAdpter extends BaseAdapter<TopicListBaen.DataBeanX.DataBean> {

    public TopicActivityReAdpter(Context context, List<TopicListBaen.DataBeanX.DataBean> data) {
        super(context, data);
    }

    @Override
    protected int getLayout() {
        return R.layout.adpter_topic_activityadpter;
    }

    @Override
    protected void bindData(TopicListBaen.DataBeanX.DataBean data, VH vh) {
        ImageView adpterTopicImg = (ImageView) vh.getViewById(R.id.adpter_topic_img);
        TextView appTopicContent = (TextView) vh.getViewById(R.id.app_topic_content);
        Glide.with(context).load(data.getScene_pic_url()).into(adpterTopicImg);
        TxtUtils.setTextView(appTopicContent,data.getSubtitle());
    }
}
