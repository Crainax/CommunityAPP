package com.unique.app.ui;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.unique.app.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity  {

    @BindView(R.id.toolbar)
    public Toolbar mToolbar;

//    private BottomBar mBottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //初始化选择
        initToolbar();
    }

    /**
     * 初始化标题栏
     */
    private void initToolbar() {
        mToolbar.setTitle("场景寻人");
    }

}
