package com.didi.sdk.sidebar.history.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import com.didi.sdk.view.DropDownListView;

public class DropPinnedHeaderList extends DropDownListView {

    /* renamed from: a */
    private static final int f40126a = 255;

    /* renamed from: b */
    private PinnedHeaderAdapter f40127b;

    /* renamed from: c */
    private View f40128c;

    /* renamed from: d */
    private boolean f40129d;

    /* renamed from: e */
    private int f40130e;

    /* renamed from: f */
    private int f40131f;

    /* renamed from: g */
    private int f40132g;

    /* renamed from: h */
    private int f40133h;

    /* renamed from: i */
    private boolean f40134i;

    public interface PinnedHeaderAdapter {
        public static final int PINNED_HEADER_GONE = 0;
        public static final int PINNED_HEADER_PUSHED_UP = 2;
        public static final int PINNED_HEADER_VISIBLE = 1;

        void configurePinnedHeader(View view, int i, int i2);

        int getPinnedHeaderState(int i);
    }

    public DropPinnedHeaderList(Context context) {
        super(context);
    }

    public DropPinnedHeaderList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOverScrollMode(2);
    }

    public DropPinnedHeaderList(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setPinnedHeaderView(View view) {
        this.f40128c = view;
        if (view != null) {
            setFadingEdgeLength(0);
        }
        requestLayout();
    }

    public void setAdapter(ListAdapter listAdapter, boolean z) {
        super.setAdapter(listAdapter);
        this.f40134i = z;
        if (z) {
            this.f40127b = (PinnedHeaderAdapter) listAdapter;
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        View view = this.f40128c;
        if (view != null) {
            measureChild(view, i, i2);
            this.f40130e = this.f40128c.getMeasuredWidth();
            this.f40131f = this.f40128c.getMeasuredHeight();
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View view;
        super.onLayout(z, i, i2, i3, i4);
        if (this.f40134i && (view = this.f40128c) != null) {
            view.layout(0, 0, this.f40130e, this.f40131f);
            configureHeaderView(getFirstVisiblePosition());
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        super.onScroll(absListView, i, i2, i3);
        configureHeaderView(i);
    }

    public void updateHeaderView(int i) {
        PinnedHeaderAdapter pinnedHeaderAdapter = this.f40127b;
        if (pinnedHeaderAdapter != null) {
            pinnedHeaderAdapter.configurePinnedHeader(this.f40128c, i, 255);
        }
    }

    public void configureHeaderView(int i) {
        if (this.f40134i && this.f40128c != null && this.f40127b != null && getChildCount() != 0 && getCount() != i + 1) {
            int i2 = this.f40132g;
            int i3 = this.f40133h;
            this.f40133h = i;
            int pinnedHeaderState = this.f40127b.getPinnedHeaderState(i);
            this.f40132g = pinnedHeaderState;
            if (pinnedHeaderState == 0) {
                this.f40129d = false;
            } else if (pinnedHeaderState == 1) {
                if (this.f40128c.getTop() != 0) {
                    this.f40128c.layout(0, 0, this.f40130e, this.f40131f);
                }
                if (this.f40132g != i2) {
                    this.f40127b.configurePinnedHeader(this.f40128c, i, 255);
                    this.f40128c.invalidate();
                }
                if (!this.f40129d) {
                    this.f40128c.invalidate();
                }
                this.f40129d = true;
            } else if (pinnedHeaderState == 2) {
                if (pinnedHeaderState != i2) {
                    this.f40127b.configurePinnedHeader(this.f40128c, i, 255);
                } else if (i3 != this.f40133h) {
                    this.f40127b.configurePinnedHeader(this.f40128c, i, 255);
                    this.f40128c.invalidate();
                }
                int bottom = getChildAt(0).getBottom();
                int height = this.f40128c.getHeight();
                int i4 = bottom < height ? bottom - height : 0;
                if (this.f40128c.getTop() != i4) {
                    this.f40128c.layout(0, i4, this.f40130e, this.f40131f + i4);
                }
                this.f40129d = true;
            }
        }
    }

    public void setSelection(int i) {
        PinnedHeaderAdapter pinnedHeaderAdapter;
        super.setSelection(i);
        int firstVisiblePosition = getFirstVisiblePosition();
        int lastVisiblePosition = getLastVisiblePosition();
        if (!this.f40134i) {
            return;
        }
        if ((firstVisiblePosition != 0 || lastVisiblePosition != getCount() - 1) && (pinnedHeaderAdapter = this.f40127b) != null) {
            pinnedHeaderAdapter.configurePinnedHeader(this.f40128c, i, 255);
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f40129d && this.f40134i) {
            drawChild(canvas, this.f40128c, getDrawingTime());
        }
    }
}
