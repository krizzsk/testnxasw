package com.datadog.android.rum.internal.net;

import com.datadog.android.core.internal.CoreFeature;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: RumOkHttpUploaderV2.kt */
final class RumOkHttpUploaderV2$tags$2 extends Lambda implements Function0<String> {
    final /* synthetic */ String $sdkVersion;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RumOkHttpUploaderV2$tags$2(String str) {
        super(0);
        this.$sdkVersion = str;
    }

    public final String invoke() {
        boolean z = false;
        List mutableListOf = CollectionsKt.mutableListOf(Intrinsics.stringPlus("service:", CoreFeature.INSTANCE.getServiceName$dd_sdk_android_release()), Intrinsics.stringPlus("version:", CoreFeature.INSTANCE.getPackageVersion$dd_sdk_android_release()), Intrinsics.stringPlus("sdk_version:", this.$sdkVersion), Intrinsics.stringPlus("env:", CoreFeature.INSTANCE.getEnvName$dd_sdk_android_release()));
        if (CoreFeature.INSTANCE.getVariant$dd_sdk_android_release().length() > 0) {
            z = true;
        }
        if (z) {
            mutableListOf.add(Intrinsics.stringPlus("variant:", CoreFeature.INSTANCE.getVariant$dd_sdk_android_release()));
        }
        return CollectionsKt.joinToString$default(mutableListOf, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }
}
