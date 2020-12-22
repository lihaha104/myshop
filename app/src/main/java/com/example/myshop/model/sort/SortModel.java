package com.example.myshop.model.sort;

import com.example.myshop.base.BaseModel;
import com.example.myshop.interfaces.Callback;
import com.example.myshop.interfaces.sort.ISort;
import com.example.myshop.net.CommonSubscriber;
import com.example.myshop.net.HttpManager;
import com.example.myshop.utils.RxUtils;

public class SortModel extends BaseModel implements ISort.Model {
    @Override
    public void getSort(Callback callback) {
        addDisposible(
                HttpManager.getInstance().getService().getsort()
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<SortModelBean>(callback) {
                    @Override
                    public void onNext(SortModelBean sortModelBean) {
                        callback.success(sortModelBean);
                    }
                })
        );

    }

    @Override
    public void getSortRcy(Callback callback, String id) {
        addDisposible(
             HttpManager.getInstance().getService().getsortRcy(id)
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<SortModelRcyBean>(callback) {
                    @Override
                    public void onNext(SortModelRcyBean sortModelRcyBean) {
                        callback.success(sortModelRcyBean);
                    }
                })
        );
    }


}
