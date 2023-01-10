package com.didi.safetoolkit.business.safeCenter;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class SfSafetyCenterDivider extends RecyclerView.ItemDecoration {

    /* renamed from: a */
    private int f37173a;

    /* renamed from: b */
    private int f37174b;

    /* renamed from: c */
    private Paint f37175c = new Paint();

    /* renamed from: d */
    private Paint f37176d;

    public SfSafetyCenterDivider(Context context) {
        Paint paint = new Paint();
        this.f37176d = paint;
        paint.setColor(Color.parseColor("#3D8EAFD3"));
        this.f37176d.setMaskFilter(new BlurMaskFilter((float) ((int) TypedValue.applyDimension(1, 5.0f, context.getResources().getDisplayMetrics())), BlurMaskFilter.Blur.NORMAL));
        this.f37176d.setStyle(Paint.Style.FILL);
        this.f37175c.setColor(Color.parseColor("#3D8EAFD3"));
        this.f37173a = (int) TypedValue.applyDimension(1, 10.0f, context.getResources().getDisplayMetrics());
        this.f37174b = (int) TypedValue.applyDimension(1, 5.0f, context.getResources().getDisplayMetrics());
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        rect.bottom = this.f37173a;
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        RecyclerView recyclerView2 = recyclerView;
        recyclerView2.setLayerType(1, (Paint) null);
        int childCount = recyclerView.getChildCount();
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView2.getChildAt(i);
            float f = (float) paddingLeft;
            float bottom = (float) childAt.getBottom();
            float f2 = (float) width;
            canvas.drawRect(f, bottom, f2, (float) (childAt.getBottom() + this.f37173a), this.f37175c);
            canvas.drawRect(f, bottom, f2, (float) (childAt.getBottom() + this.f37174b), this.f37176d);
        }
    }
}
