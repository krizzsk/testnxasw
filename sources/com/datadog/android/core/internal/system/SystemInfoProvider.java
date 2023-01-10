package com.datadog.android.core.internal.system;

import android.content.Context;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\t"}, mo148868d2 = {"Lcom/datadog/android/core/internal/system/SystemInfoProvider;", "", "getLatestSystemInfo", "Lcom/datadog/android/core/internal/system/SystemInfo;", "register", "", "context", "Landroid/content/Context;", "unregister", "dd-sdk-android_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SystemInfoProvider.kt */
public interface SystemInfoProvider {
    SystemInfo getLatestSystemInfo();

    void register(Context context);

    void unregister(Context context);
}
