package com.example.myshop.ui.me;


import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.myshop.R;
import com.example.myshop.base.BaseFragment;
import com.example.myshop.base.BasePresenter;
import com.example.myshop.ui.LoginActivity;
import com.example.myshop.utils.SpUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class MeFragment extends BaseFragment {

    public static final int LOGIN = 1001;
    public static final int LOGINOUT = 1002;
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
        String token = SpUtils.getInstance().getString("token");
        if (!TextUtils.isEmpty(token)) {
            login(true);
        } else {
            login(false);
        }

    }

    @OnClick({R.id.me_head_img, R.id.me_head_login, R.id.me_head_jt_img,R.id.me_ll_shoucang})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.me_head_img://头像
                startActivity(new Intent(getActivity(), LoginActivity.class));
                break;
            case R.id.me_head_login://登录
                String token = SpUtils.getInstance().getString("token");
                if (TextUtils.isEmpty(token)) {
                    openLogin();//等于空跳转到登录
                }
                break;
            case R.id.me_head_jt_img://个人详情
                startActivity(new Intent(getActivity(), UserDetailActivity.class));
                break;
            case R.id.me_ll_shoucang://收藏
                startActivity(new Intent(mContext, MyCollectionActivity.class));
                break;
        }
    }

    private void openLogin() {
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivityForResult(intent,LOGIN);
    }

    private void login(boolean b) {
        if (b) {
            String username = SpUtils.getInstance().getString("username");
            String avatar = SpUtils.getInstance().getString("avatar");
             meHeadLogin.setText(username);
            if (!TextUtils.isEmpty(avatar)) {
                Glide.with(this).load(avatar).apply(new RequestOptions().circleCrop()).into(meHeadImg);
            }
        }else {
            //登录界面
            Intent intent = new Intent(mContext, LoginActivity.class);
            getActivity().startActivityForResult(intent, 100);
        }

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == LOGIN && resultCode == 300) {
            String username = data.getStringExtra("username");
            String avatar = data.getStringExtra("avatar");
            meHeadLogin.setText(username);
            Glide.with(this).load(avatar).apply(new RequestOptions().circleCrop()).into(meHeadImg);
        }
        if (requestCode == LOGINOUT && resultCode == 89) {
            login(false);
        }
    }

    /**/
    @Override
    public void showTips(String tips) {

    }
}
