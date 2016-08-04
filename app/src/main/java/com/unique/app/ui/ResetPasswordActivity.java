package com.unique.app.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.unique.app.R;
import com.unique.app.presenter.ResetPasswordPresenter;
import com.unique.app.ui.view.CenterToolbar;
import com.unique.app.view.ResetPasswordView;

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
 * @since 2016/8/3 <br/>
 */
public class ResetPasswordActivity extends BaseActivity implements ResetPasswordView
        , CenterToolbar.OnToolbarBackClickListener {

    @BindView(R.id.toolbar)
    CenterToolbar mToolbar;
    @BindView(R.id.et_reset_password)
    EditText etResetPassword;

    private ProgressDialog mProgressDialog;

    private ResetPasswordPresenter mResetPasswordPresenter;

    public static void start(Context context) {
        Intent starter = new Intent(context, ResetPasswordActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        ButterKnife.bind(this);
        mResetPasswordPresenter = new ResetPasswordPresenter(this);
        initToolbar();
    }

    private void initToolbar() {
        mToolbar.setTitle("重置密码");
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
        Toast.makeText(ResetPasswordActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showResetSucceedMsg(String message) {
        Toast.makeText(ResetPasswordActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void finish() {
        finish();
    }

    private void reset() {

        String password = etResetPassword.getText().toString();

        mResetPasswordPresenter.reset(password);

    }

    @Override
    public void onToolbarBackClick(View view) {
        onBackPressed();
    }

    @OnClick(R.id.click_find_password_validate)
    public void onClick() {
    }
}
