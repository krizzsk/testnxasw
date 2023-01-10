package com.didi.component.openride.newscan;

import com.didi.component.openride.widget.OpenRideDriverInfoPopWin;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: GlobalOpenRideDriverInfoConfirmFragment.kt */
final class GlobalOpenRideDriverInfoConfirmFragment$initData$2 implements Runnable {
    final /* synthetic */ GlobalOpenRideDriverInfoConfirmFragment this$0;

    GlobalOpenRideDriverInfoConfirmFragment$initData$2(GlobalOpenRideDriverInfoConfirmFragment globalOpenRideDriverInfoConfirmFragment) {
        this.this$0 = globalOpenRideDriverInfoConfirmFragment;
    }

    public final void run() {
        OpenRideDriverInfoPopWin access$getMPop$p = this.this$0.f16573a;
        if (access$getMPop$p != null) {
            access$getMPop$p.show();
        }
    }
}
