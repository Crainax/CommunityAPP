package com.unique.app.ui;

import android.content.Context;
import android.content.Intent;

/**
 * Project: CommnitiAPP <br/>
 * Package: com.unique.app.ui <br/>
 * Description: <br/>
 * <hr/>
 *
 * @author Crainax <br/>
 * @version 1.0 <br/>
 * @since 2016/8/1 <br/>
 */
public class FindPasswordActivity extends BaseActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, FindPasswordActivity.class);
        context.startActivity(starter);
    }

}
