package com.didi.payment.commonsdk.view.helper;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.core.text.TextUtilsCompat;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Locale;

public class GravitySnapHelper extends LinearSnapHelper {
    public static final int FLING_DISTANCE_DISABLE = -1;
    public static final float FLING_SIZE_FRACTION_DISABLE = -1.0f;

    /* renamed from: a */
    private int f32681a;

    /* renamed from: b */
    private boolean f32682b;

    /* renamed from: c */
    private boolean f32683c;

    /* renamed from: d */
    private int f32684d;

    /* renamed from: e */
    private boolean f32685e;

    /* renamed from: f */
    private boolean f32686f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public float f32687g;

    /* renamed from: h */
    private int f32688h;

    /* renamed from: i */
    private float f32689i;

    /* renamed from: j */
    private OrientationHelper f32690j;

    /* renamed from: k */
    private OrientationHelper f32691k;

    /* renamed from: l */
    private SnapListener f32692l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public RecyclerView f32693m;

    /* renamed from: n */
    private RecyclerView.OnScrollListener f32694n;

    public interface SnapListener {
        void onSnap(int i);
    }

    public GravitySnapHelper(int i) {
        this(i, false, (SnapListener) null);
    }

    public GravitySnapHelper(int i, SnapListener snapListener) {
        this(i, false, snapListener);
    }

    public GravitySnapHelper(int i, boolean z) {
        this(i, z, (SnapListener) null);
    }

