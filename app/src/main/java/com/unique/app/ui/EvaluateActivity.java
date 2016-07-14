package com.unique.app.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RatingBar;

import com.orhanobut.logger.Logger;
import com.unique.app.R;
import com.unique.app.entity.EvaluateInfo;
import com.unique.app.ui.adapter.EvaluateAdapter;
import com.unique.app.ui.adapter.SpaceItemDecoration;
import com.unique.app.ui.view.CenterToolbar;

import java.util.ArrayList;
import java.util.List;

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
 * @since 2016/7/12 <br/>
 */
public class EvaluateActivity extends BaseActivity implements
        CenterToolbar.OnToolbarBackClickListener, EvaluateAdapter.OnEvaluateItemClickListener {

    public static final String INTENT_SCENE_FIND_INFO_SINGLE = "scene_find_single";
    public static final String INTENT_SCENE_FIND_INFO_MULTI = "scene_find_multi";
    @BindView(R.id.rv_evaluate)
    RecyclerView mRvEvaluate;
    @BindView(R.id.toolbar)
    CenterToolbar mToolbar;

    private EvaluateInfo mSingleData;
    private List<EvaluateInfo> mDataList;
    private EvaluateAdapter mEvaluateAdapter;

    public static void startSingleEvaluate(Context context, EvaluateInfo data) {
        Intent starter = new Intent(context, EvaluateActivity.class);
        starter.putExtra(INTENT_SCENE_FIND_INFO_SINGLE, data);
        context.startActivity(starter);
    }

    public static void startMultiEvaluate(Context context, ArrayList<EvaluateInfo> datas) {
        Intent starter = new Intent(context, EvaluateActivity.class);
        starter.putParcelableArrayListExtra(INTENT_SCENE_FIND_INFO_MULTI, datas);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluate);
        ButterKnife.bind(this);

        //获取数据
        Intent intent = getIntent();
        mSingleData = intent.getParcelableExtra(INTENT_SCENE_FIND_INFO_SINGLE);
        mDataList = intent.getParcelableArrayListExtra(INTENT_SCENE_FIND_INFO_MULTI);
        if (mSingleData == null && mDataList == null) {
            finish();
            Logger.w("onCreate: EvaluateActivity 没有数据传入,已经停止");
        }

        if (mSingleData != null && mDataList != null) {
            finish();
            Logger.w("onCreate: EvaluateActivity 数据传入过多,已经停止");
        }

        //初始化
        initToolbar();

        initRecyclerView();
    }


    private void initRecyclerView() {

        if (mSingleData != null) {
            mEvaluateAdapter = new EvaluateAdapter(mSingleData);
        } else {
            mEvaluateAdapter = new EvaluateAdapter(mDataList);
        }

        mRvEvaluate.setAdapter(mEvaluateAdapter);
        mRvEvaluate.setHasFixedSize(true);
        mRvEvaluate.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRvEvaluate.setItemAnimator(new DefaultItemAnimator());

        int spacingInPixel = getResources().getDimensionPixelSize(R.dimen.rv_evaluate_item_distance);
        // TODO: 2016/7/12 上传到JCenter()中去
        mRvEvaluate.addItemDecoration(new SpaceItemDecoration(spacingInPixel));
        mEvaluateAdapter.setOnEvaluateItemClickListener(this);

    }

    private void initToolbar() {

        mToolbar.setTitle("评价");
        mToolbar.enableBackButton(true);
        mToolbar.setOnToolbarBackClickListener(this);

    }

    @Override
    public void onToolbarBackClick(View view) {
        finish();
    }

    @Override
    public void onItemClick(View view, EvaluateInfo data) {
    }

    @Override
    public void onAvatarItemClick(View view, EvaluateInfo data) {
        PictureActivity.start(this, data.getUserInfo().getAvatarUrl(), view);
    }

    @Override
    public void onUserNameItemClick(View view, EvaluateInfo data) {
        UserInfoActivity.start(this, data.getUserInfo());
    }

    @Override
    public void onRatingBarItemChange(RatingBar ratingBar, float rating, boolean fromUser, EvaluateInfo data) {
        ratingBar.setIsIndicator(true);
        data.setEvaluate(true);
        data.setRating(rating);
        mEvaluateAdapter.notifyDataSetChanged();
        // TODO: 2016/7/13 Presenter中去运行成功上传的逻辑
    }
}
