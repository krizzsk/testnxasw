package com.didi.entrega.customer.foundation.util;

import com.didi.entrega.customer.app.GlobalContext;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo148868d2 = {"Lcom/didi/entrega/customer/foundation/util/ApiErrorUtil;", "", "()V", "Companion", "entrega-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: ApiErrorUtil.kt */
public final class ApiErrorUtil {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private static final String f21921a = "-1";

    @Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo148868d2 = {"Lcom/didi/entrega/customer/foundation/util/ApiErrorUtil$Companion;", "", "()V", "NETWORK_ERROR_CODE", "", "getErrorType", "errorType", "entrega-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: ApiErrorUtil.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getErrorType(String str) {
            Intrinsics.checkNotNullParameter(str, "errorType");
            if (!Intrinsics.areEqual((Object) "-1", (Object) str)) {
                return str;
            }
            return NetWorkUtils.isNetworkConnected(GlobalContext.getContext()) ? "-10000" : "-10001";
        }
    }
}
