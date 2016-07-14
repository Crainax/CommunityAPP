package com.unique.app.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.unique.app.R;
import com.unique.app.debbug.FakeUtils;
import com.unique.app.entity.SceneFindSingleInfo;
import com.unique.app.ui.adapter.LauncherActAdapter;
import com.unique.app.ui.adapter.SpaceItemDecoration;
import com.unique.app.ui.view.CenterToolbar;

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
public class LauncherActActivity extends BaseActivity implements
        LauncherActAdapter.OnLauncherActItemClickListener, CenterToolbar.OnToolbarBackClickListener {

    @BindView(R.id.rv_launch_act)
    RecyclerView mRvLaunchAct;
    @BindView(R.id.toolbar)
    CenterToolbar toolbar;
    private LauncherActAdapter mLauncherActAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_act);
        ButterKnife.bind(this);

        initToolbar();
        initRecyclerView();
    }


    private void initRecyclerView() {

        mLauncherActAdapter = new LauncherActAdapter(FakeUtils.fakeSceneFindSingleInfo(10));
        mRvLaunchAct.setAdapter(mLauncherActAdapter);
        mRvLaunchAct.setHasFixedSize(true);
        mRvLaunchAct.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRvLaunchAct.setItemAnimator(new DefaultItemAnimator());

        int spacingInPixel = getResources().getDimensionPixelSize(R.dimen.rv_my_follow_item_distance);
        // TODO: 2016/7/12 上传到JCenter()中去
        mRvLaunchAct.addItemDecoration(new SpaceItemDecoration(spacingInPixel));
        mLauncherActAdapter.setLauncherActItemClickListener(this);

    }

    private void initToolbar() {

        toolbar.setTitle("我发起的活动");
        toolbar.enableBackButton(true);
        toolbar.setOnToolbarBackClickListener(this);
    }

    @Override
    public void onLauncherActItemClick(View view, SceneFindSingleInfo sceneFindSingleInfo) {

    }

    @Override
    public void onEvaluateButtonClick(View view, SceneFindSingleInfo sceneFindSingleInfo) {
        EvaluateActivity.startSingleEvaluate(this, sceneFindSingleInfo.getEvaluateInfo());
    }


    @Override
    public void onToolbarBackClick(View view) {
        finish();
    }
}
