package com.unique.app.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.unique.app.R;
import com.unique.app.entity.SceneFindMultiInfo;
import com.unique.app.util.DateUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Project: CommnitiAPP <br/>
 * Package: com.unique.app.ui.adapter <br/>
 * Description: <br/>
 * <hr/>
 *
 * @author Crainax <br/>
 * @version 1.0 <br/>
 * @since 2016/7/14 <br/>
 */
public class SceneFindMultiAdapter extends RecyclerView.Adapter<SceneFindMultiAdapter.ViewHolder> {

    private List<SceneFindMultiInfo> datas;

    private OnSceneFindItemClickListener onSceneFindItemClickListener;

    public interface OnSceneFindItemClickListener {
        void onSceneFindItemClick(View view, SceneFindMultiInfo sceneFindMultiInfo);

        void onLikeClick(View view, SceneFindMultiInfo sceneFindMultiInfo);

        void onPeopleCountClick(View view, SceneFindMultiInfo sceneFindMultiInfo);
    }

    /**
     * OnSceneFindItemClickListener的Setter
     */
    public void setOnSceneFindItemClickListener(OnSceneFindItemClickListener l) {
        this.onSceneFindItemClickListener = l;
    }

    public SceneFindMultiAdapter(List<SceneFindMultiInfo> datas) {
        this.datas = datas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_scene_find_multi, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        SceneFindMultiInfo sceneFindMultiInfo = datas.get(position);

        holder.mTvTitle.setText(sceneFindMultiInfo.getTitle());
        holder.mTvDate.setText(DateUtils.formatDate(sceneFindMultiInfo.getDate(), DateUtils.FORMAT_YMD_2));

        String countStr = holder.itemView.getResources().getString(R.string.scene_find_multi_count
                , sceneFindMultiInfo.getCurrentPeopleCount() + ""
                , sceneFindMultiInfo.getTotalPeopleCount() + "");

        holder.mTvPeopleCount.setText(countStr);

        // TODO: 2016/7/10 加入Tag的RecyclerView的代码

        bindClickListener(holder, sceneFindMultiInfo);
    }


    /**
     * Bind the onclick listener to the view.
        *
        * @param position
                */
        private void bindClickListener(ViewHolder holder, final SceneFindMultiInfo position) {
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
                        onSceneFindItemClickListener.onLikeClick(v,position);
                }
            });
            holder.mTvPeopleCount.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onSceneFindItemClickListener != null)
                        onSceneFindItemClickListener.onPeopleCountClick(v, position);

                }
            });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_scene_find_multi_title)
        TextView mTvTitle;
        @BindView(R.id.tv_scene_find_multi_date)
        TextView mTvDate;
        @BindView(R.id.tv_scene_find_multi_count)
        TextView mTvPeopleCount;
        @BindView(R.id.rv_item_scene_find_multi_tag)
        RecyclerView mRvTag;
        @BindView(R.id.click_scene_find_multi_love)
        View mClickLove;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
