package com.unique.app.presenter;

import com.unique.app.base.OnCompleteListener;
import com.unique.app.model.UserModel;
import com.unique.app.view.ResetPasswordView;

/**
 * Project: CommnitiAPP <br/>
 * Package: com.unique.app.presenter <br/>
 * Description: <br/>
 * <hr/>
 *
 * @author Crainax <br/>
 * @version 1.0 <br/>
 * @since 2016/8/3 <br/>
 */
public class ResetPasswordPresenter {

    private final ResetPasswordView mResetPasswordView;
    private final UserModel mUserModel;

    public ResetPasswordPresenter(ResetPasswordView mResetPasswordView) {
        this.mResetPasswordView = mResetPasswordView;
        mUserModel = new UserModel();
    }

    public void reset(String password) {

        mResetPasswordView.hideProgress();

        mUserModel.reset(password, new OnCompleteListener() {
            @Override
            public void onComplete(Throwable e) {
                if (e == null) {
                    //成功重设
                    mResetPasswordView.showResetSucceedMsg("验证成功!");
                    mResetPasswordView.finish();
                } else {
                    //重设失败
                    mResetPasswordView.showFailMsg("验证失败!");
                }
            }
        });
    }


}

