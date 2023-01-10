package com.didi.travel.p172v2.biz;

import com.didi.travel.p172v2.biz.IBiz;
import com.didi.travel.p172v2.biz.rpc.IRpcDynamicHostCallback;
import com.didi.travel.p172v2.biz.rpc.RpcCommonParamListener;
import com.didi.travel.p172v2.util.LogUtils;
import java.lang.reflect.Proxy;

/* renamed from: com.didi.travel.v2.biz.Biz */
public final class Biz<T extends IBiz> {

    /* renamed from: a */
    private static final String f46939a = Biz.class.getSimpleName();

    /* renamed from: b */
    private final Class<T> f46940b;

    /* renamed from: c */
    private final IIBiz f46941c;

    /* renamed from: d */
    private final T f46942d;

    /* renamed from: e */
    private final BizProxy<T> f46943e = new BizProxy<>(this);

    /* renamed from: f */
    private IRpcDynamicHostCallback f46944f;

    public Biz(Class<T> cls) {
        this.f46940b = cls;
        this.f46941c = (IIBiz) cls.getAnnotation(IIBiz.class);
        this.f46942d = (IBiz) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, this.f46943e);
    }

    public String getKey() {
        return this.f46941c.key();
    }

    public Class<T> getBizClass() {
        return this.f46940b;
    }

    public T getIBiz() {
        return this.f46942d;
    }

    public BizProxy<T> getBizProxy() {
        return this.f46943e;
    }

    public IRpcDynamicHostCallback getBizRpcDynamicHostCallback() {
        IRpcDynamicHostCallback iRpcDynamicHostCallback = this.f46944f;
        if (iRpcDynamicHostCallback != null) {
            return iRpcDynamicHostCallback;
        }
        Class<? extends IRpcDynamicHostCallback> rpcDynamicHostImp = this.f46941c.rpcDynamicHostImp();
        try {
            this.f46944f = (IRpcDynamicHostCallback) rpcDynamicHostImp.newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            String str = f46939a;
            LogUtils.m34979e(str, "getBizRpcDynamicHostImp:clz = " + rpcDynamicHostImp + ", e = " + e);
            e.printStackTrace();
        }
        return this.f46944f;
    }

    public void addRpcInvokeBeforeListener(RpcCommonParamListener rpcCommonParamListener) {
        this.f46943e.addRpcInvokeCommonParamListener(rpcCommonParamListener);
    }

    public void removeRpcInvokeCommonParamListener(RpcCommonParamListener rpcCommonParamListener) {
        this.f46943e.removeRpcInvokeCommonParamListener(rpcCommonParamListener);
    }

    public String toString() {
        return "Biz{key=" + getKey() + ", mClass=" + this.f46940b + '}';
    }
}
