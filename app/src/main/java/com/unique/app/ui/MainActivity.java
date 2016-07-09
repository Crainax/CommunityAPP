package com.unique.app.ui;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;
import com.unique.app.R;
import com.unique.app.ui.frag.BaseFragment;
import com.unique.app.util.BottomFragmentNavigator;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements OnMenuTabClickListener {

    @BindView(R.id.toolbar)
    public Toolbar mToolbar;

    private BottomBar mBottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //初始化选择
        initToolbar();
        initBottomBar(savedInstanceState);

    }

    /**
     * 初始化底部栏
     */
    private void initBottomBar(Bundle savedInstanceState) {

        // Customize the colors here
        mBottomBar = BottomBar.attach(this, savedInstanceState,
                Color.parseColor("#FFFFFF"), // Background Color
                ContextCompat.getColor(this, R.color.colorAccent), // Tab Item Color
                0.25f); // Tab Item Alpha

        mBottomBar.setItems(R.menu.menu_bottombar);

        mBottomBar.setOnMenuTabClickListener(this);
        mBottomBar.setDefaultTabPosition(0);
    }

    /**
     * 初始化标题栏
     */
    private void initToolbar() {
//        mToolbar.setTitle("场景寻人");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mBottomBar.onSaveInstanceState(outState);
    }

    /**
     * 底部栏选择监听
     */
    @Override
    public void onMenuTabSelected(@IdRes int menuItemId) {

        BaseFragment fragment = BottomFragmentNavigator.navigate(menuItemId);


        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fl_fragment_container, fragment);
        transaction.commit();
    }

    /**
     * 底部栏重选监听
     */
    @Override
    public void onMenuTabReSelected(@IdRes int menuItemId) {

    }


}
