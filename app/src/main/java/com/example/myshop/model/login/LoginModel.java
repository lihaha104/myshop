package com.example.myshop.model.login;

import com.example.myshop.base.BaseModel;
import com.example.myshop.interfaces.Callback;
import com.example.myshop.interfaces.login.ILogin;
import com.example.myshop.net.CommonSubscriber;
import com.example.myshop.net.HttpManager;
import com.example.myshop.utils.RxUtils;

public class LoginModel extends BaseModel implements ILogin.Model {
    @Override
    public void myLogin(String username, String pw, Callback callback) {
        addDisposible(
                HttpManager.getInstance().getService()
                .myLogin(username,pw)
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<LoginBean>(callback) {
                    @Override
                    public void onNext(LoginBean loginBean) {
                        callback.success(loginBean);
                    }
                })
        );
    }
}
