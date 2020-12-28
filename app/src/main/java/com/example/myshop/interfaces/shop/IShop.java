package com.example.myshop.interfaces.shop;

import com.example.myshop.interfaces.Callback;
import com.example.myshop.interfaces.IBaseModel;
import com.example.myshop.interfaces.IBasePresenter;
import com.example.myshop.interfaces.IBaseView;
import com.example.myshop.model.shop.ShopCarDataBean;

public interface IShop {

    interface View extends IBaseView {
        void getShopReturn(ShopCarDataBean carBean);
    }

    interface Presenter extends IBasePresenter<View> {
        void getshop();
    }

    interface Model extends IBaseModel {
        void getshop(Callback callback);
    }

}
