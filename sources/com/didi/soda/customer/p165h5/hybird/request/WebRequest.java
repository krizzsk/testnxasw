package com.didi.soda.customer.p165h5.hybird.request;

import android.net.Uri;
import com.didi.onehybrid.jsbridge.CallbackFunction;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.web.model.CallBackModel;
import com.didi.soda.web.tools.WebJsBridgeTool;
import com.didichuxing.foundation.net.http.HttpBody;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.rpc.RpcClient;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcResponse;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(mo148867d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u001c\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J$\u0010\u0010\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u001c\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\n\u0010\u0012\u001a\u00060\u0013j\u0002`\u0014H\u0002J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0017"}, mo148868d2 = {"Lcom/didi/soda/customer/h5/hybird/request/WebRequest;", "", "()V", "callbackError", "", "callback", "Lcom/didi/onehybrid/jsbridge/CallbackFunction;", "errMsg", "", "newBody", "Lcom/didichuxing/foundation/net/http/HttpBody;", "json", "Lorg/json/JSONObject;", "onWebRequestSuccess", "response", "Lcom/didichuxing/foundation/rpc/RpcResponse;", "serialize", "key", "builder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "transRequest", "params", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.soda.customer.h5.hybird.request.WebRequest */
/* compiled from: WebRequest.kt */
public final class WebRequest {
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0062, code lost:
        if (r6 == null) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0064, code lost:
        r0 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0065, code lost:
        m32761a(r7, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0080, code lost:
        if (r6 == null) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m32762a(com.didichuxing.foundation.rpc.RpcResponse r6, com.didi.onehybrid.jsbridge.CallbackFunction r7) {
        /*
            r5 = this;
            java.lang.String r0 = ""
            boolean r1 = r6 instanceof com.didichuxing.foundation.net.rpc.http.HttpRpcResponse
            r2 = 0
            if (r1 == 0) goto L_0x000a
            com.didichuxing.foundation.net.rpc.http.HttpRpcResponse r6 = (com.didichuxing.foundation.net.rpc.http.HttpRpcResponse) r6
            goto L_0x000b
        L_0x000a:
            r6 = r2
        L_0x000b:
            if (r6 != 0) goto L_0x000e
            goto L_0x0019
        L_0x000e:
            com.didichuxing.foundation.net.http.HttpEntity r6 = r6.getEntity()
            if (r6 != 0) goto L_0x0015
            goto L_0x0019
        L_0x0015:
            java.io.InputStream r2 = r6.getContent()
        L_0x0019:
            if (r2 != 0) goto L_0x0022
            java.lang.String r6 = "请求的结果为Null"
            r5.m32761a((com.didi.onehybrid.jsbridge.CallbackFunction) r7, (java.lang.String) r6)
            goto L_0x0083
        L_0x0022:
            java.io.BufferedInputStream r6 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x006b }
            r6.<init>(r2)     // Catch:{ Exception -> 0x006b }
            java.io.InputStream r6 = (java.io.InputStream) r6     // Catch:{ Exception -> 0x006b }
            byte[] r6 = com.didichuxing.foundation.p188io.Streams.readFullyNoClose((java.io.InputStream) r6)     // Catch:{ Exception -> 0x006b }
            java.lang.String r1 = "bytes"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r1)     // Catch:{ Exception -> 0x006b }
            java.nio.charset.Charset r1 = com.didi.soda.customer.app.constant.CharsetConst.CHARSET_UTF_8     // Catch:{ Exception -> 0x006b }
            java.lang.String r3 = "CHARSET_UTF_8"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)     // Catch:{ Exception -> 0x006b }
            java.lang.String r3 = new java.lang.String     // Catch:{ Exception -> 0x006b }
            r3.<init>(r6, r1)     // Catch:{ Exception -> 0x006b }
            if (r7 == 0) goto L_0x0059
            com.didi.soda.web.model.CallBackModel r6 = new com.didi.soda.web.model.CallBackModel     // Catch:{ Exception -> 0x006b }
            java.lang.String r1 = "ok"
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x006b }
            r4.<init>(r3)     // Catch:{ Exception -> 0x006b }
            r3 = 0
            r6.<init>(r3, r1, r4)     // Catch:{ Exception -> 0x006b }
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x006b }
            org.json.JSONObject r6 = com.didi.soda.web.tools.WebJsBridgeTool.buildResponse((com.didi.soda.web.model.CallBackModel) r6)     // Catch:{ Exception -> 0x006b }
            r1[r3] = r6     // Catch:{ Exception -> 0x006b }
            r7.onCallBack(r1)     // Catch:{ Exception -> 0x006b }
        L_0x0059:
            r2.close()     // Catch:{ Exception -> 0x005d }
            goto L_0x0083
        L_0x005d:
            r6 = move-exception
            java.lang.String r6 = r6.getMessage()
            if (r6 == 0) goto L_0x0065
        L_0x0064:
            r0 = r6
        L_0x0065:
            r5.m32761a((com.didi.onehybrid.jsbridge.CallbackFunction) r7, (java.lang.String) r0)
            goto L_0x0083
        L_0x0069:
            r6 = move-exception
            goto L_0x0084
        L_0x006b:
            r6 = move-exception
            java.lang.String r6 = r6.getMessage()     // Catch:{ all -> 0x0069 }
            if (r6 == 0) goto L_0x0073
            goto L_0x0074
        L_0x0073:
            r6 = r0
        L_0x0074:
            r5.m32761a((com.didi.onehybrid.jsbridge.CallbackFunction) r7, (java.lang.String) r6)     // Catch:{ all -> 0x0069 }
            r2.close()     // Catch:{ Exception -> 0x007b }
            goto L_0x0083
        L_0x007b:
            r6 = move-exception
            java.lang.String r6 = r6.getMessage()
            if (r6 == 0) goto L_0x0065
            goto L_0x0064
        L_0x0083:
            return
        L_0x0084:
            r2.close()     // Catch:{ Exception -> 0x0088 }
            goto L_0x0093
        L_0x0088:
            r1 = move-exception
            java.lang.String r1 = r1.getMessage()
            if (r1 == 0) goto L_0x0090
            r0 = r1
        L_0x0090:
            r5.m32761a((com.didi.onehybrid.jsbridge.CallbackFunction) r7, (java.lang.String) r0)
        L_0x0093:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.p165h5.hybird.request.WebRequest.m32762a(com.didichuxing.foundation.rpc.RpcResponse, com.didi.onehybrid.jsbridge.CallbackFunction):void");
    }

    public final void transRequest(JSONObject jSONObject, CallbackFunction callbackFunction) {
        Intrinsics.checkNotNullParameter(jSONObject, "params");
        WebRequestModel create = WebRequestModel.f43921a.create(jSONObject);
        if (!create.mo111607f()) {
            m32761a(callbackFunction, "入参不符合要求，请检查入参!!!");
        }
        RpcClient build = new RpcServiceFactory(GlobalContext.getContext()).getRpcClient(Uri.parse(create.mo111597a()).getScheme()).newBuilder().setConnectTimeout(create.mo111606e()).setReadTimeout(create.mo111606e()).setWriteTimeout(create.mo111606e()).build();
        HttpRpcRequest build2 = new HttpRpcRequest.Builder().setUrl(create.mo111597a()).setRpcClient((RpcClient<? extends RpcRequest, ? extends RpcResponse>) build).post(m32760a(create.mo111604c())).build();
        Intrinsics.checkNotNullExpressionValue(build2, "Builder()\n            .s…ta))\n            .build()");
        build.newRpc(build2).enqueue(new WebRequest$transRequest$rpcCallback$1(this, callbackFunction));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m32761a(CallbackFunction callbackFunction, String str) {
        if (callbackFunction != null) {
            callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(new CallBackModel(1, str, (JSONObject) null)));
        }
    }

    /* renamed from: a */
    private final HttpBody m32760a(JSONObject jSONObject) {
        StringBuilder sb = new StringBuilder();
        if (jSONObject != null) {
            m32764a(jSONObject, sb);
        }
        HttpBody newInstance = HttpBody.newInstance("application/x-www-form-urlencoded", sb.toString());
        Intrinsics.checkNotNullExpressionValue(newInstance, "newInstance(\"application…, bodyBuilder.toString())");
        return newInstance;
    }

    /* renamed from: a */
    private final void m32764a(JSONObject jSONObject, StringBuilder sb) throws JSONException, IOException {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            m32763a(next, jSONObject.get(next).toString(), sb);
            if (keys.hasNext()) {
                sb.append(Typography.amp);
            }
        }
    }

    /* renamed from: a */
    private final void m32763a(String str, String str2, StringBuilder sb) throws JSONException, IOException {
        sb.append(str);
        sb.append('=');
        sb.append(URLEncoder.encode(str2, "UTF-8"));
    }
}
