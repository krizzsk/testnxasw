package com.didi.payment.wallet.global.utils;

import android.content.Context;
import com.didi.payment.base.exts.ApplicationContextProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", "Landroid/content/Context;"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: WalletSecuritySPUtils.kt */
final class WalletSecuritySPUtils$context$2 extends Lambda implements Function0<Context> {
    public static final WalletSecuritySPUtils$context$2 INSTANCE = new WalletSecuritySPUtils$context$2();

    WalletSecuritySPUtils$context$2() {
        super(0);
    }

    public final Context invoke() {
        return ApplicationContextProvider.Companion.getContext();
    }
}
