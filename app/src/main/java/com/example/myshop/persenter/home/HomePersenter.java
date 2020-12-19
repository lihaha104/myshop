package com.example.myshop.persenter.home;

import com.example.myshop.base.BasePresenter;
import com.example.myshop.interfaces.Callback;
import com.example.myshop.interfaces.home.IHome;
import com.example.myshop.model.home.HomeModelBean;
import com.example.myshop.model.home.HomeModel;

public class HomePersenter extends BasePresenter<IHome.View> implements IHome.Persenter {
    IHome.Model model;
    IHome.View view;


    public HomePersenter(IHome.View view) {
        this.view = view;
        this.model = new HomeModel();
    }

    @Override
    public void getHome() {
        model.getHome(new Callback<HomeModelBean>() {
            @Override
            public void success(HomeModelBean homeModelBean) {
                if(view!=null){
                    view.getHomeReturn(homeModelBean);
                }
            }

            @Override
            public void fail(String err) {

                if(mView!=null){
                    view.showTips(err);
                }
            }
        });
    }
}
