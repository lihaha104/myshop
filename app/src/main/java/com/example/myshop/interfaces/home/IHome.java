package com.example.myshop.interfaces.home;

import com.example.myshop.interfaces.Callback;
import com.example.myshop.interfaces.IBaseModel;
import com.example.myshop.interfaces.IBasePresenter;
import com.example.myshop.interfaces.IBaseView;
import com.example.myshop.model.home.HomeModelBean;

public interface IHome {
    interface View extends IBaseView {
        void  getHomeReturn(HomeModelBean result);
    }
    interface Model extends IBaseModel{
        void  getHome(Callback callback);
    }
    interface Persenter extends IBasePresenter<View>{
        void getHome();
    }
}
