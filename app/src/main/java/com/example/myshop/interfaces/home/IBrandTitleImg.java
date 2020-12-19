package com.example.myshop.interfaces.home;

import com.example.myshop.interfaces.Callback;
import com.example.myshop.interfaces.IBaseModel;
import com.example.myshop.interfaces.IBasePresenter;
import com.example.myshop.interfaces.IBaseView;
import com.example.myshop.model.home.BrandTitleImgBean;
import com.example.myshop.model.home.BrandTitleImgRcyBean;

public interface IBrandTitleImg {
    interface View extends IBaseView {
        void  getHomeBrandTitleImgReturn(BrandTitleImgBean result);
        void getHomeBrandTitleImgRcyReturn(BrandTitleImgRcyBean result);
    }
    interface Model extends IBaseModel {
        void  getHomeBrandTitleImg(Callback callback, String id);
        void getHomeBrandTitleImgRcy(Callback callback, String id);
    }
    interface Persenter extends IBasePresenter<IBrandTitleImg.View> {
        void getHomeBrandTitleImg(String id);
        void getHomeBrandTitleImgRcy(String id);
    }
}
