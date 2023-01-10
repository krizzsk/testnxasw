package com.didi.component.openride.newscan;

import com.didi.global.loading.Loading;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: GlobalOpenRideCodeInputFragment.kt */
final class GlobalOpenRideCodeInputFragment$dismissRequestLoadingDialog$1 implements Runnable {
    final /* synthetic */ GlobalOpenRideCodeInputFragment this$0;

    GlobalOpenRideCodeInputFragment$dismissRequestLoadingDialog$1(GlobalOpenRideCodeInputFragment globalOpenRideCodeInputFragment) {
        this.this$0 = globalOpenRideCodeInputFragment;
    }

    public final void run() {
        if (!this.this$0.isDetached()) {
            Loading.hide(this.this$0.f16567a);
        }
    }
}
