package com.datadog.android.core.internal.constraints;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", "", "it"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: DatadogDataConstraints.kt */
final class DatadogDataConstraints$tagTransforms$2 extends Lambda implements Function1<String, String> {
    public static final DatadogDataConstraints$tagTransforms$2 INSTANCE = new DatadogDataConstraints$tagTransforms$2();

    DatadogDataConstraints$tagTransforms$2() {
        super(1);
    }

    public final String invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        boolean z = false;
        char charAt = str.charAt(0);
        if ('a' <= charAt && charAt <= 'z') {
            z = true;
        }
        if (!z) {
            return null;
        }
        return str;
    }
}
