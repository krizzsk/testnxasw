package com.didi.travel.p172v2.biz;

import android.os.SystemClock;
import android.text.TextUtils;
import com.didi.travel.p172v2.TravelSDKV2;
import com.didi.travel.p172v2.biz.IBiz;
import com.didi.travel.p172v2.biz.api.Api;
import com.didi.travel.p172v2.biz.api.ApiInvokePolicy;
import com.didi.travel.p172v2.biz.api.ApiProxy;
import com.didi.travel.p172v2.biz.api.IIApi;
import com.didi.travel.p172v2.biz.bff.BffProxy;
import com.didi.travel.p172v2.biz.bff.IIBff;
import com.didi.travel.p172v2.biz.common.CommonProxy;
import com.didi.travel.p172v2.biz.rpc.IIRpc;
import com.didi.travel.p172v2.biz.rpc.IRpcDynamicHostCallback;
import com.didi.travel.p172v2.biz.rpc.RpcCommonParamListener;
import com.didi.travel.p172v2.biz.rpc.RpcProxy;
import com.didi.travel.p172v2.util.LogUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.didi.travel.v2.biz.BizProxy */
public final class BizProxy<T extends IBiz> implements InvocationHandler {

    /* renamed from: a */
    private static final String f46945a = BizProxy.class.getSimpleName();

    /* renamed from: b */
    private final Biz<T> f46946b;

    /* renamed from: c */
    private final Class<T> f46947c;

    /* renamed from: d */
    private CommonProxy<T> f46948d;

    /* renamed from: e */
    private BffProxy<T> f46949e;

    /* renamed from: f */
    private HashMap<String, RpcProxy<T>> f46950f = new HashMap<>();

    /* renamed from: g */
    private HashMap<Method, ApiProxy<T>> f46951g = new HashMap<>();

    /* renamed from: h */
    private HashMap<Method, Api> f46952h = new HashMap<>();

    /* renamed from: i */
    private HashMap<String, Method> f46953i = new HashMap<>();

    /* renamed from: j */
    private Set<RpcCommonParamListener> f46954j = new HashSet();

    public BizProxy(Biz<T> biz) {
        this.f46946b = biz;
        this.f46947c = biz.getBizClass();
        long uptimeMillis = SystemClock.uptimeMillis();
        m34966a((Class) this.f46947c);
        long uptimeMillis2 = SystemClock.uptimeMillis();
        String str = f46945a;
        LogUtils.m34980i(str, "loadInterface spend time = " + (uptimeMillis2 - uptimeMillis) + ", startTime = " + uptimeMillis + ", endTime = " + uptimeMillis2);
    }

    public Method getMethod(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f46953i.get(str);
    }

    public Api getApi(Method method) {
        if (method == null) {
            return null;
        }
        return this.f46952h.get(method);
    }

    public void addRpcInvokeCommonParamListener(RpcCommonParamListener rpcCommonParamListener) {
        if (rpcCommonParamListener != null) {
            this.f46954j.add(rpcCommonParamListener);
        }
    }

    public void removeRpcInvokeCommonParamListener(RpcCommonParamListener rpcCommonParamListener) {
        if (rpcCommonParamListener != null) {
            this.f46954j.remove(rpcCommonParamListener);
        }
    }

