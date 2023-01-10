package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.api.Api;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class Common {
    public static final Api<Api.ApiOptions.NoOptions> API;
    public static final Api.ClientKey<zah> CLIENT_KEY = new Api.ClientKey<>();
    public static final zae zaa = new zae();
    private static final Api.AbstractClientBuilder zab;

    static {
        zab zab2 = new zab();
        zab = zab2;
        API = new Api<>("Common.API", zab2, CLIENT_KEY);
    }
}
