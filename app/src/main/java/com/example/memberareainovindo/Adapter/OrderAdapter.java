package com.example.memberareainovindo.Adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.memberareainovindo.Model.response.order.DataItem;
import com.example.memberareainovindo.databinding.ListOrderBinding;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {
    final List<DataItem> listItem;

    public OrderAdapter(List<DataItem> listItem) {
        this.listItem = listItem;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ListOrderBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(listItem.get(position));
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ListOrderBinding binding;
        public ViewHolder( @NonNull ListOrderBinding itemView) {
            super(itemView.getRoot());

            binding = itemView;
        }

        public void bindData(DataItem dataItem) {
            binding.txtIdOrder.setText(dataItem.getId());
            binding.txtPName1.setText(dataItem.getProjectName());
            binding.txtLama1.setText(dataItem.getLamaP());
            binding.txtPType2.setText(dataItem.getPriceName());
            binding.txtTypeDomain1.setText(dataItem.getNameDomain());
            binding.txtSWork1.setText(dataItem.getMulaiP());
            binding.txtFWork1.setText(dataItem.getSelesaiP());
            binding.txtFDomain1.setText(dataItem.getLamaDomain());
            binding.txtWa.setText(dataItem.getLinkGroupWa());
        }
    }
}
