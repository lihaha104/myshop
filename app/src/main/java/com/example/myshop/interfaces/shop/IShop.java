package com.example.myshop.interfaces.shop;

import com.example.myshop.interfaces.Callback;
import com.example.myshop.interfaces.IBaseModel;
import com.example.myshop.interfaces.IBasePresenter;
import com.example.myshop.interfaces.IBaseView;
import com.example.myshop.model.shop.DeleteCarBean;
import com.example.myshop.model.shop.ShopCarDataBean;
import com.example.myshop.model.shop.UpdateCarBean;

import java.util.Map;

public interface IShop {

    interface View extends IBaseView {
        void getShopReturn(ShopCarDataBean carBean);
        //更新 购物车
        void updateShopCarReturn(UpdateCarBean result);
        //删除购物车
        void deleteShopCarReturn(DeleteCarBean result);
    }

    interface Presenter extends IBasePresenter<View> {
        void getshop();
        //更新购物车的数据
        void  updateShopCar(Map<String,String> map);
        //删除购物车列表
        void deleteShopCar(String pIds);
    }

    interface Model extends IBaseModel {
        void getshop(Callback callback);
        void updateCar(Map<String,String> map,Callback callback);
        void deleteCar(String pIds,Callback callback);
    }

}
