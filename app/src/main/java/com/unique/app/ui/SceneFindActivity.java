package com.unique.app.ui;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.Switch;

import com.unique.app.R;
import com.unique.app.ui.frag.MultiSceneFindFragment;
import com.unique.app.ui.frag.SceneFindFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SceneFindActivity extends BaseActivity implements
        CompoundButton.OnCheckedChangeListener, Toolbar.OnMenuItemClickListener {

    @BindView(R.id.toolbar)
    public Toolbar mToolbar;
    RecyclerView mRvSceneFind;
    @BindView(R.id.switch_scene_find)
    Switch mSwitchSceneFind;
    @BindView(R.id.container_scene_find)
    FrameLayout mContainerSceneFind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene_find);
        ButterKnife.bind(this);

        //初始化选择
        initToolbar();
        initSwitch();

        //选取左边的Fragment
        setSceneFindSingleFragment();
    }

    private void initSwitch() {
        mSwitchSceneFind.setOnCheckedChangeListener(this);
    }

    /**
     * 初始化标题栏
     */
    private void initToolbar() {
        mToolbar.setTitle("场景寻人");
        mToolbar.inflateMenu(R.menu.menu_toolbar_scene);
        mToolbar.setOnMenuItemClickListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (!isChecked) {
            //左边
            setSceneFindSingleFragment();
        } else {
            //右边
            setSceneFindMultiFragment();
        }
    }

    private void setSceneFindMultiFragment() {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.container_scene_find, new MultiSceneFindFragment());
        ft.commit();
    }

    private void setSceneFindSingleFragment() {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.container_scene_find, new SceneFindFragment());
        ft.commit();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_tb_scene_find_add:
                NewSceneFindActivity.start(this);
        }
        return false;
    }
}
