package com.live;

import com.live.bean.CreateRoomBean;

import java.util.HashMap;

import io.reactivex.Flowable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {

    String BASE_URL = "https://cdplay.cn/";

    //创建房间
    //https://cdplay.cn/api/live/createRoom
    @POST("api/live/createRoom")
    @FormUrlEncoded
    Flowable<CreateRoomBean> createRoom(@FieldMap HashMap<String, String> map);


}