    public GravitySnapHelper(int i, boolean z, SnapListener snapListener) {
        this.f32685e = false;
        this.f32686f = false;
        this.f32687g = 100.0f;
        this.f32688h = -1;
        this.f32689i = -1.0f;
        this.f32694n = new RecyclerView.OnScrollListener() {
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                GravitySnapHelper.this.m24752a(i);
            }
        };
        if (i == 8388611 || i == 8388613 || i == 80 || i == 48 || i == 17) {
            this.f32683c = z;
            this.f32681a = i;
            this.f32692l = snapListener;
            return;
        }
        throw new IllegalArgumentException("Invalid gravity value. Use START | END | BOTTOM | TOP | CENTER constants");
    }

    public void attachToRecyclerView(RecyclerView recyclerView) throws IllegalStateException {
        RecyclerView recyclerView2 = this.f32693m;
        if (recyclerView2 != null) {
            recyclerView2.removeOnScrollListener(this.f32694n);
        }
        if (recyclerView != null) {
            recyclerView.setOnFlingListener((RecyclerView.OnFlingListener) null);
            int i = this.f32681a;
            if (i == 8388611 || i == 8388613) {
                boolean z = true;
                if (TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) != 1) {
                    z = false;
                }
                this.f32682b = z;
            }
            recyclerView.addOnScrollListener(this.f32694n);
            this.f32693m = recyclerView;
        } else {
            this.f32693m = null;
        }
        super.attachToRecyclerView(recyclerView);
    }

    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        return findSnapView(layoutManager, true);
    }

    public View findSnapView(RecyclerView.LayoutManager layoutManager, boolean z) {
        View view;
        int i = this.f32681a;
        if (i != 17) {
            if (i == 48) {
                view = m24749a(layoutManager, m24750a(layoutManager), GravityCompat.START, z);
            } else if (i == 80) {
                view = m24749a(layoutManager, m24750a(layoutManager), GravityCompat.END, z);
            } else if (i == 8388611) {
                view = m24749a(layoutManager, m24758b(layoutManager), GravityCompat.START, z);
            } else if (i != 8388613) {
                view = null;
            } else {
                view = m24749a(layoutManager, m24758b(layoutManager), GravityCompat.END, z);
            }
        } else if (layoutManager.canScrollHorizontally()) {
            view = m24749a(layoutManager, m24758b(layoutManager), 17, z);
        } else {
            view = m24749a(layoutManager, m24750a(layoutManager), 17, z);
        }
        if (view != null) {
            this.f32684d = this.f32693m.getChildAdapterPosition(view);
        } else {
            this.f32684d = -1;
        }
        return view;
    }

    public int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager layoutManager, View view) {
        if (this.f32681a == 17) {
            return super.calculateDistanceToFinalSnap(layoutManager, view);
        }
        int[] iArr = new int[2];
        if (!(layoutManager instanceof LinearLayoutManager)) {
            return iArr;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        if (linearLayoutManager.canScrollHorizontally()) {
            if ((!this.f32682b || this.f32681a != 8388613) && (this.f32682b || this.f32681a != 8388611)) {
                iArr[0] = m24757b(view, m24758b((RecyclerView.LayoutManager) linearLayoutManager));
            } else {
                iArr[0] = m24748a(view, m24758b((RecyclerView.LayoutManager) linearLayoutManager));
            }
        } else if (linearLayoutManager.canScrollVertically()) {
            if (this.f32681a == 48) {
                iArr[1] = m24748a(view, m24750a((RecyclerView.LayoutManager) linearLayoutManager));
            } else {
                iArr[1] = m24757b(view, m24750a((RecyclerView.LayoutManager) linearLayoutManager));
            }
        }
        return iArr;
    }

    public int[] calculateScrollDistance(int i, int i2) {
        if (this.f32693m == null || ((this.f32690j == null && this.f32691k == null) || (this.f32688h == -1 && this.f32689i == -1.0f))) {
            return super.calculateScrollDistance(i, i2);
        }
        Scroller scroller = new Scroller(this.f32693m.getContext(), new DecelerateInterpolator());
        int a = m24747a();
        int i3 = -a;
        scroller.fling(0, 0, i, i2, i3, a, i3, a);
        return new int[]{scroller.getFinalX(), scroller.getFinalY()};
    }

    public RecyclerView.SmoothScroller createScroller(RecyclerView.LayoutManager layoutManager) {
        RecyclerView recyclerView;
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (recyclerView = this.f32693m) == null) {
            return null;
        }
        return new LinearSmoothScroller(recyclerView.getContext()) {
            /* access modifiers changed from: protected */
            public void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
                if (GravitySnapHelper.this.f32693m != null && GravitySnapHelper.this.f32693m.getLayoutManager() != null) {
                    GravitySnapHelper gravitySnapHelper = GravitySnapHelper.this;
                    int[] calculateDistanceToFinalSnap = gravitySnapHelper.calculateDistanceToFinalSnap(gravitySnapHelper.f32693m.getLayoutManager(), view);
                    int i = calculateDistanceToFinalSnap[0];
                    int i2 = calculateDistanceToFinalSnap[1];
                    int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(i2)));
                    if (calculateTimeForDeceleration > 0) {
                        action.update(i, i2, calculateTimeForDeceleration, this.mDecelerateInterpolator);
                    }
                }
            }

            /* access modifiers changed from: protected */
            public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return GravitySnapHelper.this.f32687g / ((float) displayMetrics.densityDpi);
            }
        };
    }

    public void setSnapListener(SnapListener snapListener) {
        this.f32692l = snapListener;
    }

    public void setGravity(int i, Boolean bool) {
        if (this.f32681a != i) {
            this.f32681a = i;
            updateSnap(bool, false);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000b, code lost:
        r0 = r2.f32693m.getLayoutManager();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateSnap(java.lang.Boolean r3, java.lang.Boolean r4) {
        /*
            r2 = this;
            androidx.recyclerview.widget.RecyclerView r0 = r2.f32693m
            if (r0 == 0) goto L_0x003a
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r0.getLayoutManager()
            if (r0 != 0) goto L_0x000b
            goto L_0x003a
        L_0x000b:
            androidx.recyclerview.widget.RecyclerView r0 = r2.f32693m
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r0.getLayoutManager()
            boolean r4 = r4.booleanValue()
            android.view.View r4 = r2.findSnapView(r0, r4)
            if (r4 == 0) goto L_0x003a
            int[] r4 = r2.calculateDistanceToFinalSnap(r0, r4)
            boolean r3 = r3.booleanValue()
            r0 = 1
            r1 = 0
            if (r3 == 0) goto L_0x0031
            androidx.recyclerview.widget.RecyclerView r3 = r2.f32693m
            r1 = r4[r1]
            r4 = r4[r0]
            r3.smoothScrollBy(r1, r4)
            goto L_0x003a
        L_0x0031:
            androidx.recyclerview.widget.RecyclerView r3 = r2.f32693m
            r1 = r4[r1]
            r4 = r4[r0]
            r3.scrollBy(r1, r4)
        L_0x003a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.commonsdk.view.helper.GravitySnapHelper.updateSnap(java.lang.Boolean, java.lang.Boolean):void");
    }

    public boolean scrollToPosition(int i) {
        if (i == -1) {
            return false;
        }
        return m24754a(i, false);
    }

    public boolean smoothScrollToPosition(int i) {
        if (i == -1) {
            return false;
        }
        return m24754a(i, true);
    }

    public int getGravity() {
        return this.f32681a;
    }

    public void setGravity(int i) {
        setGravity(i, true);
    }

    public boolean getSnapLastItem() {
        return this.f32683c;
    }

    public void setSnapLastItem(boolean z) {
        this.f32683c = z;
    }

    public int getMaxFlingDistance() {
        return this.f32688h;
    }

    public void setMaxFlingDistance(int i) {
        this.f32688h = i;
        this.f32689i = -1.0f;
    }

    public float getMaxFlingSizeFraction() {
        return this.f32689i;
    }

    public void setMaxFlingSizeFraction(float f) {
        this.f32688h = -1;
        this.f32689i = f;
    }

    public float getScrollMsPerInch() {
        return this.f32687g;
    }

    public void setScrollMsPerInch(float f) {
        this.f32687g = f;
    }

    public boolean getSnapToPadding() {
        return this.f32686f;
    }

    public void setSnapToPadding(boolean z) {
        this.f32686f = z;
    }

    public int getCurrentSnappedPosition() {
        View findSnapView;
        RecyclerView recyclerView = this.f32693m;
        if (recyclerView == null || recyclerView.getLayoutManager() == null || (findSnapView = findSnapView(this.f32693m.getLayoutManager())) == null) {
            return -1;
        }
        return this.f32693m.getChildAdapterPosition(findSnapView);
    }

    /* renamed from: a */
    private int m24747a() {
        float width;
        float f;
        if (this.f32689i != -1.0f) {
            if (this.f32690j != null) {
                width = (float) this.f32693m.getHeight();
                f = this.f32689i;
            } else if (this.f32691k == null) {
                return Integer.MAX_VALUE;
            } else {
                width = (float) this.f32693m.getWidth();
                f = this.f32689i;
            }
            return (int) (width * f);
        }
        int i = this.f32688h;
        if (i != -1) {
            return i;
        }
        return Integer.MAX_VALUE;
    }

    /* renamed from: a */
    private boolean m24754a(int i, boolean z) {
        if (this.f32693m.getLayoutManager() != null) {
            if (z) {
                RecyclerView.SmoothScroller createScroller = createScroller(this.f32693m.getLayoutManager());
                if (createScroller != null) {
                    createScroller.setTargetPosition(i);
                    this.f32693m.getLayoutManager().startSmoothScroll(createScroller);
                    return true;
                }
            } else {
                RecyclerView.ViewHolder findViewHolderForAdapterPosition = this.f32693m.findViewHolderForAdapterPosition(i);
                if (findViewHolderForAdapterPosition != null) {
                    int[] calculateDistanceToFinalSnap = calculateDistanceToFinalSnap(this.f32693m.getLayoutManager(), findViewHolderForAdapterPosition.itemView);
                    this.f32693m.scrollBy(calculateDistanceToFinalSnap[0], calculateDistanceToFinalSnap[1]);
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    private int m24748a(View view, OrientationHelper orientationHelper) {
        int i;
        int i2;
        if (!this.f32686f) {
            i2 = orientationHelper.getDecoratedStart(view);
            if (i2 < orientationHelper.getStartAfterPadding() / 2) {
                return i2;
            }
            i = orientationHelper.getStartAfterPadding();
        } else {
            i2 = orientationHelper.getDecoratedStart(view);
            i = orientationHelper.getStartAfterPadding();
        }
        return i2 - i;
    }

    /* renamed from: b */
    private int m24757b(View view, OrientationHelper orientationHelper) {
        int i;
        int i2;
        if (!this.f32686f) {
            int decoratedEnd = orientationHelper.getDecoratedEnd(view);
            if (decoratedEnd < orientationHelper.getEnd() - ((orientationHelper.getEnd() - orientationHelper.getEndAfterPadding()) / 2)) {
                return decoratedEnd - orientationHelper.getEndAfterPadding();
            }
            i2 = orientationHelper.getDecoratedEnd(view);
            i = orientationHelper.getEnd();
        } else {
            i2 = orientationHelper.getDecoratedEnd(view);
            i = orientationHelper.getEndAfterPadding();
        }
        return i2 - i;
    }

    /* renamed from: a */
    private View m24749a(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper, int i, boolean z) {
        int i2;
        int i3;
        View view = null;
        if (layoutManager.getChildCount() != 0 && (layoutManager instanceof LinearLayoutManager)) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            if (z && m24755a(linearLayoutManager) && !this.f32683c) {
                return null;
            }
            int i4 = Integer.MAX_VALUE;
            if (layoutManager.getClipToPadding()) {
                i2 = orientationHelper.getStartAfterPadding() + (orientationHelper.getTotalSpace() / 2);
            } else {
                i2 = orientationHelper.getEnd() / 2;
            }
            boolean z2 = true;
            boolean z3 = (i == 8388611 && !this.f32682b) || (i == 8388613 && this.f32682b);
            if ((i != 8388611 || !this.f32682b) && (i != 8388613 || this.f32682b)) {
                z2 = false;
            }
            for (int i5 = 0; i5 < linearLayoutManager.getChildCount(); i5++) {
                View childAt = linearLayoutManager.getChildAt(i5);
                if (z3) {
                    if (!this.f32686f) {
                        i3 = Math.abs(orientationHelper.getDecoratedStart(childAt));
                    } else {
                        i3 = Math.abs(orientationHelper.getStartAfterPadding() - orientationHelper.getDecoratedStart(childAt));
                    }
                } else if (!z2) {
                    i3 = Math.abs((orientationHelper.getDecoratedStart(childAt) + (orientationHelper.getDecoratedMeasurement(childAt) / 2)) - i2);
                } else if (!this.f32686f) {
                    i3 = Math.abs(orientationHelper.getDecoratedEnd(childAt) - orientationHelper.getEnd());
                } else {
                    i3 = Math.abs(orientationHelper.getEndAfterPadding() - orientationHelper.getDecoratedEnd(childAt));
                }
                if (i3 < i4) {
                    view = childAt;
                    i4 = i3;
                }
            }
        }
        return view;
    }

    /* renamed from: a */
    private boolean m24755a(LinearLayoutManager linearLayoutManager) {
        if ((linearLayoutManager.getReverseLayout() || this.f32681a != 8388611) && ((!linearLayoutManager.getReverseLayout() || this.f32681a != 8388613) && ((linearLayoutManager.getReverseLayout() || this.f32681a != 48) && (!linearLayoutManager.getReverseLayout() || this.f32681a != 80)))) {
            if (this.f32681a == 17) {
                if (linearLayoutManager.findFirstCompletelyVisibleItemPosition() == 0 || linearLayoutManager.findLastCompletelyVisibleItemPosition() == linearLayoutManager.getItemCount() - 1) {
                    return true;
                }
                return false;
            } else if (linearLayoutManager.findFirstCompletelyVisibleItemPosition() == 0) {
                return true;
            } else {
                return false;
            }
        } else if (linearLayoutManager.findLastCompletelyVisibleItemPosition() == linearLayoutManager.getItemCount() - 1) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m24752a(int i) {
        SnapListener snapListener;
        if (i == 0 && (snapListener = this.f32692l) != null && this.f32685e) {
            int i2 = this.f32684d;
            if (i2 != -1) {
                snapListener.onSnap(i2);
            } else {
                m24759b();
            }
        }
        this.f32685e = i != 0;
    }

    /* renamed from: b */
    private void m24759b() {
        View findSnapView;
        int childAdapterPosition;
        RecyclerView.LayoutManager layoutManager = this.f32693m.getLayoutManager();
        if (layoutManager != null && (findSnapView = findSnapView(layoutManager, false)) != null && (childAdapterPosition = this.f32693m.getChildAdapterPosition(findSnapView)) != -1) {
            this.f32692l.onSnap(childAdapterPosition);
        }
    }

    /* renamed from: a */
    private OrientationHelper m24750a(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.f32690j;
        if (orientationHelper == null || orientationHelper.getLayoutManager() != layoutManager) {
            this.f32690j = OrientationHelper.createVerticalHelper(layoutManager);
        }
        return this.f32690j;
    }

    /* renamed from: b */
    private OrientationHelper m24758b(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.f32691k;
        if (orientationHelper == null || orientationHelper.getLayoutManager() != layoutManager) {
            this.f32691k = OrientationHelper.createHorizontalHelper(layoutManager);
        }
        return this.f32691k;
    }
}
