package com.example.myshop.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.myshop.R;
import com.example.myshop.ui.home.HomeFragment;
import com.example.myshop.ui.me.MeFragment;
import com.example.myshop.ui.shop.ShopFragment;
import com.example.myshop.ui.sort.SortFragment;
import com.example.myshop.ui.topic.TopicFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mMainNavView;
    private ViewPager mVp;
    private TabLayout mTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initVp();
    }

    private void initView() {
       /* mMainNavView = (BottomNavigationView) findViewById(R.id.main_nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_topic, R.id.navigation_sort,R.id.navigation_shop,R.id.navigation_me)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.main_nav_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(mMainNavView, navController);
        mMainNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_home:
                        item.setIcon(R.mipmap.ic_menu_choice_pressed);
                        break;
                    case R.id.navigation_topic:
                        item.setIcon(R.mipmap.ic_menu_topic_pressed);
                        break;
                    case R.id.navigation_sort:
                        item.setIcon(R.mipmap.ic_menu_sort_pressed);
                        break;
                    case R.id.navigation_shop:
                        item.setIcon(R.mipmap.ic_menu_shoping_pressed);
                        break;
                    case R.id.navigation_me:
                        item.setIcon(R.mipmap.ic_menu_me_pressed);
                        break;
                }
                return true;
            }
        });*/
        mVp = (ViewPager) findViewById(R.id.vp);
        mTab = (TabLayout) findViewById(R.id.tab);
    }

    private void initVp() {
        //创建集合
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new TopicFragment());
        fragments.add(new SortFragment());
        fragments.add(new ShopFragment());
        fragments.add(new MeFragment());
        //创建适配器
        FragmentAdpter fragmentAdpter = new FragmentAdpter(getSupportFragmentManager(),fragments);
        //绑定
        mVp.setAdapter(fragmentAdpter);
        mTab.setupWithViewPager(mVp);
        mTab.getTabAt(0).setText(R.string.bar_name_home).setIcon(R.drawable.selecthome);
        mTab.getTabAt(1).setText(R.string.bar_name_topic).setIcon(R.drawable.selecttop);
        mTab.getTabAt(2).setText(R.string.bar_name_sort).setIcon(R.drawable.selectsort);
        mTab.getTabAt(3).setText(R.string.bar_name_shop).setIcon(R.drawable.selectshop);
        mTab.getTabAt(4).setText(R.string.bar_name_me).setIcon(R.drawable.selectme);
    }
}