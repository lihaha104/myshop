package com.example.myshop.ui.topic;


import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.core.view.ScrollingView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myshop.R;
import com.example.myshop.base.BaseAdapter;
import com.example.myshop.base.BaseFragment;
import com.example.myshop.interfaces.topic.ITopic;
import com.example.myshop.model.topic.TopicCommentBean;
import com.example.myshop.model.topic.TopicDetailBean;
import com.example.myshop.model.topic.TopicListBaen;
import com.example.myshop.persenter.topic.TopicPersenter;

import java.util.List;

import butterknife.BindView;

public class TopicFragment extends BaseFragment<TopicPersenter> implements ITopic.View {
    @BindView(R.id.topic_rcy)
    RecyclerView topicRcy;
    @BindView(R.id.up)
    Button up;
    @BindView(R.id.dwon)
    Button dwon;
    @BindView(R.id.nest)
    NestedScrollView nest;
    private TopidFragementAdpter topidFragementAdpter;

    @Override
    protected int getLayout() {
        return R.layout.fragment_topic;
    }


    @Override
    protected void initView() {
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.getTopicList(1);
                top();
            }
        });
        dwon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.getTopicList(2);
                top();
            }
        });
    }

    @Override
    protected TopicPersenter createPrenter() {
        return new TopicPersenter(this);
    }

    @Override
    protected void initData() {
        //presenter.getTopicDetail();
        //presenter.getTopicComment();
        presenter.getTopicList(1);

    }

    private void top() {
        //回到顶部
        nest.fullScroll(View.FOCUS_UP);

    }


    @Override
    public void getTopicDetailResult(TopicDetailBean result) {

    }

    @Override
    public void getTopicCommentResult(TopicCommentBean result) {

    }

    @Override
    public void getTopicListResult(TopicListBaen result) {
        List<TopicListBaen.DataBeanX.DataBean> data = result.getData().getData();
        topicRcy.setLayoutManager(new LinearLayoutManager(mContext));
        topicRcy.addItemDecoration(new DividerItemDecoration(mContext,DividerItemDecoration.VERTICAL));
        //创建适配器
        topidFragementAdpter = new TopidFragementAdpter(getActivity(), data);
        topicRcy.setAdapter(topidFragementAdpter);

        topidFragementAdpter.addListClick(new BaseAdapter.IListClick() {
            @Override
            public void itemClick(int pos) {
                Intent intent = new Intent(getActivity(), TopicActivity.class);
                intent.putExtra("id", data.get(pos).getId());
                startActivity(intent);
            }
        });
    }

    @Override
    public void showTips(String tips) {

    }
}
