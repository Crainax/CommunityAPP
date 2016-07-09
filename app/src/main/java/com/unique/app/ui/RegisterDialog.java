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
public class RegisterDialog extends Dialog {

    @BindView(R.id.et_register_dialog_school)
    EditText mEtRegisterDialogSchool;
    @BindView(R.id.et_register_dialog_studentID)
    EditText mEtRegisterDialogStudentID;
    @BindView(R.id.et_register_dialog_name)
    EditText mEtRegisterDialogName;
    @BindView(R.id.et_register_dialog_nickname)
    EditText mEtRegisterDialogNickname;
    private OnRegisterListener mOnRegisterListener;

    public interface OnRegisterListener {
        void onRegister(String school, String studentID, String name, String nickname);
    }

    @OnClick(R.id.bt_login_dialog_cancel)
    void cancel(View view) {
        this.dismiss();
    }

    @OnClick(R.id.bt_login_dialog_login)
    void login(View view) {
        if (mOnRegisterListener != null) {
            String name = mEtRegisterDialogName.getText().toString();
            String nickname = mEtRegisterDialogNickname.getText().toString();
            String school = mEtRegisterDialogSchool.getText().toString();
            String studentId = mEtRegisterDialogStudentID.getText().toString();
            mOnRegisterListener.onRegister(school, studentId, name, nickname);
        }
    }


    public RegisterDialog(Context context, RegisterDialog.OnRegisterListener onRegisterListener) {
        super(context);
        this.mOnRegisterListener = onRegisterListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_register);
        ButterKnife.bind(this);
    }

}
