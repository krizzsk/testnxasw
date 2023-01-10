package com.didi.travel.p172v2.biz.api;

import com.android.didi.bfflib.business.BffResponseListener;

/* renamed from: com.didi.travel.v2.biz.api.IBffResponseListenerContainer */
public interface IBffResponseListenerContainer<T> {
    void addBffResponseListener(BffResponseListener<T> bffResponseListener);

    void removeBffResponseListener(BffResponseListener<T> bffResponseListener);
}
