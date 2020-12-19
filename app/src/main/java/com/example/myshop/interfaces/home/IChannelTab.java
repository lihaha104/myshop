package com.example.myshop.interfaces.home;

import com.example.myshop.interfaces.Callback;
import com.example.myshop.interfaces.IBaseModel;
import com.example.myshop.interfaces.IBasePresenter;
import com.example.myshop.interfaces.IBaseView;
import com.example.myshop.model.home.ChannelTabBean;

public interface IChannelTab {
    interface View extends IBaseView {
        void   gethometabReturn(ChannelTabBean homeTabBean);
    }
    interface Model extends IBaseModel {
        void getHoemTable(Callback callback,String id);
    }
    interface Persenter extends IBasePresenter<IChannelTab.View> {
        void gethometab(String id);
    }
}
