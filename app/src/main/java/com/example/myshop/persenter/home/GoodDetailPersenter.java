package com.example.myshop.persenter.home;

import com.example.myshop.base.BasePresenter;
import com.example.myshop.interfaces.Callback;
import com.example.myshop.interfaces.home.IGoodDetail;
import com.example.myshop.interfaces.home.IHome;
import com.example.myshop.model.home.GoodDetailBean;
import com.example.myshop.model.home.GoodDetailModel;
import com.example.myshop.model.home.HomeModel;
import com.example.myshop.model.home.HomeModelBean;

public class GoodDetailPersenter extends BasePresenter<IGoodDetail.View> implements IGoodDetail.Persenter {
    IGoodDetail.Model model;
    IGoodDetail.View view;


    public GoodDetailPersenter(IGoodDetail.View view) {
        this.view = view;
        this.model = new GoodDetailModel();
    }
    @Override
    public void getGoodDetail(int id) {
        model.getGoodDetail(new Callback<GoodDetailBean>() {
            @Override
            public void success(GoodDetailBean goodDetailBean) {
                view.getGoodDetailResult(goodDetailBean);
            }

            @Override
            public void fail(String err) {

            }
        },id);
    }
}
