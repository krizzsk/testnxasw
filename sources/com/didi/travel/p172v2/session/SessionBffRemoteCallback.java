package com.didi.travel.p172v2.session;

import com.didi.travel.p172v2.TravelSDKV2;
import com.didi.travel.p172v2.biz.api.Api;
import com.didi.travel.p172v2.biz.api.RemoteCallback;

/* renamed from: com.didi.travel.v2.session.SessionBffRemoteCallback */
public class SessionBffRemoteCallback<T> extends RemoteCallback<T> {

    /* renamed from: a */
    private final Session f46990a;

    /* renamed from: b */
    private final Api f46991b;

    /* renamed from: c */
    private final Object[] f46992c;

    /* renamed from: d */
    private final RemoteCallback<T> f46993d;

    public SessionBffRemoteCallback(Session session, Api api, Object[] objArr, RemoteCallback<T> remoteCallback) {
        this.f46990a = session;
        this.f46991b = api;
        this.f46992c = objArr;
        this.f46993d = remoteCallback;
    }

    public void onBizSuccess(T t) {
        super.onBizSuccess(t);
        TravelSDKV2.bindStoreLifeCycle(this.f46990a, this.f46991b, this.f46992c, t);
        RemoteCallback<T> remoteCallback = this.f46993d;
        if (remoteCallback != null) {
            remoteCallback.onBizSuccess(t);
        }
    }

    public void onBizFail(T t) {
        super.onBizFail(t);
        TravelSDKV2.bindStoreLifeCycle(this.f46990a, this.f46991b, this.f46992c, t);
        RemoteCallback<T> remoteCallback = this.f46993d;
        if (remoteCallback != null) {
            remoteCallback.onBizFail(t);
        }
    }

    public void onNetError(T t) {
        super.onNetError(t);
        TravelSDKV2.bindStoreLifeCycle(this.f46990a, this.f46991b, this.f46992c, t);
        RemoteCallback<T> remoteCallback = this.f46993d;
        if (remoteCallback != null) {
            remoteCallback.onNetError(t);
        }
    }

    public void onFinish(T t) {
        super.onFinish(t);
        RemoteCallback<T> remoteCallback = this.f46993d;
        if (remoteCallback != null) {
            remoteCallback.onFinish(t);
        }
    }
}
