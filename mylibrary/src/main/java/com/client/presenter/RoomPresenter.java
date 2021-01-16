package com.client.presenter;

import com.example.mymvps.base.BasePresenter;
import com.example.mymvps.interfaces.Callback;
import com.client.interfaces.IRoom;
import com.client.bean.CreateRoomBean;
import com.client.bean.GetRoomListBean;
import com.client.bean.RoomAddressBean;
import com.client.bean.RoomDetailsBean;
import com.client.bean.StartLiveBean;
import com.client.model.RoomModel;

import java.util.HashMap;

public class RoomPresenter extends BasePresenter<IRoom.View> implements IRoom.Presenter {
    IRoom.View view;
    IRoom.Model model;

    public RoomPresenter(IRoom.View view) {
        this.view = view;
        this.model = new RoomModel();
    }

    @Override
    public void createRoom(HashMap<String, String> map) {
        if(view!=null){
            model.createRoom(map, new Callback<CreateRoomBean>() {
                @Override
                public void success(CreateRoomBean createRoomBean) {
                    view.createRoomResult(createRoomBean);
                }

                @Override
                public void fail(String err) {
                    view.showTips(err);
                }
            });
        }
    }

    @Override
    public void getRoomList() {
        if(view!=null){
            model.getRoomList(new Callback<GetRoomListBean>() {
                @Override
                public void success(GetRoomListBean getRoomListBean) {
                    view.getRoomListResult(getRoomListBean);
                }

                @Override
                public void fail(String err) {
                    view.showTips(err);
                }
            });
        }
    }

    @Override
    public void roomDetails() {
        if(view!=null){
            model.roomDetails(new Callback<RoomDetailsBean>() {
                @Override
                public void success(RoomDetailsBean roomDetailsBean) {
                    view.roomDetailsResult(roomDetailsBean);
                }

                @Override
                public void fail(String err) {
                    view.showTips(err);
                }
            });
        }
    }

    @Override
    public void roomAddress(String roomid) {
        if(view!=null){
            model.roomAddress(roomid, new Callback<RoomAddressBean>() {
                @Override
                public void success(RoomAddressBean roomAddressBean) {
                    view.roomAddressResult(roomAddressBean);
                }

                @Override
                public void fail(String err) {
                    view.showTips(err);
                }
            });
        }
    }

    @Override
    public void startLive(HashMap<String, String> map) {
        if(view!=null){
            model.startLive(map, new Callback<StartLiveBean>() {
                @Override
                public void success(StartLiveBean startLiveBean) {
                    view.startLiveResult(startLiveBean);
                }

                @Override
                public void fail(String err) {
                    view.showTips(err);
                }
            });
        }
    }
}