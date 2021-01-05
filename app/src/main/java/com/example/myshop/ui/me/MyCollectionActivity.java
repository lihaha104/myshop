package com.example.myshop.ui.me;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.myshop.R;
import com.example.myshop.model.shop.CollcationsListBean;
import com.example.myshop.utils.Realm;
import com.yanzhenjie.recyclerview.swipe.SwipeItemClickListener;
import com.yanzhenjie.recyclerview.swipe.SwipeMenu;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuBridge;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuCreator;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItem;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItemClickListener;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmResults;

public class MyCollectionActivity extends AppCompatActivity {


    @BindView(R.id.rlv_favorites)
    SwipeMenuRecyclerView rlvFavorites;
    private ArrayList<CollcationsListBean> collcationsListBeans;
    private CollcationAdpter collcationAdpter;
    private RealmResults<CollcationsListBean> all;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_collection);
        ButterKnife.bind(this);
        initData();

    }
    private void initData() {
        rlvFavorites.setLayoutManager(new LinearLayoutManager(this));
        rlvFavorites.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        collcationsListBeans = new ArrayList<>();

        //设置菜单
        rlvFavorites.setSwipeMenuCreator(swipeMenuCreator);
        //设置菜单Item监听
        rlvFavorites.setSwipeMenuItemClickListener(swipeMenuItemClickListener);
        //查询数据库所有数据
        all = Realm.getRealm(this).where(CollcationsListBean.class).findAll();
        collcationsListBeans.addAll(all);
        if (collcationsListBeans.size() > 0) {
            collcationAdpter = new CollcationAdpter(this, collcationsListBeans);
            //绑定适配器
            rlvFavorites.setAdapter(collcationAdpter);
            Toast.makeText(this, "收藏东西", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "还未收藏东西", Toast.LENGTH_SHORT).show();
        }




    }
    ////创建侧滑菜单
    private  SwipeMenuCreator swipeMenuCreator = new SwipeMenuCreator() {
        @Override
        public void onCreateMenu(SwipeMenu swipeLeftMenu, SwipeMenu swipeRightMenu, int viewType) {
            SwipeMenuItem swipeMenuItem = new SwipeMenuItem(MyCollectionActivity.this)
                    .setImage(R.drawable.ljt)
                    .setWidth(150)//设置宽
                    .setHeight(ViewGroup.LayoutParams.MATCH_PARENT);//设置高与父同款
            swipeRightMenu.addMenuItem(swipeMenuItem);//添加一个条目在右侧菜单
        }
    };
    //设置菜单Item监听
    private SwipeMenuItemClickListener swipeMenuItemClickListener = new SwipeMenuItemClickListener() {
        @Override
        public void onItemClick(SwipeMenuBridge menuBridge) {
            //任何操作必须关闭菜单，否则可能出现Item菜单打开状态错乱
            menuBridge.closeMenu();
            //在menuBridge中我们可以得到侧滑的这一项item的position (menuBridge.getAdapterPosition())
            int adapterPosition = menuBridge.getAdapterPosition();
            collcationsListBeans.remove(adapterPosition);
            collcationAdpter.notifyDataSetChanged();
            //删除数据库
            Realm.getRealm(MyCollectionActivity.this).executeTransaction(new io.realm.Realm.Transaction() {
                @Override
                public void execute(io.realm.Realm realm) {
                    //从数据库中删除数据
                    all.deleteFromRealm(adapterPosition);
                }
            });
        }
    };

}