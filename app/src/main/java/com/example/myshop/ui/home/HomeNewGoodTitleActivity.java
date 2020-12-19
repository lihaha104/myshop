package com.example.myshop.ui.home;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myshop.R;
import com.example.myshop.base.BaseActivity;
import com.example.myshop.interfaces.home.INewGoodsTitle;
import com.example.myshop.model.home.NewGoodsTitleBean;
import com.example.myshop.persenter.home.NewGoodsTitlePersenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeNewGoodTitleActivity extends BaseActivity<NewGoodsTitlePersenter> implements INewGoodsTitle.View {
    private static final String ASC = "asc";
    private static final String DESC = "desc";
    private static final String DEFAULT = "default";
    private static final String PRICE = "price";
    private static final String CATEGORY = "category";

    @BindView(R.id.newgood_title_img_img)
    ImageView newgoodTitleImgImg;
    @BindView(R.id.newgood_title_img_name)
    TextView newgoodTitleImgName;
    @BindView(R.id.fragment)
    FrameLayout fragment;
    @BindView(R.id.newgood_zonghe)
    TextView newgoodZonghe;
    @BindView(R.id.newgood_pice)
    TextView newgoodPice;
    @BindView(R.id.newgood_kind)
    TextView newgoodKind;
    @BindView(R.id.newgood_title_img_rcy)
    RecyclerView newgoodTitleImgRcy;
    @BindView(R.id.img_icno)
    ImageView imgIcno;
    //是否是新品
    private int isNew = 1;
    private int page = 1;
    private int size = 100;
    private String order = ASC;
    private String sort = DEFAULT;
    private int categoryId = 0;
    private PopupWindow popupWindow;
    private List<NewGoodsTitleBean.DataBeanX.FilterCategoryBean> filterCategory;
    private List<NewGoodsTitleBean.DataBeanX.DataBean> data;
    private HomeNewGoodsTitleAdpter newGoodsAdapter;

    @Override
    protected int getLayout() {
        return R.layout.activity_home_new_good_title;
    }

    @Override
    protected NewGoodsTitlePersenter createPrenter() {
        return new NewGoodsTitlePersenter(this);
    }

    @Override
    protected void initView() {
        order = ASC;
        sort = DEFAULT;
        categoryId = 0;
        layoutPrice.setTag(0);  //
        txtAll.setTextColor(Color.parseColor(NewGoodActivity.this.getString(R.color.red)));
        data = new ArrayList<>();
        newGoodsAdapter = new NewGoodsAdapter(data, this);
        recyGoodList.setLayoutManager(new GridLayoutManager(this, 2));
        recyGoodList.setAdapter(newGoodsAdapter);
    }



    private Map<String, String> initMap() {
        map = new HashMap();
        map.put("isNew", String.valueOf(isNew));
        map.put("page", String.valueOf(page));
        map.put("size", String.valueOf(size));
        map.put("order", order);
        map.put("sort", sort);
        map.put("category", String.valueOf(categoryId));
        return map;
    }

    @Override
    protected void initData() {
        persenter.gethomenewgoodstitle(initMap());
    }

    @Override
    public void gethomenewgoodstitleReturn(NewGoodsTitleBean result) {

        List<NewGoodsTitleBean.DataBeanX.DataBean> datas = result.getData().getData();
        newgoodTitleImgRcy.setLayoutManager(new GridLayoutManager(this,2));
        HomeNewGoodsTitleAdpter homeNewGoodsAdpter = new HomeNewGoodsTitleAdpter(this, datas);
        newgoodTitleImgRcy.setAdapter(homeNewGoodsAdpter);
    }

    @OnClick({R.id.newgood_zonghe, R.id.newgood_pice, R.id.newgood_kind})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.newgood_zonghe:
                initText(newgoodZonghe);
                type = 0;
                setIconType(type);
                categoryId = 1005001;
                sort = DEFAULT;
                order = ASC;
                initData();
                /*if (popupWindow!=null){
                    popupWindow.dismiss();
                }*/
                break;
            case R.id.newgood_pice:
                initText(newgoodPice);
                if (type==1){
                    type=2;
                    setIconType(type);
                    sort=PRICE;
                    order=DESC;
                    initData();
                }else if (type==0){
                    type=1;
                    setIconType(type);
                    order=ASC;
                    sort=PRICE;
                    initData();
                }else {
                    type=1;
                    setIconType(type);
                    order=ASC;
                    sort=PRICE;
                    initData();
                }

                /*if (popupWindow==null){
                    popupWindow.dismiss();
                }*/
                break;
            case R.id.newgood_kind:
                initText(newgoodKind);
                type=0;
                setIconType(type);
                initData();
                //setPopw();
                break;
        }
    }
    //设置价格的图标
    private void setIconType(int type) {
        switch (type) {
            case 0:
                Glide.with(this).load(R.mipmap.aa).into(imgIcno);
                break;
            case 1:
                Glide.with(this).load(R.mipmap.up).into(imgIcno);
                break;
            case 2:
                Glide.with(this).load(R.mipmap.dwon).into(imgIcno);
                break;
        }
    }
    //设置点击的文本变红
    @SuppressLint("ResourceType")
    private void initText(TextView tv) {
        if (tv.equals(newgoodZonghe)) {
            tv.setTextColor(Color.parseColor(getString(R.color.red)));
            newgoodPice.setTextColor(Color.parseColor(getString(R.color.black)));
            newgoodKind.setTextColor(Color.parseColor(getString(R.color.black)));
        } else if (tv.equals(newgoodPice)) {
            tv.setTextColor(Color.parseColor(getString(R.color.red)));
            newgoodZonghe.setTextColor(Color.parseColor(getString(R.color.black)));
            newgoodKind.setTextColor(Color.parseColor(getString(R.color.black)));
        } else {
            tv.setTextColor(Color.parseColor(getString(R.color.red)));
            newgoodZonghe.setTextColor(Color.parseColor(getString(R.color.black)));
            newgoodPice.setTextColor(Color.parseColor(getString(R.color.black)));
        }
    }

    @Override
    public void showTips(String tips) {

    }



}