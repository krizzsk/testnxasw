package com.didi.sdk.paxadsdk.listener;

import android.view.View;
import com.didi.sdk.paxadsdk.model.AdTraceInfo;

public interface AdLoadListenner {
    void onAdClicked(AdTraceInfo adTraceInfo);

    void onAdClosed(AdTraceInfo adTraceInfo);

    void onAdImpression(AdTraceInfo adTraceInfo);

    void onAdLoaded(AdTraceInfo adTraceInfo);

    void onAdOpened(AdTraceInfo adTraceInfo);

    void onFailed(String str, String str2, AdTraceInfo adTraceInfo);

    void onSuccess(View view, AdTraceInfo adTraceInfo);
}
