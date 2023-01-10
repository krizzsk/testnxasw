package com.didiglobal.dittoview.view.recyclerview;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

public class StartSnapHelper extends PagerSnapHelper {

    /* renamed from: a */
    private String f52581a = "StartSnapHelper";

    /* renamed from: b */
    private OrientationHelper f52582b;

    /* renamed from: c */
    private OrientationHelper f52583c;

    public void attachToRecyclerView(RecyclerView recyclerView) throws IllegalStateException {
        super.attachToRecyclerView(recyclerView);
    }

    public int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager layoutManager, View view) {
        int[] iArr = new int[2];
        if (layoutManager.canScrollHorizontally()) {
            iArr[0] = m39463a(view, m39466b(layoutManager));
        } else {
            iArr[0] = 0;
        }
        if (layoutManager.canScrollVertically()) {
            iArr[1] = m39463a(view, m39465a(layoutManager));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        if (!(layoutManager instanceof LinearLayoutManager)) {
            return super.findSnapView(layoutManager);
        }
        if (layoutManager.canScrollHorizontally()) {
            return m39464a(layoutManager, m39466b(layoutManager));
        }
        return m39464a(layoutManager, m39465a(layoutManager));
    }

    /* renamed from: a */
    private int m39463a(View view, OrientationHelper orientationHelper) {
        return orientationHelper.getDecoratedStart(view) - orientationHelper.getStartAfterPadding();
    }

    /* renamed from: a */
    private View m39464a(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
        if (!(layoutManager instanceof LinearLayoutManager)) {
            return super.findSnapView(layoutManager);
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        boolean z = linearLayoutManager.findLastCompletelyVisibleItemPosition() == layoutManager.getItemCount() - 1;
        if (findFirstVisibleItemPosition == -1 || z) {
            return null;
        }
        View findViewByPosition = layoutManager.findViewByPosition(findFirstVisibleItemPosition);
        if (orientationHelper.getDecoratedEnd(findViewByPosition) >= orientationHelper.getDecoratedMeasurement(findViewByPosition) / 2 && orientationHelper.getDecoratedEnd(findViewByPosition) > 0) {
            return findViewByPosition;
        }
        if (linearLayoutManager.findLastCompletelyVisibleItemPosition() == layoutManager.getItemCount() - 1) {
            return null;
        }
        return layoutManager.findViewByPosition(findFirstVisibleItemPosition + 1);
    }

    public boolean onFling(int i, int i2) {
        return super.onFling(i, i2);
    }

    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i, int i2) {
        return super.findTargetSnapPosition(layoutManager, i, i2);
    }

    /* renamed from: a */
    private OrientationHelper m39465a(RecyclerView.LayoutManager layoutManager) {
        if (this.f52582b == null) {
            this.f52582b = OrientationHelper.createVerticalHelper(layoutManager);
        }
        return this.f52582b;
    }

    /* renamed from: b */
    private OrientationHelper m39466b(RecyclerView.LayoutManager layoutManager) {
        if (this.f52583c == null) {
            this.f52583c = OrientationHelper.createHorizontalHelper(layoutManager);
        }
        return this.f52583c;
    }
}
