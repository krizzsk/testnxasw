package com.didi.travel.p172v2.session;

import com.didi.travel.p172v2.TravelSDKV2;
import com.didi.travel.p172v2.biz.api.Api;
import com.didi.travel.p172v2.biz.api.RemoteCallback;

/* renamed from: com.didi.travel.v2.session.SessionRpcRemoteCallback */
public class SessionRpcRemoteCallback<T> extends RemoteCallback<T> {

    /* renamed from: a */
    private final Session f46998a;

    /* renamed from: b */
    private final Api f46999b;

    /* renamed from: c */
    private final Object[] f47000c;

    /* renamed from: d */
    private final RemoteCallback<T> f47001d;

    public SessionRpcRemoteCallback(Session session, Api api, Object[] objArr, RemoteCallback<T> remoteCallback) {
        this.f46998a = session;
        this.f46999b = api;
        this.f47000c = objArr;
        this.f47001d = remoteCallback;
    }

    public void onBizSuccess(T t) {
        super.onBizSuccess(t);
        TravelSDKV2.bindStoreLifeCycle(this.f46998a, this.f46999b, this.f47000c, t);
        RemoteCallback<T> remoteCallback = this.f47001d;
        if (remoteCallback != null) {
            remoteCallback.onBizSuccess(t);
        }
    }

    public void onBizFail(T t) {
        super.onBizFail(t);
        TravelSDKV2.bindStoreLifeCycle(this.f46998a, this.f46999b, this.f47000c, t);
        RemoteCallback<T> remoteCallback = this.f47001d;
        if (remoteCallback != null) {
            remoteCallback.onBizFail(t);
        }
    }

    public void onNetError(T t) {
        super.onNetError(t);
        TravelSDKV2.bindStoreLifeCycle(this.f46998a, this.f46999b, this.f47000c, t);
        RemoteCallback<T> remoteCallback = this.f47001d;
        if (remoteCallback != null) {
            remoteCallback.onNetError(t);
        }
    }

    public void onFinish(T t) {
        super.onFinish(t);
        RemoteCallback<T> remoteCallback = this.f47001d;
        if (remoteCallback != null) {
            remoteCallback.onFinish(t);
        }
    }
}
