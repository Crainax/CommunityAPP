package com.unique.app.view;

/**
 * Project: CommnitiAPP <br/>
 * Package: com.unique.app.view <br/>
 * Description: <br/>
 * <hr/>
 *
 * @author Crainax <br/>
 * @version 1.0 <br/>
 * @since 2016/8/2 <br/>
 */
public interface SignUpView {

    void showProgress();

    void hideProgress();

    void showFailMsg(String message);

    void showRegisterSuccessMsg(String message);

    void goToLoginActivity();

}
