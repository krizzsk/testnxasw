package com.datadog.android.core.internal.system;

import android.content.Context;
import com.datadog.android.core.internal.system.SystemInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, mo148868d2 = {"Lcom/datadog/android/core/internal/system/NoOpSystemInfoProvider;", "Lcom/datadog/android/core/internal/system/SystemInfoProvider;", "()V", "getLatestSystemInfo", "Lcom/datadog/android/core/internal/system/SystemInfo;", "register", "", "context", "Landroid/content/Context;", "unregister", "dd-sdk-android_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: NoOpSystemInfoProvider.kt */
public final class NoOpSystemInfoProvider implements SystemInfoProvider {
    public void register(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void unregister(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public SystemInfo getLatestSystemInfo() {
        return new SystemInfo((SystemInfo.BatteryStatus) null, 0, false, 7, (DefaultConstructorMarker) null);
    }
}