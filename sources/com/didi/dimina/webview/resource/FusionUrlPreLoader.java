package com.didi.dimina.webview.resource;

import android.content.Context;
import com.didi.dimina.webview.resource.FusionResourceManager;

public class FusionUrlPreLoader {
    public static long ActivityStart = -1;

    /* renamed from: a */
    private static final String f20212a = "FusionUrlPreLoader";

    /* renamed from: b */
    private static final short f20213b = 201;

    /* renamed from: c */
    private static final short f20214c = 202;

    /* renamed from: d */
    private static final short f20215d = 203;

    /* renamed from: e */
    private final Context f20216e;

    /* renamed from: f */
    private final String f20217f;

    /* renamed from: g */
    private FusionCacheClient f20218g = null;

    /* renamed from: h */
    private final FusionHttpClient f20219h = null;

    /* renamed from: i */
    private volatile int f20220i = -1;

    /* renamed from: j */
    private FusionResourceManager.FusionResource f20221j;

    public FusionUrlPreLoader(Context context, String str) {
        this.f20216e = context;
        this.f20217f = str;
        ActivityStart = System.currentTimeMillis();
        this.f20218g = FusionCacheClient.sInstance;
    }

    public synchronized FusionResourceManager.FusionResource getPreLoadResource() {
        this.f20220i = 202;
        return this.f20221j;
    }

    public synchronized boolean isValid() {
        return (this.f20220i == -1 || this.f20220i == 202) ? false : true;
    }

    public boolean isLoadFinished() {
        return this.f20220i == 203;
    }
}
