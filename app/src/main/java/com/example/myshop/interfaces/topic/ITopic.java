package com.example.myshop.interfaces.topic;

import com.example.myshop.interfaces.Callback;
import com.example.myshop.interfaces.IBaseModel;
import com.example.myshop.interfaces.IBasePresenter;
import com.example.myshop.interfaces.IBaseView;
import com.example.myshop.model.topic.TopicCommentBean;
import com.example.myshop.model.topic.TopicDetailBean;
import com.example.myshop.model.topic.TopicListBaen;

import java.util.Map;

public interface ITopic {
    interface View extends IBaseView {
        //获得topic数据
        void  getTopicDetailResult(TopicDetailBean result);
        void  getTopicCommentResult(TopicCommentBean result);
        void  getTopicListResult(TopicListBaen result);

    }
    interface Model extends IBaseModel {
        void  getTopicDetail(Callback callback,int id);
        void  getTopicComment(Callback callback, Map map);
        void  getTopicList(Callback callback,int page);
    }
    interface Persenter extends IBasePresenter<ITopic.View> {
        void getTopicDetail(int id);
        void getTopicComment(Map map);
        void getTopicList(int page);
    }
}
