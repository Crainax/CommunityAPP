package com.unique.app.presenter;

import com.unique.app.base.OnCompleteListener;
import com.unique.app.model.UserModel;
import com.unique.app.view.FindPasswordView;

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
public class FindPasswordPresenter {

    private final FindPasswordView mFindPasswordView;
    private final UserModel mUserModel;
    public FindPasswordPresenter(FindPasswordView findPasswordView) {
        this.mFindPasswordView = findPasswordView;
        mUserModel = new UserModel();
    }

    public void validate(String studentId, String phone) {
        mFindPasswordView.showProgress();

        mUserModel.validate(studentId, phone, new OnCompleteListener() {
            @Override
            public void onComplete(Throwable e) {

                mFindPasswordView.hideProgress();
                if (e == null) {
                    //成功注册
                    mFindPasswordView.showRegisterSuccessMsg("验证成功!");
                    mFindPasswordView.goToNextActivity();
                } else {
                    //注册失败
                    mFindPasswordView.showFailMsg("验证失败!");
                }

            }
        });
    }
}
