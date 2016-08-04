package com.unique.app.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.unique.app.R;
import com.unique.app.presenter.FindPasswordPresenter;
import com.unique.app.ui.view.CenterToolbar;
import com.unique.app.view.FindPasswordView;

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
public class FindPasswordActivity extends BaseActivity implements FindPasswordView
        , CenterToolbar.OnToolbarBackClickListener {

    @BindView(R.id.toolbar)
    CenterToolbar mToolbar;
    @BindView(R.id.et_find_password_studentID)
    EditText etFindPasswordStudentID;
    @BindView(R.id.et_find_password_phone)
    EditText etFindPasswordPhone;

    private ProgressDialog mProgressDialog;

    private FindPasswordPresenter mFindPasswordPresenter;

    public static void start(Context context) {
        Intent starter = new Intent(context, FindPasswordActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_password);
        ButterKnife.bind(this);
        mFindPasswordPresenter = new FindPasswordPresenter(this);
        initToolbar();
    }

    private void initToolbar() {
        mToolbar.setTitle("找回密码");
        mToolbar.enableBackButton(true);
        mToolbar.enableActionButton(false, true);
        mToolbar.setOnToolbarBackClickListener(this);
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
        Toast.makeText(FindPasswordActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showValidateSucceedMsg(String message) {
        Toast.makeText(FindPasswordActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void goToNextActivity() {
        ResetPasswordActivity.start(this);
        finish();
    }

    private void validate() {

        String studentId = etFindPasswordStudentID.getText().toString();
        String phone = etFindPasswordPhone.getText().toString();

        mFindPasswordPresenter.validate(studentId, phone);

    }

    @Override
    public void onToolbarBackClick(View view) {
        onBackPressed();
    }

    /**
     * 认证的按钮
     */
    @OnClick(R.id.click_find_password_validate)
    public void onClick() {
        validate();
    }

}
