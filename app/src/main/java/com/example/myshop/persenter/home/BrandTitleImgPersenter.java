package com.example.myshop.persenter.home;

import com.example.myshop.base.BasePresenter;
import com.example.myshop.interfaces.Callback;
import com.example.myshop.interfaces.home.IBrandTitleImg;
import com.example.myshop.model.home.BrandTitleImgBean;
import com.example.myshop.model.home.BrandTitleImgModel;
import com.example.myshop.model.home.BrandTitleImgRcyBean;

public class BrandTitleImgPersenter extends BasePresenter<IBrandTitleImg.View> implements IBrandTitleImg.Persenter {
    IBrandTitleImg.View view;
    IBrandTitleImg.Model model;

    public BrandTitleImgPersenter(IBrandTitleImg.View view) {
        this.view = view;
        model=new BrandTitleImgModel();
    }

    @Override
    public void getHomeBrandTitleImg(String id) {
        model.getHomeBrandTitleImg(new Callback<BrandTitleImgBean>() {
               @Override
            public void success(BrandTitleImgBean homeBrandTitleImgBean) {
                view.getHomeBrandTitleImgReturn(homeBrandTitleImgBean);
            }

            @Override
            public void fail(String err) {

            }
        },id);
    }

    @Override
    public void getHomeBrandTitleImgRcy(String id) {
        model.getHomeBrandTitleImgRcy(new Callback<BrandTitleImgRcyBean>() {
            @Override
            public void success(BrandTitleImgRcyBean homeBrandTitleImgRcyBean) {
                view.getHomeBrandTitleImgRcyReturn(homeBrandTitleImgRcyBean);
            }

            @Override
            public void fail(String err) {

            }
        },id);
    }
}
