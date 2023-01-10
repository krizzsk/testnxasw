package com.didi.travel.p172v2.biz.api;

import com.android.didi.bfflib.business.BffResponseListener;
import com.didi.travel.p172v2.IKey;
import com.didi.travel.p172v2.biz.Biz;
import com.didi.travel.p172v2.biz.bff.BffV1InvokeCallback;
import com.didi.travel.p172v2.biz.bff.BffV2InvokeCallback;
import com.didi.travel.p172v2.biz.bff.IIBff;
import com.didi.travel.p172v2.biz.rpc.IIRpc;
import com.didi.travel.p172v2.biz.rpc.IRpcDynamicHostCallback;
import com.didi.travel.p172v2.biz.rpc.RpcInvokeCallback;
import com.didi.travel.p172v2.store.IStoreCallback;
import com.didi.travel.p172v2.util.LogUtils;
import java.lang.reflect.InvocationTargetException;

/* renamed from: com.didi.travel.v2.biz.api.Api */
public final class Api implements IKey {

    /* renamed from: a */
    private static final String f46955a = Api.class.getSimpleName();

    /* renamed from: b */
    private final Biz f46956b;

    /* renamed from: c */
    private final IIApi f46957c;

    /* renamed from: d */
    private IIRpc f46958d;

    /* renamed from: e */
    private IIBff f46959e;

    /* renamed from: f */
    private IRpcDynamicHostCallback f46960f;

    /* renamed from: g */
    private IStoreCallback f46961g;

    public Api(Biz biz, IIApi iIApi) {
        if (biz != null) {
            this.f46956b = biz;
            this.f46957c = iIApi;
            return;
        }
        throw new NullPointerException(f46955a + ".new:biz is null");
    }

    public String getBizKey() {
        return this.f46956b.getKey();
    }

    public ApiInvokePolicy getApiInvokePolicy() {
        return this.f46957c.apiInvokePolicy();
    }

    public DataLevel getStoreDataLevel() {
        return this.f46957c.storeDataLevel();
    }

    public IIRpc getIIRpc() {
        return this.f46958d;
    }

    public void setIIRpc(IIRpc iIRpc) {
        if (this.f46957c.apiInvokePolicy() == ApiInvokePolicy.RPC) {
            this.f46958d = iIRpc;
            return;
        }
        String str = f46955a;
        LogUtils.m34979e(str, "setIIRpc:invalid invoke, api = " + this);
        throw new IllegalStateException(f46955a + ".setIIRpc:api = " + this);
    }

    public IIBff getIIBff() {
        return this.f46959e;
    }

    public void setIIBff(IIBff iIBff) {
        if (this.f46957c.apiInvokePolicy() == ApiInvokePolicy.BFF) {
            this.f46959e = iIBff;
            return;
        }
        String str = f46955a;
        LogUtils.m34979e(str, "setIIBff:invalid invoke, api = " + this);
        throw new IllegalStateException(f46955a + ".setIIBff:api = " + this);
    }

    public IRpcDynamicHostCallback getRpcDynamicHostCallback() {
        IRpcDynamicHostCallback iRpcDynamicHostCallback = this.f46960f;
        if (iRpcDynamicHostCallback != null) {
            return iRpcDynamicHostCallback;
        }
        IIRpc iIRpc = this.f46958d;
        if (iIRpc == null) {
            return null;
        }
        Class<? extends IRpcDynamicHostCallback> dynamicHostImp = iIRpc.dynamicHostImp();
        if (IRpcDynamicHostCallback.class.equals(dynamicHostImp)) {
            return null;
        }
        try {
            this.f46960f = (IRpcDynamicHostCallback) dynamicHostImp.newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            String str = f46955a;
            LogUtils.m34979e(str, "getRpcDynamicHostCallback:api = " + this + ", clz = " + dynamicHostImp + ", e = " + e);
            e.printStackTrace();
        }
        return this.f46960f;
    }

