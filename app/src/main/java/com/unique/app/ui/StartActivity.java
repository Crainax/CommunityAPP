package com.unique.app.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.unique.app.R;
import com.unique.app.presenter.LoginPresenter;
import com.unique.app.view.LoginView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StartActivity extends AppCompatActivity implements LoginView
        , LoginDialog.OnLoginListener, RegisterDialog.OnRegisterListener {

    @BindView(R.id.bt_showLoginDialog)
    Button mBtLogin;
    @BindView(R.id.bt_showRegisterDialog)
    Button mBtRegister;
    private ProgressDialog mProgressDialog;
    private RegisterDialog mRegisterDialog;
    private LoginDialog mLoginDialog;

    @OnClick(R.id.bt_showLoginDialog)
    void showLoginDialog(View view) {
        LoginActivity.start(this);
    }

    @OnClick(R.id.bt_showRegisterDialog)
    void showRegisterDialog(View view) {
        SignUpActivity.start(this);
    }

    private LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mLoginPresenter = new LoginPresenter(this);

    }

    @Override
    public void showProgress() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
        }
        mProgressDialog.show();
    }

    @Override
    public void hideProgress() {
        mProgressDialog.dismiss();
    }

    @Override
    public void goToMainActivity() {
        Intent intent = new Intent(this, SceneFindActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void showFailMsg(String message) {
        Toast.makeText(StartActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showRegisterSuccessMsg(String message) {
        Toast.makeText(StartActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void closeAllDialog() {
        if (mLoginDialog != null)
            if (mLoginDialog.isShowing())
                mLoginDialog.dismiss();
        if (mRegisterDialog != null)
            if (mRegisterDialog.isShowing())
                mRegisterDialog.dismiss();
    }

    @Override
    public void onLoginButtonClick(String studentID, String name) {
        mLoginPresenter.login(studentID, name);
    }

    @Override
    public void onRegister(String school, String studentID, String name, String nickname) {
        mLoginPresenter.register(school, studentID, name, nickname);

    }
}
