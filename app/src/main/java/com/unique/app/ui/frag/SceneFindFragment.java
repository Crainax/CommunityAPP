package com.unique.app.ui.frag;

import com.unique.app.R;

/**
 * Project: CommnitiAPP <br/>
 * Package: com.unique.app.ui.frag <br/>
 * Description: <br/>
 * <hr/>
 *
 * @author Crainax <br/>
 * @version 1.0 <br/>
 * @since 2016/7/8 <br/>
 */
public class SceneFindFragment extends BaseFragment {

    @Override
    public String title() {
        return "场景寻人";
    }

    @Override
    protected int resId() {
        return R.layout.frag_scene_find;
    }

    @Override
    protected int menuId() {
        return R.menu.menu_toolbar_scene;
    }

}
