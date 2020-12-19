package com.example.myshop.model.home;

import com.example.myshop.base.BaseModel;
import com.example.myshop.interfaces.Callback;
import com.example.myshop.interfaces.home.IChannelTab;
import com.example.myshop.net.CommonSubscriber;
import com.example.myshop.net.HttpManager;
import com.example.myshop.utils.RxUtils;

public class ChannelTabModel extends BaseModel implements IChannelTab.Model {
    @Override
    public void getHoemTable(Callback callback, String id) {
        addDisposible(
                HttpManager.getInstance().getService().gethometab(id)
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<ChannelTabBean>(callback) {
                    @Override
                    public void onNext(ChannelTabBean homeTabBean) {
                        callback.success(homeTabBean);
                    }
                })
        );
    }
}
