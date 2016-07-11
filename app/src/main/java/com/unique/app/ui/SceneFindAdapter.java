package com.unique.app.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.unique.app.R;
import com.unique.app.entity.SceneFindInfo;
import com.unique.app.util.DateUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Project: CommnitiAPP <br/>
 * Package: com.unique.app.ui <br/>
 * Description: <br/>
 * <hr/>
 *
 * @author Crainax <br/>
 * @version 1.0 <br/>
 * @since 2016/7/9 <br/>
 */
public class SceneFindAdapter extends RecyclerView.Adapter<SceneFindAdapter.ViewHolder> {


    private List<SceneFindInfo> datas;
    private OnSceneFindViewClickListener onSceneFindViewClickListener;
    private OnSceneFindViewLikeClickListener onSceneFindViewLikeClickListener;
    private OnSceneFindViewUserClickListener onSceneFindViewUserClickListener;

    public interface OnSceneFindViewClickListener {
        void onSceneFindViewClick(View view, int position);
    }

    public interface OnSceneFindViewLikeClickListener {
        void onSceneFindViewLikeClick(View view);
    }

    public interface OnSceneFindViewUserClickListener {
        void onSceneFindViewUserClick(View view);
    }

    public SceneFindAdapter(List<SceneFindInfo> datas) {
        this.datas = datas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_scene_find, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        SceneFindInfo sceneFindInfo = datas.get(position);

        holder.mTvTitle.setText(sceneFindInfo.getTitle());
        holder.mTvDate.setText(DateUtils.formatDate(sceneFindInfo.getDate(), DateUtils.FORMAT_YMD_2));
        // TODO: 2016/7/10 加入头像图片与Tag的RecyclerView的代码

        bindClickListener(holder, position);
    }


    /**
     * Bind the onclick listener to the view.
     *
     * @param position
     */
    private void bindClickListener(ViewHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onSceneFindViewClickListener != null)
                    onSceneFindViewClickListener.onSceneFindViewClick(v, position);
            }
        });
        holder.mClickLove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onSceneFindViewLikeClickListener != null)
                    onSceneFindViewLikeClickListener.onSceneFindViewLikeClick(v);
            }
        });
        holder.mClickUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onSceneFindViewUserClickListener != null)
                    onSceneFindViewUserClickListener.onSceneFindViewUserClick(v);
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_scene_find_single_title)
        TextView mTvTitle;
        @BindView(R.id.tv_scene_find_single_date)
        TextView mTvDate;
        @BindView(R.id.iv_scene_find_single_user_avatar)
        ImageView mIvAvatar;
        @BindView(R.id.rv_item_scene_find_single_tag)
        RecyclerView mRvTag;
        @BindView(R.id.click_scene_find_single_love)
        View mClickLove;
        @BindView(R.id.click_scene_find_single_user)
        View mClickUser;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
