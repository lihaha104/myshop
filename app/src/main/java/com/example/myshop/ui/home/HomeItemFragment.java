package com.example.myshop.ui.home;

import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myshop.R;
import com.example.myshop.base.BaseFragment;
import com.example.myshop.interfaces.home.IChannelRcy;
import com.example.myshop.model.home.ChannelRcyBean;
import com.example.myshop.model.home.ChannelTabBean;
import com.example.myshop.persenter.home.ChannelRcyPersenter;

import java.util.List;

import butterknife.BindView;

public class HomeItemFragment extends BaseFragment<ChannelRcyPersenter> implements IChannelRcy.View {

    @BindView(R.id.rcy)
    RecyclerView rcy;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_content)
    TextView tvContent;
    private ChannelTabBean.DataBean.BrotherCategoryBean brotherCategoryBean;

    public HomeItemFragment(ChannelTabBean.DataBean.BrotherCategoryBean brotherCategoryBean) {
        this.brotherCategoryBean = brotherCategoryBean;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_home_homeitem;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected ChannelRcyPersenter createPrenter() {
        return new ChannelRcyPersenter(this);
    }

    @Override
    protected void initData() {
        presenter.gethomeRcy(brotherCategoryBean.getId() + "");
    }

    @Override
    public void gethomercyReturn(ChannelRcyBean homeTabBean) {
        tvTitle.setText(brotherCategoryBean.getName());
        tvContent.setText(brotherCategoryBean.getFront_name());
        rcy.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        List<ChannelRcyBean.DataBeanX.DataBean> data = homeTabBean.getData().getData();
        //创建适配器
        HomeItemFragmentAdpter homeItemFragmentAdpter = new HomeItemFragmentAdpter(getActivity(), data);
        rcy.setAdapter(homeItemFragmentAdpter);

    }

    @Override
    public void showTips(String tips) {

    }
}
