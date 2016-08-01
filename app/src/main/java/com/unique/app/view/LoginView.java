package com.unique.app.view;

/**
 * Project: CommnitiAPP <br/>
 * Package: com.unique.app.presenter <br/>
 * Description: The base MVP View of Login Logic.<br/>
 * <hr/>
 *
 * @author Crainax <br/>
 * @version 1.0 <br/>
 * @since 2016/7/7 <br/>
 */
public interface LoginView {
    void showProgress();

    void hideProgress();

    void goToMainActivity();

    void showFailMsg(String message);

    void showRegisterSuccessMsg(String message);

}
