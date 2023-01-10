package com.didi.travel.psnger.p171v2.api;

import com.didi.travel.p172v2.biz.api.RemoteCallback;
import com.didi.travel.psnger.common.net.base.ResponseListener;

/* renamed from: com.didi.travel.psnger.v2.api.ResponseListenerAdapter */
public class ResponseListenerAdapter<T> extends RemoteCallback<T> {

    /* renamed from: a */
    private final ResponseListener<T> f46909a;

    public ResponseListenerAdapter(ResponseListener<T> responseListener) {
        this.f46909a = responseListener;
    }

    public void onBizSuccess(T t) {
        super.onBizSuccess(t);
        ResponseListener<T> responseListener = this.f46909a;
        if (responseListener != null) {
            responseListener.onSuccess(t);
        }
    }

    public void onBizFail(T t) {
        super.onBizFail(t);
        ResponseListener<T> responseListener = this.f46909a;
        if (responseListener != null) {
            responseListener.onFail(t);
        }
    }

    public void onNetError(T t) {
        super.onNetError(t);
        ResponseListener<T> responseListener = this.f46909a;
        if (responseListener != null) {
            responseListener.onError(t);
        }
    }

    public void onFinish(T t) {
        super.onFinish(t);
        ResponseListener<T> responseListener = this.f46909a;
        if (responseListener != null) {
            responseListener.onFinish(t);
        }
    }
}
