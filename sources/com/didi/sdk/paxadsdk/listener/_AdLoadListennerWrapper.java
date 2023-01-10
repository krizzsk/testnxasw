package com.didi.sdk.paxadsdk.listener;

import android.view.View;
import com.android.didi.bfflib.business.BffNetConstant;
import com.didi.sdk.paxadsdk.model.AdTraceInfo;
import com.didi.sdk.paxadsdk.utils.AdLogger;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

public class _AdLoadListennerWrapper implements AdLoadListenner {
    private AdLoadListenner parent;

    public _AdLoadListennerWrapper(AdLoadListenner adLoadListenner) {
        this.parent = adLoadListenner;
    }

    public void onSuccess(View view, AdTraceInfo adTraceInfo) {
        AdLogger.m29883d("AdLoadListennerWrapper onSuccess " + adTraceInfo);
        AdLoadListenner adLoadListenner = this.parent;
        if (adLoadListenner != null) {
            adLoadListenner.onSuccess(view, adTraceInfo);
        }
    }

    public void onFailed(String str, String str2, AdTraceInfo adTraceInfo) {
        int i;
        AdLogger.m29883d("AdLoadListennerWrapper onFailed ");
        AdLogger.m29883d(" errCode " + str + " errorMsg " + str2);
        StringBuilder sb = new StringBuilder();
        sb.append(" traceInfo ");
        sb.append(adTraceInfo);
        AdLogger.m29883d(sb.toString());
        HashMap hashMap = new HashMap();
        try {
            i = Integer.parseInt(str);
        } catch (Exception e) {
            e.printStackTrace();
            i = -1;
        }
        hashMap.put("m_tag", "tech_admob_resource_sw");
        hashMap.put("m_scene", Integer.valueOf(i));
        HashMap hashMap2 = new HashMap();
        hashMap2.put("agency", adTraceInfo.agency);
        hashMap2.put(Constants.JSON_KEY_ANDID, adTraceInfo.adid);
        hashMap2.put("errmsg", str2);
        hashMap2.put(BffNetConstant.ERR_CODE, str);
        hashMap.put("m_ext", new Gson().toJson((Object) hashMap2));
        OmegaSDKAdapter.trackEvent("ibt_monitor_scene_ck", (Map<String, Object>) hashMap);
        AdLoadListenner adLoadListenner = this.parent;
        if (adLoadListenner != null) {
            adLoadListenner.onFailed(str, str2, adTraceInfo);
        }
    }

    public void onAdClosed(AdTraceInfo adTraceInfo) {
        AdLogger.m29883d("AdLoadListennerWrapper onAdClosed " + adTraceInfo);
        AdLoadListenner adLoadListenner = this.parent;
        if (adLoadListenner != null) {
            adLoadListenner.onAdClosed(adTraceInfo);
        }
    }

    public void onAdOpened(AdTraceInfo adTraceInfo) {
        AdLogger.m29883d("AdLoadListennerWrapper onAdOpened " + adTraceInfo);
        AdLoadListenner adLoadListenner = this.parent;
        if (adLoadListenner != null) {
            adLoadListenner.onAdOpened(adTraceInfo);
        }
    }

    public void onAdLoaded(AdTraceInfo adTraceInfo) {
        AdLogger.m29883d("AdLoadListennerWrapper onAdLoaded " + adTraceInfo);
        AdLoadListenner adLoadListenner = this.parent;
        if (adLoadListenner != null) {
            adLoadListenner.onAdLoaded(adTraceInfo);
        }
    }

    public void onAdClicked(AdTraceInfo adTraceInfo) {
        AdLogger.m29883d("AdLoadListennerWrapper onAdClicked " + adTraceInfo);
        AdLoadListenner adLoadListenner = this.parent;
        if (adLoadListenner != null) {
            adLoadListenner.onAdClicked(adTraceInfo);
        }
    }

    public void onAdImpression(AdTraceInfo adTraceInfo) {
        AdLogger.m29883d("AdLoadListennerWrapper onAdImpression " + adTraceInfo);
        AdLoadListenner adLoadListenner = this.parent;
        if (adLoadListenner != null) {
            adLoadListenner.onAdImpression(adTraceInfo);
        }
    }
}
