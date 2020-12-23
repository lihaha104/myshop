package com.example.myshop.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.myshop.R;
import com.example.myshop.base.BaseActivity;
import com.example.myshop.base.BasePresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BigImageActivity extends BaseActivity {
    @BindView(R.id.num)
    TextView num;
    @BindView(R.id.pager)
    ViewPager pager;

    @Override
    protected int getLayout() {
        return R.layout.activity_big_image;
    }

    @Override
    protected BasePresenter createPrenter() {
        return null;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        List<String> listUrl = (List<String>) intent.getSerializableExtra("imageList");
        int id = intent.getIntExtra("id", 0);
        pager.setPageMargin((int) (getResources().getDisplayMetrics().density * 15));//设置页边距
        pager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return listUrl.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View inflate = View.inflate(BigImageActivity.this, R.layout.adapter_bigimage, null);
                ImageView img = inflate.findViewById(R.id.image_bigImage);
                Glide.with(BigImageActivity.this).load(listUrl.get(position)).into(img);
                container.addView(inflate);
                return inflate;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }
        });
        num.setText((id + 1) + "/" + listUrl.size());

        pager.setCurrentItem(id);

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                num.setText((position + 1) + "/" + listUrl.size());

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void initData() {

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
}