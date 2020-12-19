package com.example.myshop.interfaces.home;

import com.example.myshop.interfaces.Callback;
import com.example.myshop.interfaces.IBaseModel;
import com.example.myshop.interfaces.IBasePresenter;
import com.example.myshop.interfaces.IBaseView;
import com.example.myshop.model.home.NewGoodsTitleBean;

import java.util.Map;

public interface INewGoodsTitle {
    interface View extends IBaseView {
        void   gethomenewgoodstitleReturn(NewGoodsTitleBean result);
    }
    interface Model extends IBaseModel {
        void gethomenewgoodstitle(Callback callback,Map map);
    }
    interface Persenter extends IBasePresenter<INewGoodsTitle.View> {
        void gethomenewgoodstitle(Map map);
    }
}
