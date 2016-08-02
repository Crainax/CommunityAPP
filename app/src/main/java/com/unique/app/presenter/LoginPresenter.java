package com.unique.app.presenter;

import com.unique.app.base.OnCompleteListener;
import com.unique.app.model.UserModel;
import com.unique.app.view.LoginView;

/**
 * Project: CommnitiAPP <br/>
 * Package: com.unique.app.presenter <br/>
 * Description: <br/>
 * <hr/>
 *
 * @author Crainax <br/>
 * @version 1.0 <br/>
 * @since 2016/7/7 <br/>
 */
public class LoginPresenter {

    private LoginView mLoginView;
    private UserModel mUserModel;

    public LoginPresenter(LoginView mLoginView) {
        this.mLoginView = mLoginView;
        mUserModel = new UserModel();
    }

    public void login(String studentId, String password) {

        mLoginView.showProgress();

        mUserModel.login(studentId, password, new OnCompleteListener() {
            @Override
            public void onComplete(Throwable e) {

                mLoginView.hideProgress();
                if (e != null) {
                    //登录失败的逻辑
                    mLoginView.showFailMsg(e.getMessage());
                } else {
                    //登录成功的逻辑
                    mLoginView.goToMainActivity();
                }

            }
        });

    }


}
