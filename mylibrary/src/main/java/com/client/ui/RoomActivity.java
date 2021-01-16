package com.client.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.client.R;
import com.client.bean.CreateRoomBean;
import com.client.bean.GetRoomListBean;
import com.client.bean.RoomAddressBean;
import com.client.bean.RoomDetailsBean;
import com.client.bean.StartLiveBean;
import com.client.interfaces.IRoom;
import com.client.presenter.RoomPresenter;
import com.client.utils.TxtUtils;
import com.example.mymvps.base.BaseActivity;
import com.example.mymvps.base.BaseAdapter;

import java.util.List;

public class RoomActivity extends BaseActivity<IRoom.Presenter> implements IRoom.View, View.OnClickListener {


    private RecyclerView mRecyRoom;
    private ImageView mImgStartLive;


    @Override
    protected int getLayout() {
        return R.layout.activity_room;
    }

    @Override
    protected IRoom.Presenter createPrenter() {
        return new RoomPresenter(this);
    }

    @Override
    protected void initView() {

        mRecyRoom = (RecyclerView) findViewById(R.id.recy_room);
        mImgStartLive = (ImageView) findViewById(R.id.img_startLive);
        mImgStartLive.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        persenter.getRoomList();
    }


    @Override
    public void createRoomResult(CreateRoomBean createRoomBean) {

    }

    //获得房间列表
    @Override
    public void getRoomListResult(GetRoomListBean roomListBean) {
        if (roomListBean.getErrno() == 0) {
            mRecyRoom.setLayoutManager(new GridLayoutManager(this, 2));
            List<GetRoomListBean.DataBean> data = roomListBean.getData();
            MyAdapter myAdapter = new MyAdapter(this, data);

            mRecyRoom.setAdapter(myAdapter);
            myAdapter.addListClick(new BaseAdapter.IListClick() {
                @Override
                public void itemClick(int pos) {
                    Intent intent = new Intent(RoomActivity.this, LiveActivity.class);
                    intent.putExtra("roomId", data.get(pos).getId());
                    Toast.makeText(RoomActivity.this, ""+data.get(pos).getId(), Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
            });
        } else {
            Toast.makeText(this, roomListBean.getErrmsg(), Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void roomDetailsResult(RoomDetailsBean myroomBean) {
       /* int errno = myroomBean.getErrno();
        if (errno == 0) {
            Toast.makeText(this, "进来了", Toast.LENGTH_SHORT).show();
            RoomDetailsBean.DataBean data = myroomBean.getData();
            Intent intent = new Intent(RoomActivity.this, PushActivity.class);
            intent.putExtra("name", data.getName());
            intent.putExtra("id", data.getId());
            startActivity(intent);
        } else {
            Toast.makeText(this, "errno!=0", Toast.LENGTH_SHORT).show();
        }*/
    }

    @Override
    public void roomAddressResult(RoomAddressBean roomLiveUrlBean) {
    }

    @Override
    public void startLiveResult(StartLiveBean startLiveBean) {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO:OnCreate Method has been created, run FindViewById again to generate code
        setContentView(R.layout.activity_room);
        initView();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.img_startLive) {
            //跳转到直播
            Intent intent = new Intent(RoomActivity.this, LiveStreamingActivity.class);
            startActivity(intent);
        }
    }

    //我的适配器
    class MyAdapter extends BaseAdapter<GetRoomListBean.DataBean> {

        public MyAdapter(Context context, List<GetRoomListBean.DataBean> data) {
            super(context, data);
        }

        @Override
        protected int getLayout() {
            return R.layout.layout_room_item;
        }

        @Override
        protected void bindData(GetRoomListBean.DataBean data, VH vh) {
            ImageView img = (ImageView) vh.getViewById(R.id.room_img);
            TextView name = (TextView) vh.getViewById(R.id.room_tvname);
            TxtUtils.setTextView(name, data.getName());
            Glide.with(context).load(data.getIcon()).into(img);
        }

    }

    @Override
    public void showTips(String tips) {
        Toast.makeText(this, "错误为：" + tips, Toast.LENGTH_SHORT).show();
    }

}
