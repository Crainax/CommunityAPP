package com.unique.app.ui.frag;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.unique.app.R;
import com.unique.app.debbug.FakeUtils;
import com.unique.app.entity.SceneFindSingleInfo;
import com.unique.app.ui.PictureActivity;
import com.unique.app.ui.UserInfoActivity;
import com.unique.app.ui.adapter.SceneFindAdapter;
import com.unique.app.ui.adapter.SpaceItemDecoration;

/**
 * Project: CommnitiAPP <br/>
 * Package: com.unique.app.ui.frag <br/>
 * Description: <br/>
 * <hr/>
 *
 * @author Crainax <br/>
 * @version 1.0 <br/>
 * @since 2016/7/8 <br/>
 */
public class SceneFindFragment extends Fragment implements SceneFindAdapter.OnSceneFindItemClickListener {

    private RecyclerView mRvData;
    private SceneFindAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mRvData = new RecyclerView(container.getContext());

        int spacingInPixel = getResources().getDimensionPixelSize(R.dimen.padding_5dp);
        mRvData.setPadding(0, spacingInPixel, 0, spacingInPixel);

        initRecyclerView();
        return mRvData;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void initRecyclerView() {

        mAdapter = new SceneFindAdapter(FakeUtils.fakeSceneFindSingleInfo(10));
        mRvData.setAdapter(mAdapter);
        mRvData.setHasFixedSize(true);
        mRvData.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mRvData.setItemAnimator(new DefaultItemAnimator());

        int spacingInPixel = getResources().getDimensionPixelSize(R.dimen.rv_my_follow_item_distance);
        mRvData.addItemDecoration(new SpaceItemDecoration(spacingInPixel));
        mAdapter.setOnSceneFindItemClickListener(this);

    }

    @Override
    public void onSceneFindItemClick(View view, SceneFindSingleInfo sceneFindSingleInfo) {

    }

    @Override
    public void onLikeClick(View view, SceneFindSingleInfo sceneFindSingleInfo) {
        // TODO: 2016/7/14 处理我要加入逻辑
    }

    @Override
    public void onAvatarClick(View view, SceneFindSingleInfo sceneFindSingleInfo) {
        PictureActivity.start(getActivity(), sceneFindSingleInfo.getEvaluateInfo().getUserInfo().getAvatarUrl(), view);
    }

    @Override
    public void onUserNameClick(View view, SceneFindSingleInfo sceneFindSingleInfo) {
        UserInfoActivity.start(getActivity(), sceneFindSingleInfo.getEvaluateInfo().getUserInfo());
    }
}
