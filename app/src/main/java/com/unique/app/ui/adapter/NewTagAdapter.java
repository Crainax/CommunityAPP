package com.unique.app.ui.adapter;

import android.view.View;
import android.widget.TextView;

import com.unique.app.base.exception.FullImageRecyclerViewException;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Project: CommnitiAPP <br/>
 * Package: com.unique.app.ui.adapter <br/>
 * Description: <br/>
 * <hr/>
 *
 * @author Crainax <br/>
 * @version 1.0 <br/>
 * @since 2016/7/16 <br/>
 */
public class NewTagAdapter extends TagAdapter {

    private OnNewTagClickListener onNewTagClickListener;

    public interface OnNewTagClickListener extends TagAdapter.OnTagClickListener {
        void onNewTagClick(View view);
    }

    /**
     * OnNewTagClickListener的Setter
     */
    public void setOnNewTagClickListener(OnNewTagClickListener l) {
        this.onNewTagClickListener = l;
        super.setOnTagClickListener(l);
    }

    public NewTagAdapter(List<String> tags, int maxCount) {
        super(tags, maxCount);
    }

    public void addTag(String string) {
        if (isFull()) {
            throw new FullImageRecyclerViewException("Image list is full!");
        }

        tags.add(string);
        if (tags.size() != mMaxCount)
            notifyItemInsertedEnd();
        else
            notifyDataSetChanged();

    }

    // TODO: 2016/7/17 改成其他样式
    public void removeTag(String string) {
        int indexOf = tags.indexOf(string);
        if (indexOf == -1) {
            throw new NoSuchElementException("删除失败!");
        }

        tags.remove(string);

        if (tags.size() != mMaxCount - 1)
            notifyItemRemoved(indexOf);
        else
            notifyDataSetChanged();
    }

    public boolean isFull() {
        return tags.size() == mMaxCount;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final TextView tv = holder.tv;

        if (position == tags.size()) {
            if (position != mMaxCount) {
                //如果还有位置,则放添加的标签小按钮
                tv.setText("点击添加新标签");
                bindClickListener(holder.itemView, position);
            }
        } else {
            super.onBindViewHolder(holder, position);
        }

    }


    /**
     * Bind the onclick listener to the view.
     *
     * @param itemView
     * @param position
     */
    private void bindClickListener(View itemView, final int position) {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onNewTagClickListener != null)
                    onNewTagClickListener.onNewTagClick(v);
            }
        });
    }

    @Override
    public int getItemCount() {
        return Math.min(tags.size() + 1, mMaxCount);
    }

    public void notifyItemInsertedEnd() {
        notifyItemInserted(tags.size() - 1);
    }

}
