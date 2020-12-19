package com.example.myshop.base;

import android.os.Bundle;
import android.os.Looper;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.example.myshop.interfaces.IBasePresenter;
import com.example.myshop.interfaces.IBaseView;


import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseView {


    protected P persenter;
    Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //需要界面
        setContentView(getLayout());
        unbinder = ButterKnife.bind(this);
        persenter=createPrenter();
        //初始化界面
        initView();
        if(persenter!=null){
            persenter.attachView(this);
        }
        //初始化界面数据
        initData();

    }

    protected abstract int getLayout();
    protected abstract P createPrenter();
    protected abstract void initView();
    protected abstract  void initData();

    @Override
    public void showLoading(int visible) {

    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(unbinder!=null){
            unbinder.unbind();
        }
        if(persenter != null){
            persenter.unAttachView();
        }
    }
}
