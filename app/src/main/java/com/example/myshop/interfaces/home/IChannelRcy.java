package com.example.myshop.interfaces.home;

import com.example.myshop.interfaces.Callback;
import com.example.myshop.interfaces.IBaseModel;
import com.example.myshop.interfaces.IBasePresenter;
import com.example.myshop.interfaces.IBaseView;
import com.example.myshop.model.home.ChannelRcyBean;

public interface IChannelRcy {
    interface View extends IBaseView {
        void   gethomercyReturn(ChannelRcyBean homeTabBean);
    }
    interface Model extends IBaseModel {
        void getHoemRcy(Callback callback, String categoryId);
    }
    interface Persenter extends IBasePresenter<IChannelRcy.View> {
        void gethomeRcy(String categoryId);
    }
}
