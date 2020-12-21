package com.example.myshop.model.home;

import com.example.myshop.base.BaseModel;
import com.example.myshop.interfaces.Callback;
import com.example.myshop.interfaces.home.INewGoodsTitle;
import com.example.myshop.net.CommonSubscriber;
import com.example.myshop.net.HttpManager;
import com.example.myshop.utils.RxUtils;

import java.util.Map;

import io.reactivex.disposables.Disposable;

public class NewGoodsTitleModel extends BaseModel implements INewGoodsTitle.Model{

    @Override
    public void gethomenewgoodstitle(Callback callback, Map map) {
       addDisposible(
               (Disposable) HttpManager.getInstance().getService().gethomenewgoodstitle(map)
               .compose(RxUtils.rxScheduler())
               .subscribeWith(new CommonSubscriber<NewGoodsTitleBean>(callback) {
                   @Override
                   public void onNext(NewGoodsTitleBean newGoodsTitleBean) {
                       callback.success(newGoodsTitleBean);
                   }

               })
       );
    }
}
