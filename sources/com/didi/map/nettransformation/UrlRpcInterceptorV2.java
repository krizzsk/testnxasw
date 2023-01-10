package com.didi.map.nettransformation;

import android.text.TextUtils;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.didichuxing.foundation.rpc.RpcInterceptor;
import java.io.IOException;

public class UrlRpcInterceptorV2 implements RpcInterceptor<HttpRpcRequest, HttpRpcResponse> {

    /* renamed from: a */
    private static final String f30301a = "https";

    /* renamed from: b */
    private static final String f30302b = "http";

    /* renamed from: c */
    private static final String f30303c = "net_transform_https2http_v2";

    public HttpRpcResponse intercept(RpcInterceptor.RpcChain<HttpRpcRequest, HttpRpcResponse> rpcChain) throws IOException {
        HttpRpcRequest request = rpcChain.getRequest();
        return rpcChain.proceed(request.newBuilder().setUrl(transformUrl2Http(request.getUrl())).build());
    }

    public static String transformUrl2Http(String str) {
        return (TextUtils.isEmpty(str) || str.length() < 8 || !Apollo.getToggle(f30303c).allow()) ? str : str.replaceFirst("https", "http");
    }
}
