package com.didi.global.xbanner.view.recycler;

import android.view.View;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

public class XBannerPagerSnapHelper extends PagerSnapHelper {

    /* renamed from: a */
    private OrientationHelper f24875a;

    /* renamed from: b */
    private OrientationHelper f24876b;

    public int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager layoutManager, View view) {
        return new int[]{m19952a(view, m19953a(layoutManager)), 0};
    }

    /* renamed from: a */
    private int m19952a(View view, OrientationHelper orientationHelper) {
        return orientationHelper.getDecoratedStart(view) - orientationHelper.getStartAfterPadding();
    }

    /* renamed from: a */
    private OrientationHelper m19953a(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.f24876b;
        if (orientationHelper == null || orientationHelper.getLayoutManager() != layoutManager) {
            this.f24876b = OrientationHelper.createHorizontalHelper(layoutManager);
        }
        return this.f24876b;
    }
}
