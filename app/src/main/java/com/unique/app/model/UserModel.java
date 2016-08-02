package com.unique.app.model;

import com.unique.app.base.OnCompleteListener;

/**
 * Project: CommnitiAPP <br/>
 * Package: com.unique.app.model <br/>
 * Description: <br/>
 * <hr/>
 *
 * @author Crainax <br/>
 * @version 1.0 <br/>
 * @since 2016/7/7 <br/>
 */
public class UserModel {



    public void login(String userName, String password, OnCompleteListener onCompleteListener) {

        if (onCompleteListener != null) {
            onCompleteListener.onComplete(null);
        }

    }

    public void register(String school, String studentID, String name,  OnCompleteListener onCompleteListener) {
        if (onCompleteListener != null) {
            onCompleteListener.onComplete(null);
        }
    }
}
