package com.example.myshop.ui.shop;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myshop.R;
import com.example.myshop.base.BaseActivity;
import com.example.myshop.interfaces.shop.IShopAddress;
import com.example.myshop.model.shop.AddressAddProvinceBean;
import com.example.myshop.model.shop.AddressBean;
import com.example.myshop.model.shop.ShopAddressesAddActivity;
import com.example.myshop.persenter.shop.ShopAddressesPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ShopAddressesActivity extends BaseActivity<IShopAddress.Presenter> implements IShopAddress.View {
    @BindView(R.id.address_rlv)
    RecyclerView addressRlv;
    @BindView(R.id.address_btn_add)
    Button addressBtnAdd;

    @Override
    protected int getLayout() {
        return R.layout.activity_shop_addresses;
    }

    @Override
    protected ShopAddressesPresenter createPrenter() {
        return new ShopAddressesPresenter(this);
    }


    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void getAddressReturn(AddressBean result) {
        List<AddressBean.DataBean> data = result.getData();
        addressRlv.setLayoutManager(new LinearLayoutManager(this));
        addressRlv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

    }

    @Override
    public void getAddressAddProvinceReturn(AddressAddProvinceBean result) {

    }

    @Override
    public void showTips(String tips) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.address_btn_add)
    public void onViewClicked() {

        Intent intent = new Intent(this, ShopAddressesAddActivity.class);
        //startActivity(intent);
        startActivityForResult(intent,100);
    }
}