package com.didichuxing.foundation.rpc;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.foundation.net.UnsupportedSchemeException;
import com.didichuxing.foundation.spi.ServiceLoader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Iterator;

/* renamed from: com.didichuxing.foundation.rpc.b */
/* compiled from: RpcClientFactoryService */
class C16383b {

    /* renamed from: a */
    static final ServiceLoader<RpcClientFactory> f50188a = ServiceLoader.load(RpcClientFactory.class);

    /* renamed from: c */
    private static final String f50189c = "/sdcard/.rpc_crash_dump.log";

    /* renamed from: d */
    private static Object f50190d;

    /* renamed from: e */
    private static Method f50191e;

    /* renamed from: f */
    private static Object f50192f;

    /* renamed from: g */
    private static Method f50193g;

    /* renamed from: h */
    private static Method f50194h;

    /* renamed from: b */
    final Context f50195b;

    static {
        try {
            Class<?> cls = Class.forName("com.didichuxing.foundation.net.rpc.http.HttpRpcClientFactory");
            Constructor<?> constructor = cls.getConstructor(new Class[0]);
            if (constructor != null) {
                f50192f = constructor.newInstance(new Object[0]);
                f50193g = cls.getMethod("isSchemeSupported", new Class[]{String.class});
                f50194h = cls.getMethod("newRpcClient", new Class[]{Context.class});
            }
            Class<?> cls2 = Class.forName("didinet.ProblemTracking");
            f50190d = cls2.getMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
            f50191e = cls2.getMethod("recordContextInfo", new Class[]{Class.class, Boolean.TYPE, String.class});
        } catch (Throwable th) {
            if (C16382a.f50187a) {
                SystemUtils.log(3, "networking", "" + Log.getStackTraceString(th), (Throwable) null, "com.didichuxing.foundation.rpc.RpcClientFactoryService", 43);
            }
        }
    }

    public C16383b(Context context) {
        this.f50195b = context;
    }

    /* renamed from: a */
    public RpcClient<? extends RpcRequest, ? extends RpcResponse> mo123874a(Uri uri) {
        String scheme = uri.getScheme();
        Iterator<RpcClientFactory> it = f50188a.iterator();
        while (it.hasNext()) {
            RpcClientFactory next = it.next();
            if (next.isSchemeSupported(scheme)) {
                m37531a(getClass(), false, f50189c);
                return next.newRpcClient(this.f50195b);
            }
        }
        m37531a(getClass(), true, f50189c);
        try {
            if (!(f50192f == null || f50193g == null)) {
                if (((Boolean) f50193g.invoke(f50192f, new Object[]{scheme})).booleanValue() && f50194h != null) {
                    return (RpcClient) f50194h.invoke(f50192f, new Object[]{this.f50195b});
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        throw new UnsupportedSchemeException(scheme);
    }

    /* renamed from: a */
    private static void m37531a(Class cls, boolean z, String str) {
        Object obj;
        Method method = f50191e;
        if (method != null && (obj = f50190d) != null) {
            try {
                method.invoke(obj, new Object[]{cls, Boolean.valueOf(z), str});
            } catch (Throwable th) {
                if (C16382a.f50187a) {
                    SystemUtils.log(3, "networking", "" + Log.getStackTraceString(th), (Throwable) null, "com.didichuxing.foundation.rpc.RpcClientFactoryService", 90);
                }
            }
        }
    }
}
