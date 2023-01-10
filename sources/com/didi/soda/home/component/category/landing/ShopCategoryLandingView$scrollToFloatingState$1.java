package com.didi.soda.home.component.category.landing;

import android.view.View;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.didi.raven.config.RavenKey;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.home.topgun.component.feed.helper.HomeCalculateHeightUtil;
import com.didi.soda.home.widget.LandingFloatLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JP\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¨\u0006\u000f"}, mo148868d2 = {"com/didi/soda/home/component/category/landing/ShopCategoryLandingView$scrollToFloatingState$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: ShopCategoryLandingView.kt */
public final class ShopCategoryLandingView$scrollToFloatingState$1 implements View.OnLayoutChangeListener {
    final /* synthetic */ int $anchorTarget;
    final /* synthetic */ boolean $isFilterNone;
    final /* synthetic */ ShopCategoryLandingView this$0;

    ShopCategoryLandingView$scrollToFloatingState$1(int i, boolean z, ShopCategoryLandingView shopCategoryLandingView) {
        this.$anchorTarget = i;
        this.$isFilterNone = z;
        this.this$0 = shopCategoryLandingView;
    }

    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Intrinsics.checkNotNullParameter(view, RavenKey.VERSION);
        NovaRecyclerView novaRecyclerView = null;
        if (this.$anchorTarget >= 0 && !this.$isFilterNone) {
            NovaRecyclerView access$getMRecyclerView$p = this.this$0.f45049a;
            if (access$getMRecyclerView$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
                access$getMRecyclerView$p = null;
            }
            int filterDataFullScreenOffset = HomeCalculateHeightUtil.getFilterDataFullScreenOffset(access$getMRecyclerView$p, this.$anchorTarget, false);
            this.this$0.m33410a(filterDataFullScreenOffset);
            LogUtil.m32588i("Float", this.$anchorTarget + "onLayoutChange >>>>> footer" + filterDataFullScreenOffset);
        }
        LandingFloatLayout access$getMFloatLayout$p = this.this$0.f45052d;
        if (access$getMFloatLayout$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFloatLayout");
            access$getMFloatLayout$p = null;
        }
        access$getMFloatLayout$p.acceptScroll();
        LandingFloatLayout access$getMFloatLayout$p2 = this.this$0.f45052d;
        if (access$getMFloatLayout$p2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFloatLayout");
            access$getMFloatLayout$p2 = null;
        }
        access$getMFloatLayout$p2.post(new Runnable() {
            public final void run() {
                ShopCategoryLandingView$scrollToFloatingState$1.m47410onLayoutChange$lambda0(ShopCategoryLandingView.this);
            }
        });
        NovaRecyclerView access$getMRecyclerView$p2 = this.this$0.f45049a;
        if (access$getMRecyclerView$p2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        } else {
            novaRecyclerView = access$getMRecyclerView$p2;
        }
        novaRecyclerView.removeOnLayoutChangeListener(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: onLayoutChange$lambda-0  reason: not valid java name */
    public static final void m47410onLayoutChange$lambda0(ShopCategoryLandingView shopCategoryLandingView) {
        Intrinsics.checkNotNullParameter(shopCategoryLandingView, "this$0");
        LandingFloatLayout access$getMFloatLayout$p = shopCategoryLandingView.f45052d;
        if (access$getMFloatLayout$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFloatLayout");
            access$getMFloatLayout$p = null;
        }
        access$getMFloatLayout$p.notifyScroll();
    }
}
