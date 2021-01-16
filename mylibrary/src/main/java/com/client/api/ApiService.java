package com.client.api;

import com.client.bean.CreateRoomBean;
import com.client.bean.GetRoomListBean;
import com.client.bean.RoomAddressBean;
import com.client.bean.RoomDetailsBean;
import com.client.bean.StartLiveBean;

import java.util.HashMap;

import io.reactivex.Flowable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

    String BASE_URL = "https://cdplay.cn/";

    //创建房间
    //https://cdplay.cn/api/live/createRoom
    @POST("api/live/createRoom")
    @FormUrlEncoded
    Flowable<CreateRoomBean> createRoom(@FieldMap HashMap<String, String> map);

    //获取房间列表
    @GET("api/live/getRoomList")
    Flowable<GetRoomListBean> getroomlist();

    //获取房间信息
    @POST("api/live/myroom")
    Flowable<RoomDetailsBean> roomDetail();

    //房间播放地址
    @POST("api/live/roomLiveUrl")
    Flowable<RoomAddressBean> roomAddress(@Query("roomid") String roomid);

    //开启直播
    @POST("api/live/startLive")
    @FormUrlEncoded
    Flowable<StartLiveBean> startLive(@FieldMap HashMap<String,String> map);

}
