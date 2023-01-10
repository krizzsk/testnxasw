package com.didi.sdk.p155ms.common;

import android.content.Context;
import androidx.core.util.Consumer;

/* renamed from: com.didi.sdk.ms.common.IAnalytics */
public interface IAnalytics {
    void getAppInstanceIdAsync(Context context, Consumer<String> consumer);
}
