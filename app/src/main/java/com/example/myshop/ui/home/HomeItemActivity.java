package com.example.myshop.ui.home;

import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.myshop.R;
import com.example.myshop.base.BaseActivity;
import com.example.myshop.interfaces.home.IChannelTab;
import com.example.myshop.model.home.ChannelTabBean;
import com.example.myshop.persenter.home.ChannelTabPersenter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HomeItemActivity extends BaseActivity<ChannelTabPersenter> implements IChannelTab.View {


    @BindView(R.id.homeitem_tab)
    TabLayout homeitemTab;
    @BindView(R.id.homeitem_vp)
    ViewPager homeitemVp;
    private String id;

    @Override
    protected int getLayout() {
        return R.layout.activity_home_item;
    }

    @Override
    protected ChannelTabPersenter createPrenter() {
        return new ChannelTabPersenter(this);
    }

    @Override
    protected void initView() {

    }


    @Override
    protected void initData() {
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        Toast.makeText(this, "lihahaha"+id, Toast.LENGTH_SHORT).show();
        persenter.gethometab(id);
    }

    //获得数据
    @Override
    public void gethometabReturn(ChannelTabBean homeTabBean) {
        List<ChannelTabBean.DataBean.BrotherCategoryBean> brotherCategory = homeTabBean.getData().getBrotherCategory();
        List<Fragment> fragments = new ArrayList<>();
        List<String> strings=new ArrayList<>();
        for (int i = 0; i < brotherCategory.size(); i++) {
            ChannelTabBean.DataBean.BrotherCategoryBean brotherCategoryBean = brotherCategory.get(i);
            HomeItemFragment homeItemFragment = new HomeItemFragment(brotherCategoryBean);
            fragments.add(homeItemFragment);
            homeitemTab.setTag(i);
            strings.add(brotherCategory.get(i).getName());
        }
        homeitemVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return strings.get(position);
            }
        });
        homeitemTab.setupWithViewPager(homeitemVp);

        for (int i = 0; i < brotherCategory.size(); i++) {
            int bid = brotherCategory.get(i).getId();
            if(String.valueOf(bid).equals(id)){
                homeitemTab.getTabAt(i).select();
                Toast.makeText(this, ""+bid, Toast.LENGTH_SHORT).show();
            }
        }


    }

    @Override
    public void showLoading(int visible) {

    }

    @Override
    public void showTips(String tips) {

    }


}