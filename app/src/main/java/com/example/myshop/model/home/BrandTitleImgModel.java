package com.example.myshop.model.home;

import com.example.myshop.base.BaseModel;
import com.example.myshop.interfaces.Callback;
import com.example.myshop.interfaces.home.IBrandTitleImg;
import com.example.myshop.net.CommonSubscriber;
import com.example.myshop.net.HttpManager;
import com.example.myshop.utils.RxUtils;

public class BrandTitleImgModel extends BaseModel implements IBrandTitleImg.Model {
    @Override
    public void getHomeBrandTitleImg(Callback callback, String id) {
        addDisposible(
                HttpManager.getInstance().getService().gethomebrandtitleimg(id)
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<BrandTitleImgBean>(callback) {
                    @Override
                    public void onNext(BrandTitleImgBean homeBrandTitleImgBean) {
                        callback.success(homeBrandTitleImgBean);
                    }
                })
        );
    }

    @Override
    public void getHomeBrandTitleImgRcy(Callback callback, String id) {
        addDisposible(
                HttpManager.getInstance().getService().gethomebrandtitleimgRcy(id)
                        .compose(RxUtils.rxScheduler())
                        .subscribeWith(new CommonSubscriber<BrandTitleImgRcyBean>(callback) {
                            @Override
                            public void onNext(BrandTitleImgRcyBean homeBrandTitleImgRcyBean) {
                                callback.success(homeBrandTitleImgRcyBean);
                            }
                        })
        );
    }
}
