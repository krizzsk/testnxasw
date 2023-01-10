package com.didi.soda.customer.widget.tabbar;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(mo148867d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo148868d2 = {"com/didi/soda/customer/widget/tabbar/TabBarItemView$setOnDoubleClickListener$listener$1", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "onDoubleTap", "", "e", "Landroid/view/MotionEvent;", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: TabBarItemView.kt */
public final class TabBarItemView$setOnDoubleClickListener$listener$1 extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ Function1<View, Unit> $doubleClick;
    final /* synthetic */ TabBarItemView this$0;

    TabBarItemView$setOnDoubleClickListener$listener$1(Function1<? super View, Unit> function1, TabBarItemView tabBarItemView) {
        this.$doubleClick = function1;
        this.this$0 = tabBarItemView;
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        this.$doubleClick.invoke(this.this$0);
        return true;
    }
}
