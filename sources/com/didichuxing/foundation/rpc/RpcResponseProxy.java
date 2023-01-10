package com.didichuxing.foundation.rpc;

import com.didichuxing.foundation.net.http.HttpHeader;
import java.io.IOException;
import java.util.List;

public class RpcResponseProxy<T> {

    /* renamed from: a */
    private final T f50183a;

    /* renamed from: b */
    private final RpcResponse f50184b;

    RpcResponseProxy(RpcResponse rpcResponse) throws IOException {
        this.f50183a = rpcResponse.getContent();
        this.f50184b = rpcResponse;
    }

    public RpcRequest getRequest() {
        return this.f50184b.getRequest();
    }

    public T getContent() {
        return this.f50183a;
    }

    public RpcProtocol getProtocol() {
        return this.f50184b.getProtocol();
    }

    public int getStatus() {
        return this.f50184b.getStatus();
    }

    public boolean isSuccessful() {
        return this.f50184b.isSuccessful();
    }

    public List<HttpHeader> getHeaders() {
        return this.f50184b.getHeaders();
    }
}
