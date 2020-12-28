package com.example.myshop.ui.me;


import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myshop.R;
import com.example.myshop.base.BaseFragment;
import com.example.myshop.base.BasePresenter;
import com.example.myshop.ui.LoginActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class MeFragment extends BaseFragment {
    @BindView(R.id.me_head_img)
    ImageView meHeadImg;
    @BindView(R.id.me_head_login)
    TextView meHeadLogin;
    @BindView(R.id.me_head_jt_img)
    ImageView meHeadJtImg;
    @BindView(R.id.me_ll_dingdan)
    LinearLayout meLlDingdan;
    @BindView(R.id.me_ll_youhuiquan)
    LinearLayout meLlYouhuiquan;
    @BindView(R.id.me_ll_lipinka)
    LinearLayout meLlLipinka;
    @BindView(R.id.me_ll_shoucang)
    LinearLayout meLlShoucang;
    @BindView(R.id.me_ll_zuji)
    LinearLayout meLlZuji;
    @BindView(R.id.me_ll_fuli)
    LinearLayout meLlFuli;
    @BindView(R.id.me_ll_dizhi)
    LinearLayout meLlDizhi;
    @BindView(R.id.me_ll_zhanghao)
    LinearLayout meLlZhanghao;
    @BindView(R.id.me_ll_lianxi)
    LinearLayout meLlLianxi;
    @BindView(R.id.me_ll_bangzhu)
    LinearLayout meLlBangzhu;
    @BindView(R.id.me_ll_fankui)
    LinearLayout meLlFankui;

    @Override
    protected int getLayout() {
        return R.layout.fragment_me;
    }

    @Override
    protected BasePresenter createPrenter() {
        return null;
    }


    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        meHeadLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mContext.startActivity(new Intent(mContext, LoginActivity.class));

            }
        });
    }

    /**/
    @Override
    public void showTips(String tips) {

    }

    @OnClick(R.id.me_ll_shoucang)
    public void onViewClicked() {
        startActivity(new Intent(mContext,MyCollectionActivity.class));
    }
}
