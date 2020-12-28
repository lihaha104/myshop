package com.example.myshop.model.topic;

import android.util.Log;

import com.example.myshop.base.BaseModel;
import com.example.myshop.interfaces.Callback;
import com.example.myshop.interfaces.topic.ITopic;
import com.example.myshop.net.CommonSubscriber;
import com.example.myshop.net.HttpManager;
import com.example.myshop.utils.RxUtils;

import java.util.Map;

import io.reactivex.disposables.Disposable;

public class TopicModel extends BaseModel implements ITopic.Model {
    @Override
    public void getTopicDetail(Callback callback,int id) {
        addDisposible(HttpManager.getInstance().getService().gettopicdetail(id)
        .compose(RxUtils.rxScheduler())
         .subscribeWith(new CommonSubscriber<TopicDetailBean>(callback) {
             @Override
             public void onNext(TopicDetailBean topicDetailBean) {
                 callback.success(topicDetailBean);
             }
         })
        );
    }

    @Override
    public void getTopicComment(Callback callback, Map map) {
        addDisposible(
                (Disposable) HttpManager.getInstance().getService().gettopiccomment(map)
                        .compose(RxUtils.rxScheduler())
                        .subscribeWith(new CommonSubscriber<TopicCommentBean>(callback) {
                            @Override
                            public void onNext(TopicCommentBean topicCommentBean) {
                                callback.success(topicCommentBean);
                            }
                        })
        );
    }

    @Override
    public void getTopicList(Callback callback,int page) {
        addDisposible(
                HttpManager.getInstance().getService().gettopiclist(page)
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<TopicListBaen>(callback) {
                    @Override
                    public void onNext(TopicListBaen topicListBaen) {
                        callback.success(topicListBaen);
                    }
                })
        );
    }

}
