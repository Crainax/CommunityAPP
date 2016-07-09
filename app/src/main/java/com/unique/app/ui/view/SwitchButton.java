package com.unique.app.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
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
 * @since 2016/7/9 <br/>
 */
public class SwitchButton extends View implements View.OnClickListener {

    private TextView mLeftTextView;
    private TextView mRightTextView;
    private OnSwitchButtonClickListener onSwitchButtonClickListener;

    /**
     * 当前指示状态
     */
    private boolean mIsLeftState = true;

    public void setOnSwitchButtonClickListener(OnSwitchButtonClickListener onSwitchButtonClickListener) {
        this.onSwitchButtonClickListener = onSwitchButtonClickListener;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_switchbutton_left:
                //点击左边事件
                mIsLeftState = true;
                if (onSwitchButtonClickListener != null) {
                    onSwitchButtonClickListener.onLeftButtonClick();
                }
                synColor();
                break;
            case R.id.tv_switchbutton_right:
                //点击右边事件
                mIsLeftState = false;
                if (onSwitchButtonClickListener != null) {
                    onSwitchButtonClickListener.onRightButtonClick();
                }
                synColor();
                break;
        }
    }

    private void synColor() {

        if (mIsLeftState) {
            mLeftTextView.setBackgroundResource(R.drawable.shape_tv_switch_norma_left_focus);
            mRightTextView.setBackgroundResource(R.drawable.shape_tv_switch_normal_right);
        } else {
            mLeftTextView.setBackgroundResource(R.drawable.shape_tv_switch_norma_left);
            mRightTextView.setBackgroundResource(R.drawable.shape_tv_switch_normal_right_focus);
        }

    }

    public interface OnSwitchButtonClickListener {

        void onLeftButtonClick();

        void onRightButtonClick();

    }

    public SwitchButton(Context context) {
        this(context, null);
    }


    public SwitchButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }


    public SwitchButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {

        View rootView = inflate(context, R.layout.view_switch_button, null);

        mLeftTextView = ((TextView) rootView.findViewById(R.id.tv_switchbutton_left));
        mRightTextView = ((TextView) rootView.findViewById(R.id.tv_switchbutton_right));
        mLeftTextView.setOnClickListener(this);
        mRightTextView.setOnClickListener(this);

    }

    public void setState(boolean isLeft) {

        if (isLeft)
            mLeftTextView.callOnClick();
        else
            mRightTextView.callOnClick();

    }

}


