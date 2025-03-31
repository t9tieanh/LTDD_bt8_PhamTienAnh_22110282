package com.example.view_flipper.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.view_flipper.R;
import com.smarteist.autoimageslider.SliderViewAdapter;
import java.util.List;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderViewHolder> {
    private Context context;
    private List<Integer> imageList;

    public SliderAdapter(Context context, List<Integer> imageList) {
        this.context = context;
        this.imageList = imageList;
    }

    @Override
    public SliderViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false);
        return new SliderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SliderViewHolder viewHolder, int position) {
        viewHolder.imageView.setImageResource(imageList.get(position));
    }

    @Override
    public int getCount() {
        return imageList.size();
    }

    public static class SliderViewHolder extends SliderViewAdapter.ViewHolder {
        ImageView imageView;

        public SliderViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}

