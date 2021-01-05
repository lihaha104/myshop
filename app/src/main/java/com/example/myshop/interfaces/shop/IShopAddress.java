package com.example.myshop.interfaces.shop;


import com.example.myshop.interfaces.Callback;
import com.example.myshop.interfaces.IBaseModel;
import com.example.myshop.interfaces.IBasePresenter;
import com.example.myshop.interfaces.IBaseView;
import com.example.myshop.model.shop.AddressAddProvinceBean;
import com.example.myshop.model.shop.AddressBean;

public interface IShopAddress {

    interface View extends IBaseView {
        //地址列表
        void getAddressReturn(AddressBean result);
        //添加地址
        //省市区县数据
        void getAddressAddProvinceReturn(AddressAddProvinceBean result);
    }

    interface Presenter extends IBasePresenter<View> {
        //地址列表
        void getAddressList();
        //添加地址
        //省市区县数据
        void getAddressAddProvince(int parentId);
    }

    interface Model extends IBaseModel {
        //地址列表
        void getAddressList(Callback callback);
        //添加地址
        //省市区县数据
        void getAddressAddProvince(int parentId, Callback callback);
    }

}
