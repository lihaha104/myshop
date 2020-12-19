package com.example.myshop.interfaces.home;

import com.example.myshop.interfaces.Callback;
import com.example.myshop.interfaces.IBaseModel;
import com.example.myshop.interfaces.IBasePresenter;
import com.example.myshop.interfaces.IBaseView;
import com.example.myshop.model.home.BrandTitleBean;

public interface IBrandTitle {
    interface View extends IBaseView {
        void  getHomeBrandTitleReturn(BrandTitleBean result);
    }
    interface Model extends IBaseModel {
        void  getHomeBrandTitle(Callback callback,String page);
    }
    interface Persenter extends IBasePresenter<IBrandTitle.View> {
        void getHomeBrandTitle(String page);
    }
}
