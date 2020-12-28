package com.example.myshop.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.myshop.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SplaceActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{

    @BindView(R.id.splace_btn)
    Button splaceBtn;
    @BindView(R.id.splace_vp)
    ViewPager splaceVp;

    @BindView(R.id.dot1)
    ImageView dot1;
    @BindView(R.id.dot2)
    ImageView dot2;
    @BindView(R.id.dot3)
    ImageView dot3;

    private ImageView[] dots;
    private ArrayList<View> views;

    private int[] ids={R.id.dot1,R.id.dot2,R.id.dot3};

    /*   int num = 3;
      Handler handler = new Handler() {
          @Override
          public void handleMessage(@NonNull Message msg) {
              super.handleMessage(msg);
              if (msg.what == 1) {
                  num--;
                  if (num == 0) {
                      timer.cancel();
                      startActivity(new Intent(SplaceActivity.this, MainActivity.class));
                      finish();
                  } else {
                      handler.sendEmptyMessageDelayed(1, 1000);

                  }
              }
          }
      };
      private Timer timer;
  */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splace);
        ButterKnife.bind(this);
        /* inittime();*/
        initVp();
        initDots();
    }

    /* private void inittime() {

         timer = new Timer();
         timer.schedule(new TimerTask() {
             @Override
             public void run() {
                 handler.sendEmptyMessage(1);
             }
         }, 1000, 3000);
     }
 */
    private void initVp() {
        //穿件View视图
        views = new ArrayList<>();
        View vp1 = View.inflate(this, R.layout.vp1, null);
        View vp2 = View.inflate(this, R.layout.vp2, null);
        View vp3 = View.inflate(this, R.layout.vp3, null);
        views.add(vp1);
        views.add(vp2);
        views.add(vp3);
        splaceVp.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return views.size();
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view == object;
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                View view = views.get(position);
                container.addView(view);
                return view;
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                container.removeView((View) object);
            }
        });
        splaceVp.addOnPageChangeListener(this);

    }
    private  void initDots(){
        dots=new ImageView[views.size()];
        for (int i=0;i<views.size();i++){
            dots[i]=(ImageView) findViewById(ids[i]);
        }
    }


    @OnClick(R.id.splace_btn)
    public void onViewClicked() {
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for(int i=0;i<ids.length;i++){
            if(position==i){
                dots[i].setImageResource(R.mipmap.ic_menu_sort_pressed);
            }else {
                dots[i].setImageResource(R.mipmap.ic_menu_sort_nor);
            }
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}