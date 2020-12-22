package com.example.myshop.ui.sort;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myshop.R;
import com.example.myshop.base.BaseFragment;
import com.example.myshop.interfaces.sort.ISort;
import com.example.myshop.model.sort.SortModelBean;
import com.example.myshop.model.sort.SortModelRcyBean;
import com.example.myshop.persenter.sort.SortPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class SortSonFragment extends BaseFragment<SortPresenter> implements ISort.View {
    private int id;
    private int i;

    public SortSonFragment(int id,int i) {
        this.id = id;
        this.i=i;
    }

    @BindView(R.id.sort_son_img)
    ImageView sortSonImg;
    @BindView(R.id.sort_son_name)
    TextView sortSonName;
    @BindView(R.id.sort_son_tv)
    TextView sortSonTv;
    @BindView(R.id.sort_son_rcy)
    RecyclerView sortSonRcy;
    private ArrayList<SortModelBean.DataBean.CategoryListBean> list;

    @Override
    protected int getLayout() {
        return R.layout.fragment_sort_sonfragment;
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
        presenter.getSortRcy(id+"");
    }

    @Override
    public void getSortReturn(SortModelBean result) {
        List<SortModelBean.DataBean.CategoryListBean> categoryList = result.getData().getCategoryList();
        SortModelBean.DataBean.CategoryListBean categoryListBean = categoryList.get(i);
        Glide.with(getActivity()).load(categoryListBean.getWap_banner_url()).into(sortSonImg);
        sortSonName.setText(categoryListBean.getName());
        sortSonTv.setText(categoryListBean.getFront_desc());

   }

    @Override
    public void getSortRcyReturn(SortModelRcyBean result) {
        List<SortModelRcyBean.DataBean.CurrentCategoryBean.SubCategoryListBean> subCategoryList = result.getData().getCurrentCategory().getSubCategoryList();

        //设置rcy
        sortSonRcy.setLayoutManager(new GridLayoutManager(mContext,3));
        SortSonFragmentAdpter sortSonFragmentAdpter = new SortSonFragmentAdpter(i,getActivity(),subCategoryList);
        sortSonRcy.setAdapter(sortSonFragmentAdpter);
    }

    @Override
    public void showTips(String tips) {

    }
}
