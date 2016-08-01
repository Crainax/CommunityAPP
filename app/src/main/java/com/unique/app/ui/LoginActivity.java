package com.unique.app.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.unique.app.R;
import com.unique.app.presenter.LoginPresenter;
import com.unique.app.view.LoginView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginView {

    @BindView(R.id.et_login_studentID)
    EditText etLoginStudentID;
    @BindView(R.id.et_login_password)
    EditText etLoginPassword;

    private ProgressDialog mProgressDialog;
    private LoginPresenter mLoginPresenter;
    private boolean mProcessing;

    @OnClick({R.id.click_login_for, R.id.click_login_login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.click_login_for:
                forgetPassword();
                break;
            case R.id.click_login_login:
                login();
                break;
        }
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, LoginActivity.class);
        context.startActivity(starter);
    }

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
        Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showRegisterSuccessMsg(String message) {
        Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    private void forgetPassword() {
        FindPasswordActivity.start(this);
    }

    private void login() {
        String studentId = etLoginStudentID.getText().toString();
        String password = etLoginPassword.getText().toString();
        mLoginPresenter.login(studentId, password);
    }

}
