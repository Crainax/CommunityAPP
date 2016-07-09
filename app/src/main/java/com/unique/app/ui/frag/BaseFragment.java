package com.unique.app.ui.frag;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.MenuRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.unique.app.ui.MainActivity;

/**
 * Project: CommnitiAPP <br/>
 * Package: com.unique.app.ui <br/>
 * Description: 所有BottomBar的Fragment有关的基类<br/>
 * <hr/>
 *
 * @author Crainax <br/>
 * @version 1.0 <br/>
 * @since 2016/7/8 <br/>
 */
public abstract class BaseFragment extends Fragment {

    protected MainActivity mActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = ((MainActivity) getActivity());
    }

    public abstract String title();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(resId(), container, false);


        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity.mToolbar.setTitle(title());
        if (menuId() > 0) {
            mActivity.mToolbar.inflateMenu(menuId());
        }
    }

    @LayoutRes
    protected abstract int resId();

    @MenuRes
    protected abstract int menuId();

}
