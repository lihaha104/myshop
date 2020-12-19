package com.example.myshop.persenter.home;

import com.example.myshop.base.BasePresenter;
import com.example.myshop.interfaces.Callback;
import com.example.myshop.interfaces.home.IBrandTitle;
import com.example.myshop.model.home.BrandTitleBean;
import com.example.myshop.model.home.BrandTitleModel;

public class BrandTitlePersenter extends BasePresenter<IBrandTitle.View> implements IBrandTitle.Persenter {
    IBrandTitle.View view;
    IBrandTitle.Model model;

    public BrandTitlePersenter(IBrandTitle.View view) {
        this.view = view;
        model=new BrandTitleModel();
    }


    @Override
    public void getHomeBrandTitle(String page) {
        model.getHomeBrandTitle(new Callback<BrandTitleBean>() {
            @Override
            public void success(BrandTitleBean homeBrandTitleBean) {
                view.getHomeBrandTitleReturn(homeBrandTitleBean);
            }

            @Override
            public void fail(String err) {

            }
        },page);
    }
}
