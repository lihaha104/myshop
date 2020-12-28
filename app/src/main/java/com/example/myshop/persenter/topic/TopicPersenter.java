package com.example.myshop.persenter.topic;

import com.example.myshop.base.BasePresenter;
import com.example.myshop.interfaces.Callback;
import com.example.myshop.interfaces.topic.ITopic;
import com.example.myshop.model.topic.TopicCommentBean;
import com.example.myshop.model.topic.TopicDetailBean;
import com.example.myshop.model.topic.TopicListBaen;
import com.example.myshop.model.topic.TopicModel;

import java.util.Map;

public class TopicPersenter extends BasePresenter<ITopic.View> implements ITopic.Persenter {
    ITopic.Model model;
    ITopic.View view;

    public TopicPersenter(ITopic.View view) {
        this.view = view;
        model=new TopicModel();
    }

    @Override
    public void getTopicDetail(int id) {
        model.getTopicDetail(new Callback<TopicDetailBean>() {
            @Override
            public void success(TopicDetailBean topicDetailBean) {
                view.getTopicDetailResult(topicDetailBean);
            }

            @Override
            public void fail(String err) {
            }
        },id);
    }

    @Override
    public void getTopicComment(Map map) {
        model.getTopicComment(new Callback<TopicCommentBean>() {


            @Override
            public void success(TopicCommentBean topicCommentBean) {
                view.getTopicCommentResult(topicCommentBean);
            }

            @Override
            public void fail(String err) {

            }
        },map);
    }

    @Override
    public void getTopicList(int page) {
        model.getTopicList(new Callback<TopicListBaen>() {
            @Override
            public void success(TopicListBaen topicListBaen) {
              view.getTopicListResult(topicListBaen);
            }

            @Override
            public void fail(String err) {

            }
        },page);
    }
}
