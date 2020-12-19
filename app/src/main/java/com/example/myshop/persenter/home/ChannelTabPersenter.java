package com.example.myshop.persenter.home;

import com.example.myshop.base.BasePresenter;
import com.example.myshop.interfaces.Callback;
import com.example.myshop.interfaces.home.IChannelTab;
import com.example.myshop.model.home.ChannelTabBean;
import com.example.myshop.model.home.ChannelTabModel;

public class ChannelTabPersenter extends BasePresenter<IChannelTab.View> implements IChannelTab.Persenter {
    IChannelTab.Model model;
    IChannelTab.View view;

    public ChannelTabPersenter(IChannelTab.View view) {
        this.view = view;
        this.model=new ChannelTabModel();
    }

    @Override
    public void gethometab(String id) {
        model.getHoemTable(new Callback<ChannelTabBean>() {
            @Override
            public void success(ChannelTabBean homeTabBean) {
                view.gethometabReturn(homeTabBean);
            }

            @Override
            public void fail(String err) {
                view.showTips(err);
            }
        },id);
    }
}
