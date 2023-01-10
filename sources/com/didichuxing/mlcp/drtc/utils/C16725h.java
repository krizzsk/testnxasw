package com.didichuxing.mlcp.drtc.utils;

import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import com.didichuxing.mlcp.drtc.enums.MessengerType;
import com.didichuxing.mlcp.drtc.interfaces.C16686a;
import com.didichuxing.mlcp.drtc.interfaces.C16687b;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.http.AsyncHttpClient;
import com.koushikdutta.async.http.WebSocket;
import java.lang.ref.WeakReference;
import java.math.BigInteger;
import java.util.concurrent.ConcurrentLinkedDeque;
import org.json.JSONObject;

/* renamed from: com.didichuxing.mlcp.drtc.utils.h */
/* compiled from: WebsocketMessenger */
class C16725h implements C16687b {

    /* renamed from: a */
    private static final String f51032a = "com.didichuxing.mlcp.drtc.utils.h";

    /* renamed from: b */
    private final String f51033b;

    /* renamed from: c */
    private final C16686a f51034c;

    /* renamed from: d */
    private final MessengerType f51035d = MessengerType.websocket;

    /* renamed from: e */
    private WebSocket f51036e = null;

    /* renamed from: f */
    private boolean f51037f;

    /* renamed from: g */
    private int f51038g = 3;

    /* renamed from: h */
    private final ConcurrentLinkedDeque<String> f51039h = new ConcurrentLinkedDeque<>();

    public C16725h(String str, C16686a aVar) {
        this.f51033b = str;
        this.f51034c = aVar;
    }

    /* renamed from: a */
    public MessengerType mo125452a() {
        return this.f51035d;
    }

    /* renamed from: b */
    public void mo125456b() {
        if (this.f51036e.isOpen()) {
            this.f51036e.close();
        }
        ConcurrentLinkedDeque<String> concurrentLinkedDeque = this.f51039h;
        if (concurrentLinkedDeque != null && concurrentLinkedDeque.size() > 0) {
            this.f51039h.clear();
        }
    }

    /* renamed from: c */
    public void mo125457c() {
        AsyncHttpClient.getDefaultInstance().websocket(this.f51033b, SDKConsts.getSysConfig().f50903d, (AsyncHttpClient.WebSocketConnectCallback) new AsyncHttpClient.WebSocketConnectCallback(new WeakReference(this)) {
            public final /* synthetic */ WeakReference f$1;

            {
                this.f$1 = r2;
            }

            public final void onCompleted(Exception exc, WebSocket webSocket) {
                C16725h.this.m38193a(this.f$1, exc, webSocket);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m38193a(WeakReference weakReference, Exception exc, WebSocket webSocket) {
        C16725h hVar = (C16725h) weakReference.get();
        if (exc != null) {
            hVar.f51034c.mo125398a(exc);
            return;
        }
        this.f51036e = webSocket;
        webSocket.setWriteableCallback($$Lambda$h$wZkYw3YonWm5_rKBMZvtklOWKMc.INSTANCE);
        this.f51036e.setPongCallback($$Lambda$h$zPRH6DimiAN8M2eOm7gC61BCU7o.INSTANCE);
        this.f51036e.setDataCallback($$Lambda$h$JPmhxHPsn8_1kJdD4BZYmZEIQy8.INSTANCE);
        this.f51036e.setEndCallback($$Lambda$h$5BtXBilVvSTOFQyzSXmQevtCExo.INSTANCE);
        WebSocket webSocket2 = this.f51036e;
        hVar.getClass();
        webSocket2.setStringCallback(new WebSocket.StringCallback() {
            public final void onStringAvailable(String str) {
                C16725h.this.mo125583b(str);
            }
        });
        this.f51036e.setClosedCallback(new CompletedCallback() {
            public final void onCompleted(Exception exc) {
                C16725h.m38190a(C16725h.this, exc);
            }
        });
        hVar.f51037f = true;
        if (hVar.f51038g == 3) {
            hVar.f51034c.mo125411e();
        }
    }

    /* renamed from: b */
    public void mo125583b(String str) {
        String str2 = f51032a;
        SystemUtils.log(3, str2, "Rec: \n\t" + str, (Throwable) null, f51032a, 5);
        try {
            this.f51034c.mo125412e(new JSONObject(str));
        } catch (Exception e) {
            this.f51034c.mo125402b(e);
        }
    }

    /* renamed from: a */
    private void m38192a(Exception exc) {
        this.f51034c.mo125402b(exc);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m38190a(C16725h hVar, Exception exc) {
        SystemUtils.log(3, f51032a, "Socket closed for some reason", (Throwable) null, f51032a, 46);
        hVar.f51037f = false;
        if (exc != null) {
            String str = f51032a;
            SystemUtils.log(3, str, "SOCKET EX " + exc.getMessage(), (Throwable) null, f51032a, 50);
            hVar.m38192a(exc);
            return;
        }
        hVar.f51034c.mo125413f();
    }

    /* renamed from: a */
    public void mo125453a(String str) {
        String str2 = f51032a;
        SystemUtils.log(3, str2, "Sent: \n\t" + str, (Throwable) null, f51032a, 54);
        WebSocket webSocket = this.f51036e;
        if (webSocket != null) {
            webSocket.send(str);
        } else {
            this.f51039h.addLast(str);
        }
    }

    /* renamed from: a */
    public void mo125454a(String str, BigInteger bigInteger) {
        mo125453a(str);
    }

    /* renamed from: a */
    public void mo125455a(String str, BigInteger bigInteger, BigInteger bigInteger2) {
        mo125453a(str);
    }
}