    public Set<RpcCommonParamListener> getRpcInvokeCommonParamListenerList() {
        return new HashSet(this.f46954j);
    }

    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(this, objArr);
        }
        if (TravelSDKV2.isDebug()) {
            String str = f46945a;
            LogUtils.m34978d(str, "invoke:proxy = " + obj + ", method = " + method + ", args = " + objArr);
        }
        Api api = this.f46952h.get(method);
        if (api != null) {
            ApiProxy apiProxy = this.f46951g.get(method);
            if (apiProxy != null) {
                return apiProxy.invoke(api, obj, method, objArr);
            }
            throw new IllegalArgumentException(f46945a + ".invoke : apiProxy is null, method = " + method);
        }
        throw new IllegalStateException(f46945a + ".invoke : api is null, method = " + method);
    }

    /* renamed from: a */
    private void m34966a(Class cls) {
        LogUtils.m34981v(f46945a, "loadInterface:clz = " + cls);
        if (cls != null) {
            Method[] declaredMethods = cls.getDeclaredMethods();
            if (declaredMethods != null && declaredMethods.length > 0) {
                for (Method a : declaredMethods) {
                    m34967a(a);
                }
            }
            if (!IBiz.class.equals(cls)) {
                Class[] interfaces = cls.getInterfaces();
                if (interfaces.length > 0) {
                    for (Class cls2 : interfaces) {
                        LogUtils.m34981v(f46945a, "loadInterface.superInterface:item = " + cls2);
                        m34966a(cls2);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m34967a(Method method) {
        String str = f46945a;
        LogUtils.m34981v(str, "loadMethod:method = " + method);
        if (method != null && !Object.class.equals(method.getDeclaringClass())) {
            TravelSDKV2.checkMethod(method, f46945a);
            IIApi iIApi = (IIApi) method.getAnnotation(IIApi.class);
            ApiInvokePolicy apiInvokePolicy = iIApi.apiInvokePolicy();
            if (apiInvokePolicy == ApiInvokePolicy.INNER) {
                m34965a(iIApi, method);
            } else if (apiInvokePolicy == ApiInvokePolicy.BFF) {
                m34963a(iIApi, (IIBff) method.getAnnotation(IIBff.class), method);
            } else if (apiInvokePolicy == ApiInvokePolicy.RPC) {
                m34964a(iIApi, (IIRpc) method.getAnnotation(IIRpc.class), method);
            } else {
                throw new IllegalArgumentException(f46945a + ".loadMethod : unknown apiInvokePolicy = " + apiInvokePolicy + ", iiApi = " + iIApi + ", method = " + method);
            }
        }
    }

    /* renamed from: a */
    private void m34965a(IIApi iIApi, Method method) {
        if (this.f46948d == null) {
            this.f46948d = new CommonProxy<>(this.f46946b);
        }
        Api api = new Api(this.f46946b, iIApi);
        this.f46951g.put(method, this.f46948d);
        this.f46952h.put(method, api);
        this.f46953i.put(api.getKey(), method);
    }

    /* renamed from: a */
    private void m34963a(IIApi iIApi, IIBff iIBff, Method method) {
        if (this.f46949e == null) {
            this.f46949e = new BffProxy<>(this.f46946b);
        }
        Api api = new Api(this.f46946b, iIApi);
        api.setIIBff(iIBff);
        this.f46951g.put(method, this.f46949e);
        this.f46952h.put(method, api);
        this.f46953i.put(api.getKey(), method);
    }

    /* renamed from: a */
    private void m34964a(IIApi iIApi, IIRpc iIRpc, Method method) {
        Api api = new Api(this.f46946b, iIApi);
        api.setIIRpc(iIRpc);
        String a = m34962a(api, iIRpc);
        RpcProxy rpcProxy = this.f46950f.get(a);
        if (rpcProxy == null) {
            rpcProxy = new RpcProxy(this.f46946b, a);
            this.f46950f.put(a, rpcProxy);
        }
        this.f46951g.put(method, rpcProxy);
        this.f46952h.put(method, api);
        this.f46953i.put(api.getKey(), method);
    }

    /* renamed from: a */
    private String m34962a(Api api, IIRpc iIRpc) {
        if (api == null || iIRpc == null) {
            return "";
        }
        String hostKey = iIRpc.hostKey();
        String host = iIRpc.host();
        String sharePath = iIRpc.sharePath();
        IRpcDynamicHostCallback rpcDynamicHostCallback = api.getRpcDynamicHostCallback();
        if (rpcDynamicHostCallback == null) {
            rpcDynamicHostCallback = this.f46946b.getBizRpcDynamicHostCallback();
        }
        if (rpcDynamicHostCallback != null) {
            host = rpcDynamicHostCallback.getHost(api, hostKey, host);
            sharePath = rpcDynamicHostCallback.getSharePath(api, hostKey, sharePath);
        }
        return host + sharePath;
    }
}
