package p243import;

import android.content.Context;
import android.graphics.RectF;
import com.facebook.internal.NativeProtocol;
import com.iproov.sdk.IProov;
import com.iproov.sdk.bridge.OptionsBridge;
import com.iproov.sdk.cameray.C20752break;
import com.iproov.sdk.core.C20785case;
import com.iproov.sdk.core.C20871for;
import com.iproov.sdk.core.C20882import;
import com.iproov.sdk.core.C20887static;
import com.iproov.sdk.core.C20893while;
import com.iproov.sdk.core.exception.IProovException;
import com.iproov.sdk.core.exception.NetworkException;
import com.iproov.sdk.core.exception.ServerException;
import com.iproov.sdk.core.exception.UnexpectedErrorException;
import com.iproov.sdk.logging.IPLog;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;
import p055case.C1272else;
import p091public.C3561for;
import p091public.C3563new;
import p095switch.C3660catch;
import p095switch.C3667do;
import p095switch.C3676new;
import p095switch.C3680try;
import p218io.socket.client.Ack;
import p218io.socket.client.C19355IO;
import p218io.socket.client.Socket;
import p218io.socket.emitter.Emitter;
import p218io.socket.engineio.client.transports.WebSocket;
import p242if.C22005if;
import p243import.C22010if;

/* renamed from: import.if */
/* compiled from: Streamer */
public class C22010if {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f60049a = ("🔌 " + C22010if.class.getSimpleName());
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C22012if f60050b;

    /* renamed from: c */
    private final IProov.Options.Network f60051c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Context f60052d;

    /* renamed from: e */
    private String f60053e;

    /* renamed from: f */
    private Socket f60054f;

    /* renamed from: g */
    private Timer f60055g;

    /* renamed from: h */
    private final Object f60056h = new Object();

    /* renamed from: i */
    private int f60057i = 0;

    /* renamed from: j */
    private int f60058j = 0;

    /* renamed from: k */
    private int f60059k = 0;

    /* renamed from: l */
    private double f60060l;

    /* renamed from: m */
    private C20752break f60061m;

    /* renamed from: n */
    private int f60062n = 0;

    /* renamed from: o */
    private long f60063o = 0;

    /* renamed from: p */
    private final Set<Ack> f60064p = new HashSet();

    /* renamed from: q */
    private final List<byte[]> f60065q = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: r */
    public final ExecutorService f60066r = C3660catch.m7405do("TimeoutProcessor", C3660catch.C3662for.MEDIUM, C3660catch.C3664new.RUN_TASK_ONLY_IF_IDLE);

    /* renamed from: import.if$do */
    /* compiled from: Streamer */
    class C22011do extends TimerTask {
        C22011do() {
        }

        /* access modifiers changed from: private */
        /* renamed from: do */
        public /* synthetic */ void m45227do() {
            C22010if.this.m48279for();
            IPLog.m43490e(C22010if.f60049a, "Socket.IO timeout");
            C22010if.this.f60050b.onError(new NetworkException(C22010if.this.f60052d, "Socket.IO timeout"));
        }

        public void run() {
            C22010if.this.f60066r.execute(new Runnable() {
                public final void run() {
                    C22010if.C22011do.this.m45227do();
                }
            });
        }
    }

    /* renamed from: import.if$if */
    /* compiled from: Streamer */
    public interface C22012if {
        /* renamed from: do */
        void mo171505do();

        /* renamed from: do */
        void mo171506do(double d);

        /* renamed from: do */
        void mo171507do(C20871for forR);

        /* renamed from: do */
        void mo171508do(C22005if ifVar);

        /* renamed from: if */
        void mo171509if();

        void onConnected();

        void onConnecting();

        void onError(IProovException iProovException);
    }

