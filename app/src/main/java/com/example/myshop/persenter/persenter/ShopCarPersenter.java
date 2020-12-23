package com.example.myshop.persenter.persenter;

import com.example.myshop.base.BasePresenter;
import com.example.myshop.interfaces.Callback;
import com.example.myshop.interfaces.shop.IShop;
import com.example.myshop.model.shop.ShopCarDataBean;

public class ShopCarPersenter extends BasePresenter<IShop.View> implements IShop.Presenter {
    IShop.View view;
    IShop.Model model;
    @Override
    public void getshop() {
        model.getshop(new Callback<ShopCarDataBean>() {

            @Override
            public void success(ShopCarDataBean shopCarDataBean) {
                view.getShopReturn(shopCarDataBean);
            }

            @Override
            public void fail(String err) {

            }
        });
    }
}
