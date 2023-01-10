package com.didichuxing.mlcp.drtc.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.didi.sdk.apm.SystemUtils;
import com.didi.trackupload.sdk.Constants;
import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import com.didichuxing.mlcp.drtc.enums.DrtcCameraType;
import com.didichuxing.mlcp.drtc.enums.DrtcCaptureFrameType;
import com.didichuxing.mlcp.drtc.enums.DrtcMode;
import com.didichuxing.mlcp.drtc.enums.DrtcPluginRoleType;
import com.didichuxing.mlcp.drtc.enums.DrtcSupportedPlugins;
import com.didichuxing.mlcp.drtc.enums.DrtcSvcStatus;
import com.didichuxing.mlcp.drtc.interfaces.C16688c;
import com.didichuxing.mlcp.drtc.interfaces.C16689d;
import com.didichuxing.mlcp.drtc.interfaces.C16690e;
import com.didichuxing.mlcp.drtc.interfaces.CallingService;
import com.didichuxing.mlcp.drtc.interfaces.CallingServiceListener;
import com.didichuxing.mlcp.drtc.interfaces.FrameReceiver;
import com.didichuxing.mlcp.drtc.interfaces.p193f.C16694d;
import com.didichuxing.mlcp.drtc.interfaces.p193f.C16696f;
import com.didichuxing.mlcp.drtc.interfaces.p193f.C16697g;
import com.didichuxing.mlcp.drtc.interfaces.p193f.C16698h;
import com.didichuxing.mlcp.drtc.models.C16700a;
import com.didichuxing.mlcp.drtc.models.C16702c;
import com.didichuxing.mlcp.drtc.p192a.C16679e;
import com.didichuxing.mlcp.drtc.p192a.C16684g;
import com.didichuxing.mlcp.drtc.p192a.C16685h;
import com.didichuxing.mlcp.drtc.utils.C16715a;
import com.didichuxing.mlcp.drtc.utils.C16723f;
import com.didichuxing.mlcp.drtc.utils.DrtcAudioManager;
import com.didichuxing.mlcp.drtc.utils.MetricReporter;
import java.lang.ref.WeakReference;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.webrtc.EglBase;
import org.webrtc.MediaStream;
import org.webrtc.PeerConnection;
import org.webrtc.RendererCommon;
import org.webrtc.SurfaceViewRenderer;
import org.webrtc.VideoFrame;
import org.webrtc.VideoSink;

/* renamed from: com.didichuxing.mlcp.drtc.sdk.a */
/* compiled from: DrtcCallingServiceImpl */
class C16709a implements CallingService, C16689d, C16696f {

    /* renamed from: a */
    private static DrtcSvcStatus f50967a = DrtcSvcStatus.idle;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final String f50968b = C16709a.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final DrtcSDK f50969c;

    /* renamed from: d */
    private final C16690e f50970d;

    /* renamed from: e */
    private final List<PeerConnection.IceServer> f50971e = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final Deque<VideoSink> f50972f = new ArrayDeque();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final HashMap<BigInteger, VideoSink> f50973g = new HashMap<>();

    /* renamed from: h */
    private final DrtcAudioManager f50974h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final C16700a f50975i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final HashMap<BigInteger, String> f50976j = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: k */
    public EglBase f50977k;

    /* renamed from: l */
    private SurfaceViewRenderer f50978l;

    /* renamed from: m */
    private ProxyVideoSink f50979m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public C16679e f50980n;

    /* renamed from: o */
    private FrameReceiver f50981o;

    /* renamed from: p */
    private boolean f50982p = false;

    /* renamed from: q */
    private volatile boolean f50983q = false;

    /* renamed from: r */
    private boolean f50984r = true;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public boolean f50985s = true;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public int f50986t = -1;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public String f50987u = "DroidSDK";
    /* access modifiers changed from: private */

    /* renamed from: v */
    public String f50988v = null;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public String f50989w = "";

    /* renamed from: com.didichuxing.mlcp.drtc.sdk.a$a */
    /* compiled from: DrtcCallingServiceImpl */
    class C16710a implements C16694d {

        /* renamed from: a */
        private final VideoSink f50990a;

        /* renamed from: b */
        private final BigInteger f50991b;

        /* renamed from: c */
        private final BigInteger f50992c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public DrtcPluginHandle f50993d = null;

        /* renamed from: com.didichuxing.mlcp.drtc.sdk.a$a$a */
        /* compiled from: DrtcCallingServiceImpl */
        class C16711a implements C16698h {

            /* renamed from: a */
            final C16710a f50995a = ((C16710a) this.f50996b.get());

            /* renamed from: b */
            final /* synthetic */ WeakReference f50996b;

            /* renamed from: c */
            final /* synthetic */ JSONObject f50997c;

            C16711a(WeakReference weakReference, JSONObject jSONObject) {
                this.f50996b = weakReference;
                this.f50997c = jSONObject;
            }

