package com.didi.payment.wallet_ui.selector;

import android.graphics.Path;
import com.didi.payment.wallet_ui.UiUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", "Landroid/graphics/Path;"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: WalletRadio.kt */
final class WalletRadio$selectorPath$2 extends Lambda implements Function0<Path> {
    public static final WalletRadio$selectorPath$2 INSTANCE = new WalletRadio$selectorPath$2();

    WalletRadio$selectorPath$2() {
        super(0);
    }

    public final Path invoke() {
        Path path = new Path();
        path.moveTo(UiUtils.Companion.floatSize(11), UiUtils.Companion.floatSize(20));
        path.lineTo(UiUtils.Companion.floatSize(17), UiUtils.Companion.floatSize(26));
        path.lineTo(UiUtils.Companion.floatSize(29), UiUtils.Companion.floatSize(14));
        return path;
    }
}
