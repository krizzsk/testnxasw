package com.didi.soda.home.manager;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.home.manager.HomeRocketLaunchAnimManager;
import com.didi.soda.home.topgun.widget.floatlayout.FloatLayout;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(mo148867d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, mo148868d2 = {"com/didi/soda/home/manager/HomeRocketLaunchAnimManager$attach$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: HomeRocketLaunchAnimManager.kt */
public final class HomeRocketLaunchAnimManager$attach$1 extends RecyclerView.OnScrollListener {
    final /* synthetic */ Context $ctx;
    final /* synthetic */ FloatLayout $floatLayout;
    final /* synthetic */ Ref.IntRef $lastScrollState;
    final /* synthetic */ Ref.IntRef $totalScrollOffset;
    final /* synthetic */ HomeRocketLaunchAnimManager this$0;

    HomeRocketLaunchAnimManager$attach$1(Ref.IntRef intRef, Context context, FloatLayout floatLayout, Ref.IntRef intRef2, HomeRocketLaunchAnimManager homeRocketLaunchAnimManager) {
        this.$totalScrollOffset = intRef;
        this.$ctx = context;
        this.$floatLayout = floatLayout;
        this.$lastScrollState = intRef2;
        this.this$0 = homeRocketLaunchAnimManager;
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        HomeRocketLaunchAnimManager.OnHomeListScrollChangeListener access$getMHomeListScrollChangeListener$p;
        HomeRocketLaunchAnimManager.OnHomeListScrollChangeListener access$getMHomeListScrollChangeListener$p2;
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i, i2);
        if (!recyclerView.canScrollVertically(-1)) {
            this.$totalScrollOffset.element = 0;
        }
        this.$totalScrollOffset.element += i2;
        int screenHeight = ((CustomerSystemUtil.getScreenHeight(this.$ctx) - CustomerSystemUtil.getImmersiveStatusBarHeight(this.$ctx)) - ResourceHelper.getDimensionPixelSize(R.dimen.customer_tab_bar_height)) - this.$floatLayout.getAnchorOffsetDistance();
        Ref.IntRef intRef = this.$lastScrollState;
        int i3 = 1;
        if (this.$totalScrollOffset.element < screenHeight) {
            if (!(this.$lastScrollState.element == 2 || (access$getMHomeListScrollChangeListener$p = this.this$0.f45161a) == null)) {
                access$getMHomeListScrollChangeListener$p.onScrollUpLessThanOnePage();
            }
            i3 = 2;
        } else if (!(this.$lastScrollState.element == 1 || (access$getMHomeListScrollChangeListener$p2 = this.this$0.f45161a) == null)) {
            access$getMHomeListScrollChangeListener$p2.onScrollDownMoreThanOnePage();
        }
        intRef.element = i3;
        LogUtil.m32584d(this.this$0.f45163c, "onScrolled------dy=" + i2 + "----totalScrollHeight=" + this.$totalScrollOffset.element + "----expriedHeight=" + screenHeight);
    }
}
