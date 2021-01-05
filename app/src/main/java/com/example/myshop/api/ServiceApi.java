package com.example.myshop.api;


import com.example.myshop.model.app.AppBean;
import com.example.myshop.model.home.BrandTitleImgBean;
import com.example.myshop.model.home.BrandTitleImgRcyBean;
import com.example.myshop.model.home.GoodDetailBean;
import com.example.myshop.model.home.HomeModelBean;
import com.example.myshop.model.home.BrandTitleBean;
import com.example.myshop.model.home.NewGoodsTitleBean;
import com.example.myshop.model.home.ChannelRcyBean;
import com.example.myshop.model.home.ChannelTabBean;
import com.example.myshop.model.login.LoginBean;
import com.example.myshop.model.me.UserInfoBean;
import com.example.myshop.model.shop.AddressAddProvinceBean;
import com.example.myshop.model.shop.AddressBean;
import com.example.myshop.model.shop.DeleteCarBean;
import com.example.myshop.model.shop.ShopCarDataBean;
import com.example.myshop.model.regist.MyRegisterBean;
import com.example.myshop.model.shop.UpdateCarBean;
import com.example.myshop.model.sort.SortModelBean;
import com.example.myshop.model.sort.SortModelRcyBean;
import com.example.myshop.model.topic.TopicCommentBean;
import com.example.myshop.model.topic.TopicDetailBean;
import com.example.myshop.model.topic.TopicListBaen;

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

    /*-------------专题--------------*/
    @GET("api/topic/detail")
    Flowable<TopicDetailBean> gettopicdetail(@Query("id") int id);
    @GET("api/comment/list")
    Flowable<TopicCommentBean> gettopiccomment(@QueryMap Map<String,String> map);
    @GET("api/topic/list")
    Flowable<TopicListBaen> gettopiclist(@Query("page") int page);



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


    /*------------购物车-----------*/
    //购物车列表
    @GET("api/cart/index")
    Flowable<ShopCarDataBean> getCarList();

    //添加到购物车
    @POST("api/cart/add")
    @FormUrlEncoded
    Flowable<ShopCarDataBean> addCar(@FieldMap Map<String,String> map);

    //更新购物车的数据
    @POST("api/cart/update")
    @FormUrlEncoded
    Flowable<UpdateCarBean> updateCar(@FieldMap Map<String,String> map);

    //删除购物车数据
    @POST("api/cart/delete")
    @FormUrlEncoded
    Flowable<DeleteCarBean> deleteCar(@Field("productIds") String productIds);

    //收获地址列表
    @GET("address/list")
    Flowable<AddressBean> getAddress();

    //获得省市接口数据
    @GET("region/list") //parentId  1
    Flowable<AddressAddProvinceBean> getAddressAddProvince(@Query("parentId")int parentId);

    //用户信息更新
    @POST("api/user/updateUserInfo")
    @FormUrlEncoded
    Flowable<UserInfoBean> updateUserInfo(@FieldMap Map<String,String> map);

    //版本更新
    @GET("api/apk/appinfo")
    Flowable<AppBean> getAppInfo();

}
