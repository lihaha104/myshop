package com.example.myshop.ui.topic;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myshop.R;
import com.example.myshop.base.BaseActivity;
import com.example.myshop.base.BaseAdapter;
import com.example.myshop.interfaces.topic.ITopic;
import com.example.myshop.model.topic.TopicCommentBean;
import com.example.myshop.model.topic.TopicDetailBean;
import com.example.myshop.model.topic.TopicListBaen;
import com.example.myshop.persenter.topic.TopicPersenter;
import com.example.myshop.ui.home.BigImageActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;

public class TopicActivity extends BaseActivity<TopicPersenter> implements ITopic.View {


    @BindView(R.id.rlv_de_to)
    RecyclerView rlvDeTo;
    @BindView(R.id.rlv_topic_rela)
    RecyclerView rlvTopicRela;
    private int id;
    private List<String> list;

    @Override
    protected int getLayout() {
        return R.layout.activity_topic;
    }

    @Override
    protected TopicPersenter createPrenter() {
        return new TopicPersenter(this);
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);

    }

    @Override
    protected void initData() {
        persenter.getTopicDetail(314);
        persenter.getTopicList(1);
    }
    //图片
    @Override
    public void getTopicDetailResult(TopicDetailBean result) {
        String content = result.getData().getContent();
        list = new ArrayList<>();
        String img = "<img[\\s\\S]*?>";
        Pattern pattern = Pattern.compile(img);
        Matcher matcher = pattern.matcher(content);
        Log.i("macher", "initImgae: "+pattern);

        while (matcher.find()) {
            String word = matcher.group();
            int start = word.indexOf("\"") + 1;
            int end = word.indexOf(".jpg");
            //判断图片的格式
            if (end > 0) {
                String url = word.substring(start, end);
                if (url != null) {
                    url = "http:" + url + ".jpg";
                    list.add(url);
                } else {
                    return;
                }
            } else {
                int end1 = word.indexOf(".png");
                String url = word.substring(start, end1);
                if (url != null) {
                    url = url + ".png";
                    list.add(url);
                } else {
                    return;
                }
            }
        }

        rlvDeTo.setLayoutManager(new LinearLayoutManager(this));
        rlvDeTo.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        TopicActivityImgAdpter rlvDeToAdapter = new TopicActivityImgAdpter(this,list);
        rlvDeTo.setAdapter(rlvDeToAdapter);
        rlvDeToAdapter.addListClick(new BaseAdapter.IListClick() {
            @Override
            public void itemClick(int pos) {
                Intent intent = new Intent(TopicActivity.this, BigImageActivity.class);
                intent.putExtra( "imageList", (Serializable) list);
                intent.putExtra( "id", pos );
                startActivity(intent);
            }
        });

    }
    //recy
    @Override
    public void getTopicListResult(TopicListBaen result) {
        List<TopicListBaen.DataBeanX.DataBean> data = result.getData().getData();
        rlvTopicRela.setLayoutManager(new LinearLayoutManager(this));
        TopicActivityReAdpter topicActivityReAdpter = new TopicActivityReAdpter(this,data);
        rlvTopicRela.setAdapter(topicActivityReAdpter);
        topicActivityReAdpter.addListClick(new BaseAdapter.IListClick() {
            @Override
            public void itemClick(int pos) {
                startActivity(new Intent(TopicActivity.this,TopicActivity.class));
            }
        });
    }

    @Override
    public void getTopicCommentResult(TopicCommentBean result) {

    }
    @Override
    public void showTips(String tips) {
        Toast.makeText(this, ""+tips, Toast.LENGTH_SHORT).show();
    }


}