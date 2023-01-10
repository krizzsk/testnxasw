package com.didiglobal.pay.paysecure.tmx;

import android.net.Uri;
import com.didichuxing.foundation.net.rpc.http.HttpRpcInterceptor;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.didichuxing.foundation.rpc.RpcInterceptor;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didiglobal.pay.paysecure.util.PaySecureApollo;
import com.didiglobal.pay.paysecure.util.PaySecureLog;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@ServiceProvider(priority = Integer.MIN_VALUE, value = {RpcInterceptor.class})
@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u001c\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\nH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0002R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo148868d2 = {"Lcom/didiglobal/pay/paysecure/tmx/TMXHttpRpcInterceptor;", "Lcom/didichuxing/foundation/net/rpc/http/HttpRpcInterceptor;", "()V", "whiteApis", "", "", "getPayRiskInfo", "intercept", "Lcom/didichuxing/foundation/net/rpc/http/HttpRpcResponse;", "chain", "Lcom/didichuxing/foundation/rpc/RpcInterceptor$RpcChain;", "Lcom/didichuxing/foundation/net/rpc/http/HttpRpcRequest;", "isWhiteUrl", "", "url", "Companion", "paysecure_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: TMXHttpRpcInterceptor.kt */
public final class TMXHttpRpcInterceptor implements HttpRpcInterceptor {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: b */
    private static final String f52924b = "TMXHttpRpcInterceptor";

    /* renamed from: a */
    private List<String> f52925a;

    @Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo148868d2 = {"Lcom/didiglobal/pay/paysecure/tmx/TMXHttpRpcInterceptor$Companion;", "", "()V", "TAG", "", "paysecure_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
    /* compiled from: TMXHttpRpcInterceptor.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public HttpRpcResponse intercept(RpcInterceptor.RpcChain<HttpRpcRequest, HttpRpcResponse> rpcChain) {
        Intrinsics.checkParameterIsNotNull(rpcChain, "chain");
        HttpRpcRequest request = rpcChain.getRequest();
        Intrinsics.checkExpressionValueIsNotNull(request, "request");
        Uri parse = Uri.parse(request.getUrl());
        String uri = parse.toString();
        Intrinsics.checkExpressionValueIsNotNull(uri, "url.toString()");
        if (m39666a(uri)) {
            Uri.Builder buildUpon = parse.buildUpon();
            buildUpon.appendQueryParameter("payrisk_info", m39665a());
            String uri2 = buildUpon.build().toString();
            Intrinsics.checkExpressionValueIsNotNull(uri2, "builder.build().toString()");
            PaySecureLog.INSTANCE.mo129703e(f52924b, uri2);
            HttpRpcResponse proceed = rpcChain.proceed(request.newBuilder().setUrl(uri2).build());
            Intrinsics.checkExpressionValueIsNotNull(proceed, "chain.proceed(newRequest)");
            return proceed;
        }
        HttpRpcResponse proceed2 = rpcChain.proceed(request);
        Intrinsics.checkExpressionValueIsNotNull(proceed2, "chain.proceed(request)");
        return proceed2;
    }

    /* renamed from: a */
    private final String m39665a() {
        JSONObject jSONObject = new JSONObject();
        String apiSessionId = TMXProfilingMgr.INSTANCE.getApiSessionId();
        if (apiSessionId == null) {
            apiSessionId = "";
        }
        jSONObject.put("ln_session_id", apiSessionId);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "json.toString()");
        return jSONObject2;
    }

    /* renamed from: a */
    private final boolean m39666a(String str) {
        Collection collection = this.f52925a;
        if (collection == null || collection.isEmpty()) {
            this.f52925a = PaySecureApollo.INSTANCE.getTMXApolloApis();
        }
        List<String> list = this.f52925a;
        if (list != null) {
            for (String contains$default : list) {
                if (StringsKt.contains$default((CharSequence) str, (CharSequence) contains$default, false, 2, (Object) null)) {
                    return true;
                }
            }
        }
        return false;
    }
}
