package com.didi.sdk.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.didi.sdk.apm.SystemUtils;

public class PinnedHeaderListView extends ListView {

    /* renamed from: a */
    private static final int f40569a = 255;

    /* renamed from: b */
    private PinnedHeaderAdapter f40570b;

    /* renamed from: c */
    private View f40571c;

    /* renamed from: d */
    private boolean f40572d;

    /* renamed from: e */
    private int f40573e;

    /* renamed from: f */
    private int f40574f;

    /* renamed from: g */
    private int f40575g;

    /* renamed from: h */
    private int f40576h;

    /* renamed from: i */
    private boolean f40577i;

    public interface PinnedHeaderAdapter {
        public static final int PINNED_HEADER_GONE = 0;
        public static final int PINNED_HEADER_PUSHED_UP = 2;
        public static final int PINNED_HEADER_VISIBLE = 1;

        public interface ScrollStateChangeListener {
            void onScroll(AbsListView absListView, int i, int i2, int i3);

            void onScrollStateChanged(AbsListView absListView, int i);
        }

        void configurePinnedHeader(View view, int i, int i2);

        int getPinnedHeaderState(int i);
    }

    public PinnedHeaderListView(Context context) {
        super(context);
    }

    public PinnedHeaderListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOverScrollMode(2);
    }

    public PinnedHeaderListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setPinnedHeaderView(View view) {
        this.f40571c = view;
        if (view != null) {
            setFadingEdgeLength(0);
        }
        requestLayout();
    }

    public void setAdapter(ListAdapter listAdapter, boolean z) {
        super.setAdapter(listAdapter);
        this.f40577i = z;
        if (z) {
            this.f40570b = (PinnedHeaderAdapter) listAdapter;
        }
        setOnScrollListener((AbsListView.OnScrollListener) this.f40570b);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        View view = this.f40571c;
        if (view != null) {
            measureChild(view, i, i2);
            this.f40573e = this.f40571c.getMeasuredWidth();
            this.f40574f = this.f40571c.getMeasuredHeight();
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View view;
        super.onLayout(z, i, i2, i3, i4);
        if (this.f40577i && (view = this.f40571c) != null) {
            view.layout(0, 0, this.f40573e, this.f40574f);
            configureHeaderView(getFirstVisiblePosition());
        }
    }

    public void configureHeaderView(int i) {
        if (this.f40577i && this.f40571c != null && this.f40570b != null && getChildCount() != 0 && getCount() != i + 1) {
            int i2 = this.f40575g;
            int i3 = this.f40576h;
            this.f40576h = i;
            int pinnedHeaderState = this.f40570b.getPinnedHeaderState(i);
            this.f40575g = pinnedHeaderState;
            if (pinnedHeaderState == 0) {
                this.f40572d = false;
            } else if (pinnedHeaderState == 1) {
                if (this.f40571c.getTop() != 0) {
                    this.f40571c.layout(0, 0, this.f40573e, this.f40574f);
                }
                this.f40570b.configurePinnedHeader(this.f40571c, i, 255);
                this.f40571c.invalidate();
                if (!this.f40572d) {
                    this.f40571c.invalidate();
                }
                this.f40572d = true;
            } else if (pinnedHeaderState == 2) {
                if (pinnedHeaderState != i2) {
                    this.f40570b.configurePinnedHeader(this.f40571c, i, 255);
                } else if (i3 != this.f40576h) {
                    this.f40570b.configurePinnedHeader(this.f40571c, i, 255);
                    this.f40571c.invalidate();
                    SystemUtils.log(3, "chenyi", "pushe up  oldPosition != mFirstPositionchagen group...", (Throwable) null, "com.didi.sdk.view.PinnedHeaderListView", 141);
                }
                int bottom = getChildAt(0).getBottom();
                int height = this.f40571c.getHeight();
                int i4 = bottom < height ? bottom - height : 0;
                if (this.f40571c.getTop() != i4) {
                    this.f40571c.layout(0, i4, this.f40573e, this.f40574f + i4);
                }
                this.f40572d = true;
            }
        }
    }

    public void setSelection(int i) {
        super.setSelection(i);
        int firstVisiblePosition = getFirstVisiblePosition();
        int lastVisiblePosition = getLastVisiblePosition();
        if (this.f40577i) {
            if (firstVisiblePosition != 0 || lastVisiblePosition != getCount() - 1) {
                this.f40570b.configurePinnedHeader(this.f40571c, i, 255);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f40572d && this.f40577i) {
            drawChild(canvas, this.f40571c, getDrawingTime());
        }
    }
}
