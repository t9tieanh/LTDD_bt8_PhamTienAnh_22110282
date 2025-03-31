package com.example.searchrecycleview.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.searchrecycleview.R;
import com.example.searchrecycleview.databinding.ItemIconPromotionBinding;
import com.example.searchrecycleview.model.IconModel;

import java.util.List;

public class IconAdapter extends RecyclerView.Adapter<IconAdapter.IconHolder> {

    public IconAdapter(List<IconModel> iconList) {
        this.iconList = iconList;
    }

    private List<IconModel> iconList;

    @NonNull
    @Override
    public IconHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemIconPromotionBinding binding = ItemIconPromotionBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new IconHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull IconHolder holder, int position) {
        IconModel item = iconList.get(position);

        // Load ảnh bằng Glide
        Glide.with(holder.itemView.getContext())
                .load(item.getImgId()) // Nếu là drawable ID
                .placeholder(R.drawable.images) // Ảnh chờ khi tải
                .error(R.drawable.crc_error) // Ảnh lỗi nếu không load được
                .into(holder.binding.ivImgIcon); // Load vào ImageView

        holder.binding.tvIcon.setText(item.getDesc());
    }

    @Override
    public int getItemCount() {
        return iconList.size();
    }

    public void setFilteredList(List<IconModel> filteredList) {
        this.iconList = filteredList;
        notifyDataSetChanged();
    }

    public class  IconHolder extends RecyclerView.ViewHolder {
        private ItemIconPromotionBinding binding;

        public IconHolder(@NonNull ItemIconPromotionBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
