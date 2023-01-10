package com.didi.beatles.p101im.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: com.didi.beatles.im.views.IMRecycleViewDivider */
public class IMRecycleViewDivider extends RecyclerView.ItemDecoration {

    /* renamed from: e */
    private static final int[] f11771e = {16843284};

    /* renamed from: a */
    private Paint f11772a;

    /* renamed from: b */
    private Drawable f11773b;

    /* renamed from: c */
    private int f11774c;

    /* renamed from: d */
    private int f11775d;

    public IMRecycleViewDivider(Context context, int i) {
        this.f11774c = 2;
        if (i == 1 || i == 0) {
            this.f11775d = i;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f11771e);
            this.f11773b = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
            return;
        }
        throw new IllegalArgumentException("请输入正确的参数！");
    }

    public IMRecycleViewDivider(Context context, int i, int i2) {
        this(context, i);
        Drawable drawable = ContextCompat.getDrawable(context, i2);
        this.f11773b = drawable;
        this.f11774c = drawable.getIntrinsicHeight();
    }

    public IMRecycleViewDivider(Context context, int i, int i2, int i3) {
        this(context, i);
        this.f11774c = i2;
        Paint paint = new Paint(1);
        this.f11772a = paint;
        paint.setColor(i3);
        this.f11772a.setStyle(Paint.Style.FILL);
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        rect.set(0, 0, 0, this.f11774c);
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        super.onDraw(canvas, recyclerView, state);
        if (this.f11775d == 1) {
            m10091b(canvas, recyclerView);
        } else {
            m10090a(canvas, recyclerView);
        }
    }

    /* renamed from: a */
    private void m10090a(Canvas canvas, RecyclerView recyclerView) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int measuredWidth = recyclerView.getMeasuredWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            int bottom = childAt.getBottom() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).bottomMargin;
            int i2 = this.f11774c + bottom;
            Drawable drawable = this.f11773b;
            if (drawable != null) {
                drawable.setBounds(paddingLeft, bottom, measuredWidth, i2);
                this.f11773b.draw(canvas);
            }
            Paint paint = this.f11772a;
            if (paint != null) {
                canvas.drawRect((float) paddingLeft, (float) bottom, (float) measuredWidth, (float) i2, paint);
            }
        }
    }

    /* renamed from: b */
    private void m10091b(Canvas canvas, RecyclerView recyclerView) {
        int paddingTop = recyclerView.getPaddingTop();
        int measuredHeight = recyclerView.getMeasuredHeight() - recyclerView.getPaddingBottom();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            int right = childAt.getRight() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).rightMargin;
            int i2 = this.f11774c + right;
            Drawable drawable = this.f11773b;
            if (drawable != null) {
                drawable.setBounds(right, paddingTop, i2, measuredHeight);
                this.f11773b.draw(canvas);
            }
            Paint paint = this.f11772a;
            if (paint != null) {
                canvas.drawRect((float) right, (float) paddingTop, (float) i2, (float) measuredHeight, paint);
            }
        }
    }
}
