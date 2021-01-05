package com.example.myshop.ui.home;

import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myshop.R;
import com.example.myshop.base.BaseActivity;
import com.example.myshop.base.BaseAdapter;
import com.example.myshop.interfaces.home.IGoodDetail;
import com.example.myshop.model.home.GoodDetailBean;
import com.example.myshop.model.shop.CollcationsListBean;
import com.example.myshop.model.shop.ShopCarDataBean;
import com.example.myshop.persenter.home.GoodDetailPersenter;
import com.example.myshop.ui.MainActivity;
import com.example.myshop.utils.Realm;
import com.example.myshop.utils.TxtUtils;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

public class HomeItemDetailsActivity extends BaseActivity<GoodDetailPersenter> implements IGoodDetail.View {
    /* private String h5 = "<html>\n" +
             "            <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\"/>\n" +
             "            <head>\n" +
             "                <style>\n" +
             "                    p{\n" +
             "                        margin:0px;\n" +
             "                    }\n" +
             "                    img{\n" +
             "                        width:100%;\n" +
             "                        height:auto;\n" +
             "                    }\n" +
             "                </style>\n" +
             "            </head>\n" +
             "            <body>\n" +
             "                word\n" +
             "            </body>\n" +
             "        </html>";*/
    @BindView(R.id.hotgoodsitem_banner)
    Banner hotgoodsitem_banner;
    //商品详情
    @BindView(R.id.hotgoodsitem_details_name)
    TextView hotgoodsitem_name;
    @BindView(R.id.hotgoodsitem__brief)
    TextView hotgoodsitem__brief;
    @BindView(R.id.hotgoodsitem__price)
    TextView hotgoodsitem__price;
    @BindView(R.id.details_num)
    ConstraintLayout details_num;
    //评价
    @BindView(R.id.con_assess)
    ConstraintLayout con_assess;
    @BindView(R.id.hotgoodsitem_headimg)
    ImageView hotgoodsitem_headimg;
    @BindView(R.id.hotgoodsitem_clientname)
    TextView hotgoodsitem_clientname;
    @BindView(R.id.hotgoodsitem_time)
    TextView hotgoodsitem_time;
    @BindView(R.id.hotgoodsitem_content)
    TextView hotgoodsitem_content;
    //参数
    @BindView(R.id.rcy_attribute)
    RecyclerView rcy_attribute;
    //图片
    @BindView(R.id.rv_img)
    RecyclerView rv_img;

    //常见问题
    @BindView(R.id.rcy_issue)
    RecyclerView rcy_issue;
    private int id;
    private List<String> listUrl;

    //加入购物城
    @BindView(R.id.layout_car)
    FrameLayout layout_car;
    @BindView(R.id.txt_number)
    TextView txt_number;
    @BindView(R.id.txt_addCar)
    TextView txt_addCar;
    @BindView(R.id.txt_buy)
    TextView txt_buy;
    @BindView(R.id.img_car)
    ImageView img_car;
    @BindView(R.id.img_collect)
    ImageView img_collect;

    private int shu = 1;//购买的数量

    private GoodDetailBean.DataBeanX.InfoBean info;
    private TextView num;
    private boolean cick;//判断购物车的点击情况
    private boolean collcation;//判断收藏的点击情况
    private PopupWindow popupWindow;
    private GoodDetailBean goodDetailBean;

    @Override
    protected int getLayout() {
        return R.layout.activity_home_item_details;
    }

