package com.didi.entrega.customer.foundation.rpc.header;

import com.didichuxing.foundation.net.rpc.http.HttpRpcClient;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;

public abstract class AbsHttpHeaderContentProvider {

    /* renamed from: a */
    private HttpRpcRequest f21867a;

    /* renamed from: b */
    private HttpRpcClient f21868b;

    public abstract String getParamContent();

    public abstract String getParamKey();

    public AbsHttpHeaderContentProvider(HttpRpcRequest httpRpcRequest, HttpRpcClient httpRpcClient) {
        this.f21867a = httpRpcRequest;
        this.f21868b = httpRpcClient;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public HttpRpcClient mo65729a() {
        return this.f21868b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public HttpRpcRequest mo65730b() {
        return this.f21867a;
    }
}
