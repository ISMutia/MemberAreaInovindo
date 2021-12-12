package com.example.memberareainovindo.Adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.memberareainovindo.Model.response.order.DataItem;
import com.example.memberareainovindo.databinding.ListOrderBinding;

import java.util.List;

public class ListOrderAdapter extends RecyclerView.Adapter<ListOrderAdapter.ViewHolder> {
    final List<DataItem> lisItem;

    public ListOrderAdapter(List<DataItem> lisItem) {
        this.lisItem = lisItem;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ListOrderBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(lisItem.get(position));
        // jika ada item
    }

    @Override
    public int getItemCount() {
        return lisItem.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ListOrderBinding binding;

        public ViewHolder(@NonNull ListOrderBinding itemView) {
            super(itemView.getRoot());

            binding = itemView;

            // deklarasi variable widget
        }

        public void bindData(DataItem dataItem) {

            binding.txtIdOrder.setText(dataItem.getId()+"");
            binding.txtPName1.setText(dataItem.getProjectName());
            binding.txtLama1.setText(dataItem.getLamaP());
            binding.txtFDomain1.setText(dataItem.getLamaDomain());
            binding.txtSWork1.setText(dataItem.getMulaiP());
            binding.txtFWork1.setText(dataItem.getSelesaiP());
            binding.txtPType2.setText(dataItem.getPriceName());
            binding.txtTypeDomain1.setText(dataItem.getDomainName());
            binding.txtStatus.setText(dataItem.getStatusName());


        }
    }
}
