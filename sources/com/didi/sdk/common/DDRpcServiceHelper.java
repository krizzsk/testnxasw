package com.didi.sdk.common;

import android.content.Context;
import com.didichuxing.foundation.rpc.RpcServiceFactory;

public class DDRpcServiceHelper {

    /* renamed from: b */
    private static DDRpcServiceHelper f38384b;

    /* renamed from: a */
    private RpcServiceFactory f38385a;

    private DDRpcServiceHelper(Context context) {
        this.f38385a = new RpcServiceFactory(context);
    }

    public static void init(Context context) {
        if (f38384b == null) {
            f38384b = new DDRpcServiceHelper(context.getApplicationContext());
        }
    }

    /* renamed from: a */
    private static DDRpcServiceHelper m28960a() {
        return f38384b;
    }

    public static RpcServiceFactory getRpcServiceFactory() {
        return m28960a().f38385a;
    }
}
