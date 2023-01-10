package com.didi.payment.wallet_ui.loading;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import com.didi.payment.wallet_ui.UiUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", "Landroid/graphics/LinearGradient;"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: WalletLoadingProgressBar.kt */
final class WalletLoadingProgressBar$bgShader$2 extends Lambda implements Function0<LinearGradient> {
    public static final WalletLoadingProgressBar$bgShader$2 INSTANCE = new WalletLoadingProgressBar$bgShader$2();

    WalletLoadingProgressBar$bgShader$2() {
        super(0);
    }

    public final LinearGradient invoke() {
        return new LinearGradient(0.0f, WalletLoadingProgressBar.f35658q, (float) UiUtils.Companion.getScreenWidth(), WalletLoadingProgressBar.f35658q, WalletLoadingProgressBar.f35650i, WalletLoadingProgressBar.f35651j, Shader.TileMode.CLAMP);
    }
}
