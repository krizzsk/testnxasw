package com.didi.component.savingcenter;

import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SavingCenterView.kt */
final class SavingCenterView$playDelay$1 implements Runnable {
    final /* synthetic */ SavingCenterView this$0;

    SavingCenterView$playDelay$1(SavingCenterView savingCenterView) {
        this.this$0 = savingCenterView;
    }

    public final void run() {
        SavingCenterView savingCenterView = this.this$0;
        savingCenterView.play(savingCenterView.getMShowTime());
    }
}
