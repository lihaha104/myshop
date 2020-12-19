package com.example.myshop.api;


import com.example.myshop.model.home.BrandTitleImgBean;
import com.example.myshop.model.home.BrandTitleImgRcyBean;
import com.example.myshop.model.home.HomeModelBean;
import com.example.myshop.model.home.BrandTitleBean;
import com.example.myshop.model.home.NewGoodsTitleBean;
import com.example.myshop.model.home.ChannelRcyBean;
import com.example.myshop.model.home.ChannelTabBean;

import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface ServiceApi {
    String BASE_URL = "http://cdplay.cn/";
    /*--------home--------*/
    //home首页
    @GET("api/index")
    Flowable<HomeModelBean> getHome();
    //homeitemtab
    @GET("goods/category")
    Flowable<ChannelTabBean> gethometab(@Query("id") String id);

    @GET("api/goods/list")
   //homeitemrcy
    Flowable<ChannelRcyBean> gethomercy(@Query("categoryId") String categoryId);
    //homeBrandTitle
    @GET("api/brand/list")
    Flowable<BrandTitleBean> gethomebrandtitle(@Query("page")String page);
    //homeBrandTitle
    @GET("api/brand/detail")
    Flowable<BrandTitleImgBean> gethomebrandtitleimg(@Query("id") String id);
    //homeBrandTitleImg
    @GET("api/goods/list")
    Flowable<BrandTitleImgRcyBean> gethomebrandtitleimgRcy(@Query("brandId") String brandId);
    //homenewgoods   ?isNew=1&page=1&size =1000&order=asc&sort=default&categoryId=0
    @GET("api/goods/list")
    Flowable<NewGoodsTitleBean> gethomenewgoodstitle(@QueryMap Map<String,String> map);

}
