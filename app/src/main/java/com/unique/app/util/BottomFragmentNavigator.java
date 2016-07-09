package com.unique.app.util;

import com.unique.app.R;
import com.unique.app.ui.frag.BaseFragment;
import com.unique.app.ui.frag.AccurateFindFragment;
import com.unique.app.ui.frag.MeFragment;
import com.unique.app.ui.frag.OrganizationFragment;
import com.unique.app.ui.frag.SceneFindFragment;

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
public class BottomFragmentNavigator {

    /**
     * 由底部菜单ID生成相对应的Fragment.
     * @param menuItemId 需要转换的底部菜单ID
     * @return 对应的Fragment.
     */
    public static BaseFragment navigate(int menuItemId) {
        switch (menuItemId) {
            case R.id.bb_menu_scene_find:
                return new SceneFindFragment();
            case R.id.bb_menu_accurate_find:
                return new AccurateFindFragment();
            case R.id.bb_menu_organization:
                return new OrganizationFragment();
            case R.id.bb_menu_me:
                return new MeFragment();
        }
        throw new IllegalArgumentException("参数Id出错,不是底部菜单的ID:" + menuItemId + ".");
    }

}
