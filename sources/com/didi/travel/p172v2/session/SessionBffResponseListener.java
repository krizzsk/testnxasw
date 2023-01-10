package com.didi.travel.p172v2.session;

import com.android.didi.bfflib.business.BffResponseListener;
import com.didi.travel.p172v2.TravelSDKV2;
import com.didi.travel.p172v2.biz.api.Api;

/* renamed from: com.didi.travel.v2.session.SessionBffResponseListener */
public class SessionBffResponseListener<T> extends BffResponseListener<T> {

    /* renamed from: a */
    private final Session f46994a;

    /* renamed from: b */
    private final Api f46995b;

    /* renamed from: c */
    private final Object[] f46996c;

    /* renamed from: d */
    private final BffResponseListener<T> f46997d;

    public SessionBffResponseListener(Session session, Api api, Object[] objArr, BffResponseListener<T> bffResponseListener) {
        this.f46994a = session;
        this.f46995b = api;
        this.f46996c = objArr;
        this.f46997d = bffResponseListener;
    }

    public void onSuccess(T t) {
        super.onSuccess(t);
        TravelSDKV2.bindStoreLifeCycle(this.f46994a, this.f46995b, this.f46996c, t);
        BffResponseListener<T> bffResponseListener = this.f46997d;
        if (bffResponseListener != null) {
            bffResponseListener.onSuccess(t);
        }
    }

    public void onFail(T t) {
        super.onFail(t);
        TravelSDKV2.bindStoreLifeCycle(this.f46994a, this.f46995b, this.f46996c, t);
        BffResponseListener<T> bffResponseListener = this.f46997d;
        if (bffResponseListener != null) {
            bffResponseListener.onFail(t);
        }
    }

    public void onError(T t) {
        super.onError(t);
        TravelSDKV2.bindStoreLifeCycle(this.f46994a, this.f46995b, this.f46996c, t);
        BffResponseListener<T> bffResponseListener = this.f46997d;
        if (bffResponseListener != null) {
            bffResponseListener.onError(t);
        }
    }

    public void onFinish(T t) {
        super.onFinish(t);
        BffResponseListener<T> bffResponseListener = this.f46997d;
        if (bffResponseListener != null) {
            bffResponseListener.onFinish(t);
        }
    }
}