    @Override
    protected GoodDetailPersenter createPrenter() {
        return new GoodDetailPersenter(this);
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        Toast.makeText(this, "" + id, Toast.LENGTH_SHORT).show();
        //点击添加购物车
        txt_addCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!cick) {
                    if (info != null) {
                        initpop(info);
                    }
                    cick = true;
                } else {
                    cick = false;
                    closepop();
                    addCar();
                }


            }
        });
    }

    @Override
    protected void initData() {
        persenter.getGoodDetail(id);
    }

    @Override
    public void getGoodDetailResult(GoodDetailBean result) {
        goodDetailBean = result;
        GoodDetailBean.DataBeanX data = result.getData();
        //banner
        List<GoodDetailBean.DataBeanX.GalleryBean> gallery = data.getGallery();
        hotgoodsitem_banner.setImages(gallery).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                GoodDetailBean.DataBeanX.GalleryBean galleryBean = (GoodDetailBean.DataBeanX.GalleryBean) path;
                Glide.with(context).load(galleryBean.getImg_url()).into(imageView);
            }
        }).start();
        //信息
        info = data.getInfo();
        hotgoodsitem_name.setText(info.getName());
        hotgoodsitem__brief.setText(info.getGoods_brief());
        hotgoodsitem__price.setText("￥" + info.getRetail_price());
        initGoodDetail(info.getGoods_desc());

        //商品参数
        List<GoodDetailBean.DataBeanX.AttributeBean> attribute = data.getAttribute();
        rcy_attribute.setLayoutManager(new LinearLayoutManager(this));
        DetailsAttributeAdpter detailsAttributeAdpter = new DetailsAttributeAdpter(this, attribute);
        rcy_attribute.setAdapter(detailsAttributeAdpter);

        //常见问题
        List<GoodDetailBean.DataBeanX.IssueBean> issue = data.getIssue();
        rcy_issue.setLayoutManager(new LinearLayoutManager(this));
        DetailsIssueAdpter detailsIssueAdpter = new DetailsIssueAdpter(this, issue);
        rcy_issue.setAdapter(detailsIssueAdpter);

        //点击购物车图标跳转到shopfragment
        img_car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeItemDetailsActivity.this, MainActivity.class);
                intent.putExtra("indext", 3);
                startActivity(intent);
            }
        });
        //点击收藏图标收藏
        img_collect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (collcation) {
                    img_collect.setImageResource(R.mipmap.collcation);
                    Toast.makeText(HomeItemDetailsActivity.this, "收藏成功", Toast.LENGTH_SHORT).show();
                    //添加数据库
                    Realm.getRealm(HomeItemDetailsActivity.this).executeTransaction(
                            new io.realm.Realm.Transaction() {
                                @Override
                                public void execute(io.realm.Realm realm) {
                                    CollcationsListBean collcationsListBean = realm.createObject(CollcationsListBean.class);
                                    collcationsListBean.setName(info.getName());
                                    collcationsListBean.setPic(info.getPrimary_pic_url());
                                    collcationsListBean.setPrice("￥" + info.getRetail_price());
                                    collcationsListBean.setContent(info.getGoods_desc());
                                }
                            }
                    );
                    collcation = false;

                } else {
                    img_collect.setImageResource(R.mipmap.nocollcation);
                    Toast.makeText(HomeItemDetailsActivity.this, "取消收藏", Toast.LENGTH_SHORT).show();
                    collcation = true;
                    //添加到数据库

                }
            }
        });


    }

    @Override
    public void addShopCarReturn(ShopCarDataBean addCarBean) {
        //添加成功以后跟新数量显示
        int number = addCarBean.getData().getCartTotal().getGoodsCount();
        txt_number.setText(String.valueOf(number));
    }

    //添加购物车
    private void addCar() {
        if (shu <= 0) {
            Toast.makeText(this, "请选择商品的数量", Toast.LENGTH_SHORT).show();
            return;
        }
        if (goodDetailBean.getData().getProductList().size() > 0) {
            int goodsId = this.goodDetailBean.getData().getProductList().get(0).getGoods_id();
            int productid = this.goodDetailBean.getData().getProductList().get(0).getId();
            Map<String, String> map = new HashMap<>();
            map.put("goodsId", String.valueOf(goodsId));
            map.put("number", String.valueOf(shu));
            map.put("productId", String.valueOf(productid));
            persenter.addShopCar(map);
        }
    }

    //图片
    private void initGoodDetail(String goods_desc) {
        //        String content = h5.replace( "word", webData );
//        Log.i( "TAG", content );
//        mWebView.loadDataWithBaseURL( "about:blank", content, "text/html", "utf-8", null );

        listUrl = new ArrayList<>();

        String str = null;
        String[] image = goods_desc.split("http");
        for (int i = 0; i < image.length; i++) {
            String[] url = image[i].split("jpg");
            if (url.length != 0) {
                for (int j = 0; j < url.length - 1; j++) {
                    str = "http" + url[0] + "jpg";
                    //集合里是否包含了元素
                    if (!listUrl.contains(str))
                        listUrl.add(str);
                }
            }
            String[] urls = image[i].split("png");
            if (urls.length != 0) {
                for (int j = 0; j < urls.length - 1; j++) {
                    str = "http" + urls[0] + "png";
                    if (!listUrl.contains(str))
                        listUrl.add(str);
                }
            }
        }
        //大图
        rv_img.setLayoutManager(new LinearLayoutManager(this));
        BigAdapter bigAdapter = new BigAdapter(this, listUrl);
        rv_img.setAdapter(bigAdapter);
        bigAdapter.addListClick(new BaseAdapter.IListClick() {
            @Override
            public void itemClick(int pos) {
                //跳转页面
                Intent intent = new Intent(HomeItemDetailsActivity.this, BigImageActivity.class);
                intent.putExtra("imageList", (Serializable) listUrl);
                intent.putExtra("id", pos);
                startActivity(intent);
            }
        });


    }

    //弹窗
    private void initpop(GoodDetailBean.DataBeanX.InfoBean info) {
        //pop
        View join_view = LayoutInflater.from(HomeItemDetailsActivity.this).inflate(R.layout.join_item, null);
        popupWindow = new PopupWindow(join_view, GridLayout.LayoutParams.MATCH_PARENT, GridLayout.LayoutParams.WRAP_CONTENT);
        ImageView image_pop = join_view.findViewById(R.id.join_img);
        TextView price_pop = join_view.findViewById(R.id.join__brief);
        TextView jia = join_view.findViewById(R.id.join_jia);
        TextView jian = join_view.findViewById(R.id.join_jian);
        num = join_view.findViewById(R.id.join_num);
        Glide.with(HomeItemDetailsActivity.this).load(info.getList_pic_url()).into(image_pop);
        price_pop.setText("￥" + info.getRetail_price() + "");
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.5f;
        getWindow().setAttributes(attributes);
        //弹出pw
        popupWindow.showAtLocation(layout_car, Gravity.BOTTOM, 0, 140);
        jia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shu++;
                if (shu > 0) {
                    num.setText(String.valueOf(shu));
                    String s = txt_number.getText().toString();
                    TxtUtils.setTextView(txt_number, Integer.valueOf(s) + 1);
                }


            }
        });
        jian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (--shu > 0) {
                    num.setText(String.valueOf(shu));

                    String s1 = txt_number.getText().toString();
                    TxtUtils.setTextView(txt_number, Integer.valueOf(s1) - 1);
                }

            }
        });

        join_view.findViewById(R.id.join_no).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closepop();
            }
        });

    }

    //关闭弹窗
    private void closepop() {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 1f;
        getWindow().setAttributes(attributes);
        popupWindow.dismiss();
    }


    @Override
    public void showTips(String tips) {
    }
}

