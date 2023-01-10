package com.datadog.android.core.internal.net.info;

import android.content.Context;
import com.datadog.android.core.model.NetworkInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, mo148868d2 = {"Lcom/datadog/android/core/internal/net/info/NoOpNetworkInfoProvider;", "Lcom/datadog/android/core/internal/net/info/NetworkInfoProvider;", "()V", "getLatestNetworkInfo", "Lcom/datadog/android/core/model/NetworkInfo;", "register", "", "context", "Landroid/content/Context;", "unregister", "dd-sdk-android_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: NoOpNetworkInfoProvider.kt */
public final class NoOpNetworkInfoProvider implements NetworkInfoProvider {
    public void register(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void unregister(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public NetworkInfo getLatestNetworkInfo() {
        return new NetworkInfo((NetworkInfo.Connectivity) null, (String) null, (Long) null, (Long) null, (Long) null, (Long) null, (String) null, 127, (DefaultConstructorMarker) null);
    }
}
