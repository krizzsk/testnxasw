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

/* renamed from: com.didi.beatles.im.views.IMDividerItemDecoration */
public class IMDividerItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: e */
    private static final int[] f11704e = {16843284};

    /* renamed from: a */
    private Paint f11705a;

    /* renamed from: b */
    private Drawable f11706b;

    /* renamed from: c */
    private int f11707c;

    /* renamed from: d */
    private int f11708d;

    public IMDividerItemDecoration(Context context, int i) {
        this.f11707c = 2;
        if (i == 1 || i == 0) {
            this.f11708d = i;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f11704e);
            this.f11706b = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
            return;
        }
        throw new IllegalArgumentException("请输入正确的参数！");
    }

    public IMDividerItemDecoration(Context context, int i, int i2) {
        this(context, i);
        Drawable drawable = ContextCompat.getDrawable(context, i2);
        this.f11706b = drawable;
        this.f11707c = drawable.getIntrinsicHeight();
    }

    public IMDividerItemDecoration(Context context, int i, int i2, int i3) {
        this(context, i);
        this.f11707c = i2;
        Paint paint = new Paint(1);
        this.f11705a = paint;
        paint.setColor(i3);
        this.f11705a.setStyle(Paint.Style.FILL);
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        rect.set(0, 0, 0, this.f11707c);
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        super.onDraw(canvas, recyclerView, state);
        if (this.f11708d == 1) {
            m10063b(canvas, recyclerView);
        } else {
            m10062a(canvas, recyclerView);
        }
    }

    /* renamed from: a */
    private void m10062a(Canvas canvas, RecyclerView recyclerView) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int measuredWidth = recyclerView.getMeasuredWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            int bottom = childAt.getBottom() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).bottomMargin;
            int i2 = this.f11707c + bottom;
            Drawable drawable = this.f11706b;
            if (drawable != null) {
                drawable.setBounds(paddingLeft, bottom, measuredWidth, i2);
                this.f11706b.draw(canvas);
            }
            Paint paint = this.f11705a;
            if (paint != null) {
                canvas.drawRect((float) paddingLeft, (float) bottom, (float) measuredWidth, (float) i2, paint);
            }
        }
    }

    /* renamed from: b */
    private void m10063b(Canvas canvas, RecyclerView recyclerView) {
        int paddingTop = recyclerView.getPaddingTop();
        int measuredHeight = recyclerView.getMeasuredHeight() - recyclerView.getPaddingBottom();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            int right = childAt.getRight() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).rightMargin;
            int i2 = this.f11707c + right;
            Drawable drawable = this.f11706b;
            if (drawable != null) {
                drawable.setBounds(right, paddingTop, i2, measuredHeight);
                this.f11706b.draw(canvas);
            }
            Paint paint = this.f11705a;
            if (paint != null) {
                canvas.drawRect((float) right, (float) paddingTop, (float) i2, (float) measuredHeight, paint);
            }
        }
    }
}
