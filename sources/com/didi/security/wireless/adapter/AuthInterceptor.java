package com.didi.security.wireless.adapter;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.foundation.net.http.HttpBody;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.didichuxing.foundation.rpc.RpcInterceptor;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import java.io.IOException;

@ServiceProvider(priority = -990, value = {RpcInterceptor.class})
public class AuthInterceptor implements RpcInterceptor<HttpRpcRequest, HttpRpcResponse> {

    /* renamed from: a */
    private static final String f41313a = AuthInterceptor.class.getSimpleName();

    /* renamed from: b */
    private static volatile String f41314b = "";

    /* renamed from: c */
    private static final String f41315c = "secdd-authentication";

    /* renamed from: d */
    private static volatile SharedPreferences f41316d = null;

    public HttpRpcResponse intercept(RpcInterceptor.RpcChain<HttpRpcRequest, HttpRpcResponse> rpcChain) throws IOException {
        HttpRpcRequest request = rpcChain.getRequest();
        try {
            request = m31005a(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpRpcResponse proceed = rpcChain.proceed(request);
        String header = proceed.getHeader(f41315c);
        if (!TextUtils.isEmpty(header)) {
            m31007a(header);
        }
        return proceed;
    }

    /* renamed from: a */
    private HttpRpcRequest m31005a(HttpRpcRequest httpRpcRequest) {
        HttpRpcRequest httpRpcRequest2;
        try {
            byte[] b = m31009b(httpRpcRequest);
            if (b == null || b.length <= 0) {
                httpRpcRequest2 = httpRpcRequest;
            } else {
                httpRpcRequest2 = httpRpcRequest.newBuilder().setMethod(httpRpcRequest.getMethod(), HttpBody.newInstance(httpRpcRequest.getEntity().getContentType(), b)).build();
            }
            String b2 = m31008b();
            C14179a.m31015a(f41313a, String.format("[%s] sig => [%s]", new Object[]{f41313a, b2}));
            if (TextUtils.isEmpty(b2)) {
                return httpRpcRequest;
            }
            HttpRpcRequest.Builder newBuilder = httpRpcRequest2.newBuilder();
            newBuilder.removeHeaders(f41315c);
            newBuilder.addHeader(f41315c, b2);
            return newBuilder.build();
        } catch (Exception e) {
            e.printStackTrace();
            return httpRpcRequest;
        }
    }

    /* renamed from: a */
    private static synchronized void m31006a() {
        synchronized (AuthInterceptor.class) {
            if (f41316d == null && SecurityWrapper.sContext != null && f41316d == null) {
                f41316d = SystemUtils.getSharedPreferences(SecurityWrapper.sContext, "authToken", 0);
            }
        }
    }

    /* renamed from: b */
    private static String m31008b() {
        try {
            if (TextUtils.isEmpty(f41314b)) {
                m31006a();
                if (f41316d != null) {
                    f41314b = f41316d.getString("authToken", "");
                }
                if (TextUtils.isEmpty(f41314b)) {
                    f41314b = String.valueOf(System.currentTimeMillis() / 1000);
                }
            }
        } catch (Throwable unused) {
        }
        return f41314b;
    }

    /* renamed from: a */
    private static synchronized void m31007a(String str) {
        synchronized (AuthInterceptor.class) {
            try {
                if (!TextUtils.isEmpty(str) && !str.equals(f41314b)) {
                    f41314b = str;
                    if (f41316d != null) {
                        f41316d.edit().putString("authToken", str).commit();
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0030, code lost:
        if (r3 == null) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0023, code lost:
        if (r3 != null) goto L_0x0025;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] m31009b(com.didichuxing.foundation.net.rpc.http.HttpRpcRequest r6) {
        /*
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r1]
            r3 = 0
            com.didichuxing.foundation.net.http.HttpEntity r6 = r6.getEntity()     // Catch:{ Exception -> 0x0030, all -> 0x0029 }
            java.io.InputStream r3 = r6.getContent()     // Catch:{ Exception -> 0x0030, all -> 0x0029 }
            if (r3 == 0) goto L_0x0023
        L_0x0014:
            r6 = 0
            int r4 = r3.read(r2, r6, r1)     // Catch:{ Exception -> 0x0030, all -> 0x0029 }
            r5 = -1
            if (r4 == r5) goto L_0x0020
            r0.write(r2, r6, r4)     // Catch:{ Exception -> 0x0030, all -> 0x0029 }
            goto L_0x0014
        L_0x0020:
            r0.flush()     // Catch:{ Exception -> 0x0030, all -> 0x0029 }
        L_0x0023:
            if (r3 == 0) goto L_0x0033
        L_0x0025:
            r3.close()     // Catch:{ IOException -> 0x0033 }
            goto L_0x0033
        L_0x0029:
            r6 = move-exception
            if (r3 == 0) goto L_0x002f
            r3.close()     // Catch:{ IOException -> 0x002f }
        L_0x002f:
            throw r6
        L_0x0030:
            if (r3 == 0) goto L_0x0033
            goto L_0x0025
        L_0x0033:
            byte[] r6 = r0.toByteArray()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.security.wireless.adapter.AuthInterceptor.m31009b(com.didichuxing.foundation.net.rpc.http.HttpRpcRequest):byte[]");
    }
}
