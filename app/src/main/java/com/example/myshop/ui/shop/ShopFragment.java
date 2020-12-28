package com.example.myshop.ui.shop;


import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myshop.R;
import com.example.myshop.base.BaseAdapter;
import com.example.myshop.base.BaseFragment;
import com.example.myshop.interfaces.shop.IShop;
import com.example.myshop.model.shop.ShopCarDataBean;
import com.example.myshop.persenter.shop.ShopCarPersenter;
import com.example.myshop.ui.LoginActivity;
import com.example.myshop.utils.SpUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class ShopFragment extends BaseFragment<ShopCarPersenter> implements IShop.View {
    @BindView(R.id.recy_good)
    RecyclerView recyGood;
    @BindView(R.id.checkbox_all)
    CheckBox checkboxAll;
    @BindView(R.id.txt_totalPrice)
    TextView txtTotalPrice;
    @BindView(R.id.txt_edit)
    TextView txtEdit;
    @BindView(R.id.txt_submit)
    TextView txtSubmit;

    private boolean isEdit; //是否是编辑状态
    private ArrayList<ShopCarDataBean.DataBean.CartListBean> cartListBeans;
    private CarListAdapter carListAdapter;
    private ShopCarDataBean shopCarDataBean;
    private int posi=0;



    @Override
    protected int getLayout() {
        return R.layout.fragment_shop;
    }


    @Override
    protected void initView() {
        checkboxAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("TAG", "checkboxall");
                boolean bool = checkboxAll.isChecked();
                if (isEdit) {
                    updateGoodSelectStateEdit(bool);
                }else{
                    updateGoodSelectStateOrder(bool);
                }
            }
        });
    }



    @Override
    protected ShopCarPersenter createPrenter() {
        return new ShopCarPersenter(this);
    }

    @Override
    protected void initData() {
        cartListBeans = new ArrayList<>();
        carListAdapter = new CarListAdapter(mContext,cartListBeans);
        recyGood.setLayoutManager(new LinearLayoutManager(mContext));
        recyGood.setAdapter(carListAdapter);
        //判断是否有登录
        String token = SpUtils.getInstance().getString("token");
        if(!TextUtils.isEmpty(token)){
            presenter.getshop();
        }else{
            gotoLogin();
        }

        /**
         * 监听条目元素点击的时候的接口回调
         */
        carListAdapter.addItemViewClick(new BaseAdapter.IItemViewClick() {
            @Override
            public void itemViewClick(int id, Object data) {
                for(ShopCarDataBean.DataBean.CartListBean item:shopCarDataBean.getData().getCartList()){
                    if(item.getId() == id){
                        if(!isEdit){
                            item.selectOrder = (boolean) data;
                        }else{
                            item.selectEdit = (boolean) data;
                        }
                        break;
                    }
                }
                boolean isSelectAll;
                if(!isEdit){
                    isSelectAll = totalSelectOrder();
                }else{
                    isSelectAll = totalSelectEdit();
                }
                checkboxAll.setChecked(isSelectAll);
            }
        });
    }

    private void gotoLogin() {
        startActivity(new Intent(mContext, LoginActivity.class));
    }

    @Override
    public void getShopReturn(ShopCarDataBean carBean) {
        shopCarDataBean=carBean;
        List<ShopCarDataBean.DataBean.CartListBean> cartList = carBean.getData().getCartList();
        cartListBeans.addAll(cartList);
        carListAdapter.notifyDataSetChanged();
        carListAdapter.addItemViewClick(new BaseAdapter.IItemViewClick() {
            @Override
            public void itemViewClick(int viewid, Object data) {
                for(ShopCarDataBean.DataBean.CartListBean item:cartListBeans){
                    if(item.getId() == viewid){
                        if(!isEdit){
                            item.selectOrder = (boolean) data;
                        }else{
                            item.selectEdit = (boolean) data;
                        }
                        break;
                    }
                }
                boolean isSelectAll;
                if(!isEdit){
                    isSelectAll = totalSelectOrder();
                }else{
                    isSelectAll = totalSelectEdit();
                }
                checkboxAll.setChecked(isSelectAll);
            }
        });

    }

    /**
     * 编辑状态下的数据刷新
     */
    private void updateGoodSelectStateEdit(boolean b) {
        for(ShopCarDataBean.DataBean.CartListBean item:cartListBeans){
            item.selectOrder = b;
        }
          totalSelectEdit();
        // 更新列表条目的选中状态
        carListAdapter.notifyDataSetChanged();
    }
    /**
     * 下单状态的数据刷新
     */
    private void updateGoodSelectStateOrder(boolean b) {
        for(ShopCarDataBean.DataBean.CartListBean item:cartListBeans){
            item.selectOrder = b;
        }
        totalSelectOrder();
        // 更新列表条目的选中状态
        carListAdapter.notifyDataSetChanged();
    }
    /**
     * 下单状态下的总数和价格的计算
     */
    private boolean totalSelectOrder(){
        int num = 0;
        int totalPrice = 0;
        boolean isSelectAll = true;
        for(ShopCarDataBean.DataBean.CartListBean item:shopCarDataBean.getData().getCartList()){
            if(item.selectOrder){
                num += item.getNumber();
                totalPrice += item.getNumber()*item.getRetail_price();
            }else{
                    isSelectAll = false;
            }
        }
        String strAll = "全选($)";
        strAll = strAll.replace("$",String.valueOf(num));
        checkboxAll.setText(strAll);
        txtTotalPrice.setText("￥"+totalPrice);
        return isSelectAll;
    }

    /**
     * 编辑状态下的总数和价格的计算
     */
    private boolean totalSelectEdit(){
        int num = 0;
        int totalPrice = 0;
        boolean isSelectAll = true;
        for(ShopCarDataBean.DataBean.CartListBean item:shopCarDataBean.getData().getCartList()){
            if(item.selectEdit){
                num += item.getNumber();
                totalPrice += item.getNumber()*item.getRetail_price();
            }else{
                    isSelectAll = false;
            }
        }
        String strAll = "全选($)";
        strAll = strAll.replace("$",String.valueOf(num));
        checkboxAll.setText(strAll);
        txtTotalPrice.setText("￥"+totalPrice);
        return isSelectAll;
    }




    @OnClick({R.id.txt_edit, R.id.txt_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.txt_edit:
                changeEdit();
                break;
            case R.id.txt_submit:
                submit();
                break;
        }
    }
    /**
     * 修改编辑和完成的状态
     */
    private void changeEdit(){
        if("编辑".equals(txtEdit.getText().toString())){
            txtEdit.setText("完成");
            txtSubmit.setText("删除所选");
            isEdit = true;
        }else{
            txtEdit.setText("编辑");
            txtSubmit.setText("下单");
            isEdit = true;
            updateGoodSelectStateEdit(true);
        }
        carListAdapter.setEditState(isEdit);
        carListAdapter.notifyDataSetChanged();
    }
    /**
     * 提交
     */

    private void submit(){
        if("下单".equals(txtSubmit.getText().toString())){
            Toast.makeText(mContext, "要下单了", Toast.LENGTH_SHORT).show();
            //下单
        }else if("删除所选".equals(txtSubmit.getText().toString())){
           //delete();
            if(posi>=0){
                cartListBeans.remove(posi);
                carListAdapter.notifyDataSetChanged();
            }else{
                Toast.makeText(mContext, "没有数据了", Toast.LENGTH_SHORT).show();  
            }
            Toast.makeText(mContext, "z这块是删除", Toast.LENGTH_SHORT).show();

        }
    }

    private void delete() {
        //删除购物车所选数据
       
        StringBuilder sb = new StringBuilder();
        for(ShopCarDataBean.DataBean.CartListBean item:cartListBeans){
            if(item.selectEdit){
                sb.append(item.getProduct_id());
                sb.append(",");
            }
        }
        if(sb.length()> 1){
            sb.deleteCharAt(sb.length()-1);
        }else{
            Toast.makeText(mContext, "购物车中没有东西了哦", Toast.LENGTH_SHORT).show();
        }
//            presenter.deleteCar(sb.toString());
    }

    @Override
    public void showTips(String tips) {

    }
}
