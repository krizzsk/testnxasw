package com.didi.payment.wallet_ui.loading;

import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n"}, mo148868d2 = {"<anonymous>", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: WalletLoadingProgressBar.kt */
final class WalletLoadingProgressBar$animator$2 extends Lambda implements Function0<ValueAnimator> {
    final /* synthetic */ WalletLoadingProgressBar this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WalletLoadingProgressBar$animator$2(WalletLoadingProgressBar walletLoadingProgressBar) {
        super(0);
        this.this$0 = walletLoadingProgressBar;
    }

    public final ValueAnimator invoke() {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, 100});
        WalletLoadingProgressBar walletLoadingProgressBar = this.this$0;
        ofInt.setDuration(1200);
        ofInt.setRepeatCount(-1);
        ofInt.setRepeatMode(1);
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.addUpdateListener(walletLoadingProgressBar);
        return ofInt;
    }
}
