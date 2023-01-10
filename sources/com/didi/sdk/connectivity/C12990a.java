package com.didi.sdk.connectivity;

import android.util.Log;
import com.didi.sdk.apm.SystemUtils;
import didinet.ApolloAPI;
import didinet.NetEngine;

/* renamed from: com.didi.sdk.connectivity.a */
/* compiled from: ApolloProvider */
class C12990a implements ConfigProvider<Config> {

    /* renamed from: a */
    private static final String f38523a = "net-connectivity";

    /* renamed from: b */
    private Config f38524b;

    C12990a() {
    }

    /* renamed from: a */
    public Config provider() {
        Config config = this.f38524b;
        if (config != null) {
            return config;
        }
        ApolloAPI apolloAPI = NetEngine.getInstance().getApolloAPI();
        if (apolloAPI == null || !apolloAPI.getToggle(f38523a).allow()) {
            return null;
        }
        try {
            Config a = Config.m29022a(apolloAPI.getToggle(f38523a).getExperiment());
            this.f38524b = a;
            return a;
        } catch (Throwable th) {
            SystemUtils.log(3, "connectivity", Log.getStackTraceString(th), (Throwable) null, "com.didi.sdk.connectivity.ApolloProvider", 32);
            return null;
        }
    }
}
