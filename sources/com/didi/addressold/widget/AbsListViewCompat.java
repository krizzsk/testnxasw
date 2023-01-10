package com.didi.addressold.widget;

import android.view.View;
import android.widget.AbsListView;

public class AbsListViewCompat<T extends AbsListView> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public OnScrollCallback f9891a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f9892b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f9893c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f9894d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public T f9895e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f9896f;

    public interface OnScrollCallback {
        public static final int SCROLL_DIRECTION_DOWN = 2;
        public static final int SCROLL_DIRECTION_NOTHING = 0;
        public static final int SCROLL_DIRECTION_UP = 1;
        public static final int SCROLL_POSITION_BOTTOM = 2;
        public static final int SCROLL_POSITION_OTHER = 0;
        public static final int SCROLL_POSITION_TOP = 1;
        public static final int STATE_SCROLLING = 1;
        public static final int STATE_STOPPED = 2;
        public static final int STATE_TOUCH_SCROLL = 0;

        void onScrollChanged(int i, int i2, int i3);
    }

    public AbsListViewCompat setScrollView(T t) {
        if (t == null) {
            return this;
        }
        this.f9895e = t;
        m8618a();
        return this;
    }

    public T getScrollView() {
        return this.f9895e;
    }

    public AbsListViewCompat setOnScrollCallback(OnScrollCallback onScrollCallback) {
        this.f9891a = onScrollCallback;
        return this;
    }

    /* renamed from: a */
    private void m8618a() {
        this.f9895e.setOnScrollListener(new AbsListView.OnScrollListener() {
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (AbsListViewCompat.this.f9891a != null) {
                    int b = AbsListViewCompat.this.m8623c();
                    if (i == 0) {
                        AbsListViewCompat absListViewCompat = AbsListViewCompat.this;
                        int unused = absListViewCompat.f9892b = absListViewCompat.m8620b();
                        AbsListViewCompat.this.f9891a.onScrollChanged(2, 0, b);
                    } else if (i == 1) {
                        boolean unused2 = AbsListViewCompat.this.f9896f = true;
                        AbsListViewCompat.this.f9891a.onScrollChanged(0, 0, b);
                    }
                }
            }

            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int c;
                if (AbsListViewCompat.this.f9896f && AbsListViewCompat.this.f9891a != null && AbsListViewCompat.this.f9892b != (c = AbsListViewCompat.this.m8620b())) {
                    int unused = AbsListViewCompat.this.f9892b = c;
                    int i4 = 0;
                    int i5 = 2;
                    int[] iArr = new int[2];
                    AbsListViewCompat.this.f9895e.getChildAt(0).getLocationOnScreen(iArr);
                    int i6 = 1;
                    if (i != AbsListViewCompat.this.f9893c) {
                        if (i > AbsListViewCompat.this.f9893c) {
                            i4 = 1;
                        } else if (i < AbsListViewCompat.this.f9893c) {
                            i4 = 2;
                        }
                        int unused2 = AbsListViewCompat.this.f9893c = i;
                        int unused3 = AbsListViewCompat.this.f9894d = iArr[1];
                    } else {
                        if (AbsListViewCompat.this.f9894d > iArr[1]) {
                            i4 = 1;
                        } else {
                            if (AbsListViewCompat.this.f9894d < iArr[1]) {
                                i4 = 2;
                            }
                            int unused4 = AbsListViewCompat.this.f9894d = iArr[1];
                            i6 = i5;
                        }
                        i5 = 1;
                        int unused5 = AbsListViewCompat.this.f9894d = iArr[1];
                        i6 = i5;
                    }
                    AbsListViewCompat.this.f9891a.onScrollChanged(i6, i4, AbsListViewCompat.this.m8623c());
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public int m8620b() {
        View childAt = this.f9895e.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return -(childAt.getTop() + this.f9895e.getPaddingTop());
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public int m8623c() {
        View childAt;
        if (this.f9895e.getLastVisiblePosition() == this.f9895e.getCount() - 1) {
            T t = this.f9895e;
            if (t.getChildAt(t.getChildCount() - 1).getBottom() + this.f9895e.getPaddingBottom() == this.f9895e.getBottom()) {
                return 2;
            }
        }
        if (this.f9895e.getFirstVisiblePosition() == 0 && (childAt = this.f9895e.getChildAt(0)) != null && childAt.getTop() == this.f9895e.getPaddingTop()) {
            return 1;
        }
        return 0;
    }
}
