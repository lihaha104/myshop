package com.example.myshop.ui.shop;


import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myshop.R;
import com.example.myshop.app.MyApp;
import com.example.myshop.base.BaseAdapter;
import com.example.myshop.base.BaseFragment;
import com.example.myshop.interfaces.shop.IShop;
import com.example.myshop.model.shop.DeleteCarBean;
import com.example.myshop.model.shop.ShopCarDataBean;
import com.example.myshop.model.shop.UpdateCarBean;
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        presenter.getshop();
    }

    private void gotoLogin() {
        startActivity(new Intent(mContext, LoginActivity.class));
    }

    @Override
    public void getShopReturn(ShopCarDataBean carBean) {
        shopCarDataBean=carBean;
        cartListBeans.clear();
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

    //修改列表
    @Override
    public void updateShopCarReturn(UpdateCarBean result) {
        for(UpdateCarBean.DataBean.CartListBean item:result.getData().getCartList()){
            updateCartListBeanNumberById(item.getId(),item.getNumber());
        }
        //更新商品的总数和总价
        shopCarDataBean.getData().getCartTotal().setGoodsCount(result.getData().getCartTotal().getGoodsCount());
        shopCarDataBean.getData().getCartTotal().setGoodsAmount(result.getData().getCartTotal().getGoodsAmount());
        carListAdapter.notifyDataSetChanged();
        totalSelectEdit();
    }
    /**
     * 刷新购物车列表的数据
     * @param carId
     * @param number
     */
    private void updateCartListBeanNumberById(int carId,int number){
        for(ShopCarDataBean.DataBean.CartListBean item:cartListBeans){
            if(item.getId() == carId){
                item.setNumber(number);
                break;
            }
        }
    }
    //删除列表
    @Override
    public void deleteShopCarReturn(DeleteCarBean result) {
        //通过购物车返回的最新数据，同步本地列表中的数据
        int index,lg=cartListBeans.size();
        for(index=0;index<lg; index++){
            ShopCarDataBean.DataBean.CartListBean item = cartListBeans.get(index);
            boolean bool = deleteCarListById(result.getData().getCartList(),item.getId());
            Log.i("TAG","delete bool:"+bool +" item:"+item.getId());
            if(bool){
                cartListBeans.remove(index);
                index--;
                lg--;
            }

        }
        carListAdapter.notifyDataSetChanged();
        totalSelectEdit();
    }
    private boolean deleteCarListById(List<DeleteCarBean.DataBean.CartListBean> list ,int carId){
        for(DeleteCarBean.DataBean.CartListBean item:list){
            if(item.getId() == carId){
                return false;
            }
        }
        return true;
    }

    /**
     * 编辑状态下的数据刷新
     */
    private void updateGoodSelectStateEdit(boolean b) {
        for(ShopCarDataBean.DataBean.CartListBean item:cartListBeans){
            item.selectOrder = b;
        }
          totalSelectOrder();
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
        for(ShopCarDataBean.DataBean.CartListBean item:cartListBeans){
            if(item.selectOrder){
                num += item.getNumber();
                totalPrice += item.getNumber()*item.getRetail_price();
            }else{
                if(isSelectAll){
                    isSelectAll = false;
                }
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
                if(isSelectAll){
                    isSelectAll = false;
                }
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
            isEdit = false;
            updateGoodSelectStateEdit(false);
        }
        carListAdapter.setEditState(isEdit);
        carListAdapter.notifyDataSetChanged();
    }
    /**
     * 提交
     */

    private void submit(){
        if("下单".equals(txtSubmit.getText().toString())){
            //下单
            order();

        }else if("删除所选".equals(txtSubmit.getText().toString())){
            //删除购物车所选数据
            deleteCar();
        }
    }
    //下单
    private void order() {

        Intent intent = new Intent(mContext, OrderActivity.class);
        MyApp.getMap().put("shop",cartListBeans);
        startActivity(intent);
    }

    /**
     *删除所有选中的商品数据
     */
    private void deleteCar(){
        StringBuilder sb = new StringBuilder();
        for(ShopCarDataBean.DataBean.CartListBean item:cartListBeans){
            if(item.selectEdit){
                sb.append(item.getProduct_id());
                sb.append(",");
            }
        }
        if(sb.length() > 0){
            sb.deleteCharAt(sb.length()-1);
        }
        Log.i("TAG",sb.toString());
        presenter.deleteShopCar(sb.toString());
    }



    @Override
    public void showTips(String tips) {

    }
}
