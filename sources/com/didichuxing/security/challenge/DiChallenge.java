package com.didichuxing.security.challenge;

import android.content.Context;
import android.text.TextUtils;
import com.didichuxing.security.challenge.bean.ClgResponse;
import com.didichuxing.security.challenge.cookie.ClgCookie;
import com.didichuxing.security.challenge.cookie.ClgCookieStore;
import com.didichuxing.security.challenge.p198js.ClgJsExecutor;
import com.didichuxing.security.challenge.track.ClgTracker;
import com.didichuxing.security.safecollector.WsgSecInfo;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import com.google.gson.Gson;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class DiChallenge<T> {

    /* renamed from: a */
    static Context f51516a;

    /* renamed from: b */
    private static volatile Boolean f51517b;

    /* renamed from: f */
    private static Gson f51518f = new Gson();

    /* renamed from: g */
    private static final String[] f51519g = {"xmlhttprequest", "activexobject", "axios", RemoteConfigComponent.FETCH_FILE_NAME, "http", "ajax"};

    /* renamed from: c */
    private RequestBuilder<T> f51520c;

    /* renamed from: d */
    private ClgResponse f51521d = null;

    /* renamed from: e */
    private String f51522e = "";

    public interface RequestBuilder<T> {
        IHttpRequest<T> build() throws Exception;
    }

    /* renamed from: c */
    private String m38620c() {
        return "secdd-challenge";
    }

    /* renamed from: d */
    private String m38622d() {
        return "hbGxlbmdlZGVtbyIsInZj";
    }

    public static void init(Context context) {
        if (f51516a == null && context != null) {
            f51516a = context.getApplicationContext();
        }
    }

    public static <T> T execute(RequestBuilder<T> requestBuilder) throws Exception {
        if (f51516a == null) {
            return requestBuilder.build().execute().getResponse();
        }
        return new DiChallenge(requestBuilder).m38607a();
    }

    private DiChallenge(RequestBuilder<T> requestBuilder) {
        this.f51520c = requestBuilder;
    }

    /* renamed from: a */
    private T m38607a() throws Exception {
        return m38618b();
    }

    /* renamed from: b */
    private T m38618b() throws Exception {
        IHttpRequest<T> build = this.f51520c.build();
        if (!m38615a(build)) {
            return build.execute().getResponse();
        }
        if (build.getHeader(m38622d()) != null) {
            build.removeHeader(m38622d());
            return build.execute().getResponse();
        }
        boolean z = build.getHeader(m38620c()) != null;
        if (!z) {
            build = m38616b(build);
        }
        return m38608a(build, build.execute(), z);
    }

    /* renamed from: a */
    private boolean m38615a(IHttpRequest<T> iHttpRequest) throws Exception {
        return iHttpRequest.getUrl().toLowerCase().startsWith("https");
    }

    /* renamed from: a */
    private T m38608a(IHttpRequest<T> iHttpRequest, IHttpResponse<T> iHttpResponse, boolean z) throws Exception {
        ClgCookie b = m38617b(iHttpResponse);
        if (b != null) {
            try {
                ClgCookieStore.getInstance().save(b);
            } catch (Throwable unused) {
            }
        }
        if (z) {
            return iHttpResponse.getResponse();
        }
        if (!m38625e(iHttpResponse)) {
            return iHttpResponse.getResponse();
        }
        ClgResponse a = m38606a(iHttpRequest.getUrl(), iHttpResponse);
        this.f51521d = a;
        if (a == null || a.data == null) {
            return m38610a(false);
        }
        ClgTracker.trackReceived(f51516a, this.f51521d);
        String a2 = m38611a(this.f51521d);
        this.f51522e = a2;
        if (m38619b(a2)) {
            this.f51522e = "0";
        }
        return m38610a(true);
    }

    /* renamed from: a */
    private T m38610a(boolean z) throws Exception {
        IHttpRequest<T> build = this.f51520c.build();
        if (z) {
            build = m38616b(build);
        } else {
            build.setHeader(m38622d(), "challenge-response service went down");
        }
        return m38609a(build.execute());
    }

    /* renamed from: a */
    private T m38609a(IHttpResponse<T> iHttpResponse) throws Exception {
        ClgCookie b = m38617b(iHttpResponse);
        if (b != null) {
            try {
                ClgCookieStore.getInstance().save(b);
            } catch (Throwable unused) {
            }
        }
        return iHttpResponse.getResponse();
    }

    /* renamed from: b */
    private ClgCookie m38617b(IHttpResponse<T> iHttpResponse) throws Exception {
        String header = iHttpResponse.getHeader("set-secch-sessionid");
        if (header != null) {
            try {
                return ClgCookie.parse(header);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    /* renamed from: a */
    private ClgResponse m38606a(String str, IHttpResponse<T> iHttpResponse) throws Exception {
        byte[] bArr;
        ClgResponse clgResponse = null;
        try {
            bArr = m38621c(iHttpResponse);
        } catch (Throwable th) {
            Context context = f51516a;
            ClgTracker.trackWafError(context, str, "read waf response: " + th);
            bArr = null;
        }
        if (bArr == null || bArr.length <= 0) {
            ClgTracker.trackWafError(f51516a, str, "waf response no data");
            return null;
        }
        try {
            clgResponse = (ClgResponse) f51518f.fromJson(new String(bArr, StandardCharsets.UTF_8), ClgResponse.class);
        } catch (Throwable th2) {
            Context context2 = f51516a;
            ClgTracker.trackWafError(context2, str, "parse waf response: " + th2);
        }
        if (clgResponse != null) {
            clgResponse.url = str;
        }
        return clgResponse;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x002f A[SYNTHETIC, Splitter:B:20:0x002f] */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] m38621c(com.didichuxing.security.challenge.IHttpResponse<T> r7) throws java.lang.Exception {
        /*
            r6 = this;
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r1]
            java.io.InputStream r7 = r7.getRawBody()     // Catch:{ all -> 0x002b }
            if (r7 == 0) goto L_0x0021
        L_0x000f:
            r3 = 0
            int r4 = r7.read(r2, r3, r1)     // Catch:{ all -> 0x001f }
            r5 = -1
            if (r4 == r5) goto L_0x001b
            r0.write(r2, r3, r4)     // Catch:{ all -> 0x001f }
            goto L_0x000f
        L_0x001b:
            r0.flush()     // Catch:{ all -> 0x001f }
            goto L_0x0021
        L_0x001f:
            r0 = move-exception
            goto L_0x002d
        L_0x0021:
            if (r7 == 0) goto L_0x0026
            r7.close()     // Catch:{ all -> 0x0026 }
        L_0x0026:
            byte[] r7 = r0.toByteArray()
            return r7
        L_0x002b:
            r0 = move-exception
            r7 = 0
        L_0x002d:
            if (r7 == 0) goto L_0x0032
            r7.close()     // Catch:{ all -> 0x0032 }
        L_0x0032:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.security.challenge.DiChallenge.m38621c(com.didichuxing.security.challenge.IHttpResponse):byte[]");
    }

    /* renamed from: d */
    private boolean m38623d(IHttpResponse<T> iHttpResponse) throws Exception {
        return iHttpResponse != null && 522 == iHttpResponse.getResponseCode();
    }

    /* renamed from: a */
    private String m38611a(ClgResponse clgResponse) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (!TextUtils.isEmpty(clgResponse.data.funcDef)) {
                String lowerCase = clgResponse.data.funcDef.toLowerCase();
                for (String contains : f51519g) {
                    if (lowerCase.contains(contains)) {
                        ClgTracker.trackResult(f51516a, false, "js contains risky words", clgResponse, 0);
                        return null;
                    }
                }
            }
            String a = m38613a(clgResponse.data.funcDef, clgResponse.data.func, clgResponse.data.args, 5000);
            ClgTracker.trackResult(f51516a, true, a, clgResponse, System.currentTimeMillis() - currentTimeMillis);
            return a;
        } catch (Throwable th) {
            ClgTracker.trackResult(f51516a, false, String.valueOf(th), clgResponse, System.currentTimeMillis() - currentTimeMillis);
            return null;
        }
    }

    /* renamed from: a */
    private String m38613a(String str, String str2, String str3, long j) throws Exception {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final StringBuilder sb = new StringBuilder();
        final StringBuilder sb2 = new StringBuilder();
        ClgJsExecutor.getInstance(f51516a).execute(str, str2, str3, new ClgJsExecutor.Callback() {
            public void onMessage(String str) {
                sb2.append(str);
                sb2.append(", ");
            }

            public void onResult(String str) {
                sb.append(str);
                countDownLatch.countDown();
            }
        });
        if (j <= 0) {
            countDownLatch.await();
        } else if (!countDownLatch.await(j, TimeUnit.MILLISECONDS)) {
            sb2.append("js timeout:");
            sb2.append(str);
            throw new Exception(sb2.toString());
        }
        String sb3 = sb.toString();
        if (!m38619b(sb3)) {
            return sb3;
        }
        sb2.append("js return nothing");
        throw new Exception(sb2.toString());
    }

    /* renamed from: e */
    private boolean m38624e() {
        try {
            String a = m38613a("function test_challenge(a, b, c) {sum = a + b +c; return sum; }", "test_challenge", "1,2,3", 5000);
            boolean equals = "6".equals(m38612a(a));
            if (equals) {
                ClgTracker.trackTest(f51516a, true, (String) null);
            } else {
                ClgTracker.trackTest(f51516a, false, a);
            }
            return equals;
        } catch (Throwable th) {
            ClgTracker.trackTest(f51516a, false, String.valueOf(th));
            return false;
        }
    }

    /* renamed from: b */
    private IHttpRequest<T> m38616b(IHttpRequest<T> iHttpRequest) throws Exception {
        String c = m38620c();
        if (f51517b == null) {
            synchronized (DiChallenge.class) {
                if (f51517b == null) {
                    f51517b = Boolean.valueOf(m38624e());
                }
            }
        }
        iHttpRequest.setHeader(c, m38614a(iHttpRequest.getUrl(), f51517b.booleanValue()));
        return iHttpRequest;
    }

    /* renamed from: e */
    private boolean m38625e(IHttpResponse<T> iHttpResponse) throws Exception {
        return m38623d(iHttpResponse);
    }

    /* renamed from: a */
    private String m38614a(String str, boolean z) {
        ClgResponse clgResponse = this.f51521d;
        boolean z2 = (clgResponse == null || clgResponse.data == null) ? false : true;
        ClgCookie load = ClgCookieStore.getInstance().load(str);
        StringBuilder sb = new StringBuilder();
        sb.append("1,");
        sb.append(WsgSecInfo.packageName(f51516a));
        sb.append('|');
        sb.append(BuildConfig.VERSION_NAME);
        if (z) {
            String a = m38612a(this.f51522e);
            sb.append('|');
            String str2 = "";
            sb.append(z2 ? this.f51521d.data.func : str2);
            sb.append('|');
            sb.append(z2 ? this.f51521d.data.args : str2);
            sb.append('|');
            sb.append(z2 ? this.f51521d.data.f51525ts : str2);
            sb.append('|');
            if (a == null) {
                a = "0";
            }
            sb.append(a);
            sb.append('|');
            sb.append(z2 ? this.f51521d.data.chid : str2);
            sb.append('|');
            if (load != null) {
                str2 = load.getSecchSessionid();
            }
            sb.append(str2);
        }
        return sb.toString();
    }

    /* renamed from: a */
    private String m38612a(String str) {
        if (m38619b(str)) {
            return null;
        }
        try {
            return String.valueOf((long) Double.parseDouble(str));
        } catch (Throwable th) {
            ClgTracker.trackGetFixPartError(f51516a, String.valueOf(th), str);
            return null;
        }
    }

    /* renamed from: b */
    private boolean m38619b(String str) {
        return TextUtils.isEmpty(str) || "null".equalsIgnoreCase(str);
    }
}
