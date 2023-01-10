package com.didi.soda.home.topgun.widget.floatlayout;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: FloatLayout.kt */
final class FloatLayout$stickItemImp$1$1 extends Lambda implements Function0<Integer> {
    final /* synthetic */ FloatLayout this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FloatLayout$stickItemImp$1$1(FloatLayout floatLayout) {
        super(0);
        this.this$0 = floatLayout;
    }

    public final Integer invoke() {
        int height = this.this$0.f45790b.getHeight();
        if (height == 0) {
            this.this$0.f45790b.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            height = this.this$0.f45790b.getMeasuredHeight();
        }
        return Integer.valueOf(height - this.this$0.f45790b.getPaddingBottom());
    }
}
