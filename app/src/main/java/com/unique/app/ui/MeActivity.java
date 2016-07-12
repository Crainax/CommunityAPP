package com.unique.app.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.unique.app.R;
import com.unique.app.ui.view.CenterToolbar;

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
 * @since 2016/7/10 <br/>
 */
public class MeActivity extends BaseActivity {

    @BindView(R.id.iv_me_avatar)
    CircleImageView mIvMeAvatar;
    @BindView(R.id.tv_me_user)
    TextView mTvMeUser;
    @BindView(R.id.tv_me_profile)
    TextView mTvMeProfile;
    @BindView(R.id.toolbar)
    CenterToolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);
        ButterKnife.bind(this);
        initToolbar();
    }

    /**
     * 初始化Toolbar
     */
    private void initToolbar() {

        mToolbar.setTitle("个人主页");

    }

    @OnClick({R.id.click_me_edit_my_profile,R.id.click_me_my_follow, R.id.click_me_launch_act, R.id.click_me_partake_act, R.id.click_me_msg_list, R.id.click_me_setting, R.id.click_me_exit})
     void onClick(View view) {
        switch (view.getId()) {
            case R.id.click_me_edit_my_profile:
                startEditProfileActivity();
                break;
            case R.id.click_me_my_follow:
                startMyFollowActivity();
                break;
            case R.id.click_me_launch_act:
                startLaunchActActivity();
                break;
            case R.id.click_me_partake_act:
                startPartakeActActivity();
                break;
            case R.id.click_me_msg_list:
                startMsgListActivity();
                break;
            case R.id.click_me_setting:
                startSettingActivity();
                break;
            case R.id.click_me_exit:
                exitUser();
                break;
        }
    }

    private void startEditProfileActivity() {
        Intent intent = new Intent(MeActivity.this, EditProfileActivity.class);
        startActivity(intent);
    }

    private void exitUser() {
        // TODO: 2016/7/10 退出帐号
        Intent intent = new Intent(MeActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    private void startSettingActivity() {
        Intent intent = new Intent(MeActivity.this, SettingActivity.class);
        startActivity(intent);
    }

    private void startMsgListActivity() {
        Intent intent = new Intent(MeActivity.this, MsgListActivity.class);
        startActivity(intent);
    }

    private void startPartakeActActivity() {
        Intent intent = new Intent(MeActivity.this, PartakeActivity.class);
        startActivity(intent);
    }

    private void startLaunchActActivity() {
        Intent intent = new Intent(MeActivity.this, LauncherActActivity.class);
        startActivity(intent);
    }

    private void startMyFollowActivity() {
        Intent intent = new Intent(MeActivity.this, MyFollowActivity.class);
        startActivity(intent);
    }
}
