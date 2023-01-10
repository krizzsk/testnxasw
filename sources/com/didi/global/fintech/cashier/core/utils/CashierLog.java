package com.didi.global.fintech.cashier.core.utils;

import com.didi.global.fintech.cashier.user.facade.CashierFacade;
import com.didi.sdk.apm.SystemUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0001J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0001J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0001J\u0016\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0001J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0001J\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0001R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/core/utils/CashierLog;", "", "()V", "TAG", "", "d", "", "msg", "tag", "e", "i", "cashier_core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: CashierLog.kt */
public final class CashierLog {
    public static final CashierLog INSTANCE = new CashierLog();

    /* renamed from: a */
    private static final String f23354a = "CashierLog";

    private CashierLog() {
    }

    /* renamed from: d */
    public final void mo68925d(String str, Object obj) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(obj, "msg");
        if (CashierFacade.Companion.getInstance().getInitConfig().isDebugMode()) {
            SystemUtils.log(3, Intrinsics.stringPlus("CashierLog-", str), obj.toString(), (Throwable) null, "com.didi.global.fintech.cashier.core.utils.CashierLog", 14);
        }
    }

    /* renamed from: d */
    public final void mo68924d(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "msg");
        if (CashierFacade.Companion.getInstance().getInitConfig().isDebugMode()) {
            SystemUtils.log(3, f23354a, obj.toString(), (Throwable) null, "com.didi.global.fintech.cashier.core.utils.CashierLog", 20);
        }
    }

    /* renamed from: i */
    public final void mo68929i(String str, Object obj) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(obj, "msg");
        if (CashierFacade.Companion.getInstance().getInitConfig().isDebugMode()) {
            SystemUtils.log(4, Intrinsics.stringPlus("CashierLog-", str), obj.toString(), (Throwable) null, "com.didi.global.fintech.cashier.core.utils.CashierLog", 26);
        }
    }

    /* renamed from: i */
    public final void mo68928i(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "msg");
        if (CashierFacade.Companion.getInstance().getInitConfig().isDebugMode()) {
            SystemUtils.log(4, f23354a, obj.toString(), (Throwable) null, "com.didi.global.fintech.cashier.core.utils.CashierLog", 32);
        }
    }

    /* renamed from: e */
    public final void mo68926e(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "msg");
        if (CashierFacade.Companion.getInstance().getInitConfig().isDebugMode()) {
            SystemUtils.log(6, f23354a, obj.toString(), (Throwable) null, "com.didi.global.fintech.cashier.core.utils.CashierLog", 38);
        }
    }

    /* renamed from: e */
    public final void mo68927e(String str, Object obj) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(obj, "msg");
        if (CashierFacade.Companion.getInstance().getInitConfig().isDebugMode()) {
            SystemUtils.log(6, Intrinsics.stringPlus("CashierLog-", str), obj.toString(), (Throwable) null, "com.didi.global.fintech.cashier.core.utils.CashierLog", 44);
        }
    }
}
