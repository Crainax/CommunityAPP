package com.unique.app.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.unique.app.R;
import com.unique.app.entity.SceneFindSingleInfo;
import com.unique.app.entity.UserInfo;
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


    private List<SceneFindSingleInfo> datas;
    private OnSceneFindItemClickListener onSceneFindItemClickListener;

    public interface OnSceneFindItemClickListener {
        void onSceneFindItemClick(View view, SceneFindSingleInfo sceneFindSingleInfo);

        void onLikeClick(View view, SceneFindSingleInfo sceneFindSingleInfo);

        void onAvatarClick(View view, SceneFindSingleInfo sceneFindSingleInfo);

        void onUserNameClick(View view, SceneFindSingleInfo sceneFindSingleInfo);
    }

    /**
     * OnSceneFindItemClickListener的Setter
     */
    public void setOnSceneFindItemClickListener(OnSceneFindItemClickListener l) {
        this.onSceneFindItemClickListener = l;
    }

    public SceneFindAdapter(List<SceneFindSingleInfo> datas) {
        this.datas = datas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_scene_find, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        SceneFindSingleInfo sceneFindSingleInfo = datas.get(position);
        UserInfo userInfo = sceneFindSingleInfo.getEvaluateInfo().getUserInfo();

        holder.mTvTitle.setText(sceneFindSingleInfo.getTitle());
        holder.mTvDate.setText(DateUtils.formatDate(sceneFindSingleInfo.getDate(), DateUtils.FORMAT_YMD_2));
        holder.mTvUserName.setText(userInfo.getUserName());

        Glide.with(holder.itemView.getContext())
                .load(userInfo.getAvatarUrl())
                .placeholder(R.drawable.placeholder)
                .dontAnimate()
                .into(holder.mIvAvatar);

        // TODO: 2016/7/10 加入Tag的RecyclerView的代码

        bindClickListener(holder, sceneFindSingleInfo);
    }


    /**
     * Bind the onclick listener to the view.
     *
     * @param position
     */
    private void bindClickListener(ViewHolder holder, final SceneFindSingleInfo position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onSceneFindItemClickListener != null)
                    onSceneFindItemClickListener.onSceneFindItemClick(v, position);
            }
        });
        holder.mClickLove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onSceneFindItemClickListener != null)
                    onSceneFindItemClickListener.onLikeClick(v, position);
            }
        });
        holder.mClickUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onSceneFindItemClickListener != null)
                    onSceneFindItemClickListener.onUserNameClick(v, position);
            }
        });
        holder.mIvAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onSceneFindItemClickListener != null)
                    onSceneFindItemClickListener.onAvatarClick(v, position);

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
        @BindView(R.id.tv_scene_find_single_user_name)
        TextView mTvUserName;
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
