package com.didi.onehybrid.resource;

import android.content.Context;
import com.didi.onehybrid.resource.FusionResourceManager;

public class FusionUrlPreLoader {
    public static long ActivityStart = -1;

    /* renamed from: a */
    private static final String f32155a = "FusionUrlPreLoader";

    /* renamed from: b */
    private static final short f32156b = 201;

    /* renamed from: c */
    private static final short f32157c = 202;

    /* renamed from: d */
    private static final short f32158d = 203;

    /* renamed from: e */
    private Context f32159e;

    /* renamed from: f */
    private String f32160f;

    /* renamed from: g */
    private FusionCacheClient f32161g = null;

    /* renamed from: h */
    private FusionHttpClient f32162h = null;

    /* renamed from: i */
    private volatile int f32163i = -1;

    /* renamed from: j */
    private FusionResourceManager.FusionResource f32164j;

    public FusionUrlPreLoader(Context context, String str) {
        this.f32159e = context;
        this.f32160f = str;
        ActivityStart = System.currentTimeMillis();
        this.f32161g = FusionCacheClient.sInstance;
    }

    public synchronized void startLoad() {
    }

    public synchronized FusionResourceManager.FusionResource getPreLoadResource() {
        this.f32163i = 202;
        return this.f32164j;
    }

    public synchronized boolean isValid() {
        return (this.f32163i == -1 || this.f32163i == 202) ? false : true;
    }

    public boolean isLoadFinished() {
        return this.f32163i == 203;
    }
}
