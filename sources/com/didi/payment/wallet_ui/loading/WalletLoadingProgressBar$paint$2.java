package com.didi.payment.wallet_ui.loading;

import android.graphics.Paint;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", "Landroid/graphics/Paint;"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: WalletLoadingProgressBar.kt */
final class WalletLoadingProgressBar$paint$2 extends Lambda implements Function0<Paint> {
    public static final WalletLoadingProgressBar$paint$2 INSTANCE = new WalletLoadingProgressBar$paint$2();

    WalletLoadingProgressBar$paint$2() {
        super(0);
    }

    public final Paint invoke() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth((float) WalletLoadingProgressBar.Companion.getMaxHeight());
        paint.setStyle(Paint.Style.STROKE);
        return paint;
    }
}
