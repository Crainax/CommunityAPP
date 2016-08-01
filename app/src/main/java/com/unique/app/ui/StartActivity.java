package com.unique.app.ui;

import android.content.Context;
import android.content.Intent;
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
        finish();
    }

    @OnClick(R.id.click_goto_sign_in)
    void showRegisterDialog(View view) {
        SignUpActivity.start(this);
        finish();
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, StartActivity.class);
        context.startActivity(starter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        ButterKnife.bind(this);
    }

}
