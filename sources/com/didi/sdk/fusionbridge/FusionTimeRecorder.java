package com.didi.sdk.fusionbridge;

import android.content.Context;
import android.net.Uri;
import com.didi.onehybrid.FusionEngine;
import com.didi.onehybrid.util.C11212Util;
import com.didi.onehybrid.util.NetworkUtil;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.Utils;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;

public class FusionTimeRecorder {

    /* renamed from: a */
    private static final String f38714a = "tone_p_x_fusion_render_from_native";

    /* renamed from: b */
    private static final String f38715b = "page_url";

    /* renamed from: c */
    private static final String f38716c = "fusion_optimize";

    /* renamed from: d */
    private static final String f38717d = "cache_count";

    /* renamed from: e */
    private static final String f38718e = "nt_type";

    /* renamed from: f */
    private static final String f38719f = "is_debug";

    /* renamed from: g */
    private static final String f38720g = "webview_init_time";

    /* renamed from: h */
    private static final String f38721h = "first_h5_time";

    /* renamed from: i */
    private static final String f38722i = "render_time";

    /* renamed from: j */
    private static final String f38723j = "total_time";

    /* renamed from: k */
    private final String f38724k;

    /* renamed from: l */
    private final boolean f38725l;

    /* renamed from: m */
    private long f38726m = -1;

    /* renamed from: n */
    private long f38727n = -1;

    /* renamed from: o */
    private long f38728o = -1;

    /* renamed from: p */
    private long f38729p = -1;

    /* renamed from: q */
    private int f38730q = 0;

    /* renamed from: r */
    private boolean f38731r = false;

    public FusionTimeRecorder(String str, boolean z) {
        this.f38724k = str;
        this.f38725l = z;
    }

    public void activityStarted() {
        this.f38726m = System.currentTimeMillis();
    }

    public void beginLoadUrl() {
        this.f38727n = System.currentTimeMillis();
    }

    public void pageStarted() {
        this.f38728o = System.currentTimeMillis();
    }

    public void pageFinished() {
        this.f38729p = System.currentTimeMillis();
    }

    public void setFromCache(Uri uri, boolean z) {
        if (uri != null && z) {
            this.f38730q++;
        }
    }

    public void flush(Context context) {
        if (!this.f38731r && this.f38726m != -1 && this.f38728o != -1 && this.f38729p != -1) {
            HashMap hashMap = new HashMap();
            hashMap.put(f38715b, this.f38724k);
            hashMap.put(f38716c, Integer.valueOf((!this.f38725l || (!FusionEngine.isWebViewPreInited() && this.f38730q <= 0)) ? 0 : 1));
            hashMap.put(f38717d, Integer.valueOf(this.f38730q));
            hashMap.put(f38718e, Integer.valueOf(NetworkUtil.getSimpleNetworkType(context)));
            hashMap.put(f38719f, Integer.valueOf(Utils.isDebug(context) ? 1 : 0));
            hashMap.put(f38720g, Long.valueOf(this.f38727n - this.f38726m));
            hashMap.put(f38721h, Long.valueOf(this.f38728o - this.f38727n));
            hashMap.put(f38722i, Long.valueOf(this.f38729p - this.f38728o));
            hashMap.put("total_time", Long.valueOf(this.f38729p - this.f38726m));
            if (C11212Util.isApkDebug(context)) {
                SystemUtils.log(4, "FusionTime", hashMap.toString(), (Throwable) null, "com.didi.sdk.fusionbridge.FusionTimeRecorder", 116);
            }
            OmegaSDKAdapter.trackEvent("tone_p_x_fusion_render_from_native", (Map<String, Object>) hashMap);
            this.f38731r = true;
        }
    }
}
