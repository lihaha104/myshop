package com.example.myshop.persenter.shop;

import com.example.myshop.base.BasePresenter;
import com.example.myshop.interfaces.Callback;
import com.example.myshop.interfaces.shop.IShopAddress;
import com.example.myshop.model.shop.AddressAddProvinceBean;
import com.example.myshop.model.shop.AddressBean;
import com.example.myshop.model.shop.ShopAddressesModel;

public class ShopAddressesPresenter extends BasePresenter<IShopAddress.View> implements IShopAddress.Presenter {
    IShopAddress.View view;
    IShopAddress.Model model;

    public ShopAddressesPresenter(IShopAddress.View view) {
        this.view = view;
        model=new ShopAddressesModel();
    }

    @Override
    public void getAddressList() {
      model.getAddressList(new Callback<AddressBean>() {


          @Override
          public void success(AddressBean addressBean) {
             view.getAddressReturn(addressBean);
          }

          @Override
          public void fail(String err) {

          }
      });
    }

    @Override
    public void getAddressAddProvince(int parentId) {
    model.getAddressAddProvince(parentId, new Callback<AddressAddProvinceBean>() {

        @Override
        public void success(AddressAddProvinceBean addressAddProvinceBean) {
            view.getAddressAddProvinceReturn(addressAddProvinceBean);
        }

        @Override
        public void fail(String err) {

        }
    });
    }
}
