package com.unique.app.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.unique.app.R;
import com.unique.app.entity.EvaluateInfo;

import java.util.ArrayList;
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
public class EvaluateAdapter extends RecyclerView.Adapter<EvaluateAdapter.ViewHolder> {

    private List<EvaluateInfo> datas;

    private OnEvaluateItemClickListener onEvaluateItemClickListener;

    public interface OnEvaluateItemClickListener {
        void onItemClick(View view, EvaluateInfo data);

        void onAvatarItemClick(View view, EvaluateInfo data);

        void onUserNameItemClick(View view, EvaluateInfo data);

        void onRatingBarItemChange(RatingBar ratingBar, float rating, boolean fromUser, EvaluateInfo data);

    }

    /**
     * OnEvaluateItemClickListener的Setter
     */
    public void setOnEvaluateItemClickListener(OnEvaluateItemClickListener l) {
        this.onEvaluateItemClickListener = l;
    }

    public EvaluateAdapter(List<EvaluateInfo> datas) {
        this.datas = datas;
    }

    public EvaluateAdapter(EvaluateInfo data) {
        this.datas = new ArrayList<>();
        this.datas.add(data);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_evaluate, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        final EvaluateInfo data = datas.get(position);

        holder.tvUserName.setText(data.getUserInfo().getUserName());

        Glide.with(holder.itemView.getContext())
                .load(data.getUserInfo().getAvatarUrl())
                .placeholder(R.drawable.placeholder)
                .dontAnimate()
                .into(holder.IvAvatar);

        System.out.println(data.isEvaluate());

        if (data.isEvaluate()) {
            holder.rbEvaluate.setIsIndicator(true);
            holder.rbEvaluate.setRating(data.getRating());
        } else {
            holder.rbEvaluate.setIsIndicator(false);
            holder.rbEvaluate.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                @Override
                public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                    onEvaluateItemClickListener.onRatingBarItemChange(ratingBar, rating, fromUser, data);
                }
            });
        }

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
                if (onEvaluateItemClickListener != null) {
                    onEvaluateItemClickListener.onUserNameItemClick(v, datas.get(position));
                }
            }
        });
        holder.IvAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onEvaluateItemClickListener != null) {
                    onEvaluateItemClickListener.onAvatarItemClick(v, datas.get(position));
                }
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onEvaluateItemClickListener != null) {
                    onEvaluateItemClickListener.onItemClick(v, datas.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_evaluate_user_name)
        TextView tvUserName;
        @BindView(R.id.iv_evaluate_user_avatar)
        ImageView IvAvatar;
        @BindView(R.id.rb_evaluate)
        RatingBar rbEvaluate;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
