package com.unique.app.presenter;

import com.unique.app.base.OnCompleteListener;
import com.unique.app.model.UserModel;
import com.unique.app.view.SignUpView;

/**
 * Project: CommnitiAPP <br/>
 * Package: com.unique.app.presenter <br/>
 * Description: <br/>
 * <hr/>
 *
 * @author Crainax <br/>
 * @version 1.0 <br/>
 * @since 2016/8/2 <br/>
 */
public class SignUpPresenter {

    private final SignUpView mSignUpView;
    private final UserModel mUserModel;

    public SignUpPresenter(SignUpView view) {
        this.mSignUpView = view;
        mUserModel = new UserModel();
    }

    public void signup(String studentId, String school, String name) {

        mSignUpView.showProgress();

        mUserModel.register(school, studentId, name, new OnCompleteListener() {
            @Override
            public void onComplete(Throwable e) {

                mSignUpView.hideProgress();
                if (e == null) {
                    //成功注册
                    mSignUpView.showRegisterSuccessMsg("成功注册!");
                    mSignUpView.goToLoginActivity();
                } else {
                    //注册失败
                    mSignUpView.showFailMsg("注册失败!");
                }

            }
        });

    }
}
