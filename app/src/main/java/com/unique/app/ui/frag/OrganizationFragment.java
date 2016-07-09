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
public class OrganizationFragment extends BaseFragment {
    @Override
    public String title() {
        return "寻找组织";
    }

    @Override
    protected int resId() {
        return R.layout.frag_organization;
    }

    @Override
    protected int menuId() {
        return R.menu.menu_toolbar_org;
    }


}
