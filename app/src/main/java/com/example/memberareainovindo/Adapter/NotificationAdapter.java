package com.example.memberareainovindo.Adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.memberareainovindo.Model.response.notification.DataItem;
import com.example.memberareainovindo.databinding.ListNotificationBinding;
import com.example.memberareainovindo.databinding.ListProgressBinding;

import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {
    final List<DataItem> lisItem;

    public NotificationAdapter(List<DataItem> lisItem) {
        this.lisItem = lisItem;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ListNotificationBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(lisItem.get(position));
    }

    @Override
    public int getItemCount() {
        return lisItem.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ListNotificationBinding binding;

        public ViewHolder(@NonNull ListNotificationBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        public void bindData(DataItem dataItem) {
            binding.tvTitle.setText(dataItem.getTittle());
            binding.tvDecs.setText(dataItem.getDescription());
        }
    }
}
