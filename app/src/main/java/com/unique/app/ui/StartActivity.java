package com.unique.app.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.unique.app.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class StartActivity extends AppCompatActivity {

    @OnClick(R.id.click_goto_login)
    void showLoginDialog(View view) {
        LoginActivity.start(this);
    }

    @OnClick(R.id.click_goto_sign_in)
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
