package com.example.myshop.ui.me;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.alibaba.sdk.android.oss.ClientConfiguration;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.OSS;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSStsTokenCredentialProvider;
import com.alibaba.sdk.android.oss.internal.OSSAsyncTask;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.myshop.R;
import com.example.myshop.app.Constants;
import com.example.myshop.base.BaseActivity;
import com.example.myshop.base.BasePresenter;
import com.example.myshop.utils.BitmapUtils;
import com.example.myshop.utils.GlideEngine;
import com.example.myshop.utils.SpUtils;
import com.example.myshop.utils.SystemUtils;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserDetailActivity extends BaseActivity {
    @BindView(R.id.img_avatar)
    ImageView imgAvatar;
    @BindView(R.id.txt_username)
    TextView txtUsername;
    @BindView(R.id.txt_nickname)
    TextView txtNickname;

    String buckName = "2002aaa";
    String ossPoint = "http://oss-cn-beijing.aliyuncs.com";
    String key = "LTAI4GH6Gy8tFbbXJ3vatsAn";  //appkey
    String secret = "YjWyqsTnHX8336jRZ1vg7FSWaojPf8";  //密码

   /*自己的
    String buckName = "lihahaha";
    String ossPoint = "http://lihahaha.oss-cn-beijing.aliyuncs.com";
    String key = "LTAI4G922N8gcFgs8Qnm5r1f";  //appkey
    String secret = "lNKkUkhWIDwiAqkSR7lhJoaj1vDe29";  //密码*/
    @BindView(R.id.img_arrow_lt)
    ImageView imgArrowLt;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.img_share)
    ImageView imgShare;
    @BindView(R.id.img_menu)
    ImageView imgMenu;
    @BindView(R.id.layout_menu)
    ConstraintLayout layoutMenu;
    @BindView(R.id.layout_avatar)
    ConstraintLayout layoutAvatar;
    @BindView(R.id.layout_nickname)
    ConstraintLayout layoutNickname;
    @BindView(R.id.txt_birthday)
    TextView txtBirthday;
    @BindView(R.id.layout_birthday)
    ConstraintLayout layoutBirthday;
    @BindView(R.id.input)
    ConstraintLayout input;
    @BindView(R.id.btn_exit)
    Button btnExit;
    @BindView(R.id.txt_input)
    EditText txtInput;
    @BindView(R.id.btn_save)
    Button btnSave;
    @BindView(R.id.layout_input)
    ConstraintLayout layoutInput;


    private OSS ossClient;
    private Bitmap scaleBitmp;

    @Override
    protected int getLayout() {
        return R.layout.activity_user_detail;
    }

    @Override
    protected BasePresenter createPrenter() {
        return null;
    }

    @Override
    protected void initView() {
        initOss();
        //头像
        imgAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //打开相册
                openPhoto();
            }
        });
        //用户名
        String token = SpUtils.getInstance().getString("token");
        if (token != null) {
            String name = SpUtils.getInstance().getString("name");
            txtUsername.setText(name);
        }
        //昵称
        txtNickname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //打开键盘输入的状态
                showInput();
            }
        });

        //保存
        btnSave.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nikename = txtInput.getText().toString();
                SpUtils.getInstance().setValue( "nickname",nikename );
                txtNickname.setText( nikename  );
                if (!TextUtils.isEmpty( nikename )) {
                    Map<String, String> map = new HashMap<>();
                    map.put( "nickname", nikename );
                    //请求数据
                    //记得添加// persenter.updateUser(map);
                }
                layoutInput.setVisibility( View.GONE );
            }
        } );

    }

    //打开键盘输入
    private void showInput() {
        layoutInput.setVisibility(View.VISIBLE);
        //光标
        txtInput.setFocusable(true);
        SystemUtils.openSoftKeyBoard(this);
    }

    @Override
    protected void initData() {
        String img = SpUtils.getInstance().getString( "img" );
        if (!TextUtils.isEmpty( img )) {
            Glide.with( this ).load( img ).apply( new RequestOptions().circleCrop() ).into( imgAvatar );
        }

        btnExit.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //记得添加// persenter.exit();
            }
        } );
    }

    //初始化OSS
    private void initOss() {
        OSSCredentialProvider credentialProvider = new OSSStsTokenCredentialProvider(key, secret, "");
        // 配置类如果不设置，会有默认配置。
        ClientConfiguration conf = new ClientConfiguration();
        conf.setConnectionTimeout(15 * 1000); // 连接超时，默认15秒。
        conf.setSocketTimeout(15 * 1000); // socket超时，默认15秒。
        conf.setMaxConcurrentRequest(5); // 最大并发请求数，默认5个。
        conf.setMaxErrorRetry(2); // 失败后最大重试次数，默认2次。
        ossClient = new OSSClient(getApplicationContext(), ossPoint, credentialProvider);
    }

    //跳转到相册
    private void openPhoto() {
        PictureSelector.create(this)
                .openGallery(PictureMimeType.ofImage())
                .loadImageEngine(GlideEngine.createGlideEngine())
                .maxSelectNum(1)
                .imageSpanCount(4)
                .selectionMode(PictureConfig.MULTIPLE)
                .forResult(PictureConfig.CHOOSE_REQUEST);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case PictureConfig.CHOOSE_REQUEST:
                List<LocalMedia> selectList = PictureSelector.obtainMultipleResult(data);
                if (selectList.size() == 0) return;
                //获取本地图片的选择地址，上传到服务器
                //头像的压缩和二次采样
                //把选中的图片插入到列表
                for (int i = 0; i < selectList.size(); i++) {
                        scaleBitmp = BitmapUtils.getBitmap( selectList.get( i ).getPath(), Constants.HEAD_WIDTH, Constants.HEAD_HEIGHT );
                    //Bitmap转uri
                    Uri uri = Uri.parse(MediaStore.Images.Media.insertImage(getContentResolver(), scaleBitmp, null, null));
                    //uri转字符串
                    String path = getRealPathFromUri(this, uri);
                    uploadHead(path);
                }

                break;
            default:
                throw new IllegalStateException("Unexpected value: " + requestCode);

        }
    }

    //uri转字符串的方法
    public static String getRealPathFromUri(Context context, Uri contentUri) {
        Cursor cursor = null;
        try {
            String[] proj = {MediaStore.Images.Media.DATA};
            cursor = context.getContentResolver().query(contentUri, proj, null, null, null);
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }
    //oss上传图片
    private void uploadHead(String path) {
        String fileName = path.substring(path.lastIndexOf("/") + 1, path.length());
        PutObjectRequest put = new PutObjectRequest(buckName, fileName, path);
        put.setProgressCallback(new OSSProgressCallback<PutObjectRequest>() {
            @Override
            public void onProgress(PutObjectRequest request, long currentSize, long totalSize) {
                //上次进度
                Log.i("oss_upload", currentSize + "/" + totalSize);
                // 进度百分比的计算
                // int p = (int) (currentSize/totalSize*100);
                if (currentSize == totalSize) {
                    //完成
                    String headUrl = request.getUploadFilePath();
                    //
                    Log.i("HeadUrl", headUrl);
                    //request.getUploadFilePath()
                }

            }
        });
        OSSAsyncTask task = ossClient.asyncPutObject(put, new OSSCompletedCallback<PutObjectRequest, PutObjectResult>() {
            @Override
            public void onSuccess(PutObjectRequest request, PutObjectResult result) {
                Log.d("PutObject", "UploadSuccess");
                Log.d("ETag", result.getETag());
                Log.d("RequestId", result.getRequestId());
                //成功的回调中读取相关的上传文件的信息  生成一个url地址
                String url = ossClient.presignPublicObjectURL(request.getBucketName(), request.getObjectKey());
                //TODO 刷新显示到界面上
                Log.e("TAG", "sp: ....." + SpUtils.getInstance().getString("avatar"));
                Log.e("TAG", "onSuccess: /////" + url);
                Map<String, String> map = new HashMap<>();
                map.put("avatar", url);
                //记得添加//persenter.updateUserInfo(map);
                updateHead(url);
                //调用服务器接口，把url上传到服务器的接口
                SpUtils.getInstance().setValue("avatar", url);
            }

            @Override
            public void onFailure(PutObjectRequest request, ClientException clientExcepion, ServiceException serviceException) {
                // 请求异常。
                if (clientExcepion != null) {
                    // 本地异常，如网络异常等。
                    clientExcepion.printStackTrace();
                }
                if (serviceException != null) {
                    // 服务异常。
                    Log.e("ErrorCode", serviceException.getErrorCode());
                    Log.e("RequestId", serviceException.getRequestId());
                    Log.e("HostId", serviceException.getHostId());
                    Log.e("RawMessage", serviceException.getRawMessage());
                }
            }
        });
    }

    private void updateHead(String url) {
        String token = SpUtils.getInstance().getString("token");
        if (token != null) {
            //赋值到组件上
            imgAvatar.post(new Runnable() {
                @Override
                public void run() {
                    Glide.with(UserDetailActivity.this).load(url).apply(new RequestOptions().circleCrop()).into(imgAvatar);
                }
            });
        }

  /*  @Override
    public void getResult(UserInfoBean userInfoBean) {
        txtUsername.setText(SpUtils.getInstance().getString("username"));
        String nickname = SpUtils.getInstance().getString("nickname");
        if (!TextUtils.isEmpty(nickname)) {
            txtNickname.setText(nickname);
        }
        if (userInfoBean.getErrno() == 0) {
            String tips = "更新成功";
            showToast(tips);
            //"更新成功"
        }
    }*/
    /*    @Override
        public void updateUserReturn(UserBean userBean) {
            if (userBean.getErrno() == 0) {
                SystemUtils.closeSoftKeyBoard( this );
                layoutInput.setVisibility( View.GONE );
            }
        }

        @Override
        public void exitReturn(ExitBean exitBean) {

            int errno = exitBean.getErrno();
            if (errno == 0) {
                //退出
                SpUtils.getInstance().delete();
                SpUtils.getInstance().remove( "token" );
                finish();


            } else {
                Toast.makeText( this, "退出失败", Toast.LENGTH_SHORT ).show();
            }
        }*/





    }

    @Override
    public void showTips(String tips) {

    }
}