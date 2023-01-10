package com.didi.foundation.sdk.net;

import com.didi.foundation.sdk.application.FoundationApplicationListener;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import java.util.concurrent.ConcurrentHashMap;

public class SFRpcServiceFactory {

    /* renamed from: a */
    private static volatile SFRpcServiceFactory f23130a;

    /* renamed from: b */
    private static final Object f23131b = new Object();

    /* renamed from: c */
    private RpcServiceFactory f23132c = new RpcServiceFactory(FoundationApplicationListener.getApplication());

    /* renamed from: d */
    private ConcurrentHashMap<Class<?>, RpcService> f23133d = new ConcurrentHashMap<>();

    private SFRpcServiceFactory() {
    }

    /* renamed from: a */
    private static SFRpcServiceFactory m19041a() {
        if (f23130a == null) {
            synchronized (f23131b) {
                f23130a = new SFRpcServiceFactory();
            }
        }
        return f23130a;
    }

    public static <T extends RpcService> T getRpcService(Class<T> cls, String str) {
        T t = (RpcService) m19041a().f23133d.get(cls);
        if (t == null) {
            synchronized (cls) {
                t = m19041a().f23132c.newRpcService(cls, str);
                m19041a().f23133d.put(cls, t);
            }
        }
        return t;
    }

    public static void clearCache() {
        m19041a().f23133d.clear();
    }
}
