package com.unique.app.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.unique.app.R;

import java.util.List;

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
public class TagAdapter extends RecyclerView.Adapter<TagAdapter.ViewHolder> {

    protected List<String> tags;

    protected int mMaxCount;

    protected OnTagClickListener onTagClickListener;

    public interface OnTagClickListener {

        void onTagItemClick(View view, String tag);

        void onTagItemLongClick(View v, String tag);
    }

    /**
     * OnTagClickListener的Setter
     */
    public void setOnTagClickListener(OnTagClickListener l) {
        this.onTagClickListener = l;
    }

    public TagAdapter(List<String> tags, int maxCount) {
        this.tags = tags;
        this.mMaxCount = maxCount;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tag, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final TextView tv = holder.tv;

        tv.setText(tags.get(position));

        bindClickListener(holder.itemView, position);
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
                if (onTagClickListener != null) {
                    String string = tags.get(position);
                    onTagClickListener.onTagItemClick(v, string);
                }
            }
        });
        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (onTagClickListener != null) {
                    String string = tags.get(position);
                    onTagClickListener.onTagItemLongClick(v, string);
                }
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return tags.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv;

        public ViewHolder(View textView) {
            super(textView);
            this.tv = (TextView) textView;
        }
    }

    public void notifyItemInsertedEnd() {
        notifyItemInserted(tags.size() - 1);
    }

}
