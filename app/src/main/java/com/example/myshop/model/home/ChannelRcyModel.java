package com.example.myshop.model.home;

import com.example.myshop.base.BaseModel;
import com.example.myshop.interfaces.Callback;
import com.example.myshop.interfaces.home.IChannelRcy;
import com.example.myshop.net.CommonSubscriber;
import com.example.myshop.net.HttpManager;
import com.example.myshop.utils.RxUtils;

public class ChannelRcyModel extends BaseModel implements IChannelRcy.Model {

    @Override
    public void getHoemRcy(Callback callback, String categoryId) {
        addDisposible(
                HttpManager.getInstance().getService().gethomercy(categoryId)
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<ChannelRcyBean>(callback) {
                    @Override
                    public void onNext(ChannelRcyBean homeRcyBean) {
                        callback.success(homeRcyBean);
                    }
                })
        );
    }
}
