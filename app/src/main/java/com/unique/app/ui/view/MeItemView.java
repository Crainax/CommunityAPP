package com.unique.app.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.unique.app.R;

/**
 * Project: CommnitiAPP <br/>
 * Package: com.unique.app.ui.view <br/>
 * Description: <br/>
 * <hr/>
 *
 * @author Crainax <br/>
 * @version 1.0 <br/>
 * @since 2016/7/10 <br/>
 */
public class MeItemView extends FrameLayout {

    public MeItemView(Context context) {
        this(context, null);
    }

    public MeItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MeItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray a =
                context.getTheme().obtainStyledAttributes(attrs, R.styleable.MeItemView
                        , defStyleAttr, 0);

        int n = a.getIndexCount();

        String title = null;
        Drawable icon = null;
        for (int i = 0; i < n; i++) {
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.MeItemView_titleText:
                    title = a.getString(attr);
                    break;
                case R.styleable.MeItemView_iconDrawable:
                    icon = a.getDrawable(attr);
                    break;
            }
        }

        // TODO: 2016/7/10 完成继承控件,见github自定义View中
        LayoutInflater.from(context).inflate(R.layout.view_me_item, this, true);

        if (title != null) {
            TextView textView = (TextView) findViewById(R.id.tv_view_me_title_no_code);
            textView.setText(title);
        }

        if (icon != null) {
            ImageView imageView = (ImageView) findViewById(R.id.iv_view_me_icon_no_code);
            imageView.setImageDrawable(icon);
        }

    }

}
