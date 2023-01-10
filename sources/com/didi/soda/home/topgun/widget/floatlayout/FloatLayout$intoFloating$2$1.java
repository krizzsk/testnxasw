package com.didi.soda.home.topgun.widget.floatlayout;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.raven.config.RavenKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JP\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¨\u0006\u000f"}, mo148868d2 = {"com/didi/soda/home/topgun/widget/floatlayout/FloatLayout$intoFloating$2$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: FloatLayout.kt */
public final class FloatLayout$intoFloating$2$1 implements View.OnLayoutChangeListener {
    final /* synthetic */ FloatLayout this$0;

    FloatLayout$intoFloating$2$1(FloatLayout floatLayout) {
        this.this$0 = floatLayout;
    }

    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Intrinsics.checkNotNullParameter(view, RavenKey.VERSION);
        this.this$0.notifyScroll();
        RecyclerView access$getRecyclerView$p = this.this$0.f45798j;
        Intrinsics.checkNotNull(access$getRecyclerView$p);
        access$getRecyclerView$p.removeOnLayoutChangeListener(this);
    }
}
