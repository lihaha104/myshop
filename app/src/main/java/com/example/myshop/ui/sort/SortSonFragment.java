package com.example.myshop.ui.sort;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myshop.R;
import com.example.myshop.base.BaseAdapter;
import com.example.myshop.base.BaseFragment;
import com.example.myshop.interfaces.sort.ISort;
import com.example.myshop.model.home.HomeModelBean;
import com.example.myshop.model.sort.SortModelBean;
import com.example.myshop.model.sort.SortModelRcyBean;
import com.example.myshop.persenter.sort.SortPresenter;
import com.example.myshop.ui.home.HomeBrandTitleActivity;
import com.example.myshop.ui.home.HomeItemActivity;
import com.example.myshop.ui.home.HomeItemDetailsActivity;
import com.example.myshop.ui.home.HomeItemFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class SortSonFragment extends BaseFragment<SortPresenter> implements ISort.View {
    private int id;

    public SortSonFragment() {
    }



    @BindView(R.id.sort_son_img)
    ImageView sortSonImg;
    @BindView(R.id.sort_son_name)
    TextView sortSonName;
    @BindView(R.id.sort_son_tv)
    TextView sortSonTv;
    @BindView(R.id.sort_son_rcy)
    RecyclerView sortSonRcy;

    @Override
    protected int getLayout() {
        return R.layout.fragment_sort_sonfragment;
    }

    @Override
    protected void initView() {
        id = getArguments().getInt("id");
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
        SortModelBean.DataBean.CurrentCategoryBean currentCategory = result.getData().getCurrentCategory();
        Glide.with(getContext()).load(currentCategory.getWap_banner_url()).into(sortSonImg);
        sortSonName.setText(currentCategory.getName());
        sortSonTv.setText(currentCategory.getFront_desc());

   }

    @Override
    public void getSortRcyReturn(SortModelRcyBean result) {
        List<SortModelRcyBean.DataBean.CurrentCategoryBean.SubCategoryListBean> subCategoryList = result.getData().getCurrentCategory().getSubCategoryList();

        //设置rcy
        sortSonRcy.setLayoutManager(new GridLayoutManager(mContext,3));
        SortSonFragmentAdpter sortSonFragmentAdpter = new SortSonFragmentAdpter(getActivity(),subCategoryList);
        sortSonRcy.setAdapter(sortSonFragmentAdpter);
        sortSonFragmentAdpter.addListClick(new BaseAdapter.IListClick() {
            @Override
            public void itemClick(int pos) {
                int ids = subCategoryList.get(pos).getId();
                Intent intent = new Intent(getActivity(), HomeItemActivity.class);
                intent.putExtra("id", ids+"");
                Toast.makeText(getActivity(), "李佳鑫的tab："+ids+"", Toast.LENGTH_SHORT).show();
              startActivity(intent);
            }
        });
    }

    @Override
    public void showTips(String tips) {

    }
}