    public IApiInvokeCallback instanceApiInvokeCallback() {
        Class<? extends IApiInvokeCallback> apiInvokeCallbackImp = this.f46957c.apiInvokeCallbackImp();
        try {
            return (IApiInvokeCallback) apiInvokeCallbackImp.newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            String str = f46955a;
            LogUtils.m34979e(str, "instanceApiInvokeCallback:invalid class, api = " + this + ", clz = " + apiInvokeCallbackImp + ", exception = " + e);
            e.printStackTrace();
            return null;
        }
    }

    public RpcInvokeCallback instanceRpcInvokeCallback(RemoteCallback remoteCallback) {
        IIRpc iIRpc = this.f46958d;
        if (iIRpc == null) {
            LogUtils.m34979e(f46955a, "instanceRpcInvokeCallback:mIIRpc is null");
            return null;
        }
        Class<? extends RpcInvokeCallback> rpcInvokeCallbackImp = iIRpc.rpcInvokeCallbackImp();
        try {
            return (RpcInvokeCallback) rpcInvokeCallbackImp.getConstructor(new Class[]{RemoteCallback.class}).newInstance(new Object[]{remoteCallback});
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            String str = f46955a;
            LogUtils.m34979e(str, "instanceRpcInvokeCallback:invalid class, api = " + this + ", clz = " + rpcInvokeCallbackImp + ", exception = " + e);
            e.printStackTrace();
            return null;
        }
    }

    public BffV1InvokeCallback instanceBffV1InvokeCallback(Api api, Object[] objArr, RemoteCallback remoteCallback) {
        IIBff iIBff = this.f46959e;
        if (iIBff == null) {
            LogUtils.m34979e(f46955a, "instanceBffV1InvokeCallback:mIIBff is null");
            return null;
        }
        Class<? extends BffV1InvokeCallback> bffV1InvokeCallbackImp = iIBff.bffV1InvokeCallbackImp();
        try {
            return (BffV1InvokeCallback) bffV1InvokeCallbackImp.getConstructor(new Class[]{Api.class, Object[].class, RemoteCallback.class}).newInstance(new Object[]{api, objArr, remoteCallback});
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            String str = f46955a;
            LogUtils.m34979e(str, "instanceBffV1InvokeCallback:invalid class, api = " + this + ", clz = " + bffV1InvokeCallbackImp + ", exception = " + e);
            e.printStackTrace();
            return null;
        }
    }

    public BffV2InvokeCallback instanceBffV2ApiInvokeCallback(Api api, Object[] objArr, BffResponseListener bffResponseListener) {
        IIBff iIBff = this.f46959e;
        if (iIBff == null) {
            LogUtils.m34979e(f46955a, "instanceBffV2ApiInvokeCallback:mIIBff is null");
            return null;
        }
        Class<? extends BffV2InvokeCallback> bffV2InvokeCallbackImp = iIBff.bffV2InvokeCallbackImp();
        try {
            return (BffV2InvokeCallback) bffV2InvokeCallbackImp.getConstructor(new Class[]{Api.class, Object[].class, BffResponseListener.class}).newInstance(new Object[]{api, objArr, bffResponseListener});
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            String str = f46955a;
            LogUtils.m34979e(str, "instanceBffV2ApiInvokeCallback:invalid class, api = " + this + ", clz = " + bffV2InvokeCallbackImp + ", exception = " + e);
            e.printStackTrace();
            return null;
        }
    }

    public IStoreCallback getApiStoreCallback() {
        IStoreCallback iStoreCallback = this.f46961g;
        if (iStoreCallback != null) {
            return iStoreCallback;
        }
        Class<? extends IStoreCallback> apiStoreCallbackImp = this.f46957c.apiStoreCallbackImp();
        if (IStoreCallback.class.equals(apiStoreCallbackImp)) {
            return null;
        }
        try {
            this.f46961g = (IStoreCallback) apiStoreCallbackImp.newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            String str = f46955a;
            LogUtils.m34979e(str, "getApiStoreCallback:invalid class, api = " + this + ", clz = " + apiStoreCallbackImp + ", exception = " + e);
            e.printStackTrace();
        }
        return this.f46961g;
    }

    public String getKey() {
        return this.f46957c.key();
    }

    public String toString() {
        return "Api{mBizKey='" + getBizKey() + '\'' + ", mApiKey='" + this.f46957c.key() + '\'' + '}';
    }
}
