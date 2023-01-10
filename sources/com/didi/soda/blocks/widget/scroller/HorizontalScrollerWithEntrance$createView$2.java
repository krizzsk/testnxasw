package com.didi.soda.blocks.widget.scroller;

import android.view.View;
import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\n¢\u0006\u0002\b\u000e"}, mo148868d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "onLayoutChange"}, mo148869k = 3, mo148870mv = {1, 1, 16})
/* compiled from: HorizontalScrollerWithEntrance.kt */
final class HorizontalScrollerWithEntrance$createView$2 implements View.OnLayoutChangeListener {
    final /* synthetic */ HorizontalScrollerWithEntrance this$0;

    HorizontalScrollerWithEntrance$createView$2(HorizontalScrollerWithEntrance horizontalScrollerWithEntrance) {
        this.this$0 = horizontalScrollerWithEntrance;
    }

    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.this$0.adjustWidthAndHeight();
    }
}
