package com.unique.app.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.unique.app.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StartActivity extends AppCompatActivity {

    @BindView(R.id.bt_showLoginDialog)
    Button mBtLogin;
    @BindView(R.id.bt_showRegisterDialog)
    Button mBtRegister;

    @OnClick(R.id.bt_showLoginDialog)
    void showLoginDialog(View view) {
        LoginActivity.start(this);
    }

    @OnClick(R.id.bt_showRegisterDialog)
    void showRegisterDialog(View view) {
        SignUpActivity.start(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        ButterKnife.bind(this);
    }

}