            /* renamed from: a */
            public void mo125425a(JSONObject jSONObject) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("jsep", jSONObject);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("request", "start");
                    jSONObject3.put(SDKConsts.TAG_KEY_ROOM, C16709a.this.f50986t);
                    jSONObject2.put("message", jSONObject3);
                    this.f50995a.f50993d.mo125517a((C16697g) new C16684g(jSONObject2));
                } catch (JSONException e) {
                    String b = C16709a.f50968b;
                    SystemUtils.log(6, b, "listener start and config message ex:" + e.getMessage(), (Throwable) null, "com.didichuxing.mlcp.drtc.sdk.a$a$a", 11);
                }
            }

            /* renamed from: b */
            public Context mo125426b() {
                return C16709a.this.f50969c.mo125540a();
            }

            /* renamed from: c */
            public void mo125407c(String str) {
            }

            /* renamed from: j */
            public JSONObject mo125427j() {
                return this.f50997c;
            }

            /* renamed from: m */
            public EglBase.Context mo125428m() {
                return C16709a.this.f50977k.getEglBaseContext();
            }

            /* renamed from: r */
            public C16700a mo125429r() {
                C16700a i = C16700a.m37988i();
                i.mo125496a((C16702c) null);
                i.mo125501d(false);
                i.mo125498b(C16709a.this.f50975i.mo125502d());
                i.mo125499c(C16709a.this.f50975i.mo125503e());
                return C16709a.this.f50975i;
            }

