package com.example.lfy.dlvideo.fragment_home.child_fragment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lfy.dlvideo.R;
import com.example.lfy.dlvideo.bean.FirstBean;

import java.util.List;

/**
 * Created by lfy on 2016/6/3.
 */
public class FirstAdapter extends RecyclerView.Adapter<FirstAdapter.ViewHold> {
    List<FirstBean> firstBeen;
    public int lastPosition = -1;

    public void addDate(List<FirstBean> firstBeen) {
        this.firstBeen = firstBeen;
    }

    private OnItemClickListen Listen;

    public void setOnItemClickListen(OnItemClickListen Listen) {
        this.Listen = Listen;
    }


    @Override
    public ViewHold onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.child_fragment_first, parent, false);
        return new ViewHold(view);
    }

    @Override
    public void onBindViewHolder(ViewHold holder, int position) {
        holder.itemView.setTag(position);
        setAnimation(holder.itemView, position);

    }

    protected void setAnimation(View viewToAnimate, int position) {
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(viewToAnimate.getContext(), R.anim.item_slide_bottom_up);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        } else {
            Animation animation = AnimationUtils.loadAnimation(viewToAnimate.getContext(), R.anim.item_slide_bottom_down);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

    @Override
    public void onViewDetachedFromWindow(ViewHold holder) {
        super.onViewDetachedFromWindow(holder);
        holder.itemView.clearAnimation();
    }


    @Override
    public int getItemCount() {
        return firstBeen.size();
    }

    class ViewHold extends RecyclerView.ViewHolder {
        TextView cardView;

        public ViewHold(final View itemView) {
            super(itemView);
            cardView = (TextView) itemView.findViewById(R.id.section_label);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Listen != null) {
//                        Listen.SetOnItemClick(Type.get((Integer) itemView.getTag()).getType1(), Type.get((Integer) itemView.getTag()).getTypeName1(), Type.get((Integer) itemView.getTag()).getShowType());
                        Listen.SetOnItemClick(firstBeen.get((Integer) itemView.getTag()));
                    }
                }
            });
        }
    }

    interface OnItemClickListen {
        void SetOnItemClick(FirstBean gridPhoto);
    }
}
