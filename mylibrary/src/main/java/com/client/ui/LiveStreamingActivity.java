package com.client.ui;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.client.R;
import com.client.bean.CreateRoomBean;
import com.client.bean.GetRoomListBean;
import com.client.bean.RoomAddressBean;
import com.client.bean.RoomDetailsBean;
import com.client.bean.StartLiveBean;
import com.client.interfaces.IRoom;
import com.client.presenter.RoomPresenter;
import com.example.mymvps.base.BaseActivity;

import java.util.HashMap;

//TODO 直播
public class LiveStreamingActivity extends BaseActivity<IRoom.Presenter> implements IRoom.View {


    EditText etName;
    private HashMap<String, String> map;
    private LinearLayout ll_room;
    private TextView room_name;
    private ImageView img_room;
    private Button btn_cj;

    @Override
    protected int getLayout() {
        return R.layout.activity_live_streaming;
    }

    @Override
    protected void initView() {
        etName = findViewById(R.id.et_name);
        ll_room = findViewById(R.id.ll_room);
        room_name = findViewById(R.id.room_name);
        img_room = findViewById(R.id.img_room);
        btn_cj = findViewById(R.id.btn_cj);
    }

    @Override
    protected IRoom.Presenter createPrenter() {
        return new RoomPresenter(this);
    }


    @Override
    protected void initData() {
        String s = etName.getText().toString();
        map = new HashMap<>();
        map.put("room_name", s);
        map.put("room_icon","https://dss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1819216937,2118754409&fm=26&gp=0.jpg");
        map.put("isopen", "1");
        persenter.roomDetails();
        btn_cj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                persenter.createRoom(map);
            }
        });
    }

    @Override
    public void createRoomResult(CreateRoomBean createRoomBean) {
        String name = createRoomBean.getData().getName();
        Log.e("TAG", "名字： " + name);
        Toast.makeText(this, "名字：" + name, Toast.LENGTH_SHORT).show();

        etName.setVisibility(View.GONE);
    }

    @Override
    public void getRoomListResult(GetRoomListBean roomListBean) {

    }

    @Override
    public void roomDetailsResult(RoomDetailsBean myroomBean) {
        if(myroomBean.getErrno() == 0){
            ll_room.setVisibility(View.VISIBLE);
            RoomDetailsBean.DataBean data = myroomBean.getData();
            room_name.setText(data.getName());
            Glide.with(this).load(data.getIcon()).into(img_room);


            img_room.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(LiveStreamingActivity.this, PushActivity.class);
                    intent.putExtra("id",data.getId());
                    startActivity(intent);
                }
            });
        }
    }

    @Override
    public void roomAddressResult(RoomAddressBean roomLiveUrlBean) {

    }

    @Override
    public void startLiveResult(StartLiveBean startLiveBean) {

    }


}