package com.example.myshop.interfaces.home;

import com.example.myshop.interfaces.Callback;
import com.example.myshop.interfaces.IBaseModel;
import com.example.myshop.interfaces.IBasePresenter;
import com.example.myshop.interfaces.IBaseView;
import com.example.myshop.model.home.GoodDetailBean;
import com.example.myshop.model.home.HomeModelBean;

public interface IGoodDetail {
    interface View extends IBaseView {
        void  getGoodDetailResult(GoodDetailBean result);
    }
    interface Model extends IBaseModel {
        void  getGoodDetail(Callback callback,int id);
    }
    interface Persenter extends IBasePresenter<IGoodDetail.View> {
        void getGoodDetail(int id);
    }
}
