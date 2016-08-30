package com.example.lfy.dlvideo.login;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lfy.dlvideo.R;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lfy on 2016/8/28.
 */
public class SchoolAdapter extends RecyclerView.Adapter<SchoolAdapter.ViewHolder> {

    List<String> text = null;

    public void setText(List<String> text) {
        this.text = text;
    }


    private SetOnClick Listen;

    public void setOnItemClickListen(SetOnClick Listen) {
        this.Listen = Listen;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.spinner_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemView.setTag(position);
        holder.textView.setText(text.get(position));
    }

    @Override
    public int getItemCount() {

        return text == null ? 0 : text.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(final View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.spinner_text);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Listen != null) {
                        Listen.SetOnItemClick(text.get((Integer) itemView.getTag()));
                    }

                }
            });
        }
    }

    interface SetOnClick {
        void SetOnItemClick(String item);
    }
}