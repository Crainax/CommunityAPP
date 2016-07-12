package com.unique.app.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import com.unique.app.R;
import com.unique.app.debbug.FakeContent;
import com.unique.app.entity.UserInfo;
import com.unique.app.ui.adapter.MyFollowAdapter;
import com.unique.app.ui.adapter.SpaceItemDecoration;
import com.unique.app.ui.view.CenterToolbar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Project: CommnitiAPP <br/>
 * Package: com.unique.app.ui <br/>
 * Description: <br/>
 * <hr/>
 *
 * @author Crainax <br/>
 * @version 1.0 <br/>
 * @since 2016/7/11 <br/>
 */
public class MyFollowActivity extends BaseActivity implements MyFollowAdapter.OnMyFollowItemClickListener {
    @BindView(R.id.rv_my_follow)
    RecyclerView mRvMyFollow;
    @BindView(R.id.toolbar)
    CenterToolbar mToolbar;

    private MyFollowAdapter mMyFollowAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_follow);
        ButterKnife.bind(this);

        initToolbar();
        initRecyclerView();
    }

    private void initRecyclerView() {

        mMyFollowAdapter = new MyFollowAdapter(fakeContent());
        mRvMyFollow.setAdapter(mMyFollowAdapter);
        mRvMyFollow.setHasFixedSize(true);
        mRvMyFollow.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRvMyFollow.setItemAnimator(new DefaultItemAnimator());

        int spacingInPixel = getResources().getDimensionPixelSize(R.dimen.rv_my_follow_item_distance);
        mRvMyFollow.addItemDecoration(new SpaceItemDecoration(spacingInPixel));
        mMyFollowAdapter.setOnMyFollowItemClickListener(this);
    }

    private void initToolbar() {
        mToolbar.setTitle("我的关注");
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

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

    @FakeContent
    private List<UserInfo> fakeContent() {

        List<UserInfo> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            UserInfo userInfo = new UserInfo();
            userInfo.setUserName("用户" + random.nextInt(100000));
            switch (random.nextInt(2)) {
                case 0:
                    userInfo.setAvatarUrl("http://static.tieba.baidu.com/tb/editor/images/client/image_emoticon25.png");
                    break;
                case 1:
                    userInfo.setAvatarUrl("http://tb2.bdstatic.com/tb/static-user/widget/celebrity/img/single_member_100_0b51e9e.png");
                    break;
                case 2:
                    userInfo.setAvatarUrl("http://tb2.bdstatic.com/tb/static-user/widget/celebrity/img/single_member_100_0b51e9e.png");
                    break;
            }
            list.add(userInfo);
        }

        return list;
    }

    @Override
    public void onMyFollowUserNameClick(View view, UserInfo userInfo) {
        Intent intent = new Intent(MyFollowActivity.this, UserInfoActivity.class);
        startActivity(intent);
    }

    @Override
    public void onMyFollowAvatarClick(View view, UserInfo userInfo) {
        // TODO: 2016/7/12 放大图片
    }
}
