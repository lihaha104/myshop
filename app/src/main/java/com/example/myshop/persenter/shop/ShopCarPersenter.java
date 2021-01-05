package com.example.myshop.persenter.shop;

import android.util.Log;

import com.example.myshop.base.BasePresenter;
import com.example.myshop.interfaces.Callback;
import com.example.myshop.interfaces.shop.IShop;
import com.example.myshop.model.shop.DeleteCarBean;
import com.example.myshop.model.shop.ShopCarDataBean;
import com.example.myshop.model.shop.ShopCarModel;
import com.example.myshop.model.shop.UpdateCarBean;

import java.util.Map;

public class ShopCarPersenter extends BasePresenter<IShop.View> implements IShop.Presenter {
    IShop.View view;
    IShop.Model model;

    public ShopCarPersenter(IShop.View view) {
        this.view = view;
        model = new ShopCarModel();
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


    //更新购物车
    @Override
    public void updateShopCar(Map<String, String> map) {
        model.updateCar(map, new Callback<UpdateCarBean>() {
            @Override
            public void success(UpdateCarBean data) {
                    view.updateShopCarReturn(data);
            }
            @Override
            public void fail(String err) {

            }
        });
    }
    // 删除购物车列表
    @Override
    public void deleteShopCar(String pIds) {
        model.deleteCar(pIds, new Callback<DeleteCarBean>() {
            @Override
            public void success(DeleteCarBean data) {
              view.deleteShopCarReturn(data);

            }

            @Override
            public void fail(String err) {

            }
        });
    }
}



