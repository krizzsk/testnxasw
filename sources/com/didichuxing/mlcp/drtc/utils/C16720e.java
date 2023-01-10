package com.didichuxing.mlcp.drtc.utils;

import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.mlcp.drtc.enums.MessengerType;
import com.didichuxing.mlcp.drtc.interfaces.C16686a;
import com.didichuxing.mlcp.drtc.interfaces.C16687b;
import com.koushikdutta.async.http.AsyncHttpClient;
import com.koushikdutta.async.http.AsyncHttpResponse;
import com.koushikdutta.async.http.callback.HttpConnectCallback;
import java.math.BigInteger;
import java.util.Date;
import org.json.JSONObject;

/* renamed from: com.didichuxing.mlcp.drtc.utils.e */
/* compiled from: HttpRestMessenger */
class C16720e extends HttpUtils implements C16687b, Runnable {

    /* renamed from: a */
    private final MessengerType f51022a = MessengerType.restful;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C16686a f51023b;

    /* renamed from: c */
    private final String f51024c;

    /* renamed from: d */
    private volatile boolean f51025d = false;

    /* renamed from: e */
    private BigInteger f51026e;

    /* renamed from: f */
    private String f51027f;

    /* renamed from: g */
    private Thread f51028g;

    /* renamed from: com.didichuxing.mlcp.drtc.utils.e$a */
    /* compiled from: HttpRestMessenger */
    class C16721a extends AsyncHttpClient.JSONObjectCallback {
        C16721a() {
        }

        /* renamed from: a */
        public void onCompleted(Exception exc, AsyncHttpResponse asyncHttpResponse, JSONObject jSONObject) {
            if (exc == null) {
                C16720e.this.mo125577b(jSONObject.toString());
            } else {
                C16720e.this.f51023b.mo125402b(new Exception("send message completed failed"));
            }
        }
    }

    /* renamed from: com.didichuxing.mlcp.drtc.utils.e$b */
    /* compiled from: HttpRestMessenger */
    class C16722b extends AsyncHttpClient.JSONObjectCallback {
        C16722b() {
        }

        /* renamed from: a */
        public void onCompleted(Exception exc, AsyncHttpResponse asyncHttpResponse, JSONObject jSONObject) {
            if (exc == null) {
                C16720e.this.mo125577b(jSONObject.toString());
            } else {
                C16720e.this.f51023b.mo125402b(new Exception("loop exception"));
            }
            C16720e.this.m38177d();
        }
    }

    C16720e(String str, C16686a aVar) {
        this.f51023b = aVar;
        this.f51024c = str;
        this.f51027f = "";
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m38177d() {
        if (this.f51025d) {
            HttpGet_Async(this.f51024c + "/" + this.f51026e.toString() + "?rid=" + new Date().getTime() + "&maxev=1", new C16722b());
        }
    }

    /* renamed from: c */
    public void mo125457c() {
        Connection_Async(this.f51024c, new HttpConnectCallback() {
            public final void onConnectCompleted(Exception exc, AsyncHttpResponse asyncHttpResponse) {
                C16720e.this.m38174a(exc, asyncHttpResponse);
            }
        });
        this.f51027f = "";
        Thread thread = this.f51028g;
        if (thread == null || !thread.isAlive()) {
            this.f51028g = new Thread(this, "rec");
        }
    }

    public void run() {
        if (Thread.currentThread() == this.f51028g) {
            if (this.f51027f.isEmpty()) {
                this.f51027f = this.f51024c;
            }
            m38177d();
        }
    }

    /* renamed from: a */
    public MessengerType mo125452a() {
        return this.f51022a;
    }

    /* renamed from: b */
    public void mo125456b() {
        try {
            this.f51025d = false;
            if (this.f51028g != null && this.f51028g.isAlive()) {
                this.f51028g.join();
            }
        } catch (InterruptedException unused) {
        } catch (Throwable th) {
            this.f51028g = null;
            throw th;
        }
        this.f51028g = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m38174a(Exception exc, AsyncHttpResponse asyncHttpResponse) {
        if (exc == null) {
            this.f51023b.mo125411e();
            this.f51025d = true;
            return;
        }
        this.f51023b.mo125402b(new Exception("Failed to connect"));
    }

    /* renamed from: a */
    public void mo125453a(String str) {
        SystemUtils.log(3, "message", "Sent ------>: \n\t" + str, (Throwable) null, "com.didichuxing.mlcp.drtc.utils.e", 7);
        if (this.f51027f.isEmpty()) {
            this.f51027f = this.f51024c;
        }
        HttpPost_Async(this.f51027f, str, new C16721a());
    }

    /* renamed from: b */
    public void mo125577b(String str) {
        try {
            SystemUtils.log(3, "message", "Rec<<<<<<<<<<<<<<<<<<<<<<<<< : \n\t" + str, (Throwable) null, "com.didichuxing.mlcp.drtc.utils.e", 11);
            this.f51023b.mo125412e(new JSONObject(str));
        } catch (Exception unused) {
            C16686a aVar = this.f51023b;
            aVar.mo125402b(new Exception("Rec Message failed ,rec message is not legal:" + str));
        }
    }

    /* renamed from: a */
    public void mo125454a(String str, BigInteger bigInteger) {
        m38175a(bigInteger);
        this.f51027f = "";
        this.f51027f = this.f51024c + "/" + bigInteger.toString();
        mo125453a(str);
    }

    /* renamed from: a */
    public void mo125455a(String str, BigInteger bigInteger, BigInteger bigInteger2) {
        m38175a(bigInteger);
        this.f51027f = "";
        this.f51027f = this.f51024c + "/" + bigInteger.toString() + "/" + bigInteger2.toString();
        mo125453a(str);
    }

    /* renamed from: a */
    private void m38175a(BigInteger bigInteger) {
        if (this.f51026e == null) {
            this.f51026e = bigInteger;
            Thread thread = this.f51028g;
            if (thread != null) {
                thread.start();
            }
        }
    }
}
