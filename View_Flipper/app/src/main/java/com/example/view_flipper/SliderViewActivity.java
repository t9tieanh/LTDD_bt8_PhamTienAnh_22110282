package com.example.view_flipper;

import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.view_flipper.adapter.SliderAdapter;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderView;

import java.util.Arrays;
import java.util.List;

public class SliderViewActivity extends AppCompatActivity {
    private SliderView sliderView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider_view);

        sliderView = findViewById(R.id.imageSlider);

        // Danh sách ảnh
        List<Integer> imageList = Arrays.asList(
                R.drawable.img1,
                R.drawable.img2,
                R.drawable.img3
        );

        // Gán Adapter cho SliderView
        SliderAdapter adapter = new SliderAdapter(this, imageList);
        sliderView.setSliderAdapter(adapter);

        // Cấu hình thêm cho slider
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);
        sliderView.setSliderAdapter(adapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_RIGHT);
        sliderView.setIndicatorSelectedColor(Color.parseColor("#e63946"));
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setAutoCycle(true);
        sliderView.startAutoCycle();
        sliderView.setScrollTimeInSec(3);
    }
}
