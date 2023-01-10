package com.didiglobal.ibg_rpc_service.internal;

import com.didichuxing.foundation.spi.ServiceLoader;
import com.didiglobal.ibg_rpc_service.HttpRpcClientConfig;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, mo148868d2 = {"<anonymous>", "Lcom/didiglobal/ibg_rpc_service/HttpRpcClientConfig;"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: HttpClient.kt */
final class HttpClient$config$2 extends Lambda implements Function0<HttpRpcClientConfig> {
    public static final HttpClient$config$2 INSTANCE = new HttpClient$config$2();

    HttpClient$config$2() {
        super(0);
    }

    public final HttpRpcClientConfig invoke() {
        ServiceLoader<S> load = ServiceLoader.load(HttpRpcClientConfig.class);
        Intrinsics.checkNotNullExpressionValue(load, "load(HttpRpcClientConfig::class.java)");
        HttpRpcClientConfig httpRpcClientConfig = (HttpRpcClientConfig) CollectionsKt.firstOrNull(load);
        if (httpRpcClientConfig == null) {
            Logger.m39616v("HttpClient", "warning! no config for HttpRpcClient.Builder");
        }
        return httpRpcClientConfig;
    }
}
