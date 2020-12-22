package com.example.myshop.ui.home;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.myshop.R;
import com.example.myshop.base.BaseAdapter;
import com.example.myshop.model.home.NewGoodsTitleBean;

import java.util.HashMap;
import java.util.List;

public class HomeNewGoodsTitlePwAdpter extends BaseAdapter<NewGoodsTitleBean.DataBeanX.FilterCategoryBean> {
    public HomeNewGoodsTitlePwAdpter(Context context, List<NewGoodsTitleBean.DataBeanX.FilterCategoryBean> data) {
        super(context, data);
    }

    @Override
    protected int getLayout() {
        return R.layout.adpter_home_newgoods_title_pwadpter;
    }

    @Override
    protected void bindData(NewGoodsTitleBean.DataBeanX.FilterCategoryBean data, VH vh) {


        TextView tv = (TextView) vh.getViewById(R.id.pw_tv);
        tv.setText(data.getName());

    /*    for (int i = 0; i < data.size(); i++) {
            TextView tv = li1.findViewById(R.id.item_tv);
            tv.setText(filterCategory.get(i).getName());
            tv.setLayoutParams(layoutParams);
            tv.setTag(i);
            int finalI = i;
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    NewGoodsTitleBean.DataBeanX.FilterCategoryBean filterCategoryBean = filterCategory.get(finalI);
                    categoryId = filterCategoryBean.getId();
                    HashMap<String, String> stringStringHashMap = new HashMap<>();
                    stringStringHashMap.put("isNew", 1 + "");
                    stringStringHashMap.put("categoryId", categoryId + "");
                    persenter.gethomenewgoodstitle(stringStringHashMap);
                    popupWindow.dismiss();
                }
            });
    }*/
    }
}
