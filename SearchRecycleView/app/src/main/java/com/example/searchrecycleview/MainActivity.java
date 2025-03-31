package com.example.searchrecycleview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.searchrecycleview.adapter.IconAdapter;
import com.example.searchrecycleview.databinding.ActivityMainBinding;
import com.example.searchrecycleview.model.IconModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private IconAdapter iconAdapter;
    private List<IconModel> iconList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Cấu hình RecyclerView
        binding.rclIcon.setLayoutManager(new LinearLayoutManager(this));
        binding.rclIcon.setHasFixedSize(true);
        binding.rclIcon.addItemDecoration(new LinePagerIndicatorDecoration());


        // Khởi tạo danh sách icon
        iconList = new ArrayList<>();
        iconList.add(new IconModel(R.drawable.ic_flash, "Flash Sale - Giảm giá sốc"));
        iconList.add(new IconModel(R.drawable.ic_sale, "Ưu đãi hấp dẫn"));
        iconList.add(new IconModel(R.drawable.ic_vn, "Sản phẩm nội địa Việt Nam"));
        iconList.add(new IconModel(R.drawable.ic_fresh, "Hàng tươi sống, thực phẩm sạch"));
        iconList.add(new IconModel(R.drawable.ic_xu, "Tích điểm nhận xu thưởng"));
        iconList.add(new IconModel(R.drawable.ic_hanghieu, "Hàng hiệu chính hãng"));

        for(int i = 0; i < 50 ; i++) {
            iconList.add(iconList.get(i%6));
        }


        // Gán dữ liệu vào Adapter và hiển thị
        iconAdapter = new IconAdapter(iconList);
        binding.rclIcon.setAdapter(iconAdapter);

        // Xử lý tìm kiếm
        binding.searchView.clearFocus();
        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });
    }

    private void filterList(String text) {
        List<IconModel> filteredList = new ArrayList<>();
        for (IconModel item : iconList) {
            if (item.getDesc().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        iconAdapter.setFilteredList(filteredList);
    }
}