package com.example.myshop.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myshop.R;
import com.example.myshop.base.BaseActivity;
import com.example.myshop.interfaces.home.IBrandTitleImg;
import com.example.myshop.model.home.BrandTitleImgBean;
import com.example.myshop.model.home.BrandTitleImgRcyBean;
import com.example.myshop.persenter.home.BrandTitleImgPersenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeBrandTitleImgActivity extends BaseActivity<BrandTitleImgPersenter> implements IBrandTitleImg.View {


    @BindView(R.id.title_img_img)
    ImageView titleImgImg;
    @BindView(R.id.title_img_name)
    TextView titleImgName;
    @BindView(R.id.title_img_tv)
    TextView titleImgTv;
    @BindView(R.id.title_img_rcy)
    RecyclerView titleImgRcy;
    private int id;

    @Override
    protected int getLayout() {
        return R.layout.activity_home_brand_title_img;
    }
    @Override
    protected BrandTitleImgPersenter createPrenter() {
        return new BrandTitleImgPersenter(this);
    }
    @Override
    protected void initView() {
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
    }

    @Override
    protected void initData() {
        persenter.getHomeBrandTitleImg(id + "");
        persenter.getHomeBrandTitleImgRcy(id+"");
    }

    @Override
    public void getHomeBrandTitleImgReturn(BrandTitleImgBean result) {
        String name = result.getData().getBrand().getName();
        String url = result.getData().getBrand().getList_pic_url();
        String desc = result.getData().getBrand().getSimple_desc();
        titleImgName.setText(name);
        titleImgTv.setText(desc);
        Glide.with(this).load(url).into(titleImgImg);

    }

    @Override
    public void getHomeBrandTitleImgRcyReturn(BrandTitleImgRcyBean result) {
        List<BrandTitleImgRcyBean.DataBeanX.DataBean> data = result.getData().getData();
        //rcy
        titleImgRcy.setLayoutManager(new GridLayoutManager(this,2));
        titleImgRcy.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        titleImgRcy.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL));
        HomeBrandTitleImgAdpter homeBrandTitleImgAdpter = new HomeBrandTitleImgAdpter(this,data);
        titleImgRcy.setAdapter(homeBrandTitleImgAdpter);
    }

    @Override
    public void showTips(String tips) {
        Log.e("err", "showTips: " + tips);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}