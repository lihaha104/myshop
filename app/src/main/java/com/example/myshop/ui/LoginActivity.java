package com.example.myshop.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myshop.R;
import com.example.myshop.base.BaseActivity;
import com.example.myshop.interfaces.login.ILogin;
import com.example.myshop.model.login.LoginBean;
import com.example.myshop.persenter.login.LoginPersenter;
import com.example.myshop.utils.SpUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginPersenter> implements ILogin.View {

    @BindView(R.id.user)
    EditText user;
    @BindView(R.id.pwd)
    EditText pwd;
    @BindView(R.id.img_pw)
    ImageView imgPw;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.tv_regist)
    TextView tvRegist;
    @BindView(R.id.tv_login)
    TextView tvLogin;

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected LoginPersenter createPrenter() {
        return new LoginPersenter();
    }

    @Override
    protected void initView() {
        //设值密码框为可见状态
        imgPw.setTag(1);
    }

    @OnClick({R.id.img_pw, R.id.btn_login,R.id.tv_regist})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_pw:
                int tag = (int) imgPw.getTag();
                //et_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance()); //密码可见
                //et_password.setTransformationMethod(PasswordTransformationMethod.getInstance());//密码不可见

                if(tag == 1){
                    imgPw.setImageResource(R.mipmap.ic_pw_open);
                    imgPw.setTag(2);
                    pwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    imgPw.setImageResource(R.mipmap.ic_pw_close);
                    imgPw.setTag(1);
                    pwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                break;
            case R.id.btn_login:
                login();
                break;
            case R.id.tv_regist:
                regist();
                break;
        }
    }

    private void regist() {

    }

    private void login() {
        String username = user.getText().toString();
        String pw = pwd.getText().toString();
        if(!TextUtils.isEmpty(username) && !TextUtils.isEmpty(pw)){
            persenter.myLogin(username,pw);
        }else{
            Toast.makeText(this, "账号或密码不能为空白", Toast.LENGTH_SHORT).show();;
        }
    }
    @Override
    protected void initData() {

    }

    @Override
    public void loginReturn(LoginBean loginBean) {
        if(!TextUtils.isEmpty(loginBean.getData().getToken())){
            SpUtils.getInstance().setValue("token",loginBean.getData().getToken());
            SpUtils.getInstance().setValue("uid",loginBean.getData().getUserInfo().getUid());
            finish();
        }
    }

    @Override
    public void showTips(String tips) {

    }

}