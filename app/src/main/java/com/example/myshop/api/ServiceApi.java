package com.example.myshop.api;


import com.example.myshop.model.home.BrandTitleImgBean;
import com.example.myshop.model.home.BrandTitleImgRcyBean;
import com.example.myshop.model.home.GoodDetailBean;
import com.example.myshop.model.home.HomeModelBean;
import com.example.myshop.model.home.BrandTitleBean;
import com.example.myshop.model.home.NewGoodsTitleBean;
import com.example.myshop.model.home.ChannelRcyBean;
import com.example.myshop.model.home.ChannelTabBean;
import com.example.myshop.model.login.LoginBean;
import com.example.myshop.model.shop.ShopCarDataBean;
import com.example.myshop.model.regist.MyRegisterBean;
import com.example.myshop.model.sort.SortModelBean;
import com.example.myshop.model.sort.SortModelRcyBean;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface ServiceApi {
    String BASE_URL = "http://cdplay.cn/";
    /*-------------首页--------------*/
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
    //商品详情购买页
    @GET("api/goods/detail")
    Flowable<GoodDetailBean> getGoodDetail(@Query("id") int id);





    /*-------------分类--------------*/
    @GET("api/catalog/index")
    Flowable<SortModelBean>  getsort();
    @GET("api/catalog/current")
    Flowable<SortModelRcyBean>  getsortRcy(@Query("id") String id);

    /*-------------注册--------------*/
    //注册接口
    @POST("api/auth/register")
    @FormUrlEncoded
    Flowable<MyRegisterBean> myRegist(@Field("username") String username, @Field("password") String password);

    //登录
    @POST("api/auth/login")
    @FormUrlEncoded
    Flowable<LoginBean> myLogin(@Field("username")String username, @Field("password") String pwd);

    //添加到购物车
    @POST("api/cart/add")
    @FormUrlEncoded
    Flowable<ShopCarDataBean> addCar(@FieldMap HashMap<String,String> map);

    //购物车列表
    @GET("api/cart/index")
    Flowable<ShopCarDataBean> getCarList();

}
