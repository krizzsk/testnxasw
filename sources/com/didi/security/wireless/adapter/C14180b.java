package com.didi.security.wireless.adapter;

import android.content.Context;
import com.didi.onehybrid.FusionEngine;
import com.didi.sdk.push.PushClient;
import com.didi.sdk.push.PushKey;

/* renamed from: com.didi.security.wireless.adapter.b */
/* compiled from: SecurityInitializer */
class C14180b {

    /* renamed from: a */
    private static final int f41335a = 274;

    C14180b() {
    }

    /* renamed from: a */
    static void m31017a(Context context) {
        FusionEngine.export("WSGHybridModule", WSGHybridModule.class);
        m31016a();
    }

    /* renamed from: a */
    private static void m31016a() {
        PushClient.getClient().registerMessageListener(PushKey.Creator.createAppPushMsgKey(274), new SecurityInitializer$1());
    }
}
