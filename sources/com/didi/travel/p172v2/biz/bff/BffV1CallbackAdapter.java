package com.didi.travel.p172v2.biz.bff;

import com.didi.travel.p172v2.biz.api.Api;
import com.didi.travel.p172v2.biz.api.IRemoteCallbackContainer;
import com.didi.travel.p172v2.biz.api.RemoteCallback;
import com.didi.travel.p172v2.util.LogUtils;
import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.utils.GsonUtil;
import com.didichuxing.foundation.rpc.RpcService;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.didi.travel.v2.biz.bff.BffV1CallbackAdapter */
public class BffV1CallbackAdapter<T> implements IRemoteCallbackContainer<T>, RpcService.Callback<JsonObject> {
    protected final String TAG = getClass().getSimpleName();

    /* renamed from: a */
    private Api f46962a;

    /* renamed from: b */
    private final Class<T> f46963b;

    /* renamed from: c */
    private final RemoteCallback<T> f46964c;

    /* renamed from: d */
    private final Object[] f46965d;

    /* renamed from: e */
    private final Set<RemoteCallback<T>> f46966e = new HashSet();

    public BffV1CallbackAdapter(Api api, Class<T> cls, RemoteCallback<T> remoteCallback, Object[] objArr) {
        this.f46962a = api;
        this.f46963b = cls;
        this.f46964c = remoteCallback;
        this.f46965d = objArr;
    }

    public void onSuccess(JsonObject jsonObject) {
        String str = this.TAG;
        LogUtils.m34980i(str, ".onSuccess : value = " + jsonObject);
        if (BaseObject.class.isAssignableFrom(this.f46963b)) {
            Object newInstance = newInstance();
            if (newInstance != null) {
                ((BaseObject) newInstance).parse(jsonObject.toString());
            }
            if (!((BaseObject) newInstance).isAvailable()) {
                RemoteCallback<T> remoteCallback = this.f46964c;
                if (remoteCallback != null) {
                    remoteCallback.onBizFail(newInstance);
                    invokeBizFail(newInstance);
                    this.f46964c.onFinish(newInstance);
                    invokeFinish(newInstance);
                    return;
                }
                return;
            }
            RemoteCallback<T> remoteCallback2 = this.f46964c;
            if (remoteCallback2 != null) {
                remoteCallback2.onBizSuccess(newInstance);
                invokeBizSuccess(newInstance);
                this.f46964c.onFinish(newInstance);
                invokeFinish(newInstance);
                return;
            }
            return;
        }
        T objectFromJson = GsonUtil.objectFromJson(jsonObject.toString(), this.f46963b);
        RemoteCallback<T> remoteCallback3 = this.f46964c;
        if (remoteCallback3 != null) {
            remoteCallback3.onBizSuccess(objectFromJson);
            invokeBizSuccess(objectFromJson);
            this.f46964c.onFinish(objectFromJson);
            invokeFinish(objectFromJson);
        }
    }

    public void onFailure(IOException iOException) {
        String str = this.TAG;
        LogUtils.m34980i(str, ".onFailure : exception = " + iOException);
        Object newInstance = newInstance();
        RemoteCallback<T> remoteCallback = this.f46964c;
        if (remoteCallback != null) {
            remoteCallback.onNetError(newInstance);
            invokeNetError(newInstance);
            this.f46964c.onFinish(newInstance);
            invokeFinish(newInstance);
        }
    }

    /* access modifiers changed from: protected */
    public T newInstance() {
        Class<T> cls = this.f46963b;
        if (cls == null) {
            return null;
        }
        try {
            return cls.getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            String str = this.TAG;
            LogUtils.m34979e(str, "newInstance:invalid data clz, mDataClz = " + this.f46963b);
            e.printStackTrace();
            return null;
        }
    }

    public void addRemoteCallback(RemoteCallback<T> remoteCallback) {
        if (remoteCallback != null) {
            this.f46966e.add(remoteCallback);
        }
    }

    public void removeRemoteCallback(RemoteCallback<T> remoteCallback) {
        if (remoteCallback != null) {
            this.f46966e.remove(remoteCallback);
        }
    }

    /* access modifiers changed from: protected */
    public void invokeBizSuccess(T t) {
        for (RemoteCallback next : this.f46966e) {
            if (next != null) {
                next.onBizSuccess(t);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void invokeBizFail(T t) {
        for (RemoteCallback next : this.f46966e) {
            if (next != null) {
                next.onBizFail(t);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void invokeNetError(T t) {
        for (RemoteCallback next : this.f46966e) {
            if (next != null) {
                next.onNetError(t);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void invokeFinish(T t) {
        for (RemoteCallback next : this.f46966e) {
            if (next != null) {
                next.onFinish(t);
            }
        }
    }
}