    public C22010if(Context context, String str, String str2, IProov.Options.Network network, C22012if ifVar) throws IProovException {
        this.f60052d = context;
        this.f60051c = network;
        this.f60053e = str2;
        this.f60050b = ifVar;
        C19355IO.Options options = new C19355IO.Options();
        options.query = "token=" + str2;
        if (!network.certificates.isEmpty()) {
            C22008a.m45191a(context, network, options);
        }
        String str3 = str.replace("https://", "").split("/")[0];
        options.path = network.path;
        options.timeout = (long) (network.timeoutSecs * 1000);
        options.forceNew = true;
        options.reconnection = false;
        options.transports = new String[]{WebSocket.NAME};
        try {
            Socket socket = C19355IO.socket("https://" + str3 + "/" + str2, options);
            this.f60054f = socket;
            socket.mo148487on("connect", m45201b()).mo148487on("error", m45204c()).mo148487on("connect_error", m45204c()).mo148487on("connect_timeout", m45204c()).mo148487on(Socket.EVENT_DISCONNECT, m45206d()).mo148487on("edge_status", m45208e()).mo148487on("edge_result_callback", m45210f()).mo148487on("edge_result_ack", m45212g()).mo148487on("edge_abort", m45214h());
        } catch (URISyntaxException e) {
            throw new NetworkException(context, (Exception) e);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m45198a(Object[] objArr) {
    }

    /* renamed from: b */
    private Emitter.Listener m45201b() {
        return new Emitter.Listener() {
            public final void call(Object[] objArr) {
                C22010if.this.m45219j(objArr);
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m45202b(Object[] objArr) {
    }

    /* renamed from: c */
    private Emitter.Listener m45204c() {
        return new Emitter.Listener() {
            public final void call(Object[] objArr) {
                C22010if.this.m45217i(objArr);
            }
        };
    }

    /* renamed from: e */
    private Emitter.Listener m45208e() {
        return new Emitter.Listener() {
            public final void call(Object[] objArr) {
                C22010if.this.m45213g(objArr);
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void m45209e(Object[] objArr) {
        m48279for();
    }

    /* renamed from: f */
    private Emitter.Listener m45210f() {
        return new Emitter.Listener() {
            public final void call(Object[] objArr) {
                C22010if.this.m45211f(objArr);
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public /* synthetic */ void m45211f(Object[] objArr) {
        m45218j();
        JSONObject jSONObject = objArr[0];
        C20871for forR = new C20871for(jSONObject);
        JSONObject jSONObject2 = C3680try.m7469do(jSONObject);
        try {
            jSONObject2.put("received", Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTimeInMillis());
        } catch (JSONException unused) {
        }
        objArr[objArr.length - 1].call(jSONObject2);
        this.f60050b.mo171507do(forR);
    }

    /* renamed from: g */
    private Emitter.Listener m45212g() {
        return new Emitter.Listener() {
            public final void call(Object[] objArr) {
                C22010if.this.m45209e(objArr);
            }
        };
    }

    /* renamed from: h */
    private Emitter.Listener m45214h() {
        return new Emitter.Listener() {
            public final void call(Object[] objArr) {
                C22010if.this.m45207d(objArr);
            }
        };
    }

    /* renamed from: i */
    private void m45216i() {
        synchronized (this.f60056h) {
            m45218j();
            Timer timer = new Timer();
            this.f60055g = timer;
            timer.schedule(new C22011do(), (long) (this.f60051c.timeoutSecs * 1000));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public /* synthetic */ void m45217i(Object[] objArr) {
        String str;
        m45218j();
        if (objArr[0] instanceof Exception) {
            str = objArr[0].getLocalizedMessage();
        } else {
            str = "" + objArr[0];
        }
        IPLog.m43490e(f60049a, "Error: " + str);
        this.f60050b.onError(new NetworkException(this.f60052d, str));
    }

    /* renamed from: j */
    private void m45218j() {
        synchronized (this.f60056h) {
            Timer timer = this.f60055g;
            if (timer != null) {
                timer.cancel();
                this.f60055g = null;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m45205c(Object[] objArr) {
        if (objArr.length <= 0 || !(objArr[0] instanceof JSONObject)) {
            this.f60050b.onError(new NetworkException(this.f60052d, "No data/ack received"));
            return;
        }
        JSONObject jSONObject = objArr[0];
        if (jSONObject.optString("error").isEmpty()) {
            try {
                C22005if ifVar = new C22005if(this.f60052d, jSONObject);
                this.f60053e = ifVar.m48267break();
                this.f60050b.mo171508do(ifVar);
            } catch (JSONException e) {
                this.f60050b.onError(new UnexpectedErrorException(this.f60052d, (Exception) e));
            }
        } else {
            this.f60050b.onError(IProovException.getExceptionForACode(this.f60052d, jSONObject.optString("error", "no error given"), jSONObject.optString(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION, "no description given")));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void m45207d(Object[] objArr) {
        m45218j();
        this.f60050b.onError(new ServerException(this.f60052d, objArr[0].optString("reason")));
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ void m45213g(Object[] objArr) {
        m45216i();
        this.f60060l = objArr[0].optDouble("progress") / 100.0d;
        this.f60050b.mo171506do(m48280new());
    }

    /* renamed from: if */
    public synchronized void mo181331if() {
        this.f60054f.connect();
        this.f60050b.onConnecting();
    }

    /* renamed from: new  reason: not valid java name */
    public double m48280new() {
        double d = (((double) this.f60057i) / ((double) this.f60059k)) * 0.5d;
        return d + ((1.0d - d) * this.f60060l);
    }

    /* renamed from: a */
    private byte[] m45199a(byte[] bArr) throws C22009do {
        try {
            return C3676new.m7426do(bArr);
        } catch (Exception e) {
            throw new C22009do(e);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public /* synthetic */ void m45215h(Object[] objArr) {
        m45218j();
        this.f60050b.mo171505do();
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public /* synthetic */ void m45219j(Object[] objArr) {
        this.f60050b.onConnected();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:6|7|8|9|10|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0014 */
    /* renamed from: do */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo181328do(org.json.JSONObject r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.m48281try()     // Catch:{ all -> 0x0032 }
            if (r0 != 0) goto L_0x0009
            monitor-exit(r2)
            return
        L_0x0009:
            java.lang.String r0 = "id"
            io.socket.client.Socket r1 = r2.f60054f     // Catch:{ JSONException -> 0x0014 }
            java.lang.String r1 = r1.mo148472id()     // Catch:{ JSONException -> 0x0014 }
            r3.put(r0, r1)     // Catch:{ JSONException -> 0x0014 }
        L_0x0014:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0032 }
            r0.<init>()     // Catch:{ all -> 0x0032 }
            java.lang.String r1 = "Sending client_start: "
            r0.append(r1)     // Catch:{ all -> 0x0032 }
            r0.append(r3)     // Catch:{ all -> 0x0032 }
            com.iproov.sdk.core.import r0 = com.iproov.sdk.core.C20882import.AND7     // Catch:{ all -> 0x0032 }
            com.iproov.sdk.core.C20893while.m43453do(r0)     // Catch:{ all -> 0x0032 }
            import.-$$Lambda$if$rwrjT2hfnei2sNx4VNF_Wk0nQpg r0 = new import.-$$Lambda$if$rwrjT2hfnei2sNx4VNF_Wk0nQpg     // Catch:{ all -> 0x0032 }
            r0.<init>()     // Catch:{ all -> 0x0032 }
            java.lang.String r1 = "client_start"
            r2.m45196a(r1, r3, r0)     // Catch:{ all -> 0x0032 }
            monitor-exit(r2)
            return
        L_0x0032:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p243import.C22010if.mo181328do(org.json.JSONObject):void");
    }

    /* renamed from: for  reason: not valid java name */
    public synchronized void m48279for() {
        m45218j();
        if (this.f60054f != null) {
            this.f60050b.mo171509if();
            this.f60054f.disconnect();
            this.f60054f = null;
        }
    }

    /* renamed from: if */
    public synchronized void mo181332if(JSONObject jSONObject) {
        if (m48281try()) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("sendClientLuxData: ");
                sb.append(jSONObject.toString(2));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            m45196a("client_lux", jSONObject, $$Lambda$if$lvmRuMDl8OceQ0WhtLamni8mbWQ.INSTANCE);
        }
    }

    /* renamed from: d */
    private Emitter.Listener m45206d() {
        return new Emitter.Listener() {
            public final void call(Object[] objArr) {
                C22010if.this.m45215h(objArr);
            }
        };
    }

    /* renamed from: do */
    public synchronized void mo181329do(byte[] bArr, Long l, List<C3561for> list, RectF rectF, String str, C1272else elseR, C20785case caseR, boolean z) throws IProovException {
        byte[] bArr2 = bArr;
        Long l2 = l;
        String str2 = str;
        C20785case caseR2 = caseR;
        boolean z2 = z;
        synchronized (this) {
            try {
                this.f60065q.add(m45199a(bArr));
                byte[] bArr3 = z2 ? C20887static.m43449do(bArr2, m45199a(C3667do.m7414do(this.f60053e.getBytes(StandardCharsets.UTF_8), this.f60065q)), this.f60053e) : bArr2;
                if (m48281try()) {
                    JSONObject jSONObject = new JSONObject();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("token", this.f60053e);
                    jSONObject2.put("version", 5);
                    jSONObject2.put("camera", this.f60061m.mo171296do());
                    jSONObject2.put(OptionsBridge.ORIENTATION_KEY, String.format("%03d", new Object[]{Integer.valueOf(this.f60062n)}));
                    jSONObject2.put("type", "video/" + elseR.f466do);
                    jSONObject2.put("dataURL", bArr3);
                    jSONObject2.put("part", this.f60058j + 1);
                    jSONObject2.put("final", z2);
                    jSONObject2.put("loco", C3563new.m7214do(list));
                    jSONObject2.put("frt", caseR2.f56943do);
                    if (rectF != null) {
                        jSONObject2.put("cr", C22008a.m45190a(rectF));
                    }
                    if (l2 != null) {
                        jSONObject2.put("timestamp", l2);
                    }
                    if (str2 != null) {
                        jSONObject2.put("vsg", str2);
                    }
                    jSONObject.put("video", jSONObject2);
                    StringBuilder sb = new StringBuilder();
                    sb.append("Sending part 📡 ");
                    sb.append(this.f60058j + 1);
                    sb.append("...");
                    sb.append(caseR2);
                    sb.append(" size=");
                    sb.append(bArr2.length);
                    this.f60063o += (long) bArr2.length;
                    if (z2) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Stream size ");
                        sb2.append(this.f60063o / 1024);
                        sb2.append(" kB");
                    }
                    C20893while.m43453do(C20882import.AND6);
                    m45196a("client_video", jSONObject, new Ack(z2) {
                        public final /* synthetic */ boolean f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void call(Object[] objArr) {
                            C22010if.this.m45197a(this.f$1, objArr);
                        }
                    });
                    this.f60058j++;
                } else {
                    throw new NetworkException(this.f60052d, "Cannot send video (socket not connected)");
                }
            } catch (C22009do e) {
                e.printStackTrace();
                throw new UnexpectedErrorException(this.f60052d, (Exception) e);
            } catch (JSONException e2) {
                throw new UnexpectedErrorException(this.f60052d, (Exception) e2);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: try  reason: not valid java name */
    public synchronized boolean m48281try() {
        Socket socket;
        socket = this.f60054f;
        return socket != null && socket.connected();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m45197a(boolean z, Object[] objArr) {
        if (objArr.length > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Ack received: ");
            sb.append(objArr[0]);
        }
        this.f60057i++;
        this.f60050b.mo171506do(m48280new());
        if (z) {
            m45216i();
        }
    }

    /* renamed from: do */
    public synchronized void mo181327do(String str) {
        if (m48281try()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("reason", str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            m45196a("client_abort", jSONObject, $$Lambda$if$FCWuLGmlLaYMsefRpB8UEkBji6E.INSTANCE);
        }
    }

    /* renamed from: do */
    public void mo181325do(int i) {
        this.f60059k = i + 1;
    }

    /* renamed from: do */
    public void mo181326do(C20752break breakR, int i) {
        this.f60061m = breakR;
        this.f60062n = i;
    }

    /* renamed from: a */
    private void m45196a(String str, JSONObject jSONObject, Ack ack) {
        if (ack != null) {
            this.f60064p.add(ack);
            m45216i();
        }
        C20893while.m43453do(C20882import.AND8);
        this.f60054f.emit(str, jSONObject, new Ack(ack) {
            public final /* synthetic */ Ack f$1;

            {
                this.f$1 = r2;
            }

            public final void call(Object[] objArr) {
                C22010if.this.m45195a(this.f$1, objArr);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m45195a(Ack ack, Object[] objArr) {
        this.f60064p.remove(ack);
        if (this.f60064p.isEmpty()) {
            m45218j();
        } else {
            m45216i();
        }
        if (ack != null) {
            ack.call(objArr);
        }
    }
}
