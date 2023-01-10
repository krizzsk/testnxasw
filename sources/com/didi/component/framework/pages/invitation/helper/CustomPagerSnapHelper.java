package com.didi.component.framework.pages.invitation.helper;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.component.business.util.UiUtils;
import com.didi.sdk.util.ResourcesHelper;
import com.didichuxing.drtl.tookit.DRtlToolkit;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u000234B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0019J\u0012\u0010&\u001a\u00020$2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u001a\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0015H\u0016J\u0010\u0010.\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u0015H\u0002J\u0012\u0010/\u001a\u00020$2\b\u0010+\u001a\u0004\u0018\u00010,H\u0002J\u001a\u00100\u001a\u0004\u0018\u00010\u00152\u0006\u0010+\u001a\u00020,2\u0006\u00101\u001a\u00020\u0017H\u0002J\u0010\u00102\u001a\u00020$2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\f\"\u0004\b\u001c\u0010\u000eR\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0007¨\u00065"}, mo148868d2 = {"Lcom/didi/component/framework/pages/invitation/helper/CustomPagerSnapHelper;", "Landroidx/recyclerview/widget/PagerSnapHelper;", "windowWidth", "", "(I)V", "dotColor", "getDotColor", "()I", "setDotColor", "dotGap", "", "getDotGap", "()F", "setDotGap", "(F)V", "dotRadius", "getDotRadius", "setDotRadius", "isScrollerByUser", "", "lastView", "Landroid/view/View;", "mHorizontalHelper", "Landroidx/recyclerview/widget/OrientationHelper;", "mTrackEventListener", "Lcom/didi/component/framework/pages/invitation/helper/CustomPagerSnapHelper$TrackEventListener;", "offSetHeight", "getOffSetHeight", "setOffSetHeight", "paint", "Landroid/graphics/Paint;", "selectedColor", "getSelectedColor", "setSelectedColor", "getWindowWidth", "addTrackEventListener", "", "listener", "attachToRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "calculateDistanceToFinalSnap", "", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "targetView", "calculateRightMargin", "createOrientalHelper", "findCenterView", "helper", "initPaint", "IndicatorDecoration", "TrackEventListener", "framework_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: CustomPagerSnapHelper.kt */
public final class CustomPagerSnapHelper extends PagerSnapHelper {

    /* renamed from: a */
    private final int f15717a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public OrientationHelper f15718b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Paint f15719c = new Paint();

    /* renamed from: d */
    private boolean f15720d;

    /* renamed from: e */
    private TrackEventListener f15721e;

    /* renamed from: f */
    private View f15722f;

    /* renamed from: g */
    private float f15723g = 4.0f;

    /* renamed from: h */
    private int f15724h = R.color.g_color_D8D8D8;

    /* renamed from: i */
    private int f15725i = -16777216;

    /* renamed from: j */
    private float f15726j = 10.0f;

    /* renamed from: k */
    private float f15727k = 28.0f;

    @Metadata(mo148867d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, mo148868d2 = {"Lcom/didi/component/framework/pages/invitation/helper/CustomPagerSnapHelper$TrackEventListener;", "", "trackEvent", "", "framework_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: CustomPagerSnapHelper.kt */
    public interface TrackEventListener {
        void trackEvent();
    }

    public CustomPagerSnapHelper(int i) {
        this.f15717a = i;
    }

    public final int getWindowWidth() {
        return this.f15717a;
    }

    public final float getDotRadius() {
        return this.f15723g;
    }

    public final void setDotRadius(float f) {
        this.f15723g = f;
    }

    public final int getDotColor() {
        return this.f15724h;
    }

    public final void setDotColor(int i) {
        this.f15724h = i;
    }

    public final int getSelectedColor() {
        return this.f15725i;
    }

    public final void setSelectedColor(int i) {
        this.f15725i = i;
    }

    public final float getDotGap() {
        return this.f15726j;
    }

    public final void setDotGap(float f) {
        this.f15726j = f;
    }

    public final float getOffSetHeight() {
        return this.f15727k;
    }

    public final void setOffSetHeight(float f) {
        this.f15727k = f;
    }

    public void attachToRecyclerView(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager;
        super.attachToRecyclerView(recyclerView);
        m13030a(this.f15719c);
        if (recyclerView != null) {
            recyclerView.setClipToPadding(false);
        }
        if (recyclerView == null) {
            layoutManager = null;
        } else {
            layoutManager = recyclerView.getLayoutManager();
        }
        m13031a(layoutManager);
        IndicatorDecoration indicatorDecoration = new IndicatorDecoration(this);
        if (recyclerView != null) {
            recyclerView.addItemDecoration(indicatorDecoration);
        }
    }

    public int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager layoutManager, View view) {
        Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
        Intrinsics.checkNotNullParameter(view, "targetView");
        int position = layoutManager.getPosition(view);
        if (position > 0 && position == layoutManager.getItemCount() - 1) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                ((RecyclerView.LayoutParams) layoutParams).rightMargin = m13028a(view);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            }
        }
        if (!this.f15720d) {
            this.f15720d = true;
            this.f15722f = view;
        } else if (!Intrinsics.areEqual((Object) view, (Object) this.f15722f)) {
            TrackEventListener trackEventListener = this.f15721e;
            if (trackEventListener != null) {
                trackEventListener.trackEvent();
            }
            this.f15722f = view;
        }
        return super.calculateDistanceToFinalSnap(layoutManager, view);
    }

    @Metadata(mo148867d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002J(\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J \u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¨\u0006\u0016"}, mo148868d2 = {"Lcom/didi/component/framework/pages/invitation/helper/CustomPagerSnapHelper$IndicatorDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "(Lcom/didi/component/framework/pages/invitation/helper/CustomPagerSnapHelper;)V", "drawIndicatorDot", "", "canvas", "Landroid/graphics/Canvas;", "startX", "", "startY", "radius", "getItemOffsets", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onDraw", "c", "framework_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: CustomPagerSnapHelper.kt */
    public final class IndicatorDecoration extends RecyclerView.ItemDecoration {
        final /* synthetic */ CustomPagerSnapHelper this$0;

        public IndicatorDecoration(CustomPagerSnapHelper customPagerSnapHelper) {
            Intrinsics.checkNotNullParameter(customPagerSnapHelper, "this$0");
            this.this$0 = customPagerSnapHelper;
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(rect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(recyclerView, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            super.getItemOffsets(rect, view, recyclerView, state);
            rect.bottom = UiUtils.dip2px(view.getContext(), this.this$0.getOffSetHeight());
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
            float f;
            Intrinsics.checkNotNullParameter(canvas, "c");
            Intrinsics.checkNotNullParameter(recyclerView, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            super.onDrawOver(canvas, recyclerView, state);
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            int i = 0;
            int itemCount = layoutManager == null ? 0 : layoutManager.getItemCount();
            if (itemCount > 1) {
                if (!(this.this$0.getOffSetHeight() == 0.0f)) {
                    this.this$0.f15719c.setColor(ResourcesHelper.getColor(recyclerView.getContext(), this.this$0.getDotColor()));
                    float dip2px = (float) UiUtils.dip2px(recyclerView.getContext(), this.this$0.getDotRadius());
                    float f2 = (float) 2;
                    float dip2px2 = (float) UiUtils.dip2px(recyclerView.getContext(), this.this$0.getDotGap());
                    float f3 = (dip2px * f2) + dip2px2;
                    float f4 = (((float) itemCount) * f3) - dip2px2;
                    if (DRtlToolkit.rtl()) {
                        f = ((((float) this.this$0.getWindowWidth()) + f4) / 2.0f) - dip2px;
                    } else {
                        f = ((((float) this.this$0.getWindowWidth()) - f4) / 2.0f) + dip2px;
                    }
                    float height = (float) (recyclerView.getHeight() - UiUtils.dip2px(recyclerView.getContext(), this.this$0.getOffSetHeight() / f2));
                    if (itemCount > 0) {
                        float f5 = f;
                        do {
                            i++;
                            drawIndicatorDot(canvas, f5, height, dip2px);
                            if (DRtlToolkit.rtl()) {
                                f5 -= f3;
                                continue;
                            } else {
                                f5 += f3;
                                continue;
                            }
                        } while (i < itemCount);
                    }
                    CustomPagerSnapHelper customPagerSnapHelper = this.this$0;
                    RecyclerView.LayoutManager layoutManager2 = recyclerView.getLayoutManager();
                    Intrinsics.checkNotNull(layoutManager2);
                    Intrinsics.checkNotNullExpressionValue(layoutManager2, "parent.layoutManager!!");
                    OrientationHelper access$getMHorizontalHelper$p = this.this$0.f15718b;
                    Intrinsics.checkNotNull(access$getMHorizontalHelper$p);
                    View access$findCenterView = customPagerSnapHelper.m13029a(layoutManager2, access$getMHorizontalHelper$p);
                    if (access$findCenterView != null) {
                        RecyclerView.LayoutManager layoutManager3 = recyclerView.getLayoutManager();
                        Intrinsics.checkNotNull(layoutManager3);
                        int position = layoutManager3.getPosition(access$findCenterView);
                        this.this$0.f15719c.setColor(this.this$0.getSelectedColor());
                        drawIndicatorDot(canvas, DRtlToolkit.rtl() ? f - (((float) position) * f3) : f + (((float) position) * f3), height, dip2px);
                    }
                }
            }
        }

        private final void drawIndicatorDot(Canvas canvas, float f, float f2, float f3) {
            canvas.drawCircle(f, f2, f3, this.this$0.f15719c);
        }
    }

    /* renamed from: a */
    private final void m13031a(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.f15718b;
        if (orientationHelper != null) {
            Intrinsics.checkNotNull(orientationHelper);
            if (Intrinsics.areEqual((Object) orientationHelper.getLayoutManager(), (Object) layoutManager)) {
                return;
            }
        }
        this.f15718b = OrientationHelper.createHorizontalHelper(layoutManager);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final View m13029a(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
        int i;
        int childCount = layoutManager.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        if (layoutManager.getClipToPadding()) {
            i = orientationHelper.getStartAfterPadding() + (orientationHelper.getTotalSpace() / 2);
        } else {
            i = orientationHelper.getEnd() / 2;
        }
        int i2 = Integer.MAX_VALUE;
        int i3 = 0;
        if (childCount > 0) {
            while (true) {
                int i4 = i3 + 1;
                View childAt = layoutManager.getChildAt(i3);
                int abs = Math.abs((orientationHelper.getDecoratedStart(childAt) + (orientationHelper.getDecoratedMeasurement(childAt) / 2)) - i);
                if (abs < i2) {
                    view = childAt;
                    i2 = abs;
                }
                if (i4 >= childCount) {
                    break;
                }
                i3 = i4;
            }
        }
        return view;
    }

    /* renamed from: a */
    private final void m13030a(Paint paint) {
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
    }

    /* renamed from: a */
    private final int m13028a(View view) {
        return (this.f15717a - view.getWidth()) / 2;
    }

    public final void addTrackEventListener(TrackEventListener trackEventListener) {
        Intrinsics.checkNotNullParameter(trackEventListener, "listener");
        this.f15721e = trackEventListener;
    }
}
