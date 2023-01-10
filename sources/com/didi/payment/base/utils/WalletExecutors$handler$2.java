package com.didi.payment.base.utils;

import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", "Landroid/os/Handler;"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: WalletExecutors.kt */
final class WalletExecutors$handler$2 extends Lambda implements Function0<Handler> {
    public static final WalletExecutors$handler$2 INSTANCE = new WalletExecutors$handler$2();

    WalletExecutors$handler$2() {
        super(0);
    }

    public final Handler invoke() {
        return new Handler(Looper.getMainLooper());
    }
}
