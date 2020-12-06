package com.dev.ieeensut.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.dev.ieeensut.R;
import com.dev.ieeensut.interfaces.OnRecyclerViewItemClickListener;
import com.dev.ieeensut.models.Social;

import java.util.ArrayList;

/**
 *
 */

public class SocialRecyclerAdapter extends RecyclerView.Adapter<com.dev.ieeensut.adapter.SocialRecyclerAdapter.SocialViewHolder> {

    private Context context;
    private ArrayList<Social> arrayList;
    private OnRecyclerViewItemClickListener listener;

    public SocialRecyclerAdapter(Context context, ArrayList<Social> arrayList, OnRecyclerViewItemClickListener listener) {
        this.context = context;
        this.arrayList = arrayList;
        this.listener = listener;
    }

    @Override
    public SocialViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.social_item_layout, parent, false);
        return new SocialViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(SocialViewHolder holder, int position) {
        Social social = arrayList.get(position);
        holder.socialImageView.setImageResource(social.getImageId());
        holder.socialTextView.setText(social.getTitle());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    static class SocialViewHolder extends RecyclerView.ViewHolder {
        ImageView socialImageView;
        TextView socialTextView;

        SocialViewHolder(final View itemView, final OnRecyclerViewItemClickListener listener) {
            super(itemView);
            socialImageView = itemView.findViewById(R.id.social_image_view);
            socialTextView = itemView.findViewById(R.id.social_text_view);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        listener.onItemClicked(itemView);
                    }
                }
            });
        }

    }
}
