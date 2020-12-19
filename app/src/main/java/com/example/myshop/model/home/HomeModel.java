package com.example.myshop.model.home;

import com.example.myshop.base.BaseModel;
import com.example.myshop.interfaces.Callback;
import com.example.myshop.interfaces.home.IHome;
import com.example.myshop.net.CommonSubscriber;
import com.example.myshop.net.HttpManager;
import com.example.myshop.utils.RxUtils;

public class HomeModel extends BaseModel implements IHome.Model {

    @Override
    public void getHome(Callback callback) {
        addDisposible(HttpManager.getInstance().getService().getHome()
            .compose(RxUtils.rxScheduler())
             .subscribeWith(new CommonSubscriber<HomeModelBean>(callback) {
                 @Override
                 public void onNext(HomeModelBean homeModelBean) {
                    callback.success(homeModelBean);
                 }
             })
        );
    }
}
