package com.didichuxing.request;

import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo148868d2 = {"com/didichuxing/request/UploadGAccountRequester$request$1", "Ljava/lang/Thread;", "run", "", "upgrade_release"}, mo148869k = 1, mo148870mv = {1, 1, 15})
/* compiled from: UploadGAccountRequester.kt */
public final class UploadGAccountRequester$request$1 extends Thread {
    final /* synthetic */ UploadGAccountRequester this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UploadGAccountRequester$request$1(UploadGAccountRequester uploadGAccountRequester, String str) {
        super(str);
        this.this$0 = uploadGAccountRequester;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r7 = this;
            r0 = 0
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d6, all -> 0x00d1 }
            r1.<init>()     // Catch:{ Exception -> 0x00d6, all -> 0x00d1 }
            java.lang.String r2 = com.didichuxing.request.UpgradeBaseRequest.getHost()     // Catch:{ Exception -> 0x00d6, all -> 0x00d1 }
            r1.append(r2)     // Catch:{ Exception -> 0x00d6, all -> 0x00d1 }
            java.lang.String r2 = "/muse-center/muse/user"
            r1.append(r2)     // Catch:{ Exception -> 0x00d6, all -> 0x00d1 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x00d6, all -> 0x00d1 }
            com.didichuxing.request.UploadGAccountRequester r2 = r7.this$0     // Catch:{ Exception -> 0x00d6, all -> 0x00d1 }
            java.lang.String r2 = r2.m38234a()     // Catch:{ Exception -> 0x00d6, all -> 0x00d1 }
            com.didichuxing.request.UploadGAccountRequester r3 = r7.this$0     // Catch:{ Exception -> 0x00d6, all -> 0x00d1 }
            java.lang.String r3 = r3.f51070a     // Catch:{ Exception -> 0x00d6, all -> 0x00d1 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d6, all -> 0x00d1 }
            r4.<init>()     // Catch:{ Exception -> 0x00d6, all -> 0x00d1 }
            java.lang.String r5 = "request url = "
            r4.append(r5)     // Catch:{ Exception -> 0x00d6, all -> 0x00d1 }
            r4.append(r1)     // Catch:{ Exception -> 0x00d6, all -> 0x00d1 }
            r4.append(r2)     // Catch:{ Exception -> 0x00d6, all -> 0x00d1 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00d6, all -> 0x00d1 }
            com.didichuxing.util.UpLogger.m38965d(r3, r4)     // Catch:{ Exception -> 0x00d6, all -> 0x00d1 }
            java.net.URL r3 = new java.net.URL     // Catch:{ Exception -> 0x00d6, all -> 0x00d1 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x00d6, all -> 0x00d1 }
            java.net.URLConnection r1 = r3.openConnection()     // Catch:{ Exception -> 0x00d6, all -> 0x00d1 }
            if (r1 == 0) goto L_0x00c9
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ Exception -> 0x00d6, all -> 0x00d1 }
            java.lang.String r0 = "POST"
            r1.setRequestMethod(r0)     // Catch:{ Exception -> 0x00c7 }
            r0 = 15000(0x3a98, float:2.102E-41)
            r1.setConnectTimeout(r0)     // Catch:{ Exception -> 0x00c7 }
            r0 = 1
            r1.setDoOutput(r0)     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r0 = "Content-Type"
            java.lang.String r3 = "application/json"
            r1.setRequestProperty(r0, r3)     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r0 = "Charset"
            java.lang.String r3 = "UTF-8"
            r1.setRequestProperty(r0, r3)     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r0 = "token"
            java.lang.String r3 = "cd5fb4d42ec6b7897e18e6eb489cacb4"
            r1.setRequestProperty(r0, r3)     // Catch:{ Exception -> 0x00c7 }
            r1.connect()     // Catch:{ Exception -> 0x00c7 }
            java.io.OutputStream r0 = r1.getOutputStream()     // Catch:{ Exception -> 0x00c7 }
            java.nio.charset.Charset r3 = kotlin.text.Charsets.UTF_8     // Catch:{ Exception -> 0x00c7 }
            if (r2 == 0) goto L_0x00bf
            byte[] r2 = r2.getBytes(r3)     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r3 = "(this as java.lang.String).getBytes(charset)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r3)     // Catch:{ Exception -> 0x00c7 }
            r0.write(r2)     // Catch:{ Exception -> 0x00c7 }
            r0.flush()     // Catch:{ Exception -> 0x00c7 }
            r0.close()     // Catch:{ Exception -> 0x00c7 }
            int r0 = r1.getResponseCode()     // Catch:{ Exception -> 0x00c7 }
            r2 = 200(0xc8, float:2.8E-43)
            if (r0 != r2) goto L_0x00b9
            java.io.InputStream r0 = r1.getInputStream()     // Catch:{ Exception -> 0x00c7 }
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r2]     // Catch:{ Exception -> 0x00c7 }
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x00c7 }
            r3.<init>()     // Catch:{ Exception -> 0x00c7 }
            int r4 = r0.read(r2)     // Catch:{ Exception -> 0x00c7 }
        L_0x00a1:
            r5 = -1
            if (r4 == r5) goto L_0x00ad
            r5 = 0
            r3.write(r2, r5, r4)     // Catch:{ Exception -> 0x00c7 }
            int r4 = r0.read(r2)     // Catch:{ Exception -> 0x00c7 }
            goto L_0x00a1
        L_0x00ad:
            java.lang.String r2 = "utf-8"
            r3.toString(r2)     // Catch:{ Exception -> 0x00c7 }
            r3.close()     // Catch:{ Exception -> 0x00c7 }
            r0.close()     // Catch:{ Exception -> 0x00c7 }
        L_0x00b9:
            if (r1 == 0) goto L_0x00fe
        L_0x00bb:
            r1.disconnect()
            goto L_0x00fe
        L_0x00bf:
            kotlin.TypeCastException r0 = new kotlin.TypeCastException     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r2 = "null cannot be cast to non-null type java.lang.String"
            r0.<init>(r2)     // Catch:{ Exception -> 0x00c7 }
            throw r0     // Catch:{ Exception -> 0x00c7 }
        L_0x00c7:
            r0 = move-exception
            goto L_0x00da
        L_0x00c9:
            kotlin.TypeCastException r1 = new kotlin.TypeCastException     // Catch:{ Exception -> 0x00d6, all -> 0x00d1 }
            java.lang.String r2 = "null cannot be cast to non-null type java.net.HttpURLConnection"
            r1.<init>(r2)     // Catch:{ Exception -> 0x00d6, all -> 0x00d1 }
            throw r1     // Catch:{ Exception -> 0x00d6, all -> 0x00d1 }
        L_0x00d1:
            r1 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
            goto L_0x0100
        L_0x00d6:
            r1 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
        L_0x00da:
            r0.printStackTrace()     // Catch:{ all -> 0x00ff }
            com.didichuxing.request.UploadGAccountRequester r2 = r7.this$0     // Catch:{ all -> 0x00ff }
            java.lang.String r2 = r2.f51070a     // Catch:{ all -> 0x00ff }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ff }
            r3.<init>()     // Catch:{ all -> 0x00ff }
            java.lang.String r4 = "request  exception = "
            r3.append(r4)     // Catch:{ all -> 0x00ff }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x00ff }
            r3.append(r0)     // Catch:{ all -> 0x00ff }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x00ff }
            com.didichuxing.util.UpLogger.m38966e(r2, r0)     // Catch:{ all -> 0x00ff }
            if (r1 == 0) goto L_0x00fe
            goto L_0x00bb
        L_0x00fe:
            return
        L_0x00ff:
            r0 = move-exception
        L_0x0100:
            if (r1 == 0) goto L_0x0105
            r1.disconnect()
        L_0x0105:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.request.UploadGAccountRequester$request$1.run():void");
    }
}
