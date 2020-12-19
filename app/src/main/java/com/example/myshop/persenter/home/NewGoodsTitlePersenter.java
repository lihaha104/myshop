package com.example.myshop.persenter.home;

import com.example.myshop.base.BasePresenter;
import com.example.myshop.interfaces.Callback;
import com.example.myshop.interfaces.home.IHome;
import com.example.myshop.interfaces.home.INewGoodsTitle;
import com.example.myshop.model.home.NewGoodsTitleBean;
import com.example.myshop.model.home.NewGoodsTitleModel;

import java.util.Map;

public class NewGoodsTitlePersenter extends BasePresenter<INewGoodsTitle.View> implements INewGoodsTitle.Persenter {
    INewGoodsTitle.Model model;
    INewGoodsTitle.View view;

    public NewGoodsTitlePersenter(INewGoodsTitle.View view) {
        this.view = view;
        model=new NewGoodsTitleModel();
    }

    @Override
    public void gethomenewgoodstitle(Map map) {
        model.gethomenewgoodstitle(new Callback<NewGoodsTitleBean>() {
            @Override
            public void success(NewGoodsTitleBean newGoodsTitleBean) {
               view.gethomenewgoodstitleReturn(newGoodsTitleBean);
            }

            @Override
            public void fail(String err) {

            }


        },map);
    }
}
