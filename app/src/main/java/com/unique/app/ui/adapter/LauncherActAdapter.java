package com.unique.app.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.unique.app.R;
import com.unique.app.entity.SceneFindInfo;
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
 * @since 2016/7/12 <br/>
 */
public class LauncherActAdapter extends RecyclerView.Adapter<LauncherActAdapter.ViewHolder> {

    private List<SceneFindInfo> datas;

    private OnLauncherActItemClickListener onLauncherActItemClickListener;

    public interface OnLauncherActItemClickListener {
        void onLauncherActItemClick(View view, SceneFindInfo sceneFindInfo);

        void onEvaluateButtonClick(View view, SceneFindInfo sceneFindInfo);
    }

    /**
     * LauncherActItemClickListener的Setter
     */
    public void setLauncherActItemClickListener(OnLauncherActItemClickListener l) {
        this.onLauncherActItemClickListener = l;
    }

    public LauncherActAdapter(List<SceneFindInfo> datas) {
        this.datas = datas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_launcher_act, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        SceneFindInfo sceneFindInfo = datas.get(position);

        holder.mTvTitle.setText(sceneFindInfo.getTitle());
        holder.mTvDate.setText(DateUtils.formatDate(sceneFindInfo.getDate(), DateUtils.FORMAT_YMD_2));

        if (sceneFindInfo.getEvaluateInfo().isEvaluate()) {
            holder.mTvClickEvaluate.setText("已评价");
        } else {
            holder.mTvClickEvaluate.setText("未评价");
        }

        // TODO: 2016/7/12 加入Tag的RecyclerView代码

        bindClickListener(holder, sceneFindInfo);
    }


    /**
     * Bind the onclick listener to the view.
     *
     * @param position
     */
    private void bindClickListener(ViewHolder holder, final SceneFindInfo position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onLauncherActItemClickListener != null)
                    onLauncherActItemClickListener.onLauncherActItemClick(v, position);
            }
        });
        if (!position.getEvaluateInfo().isEvaluate()) {
        }
        holder.mTvClickEvaluate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onLauncherActItemClickListener != null) {
                    onLauncherActItemClickListener.onEvaluateButtonClick(v, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_launch_act_title)
        TextView mTvTitle;
        @BindView(R.id.tv_launch_act_date)
        TextView mTvDate;
        @BindView(R.id.rv_launch_act_tag)
        RecyclerView mRvTag;
        @BindView(R.id.tv_launch_act_evaluate)
        TextView mTvClickEvaluate;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
