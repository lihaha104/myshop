package com.example.myshop.interfaces.home;

import com.example.myshop.interfaces.Callback;
import com.example.myshop.interfaces.IBaseModel;
import com.example.myshop.interfaces.IBasePresenter;
import com.example.myshop.interfaces.IBaseView;
import com.example.myshop.model.home.GoodDetailBean;
import com.example.myshop.model.home.HomeModelBean;
import com.example.myshop.model.shop.ShopCarDataBean;

import java.util.Map;

public interface IGoodDetail {
    interface View extends IBaseView {
        void  getGoodDetailResult(GoodDetailBean result);
        void addShopCarReturn(ShopCarDataBean addCarBean);
    }
    interface Model extends IBaseModel {
        void  getGoodDetail(Callback callback,int id);
        //添加进购物车
        void addShopCar(Map<String,String> map,Callback callback);

    }
    interface Persenter extends IBasePresenter<IGoodDetail.View> {
        void getGoodDetail(int id);
        //添加进购物车

        void addShopCar(Map<String,String> map);
    }
}
