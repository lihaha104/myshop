package com.example.myshop.ui.home;

import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myshop.R;
import com.example.myshop.base.BaseAdapter;
import com.example.myshop.base.BaseFragment;
import com.example.myshop.interfaces.home.IHome;
import com.example.myshop.model.home.HomeModelBean;
import com.example.myshop.persenter.home.HomePersenter;
import com.example.myshop.utils.TxtUtils;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class HomeFragment extends BaseFragment<HomePersenter> implements IHome.View {

    @BindView(R.id.home_banner)
    Banner homeBanner;
    @BindView(R.id.recy_brand)
    RecyclerView recyBrand;
    @BindView(R.id.recy_newgood)
    RecyclerView recyNewgood;
    @BindView(R.id.recy_hotgood)
    RecyclerView recyHotgood;
    @BindView(R.id.recy_topic)
    RecyclerView recyTopic;
    @BindView(R.id.recy_category)
    RecyclerView recyCategory;
    @BindView(R.id.layout_tab)
    LinearLayout layoutTab;
    @BindView(R.id.txt_brand_title)
    TextView txtBrandTitle;
    @BindView(R.id.txt_newgood_title)
    TextView txtNewgoodTitle;


    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected HomePersenter createPrenter() {
        return new HomePersenter(this);
    }


    @Override
    protected void initView() {


    }

    protected void initData() {
        presenter.getHome();
    }


    @Override
    public void getHomeReturn(HomeModelBean result) {
        HomeModelBean.DataBean data = result.getData();
        if (data != null) {
            initBanner(data.getBanner());//初始化banner
            initChannel(data.getChannel());//初始化channel
            initBrand(data.getBrandList());//初始化Brand
            initNewgoods(data.getNewGoodsList());//初始化NewGoodsList
            initHotgoods(data.getHotGoodsList());//初始化hotGoodsList
            initTopicgoods(data.getTopicList());//初始化TopicGoodslist
            initCategoryList(data.getCategoryList());//初始化Categorylist

        }
    }

    //获得banner数据
    private void initBanner(List<HomeModelBean.DataBean.BannerBean> banners) {
        homeBanner.setImages(banners).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                HomeModelBean.DataBean.BannerBean pathlast = (HomeModelBean.DataBean.BannerBean) path;
                Glide.with(context).load(pathlast.getImage_url()).into(imageView);
            }
        }).start();
    }

    //获得channel数据
    private void initChannel(List<HomeModelBean.DataBean.ChannelBean> channel) {
        layoutTab.removeAllViews();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1);
        for (HomeModelBean.DataBean.ChannelBean item : channel) {
            View channelview = LayoutInflater.from(getContext()).inflate(R.layout.layout_channel_item, layoutTab, false);
            ImageView img = channelview.findViewById(R.id.img_channel);
            TextView txtChannel = channelview.findViewById(R.id.txt_channel);
            Glide.with(getActivity()).load(item.getIcon_url()).into(img);
            TxtUtils.setTextView(txtChannel, item.getName());
            txtChannel.setGravity(Gravity.CENTER);
            channelview.setLayoutParams(layoutParams);
            layoutTab.addView(channelview);
            channelview.setTag(item);
            //监听
            channelview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    HomeModelBean.DataBean.ChannelBean item = (HomeModelBean.DataBean.ChannelBean) view.getTag();
                    String url = item.getUrl();
                    int i = url.indexOf("=");
                    String substring = url.substring(i + 1);
                    Intent intent = new Intent(getActivity(), HomeItemActivity.class);
                    intent.putExtra("id", substring);
                    intent.putExtra("name", item.getName());
                    startActivity(intent);
                }
            });
        }
    }

    ///获得brand数据
    private void initBrand(List<HomeModelBean.DataBean.BrandListBean> brandList) {
        recyBrand.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        HomeBrandAdpter homeBrandAdpter = new HomeBrandAdpter(getActivity(), brandList);
        recyBrand.setAdapter(homeBrandAdpter);
        homeBrandAdpter.addListClick(new BaseAdapter.IListClick() {
            @Override
            public void itemClick(int pos) {
                Intent intent = new Intent(getActivity(), HomeBrandTitleImgActivity.class);
                intent.putExtra("id",brandList.get(pos).getId());
                getActivity().startActivity(intent);
            }
        });
    }

    ///获得NewGoodsList数据
    private void initNewgoods(List<HomeModelBean.DataBean.NewGoodsListBean> newGoodsList) {
        recyNewgood.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        HomeNewGoodsAdpter homeNewfoodsAdpter = new HomeNewGoodsAdpter(getActivity(), newGoodsList);
        recyNewgood.setAdapter(homeNewfoodsAdpter);
        homeNewfoodsAdpter.addListClick(new BaseAdapter.IListClick() {
            @Override
            public void itemClick(int pos) {
                Intent intent = new Intent(getActivity(), HomeItemDetailsActivity.class);
                intent.putExtra("id",newGoodsList.get(pos).getId());
                startActivity(intent);
            }
        });
    }

    //获得HotGoodsList数据
    private void initHotgoods(List<HomeModelBean.DataBean.HotGoodsListBean> hotGoodsList) {
        recyHotgood.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyHotgood.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        HomeHotGoodsAdpter homeHotfoodsAdpter = new HomeHotGoodsAdpter(getActivity(), hotGoodsList);
        recyHotgood.setAdapter(homeHotfoodsAdpter);
        homeHotfoodsAdpter.addListClick(new BaseAdapter.IListClick() {
            @Override
            public void itemClick(int pos) {
                Intent intent = new Intent(getActivity(), HomeItemDetailsActivity.class);
                intent.putExtra("id",hotGoodsList.get(pos).getId());
                startActivity(intent);
            }
        });
    }

    //获得TopicGoodslist()数据
    private void initTopicgoods(List<HomeModelBean.DataBean.TopicListBean> topicList) {
        recyTopic.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        HomeTopicfoodsAdpter homeTopicfoodsAdpter = new HomeTopicfoodsAdpter(getActivity(), topicList);
        recyTopic.setAdapter(homeTopicfoodsAdpter);
    }

    //获得initCategoryList()数据
    private void initCategoryList(List<HomeModelBean.DataBean.CategoryListBean> categoryList) {
        recyCategory.setLayoutManager(new LinearLayoutManager(mContext) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        HomeCategoryAdpter homeCategoryAdpter = new HomeCategoryAdpter(getActivity(), categoryList);
        recyCategory.setAdapter(homeCategoryAdpter);

    }


    @Override
    public void showTips(String tips) {

    }


    @OnClick({R.id.txt_brand_title, R.id.txt_newgood_title})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.txt_brand_title:
                //跳转页面
                Intent intent = new Intent(getActivity(), HomeBrandTitleActivity.class);
                getActivity().startActivity(intent);
                break;
            case R.id.txt_newgood_title:
                getActivity().startActivity(new Intent(getActivity(),HomeNewGoodTitleActivity.class));
                break;
        }
    }
}
