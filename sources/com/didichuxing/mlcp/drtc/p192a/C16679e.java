package com.didichuxing.mlcp.drtc.p192a;

import android.content.Context;
import android.os.AsyncTask;
import com.didi.entrega.customer.app.constant.Const;
import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import com.didichuxing.mlcp.drtc.enums.DrtcMessageType;
import com.didichuxing.mlcp.drtc.enums.DrtcPluginRoleType;
import com.didichuxing.mlcp.drtc.enums.DrtcSupportedPlugins;
import com.didichuxing.mlcp.drtc.enums.DrtcTransactionType;
import com.didichuxing.mlcp.drtc.enums.MessengerType;
import com.didichuxing.mlcp.drtc.interfaces.C16686a;
import com.didichuxing.mlcp.drtc.interfaces.C16687b;
import com.didichuxing.mlcp.drtc.interfaces.p193f.C16691a;
import com.didichuxing.mlcp.drtc.interfaces.p193f.C16693c;
import com.didichuxing.mlcp.drtc.interfaces.p193f.C16694d;
import com.didichuxing.mlcp.drtc.interfaces.p193f.C16695e;
import com.didichuxing.mlcp.drtc.interfaces.p193f.C16696f;
import com.didichuxing.mlcp.drtc.interfaces.p193f.C16697g;
import com.didichuxing.mlcp.drtc.interfaces.p193f.C16699i;
import com.didichuxing.mlcp.drtc.sdk.DrtcPluginHandle;
import com.didichuxing.mlcp.drtc.utils.C16717c;
import com.didichuxing.mlcp.drtc.utils.C16723f;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
import org.webrtc.Loggable;
import org.webrtc.Logging;
import org.webrtc.PeerConnection;
import org.webrtc.PeerConnectionFactory;

/* renamed from: com.didichuxing.mlcp.drtc.a.e */
/* compiled from: DrtcSessionServer */
public class C16679e implements C16686a, C16691a, C16693c, C16695e, Runnable {

    /* renamed from: b */
    private static Boolean f50869b = false;

    /* renamed from: a */
    public final PeerConnection.IceTransportsType f50870a;

    /* renamed from: c */
    private final ConcurrentHashMap<BigInteger, DrtcPluginHandle> f50871c = new ConcurrentHashMap<>();

    /* renamed from: d */
    private final ConcurrentHashMap<String, C16699i> f50872d = new ConcurrentHashMap<>();

    /* renamed from: e */
    private final ConcurrentHashMap<BigInteger, C16694d> f50873e = new ConcurrentHashMap<>();

    /* renamed from: f */
    private final Object f50874f = new Object();

    /* renamed from: g */
    private final Object f50875g = new Object();

    /* renamed from: h */
    private final C16723f f50876h = new C16723f();
    /* access modifiers changed from: private */

    /* renamed from: i */
    public volatile C16687b f50877i;

    /* renamed from: j */
    private final C16696f f50878j;

    /* renamed from: k */
    private DrtcPluginHandle f50879k = null;

    /* renamed from: l */
    private Boolean f50880l;

    /* renamed from: m */
    private Context f50881m;

    /* renamed from: n */
    private volatile Thread f50882n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public BigInteger f50883o;

    /* renamed from: p */
    private final List<PeerConnection.IceServer> f50884p;

