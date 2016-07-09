package com.unique.app.ui.frag;

import com.unique.app.R;

/**
 * Project: CommnitiAPP <br/>
 * Package: com.unique.app.util <br/>
 * Description: <br/>
 * <hr/>
 *
 * @author Crainax <br/>
 * @version 1.0 <br/>
 * @since 2016/7/8 <br/>
 */
public class MeFragment extends BaseFragment {
    @Override
    public String title() {
        return "我的资料";
    }

    @Override
    protected int resId() {
        return R.layout.frag_me;
    }

    @Override
    protected int menuId() {
        return 0;
    }

}
