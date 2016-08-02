package com.unique.app.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.unique.app.R;
import com.unique.app.presenter.SignUpPresenter;
import com.unique.app.ui.view.CenterToolbar;
import com.unique.app.view.SignUpView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Project: CommnitiAPP <br/>
 * Package: com.unique.app.ui <br/>
 * Description: <br/>
 * <hr/>
 *
 * @author Crainax <br/>
 * @version 1.0 <br/>
 * @since 2016/8/1 <br/>
 */
public class SignUpActivity extends BaseActivity implements SignUpView
        , CenterToolbar.OnToolbarBackClickListener
        , CenterToolbar.OnToolbarActionClickListener {

    @BindView(R.id.toolbar)
    CenterToolbar mToolbar;
    @BindView(R.id.et_signup_school)
    EditText etSignupSchool;
    @BindView(R.id.et_signup_studentID)
    EditText etSignupStudentID;
    @BindView(R.id.et_signup_name)
    EditText etSignupName;

    private ProgressDialog mProgressDialog;

    private SignUpPresenter mSignUpPresenter;

    public static void start(Context context) {
        Intent starter = new Intent(context, SignUpActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);
        mSignUpPresenter = new SignUpPresenter(this);
        initToolbar();
    }

    private void initToolbar() {
        mToolbar.setTitle("注册");
        mToolbar.enableBackButton(true);
        mToolbar.enableActionButton(true, true);
        mToolbar.setAction("登陆");
        mToolbar.setOnToolbarBackClickListener(this);
        mToolbar.setOnToolbarActionClickListener(this);
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
    public void showFailMsg(String message) {
        Toast.makeText(SignUpActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showRegisterSuccessMsg(String message) {
        Toast.makeText(SignUpActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void goToLoginActivity() {
        LoginActivity.start(this);
        finish();
    }

    private void signUp() {
        String studentId = etSignupStudentID.getText().toString();
        String school = etSignupSchool.getText().toString();
        String name = etSignupName.getText().toString();

        mSignUpPresenter.signup(studentId, school, name);
    }

    @Override
    public void onToolbarBackClick(View view) {
        onBackPressed();
    }

    @Override
    public void onToolbarActionClick(View view) {
        goToLoginActivity();
    }

    @Override
    public void onBackPressed() {
        StartActivity.start(this);
        finish();
    }

    /**
     * 认证的按钮
     */
    @OnClick(R.id.click_signup_validate)
    public void onClick() {
        signUp();
    }
}
