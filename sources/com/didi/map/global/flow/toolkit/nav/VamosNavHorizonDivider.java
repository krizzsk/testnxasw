package com.didi.map.global.flow.toolkit.nav;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class VamosNavHorizonDivider extends RecyclerView.ItemDecoration {

    /* renamed from: a */
    private Drawable f29731a;

    public VamosNavHorizonDivider(Context context, int i) {
        this.f29731a = context.getResources().getDrawable(i);
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            int bottom = childAt.getBottom() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).bottomMargin;
            this.f29731a.setBounds(paddingLeft, bottom, width, this.f29731a.getIntrinsicHeight() + bottom);
            this.f29731a.draw(canvas);
        }
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.set(0, 0, 0, this.f29731a.getIntrinsicHeight());
    }
}
