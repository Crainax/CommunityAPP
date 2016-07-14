package com.unique.app.ui.frag;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
public class MultiSceneFindFragment extends Fragment {

    private RecyclerView mRvData;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

//        mRvData = new RecyclerView(container.getContext());
        TextView textView = new TextView(container.getContext());
        textView.setText("xixixixixiix");

        int spacingInPixel = getResources().getDimensionPixelSize(R.dimen.padding_5dp);
        textView.setPadding(0, spacingInPixel, 0, spacingInPixel);

        return textView;
    }


}
