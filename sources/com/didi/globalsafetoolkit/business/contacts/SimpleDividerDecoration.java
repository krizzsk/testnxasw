package com.didi.globalsafetoolkit.business.contacts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class SimpleDividerDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a */
    private int f24990a;

    /* renamed from: b */
    private Paint f24991b;

    public SimpleDividerDecoration(Context context) {
        Paint paint = new Paint();
        this.f24991b = paint;
        paint.setColor(Color.parseColor("#0B000000"));
        this.f24990a = (int) TypedValue.applyDimension(1, 1.0f, context.getResources().getDisplayMetrics());
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        rect.bottom = this.f24990a;
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int childCount = recyclerView.getChildCount();
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        for (int i = 0; i < childCount - 1; i++) {
            View childAt = recyclerView.getChildAt(i);
            Canvas canvas2 = canvas;
            canvas2.drawRect((float) paddingLeft, (float) childAt.getBottom(), (float) width, (float) (childAt.getBottom() + this.f24990a), this.f24991b);
        }
    }
}
