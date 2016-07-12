package com.unique.app.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.unique.app.R;
import com.unique.app.entity.UserInfo;

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
public class MyFollowAdapter extends RecyclerView.Adapter<MyFollowAdapter.ViewHolder> {

    private List<UserInfo> users;

    private OnMyFollowItemClickListener onMyFollowItemClickListener;

    public interface OnMyFollowItemClickListener {
        void onMyFollowUserNameClick(View view, UserInfo userInfo);

        void onMyFollowAvatarClick(View view, UserInfo userInfo);
    }

    public void setOnMyFollowItemClickListener(OnMyFollowItemClickListener l) {
        this.onMyFollowItemClickListener = l;
    }

    public MyFollowAdapter(List<UserInfo> users) {
        this.users = users;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_my_follow_user, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        UserInfo userInfo = users.get(position);

        holder.tvUserName.setText(userInfo.getUserName());

        Glide.with(holder.itemView.getContext())
                .load(userInfo.getAvatarUrl())
                .placeholder(R.drawable.placeholder)
                .into(holder.IvAvatar);

        bindClickListener(holder, position);
    }


    /**
     * Bind the onclick listener to the view.
     *
     * @param position
     */
    private void bindClickListener(ViewHolder holder, final int position) {
        holder.tvUserName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onMyFollowItemClickListener != null) {
                    onMyFollowItemClickListener.onMyFollowUserNameClick(v, users.get(position));
                }
            }
        });
        holder.IvAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onMyFollowItemClickListener != null) {
                    onMyFollowItemClickListener.onMyFollowAvatarClick(v, users.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_item_my_follow_user_name)
        TextView tvUserName;
        @BindView(R.id.iv_my_follow_user_avatar)
        ImageView IvAvatar;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
