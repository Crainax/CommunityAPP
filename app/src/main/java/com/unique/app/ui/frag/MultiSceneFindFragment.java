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
import com.unique.app.entity.SceneFindMultiInfo;
import com.unique.app.ui.adapter.SceneFindMultiAdapter;
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
public class MultiSceneFindFragment extends Fragment implements
         SceneFindMultiAdapter.OnSceneFindItemClickListener {

    private RecyclerView mRvData;
    private SceneFindMultiAdapter mAdapter;

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

        mAdapter = new SceneFindMultiAdapter(FakeUtils.fakeSceneFindMultiInfo(10));
        mRvData.setAdapter(mAdapter);
        mRvData.setHasFixedSize(true);
        mRvData.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mRvData.setItemAnimator(new DefaultItemAnimator());

        int spacingInPixel = getResources().getDimensionPixelSize(R.dimen.rv_my_follow_item_distance);
        mRvData.addItemDecoration(new SpaceItemDecoration(spacingInPixel));
        mAdapter.setOnSceneFindItemClickListener(this);

    }

    @Override
    public void onSceneFindItemClick(View view, SceneFindMultiInfo sceneFindMultiInfo) {

    }

    @Override
    public void onLikeClick(View view, SceneFindMultiInfo sceneFindMultiInfo) {

    }

    @Override
    public void onPeopleCountClick(View view, SceneFindMultiInfo sceneFindMultiInfo) {

    }
}
