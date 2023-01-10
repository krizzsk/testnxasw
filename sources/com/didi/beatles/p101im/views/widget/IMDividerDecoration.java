package com.didi.beatles.p101im.views.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.beatles.p101im.utils.IMLog;

/* renamed from: com.didi.beatles.im.views.widget.IMDividerDecoration */
public class IMDividerDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a */
    private static final String f12291a = "IMDividerDecoration";

    /* renamed from: b */
    private int f12292b;

    /* renamed from: c */
    private int f12293c = -65536;

    /* renamed from: d */
    private int f12294d = 2;

    /* renamed from: e */
    private boolean f12295e;

    public void setDividerWidth(int i) {
        if (i >= 0) {
            this.f12294d = i;
            return;
        }
        throw new IllegalArgumentException("divider width " + i + " is not valid!");
    }

    public void setDividerColor(int i) {
        this.f12293c = i;
    }

    public void isLastItemShowDivider(boolean z) {
        this.f12295e = z;
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            this.f12292b = ((LinearLayoutManager) layoutManager).getOrientation();
            IMLog.m10020d(f12291a, "onDraw: direction " + this.f12292b);
            if (this.f12292b == 1) {
                m10497a(canvas, recyclerView);
            } else {
                m10498b(canvas, recyclerView);
            }
        } else {
            throw new IllegalArgumentException("recyclerview's manager is not LinearLayoutManager,can't use IMDividerDecoration");
        }
    }

    /* renamed from: a */
    private void m10497a(Canvas canvas, RecyclerView recyclerView) {
        if (recyclerView != null) {
            int childCount = recyclerView.getChildCount();
            if (!this.f12295e) {
                childCount--;
            }
            if (childCount >= 1) {
                Paint paint = new Paint();
                paint.setColor(this.f12293c);
                paint.setStrokeWidth((float) this.f12294d);
                paint.setAntiAlias(true);
                for (int i = 0; i < childCount; i++) {
                    View childAt = recyclerView.getChildAt(i);
                    canvas.drawLine(childAt.getX(), childAt.getY() + ((float) childAt.getHeight()), childAt.getX() + ((float) childAt.getWidth()), childAt.getY() + ((float) childAt.getHeight()), paint);
                }
            }
        }
    }

    /* renamed from: b */
    private void m10498b(Canvas canvas, RecyclerView recyclerView) {
        int childCount = recyclerView.getChildCount();
        if (!this.f12295e) {
            childCount--;
        }
        if (childCount >= 1) {
            Paint paint = new Paint();
            paint.setColor(this.f12293c);
            paint.setStrokeWidth((float) this.f12294d);
            paint.setAntiAlias(true);
            for (int i = 0; i < childCount; i++) {
                View childAt = recyclerView.getChildAt(i);
                canvas.drawLine(childAt.getX() + ((float) childAt.getWidth()), childAt.getY(), childAt.getX() + ((float) childAt.getWidth()), childAt.getY() + ((float) childAt.getHeight()), paint);
            }
        }
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        if (this.f12292b == 1) {
            rect.set(0, 0, 0, this.f12294d);
        } else {
            rect.set(0, 0, this.f12294d, 0);
        }
    }
}
