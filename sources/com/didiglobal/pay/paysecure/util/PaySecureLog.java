package com.didiglobal.pay.paysecure.util;

import com.didi.sdk.apm.SystemUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004J\u0016\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\f"}, mo148868d2 = {"Lcom/didiglobal/pay/paysecure/util/PaySecureLog;", "", "()V", "TAG", "", "isDebugMode", "", "e", "", "msg", "tag", "i", "paysecure_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: PaySecureLog.kt */
public final class PaySecureLog {
    public static final PaySecureLog INSTANCE = new PaySecureLog();

    /* renamed from: a */
    private static final String f52995a = "PaySecureLog";

    /* renamed from: b */
    private static final boolean f52996b = true;

    private PaySecureLog() {
    }

    /* renamed from: i */
    public final void mo129705i(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "tag");
        Intrinsics.checkParameterIsNotNull(str2, "msg");
        SystemUtils.log(4, "PaySecureLog-" + str, str2, (Throwable) null, "com.didiglobal.pay.paysecure.util.PaySecureLog", 15);
    }

    /* renamed from: i */
    public final void mo129704i(String str) {
        Intrinsics.checkParameterIsNotNull(str, "msg");
        SystemUtils.log(4, f52995a, str, (Throwable) null, "com.didiglobal.pay.paysecure.util.PaySecureLog", 21);
    }

    /* renamed from: e */
    public final void mo129702e(String str) {
        Intrinsics.checkParameterIsNotNull(str, "msg");
        SystemUtils.log(6, f52995a, str, (Throwable) null, "com.didiglobal.pay.paysecure.util.PaySecureLog", 27);
    }

    /* renamed from: e */
    public final void mo129703e(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "tag");
        Intrinsics.checkParameterIsNotNull(str2, "msg");
        SystemUtils.log(6, "PaySecureLog-" + str, str2, (Throwable) null, "com.didiglobal.pay.paysecure.util.PaySecureLog", 33);
    }
}
