package com.example.myshop.model.shop;

import com.example.myshop.base.BaseModel;
import com.example.myshop.interfaces.Callback;
import com.example.myshop.interfaces.shop.IShopAddress;
import com.example.myshop.net.CommonSubscriber;
import com.example.myshop.net.HttpManager;
import com.example.myshop.utils.RxUtils;

public class ShopAddressesModel extends BaseModel implements IShopAddress.Model {
    @Override
    public void getAddressList(Callback callback) {
        addDisposible(
                HttpManager.getInstance().getService()
                .getAddress()
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<AddressBean>(callback) {
                    @Override
                    public void onNext(AddressBean addressBean) {
                        callback.success(addressBean);
                    }
                })
        );
    }

    @Override
    public void getAddressAddProvince(int parentId, Callback callback) {
        HttpManager.getInstance().getService().getAddressAddProvince(parentId)
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<AddressAddProvinceBean>(callback) {
                    @Override
                    public void onNext(AddressAddProvinceBean addressAddProvinceBean) {
                        callback.success(addressAddProvinceBean);
                    }
                });
    }
}
