package com.example.myshop.persenter.login;

import com.example.myshop.base.BasePresenter;

import com.example.myshop.interfaces.Callback;
import com.example.myshop.interfaces.login.ILogin;
import com.example.myshop.model.login.LoginBean;
import com.example.myshop.model.login.LoginModel;
import com.example.myshop.model.shop.ShopCarModel;

public class LoginPersenter extends BasePresenter<ILogin.View> implements ILogin.Persenter {
    ILogin.Model model;
    ILogin.View view;

    public LoginPersenter(ILogin.View view) {
        this.view = view;
        model = new LoginModel();
    }

    @Override
    public void myLogin(String username, String pw) {
    model.myLogin(username, pw, new Callback<LoginBean>() {
        @Override
        public void success(LoginBean loginBean) {
            view.loginReturn(loginBean);
        }

        @Override
        public void fail(String err) {

        }
    });
    }
}
