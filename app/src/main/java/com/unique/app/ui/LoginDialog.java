package com.unique.app.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;

import com.unique.app.R;

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
 * @since 2016/7/8 <br/>
 */
public class LoginDialog extends Dialog {

    @BindView(R.id.et_login_dialog_studentID)
    EditText etLoginID;
    @BindView(R.id.et_login_dialog_name)
    EditText etLoginName;

    private OnLoginListener onLoginListener;

    public interface OnLoginListener {
        void onLoginButtonClick(String studentID, String name);
    }

    @OnClick(R.id.bt_login_dialog_cancel)
    void cancel(View view) {
        this.dismiss();
    }

    @OnClick(R.id.bt_login_dialog_login)
    void login(View view) {
        if (onLoginListener != null) {
            String studentId = etLoginID.getText().toString();
            String name = etLoginName.getText().toString();
            onLoginListener.onLoginButtonClick(studentId, name);
        }
    }


    public LoginDialog(Context context, OnLoginListener onLoginListener) {
        super(context);
        this.onLoginListener = onLoginListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_login);
        ButterKnife.bind(this);
    }

}
