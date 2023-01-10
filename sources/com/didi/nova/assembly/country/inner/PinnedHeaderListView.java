package com.didi.nova.assembly.country.inner;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class PinnedHeaderListView extends ListView implements AbsListView.OnScrollListener {

    /* renamed from: a */
    private AbsListView.OnScrollListener f31644a;

    /* renamed from: b */
    private CountrySectionedAdapter f31645b;

    /* renamed from: c */
    private View f31646c;

    /* renamed from: d */
    private float f31647d;

    /* renamed from: e */
    private boolean f31648e = true;

    /* renamed from: f */
    private int f31649f = 0;

    /* renamed from: g */
    private int f31650g;

    public PinnedHeaderListView(Context context) {
        super(context);
        super.setOnScrollListener(this);
    }

    public PinnedHeaderListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setOnScrollListener(this);
    }

    public PinnedHeaderListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        super.setOnScrollListener(this);
    }

    public void setAdapter(ListAdapter listAdapter) {
        this.f31646c = null;
        this.f31645b = (CountrySectionedAdapter) listAdapter;
        super.setAdapter(listAdapter);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        AbsListView.OnScrollListener onScrollListener = this.f31644a;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i, i2, i3);
        }
        CountrySectionedAdapter countrySectionedAdapter = this.f31645b;
        if (countrySectionedAdapter == null || countrySectionedAdapter.getCount() == 0 || !this.f31648e || i < getHeaderViewsCount()) {
            this.f31646c = null;
            this.f31647d = 0.0f;
            for (int i4 = i; i4 < i + i2; i4++) {
                View childAt = getChildAt(i4);
                if (childAt != null) {
                    childAt.setVisibility(0);
                }
            }
            return;
        }
        int headerViewsCount = i - getHeaderViewsCount();
        View a = m24191a(this.f31645b.mo86083a(headerViewsCount), this.f31646c);
        this.f31646c = a;
        m24192a(a);
        this.f31647d = 0.0f;
        for (int i5 = headerViewsCount; i5 < headerViewsCount + i2; i5++) {
            if (this.f31645b.isSectionHeader(i5)) {
                View childAt2 = getChildAt(i5 - headerViewsCount);
                float top = (float) childAt2.getTop();
                childAt2.setVisibility(0);
                if (((float) this.f31646c.getMeasuredHeight()) >= top && top > 0.0f) {
                    this.f31647d = top - ((float) childAt2.getHeight());
                } else if (top <= 0.0f) {
                    childAt2.setVisibility(4);
                }
            }
        }
        invalidate();
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        AbsListView.OnScrollListener onScrollListener = this.f31644a;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i);
        }
    }

    /* renamed from: a */
    private View m24191a(int i, View view) {
        boolean z = i != this.f31649f || view == null;
        View a = this.f31645b.mo86084a(i, view, this);
        if (z) {
            m24192a(a);
            this.f31649f = i;
        }
        return a;
    }

    /* renamed from: a */
    private void m24192a(View view) {
        int i;
        if (view.isLayoutRequested()) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), this.f31650g);
            AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) view.getLayoutParams();
            if (layoutParams == null || layoutParams.height <= 0) {
                i = View.MeasureSpec.makeMeasureSpec(0, 0);
            } else {
                i = View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
            }
            view.measure(makeMeasureSpec, i);
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f31645b != null && this.f31648e && this.f31646c != null) {
            int save = canvas.save();
            canvas.translate(0.0f, this.f31647d);
            canvas.clipRect(0, 0, getWidth(), this.f31646c.getMeasuredHeight());
            this.f31646c.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.f31644a = onScrollListener;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f31650g = View.MeasureSpec.getMode(i);
    }
}
