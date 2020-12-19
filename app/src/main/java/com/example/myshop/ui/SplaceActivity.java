package com.example.myshop.ui;

import android.content.Intent;

import com.example.myshop.R;
import com.example.myshop.base.BaseActivity;
import com.example.myshop.base.BasePresenter;
import com.example.myshop.interfaces.IBasePresenter;

public class SplaceActivity extends BaseActivity {

    @Override
    protected int getLayout() {
        return R.layout.activity_splace;
    }

    @Override
    protected BasePresenter createPrenter() {
        return null;
    }


    @Override
    protected void initView() {
        startActivity(new Intent(SplaceActivity.this,MainActivity.class));
    }

    @Override
    protected void initData() {

    }

    @Override
    public void showTips(String tips) {

    }
}