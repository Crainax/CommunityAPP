package com.unique.app.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

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
public class NewSceneItemView extends FrameLayout {

    private EditText mEtTitle;

    public NewSceneItemView(Context context) {
        this(context, null);
    }

    public NewSceneItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NewSceneItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray a =
                context.getTheme().obtainStyledAttributes(attrs, R.styleable.NewSceneItemView
                        , defStyleAttr, 0);

        int n = a.getIndexCount();

        String title = null;
        Drawable icon = null;
        for (int i = 0; i < n; i++) {
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.NewSceneItemView_titleText:
                    title = a.getString(attr);
                    break;
                case R.styleable.NewSceneItemView_iconDrawable:
                    icon = a.getDrawable(attr);
                    break;
            }
        }

        // TODO: 2016/7/10 完成继承控件,见github自定义View中
        LayoutInflater.from(context).inflate(R.layout.view_new_scene_et_item, this, true);

        if (title != null) {
            mEtTitle = (EditText) findViewById(R.id.et_item_new_scene_title_title_no_code);
            mEtTitle.setHint(title);
        }

        if (icon != null) {
            ImageView imageView = (ImageView) findViewById(R.id.iv_view_new_scene_icon_no_code);
            imageView.setImageDrawable(icon);
        }

    }


    public String getText() {
        return mEtTitle.getText().toString();
    }

}
