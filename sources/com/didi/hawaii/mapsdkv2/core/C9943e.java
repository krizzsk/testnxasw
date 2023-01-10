package com.didi.hawaii.mapsdkv2.core;

import android.content.Context;

/* renamed from: com.didi.hawaii.mapsdkv2.core.e */
/* compiled from: MapContextImpl */
final class C9943e implements MapContext {

    /* renamed from: a */
    DefaultEGLContextFactory f26275a;

    /* renamed from: b */
    String f26276b;

    /* renamed from: c */
    private final Context f26277c;

    /* renamed from: d */
    private final Resources f26278d;

    /* renamed from: e */
    private GLHttpClient f26279e;

    private C9943e(Context context, GLHttpClient gLHttpClient) {
        Context applicationContext = context.getApplicationContext();
        this.f26277c = applicationContext;
        this.f26278d = new Resources(applicationContext, this);
        this.f26279e = gLHttpClient;
    }

    /* renamed from: a */
    static C9943e m20756a(Context context, GLHttpClient gLHttpClient) {
        return new C9943e(context, gLHttpClient);
    }

    public Context getAndroidContext() {
        return this.f26277c;
    }

    public Resources getResources() {
        return this.f26278d;
    }

    public GLHttpClient getHttpClient() {
        return this.f26279e;
    }
}
