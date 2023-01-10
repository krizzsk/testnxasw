package com.didi.soda.home.topgun.widget.floatlayout;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.CustomerExtentionKt;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.ViewSafeHelper;
import com.didi.soda.home.shimmer.ShimmerRecyclerView;
import com.didi.soda.home.shimmer.ShimmerViewType;
import com.taxis99.R;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(mo148867d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u000267B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u000b\u001a\u00020&J\u000e\u0010'\u001a\u00020&2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010(\u001a\u00020&J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*H\u0002J\u0006\u0010,\u001a\u00020\u0007J\u0010\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020*H\u0002J\u0006\u0010/\u001a\u00020\u0007J\u0016\u00100\u001a\u00020&2\u0006\u00101\u001a\u00020\u00152\u0006\u0010+\u001a\u00020*J\u0006\u00102\u001a\u00020&J\u0006\u00103\u001a\u00020&J\u000e\u00104\u001a\u00020&2\u0006\u00105\u001a\u00020\fR\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0004¢\u0006\u0002\n\u0000¨\u00068"}, mo148868d2 = {"Lcom/didi/soda/home/topgun/widget/floatlayout/FloatLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "acceptScroll", "", "argbEvaluator", "Landroid/animation/ArgbEvaluator;", "endColor", "headerFloatContainer", "Landroid/view/ViewGroup;", "itemFloatContainer", "Landroid/widget/FrameLayout;", "itemFloatContainerShadow", "Landroid/view/View;", "onHeaderFloatCallback", "Lcom/didi/soda/home/topgun/widget/floatlayout/OnHeaderFloatCallback;", "getOnHeaderFloatCallback", "()Lcom/didi/soda/home/topgun/widget/floatlayout/OnHeaderFloatCallback;", "setOnHeaderFloatCallback", "(Lcom/didi/soda/home/topgun/widget/floatlayout/OnHeaderFloatCallback;)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "shimmerContainer", "shimmerView", "Lcom/didi/soda/home/shimmer/ShimmerRecyclerView;", "startColor", "stickHeaderImp", "Lcom/didi/soda/home/topgun/widget/floatlayout/StickHeaderImp;", "stickItemImp", "Lcom/didi/soda/home/topgun/widget/floatlayout/StickItemImp;", "", "attachRecycleView", "banAcceptScroll", "getAlpha", "", "pre", "getAnchorOffsetDistance", "getBgColorByFraction", "fraction", "getFloatOffset", "headerFloatScroll", "toHeaderView", "intoFloating", "notifyScroll", "showOrHideShimmer", "isShow", "SimpleOnHeaderFloatListener", "SimpleOnStickListener", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: FloatLayout.kt */
public final class FloatLayout extends ConstraintLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final String f45789a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ViewGroup f45790b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public FrameLayout f45791c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public View f45792d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public FrameLayout f45793e;

    /* renamed from: f */
    private ShimmerRecyclerView f45794f;

    /* renamed from: g */
    private final ArgbEvaluator f45795g;

    /* renamed from: h */
    private int f45796h;

    /* renamed from: i */
    private int f45797i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public RecyclerView f45798j;

    /* renamed from: k */
    private OnHeaderFloatCallback f45799k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f45800l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public final StickHeaderImp f45801m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public final StickItemImp f45802n;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FloatLayout(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FloatLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* renamed from: a */
    private final float m33946a(float f) {
        return ((double) f) < 0.5d ? (f * -2.0f) + 1.0f : (f * 2.0f) - 1.0f;
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FloatLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FloatLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f45789a = "FloatLayout";
        this.f45795g = new ArgbEvaluator();
        this.f45796h = CustomerExtentionKt.getColor(R.color.customer_color_00FAFAFA);
        this.f45797i = CustomerExtentionKt.getColor(R.color.rf_color_v2_grey2_10_a100);
        this.f45800l = true;
        View.inflate(context, R.layout.customer_component_home_filter, this);
        View findViewById = findViewById(R.id.customer_ll_home_header_float);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_ll_home_header_float)");
        this.f45790b = (ViewGroup) findViewById;
        View findViewById2 = findViewById(R.id.customer_ll_home_binder_float);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.customer_ll_home_binder_float)");
        this.f45791c = (FrameLayout) findViewById2;
        View findViewById3 = findViewById(R.id.customer_ll_home_float_shadow_view);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.custom…l_home_float_shadow_view)");
        this.f45792d = findViewById3;
        View findViewById4 = findViewById(R.id.customer_fl_home_filter_shimmer_container);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.custom…filter_shimmer_container)");
        this.f45793e = (FrameLayout) findViewById4;
        this.f45790b.setPadding(0, CustomerSystemUtil.getImmersiveStatusBarHeight(getContext()) + CustomerExtentionKt.getPx(R.dimen.rf_dimen_55), 0, CustomerExtentionKt.getPx(R.dimen.rf_dimen_24));
        StickHeaderImp stickHeaderImp = new StickHeaderImp();
        stickHeaderImp.setOnFloatListener(new SimpleOnHeaderFloatListener(this));
        Unit unit = Unit.INSTANCE;
        this.f45801m = stickHeaderImp;
        StickItemImp stickItemImp = new StickItemImp();
        stickItemImp.setListener(new SimpleOnStickListener(this));
        stickItemImp.setGetStickLayoutHeight(new FloatLayout$stickItemImp$1$1(this));
        Unit unit2 = Unit.INSTANCE;
        this.f45802n = stickItemImp;
    }

    public final OnHeaderFloatCallback getOnHeaderFloatCallback() {
        return this.f45799k;
    }

    public final void setOnHeaderFloatCallback(OnHeaderFloatCallback onHeaderFloatCallback) {
        this.f45799k = onHeaderFloatCallback;
    }

    public final void acceptScroll() {
        this.f45800l = true;
    }

    public final void banAcceptScroll() {
        this.f45800l = false;
    }

    public final int getFloatOffset() {
        return this.f45802n.getIntoStickDistance(this.f45798j);
    }

    public final int getAnchorOffsetDistance() {
        int height = this.f45790b.getHeight();
        if (height <= 0) {
            this.f45790b.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            height = this.f45790b.getMeasuredHeight();
        }
        int paddingBottom = height - this.f45790b.getPaddingBottom();
        int height2 = this.f45791c.getHeight();
        if (height2 <= 0) {
            height2 = DisplayUtils.dip2px(getContext(), 60.0f);
        }
        int px = height2 + CustomerExtentionKt.getPx(R.dimen.customer_home_filter_minus_margin);
        LogUtil.m32584d("TAG", " >>>>  headerH = " + paddingBottom + " filterH = " + px);
        return paddingBottom + px;
    }

    public final void showOrHideShimmer(boolean z) {
        ShimmerRecyclerView shimmerRecyclerView;
        if (z) {
            post(new Runnable() {
                public final void run() {
                    FloatLayout.m33947a(FloatLayout.this);
                }
            });
        } else if (this.f45794f != null && this.f45793e.getVisibility() == 0 && (shimmerRecyclerView = this.f45794f) != null) {
            shimmerRecyclerView.stopShimmerAnimator(new FloatLayout$showOrHideShimmer$2(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m33947a(FloatLayout floatLayout) {
        Intrinsics.checkNotNullParameter(floatLayout, "this$0");
        if (floatLayout.f45794f == null) {
            floatLayout.f45794f = new ShimmerRecyclerView(floatLayout.getContext());
            floatLayout.f45793e.addView(floatLayout.f45794f, new ConstraintLayout.LayoutParams(-1, -1));
        }
        if (floatLayout.f45793e.getVisibility() == 8) {
            floatLayout.f45793e.setVisibility(0);
            ShimmerRecyclerView shimmerRecyclerView = floatLayout.f45794f;
            if (shimmerRecyclerView != null) {
                shimmerRecyclerView.startShimmerAnimator(ShimmerViewType.HOME_FILTER);
            }
        }
    }

    public final void intoFloating() {
        RecyclerView.LayoutManager layoutManager;
        Integer invoke;
        RecyclerView recyclerView = this.f45798j;
        if (recyclerView != null) {
            if (recyclerView == null) {
                layoutManager = null;
            } else {
                layoutManager = recyclerView.getLayoutManager();
            }
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            if (linearLayoutManager != null) {
                Iterator it = new IntRange(linearLayoutManager.findFirstVisibleItemPosition(), linearLayoutManager.findLastVisibleItemPosition()).iterator();
                int i = 0;
                RecyclerView.ViewHolder viewHolder = null;
                int i2 = 0;
                while (it.hasNext()) {
                    int nextInt = ((IntIterator) it).nextInt();
                    RecyclerView recyclerView2 = this.f45798j;
                    RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView2 == null ? null : recyclerView2.findViewHolderForAdapterPosition(nextInt);
                    if (findViewHolderForAdapterPosition instanceof IStickHolder) {
                        i2 = nextInt;
                        viewHolder = findViewHolderForAdapterPosition;
                    }
                }
                if (((IStickHolder) viewHolder) != null) {
                    Function0<Integer> getStickLayoutHeight = this.f45802n.getGetStickLayoutHeight();
                    if (!(getStickLayoutHeight == null || (invoke = getStickLayoutHeight.invoke()) == null)) {
                        i = invoke.intValue();
                    }
                    linearLayoutManager.scrollToPositionWithOffset(i2, i);
                    RecyclerView recyclerView3 = this.f45798j;
                    Intrinsics.checkNotNull(recyclerView3);
                    recyclerView3.addOnLayoutChangeListener(new FloatLayout$intoFloating$2$1(this));
                }
            }
        }
    }

    public final void notifyScroll() {
        StickHeaderImp stickHeaderImp = this.f45801m;
        RecyclerView recyclerView = this.f45798j;
        Intrinsics.checkNotNull(recyclerView);
        stickHeaderImp.onRecycleScrolled(recyclerView);
        StickItemImp stickItemImp = this.f45802n;
        RecyclerView recyclerView2 = this.f45798j;
        Intrinsics.checkNotNull(recyclerView2);
        stickItemImp.onRecycleScrolled(recyclerView2);
        post(new Runnable() {
            public final void run() {
                FloatLayout.m33949b(FloatLayout.this);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m33949b(FloatLayout floatLayout) {
        Intrinsics.checkNotNullParameter(floatLayout, "this$0");
        floatLayout.f45802n.requestLayout();
    }

    public final void attachRecycleView(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.f45798j = recyclerView;
        recyclerView.addOnScrollListener(new FloatLayout$attachRecycleView$1(this));
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            adapter.registerAdapterDataObserver(new FloatLayout$attachRecycleView$2(this));
        }
    }

    public final void headerFloatScroll(View view, float f) {
        int i;
        Intrinsics.checkNotNullParameter(view, "toHeaderView");
        LogUtil.m32584d("TAG", Intrinsics.stringPlus(" pre == ", Float.valueOf(f)));
        OnHeaderFloatCallback onHeaderFloatCallback = this.f45799k;
        if (onHeaderFloatCallback != null) {
            onHeaderFloatCallback.onFloating(f);
        }
        float f2 = 1.0f;
        if (f <= 0.0f) {
            this.f45790b.setVisibility(8);
            this.f45791c.setVisibility(8);
            i = m33948b(0.0f);
            this.f45790b.setClickable(false);
        } else if (f < 0.5f) {
            this.f45790b.setVisibility(0);
            this.f45791c.setVisibility(0);
            f2 = m33946a(f);
            i = m33948b(f);
            this.f45790b.setClickable(false);
        } else if (f < 0.5f || f >= 1.0f) {
            this.f45790b.setVisibility(0);
            this.f45791c.setVisibility(0);
            i = m33948b(1.0f);
            if (!Intrinsics.areEqual((Object) view.getParent(), (Object) this.f45790b)) {
                ViewSafeHelper.safeAddView(this.f45790b, view);
            }
            this.f45790b.setClickable(true);
        } else {
            this.f45790b.setVisibility(0);
            this.f45791c.setVisibility(0);
            f2 = m33946a(f);
            i = m33948b(f);
            if (!Intrinsics.areEqual((Object) view.getParent(), (Object) this.f45790b)) {
                ViewSafeHelper.safeAddView(this.f45790b, view);
            }
            this.f45790b.setClickable(true);
        }
        view.setAlpha(f2);
        this.f45790b.setBackgroundColor(i);
    }

    /* renamed from: b */
    private final int m33948b(float f) {
        Object evaluate = this.f45795g.evaluate(f, Integer.valueOf(this.f45796h), Integer.valueOf(this.f45797i));
        if (evaluate != null) {
            return ((Integer) evaluate).intValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    @Metadata(mo148867d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo148868d2 = {"Lcom/didi/soda/home/topgun/widget/floatlayout/FloatLayout$SimpleOnHeaderFloatListener;", "Lcom/didi/soda/home/topgun/widget/floatlayout/OnHeaderFloatListener;", "(Lcom/didi/soda/home/topgun/widget/floatlayout/FloatLayout;)V", "onHeaderFloatScroll", "", "floatView", "Landroid/view/View;", "progress", "", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: FloatLayout.kt */
    public final class SimpleOnHeaderFloatListener implements OnHeaderFloatListener {
        final /* synthetic */ FloatLayout this$0;

        public SimpleOnHeaderFloatListener(FloatLayout floatLayout) {
            Intrinsics.checkNotNullParameter(floatLayout, "this$0");
            this.this$0 = floatLayout;
        }

        public void onHeaderFloatScroll(View view, float f) {
            Intrinsics.checkNotNullParameter(view, "floatView");
            LogUtil.m32584d(this.this$0.f45789a, Intrinsics.stringPlus(">>>> onFloatScroll === ", Float.valueOf(f)));
            this.this$0.headerFloatScroll(view, f);
        }
    }

    @Metadata(mo148867d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo148868d2 = {"Lcom/didi/soda/home/topgun/widget/floatlayout/FloatLayout$SimpleOnStickListener;", "Lcom/didi/soda/home/topgun/widget/floatlayout/OnStickListener;", "(Lcom/didi/soda/home/topgun/widget/floatlayout/FloatLayout;)V", "onStickEvent", "", "stickView", "Landroid/view/View;", "isStick", "", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: FloatLayout.kt */
    public final class SimpleOnStickListener implements OnStickListener {
        final /* synthetic */ FloatLayout this$0;

        public SimpleOnStickListener(FloatLayout floatLayout) {
            Intrinsics.checkNotNullParameter(floatLayout, "this$0");
            this.this$0 = floatLayout;
        }

        public void onStickEvent(View view, boolean z) {
            Intrinsics.checkNotNullParameter(view, "stickView");
            if (z) {
                if (!Intrinsics.areEqual((Object) view.getParent(), (Object) this.this$0.f45791c)) {
                    ViewSafeHelper.safeAddView(this.this$0.f45791c, view);
                }
                this.this$0.f45792d.setVisibility(0);
                return;
            }
            if (Intrinsics.areEqual((Object) view.getParent(), (Object) this.this$0.f45791c)) {
                ViewSafeHelper.safeRemoveView(this.this$0.f45791c, view);
            }
            this.this$0.f45792d.setVisibility(8);
        }
    }
}
