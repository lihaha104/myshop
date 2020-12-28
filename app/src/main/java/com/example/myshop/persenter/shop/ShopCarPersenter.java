package com.example.myshop.persenter.shop;

import com.example.myshop.base.BasePresenter;
import com.example.myshop.interfaces.Callback;
import com.example.myshop.interfaces.shop.IShop;
import com.example.myshop.model.shop.ShopCarDataBean;
import com.example.myshop.model.shop.ShopCarModel;

public class ShopCarPersenter extends BasePresenter<IShop.View> implements IShop.Presenter {
    IShop.View view;
    IShop.Model model;

    public ShopCarPersenter(IShop.View view) {
        this.view = view;
        model=new ShopCarModel();
    }

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
