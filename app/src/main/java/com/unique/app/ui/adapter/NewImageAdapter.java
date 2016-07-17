package com.unique.app.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVFile;
import com.avos.avoscloud.GetDataCallback;
import com.bumptech.glide.Glide;
import com.unique.app.R;
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
public class NewImageAdapter extends RecyclerView.Adapter<NewImageAdapter.ViewHolder> {

    private List<AVFile> images;
    private int mImageMaxCount;

    private OnNewImageItemClickListener onNewImageItemClickListener;


    public interface OnNewImageItemClickListener {

        void onImageItemClick(View view, AVFile avFile);

        void onMoreClick(View view);

        void onImageItemLongClick(View view, AVFile avFile);
    }

    /**
     * OnNewImageItemClickListener的Setter
     */
    public void setOnNewImageItemClickListener(OnNewImageItemClickListener l) {
        this.onNewImageItemClickListener = l;
    }

    public NewImageAdapter(List<AVFile> files, int imageMaxCount) {
        this.images = files;
        this.mImageMaxCount = imageMaxCount;
    }

    public void addImage(AVFile avFile) {
        if (isFull()) {
            throw new FullImageRecyclerViewException("Image list is full!");
        }

        images.add(avFile);
        if (images.size() != mImageMaxCount)
            notifyItemInsertedEnd();
        else
            notifyDataSetChanged();

    }

    // TODO: 2016/7/17 改成其他样式
    public void removeImage(AVFile avFile) {
        int indexOf = images.indexOf(avFile);
        if (indexOf == -1) {
            throw new NoSuchElementException("删除失败!");
        }

        images.remove(avFile);

        if (images.size() != mImageMaxCount - 1)
            notifyItemRemoved(indexOf);
        else
            notifyDataSetChanged();
    }

    public boolean isFull() {
        return images.size() == mImageMaxCount;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //创建一个ImageView
        Context context = parent.getContext();
        ImageView iv = new ImageView(context);
        int dimension = (int) context.getResources().getDimension(R.dimen.new_image_dimen);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(dimension, dimension);
        iv.setLayoutParams(layoutParams);
        iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        iv.setCropToPadding(false);
        iv.setClickable(true);
        iv.setAdjustViewBounds(true);

        return new ViewHolder(iv);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final ImageView iv = holder.iv;

        if (position == images.size()) {
            if (position != mImageMaxCount)
                Glide.with(iv.getContext())
                        .load(R.drawable.ic_add_pic)
                        .dontAnimate()
                        .into(iv);
        } else {
            images.get(position).getDataInBackground(new GetDataCallback() {
                @Override
                public void done(byte[] bytes, AVException e) {
                    Glide.with(iv.getContext())
                            .load(bytes)
                            .dontAnimate()
                            .into(iv);
                }
            });
        }

        bindClickListener(holder.itemView, position);
    }


    /**
     * Bind the onclick listener to the view.
     *
     * @param itemView
     * @param position
     */
    private void bindClickListener(View itemView, final int position) {
        if (position == images.size()) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onNewImageItemClickListener != null)
                        onNewImageItemClickListener.onMoreClick(v);
                }
            });
        } else {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onNewImageItemClickListener != null) {
                        AVFile avFile = images.get(position);
                        onNewImageItemClickListener.onImageItemClick(v, avFile);
                    }
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (onNewImageItemClickListener != null) {
                        AVFile avFile = images.get(position);
                        onNewImageItemClickListener.onImageItemLongClick(v, avFile);
                    }
                    return true;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return Math.min(images.size() + 1, mImageMaxCount);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView iv;

        public ViewHolder(View imageView) {
            super(imageView);
            this.iv = (ImageView) imageView;
        }
    }

    public void notifyItemInsertedEnd() {
        notifyItemInserted(images.size() - 1);
    }

}
