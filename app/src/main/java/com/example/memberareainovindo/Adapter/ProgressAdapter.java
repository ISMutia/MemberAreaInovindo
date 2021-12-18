package com.example.memberareainovindo.Adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.memberareainovindo.Model.response.progress.DataItem;
import com.example.memberareainovindo.databinding.ListProgressBinding;

import java.util.List;

public class ProgressAdapter extends RecyclerView.Adapter<ProgressAdapter.ViewHolder> {
    final List<DataItem> lisItem;

    public ProgressAdapter(List<DataItem> lisItem) {
        this.lisItem = lisItem;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ListProgressBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
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

        private ListProgressBinding binding;

        public ViewHolder(@NonNull ListProgressBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        public void bindData(DataItem dataItem) {
            binding.txtnamaprogress.setText(dataItem.getProjectName());
            binding.simpleProgressBar.setProgress(dataItem.getProgress());
        }
    }
}
