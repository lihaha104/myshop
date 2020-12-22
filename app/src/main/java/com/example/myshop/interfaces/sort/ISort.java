package com.example.myshop.interfaces.sort;

import com.example.myshop.interfaces.Callback;
import com.example.myshop.interfaces.IBaseModel;
import com.example.myshop.interfaces.IBasePresenter;
import com.example.myshop.interfaces.IBaseView;
import com.example.myshop.interfaces.home.IHome;
import com.example.myshop.model.home.HomeModelBean;
import com.example.myshop.model.sort.SortModelBean;
import com.example.myshop.model.sort.SortModelRcyBean;

public interface ISort {
    interface View extends IBaseView {
        //获得sort数据
        void  getSortReturn(SortModelBean result);
        void  getSortRcyReturn(SortModelRcyBean result);
    }
    interface Model extends IBaseModel {
        void  getSort(Callback callback);
        void  getSortRcy(Callback callback,String id);
    }
    interface Persenter extends IBasePresenter<ISort.View> {
        void getSort();
        void getSortRcy(String id);
    }
}
