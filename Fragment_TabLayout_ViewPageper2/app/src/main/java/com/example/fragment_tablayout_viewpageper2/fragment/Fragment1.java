package com.example.fragment_tablayout_viewpageper2.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fragment_tablayout_viewpageper2.databinding.Fragment1Binding;

public class Fragment1 extends Fragment {
    private Fragment1Binding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = Fragment1Binding.inflate(inflater, container, false);
        binding.textView.setText("Đây là Fragment 1");
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
