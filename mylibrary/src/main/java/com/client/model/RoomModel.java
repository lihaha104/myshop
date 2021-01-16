package com.client.model;

import com.example.mymvps.base.BaseModel;
import com.example.mymvps.interfaces.Callback;
import com.example.mymvps.net.CommonSubscriber;

import com.client.interfaces.IRoom;
import com.client.bean.CreateRoomBean;
import com.client.bean.GetRoomListBean;
import com.client.bean.RoomAddressBean;
import com.client.bean.RoomDetailsBean;
import com.client.bean.StartLiveBean;
import com.client.net.HttpManager;
import com.client.utils.RxUtils;

import java.util.HashMap;

public class RoomModel extends BaseModel implements IRoom.Model {
    @Override
    public void createRoom(HashMap<String, String> map, Callback callback) {
        addDisposible(
                HttpManager.getInstance().getService().createRoom(map)
                        .compose(RxUtils.rxScheduler())
                        .subscribeWith(new CommonSubscriber<CreateRoomBean>(callback) {
                            @Override
                            public void onNext(CreateRoomBean createRoomBean) {
                                callback.success(createRoomBean);
                            }
                        })
        );
    }


    @Override
    public void getRoomList(Callback callback) {
        addDisposible(
                HttpManager.getInstance().getService().getroomlist()
                        .compose(RxUtils.rxScheduler())
                        .subscribeWith(new CommonSubscriber<GetRoomListBean>(callback) {
                            @Override
                            public void onNext(GetRoomListBean getRoomListBean) {
                                callback.success(getRoomListBean);
                            }
                        })
        );

    }

    @Override
    public void roomDetails(Callback callback) {
        addDisposible(HttpManager.getInstance().getService().roomDetail()
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<RoomDetailsBean>(callback) {
                    @Override
                    public void onNext(RoomDetailsBean roomDetailsBean) {
                        callback.success(roomDetailsBean);
                    }
                }));
    }

    @Override
    public void roomAddress(String roomid, Callback callback) {
        addDisposible(HttpManager.getInstance().getService().roomAddress(roomid)
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<RoomAddressBean>(callback) {
                    @Override
                    public void onNext(RoomAddressBean roomAddressBean) {
                        callback.success(roomAddressBean);
                    }
                }));
    }


    @Override
    public void startLive(HashMap<String, String> map, Callback callback) {
        addDisposible(HttpManager.getInstance().getService().startLive(map)
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<StartLiveBean>(callback) {
                    @Override
                    public void onNext(StartLiveBean startLiveBean) {
                        callback.success(startLiveBean);
                    }
                }));
    }


}
