package com.didi.soda.customer.foundation.rpc.header;

import com.didichuxing.foundation.net.rpc.http.HttpRpcClient;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;

public abstract class AbsHttpHeaderContentProvider {

    /* renamed from: a */
    private HttpRpcRequest f43639a;

    /* renamed from: b */
    private HttpRpcClient f43640b;

    public abstract String getParamContent();

    public abstract String getParamKey();

    public AbsHttpHeaderContentProvider(HttpRpcRequest httpRpcRequest, HttpRpcClient httpRpcClient) {
        this.f43639a = httpRpcRequest;
        this.f43640b = httpRpcClient;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public HttpRpcClient mo111215a() {
        return this.f43640b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public HttpRpcRequest mo111216b() {
        return this.f43639a;
    }
}
