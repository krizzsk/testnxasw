package com.didi.addressnew.widget;

import android.view.View;
import android.widget.AbsListView;

public class AbsListViewCompat<T extends AbsListView> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public OnScrollCallback f9473a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f9474b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f9475c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f9476d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public T f9477e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f9478f;

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
        this.f9477e = t;
        m8219a();
        return this;
    }

    public T getScrollView() {
        return this.f9477e;
    }

    public AbsListViewCompat setOnScrollCallback(OnScrollCallback onScrollCallback) {
        this.f9473a = onScrollCallback;
        return this;
    }

    /* renamed from: a */
    private void m8219a() {
        this.f9477e.setOnScrollListener(new AbsListView.OnScrollListener() {
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (AbsListViewCompat.this.f9473a != null) {
                    int b = AbsListViewCompat.this.m8224c();
                    if (i == 0) {
                        AbsListViewCompat absListViewCompat = AbsListViewCompat.this;
                        int unused = absListViewCompat.f9474b = absListViewCompat.m8221b();
                        AbsListViewCompat.this.f9473a.onScrollChanged(2, 0, b);
                    } else if (i == 1) {
                        try {
                            absListView.clearFocus();
                        } catch (Exception unused2) {
                        }
                        boolean unused3 = AbsListViewCompat.this.f9478f = true;
                        AbsListViewCompat.this.f9473a.onScrollChanged(0, 0, b);
                    }
                }
            }

            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int c;
                if (AbsListViewCompat.this.f9478f && AbsListViewCompat.this.f9473a != null && AbsListViewCompat.this.f9474b != (c = AbsListViewCompat.this.m8221b())) {
                    int unused = AbsListViewCompat.this.f9474b = c;
                    int i4 = 0;
                    View childAt = AbsListViewCompat.this.f9477e.getChildAt(0);
                    int i5 = 2;
                    int[] iArr = new int[2];
                    if (childAt != null) {
                        childAt.getLocationOnScreen(iArr);
                    }
                    int i6 = 1;
                    if (i != AbsListViewCompat.this.f9475c) {
                        if (i > AbsListViewCompat.this.f9475c) {
                            i4 = 1;
                        } else if (i < AbsListViewCompat.this.f9475c) {
                            i4 = 2;
                        }
                        int unused2 = AbsListViewCompat.this.f9475c = i;
                        int unused3 = AbsListViewCompat.this.f9476d = iArr[1];
                    } else {
                        if (AbsListViewCompat.this.f9476d > iArr[1]) {
                            i4 = 1;
                        } else {
                            if (AbsListViewCompat.this.f9476d < iArr[1]) {
                                i4 = 2;
                            }
                            int unused4 = AbsListViewCompat.this.f9476d = iArr[1];
                            i6 = i5;
                        }
                        i5 = 1;
                        int unused5 = AbsListViewCompat.this.f9476d = iArr[1];
                        i6 = i5;
                    }
                    AbsListViewCompat.this.f9473a.onScrollChanged(i6, i4, AbsListViewCompat.this.m8224c());
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public int m8221b() {
        View childAt = this.f9477e.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return -(childAt.getTop() + this.f9477e.getPaddingTop());
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public int m8224c() {
        View childAt;
        if (this.f9477e.getLastVisiblePosition() == this.f9477e.getCount() - 1) {
            T t = this.f9477e;
            if (t.getChildAt(t.getChildCount() - 1).getBottom() + this.f9477e.getPaddingBottom() == this.f9477e.getBottom()) {
                return 2;
            }
        }
        if (this.f9477e.getFirstVisiblePosition() == 0 && (childAt = this.f9477e.getChildAt(0)) != null && childAt.getTop() == this.f9477e.getPaddingTop()) {
            return 1;
        }
        return 0;
    }
}
