package com.example.myshop.model.shop;

import com.example.myshop.base.BaseModel;
import com.example.myshop.interfaces.Callback;
import com.example.myshop.interfaces.shop.IShop;
import com.example.myshop.net.CommonSubscriber;
import com.example.myshop.net.HttpManager;
import com.example.myshop.utils.RxUtils;

public class ShopCarModel extends BaseModel implements IShop.Model {
    @Override
    public void getshop(Callback callback) {
        addDisposible(
                HttpManager.getInstance().getService().getCarList()
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<ShopCarDataBean>(callback) {
                    @Override
                    public void onNext(ShopCarDataBean shopCarDataBean) {
                        callback.success(shopCarDataBean);
                    }
                })
        );
    }
}
