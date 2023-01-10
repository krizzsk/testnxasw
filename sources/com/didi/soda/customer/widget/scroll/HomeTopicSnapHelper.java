package com.didi.soda.customer.widget.scroll;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.nova.assembly.p128ui.banner.OnBannerClickListener;

public class HomeTopicSnapHelper extends LinearSnapHelper {

    /* renamed from: a */
    private final OnBannerClickListener f44721a;

    /* renamed from: b */
    private OrientationHelper f44722b;

    /* renamed from: c */
    private OrientationHelper f44723c;

    /* renamed from: d */
    private Context f44724d;

    public HomeTopicSnapHelper(OnBannerClickListener onBannerClickListener) {
        this.f44721a = onBannerClickListener;
    }

    public void attachToRecyclerView(RecyclerView recyclerView) throws IllegalStateException {
        super.attachToRecyclerView(recyclerView);
        this.f44724d = recyclerView.getContext();
    }

    public int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager layoutManager, View view) {
        int[] iArr = new int[2];
        boolean z = ((LinearLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition() == layoutManager.getItemCount() - 1;
        if (this.f44721a != null) {
            int viewAdapterPosition = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewAdapterPosition();
            if (z) {
                viewAdapterPosition = layoutManager.getItemCount() - 1;
            }
            this.f44721a.onBannerPageSelected(viewAdapterPosition);
        }
        if (z) {
            return iArr;
        }
        if (layoutManager.canScrollHorizontally()) {
            iArr[0] = m33184a(view, m33186b(layoutManager));
        } else {
            iArr[0] = 0;
        }
        if (layoutManager.canScrollVertically()) {
            iArr[1] = m33184a(view, m33187c(layoutManager));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof LinearLayoutManager) {
            return m33185a(layoutManager);
        }
        return super.findSnapView(layoutManager);
    }

    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i, int i2) {
        int position;
        int itemCount = layoutManager.getItemCount();
        if (itemCount == 0) {
            return -1;
        }
        View view = null;
        if (layoutManager.canScrollHorizontally()) {
            view = m33185a(layoutManager);
        }
        if (view == null || (position = layoutManager.getPosition(view)) == -1) {
            return -1;
        }
        boolean z = true;
        boolean z2 = !layoutManager.canScrollHorizontally() ? i2 > 0 : i > 0;
        OrientationHelper b = m33186b(layoutManager);
        if (b.getDecoratedEnd(view) < (b.getDecoratedMeasurement(view) * 4) / 5) {
            z = false;
        }
        if (z2) {
            return position + 2;
        }
        return (z || itemCount % 2 == 0 || position != itemCount + -3) ? position - 2 : position;
    }

    /* access modifiers changed from: protected */
    public RecyclerView.SmoothScroller createScroller(final RecyclerView.LayoutManager layoutManager) {
        return new LinearSmoothScroller(this.f44724d) {
            /* access modifiers changed from: protected */
            public void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
                int[] calculateDistanceToFinalSnap = HomeTopicSnapHelper.this.calculateDistanceToFinalSnap(layoutManager, view);
                int i = calculateDistanceToFinalSnap[0];
                int i2 = calculateDistanceToFinalSnap[1];
                int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(i2)));
                if (calculateTimeForDeceleration > 0) {
                    action.update(i, i2, calculateTimeForDeceleration, this.mDecelerateInterpolator);
                }
            }

            /* access modifiers changed from: protected */
            public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return 50.0f / ((float) displayMetrics.densityDpi);
            }
        };
    }

    /* renamed from: a */
    private int m33184a(View view, OrientationHelper orientationHelper) {
        return orientationHelper.getDecoratedStart(view) - orientationHelper.getStartAfterPadding();
    }

    /* renamed from: a */
    private View m33185a(RecyclerView.LayoutManager layoutManager) {
        if (!(layoutManager instanceof LinearLayoutManager)) {
            return super.findSnapView(layoutManager);
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        if (linearLayoutManager.findLastCompletelyVisibleItemPosition() == layoutManager.getItemCount() - 1) {
            return layoutManager.findViewByPosition(layoutManager.getItemCount() - 1);
        }
        if (findFirstVisibleItemPosition == -1) {
            return null;
        }
        View findViewByPosition = layoutManager.findViewByPosition(findFirstVisibleItemPosition);
        if (findFirstVisibleItemPosition % 2 == 0) {
            return findViewByPosition;
        }
        if (linearLayoutManager.findLastCompletelyVisibleItemPosition() == layoutManager.getItemCount() - 1) {
            return null;
        }
        return layoutManager.findViewByPosition(findFirstVisibleItemPosition + 1);
    }

    /* renamed from: b */
    private OrientationHelper m33186b(RecyclerView.LayoutManager layoutManager) {
        if (this.f44722b == null) {
            this.f44722b = OrientationHelper.createHorizontalHelper(layoutManager);
        }
        return this.f44722b;
    }

    /* renamed from: c */
    private OrientationHelper m33187c(RecyclerView.LayoutManager layoutManager) {
        if (this.f44723c == null) {
            this.f44723c = OrientationHelper.createVerticalHelper(layoutManager);
        }
        return this.f44723c;
    }
}
