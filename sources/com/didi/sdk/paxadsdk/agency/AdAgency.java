package com.didi.sdk.paxadsdk.agency;

import android.content.Context;
import com.didi.sdk.paxadsdk.NativeAdStyle;
import com.didi.sdk.paxadsdk.listener.AdLoadListenner;
import com.didi.sdk.paxadsdk.model.AdTraceInfo;

public interface AdAgency {
    String getName();

    void init(Context context);

    boolean isLoading(String str);

    void loadNativeAD(Context context, NativeAdStyle nativeAdStyle, String str, AdTraceInfo adTraceInfo, AdLoadListenner adLoadListenner);
}
