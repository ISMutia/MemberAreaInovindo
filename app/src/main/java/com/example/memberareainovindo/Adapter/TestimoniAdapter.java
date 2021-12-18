package com.example.memberareainovindo.Adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.memberareainovindo.Model.response.testimoni.DataItem;
import com.example.memberareainovindo.databinding.ListTestimoniBinding;

import java.util.List;

public class TestimoniAdapter extends RecyclerView.Adapter<TestimoniAdapter.ViewHolder> {
    final List<DataItem> lisItem;

    public TestimoniAdapter(List<DataItem> lisItem) {
        this.lisItem = lisItem;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ListTestimoniBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
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
        ListTestimoniBinding binding;

        public ViewHolder(@NonNull ListTestimoniBinding itemView) {
            super(itemView.getRoot());

            binding = itemView;
        }

        public void bindData(DataItem dataItem) {
            binding.txtCusName.setText(dataItem.getFullname());
            binding.txtTestiCus.setText(dataItem.getDescription());
        }
    }
}