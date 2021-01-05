package com.example.myshop.ui.shop;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myshop.R;
import com.example.myshop.app.MyApp;
import com.example.myshop.base.BaseActivity;
import com.example.myshop.base.BasePresenter;
import com.example.myshop.model.shop.ShopCarDataBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrderActivity extends BaseActivity {

    @BindView(R.id.txt_counponNumber)
    TextView txtCounponNumber;
    @BindView(R.id.layout_total)
    ConstraintLayout layoutTotal;
    @BindView(R.id.layout_cost)
    ConstraintLayout layoutCost;
    @BindView(R.id.layout_coupon)
    ConstraintLayout layoutCoupon;
    @BindView(R.id.recy_good)
    RecyclerView recyGood;
    @BindView(R.id.txt_price)
    TextView txtPrice;
    @BindView(R.id.mRl)
    RelativeLayout mRl;

    private TextView txtTotalLt, txtTotalRt, txtCostLt, txtCostRt, txtCouponLt, txtCouponRt;
    private ArrayList<ShopCarDataBean.DataBean.CartListBean> list;

    @Override
    protected int getLayout() {
        return R.layout.activity_order;
    }

    @Override
    protected BasePresenter createPrenter() {
        return null;
    }

    @Override
    protected void initView() {
        list = (ArrayList<ShopCarDataBean.DataBean.CartListBean>) MyApp.getMap().get("shop");
        Toast.makeText(this, ""+list.size(), Toast.LENGTH_SHORT).show();
        txtTotalLt = layoutTotal.findViewById(R.id.txt_left);
        txtTotalRt = layoutTotal.findViewById(R.id.txt_right);
        txtCostLt = layoutCost.findViewById(R.id.txt_left);
        txtCostRt = layoutCost.findViewById(R.id.txt_right);
        txtCouponLt = layoutCoupon.findViewById(R.id.txt_left);
        txtCouponRt = layoutCoupon.findViewById(R.id.txt_right);
        txtTotalLt.setText("商品合计");
        int sum = 0;
        for (ShopCarDataBean.DataBean.CartListBean item : list) {
            sum += (item.getRetail_price() * item.getNumber());
        }
        txtTotalRt.setText(list.size() + "");
        txtCostLt.setText("运费");
        txtCostRt.setText("￥0");
        txtCouponLt.setText("优惠券");
        txtCouponRt.setText("-￥0");
        txtPrice.setText("￥" + sum);
    }

    @Override
    protected void initData() {

        recyGood.setLayoutManager(new LinearLayoutManager(this));
        recyGood.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        OrderGoodsAdapter orderGoodsAdapter = new OrderGoodsAdapter(this, list);
        recyGood.setAdapter(orderGoodsAdapter);
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

    @OnClick(R.id.mRl)
    public void onViewClicked() {
        Intent intent = new Intent(this, ShopAddressesActivity.class);
        startActivity(intent);
    }
}