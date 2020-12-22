package com.example.myshop.persenter.sort;

import com.example.myshop.base.BasePresenter;
import com.example.myshop.interfaces.Callback;
import com.example.myshop.interfaces.sort.ISort;
import com.example.myshop.model.sort.SortModel;
import com.example.myshop.model.sort.SortModelBean;
import com.example.myshop.model.sort.SortModelRcyBean;

public class SortPresenter extends BasePresenter<ISort.View> implements ISort.Persenter {
    ISort.Model model;
    ISort.View view;

    public SortPresenter(ISort.View view) {
        this.view = view;
        model=new SortModel();
    }

    @Override
    public void getSort() {
        model.getSort(new Callback<SortModelBean>() {
            @Override
            public void success(SortModelBean sortModelBean) {
                view.getSortReturn(sortModelBean);
            }

            @Override
            public void fail(String err) {

            }
        });
    }

    @Override
    public void getSortRcy(String id) {
        model.getSortRcy(new Callback<SortModelRcyBean>() {
            @Override
            public void success(SortModelRcyBean sortModelRcyBean) {
                view.getSortRcyReturn(sortModelRcyBean);
            }

            @Override
            public void fail(String err) {

            }
        },id);
    }
}
