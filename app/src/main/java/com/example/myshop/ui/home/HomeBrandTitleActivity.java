package com.example.myshop.ui.home;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myshop.R;
import com.example.myshop.base.BaseActivity;
import com.example.myshop.interfaces.home.IBrandTitle;
import com.example.myshop.model.home.BrandTitleBean;
import com.example.myshop.persenter.home.BrandTitlePersenter;

import java.util.List;

import butterknife.BindView;

public class HomeBrandTitleActivity extends BaseActivity<BrandTitlePersenter> implements IBrandTitle.View {
    private int page=1;
    @BindView(R.id.home_brand_title_rcy)
    RecyclerView homeBrandTitleRcy;

    @Override
    protected int getLayout() {
        return R.layout.activity_home_brand_title;
    }

    @Override
    protected BrandTitlePersenter createPrenter() {
        return new BrandTitlePersenter(this);
    }


    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
    persenter.getHomeBrandTitle(page+"");
    }

    @Override
    public void getHomeBrandTitleReturn(BrandTitleBean result) {
        homeBrandTitleRcy.setLayoutManager(new LinearLayoutManager(this));
        List<BrandTitleBean.DataBeanX.DataBean> data = result.getData().getData();
        //创建适配器
        HomeBrandTitleAdpter homeBrandTitleAdpter = new HomeBrandTitleAdpter(this,data);
        homeBrandTitleRcy.setAdapter(homeBrandTitleAdpter);
    }

    @Override
    public void showTips(String tips) {

    }
}