    /* renamed from: com.didichuxing.mlcp.drtc.a.e$a */
    /* compiled from: DrtcSessionServer */
    static /* synthetic */ class C16680a {

        /* renamed from: a */
        static final /* synthetic */ int[] f50885a;

        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|(3:19|20|22)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.didichuxing.mlcp.drtc.enums.DrtcMessageType[] r0 = com.didichuxing.mlcp.drtc.enums.DrtcMessageType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f50885a = r0
                com.didichuxing.mlcp.drtc.enums.DrtcMessageType r1 = com.didichuxing.mlcp.drtc.enums.DrtcMessageType.ack     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f50885a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didichuxing.mlcp.drtc.enums.DrtcMessageType r1 = com.didichuxing.mlcp.drtc.enums.DrtcMessageType.success     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f50885a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didichuxing.mlcp.drtc.enums.DrtcMessageType r1 = com.didichuxing.mlcp.drtc.enums.DrtcMessageType.error     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f50885a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didichuxing.mlcp.drtc.enums.DrtcMessageType r1 = com.didichuxing.mlcp.drtc.enums.DrtcMessageType.event     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f50885a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.didichuxing.mlcp.drtc.enums.DrtcMessageType r1 = com.didichuxing.mlcp.drtc.enums.DrtcMessageType.hangup     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f50885a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.didichuxing.mlcp.drtc.enums.DrtcMessageType r1 = com.didichuxing.mlcp.drtc.enums.DrtcMessageType.detached     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f50885a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.didichuxing.mlcp.drtc.enums.DrtcMessageType r1 = com.didichuxing.mlcp.drtc.enums.DrtcMessageType.slowlink     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f50885a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.didichuxing.mlcp.drtc.enums.DrtcMessageType r1 = com.didichuxing.mlcp.drtc.enums.DrtcMessageType.webrtcup     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f50885a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.didichuxing.mlcp.drtc.enums.DrtcMessageType r1 = com.didichuxing.mlcp.drtc.enums.DrtcMessageType.media     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f50885a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.didichuxing.mlcp.drtc.enums.DrtcMessageType r1 = com.didichuxing.mlcp.drtc.enums.DrtcMessageType.keepalive     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.mlcp.drtc.p192a.C16679e.C16680a.<clinit>():void");
        }
    }

    /* renamed from: com.didichuxing.mlcp.drtc.a.e$b */
    /* compiled from: DrtcSessionServer */
    private class C16681b extends AsyncTask<C16694d, Void, Void> {
        private C16681b() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(C16694d... dVarArr) {
            C16694d dVar = dVarArr[0];
            try {
                C16699i a = C16682f.m37911a(C16679e.this, DrtcTransactionType.attach, dVar.mo125475g(), dVar);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(SDKConsts.getSysConfig().f50902c, DrtcMessageType.attach);
                jSONObject.put(SDKConsts.MSG_TAG_PLUGIN, dVar.mo125475g());
                jSONObject.put(SDKConsts.MSG_TAG_TRAN, C16679e.this.m37881a(a));
                jSONObject.put(SDKConsts.MSG_TAG_OPAQUE, dVar.mo125477p());
                if (C16679e.this.f50877i.mo125452a() == MessengerType.websocket) {
                    jSONObject.put("session_id", C16679e.this.f50883o);
                }
                C16679e.this.f50877i.mo125454a(jSONObject.toString(), C16679e.this.f50883o);
                return null;
            } catch (JSONException e) {
                C16679e.this.mo125407c(e.getMessage());
                return null;
            }
        }

        /* synthetic */ C16681b(C16679e eVar, C16680a aVar) {
            this();
        }
    }

    public C16679e(C16696f fVar) {
        System.setProperty("java.net.preferIPv6Addresses", SDKConsts.BOOLEAN_FALSE);
        System.setProperty("java.net.preferIPv4Stack", "true");
        this.f50880l = false;
        this.f50878j = fVar;
        this.f50884p = fVar.mo125485q();
        this.f50870a = this.f50878j.mo125483i();
        this.f50883o = new BigInteger("-1");
        this.f50877i = C16717c.m38164a(this.f50878j.mo125484n(), this);
    }

    /* renamed from: a */
    private void m37882a() {
        try {
            C16699i a = C16682f.m37911a(this, DrtcTransactionType.create, (DrtcSupportedPlugins) null, (C16694d) null);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(SDKConsts.getSysConfig().f50902c, DrtcMessageType.create);
            jSONObject.put(SDKConsts.MSG_TAG_TRAN, m37881a(a));
            this.f50877i.mo125453a(jSONObject.toString());
        } catch (JSONException e) {
            mo125407c(e.getMessage());
        }
    }

    /* renamed from: b */
    private void m37885b() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(SDKConsts.getSysConfig().f50902c, DrtcMessageType.destroy);
            jSONObject.put(SDKConsts.MSG_TAG_TRAN, this.f50876h.mo125582a(12));
            this.f50877i.mo125453a(jSONObject.toString());
        } catch (JSONException e) {
            mo125407c(e.getMessage());
        }
    }

    /* renamed from: a */
    public void mo125401a(JSONObject jSONObject, DrtcSupportedPlugins drtcSupportedPlugins, C16694d dVar) {
    }

    /* renamed from: b */
    public void mo125406b(JSONObject jSONObject, DrtcSupportedPlugins drtcSupportedPlugins, C16694d dVar) {
    }

    /* renamed from: c */
    public void mo125408c(JSONObject jSONObject) {
        if (jSONObject.has("reason")) {
            try {
                this.f50878j.mo125481f(jSONObject.getString("reason"));
            } catch (JSONException unused) {
                this.f50878j.mo125481f("Json parse exception");
            }
        } else {
            this.f50878j.mo125481f("unknown");
        }
    }

    /* renamed from: d */
    public void mo125410d(JSONObject jSONObject, DrtcSupportedPlugins drtcSupportedPlugins, C16694d dVar) {
        try {
            BigInteger bigInteger = new BigInteger(jSONObject.getJSONObject("data").getString("id"));
            DrtcPluginHandle drtcPluginHandle = new DrtcPluginHandle(this, this.f50881m, drtcSupportedPlugins, bigInteger, dVar, dVar.mo125472c(), dVar.mo125471a());
            if (dVar.mo125472c() == DrtcPluginRoleType.PublisherRole) {
                this.f50879k = drtcPluginHandle;
            }
            synchronized (this.f50874f) {
                this.f50871c.put(bigInteger, drtcPluginHandle);
            }
            dVar.mo125466a(drtcPluginHandle);
        } catch (JSONException e) {
            mo125407c("[E] Janus handler create failed:" + e.getMessage());
        }
    }

    /* renamed from: e */
    public void mo125412e(JSONObject jSONObject) {
        DrtcPluginHandle drtcPluginHandle;
        JSONObject jSONObject2;
        try {
            DrtcMessageType fromString = DrtcMessageType.fromString(jSONObject.getString(SDKConsts.getSysConfig().f50902c));
            JSONObject jSONObject3 = null;
            String string = jSONObject.has(SDKConsts.MSG_TAG_TRAN) ? jSONObject.getString(SDKConsts.MSG_TAG_TRAN) : null;
            BigInteger bigInteger = jSONObject.has(Const.BillClickType.SENDER) ? new BigInteger(jSONObject.getString(Const.BillClickType.SENDER)) : null;
            if (bigInteger != null) {
                synchronized (this.f50874f) {
                    drtcPluginHandle = this.f50871c.get(bigInteger);
                }
            } else {
                drtcPluginHandle = null;
            }
            switch (C16680a.f50885a[fromString.ordinal()]) {
                case 1:
                case 2:
                case 3:
                    if (string != null) {
                        synchronized (this.f50875g) {
                            C16699i iVar = this.f50872d.get(string);
                            if (iVar != null) {
                                iVar.mo125394a(jSONObject);
                            }
                            this.f50872d.remove(string);
                        }
                        return;
                    }
                    return;
                case 4:
                    if (drtcPluginHandle != null && jSONObject.has(SDKConsts.MSG_TAG_PLUGIND) && (jSONObject2 = jSONObject.getJSONObject(SDKConsts.MSG_TAG_PLUGIND)) != null) {
                        JSONObject jSONObject4 = jSONObject2.has("data") ? jSONObject2.getJSONObject("data") : null;
                        if (jSONObject.has("jsep")) {
                            jSONObject3 = jSONObject.getJSONObject("jsep");
                        }
                        drtcPluginHandle.onMessage(jSONObject4, jSONObject3);
                        return;
                    }
                    return;
                case 5:
                    if (jSONObject.has("reason")) {
                        mo125407c("[W] Peer connection has been shutdown by janus-core,since:" + jSONObject.getString("reason"));
                    }
                    if (drtcPluginHandle != null) {
                        drtcPluginHandle.onDetached();
                        m37883a(bigInteger);
                        return;
                    }
                    return;
                case 6:
                    if (drtcPluginHandle != null) {
                        drtcPluginHandle.onDetached();
                        m37883a(bigInteger);
                        return;
                    }
                    return;
                case 7:
                    String string2 = jSONObject.getString("media");
                    boolean z = jSONObject.getBoolean("uplink");
                    int i = jSONObject.getInt("lost");
                    if (z) {
                        if (i > 30) {
                            this.f50879k.updateNtQua(1);
                        } else {
                            this.f50879k.updateNtQua(2);
                        }
                    }
                    mo125407c("[W] Slow link : type[" + string2 + "],lost[" + i + com.didichuxing.bigdata.p174dp.locsdk.Const.jaRight);
                    return;
                case 8:
                    mo125407c(String.format("[I] Webrtc is up, sender id : %s", new Object[]{bigInteger.toString()}));
                    return;
                case 9:
                    if (jSONObject.has("type") && jSONObject.has("receiving")) {
                        drtcPluginHandle.onMediaStreamArrived(jSONObject.getString("type"), jSONObject.getString("receiving"));
                        return;
                    }
                    return;
                default:
                    return;
            }
        } catch (JSONException e) {
            mo125407c(e.getMessage());
        }
        mo125407c(e.getMessage());
    }

    /* renamed from: f */
    public void mo125413f() {
        this.f50880l = false;
        mo125407c("[I] " + this.f50877i.mo125452a().toString() + " Connect to core server is closed");
    }

    public void run() {
        Thread currentThread = Thread.currentThread();
        while (this.f50882n == currentThread) {
            try {
                Thread.sleep(15000);
                if (this.f50880l.booleanValue() && this.f50877i.mo125452a() == MessengerType.websocket) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(SDKConsts.getSysConfig().f50902c, DrtcMessageType.keepalive.toString());
                        jSONObject.put(SDKConsts.MSG_TAG_TRAN, this.f50876h.mo125582a(12));
                        if (this.f50877i.mo125452a() == MessengerType.websocket) {
                            jSONObject.put("session_id", this.f50883o);
                        }
                        this.f50877i.mo125454a(jSONObject.toString(), this.f50883o);
                    } catch (JSONException e) {
                        C16696f fVar = this.f50878j;
                        fVar.mo125407c("Keep alive failed is sdk online?" + e.getMessage());
                        this.f50880l = false;
                        return;
                    }
                } else {
                    return;
                }
            } catch (InterruptedException unused) {
                return;
            }
        }
    }

    /* renamed from: t */
    public BigInteger mo125415t() {
        return this.f50883o;
    }

    /* renamed from: u */
    public List<PeerConnection.IceServer> mo125416u() {
        return this.f50884p;
    }

    /* renamed from: v */
    public void mo125417v() {
        f50869b = false;
        for (Map.Entry<BigInteger, C16694d> key : this.f50873e.entrySet()) {
            mo125403b((BigInteger) key.getKey());
        }
        DrtcPluginHandle drtcPluginHandle = this.f50879k;
        if (drtcPluginHandle != null) {
            drtcPluginHandle.hangUp();
        }
    }

    /* renamed from: w */
    public boolean mo125418w() {
        if (this.f50877i != null) {
            mo125407c("[I] Session server initializing...");
            this.f50877i.mo125457c();
            return true;
        }
        mo125407c("[E] Messenger is null,server initialization failed");
        return false;
    }

    /* renamed from: x */
    public void mo125419x() {
        f50869b = false;
        m37885b();
        synchronized (this.f50875g) {
            this.f50872d.clear();
        }
        if (this.f50877i != null) {
            this.f50877i.mo125456b();
        }
        this.f50882n = null;
        this.f50880l = false;
        this.f50878j.mo125482h();
    }

    /* renamed from: b */
    public void mo125402b(Exception exc) {
        mo125407c("[Ex]" + this.f50877i.mo125452a().toString() + " Connect to core server failed. Exception: " + exc.getMessage());
    }

    /* renamed from: a */
    public C16679e mo125395a(Context context, boolean z) {
        if (!f50869b.booleanValue()) {
            mo125407c("[I] Session server initializing peer connection factory");
            this.f50881m = context;
            PeerConnectionFactory.initialize(PeerConnectionFactory.InitializationOptions.builder(context).setInjectableLogger((Loggable) null, (Logging.Severity) null).setEnableInternalTracer(false).createInitializationOptions());
            Logging.enableLogToDebugOutput(Logging.Severity.LS_NONE);
            f50869b = true;
        } else {
            mo125407c("[W] Session server peer connection factory init twice");
        }
        return this;
    }

    /* renamed from: b */
    public void mo125405b(JSONObject jSONObject) {
        this.f50880l = true;
        try {
            this.f50883o = new BigInteger(jSONObject.getJSONObject("data").getString("id"));
            this.f50882n = new Thread(this, "KeepAliveThread");
            this.f50882n.start();
            this.f50878j.mo125478a(this.f50883o);
        } catch (JSONException e) {
            mo125407c("[E] Core session create failed:" + e.getMessage());
        }
    }

    /* renamed from: c */
    public void mo125409c(JSONObject jSONObject, DrtcSupportedPlugins drtcSupportedPlugins, C16694d dVar) {
        try {
            dVar.mo125467a(jSONObject.getJSONObject("error").getString("reason"));
        } catch (JSONException unused) {
            dVar.mo125467a("unknown");
        }
    }

    /* renamed from: c */
    public void mo125407c(String str) {
        C16696f fVar = this.f50878j;
        if (fVar != null) {
            fVar.mo125407c(str);
        }
    }

    /* renamed from: a */
    private void m37883a(BigInteger bigInteger) {
        synchronized (this.f50874f) {
            this.f50871c.remove(bigInteger);
        }
    }

    /* renamed from: b */
    public void mo125403b(BigInteger bigInteger) {
        C16694d dVar = this.f50873e.get(bigInteger);
        if (dVar != null) {
            dVar.mo125476o();
        }
    }

    /* renamed from: b */
    public void mo125404b(BigInteger bigInteger, C16694d dVar) {
        this.f50873e.remove(bigInteger, dVar);
    }

    /* renamed from: a */
    public void mo125397a(C16694d dVar) {
        if (!f50869b.booleanValue()) {
            dVar.mo125407c("[E] Peer connection factory hasn't been initialized, please initialize via initializeMediaContext");
            return;
        }
        new C16681b(this, (C16680a) null).execute(new C16694d[]{dVar});
    }

    /* renamed from: a */
    public void mo125400a(JSONObject jSONObject, DrtcMessageType drtcMessageType, BigInteger bigInteger) {
        try {
            jSONObject.put(SDKConsts.getSysConfig().f50902c, drtcMessageType.toString());
            jSONObject.put(SDKConsts.MSG_TAG_TRAN, this.f50876h.mo125582a(12));
            if (this.f50877i.mo125452a() == MessengerType.websocket) {
                jSONObject.put("session_id", this.f50883o);
                jSONObject.put(SDKConsts.MSG_TAG_HANDLE_ID, bigInteger);
            }
            if (this.f50880l.booleanValue()) {
                this.f50877i.mo125455a(jSONObject.toString(), this.f50883o, bigInteger);
            }
        } catch (JSONException e) {
            mo125407c(e.getMessage());
        }
    }

    /* renamed from: a */
    public void mo125396a(DrtcTransactionType drtcTransactionType, BigInteger bigInteger, C16697g gVar, DrtcSupportedPlugins drtcSupportedPlugins) {
        JSONObject k = gVar.mo125423k();
        if (k != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(SDKConsts.getSysConfig().f50902c, DrtcMessageType.message.toString());
                if (this.f50877i.mo125452a() == MessengerType.websocket) {
                    jSONObject.put("session_id", this.f50883o);
                    jSONObject.put(SDKConsts.MSG_TAG_HANDLE_ID, bigInteger);
                }
                jSONObject.put(SDKConsts.MSG_TAG_TRAN, m37881a(C16682f.m37912a(gVar)));
                if (k.has("message")) {
                    jSONObject.put("body", k.getJSONObject("message"));
                }
                if (k.has("jsep")) {
                    jSONObject.put("jsep", k.getJSONObject("jsep"));
                }
                this.f50877i.mo125455a(jSONObject.toString(), this.f50883o, bigInteger);
                gVar.mo125422d((JSONObject) null);
            } catch (JSONException e) {
                gVar.mo125407c(e.getMessage());
            }
        }
    }

    /* renamed from: a */
    public void mo125398a(Exception exc) {
        this.f50878j.mo125479b(exc.getMessage());
    }

    /* renamed from: a */
    public void mo125399a(BigInteger bigInteger, C16694d dVar) {
        this.f50873e.put(bigInteger, dVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m37881a(C16699i iVar) {
        String a = this.f50876h.mo125582a(12);
        synchronized (this.f50875g) {
            while (this.f50872d.containsKey(a)) {
                a = this.f50876h.mo125582a(12);
            }
            this.f50872d.put(a, iVar);
        }
        return a;
    }

    /* renamed from: e */
    public void mo125411e() {
        m37882a();
        C16696f fVar = this.f50878j;
        fVar.mo125480e("[I] " + this.f50877i.mo125452a().toString() + " Connection is already");
    }
}
