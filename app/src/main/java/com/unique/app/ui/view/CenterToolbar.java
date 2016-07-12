package com.unique.app.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.StringRes;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.unique.app.R;

/**
 * Project: CommnitiAPP <br/>
 * Package: com.unique.app.ui.view <br/>
 * Description: 标题在中部的Toolbar<br/>
 * <hr/>
 *
 * @author Crainax <br/>
 * @version 1.0 <br/>
 * @since 2016/7/9 <br/>
 */
public class CenterToolbar extends Toolbar {

    private TextView mTvTitle;

    public CenterToolbar(Context context) {
        this(context, null);
    }

    public CenterToolbar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CenterToolbar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CenterToolbar,
                         defStyle, 0);

        String titleStr = null;
        //遍历属性
        for (int i = 0; i < a.getIndexCount(); i++) {
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.CenterToolbar_titleText:
                    titleStr = a.getString(attr);
                    break;
            }
        }

        View rootView = LayoutInflater.from(context)
                .inflate(R.layout.view_center_toolbar_textview, this, true);

        mTvTitle = ((TextView) rootView.findViewById(R.id.tv_toolbar_title_no_code));
        setTitle(titleStr);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTvTitle.setText(title);
    }

    @Override
    public void setTitle(@StringRes int resId) {
        setTitle(getContext().getString(resId));
    }
}
