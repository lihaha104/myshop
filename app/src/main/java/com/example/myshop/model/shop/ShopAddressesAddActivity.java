package com.example.myshop.model.shop;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myshop.R;
import com.example.myshop.base.BaseActivity;
import com.example.myshop.base.BaseAdapter;
import com.example.myshop.interfaces.shop.IShopAddress;
import com.example.myshop.persenter.shop.ShopAddressesPresenter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShopAddressesAddActivity extends BaseActivity<IShopAddress.Presenter> implements IShopAddress.View {

    @BindView(R.id.address_add_name)
    EditText addressAddName;
    @BindView(R.id.address_add_phone)
    EditText addressAddPhone;
    @BindView(R.id.address_add_sheng_qu_xian)
    EditText addressAddShengQuXian;
    @BindView(R.id.address_add_xiangxi)
    EditText addressAddXiangxi;
    @BindView(R.id.address_add_moren)
    RadioButton addressAddMoren;
    @BindView(R.id.address_add_btn_cancel)
    Button addressAddBtnCancel;
    @BindView(R.id.address_add_btn_ok)
    Button addressAddBtnOk;
    @BindView(R.id.con)
    ConstraintLayout con;
    private List<AddressAddProvinceBean.DataBean> provinces;//存放省份

    // recyclerView 选中Item 的颜色(选中的字体颜色)
    private int defaultSelectedColor = Color.parseColor("#AB2B2B");
    // recyclerView 未选中Item 的颜色（没选中的文字颜色）
    private int defaultUnSelectedColor = Color.parseColor("#262626");
    // 确定字体不可以点击时候的颜色(地址没有填完时)
    private int defaultSureUnClickColor = Color.parseColor("#7F7F7F");
    // 确定字体可以点击时候的颜色(地址填完时)
    private int defaultSureCanClickColor = Color.parseColor("#AB2B2B");
    //fragment的标题
    private String[] names = {"省份", "城市", "区县"};
    //不同状态下的数据
    private AddressAddProvinceBean.DataBean mSelectProvice; //选中 省份 bean
    private AddressAddProvinceBean.DataBean mSelectCity;//选中 城市  bean
    private AddressAddProvinceBean.DataBean mSelectDistrict;//选中 区县  bean

    private int mSelectProvicePosition = 0; //选中 省份 位置
    private int mSelectCityPosition = 0;//选中 城市  位置
    private int mSelectDistrictPosition = 0;//选中 区县  位置
    //pw
    private TextView tvSure;//确定按钮
    private TabLayout tab;//tablayout
    private RecyclerView mRvList; // 显示数据的RecyclerView pw
    private ShopAddressesAddAdapter mAdapter;   // pw recyclerview 的 adapter

    @Override
    protected int getLayout() {
        return R.layout.activity_shop_addresses_add;
    }

    @Override
    protected IShopAddress.Presenter createPrenter() {
        return new ShopAddressesPresenter(this);
    }

    @Override
    protected void initView() {
        addressAddShengQuXian.setFocusable(false);//先让ed框失去焦点才能获得点击事件

    }

    @Override
    protected void initData() {

    }

    @Override
    public void getAddressReturn(AddressBean result) {

    }

    @Override
    public void getAddressAddProvinceReturn(AddressAddProvinceBean result) {
        List<AddressAddProvinceBean.DataBean> data = result.getData();
        provinces.addAll(data);
        mAdapter.notifyDataSetChanged();

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

    @OnClick({R.id.address_add_sheng_qu_xian, R.id.address_add_moren, R.id.address_add_btn_cancel, R.id.address_add_btn_ok})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.address_add_sheng_qu_xian:
                initPw();
                break;
            case R.id.address_add_moren:
                break;
            case R.id.address_add_btn_cancel:
                finishAfterTransition();
                break;
            case R.id.address_add_btn_ok:
                break;
        }
    }

    //省市县的pw
    private void initPw() {
        //获得布局
        View inflate = View.inflate(this, R.layout.address_add_province_pw, null);
        PopupWindow popupWindow = new PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT, 1000);
        persenter.getAddressAddProvince(1);
        //创建爱你集合
        provinces = new ArrayList<>();
        //pw的确定按钮
        tvSure = inflate.findViewById(R.id.tvSure);
        tvSure.setTextColor(defaultSureUnClickColor);
        tvSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mSelectProvice != null && mSelectDistrict != null && mSelectCity != null) {
                    addressAddShengQuXian.setText(mSelectProvice.getName() + " " + mSelectCity.getName() + " " + mSelectDistrict.getName());
                    popupWindow.dismiss();//收起弹框
                    //取消阴影
                    WindowManager.LayoutParams attributes = getWindow().getAttributes();
                    attributes.alpha = 1f;
                    getWindow().setAttributes(attributes);
                } else {
                    Toast.makeText(ShopAddressesAddActivity.this, "地址还没有选完整哦", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //pw的tablayout
        tab = inflate.findViewById(R.id.tlTabLayout);
        tab.addTab(tab.newTab().setText(names[0]));
        tab.addTab(tab.newTab().setText(names[1]));
        tab.addTab(tab.newTab().setText(names[2]));
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                provinces.clear();
                switch (tab.getPosition()) {
                    case 0:
                        persenter.getAddressAddProvince(1);
                        mAdapter.notifyDataSetChanged();
                        // 滚动到这个位置
                        mRvList.smoothScrollToPosition(mSelectProvicePosition);
                        break;
                    case 1:
                        // 点到城市的时候要判断有没有选择省份
                        if (mSelectProvice != null) {
                            for (AddressAddProvinceBean.DataBean itemBean : provinces) {
                                if (itemBean.getName().equals(mSelectProvice.getName()))
                                    provinces.add(itemBean);
                            }
                        } else {
                            Toast.makeText(ShopAddressesAddActivity.this, "请您先选择省份", Toast.LENGTH_SHORT).show();
                        }
                        mAdapter.notifyDataSetChanged();
                        // 滚动到这个位置
                        mRvList.smoothScrollToPosition(mSelectCityPosition);
                        break;
                    case 2:
                        // 点到区的时候要判断有没有选择省份与城市
                        if (mSelectProvice != null && mSelectCity != null) {
                            for (AddressAddProvinceBean.DataBean itemBean : provinces) {
                                if (itemBean.getName().equals(mSelectCity.getName()))
                                    provinces.add(itemBean);
                            }
                        } else {
                            Toast.makeText(ShopAddressesAddActivity.this, "请您先选择省份与城市", Toast.LENGTH_SHORT).show();
                        }
                        mAdapter.notifyDataSetChanged();
                        // 滚动到这个位置
                        mRvList.smoothScrollToPosition(mSelectDistrictPosition);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        // recyclerview adapter的绑定
        mRvList = (RecyclerView) inflate.findViewById(R.id.rvList);
        mRvList.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new ShopAddressesAddAdapter(this, provinces);
        mRvList.setAdapter(mAdapter);

        // 初始化默认的本地数据  也提供了方法接收外面数据
        mRvList.post(new Runnable() {
            @Override
            public void run() {
                persenter.getAddressAddProvince(1);
            }
        });

        //pw显示
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(null);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.5f;
        getWindow().setAttributes(attributes);
        popupWindow.showAtLocation(con, Gravity.BOTTOM, 0, 0);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams attributes = getWindow().getAttributes();
                attributes.alpha = 1f;
                getWindow().setAttributes(attributes);
            }
        });

    }

     class ShopAddressesAddAdapter extends BaseAdapter<AddressAddProvinceBean.DataBean> {

        public ShopAddressesAddAdapter(Context context, List<AddressAddProvinceBean.DataBean> data) {
            super(context, data);
        }

        @Override
        protected int getLayout() {
            return R.layout.adpter_addressadd;
        }

        @Override
        protected void bindData(AddressAddProvinceBean.DataBean data, VH vh) {

            int tabSelectPosition = tab.getSelectedTabPosition();
            AddressAddProvinceBean.DataBean bean = (AddressAddProvinceBean.DataBean) data;

            TextView mTitle = (TextView) vh.getViewById(R.id.item_address_add_TvTitle);
            mTitle.setText(bean.getName());
            mTitle.setTextColor(defaultUnSelectedColor);

            // 设置选中效果的颜色
            switch (tabSelectPosition) {
                case 0:
                    if (bean != null && mSelectProvice != null &&
                            bean.getName().equals(mSelectProvice.getName())) {
                        mTitle.setTextColor(defaultSelectedColor);
                    }
                    break;
                case 1:
                    if (bean != null && mSelectCity != null &&
                            bean.getName().equals(mSelectCity.getName())) {
                        mTitle.setTextColor(defaultSelectedColor);
                    }
                    break;
                case 2:
                    if (bean != null &&
                            mSelectDistrict != null &&
                            bean.getName().equals(mSelectDistrict.getName())) {
                        mTitle.setTextColor(defaultSelectedColor);
                    }
                    break;
            }

            // 设置点击之后的事件
            mTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 点击 分类别
                    switch (tabSelectPosition) {
                        case 0:
                            mSelectProvice = bean;
                            // 清空后面两个的数据
                            mSelectCity = null;
                            mSelectDistrict = null;
                            mSelectCityPosition = 0;
                            mSelectDistrictPosition = 0;
                            tab.getTabAt(1).setText(names[1]);
                            tab.getTabAt(2).setText(names[2]);
                            // 设置这个对应的标题
                            tab.getTabAt(0).setText(mSelectProvice.getName());
                            // 跳到下一个选择
                            tab.getTabAt(1).select();
                            // 灰掉确定按钮
                            tvSure.setTextColor(defaultSureUnClickColor);
                            persenter.getAddressAddProvince(bean.getId());
                            mSelectProvicePosition = bean.getId();
                            break;
                        case 1:
                            mSelectCity = bean;
                            // 清空后面一个的数据
                            mSelectDistrict = null;
                            mSelectDistrictPosition = 0;
                            tab.getTabAt(2).setText(names[2]);
                            // 设置这个对应的标题
                            tab.getTabAt(1).setText(mSelectCity.getName());
                            // 跳到下一个选择
                            tab.getTabAt(2).select();
                            // 灰掉确定按钮
                            tvSure.setTextColor(defaultSureUnClickColor);
                            persenter.getAddressAddProvince(bean.getId());
                            mSelectCityPosition = bean.getId();
                            break;
                        case 2:
                            mSelectDistrict = bean;
                            // 没了，选完了，这个时候可以点确定了
                            tab.getTabAt(2).setText(mSelectDistrict.getName());
                            notifyDataSetChanged();
                            // 确定按钮变亮
                            tvSure.setTextColor(defaultSureCanClickColor);
                            persenter.getAddressAddProvince(bean.getId());
                            mSelectDistrictPosition = bean.getId();
                            break;
                    }
                }
            });

        }
    }
}