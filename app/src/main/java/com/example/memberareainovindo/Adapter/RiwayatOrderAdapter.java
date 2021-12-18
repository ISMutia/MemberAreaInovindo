package com.example.memberareainovindo.Adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.memberareainovindo.Model.response.riwayatOrder.DataItem;
import com.example.memberareainovindo.databinding.ListRiwayatOrderBinding;

import java.util.List;

public class RiwayatOrderAdapter extends RecyclerView.Adapter<RiwayatOrderAdapter.ViewHolder> {
    final List<DataItem> lisItem;

    public RiwayatOrderAdapter(List<DataItem> lisItem) {
        this.lisItem = lisItem;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ListRiwayatOrderBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
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
        ListRiwayatOrderBinding binding;

        public ViewHolder(@NonNull  ListRiwayatOrderBinding itemView) {
            super(itemView.getRoot());

            binding = itemView;
        }

        public void bindData(DataItem dataItem) {
            binding.txtPNameB.setText(dataItem.getProjectName());
            binding.txtIdBills.setText(dataItem.getNoBill()+"");
            binding.txtDname1.setText(dataItem.getNameDomain());
            binding.txtTypePaket1.setText(dataItem.getPriceName());
            binding.txtDate.setText(dataItem.getCreatedAt()+"");
        }
    }
}
