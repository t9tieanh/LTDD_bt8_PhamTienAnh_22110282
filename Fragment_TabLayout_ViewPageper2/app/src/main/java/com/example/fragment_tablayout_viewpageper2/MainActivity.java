package com.example.fragment_tablayout_viewpageper2;

import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.fragment_tablayout_viewpageper2.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolBar);

        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        binding.viewPager2.setAdapter(adapter);

        new TabLayoutMediator(binding.tabLayout, binding.viewPager2, (tab, position) -> {
            switch (position) {
                case 0: tab.setText("Tab 1"); break;
                case 1: tab.setText("Tab 2"); break;
                case 2: tab.setText("Tab 3"); break;
            }
        }).attach();

        binding.tabLayout.addOnTabSelectedListener(
                new TabLayout.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        binding.viewPager2.setCurrentItem(tab.getPosition());
                        changeLogoBtn(tab.getPosition());

                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {

                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {

                    }
                }
        );
    }

    private void changeLogoBtn(final int index) {
        binding.fabAction.hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (index) {
                    case 0:
                        binding.fabAction.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.call24));
                        break;
                    case 1:
                        binding.fabAction.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.mess24));
                        break;
                    case 2:
                        binding.fabAction.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.camera));
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + index);
                }
                binding.fabAction.show();
            }
        }, 2000);
    }

}