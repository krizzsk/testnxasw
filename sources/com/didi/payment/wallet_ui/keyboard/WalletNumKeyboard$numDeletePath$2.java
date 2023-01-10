package com.didi.payment.wallet_ui.keyboard;

import android.graphics.Path;
import com.didi.payment.wallet_ui.UiUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", "Landroid/graphics/Path;"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: WalletNumKeyboard.kt */
final class WalletNumKeyboard$numDeletePath$2 extends Lambda implements Function0<Path> {
    final /* synthetic */ WalletNumKeyboard this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WalletNumKeyboard$numDeletePath$2(WalletNumKeyboard walletNumKeyboard) {
        super(0);
        this.this$0 = walletNumKeyboard;
    }

    public final Path invoke() {
        WalletNumKeyboard walletNumKeyboard = this.this$0;
        return walletNumKeyboard.m26895a((walletNumKeyboard.f35567D * 2.5f) - UiUtils.Companion.floatSize(20), this.this$0.f35609x - (this.this$0.f35565B / ((float) 2)));
    }
}
