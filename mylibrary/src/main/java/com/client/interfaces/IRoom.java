package com.client.interfaces;

import com.example.mymvps.interfaces.Callback;
import com.example.mymvps.interfaces.IBaseModel;
import com.example.mymvps.interfaces.IBasePresenter;
import com.example.mymvps.interfaces.IBaseView;
import com.client.bean.CreateRoomBean;
import com.client.bean.GetRoomListBean;
import com.client.bean.RoomAddressBean;
import com.client.bean.RoomDetailsBean;
import com.client.bean.StartLiveBean;

import java.util.HashMap;

public interface IRoom {
    interface View extends IBaseView {
        //创建房间
        void createRoomResult(CreateRoomBean createRoomBean);

        //获得房间
        void getRoomListResult(GetRoomListBean roomListBean);

        //获取房间信息
        void roomDetailsResult(RoomDetailsBean myroomBean);

        //房间地址
        void roomAddressResult(RoomAddressBean roomLiveUrlBean);

        //开启直播
        void startLiveResult(StartLiveBean startLiveBean);
    }

    interface Presenter extends IBasePresenter<View> {
        //创建房间
        void createRoom(HashMap<String, String> map);

        //获得房间
        void getRoomList();

        //获取房间信息
        void roomDetails();

        //房间地址
        void roomAddress(String roomid);

        //开启直播
        void startLive(HashMap<String, String> map);
    }

    interface Model extends IBaseModel {
        void createRoom(HashMap<String, String> map, Callback callback);

        void getRoomList(Callback callback);

        void roomDetails(Callback callback);

        void roomAddress(String roomid, Callback callback);

        void startLive(HashMap<String, String> map, Callback callback);
    }
}
