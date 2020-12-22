package com.example.myshop.ui.sort;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.myshop.R;
import com.example.myshop.base.BaseFragment;
import com.example.myshop.base.BasePresenter;
import com.example.myshop.interfaces.sort.ISort;
import com.example.myshop.model.sort.SortModelBean;
import com.example.myshop.model.sort.SortModelRcyBean;
import com.example.myshop.persenter.sort.SortPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import q.rorbin.verticaltablayout.VerticalTabLayout;

/*分类*/
public class SortFragment extends BaseFragment<SortPresenter> implements ISort.View {
    @BindView(R.id.sort_vtab)
    VerticalTabLayout sortVtab;
    @BindView(R.id.sort_vp)
    ViewPager sortVp;

    @Override
    protected int getLayout() {
        return R.layout.fragment_sort;
    }


    @Override
    protected void initView() {

    }

    @Override
    protected SortPresenter createPrenter() {
        return new SortPresenter(this);
    }


    @Override
    protected void initData() {
        presenter.getSort();
    }



    @Override
    public void getSortReturn(SortModelBean result) {
        List<SortModelBean.DataBean.CategoryListBean> categoryList = result.getData().getCategoryList();
        ArrayList<Fragment> fragments = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < categoryList.size(); i++) {
            SortModelBean.DataBean.CategoryListBean categoryListBean = categoryList.get(i);
            SortSonFragment sortSonFragment = new SortSonFragment(categoryList.get(i).getId(),i);
            fragments.add(sortSonFragment);
            strings.add(categoryListBean.getName());
        }
        sortVp.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return strings.get(position);
            }
        });
        sortVtab.setupWithViewPager(sortVp);
    }

    @Override
    public void getSortRcyReturn(SortModelRcyBean result) {

    }


    @Override
    public void showTips(String tips) {

    }
}
