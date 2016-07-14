package com.unique.app.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.orhanobut.logger.Logger;
import com.unique.app.R;
import com.unique.app.entity.UserInfo;
import com.unique.app.ui.view.CenterToolbar;

import java.text.DecimalFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Project: CommnitiAPP <br/>
 * Package: com.unique.app.ui <br/>
 * Description: <br/>
 * <hr/>
 *
 * @author Crainax <br/>
 * @version 1.0 <br/>
 * @since 2016/7/12 <br/>
 */
public class UserInfoActivity extends BaseActivity implements CenterToolbar.OnToolbarBackClickListener {

    private static final String TAG = "Crainax";

    public static final String INTENT_DATA_IS_FOLLOW = "is_follow";
    public static final String INTENT_DATA_USER = "user";

    private UserInfo userInfo;

    @BindView(R.id.iv_user_info_avatar)
    CircleImageView ivUserInfoAvatar;
    @BindView(R.id.tv_user_info_user_name)
    TextView tvUserInfoUserName;
    @BindView(R.id.click_user_info_follow)
    Button clickUserInfoFollow;
    @BindView(R.id.tv_user_info_launch_act_num)
    TextView tvUserInfoLaunchActNum;
    @BindView(R.id.tv_user_info_partake_in_num)
    TextView tvUserInfoPartakeInNum;
    @BindView(R.id.tv_user_info_friendly_num)
    TextView tvUserInfoFriendlyNum;
    @BindView(R.id.tv_user_info_tel)
    TextView tvUserInfoTel;
    @BindView(R.id.rv_user_info_org)
    RecyclerView rvUserInfoOrg;
    @BindView(R.id.rv_user_info_tag)
    RecyclerView rvUserInfoTag;
    @BindView(R.id.toolbar)
    CenterToolbar mToolbar;

    public static void start(Context context, UserInfo userInfo) {
        Intent starter = new Intent(context, UserInfoActivity.class);
        starter.putExtra(INTENT_DATA_USER, userInfo);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        //获取用户信息
        Intent intent = getIntent();
        userInfo = intent.getParcelableExtra(UserInfoActivity.INTENT_DATA_USER);

        if (userInfo == null) {
            finish();
            Logger.i("没有用户信息,退出");
        }

        ButterKnife.bind(this);

        initView(intent);
        initToolbar();
    }

    private void initToolbar() {

        mToolbar.setTitle("用户信息");
        mToolbar.enableBackButton(true);
        mToolbar.setOnToolbarBackClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initView(Intent intent) {

        // TODO: 2016/7/13 ISFOLLOW从网上获取吧,不通过Intent发过来了

        //关注按钮
        if (intent.getBooleanExtra(UserInfoActivity.INTENT_DATA_IS_FOLLOW, false)) {
            clickUserInfoFollow.setText("已关注");
        }

        //昵称及头像
        tvUserInfoUserName.setText(userInfo.getUserName());
        Glide.with(this).load(userInfo.getAvatarUrl())
                .placeholder(R.drawable.placeholder).dontAnimate().into(ivUserInfoAvatar);

        //用户信息
        tvUserInfoLaunchActNum.setText(String.valueOf(userInfo.getLaunchActCount()));
        DecimalFormat format = new DecimalFormat("0.0");
        tvUserInfoFriendlyNum.setText(format.format(userInfo.getFriendlyNum()));
        tvUserInfoPartakeInNum.setText(String.valueOf(userInfo.getPartakeInNum()));

        Log.i(TAG, "fakeContent: " + userInfo);
        //联系方式
        if (userInfo.isPrivate())
            tvUserInfoTel.setText(getResources().getString(R.string.act_user_info_tel, "未公开"));
        else
            tvUserInfoTel.setText(getResources().getString(R.string.act_user_info_tel, userInfo.getTel()));

        //标签及组织
        // TODO: 2016/7/12 RecyclerView 的组织及标签

    }

    @OnClick({R.id.iv_user_info_avatar, R.id.click_user_info_follow, R.id.click_user_info_talk})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_user_info_avatar:
                PictureActivity.start(this, userInfo.getAvatarUrl(), view);
                break;
            case R.id.click_user_info_follow:

                break;
            case R.id.click_user_info_talk:
                //聊天
                Intent intent = new Intent(UserInfoActivity.this, TalkActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onToolbarBackClick(View view) {
        finish();
    }
}
