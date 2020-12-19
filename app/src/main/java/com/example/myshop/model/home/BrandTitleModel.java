package com.example.myshop.model.home;

import com.example.myshop.base.BaseModel;
import com.example.myshop.interfaces.Callback;
import com.example.myshop.interfaces.home.IBrandTitle;
import com.example.myshop.net.CommonSubscriber;
import com.example.myshop.net.HttpManager;
import com.example.myshop.utils.RxUtils;

public class BrandTitleModel extends BaseModel implements IBrandTitle.Model {

    @Override
    public void getHomeBrandTitle(Callback callback, String page) {
        addDisposible(
                HttpManager.getInstance().getService().gethomebrandtitle(page)
                        .compose(RxUtils.rxScheduler())
                        .subscribeWith(new CommonSubscriber<BrandTitleBean>(callback) {
                            @Override
                            public void onNext(BrandTitleBean homeBrandTitleBean) {
                                callback.success(homeBrandTitleBean);
                            }
                        })
        );
    }
}
