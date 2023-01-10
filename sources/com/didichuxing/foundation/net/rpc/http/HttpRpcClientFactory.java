package com.didichuxing.foundation.net.rpc.http;

import android.content.Context;
import com.didichuxing.foundation.net.AbstractSchemeSupport;
import com.didichuxing.foundation.net.rpc.http.OkHttpRpcClient;
import com.didichuxing.foundation.rpc.RpcClientFactory;

public class HttpRpcClientFactory extends AbstractSchemeSupport implements C16376a, RpcClientFactory {
    public String[] getSupportedSchemes() {
        return f50176c;
    }

    public HttpRpcClient newRpcClient(Context context) {
        return new OkHttpRpcClient.Builder().setContext(context.getApplicationContext()).build();
    }
}
