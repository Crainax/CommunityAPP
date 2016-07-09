package com.unique.app.ui;

import android.app.Application;

import com.orhanobut.logger.Logger;

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
public class APP extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.init("Crainax");
    }
}
