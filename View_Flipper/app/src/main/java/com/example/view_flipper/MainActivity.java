package com.example.view_flipper;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Handler;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.List;
import me.relex.circleindicator.CircleIndicator3;

import android.os.Looper;

import com.example.view_flipper.adapter.ImageAdapter;
import com.example.view_flipper.model.ImageModel;

public class MainActivity extends AppCompatActivity {
    private ViewPager2 viewPager2;
    private ImageAdapter adapter;
    private CircleIndicator3 indicator;
    private Handler handler = new Handler(Looper.getMainLooper());
    private Runnable runnable;
    private int delay = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager2 = findViewById(R.id.viewPager2);
        indicator = findViewById(R.id.circleIndicator);

        List<ImageModel> imageList = new ArrayList<>();
        imageList.add(new ImageModel(R.drawable.img1));
        imageList.add(new ImageModel(R.drawable.img2));
        imageList.add(new ImageModel(R.drawable.img3));
        imageList.add(new ImageModel(R.drawable.img4));

        // Thiết lập Adapter
        adapter = new ImageAdapter(imageList);
        viewPager2.setAdapter(adapter);
        indicator.setViewPager(viewPager2);

        // Auto Run - Chuyển slide tự động
        runnable = new Runnable() {
            @Override
            public void run() {
                int currentItem = viewPager2.getCurrentItem();
                int totalItems = adapter.getItemCount();

                if (currentItem < totalItems - 1) {
                    viewPager2.setCurrentItem(currentItem + 1, true);
                } else {
                    viewPager2.setCurrentItem(0, true); // Quay lại ảnh đầu tiên
                }

                handler.postDelayed(this, delay);
            }
        };


        handler.postDelayed(runnable, delay);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
    }
}
