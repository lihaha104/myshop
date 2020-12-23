package com.example.myshop.interfaces.login;

import com.example.myshop.interfaces.Callback;
import com.example.myshop.interfaces.IBaseModel;
import com.example.myshop.interfaces.IBasePresenter;
import com.example.myshop.interfaces.IBaseView;
import com.example.myshop.model.login.LoginBean;

public interface ILogin {
    interface View extends IBaseView {
        void loginReturn(LoginBean loginBean);
    }

    interface Persenter extends IBasePresenter<View> {
        void myLogin(String username,String pw);
    }


    interface Model extends IBaseModel {
        void myLogin(String username,String pw, Callback callback);
    }
}