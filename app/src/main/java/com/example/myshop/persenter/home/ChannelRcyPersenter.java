package com.example.myshop.persenter.home;

import com.example.myshop.base.BasePresenter;
import com.example.myshop.interfaces.Callback;
import com.example.myshop.interfaces.home.IChannelRcy;
import com.example.myshop.model.home.ChannelRcyBean;
import com.example.myshop.model.home.ChannelRcyModel;

public class ChannelRcyPersenter extends BasePresenter<IChannelRcy.View>  implements IChannelRcy.Persenter{
    IChannelRcy.Model model;
    IChannelRcy.View view;


    public ChannelRcyPersenter(IChannelRcy.View view) {
        this.view = view;
        this.model = new ChannelRcyModel();
    }

    @Override
    public void gethomeRcy(String categoryId) {
        model.getHoemRcy(new Callback<ChannelRcyBean>() {
            @Override
            public void success(ChannelRcyBean homeRcyBean) {
                view.gethomercyReturn(homeRcyBean);
            }

            @Override
            public void fail(String err) {

            }
        },categoryId);
    }
}
