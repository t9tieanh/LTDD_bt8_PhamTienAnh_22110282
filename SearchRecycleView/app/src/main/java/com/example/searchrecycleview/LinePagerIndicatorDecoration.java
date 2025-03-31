package com.example.searchrecycleview;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class LinePagerIndicatorDecoration extends RecyclerView.ItemDecoration {
    private final Paint paint = new Paint();
    private static final int COLOR_ACTIVE = Color.WHITE;
    private static final int COLOR_INACTIVE = Color.GRAY;
    private static final float INDICATOR_HEIGHT = 32f;  // Tăng chiều cao
    private static final float INDICATOR_RADIUS = 8f;   // Tăng kích thước chấm
    private static final float INDICATOR_MARGIN = 16f;  // Tăng khoảng cách giữa chấm

    public LinePagerIndicatorDecoration() {
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(INDICATOR_HEIGHT);
        paint.setAntiAlias(true);
    }

    @Override
    public void onDrawOver(Canvas canvas, RecyclerView parent, RecyclerView.State state) {
        int itemCount = parent.getAdapter().getItemCount();
        float totalLength = itemCount * INDICATOR_RADIUS * 2 + (itemCount - 1) * INDICATOR_MARGIN;
        float startX = (parent.getWidth() - totalLength) / 2f;
        float yPos = parent.getHeight() - INDICATOR_HEIGHT;

        // Vẽ các chấm INACTIVE (màu xám)
        for (int i = 0; i < itemCount; i++) {
            paint.setColor(COLOR_INACTIVE);
            float x = startX + i * (INDICATOR_RADIUS * 2 + INDICATOR_MARGIN);
            canvas.drawCircle(x, yPos, INDICATOR_RADIUS, paint);
        }

        // Xác định vị trí active (chấm đang được chọn)
        int activePosition = ((LinearLayoutManager) parent.getLayoutManager()).findFirstVisibleItemPosition();
        if (activePosition == RecyclerView.NO_POSITION) return;

        // Vẽ chấm ACTIVE (màu trắng)
        paint.setColor(COLOR_ACTIVE);
        float highlightX = startX + activePosition * (INDICATOR_RADIUS * 2 + INDICATOR_MARGIN);
        canvas.drawCircle(highlightX, yPos, INDICATOR_RADIUS, paint);
    }
}
