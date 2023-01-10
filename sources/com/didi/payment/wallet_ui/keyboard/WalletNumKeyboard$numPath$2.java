package com.didi.payment.wallet_ui.keyboard;

import android.graphics.Path;
import com.didi.payment.wallet_ui.UiUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", "Landroid/graphics/Path;"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: WalletNumKeyboard.kt */
final class WalletNumKeyboard$numPath$2 extends Lambda implements Function0<Path> {
    final /* synthetic */ WalletNumKeyboard this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WalletNumKeyboard$numPath$2(WalletNumKeyboard walletNumKeyboard) {
        super(0);
        this.this$0 = walletNumKeyboard;
    }

    public final Path invoke() {
        Path path = new Path();
        WalletNumKeyboard walletNumKeyboard = this.this$0;
        path.moveTo(0.0f, 0.0f);
        path.rLineTo((float) UiUtils.Companion.getScreenWidth(), 0.0f);
        int i = 1;
        int i2 = 1;
        while (true) {
            int i3 = i2 + 1;
            path.moveTo(0.0f, ((float) i2) * walletNumKeyboard.f35565B);
            path.rLineTo((float) UiUtils.Companion.getScreenWidth(), 0.0f);
            if (i3 > 3) {
                break;
            }
            i2 = i3;
        }
        while (true) {
            int i4 = i + 1;
            path.moveTo(((float) i) * walletNumKeyboard.f35567D, 0.0f);
            path.rLineTo(0.0f, walletNumKeyboard.f35609x);
            if (i4 > 2) {
                return path;
            }
            i = i4;
        }
    }
}
