package com.example.myshop.model.home;

import com.example.myshop.base.BaseModel;
import com.example.myshop.interfaces.Callback;
import com.example.myshop.interfaces.home.IGoodDetail;
import com.example.myshop.net.CommonSubscriber;
import com.example.myshop.net.HttpManager;
import com.example.myshop.utils.RxUtils;

public class GoodDetailModel extends BaseModel implements IGoodDetail.Model {

    @Override
    public void getGoodDetail(Callback callback, int id) {
        addDisposible(
                HttpManager.getInstance().getService().getGoodDetail(id)
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<GoodDetailBean>(callback) {
                    @Override
                    public void onNext(GoodDetailBean goodDetailBean) {
                        callback.success(goodDetailBean);
                    }
                })

        );
    }
}