            /* renamed from: s */
            public Boolean mo125430s() {
                return true;
            }
        }

        C16710a(BigInteger bigInteger, VideoSink videoSink, BigInteger bigInteger2) {
            this.f50990a = videoSink;
            this.f50991b = bigInteger;
            this.f50992c = bigInteger2;
        }

        /* renamed from: a */
        public void mo125464a(int i) {
        }

        /* renamed from: a */
        public void mo125465a(DrtcCameraType drtcCameraType) {
        }

        /* renamed from: a */
        public void mo125467a(String str) {
        }

        /* renamed from: a */
        public void mo125470a(PeerConnection.IceConnectionState iceConnectionState) {
        }

        /* renamed from: a */
        public boolean mo125471a() {
            return true;
        }

        /* renamed from: c */
        public DrtcPluginRoleType mo125472c() {
            return DrtcPluginRoleType.ListenerRole;
        }

        /* renamed from: c */
        public void mo125407c(String str) {
        }

        /* renamed from: d */
        public void mo125473d() {
            SystemUtils.log(6, C16709a.f50968b, "Remote Feed Detached.......", (Throwable) null, "com.didichuxing.mlcp.drtc.sdk.a$a", 1);
        }

        /* renamed from: d */
        public void mo125474d(String str) {
        }

        /* renamed from: g */
        public DrtcSupportedPlugins mo125475g() {
            if (C16709a.this.f50975i.mo125493a() != DrtcMode.OnlyAudio) {
                return DrtcSupportedPlugins.SATURN_VIDEO_ROOM;
            }
            return DrtcSupportedPlugins.SATURN_AUDIO_BRIDGE;
        }

        /* renamed from: o */
        public void mo125476o() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("request", "leave");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("message", jSONObject);
                this.f50993d.mo125517a((C16697g) new C16684g(jSONObject2));
            } catch (JSONException e) {
                String b = C16709a.f50968b;
                SystemUtils.log(6, b, "listener send leave message ex:" + e.getMessage(), (Throwable) null, "com.didichuxing.mlcp.drtc.sdk.a$a", 8);
            }
        }

        /* renamed from: p */
        public String mo125477p() {
            return "";
        }

        /* renamed from: a */
        public void mo125466a(DrtcPluginHandle drtcPluginHandle) {
            this.f50993d = drtcPluginHandle;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("request", SDKConsts.ACTION_VALUE_JOIN);
                jSONObject.put(SDKConsts.TAG_KEY_PTYPE, SDKConsts.TAG_VALUE_SUBSCRIBER);
                jSONObject.put(SDKConsts.TAG_KEY_ROOM, C16709a.this.f50986t);
                jSONObject.put(SDKConsts.TAG_KEY_PRIVID, this.f50992c);
                jSONObject.put(SDKConsts.TAG_KEY_FEED, this.f50991b);
                if (StringUtils.isNotEmpty(C16709a.this.f50988v)) {
                    jSONObject.put(SDKConsts.TAG_KEY_PIN, C16709a.this.f50988v);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("message", jSONObject);
                this.f50993d.mo125517a((C16697g) new C16684g(jSONObject2));
            } catch (JSONException e) {
                String b = C16709a.f50968b;
                SystemUtils.log(6, b, "listener start and config message ex:" + e.getMessage(), (Throwable) null, "com.didichuxing.mlcp.drtc.sdk.a$a", 18);
            }
        }

        /* renamed from: a */
        public void mo125468a(JSONObject jSONObject, JSONObject jSONObject2, DrtcPluginHandle drtcPluginHandle) {
            try {
                String string = jSONObject.getString("videoroom");
                if (string.equals("attached") && jSONObject2 != null) {
                    this.f50993d.mo125521b((C16698h) new C16711a(new WeakReference(this), jSONObject2));
                } else if (string.equals("event")) {
                    if (jSONObject.has("started")) {
                        if (jSONObject.getString("started") != null && jSONObject.getString("started").equals("ok")) {
                            try {
                                JSONObject jSONObject3 = new JSONObject();
                                JSONObject jSONObject4 = new JSONObject();
                                jSONObject4.put("request", SDKConsts.TAG_VALUE_CONFIGURE);
                                jSONObject4.put("audio", C16709a.this.f50975i.mo125502d());
                                jSONObject4.put("video", C16709a.this.f50975i.mo125503e());
                                jSONObject3.put("message", jSONObject4);
                                this.f50993d.mo125517a((C16697g) new C16684g(jSONObject3));
                                C16709a.this.f50980n.mo125399a(this.f50991b, (C16694d) this);
                                return;
                            } catch (JSONException e) {
                                String b = C16709a.f50968b;
                                SystemUtils.log(6, b, "listener start and config message ex:" + e.getMessage(), (Throwable) null, "com.didichuxing.mlcp.drtc.sdk.a$a", 95);
                                return;
                            }
                        }
                    }
                    if (jSONObject.has("left") && jSONObject.getString("left") != null && jSONObject.getString("left").equals("ok")) {
                        C16709a.this.f50980n.mo125404b(this.f50991b, this);
                        drtcPluginHandle.detach();
                    }
                }
            } catch (JSONException e2) {
                String b2 = C16709a.f50968b;
                SystemUtils.log(6, b2, "listener handle rec message ex:" + e2.getMessage(), (Throwable) null, "com.didichuxing.mlcp.drtc.sdk.a$a", 105);
            }
        }

        /* renamed from: a */
        public void mo125469a(MediaStream mediaStream) {
            if (C16709a.this.f50975i.mo125503e()) {
                if (mediaStream.videoTracks.size() > 0) {
                    mediaStream.videoTracks.get(0).addSink(this.f50990a);
                }
            } else if (mediaStream.videoTracks.size() > 0) {
                mediaStream.videoTracks.get(0).setEnabled(false);
                mediaStream.dispose();
            }
        }
    }

    /* renamed from: com.didichuxing.mlcp.drtc.sdk.a$b */
    /* compiled from: DrtcCallingServiceImpl */
    class C16712b implements C16694d {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final C16696f f50999a;

        /* renamed from: b */
        private BigInteger f51000b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public DrtcPluginHandle f51001c;

        /* renamed from: d */
        private boolean f51002d = false;

        /* renamed from: com.didichuxing.mlcp.drtc.sdk.a$b$a */
        /* compiled from: DrtcCallingServiceImpl */
        class C16713a implements C16698h {

            /* renamed from: a */
            final C16712b f51004a = ((C16712b) this.f51005b.get());

            /* renamed from: b */
            final /* synthetic */ WeakReference f51005b;

            C16713a(WeakReference weakReference) {
                this.f51005b = weakReference;
            }

            /* renamed from: a */
            public void mo125425a(JSONObject jSONObject) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("request", SDKConsts.TAG_VALUE_CONFIGURE);
                    jSONObject2.put("audio", C16709a.this.f50975i.mo125504f());
                    jSONObject2.put("video", C16709a.this.f50975i.mo125505g());
                    jSONObject2.put(SDKConsts.TAG_KEY_BITRATE, 800000);
                    jSONObject2.put(SDKConsts.TAG_KEY_RECORD, C16709a.this.f50975i.mo125500c());
                    if (C16709a.this.f50975i.mo125500c() && StringUtils.isNotEmpty(C16709a.this.f50989w)) {
                        jSONObject2.put(SDKConsts.TAG_KEY_FILENAME, C16709a.this.f50989w);
                    }
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("message", jSONObject2);
                    jSONObject3.put("jsep", jSONObject);
                    this.f51004a.f51001c.mo125517a((C16697g) new C16684g(jSONObject3));
                    this.f51004a.f50999a.mo125407c("[I] Publisher create jsep success and send");
                } catch (JSONException e) {
                    C16696f b = this.f51004a.f50999a;
                    b.mo125407c("[Ex] Publisher send message failed,ex:" + e.getMessage());
                }
            }

            /* renamed from: b */
            public Context mo125426b() {
                return C16709a.this.f50969c.mo125540a();
            }

            /* renamed from: c */
            public void mo125407c(String str) {
                this.f51004a.f50999a.mo125407c(str);
            }

            /* renamed from: j */
            public JSONObject mo125427j() {
                return null;
            }

            /* renamed from: m */
            public EglBase.Context mo125428m() {
                if (C16709a.this.f50977k != null) {
                    return C16709a.this.f50977k.getEglBaseContext();
                }
                return null;
            }

            /* renamed from: r */
            public C16700a mo125429r() {
                C16700a i = C16700a.m37988i();
                i.mo125501d(C16709a.this.f50975i.mo125504f());
                if (C16709a.this.f50975i.mo125493a() == DrtcMode.OnlyAudio) {
                    i.mo125498b(true);
                } else {
                    i.mo125496a(C16709a.this.f50975i.mo125506h());
                    i.mo125498b(false);
                    i.mo125499c(false);
                }
                return C16709a.this.f50975i;
            }

            /* renamed from: s */
            public Boolean mo125430s() {
                return true;
            }
        }

        C16712b(C16696f fVar) {
            this.f50999a = fVar;
        }

        /* renamed from: e */
        private void m38132e() {
            if (this.f51001c != null) {
                WeakReference weakReference = new WeakReference(this);
                if (C16709a.this.f50976j != null) {
                    C16709a.this.f50976j.put(BigInteger.valueOf(999999), C16709a.this.f50987u);
                }
                this.f51001c.mo125518a((C16698h) new C16713a(weakReference));
                return;
            }
            this.f50999a.mo125407c("[E] Publish failed, publisher handler is null");
        }

        /* renamed from: f */
        private void m38133f() {
            if (this.f51001c != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("request", SDKConsts.ACTION_VALUE_JOIN);
                    jSONObject.put(SDKConsts.TAG_KEY_ROOM, C16709a.this.f50986t);
                    jSONObject.put("id", C16709a.this.f50980n.mo125415t());
                    jSONObject.put(SDKConsts.TAG_KEY_PTYPE, SDKConsts.TAG_VALUE_PUBLISHER);
                    jSONObject.put("display", C16709a.this.f50987u);
                    if (StringUtils.isNotEmpty(C16709a.this.f50988v)) {
                        jSONObject.put(SDKConsts.TAG_KEY_PIN, C16709a.this.f50988v);
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("message", jSONObject);
                    this.f51001c.mo125517a((C16697g) new C16684g(jSONObject2));
                    this.f50999a.mo125407c("[I] Publisher joining session ...");
                } catch (JSONException e) {
                    C16696f fVar = this.f50999a;
                    fVar.mo125407c("[Ex] Publisher join session failed, ex:" + e.getMessage());
                }
            } else {
                this.f50999a.mo125407c("[E] Publisher join session, publisher handler is null");
            }
        }

        /* renamed from: a */
        public void mo125469a(MediaStream mediaStream) {
        }

        /* renamed from: c */
        public DrtcPluginRoleType mo125472c() {
            return DrtcPluginRoleType.PublisherRole;
        }

        /* renamed from: d */
        public void mo125474d(String str) {
            C16709a.this.m38083g();
        }

        /* renamed from: g */
        public DrtcSupportedPlugins mo125475g() {
            if (C16709a.this.f50975i.mo125493a() != DrtcMode.OnlyAudio) {
                return DrtcSupportedPlugins.SATURN_VIDEO_ROOM;
            }
            return DrtcSupportedPlugins.SATURN_AUDIO_BRIDGE;
        }

        /* renamed from: o */
        public void mo125476o() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("message", new JSONObject().put("request", "leave"));
                this.f51001c.mo125517a((C16697g) new C16684g(jSONObject));
                this.f50999a.mo125407c("[I] Publisher on leaving...");
            } catch (JSONException e) {
                String b = C16709a.f50968b;
                SystemUtils.log(6, b, "listener send leave message ex:" + e.getMessage(), (Throwable) null, "com.didichuxing.mlcp.drtc.sdk.a$b", 9);
            }
        }

        /* renamed from: p */
        public String mo125477p() {
            return "DrtcSDKDroid-" + new C16723f().mo125582a(12);
        }

        /* renamed from: a */
        private void m38130a(BigInteger bigInteger, BigInteger bigInteger2, String str) {
            VideoSink videoSink;
            if (C16709a.this.f50976j != null) {
                if (!C16709a.this.f50976j.containsKey(bigInteger)) {
                    C16709a.this.f50976j.put(bigInteger, str);
                } else {
                    return;
                }
            }
            C16709a.this.m38067a(str);
            if (C16709a.this.f50975i.mo125493a() != DrtcMode.OnlyAudio) {
                if (C16709a.this.f50975i.mo125503e()) {
                    try {
                        Thread.sleep(Constants.SUBTITUDE_LOC_EFFECTIVE_TIME);
                    } catch (InterruptedException e) {
                        C16696f fVar = this.f50999a;
                        fVar.mo125407c("[Ex] New Remote Feed thread sleep ex: " + e.getMessage());
                    }
                    if (!C16709a.this.f50973g.containsKey(bigInteger)) {
                        if (C16709a.this.f50972f.isEmpty()) {
                            this.f50999a.mo125407c("[W] No available renderer for Remote Feed ");
                            return;
                        }
                        C16709a.this.f50973g.put(bigInteger, C16709a.this.f50972f.pop());
                    }
                    if (C16709a.this.f50973g.size() > 0) {
                        videoSink = (VideoSink) C16709a.this.f50973g.get(bigInteger);
                        C16709a.this.f50980n.mo125397a((C16694d) new C16710a(bigInteger, videoSink, bigInteger2));
                        this.f50999a.mo125407c("[I] New remote feed attaching ...");
                    }
                }
                videoSink = null;
                C16709a.this.f50980n.mo125397a((C16694d) new C16710a(bigInteger, videoSink, bigInteger2));
                this.f50999a.mo125407c("[I] New remote feed attaching ...");
            }
        }

        /* renamed from: c */
        public void mo125407c(String str) {
            this.f50999a.mo125407c(str);
        }

        /* renamed from: d */
        public void mo125473d() {
            C16709a.this.f50980n.mo125419x();
        }

        /* renamed from: a */
        public void mo125466a(DrtcPluginHandle drtcPluginHandle) {
            C16696f fVar = this.f50999a;
            fVar.mo125407c("[I] Publisher plugin attach success,handler id : " + drtcPluginHandle.mo125520b());
            this.f51001c = drtcPluginHandle;
            C16709a.this.f50969c.f50957a = drtcPluginHandle;
            m38133f();
        }

        /* renamed from: a */
        public void mo125467a(String str) {
            C16709a.this.m38084g(str);
        }

        /* renamed from: a */
        public void mo125468a(JSONObject jSONObject, JSONObject jSONObject2, DrtcPluginHandle drtcPluginHandle) {
            try {
                String string = jSONObject.getString(DrtcSupportedPlugins.pluginEventTag(mo125475g()));
                if (string.equals("joined")) {
                    this.f50999a.mo125407c("[I] Rec resp event: [joined]");
                    if (jSONObject.has(SDKConsts.TAG_KEY_PRIVID)) {
                        this.f51000b = new BigInteger(jSONObject.getString(SDKConsts.TAG_KEY_PRIVID));
                    }
                    if (!this.f51002d && mo125475g() == DrtcSupportedPlugins.SATURN_AUDIO_BRIDGE) {
                        this.f51002d = true;
                        m38132e();
                    }
                    m38128a(mo125475g(), jSONObject);
                } else if (string.equals("destroyed")) {
                    this.f50999a.mo125407c("[I] Publisher receive event: [destroyed]");
                    C16709a.this.m38088j();
                } else if (string.equals("event")) {
                    m38128a(mo125475g(), jSONObject);
                    if (jSONObject.has("leaving")) {
                        this.f50999a.mo125407c("[I] Receive event: [leaving]");
                        if (jSONObject.getString("leaving").equals("ok")) {
                            this.f51001c.detach();
                        } else {
                            m38129a(new BigInteger(jSONObject.getString("leaving")), mo125475g());
                        }
                    } else {
                        if (jSONObject.has("error_code")) {
                            if (jSONObject.getInt("error_code") == 433 || jSONObject.getInt("error_code") == 489) {
                                C16709a.this.m38084g(jSONObject.getString("error"));
                            }
                        }
                        if (jSONObject.has("error_code") && (jSONObject.getInt("error_code") == 426 || jSONObject.getInt("error_code") == 485)) {
                            C16709a.this.m38084g(jSONObject.getString("error"));
                        } else if (jSONObject.has("result") && jSONObject.getString("result").equals("ok")) {
                            this.f50999a.mo125407c("[I] Handler ab configured");
                        } else if (!jSONObject.has("configured") || !jSONObject.getString("configured").equals("ok")) {
                            C16696f fVar = this.f50999a;
                            fVar.mo125407c("[W] Any other event [" + jSONObject + "] ,no resolve");
                        } else {
                            this.f50999a.mo125407c("[I] Handler vc configured");
                        }
                    }
                } else if (string.equals("left")) {
                    this.f51002d = false;
                    this.f51001c.detach();
                }
                if (jSONObject2 != null) {
                    this.f51001c.mo125522c((C16698h) new C16685h((C16700a) null, jSONObject2, true));
                }
            } catch (JSONException e) {
                C16696f fVar2 = this.f50999a;
                fVar2.mo125407c("Publish Message Handle ex: " + e.getMessage());
            }
        }

        /* renamed from: a */
        private void m38128a(DrtcSupportedPlugins drtcSupportedPlugins, JSONObject jSONObject) throws JSONException {
            String str = drtcSupportedPlugins == DrtcSupportedPlugins.SATURN_AUDIO_BRIDGE ? SDKConsts.TAG_COMMON_PARTICIPANTS : SDKConsts.TAG_COMMON_PUBLISHERS;
            if (jSONObject.has(str)) {
                JSONArray jSONArray = jSONObject.getJSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    m38130a(new BigInteger(jSONObject2.getString("id")), this.f51000b, jSONObject2.getString("display"));
                }
            }
        }

        /* renamed from: a */
        private void m38129a(BigInteger bigInteger, DrtcSupportedPlugins drtcSupportedPlugins) {
            if (drtcSupportedPlugins != DrtcSupportedPlugins.SATURN_AUDIO_BRIDGE || C16709a.this.f50976j == null) {
                C16709a.this.f50980n.mo125403b(bigInteger);
                C16709a.this.m38077d(bigInteger.toString());
            } else if (C16709a.this.f50976j.containsKey(bigInteger)) {
                C16709a.this.f50976j.remove(bigInteger);
                C16709a.this.m38077d((String) C16709a.this.f50976j.get(bigInteger));
            }
        }

        /* renamed from: a */
        public boolean mo125471a() {
            return C16709a.this.f50985s;
        }

        /* renamed from: a */
        public void mo125465a(DrtcCameraType drtcCameraType) {
            C16709a.this.m38061a(drtcCameraType);
        }

        /* renamed from: a */
        public void mo125464a(int i) {
            C16709a.this.m38060a(i);
        }

        /* renamed from: a */
        public void mo125470a(PeerConnection.IceConnectionState iceConnectionState) {
            C16696f fVar = this.f50999a;
            fVar.mo125407c("[I] Publisher's ice state change to " + iceConnectionState.toString());
            C16709a.this.m38068a(iceConnectionState);
        }
    }

    C16709a(DrtcSDK drtcSDK) {
        if (drtcSDK != null) {
            m38062a(DrtcSvcStatus.idle);
            this.f50969c = drtcSDK;
            this.f50970d = new C16690e();
            this.f50974h = this.f50969c.f50958b;
            this.f50975i = C16700a.m37988i();
            return;
        }
        throw new NullPointerException("[Ex] Drtc SDK shouldn't be null");
    }

    /* renamed from: a */
    public static DrtcSvcStatus m38059a() {
        return f50967a;
    }

    /* renamed from: c */
    private boolean m38074c() {
        return f50967a == DrtcSvcStatus.idle;
    }

    /* renamed from: d */
    private void m38076d() {
        m38062a(DrtcSvcStatus.idle);
        C16679e eVar = this.f50980n;
        if (eVar != null && this.f50969c != null) {
            eVar.mo125417v();
            mo125407c("[I] Client leave session :" + this.f50969c.mo125543b());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m38081f() {
        m38062a(DrtcSvcStatus.inCall);
        mo125407c("[I] Client pc connected");
        C16688c[] b = this.f50970d.mo125462b();
        if (b != null) {
            for (C16688c cVar : b) {
                CallingServiceListener callingServiceListener = (CallingServiceListener) cVar;
                HashMap<BigInteger, String> hashMap = this.f50976j;
                if (hashMap != null) {
                    callingServiceListener.onConnectReady(false, hashMap.size());
                } else {
                    callingServiceListener.onConnectReady(false, 0);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m38083g() {
        mo125407c("[W] Camera open failed --> permission deny");
        C16688c[] b = this.f50970d.mo125462b();
        if (b != null) {
            for (C16688c cVar : b) {
                ((CallingServiceListener) cVar).onCameraNoPermission();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m38088j() {
        mo125407c("[I] Core Session has been destroyed");
        m38062a(DrtcSvcStatus.idle);
        C16688c[] b = this.f50970d.mo125462b();
        if (b != null) {
            for (C16688c cVar : b) {
                ((CallingServiceListener) cVar).onSessionDestroy();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public void m38090k() {
        if (!m38074c()) {
            mo125407c("[W] Media connection closed by network lost ");
            C16688c[] b = this.f50970d.mo125462b();
            if (b != null) {
                for (C16688c cVar : b) {
                    ((CallingServiceListener) cVar).onDisconnectedByError();
                }
            }
            m38062a(DrtcSvcStatus.idle);
        }
    }

    public void addListener(CallingServiceListener callingServiceListener) {
        C16690e eVar = this.f50970d;
        if (eVar != null) {
            eVar.mo125459a(callingServiceListener);
        }
    }

    public int callOut(Context context, SurfaceViewRenderer surfaceViewRenderer, int i, String str) {
        return callOut(context, surfaceViewRenderer, i, str, true);
    }

    public synchronized DrtcCaptureFrameType captureLocalFrame(FrameReceiver frameReceiver) {
        if (m38074c()) {
            return DrtcCaptureFrameType.NOTINCALLING;
        } else if (!this.f50983q) {
            this.f50983q = true;
            this.f50981o = frameReceiver;
            return DrtcCaptureFrameType.SUCCESS;
        } else {
            return DrtcCaptureFrameType.CAPTURING;
        }
    }

    public int hangupCalling() {
        this.f50969c.mo125541a("[I] Hang up call");
        this.f50974h.mo125561a();
        m38076d();
        return 0;
    }

    /* renamed from: q */
    public List<PeerConnection.IceServer> mo125485q() {
        return this.f50971e;
    }

    public void removeListener(CallingServiceListener callingServiceListener) {
        C16690e eVar = this.f50970d;
        if (eVar != null && eVar.mo125463c() > 0) {
            this.f50970d.mo125461b(callingServiceListener);
        }
    }

    public int setupRemoteVideo(SurfaceViewRenderer surfaceViewRenderer) {
        if (surfaceViewRenderer == null) {
            return -1;
        }
        surfaceViewRenderer.init(this.f50977k.getEglBaseContext(), (RendererCommon.RendererEvents) null);
        surfaceViewRenderer.setEnableHardwareScaler(true);
        this.f50972f.push(surfaceViewRenderer);
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m38067a(String str) {
        mo125407c("[I] New remote peer joined");
        C16688c[] b = this.f50970d.mo125462b();
        if (b != null) {
            for (C16688c cVar : b) {
                CallingServiceListener callingServiceListener = (CallingServiceListener) cVar;
                callingServiceListener.onNewRemoteFeed(str);
                callingServiceListener.onNewRemoteFeedWithCount(str, this.f50976j.size());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m38077d(String str) {
        mo125407c("[I] Remote peer leaved");
        C16688c[] b = this.f50970d.mo125462b();
        if (b != null) {
            for (C16688c cVar : b) {
                CallingServiceListener callingServiceListener = (CallingServiceListener) cVar;
                callingServiceListener.onRemoteFeedLeave(str);
                callingServiceListener.onRemoteFeedLeaveWithCount(str, this.f50976j.size());
            }
        }
    }

    /* renamed from: e */
    private void m38079e() {
        m38062a(DrtcSvcStatus.idle);
        this.f50969c.mo125544c();
        try {
            if (this.f50971e.size() > 0) {
                this.f50971e.clear();
                mo125407c("[I] Clear ice servers pool");
            }
            if (this.f50973g.size() > 0) {
                for (Map.Entry<BigInteger, VideoSink> value : this.f50973g.entrySet()) {
                    SurfaceViewRenderer surfaceViewRenderer = (SurfaceViewRenderer) value.getValue();
                    surfaceViewRenderer.clearImage();
                    surfaceViewRenderer.release();
                }
                this.f50973g.clear();
                mo125407c("[I] Clear remote renderers");
            }
            if (this.f50978l != null) {
                this.f50978l.clearImage();
                this.f50978l.release();
                mo125407c("[I] Release local renderer");
            }
            if (this.f50977k != null) {
                this.f50977k.release();
                mo125407c("[I] Release rootEglBase context");
            }
            if (this.f50970d.mo125463c() > 0) {
                this.f50970d.mo125460a();
            }
        } catch (NullPointerException e) {
            mo125407c("[Ex] Close Resources ex:" + e.getMessage());
        } finally {
            this.f50978l = null;
            this.f50977k = null;
        }
        mo125407c("[I] Release all resources already");
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m38084g(String str) {
        mo125407c("[I] Join session failed :" + str);
        m38062a(DrtcSvcStatus.idle);
        C16688c[] b = this.f50970d.mo125462b();
        if (b != null) {
            for (C16688c cVar : b) {
                ((CallingServiceListener) cVar).onJoinFailed(str);
            }
        }
    }

    public int callOut(Context context, SurfaceViewRenderer surfaceViewRenderer, int i, String str, String str2, boolean z) {
        this.f50975i.mo125501d(z);
        return m38057a(context, surfaceViewRenderer, i, str, false, str2);
    }

    /* renamed from: n */
    public String mo125484n() {
        return SDKConsts.getSysConfig().f50901b;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m38060a(int i) {
        C16688c[] b;
        if (!m38074c() && (b = this.f50970d.mo125462b()) != null) {
            for (C16688c cVar : b) {
                ((CallingServiceListener) cVar).onNetworkQuality(i);
            }
        }
    }

    /* renamed from: c */
    public void mo125407c(String str) {
        DrtcSDK drtcSDK = this.f50969c;
        if (drtcSDK != null) {
            drtcSDK.mo125541a(str);
        }
    }

    /* renamed from: e */
    public void mo125480e(String str) {
        mo125407c("[I] Session server start Success:" + str);
    }

    public int callOut(Context context, SurfaceViewRenderer surfaceViewRenderer, int i, String str, boolean z) {
        return m38057a(context, surfaceViewRenderer, i, str, z, (String) null);
    }

    public int callOut(Context context, SurfaceViewRenderer surfaceViewRenderer, int i, String str, String str2, DrtcMode drtcMode) {
        this.f50975i.mo125495a(drtcMode);
        return m38057a(context, surfaceViewRenderer, i, str, false, str2);
    }

    /* renamed from: a */
    static synchronized void m38062a(DrtcSvcStatus drtcSvcStatus) {
        synchronized (C16709a.class) {
            f50967a = drtcSvcStatus;
        }
    }

    /* renamed from: a */
    private int m38057a(Context context, SurfaceViewRenderer surfaceViewRenderer, int i, String str, boolean z, String str2) {
        Context context2 = context;
        SurfaceViewRenderer surfaceViewRenderer2 = surfaceViewRenderer;
        int i2 = i;
        String str3 = str;
        boolean z2 = z;
        if (context2 == null || !m38074c()) {
            mo125407c("[W] SDK is in calling ");
            return -1;
        }
        m38062a(DrtcSvcStatus.onCalling);
        this.f50988v = str2;
        this.f50986t = i2;
        this.f50987u = str3;
        if (!this.f50969c.mo125542a(i2)) {
            mo125407c("[W] Init session conn svr failed,please check session info.");
            m38062a(DrtcSvcStatus.idle);
            return -1;
        }
        mo125407c(String.format("[I] Init session conn svr success.server[%s],icesvr[%s]", new Object[]{SDKConsts.getSysConfig().f50901b, SDKConsts.getSysConfig().f50904e}));
        this.f50975i.mo125494a(z2);
        if (z2) {
            this.f50989w = String.format("%s-%s-%s.wav", new Object[]{Integer.valueOf(i), str3, Long.valueOf(new Date().getTime())});
        }
        mo125407c("[I] Joining in drtc-session:" + this.f50969c.mo125543b());
        this.f50977k = EglBase.CC.create();
        if (!(surfaceViewRenderer2 == null || this.f50975i.mo125493a() == DrtcMode.OnlyAudio)) {
            this.f50979m = new ProxyVideoSink();
            this.f50978l = surfaceViewRenderer2;
            try {
                surfaceViewRenderer2.init(this.f50977k.getEglBaseContext(), (RendererCommon.RendererEvents) null);
            } catch (IllegalStateException unused) {
                mo125407c("[W] local render has been init again");
                SystemUtils.log(5, f50968b, "local render has been init again", (Throwable) null, "com.didichuxing.mlcp.drtc.sdk.a", 48);
            }
            this.f50978l.setMirror(true);
            this.f50978l.setZOrderMediaOverlay(true);
            this.f50978l.setEnableHardwareScaler(true);
            this.f50979m.setTarget(this.f50978l);
            this.f50979m.setListener(this);
        }
        if (this.f50971e.size() < 2) {
            if (StringUtils.isEmpty(SDKConsts.getSysConfig().f50904e) || StringUtils.isEmpty(SDKConsts.getSysConfig().f50905f) || StringUtils.isEmpty(SDKConsts.getSysConfig().f50906g)) {
                mo125407c("[W] add ice servers failed");
            } else {
                this.f50971e.add(PeerConnection.IceServer.builder(String.format("turn:%s?transport=udp", new Object[]{SDKConsts.getSysConfig().f50904e})).setUsername(SDKConsts.getSysConfig().f50905f).setPassword(SDKConsts.getSysConfig().f50906g).createIceServer());
                this.f50971e.add(PeerConnection.IceServer.builder(String.format("stun:%s?transport=udp", new Object[]{SDKConsts.getSysConfig().f50904e})).setUsername(SDKConsts.getSysConfig().f50905f).setPassword(SDKConsts.getSysConfig().f50906g).createIceServer());
                this.f50971e.add(PeerConnection.IceServer.builder(String.format("stun:%s?transport=tcp", new Object[]{SDKConsts.getSysConfig().f50904e})).setUsername(SDKConsts.getSysConfig().f50905f).setPassword(SDKConsts.getSysConfig().f50906g).createIceServer());
            }
        }
        if (this.f50980n == null) {
            this.f50980n = new C16679e(this);
        }
        C16679e eVar = this.f50980n;
        if (eVar == null) {
            mo125407c("[E] Join in session failed,session svr is null");
            m38062a(DrtcSvcStatus.idle);
            return -1;
        } else if (eVar.mo125395a(context2, this.f50984r).mo125418w()) {
            return 0;
        } else {
            mo125407c("[E] Session server start failed,end calling");
            m38062a(DrtcSvcStatus.idle);
            return -1;
        }
    }

    public int callOut(Context context, SurfaceViewRenderer surfaceViewRenderer, int i, String str, String str2, DrtcMode drtcMode, boolean z) {
        this.f50985s = z;
        this.f50975i.mo125495a(drtcMode);
        return m38057a(context, surfaceViewRenderer, i, str, false, str2);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m38068a(PeerConnection.IceConnectionState iceConnectionState) {
        if (iceConnectionState.equals(PeerConnection.IceConnectionState.DISCONNECTED)) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    C16709a.this.m38090k();
                }
            });
        }
        if (iceConnectionState.equals(PeerConnection.IceConnectionState.CONNECTED)) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    C16709a.this.m38081f();
                }
            });
        }
    }

    public int callOut(Context context, SurfaceViewRenderer surfaceViewRenderer, int i, String str, String str2, DrtcMode drtcMode, boolean z, boolean z2) {
        this.f50982p = z2;
        this.f50985s = z;
        this.f50975i.mo125495a(drtcMode);
        return m38057a(context, surfaceViewRenderer, i, str, false, str2);
    }

    /* renamed from: h */
    public void mo125482h() {
        mo125407c("[I] Core session destroyed");
        this.f50980n = null;
        m38088j();
        m38079e();
    }

    /* renamed from: i */
    public PeerConnection.IceTransportsType mo125483i() {
        if (this.f50982p) {
            return PeerConnection.IceTransportsType.RELAY;
        }
        return PeerConnection.IceTransportsType.ALL;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m38061a(DrtcCameraType drtcCameraType) {
        this.f50978l.setMirror(drtcCameraType == DrtcCameraType.FrontFace);
        mo125407c("[I] Camera switch to " + drtcCameraType.toString() + " by client remote command");
    }

    /* renamed from: b */
    public void mo125479b(String str) {
        mo125407c("[E] Session server start failed:" + str);
        m38084g(str);
    }

    /* renamed from: f */
    public void mo125481f(String str) {
        mo125407c("[E] Core session create failure");
        m38084g(str);
    }

    /* renamed from: a */
    public void mo125458a(VideoFrame videoFrame) {
        if (this.f50983q && videoFrame != null && this.f50981o != null) {
            this.f50983q = false;
            this.f50981o.receiveNewFrame(C16715a.m38160a(videoFrame), DrtcCaptureFrameType.SUCCESS);
            mo125407c("[I] Capture one frame of local");
        }
    }

    /* renamed from: a */
    public void mo125478a(BigInteger bigInteger) {
        mo125407c("[I] Core session [" + bigInteger + "] create success");
        this.f50980n.mo125397a((C16694d) new C16712b(this));
        MetricReporter.getInstance().SetReporterSession(bigInteger.toString());
    }
}
