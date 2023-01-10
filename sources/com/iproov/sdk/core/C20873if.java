package com.iproov.sdk.core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import androidx.core.content.ContextCompat;
import com.iproov.sdk.C20900do;
import com.iproov.sdk.IProov;
import com.iproov.sdk.bridge.OptionsBridge;
import com.iproov.sdk.cameray.C20752break;
import com.iproov.sdk.cameray.C20758class;
import com.iproov.sdk.cameray.C20776try;
import com.iproov.sdk.cameray.Orientation;
import com.iproov.sdk.core.C20864const;
import com.iproov.sdk.core.C20873if;
import com.iproov.sdk.core.exception.CameraException;
import com.iproov.sdk.core.exception.CameraPermissionException;
import com.iproov.sdk.core.exception.FaceDetectorException;
import com.iproov.sdk.core.exception.IProovException;
import com.iproov.sdk.core.exception.InvalidOptionsException;
import com.iproov.sdk.core.exception.NetworkException;
import com.iproov.sdk.core.exception.UnexpectedErrorException;
import com.iproov.sdk.crypto.C20897do;
import com.iproov.sdk.crypto.C20898for;
import com.iproov.sdk.crypto.C20899if;
import com.iproov.sdk.face.C20901do;
import com.iproov.sdk.face.FaceDetector;
import com.iproov.sdk.face.model.FaceFeature;
import com.iproov.sdk.graphics.iproov.OpenGLRenderer;
import com.iproov.sdk.logging.IPLog;
import com.iproov.sdk.p227ui.activity.C20907do;
import com.iproov.sdk.p227ui.activity.IProovLandscapeActivity;
import com.iproov.sdk.p227ui.activity.IProovPortraitActivity;
import com.iproov.sdk.p227ui.activity.IProovReverseLandscapeActivity;
import com.iproov.sdk.p227ui.activity.IProovReversePortraitActivity;
import com.iproov.sdk.p227ui.views.LivenessDebugOverlay;
import com.yanzhenjie.permission.runtime.Permission;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p055case.C1269do;
import p055case.C1273goto;
import p055case.C1274if;
import p055case.C1275new;
import p055case.C1277try;
import p069native.C2947if;
import p091public.C3562if;
import p091public.C3563new;
import p092return.C3566do;
import p094super.C3650for;
import p094super.C3654new;
import p094super.C3655this;
import p095switch.C3660catch;
import p095switch.C3668else;
import p095switch.C3673for;
import p095switch.C3679throw;
import p095switch.C3680try;
import p097throw.C3686do;
import p097throw.C3687if;
import p098try.C3689for;
import p098try.C3690if;
import p230const.C21729if;
import p235do.C21820break;
import p235do.C21824for;
import p235do.C21827new;
import p235do.C21828this;
import p236else.C21831for;
import p237final.C21833do;
import p237final.C21836if;
import p238for.C21839do;
import p238for.C21840for;
import p242if.C21998do;
import p242if.C22005if;
import p242if.C22006new;
import p243import.C22010if;

/* renamed from: com.iproov.sdk.core.if */
/* compiled from: CaptureManager */
public final class C20873if {

    /* renamed from: a */
    private static final C20752break[] f57105a = {C20752break.f56849do};

    /* renamed from: b */
    private static final C20752break[] f57106b = {C20752break.EXTERNAL, C20752break.f56850if};
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final String f57107c = C20873if.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: A */
    public C1269do f57108A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public C3650for f57109B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public C3566do f57110C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public C21840for f57111D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public FaceFeature f57112E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public C20864const f57113F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public C20892try f57114G;

    /* renamed from: H */
    private Bitmap f57115H;
    /* access modifiers changed from: private */

    /* renamed from: I */
    public C3563new f57116I;
    /* access modifiers changed from: private */

    /* renamed from: J */
    public RectF f57117J;
    /* access modifiers changed from: private */

    /* renamed from: K */
    public C1275new f57118K;
    /* access modifiers changed from: private */

    /* renamed from: L */
    public C20899if f57119L;
    /* access modifiers changed from: private */

    /* renamed from: M */
    public OpenGLRenderer f57120M;

    /* renamed from: N */
    private Activity f57121N;
    /* access modifiers changed from: private */

    /* renamed from: O */
    public C21827new f57122O;
    /* access modifiers changed from: private */

    /* renamed from: P */
    public C22005if f57123P;
    /* access modifiers changed from: private */

    /* renamed from: Q */
    public Orientation f57124Q;

    /* renamed from: R */
    private int f57125R;

    /* renamed from: S */
    private long f57126S;
    /* access modifiers changed from: private */

    /* renamed from: T */
    public long f57127T;
    /* access modifiers changed from: private */

    /* renamed from: U */
    public boolean f57128U;

    /* renamed from: V */
    private final C3690if.C3699this f57129V;

    /* renamed from: W */
    private final C20878goto f57130W;

    /* renamed from: X */
    private final C22010if.C22012if f57131X;

    /* renamed from: Y */
    private final C20776try.C20777do f57132Y;
    /* access modifiers changed from: private */

    /* renamed from: Z */
    public final C21840for.C21841do f57133Z;
    /* access modifiers changed from: private */

    /* renamed from: aa */
    public final C3650for.C3651do f57134aa;

    /* renamed from: ab */
    private final C20864const.C20865do f57135ab;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Context f57136d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final String f57137e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final C20886return f57138f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final IProov.Listener f57139g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final C3689for f57140h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final C21831for f57141i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final C22010if f57142j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final C20776try f57143k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public final C2947if f57144l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public final C21836if f57145m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public final ExecutorService f57146n = C3660catch.m7405do("FrameProcessor", C3660catch.C3662for.MEDIUM, C3660catch.C3664new.RUN_TASK_ONLY_IF_IDLE);

    /* renamed from: o */
    private final ExecutorService f57147o = C3660catch.m7405do("FrameEncoder", C3660catch.C3662for.LOW, C3660catch.C3664new.QUEUE_TASKS_FIFO);
    /* access modifiers changed from: private */

    /* renamed from: p */
    public final C21729if f57148p = new C21729if();
    /* access modifiers changed from: private */

    /* renamed from: q */
    public final C21729if f57149q = new C21729if();
    /* access modifiers changed from: private */

    /* renamed from: r */
    public final C20872goto f57150r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public final Object f57151s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public final C20897do f57152t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public final C20784c f57153u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public final Queue<C1277try> f57154v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public final Queue<Long> f57155w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public final AtomicInteger f57156x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public FaceDetector f57157y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public C3686do f57158z;

    /* renamed from: com.iproov.sdk.core.if$else */
    /* compiled from: CaptureManager */
    static /* synthetic */ class C20876else {

        /* renamed from: do */
        static final /* synthetic */ int[] f57161do;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.iproov.sdk.cameray.Orientation[] r0 = com.iproov.sdk.cameray.Orientation.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f57161do = r0
                com.iproov.sdk.cameray.Orientation r1 = com.iproov.sdk.cameray.Orientation.PORTRAIT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f57161do     // Catch:{ NoSuchFieldError -> 0x001d }
                com.iproov.sdk.cameray.Orientation r1 = com.iproov.sdk.cameray.Orientation.LANDSCAPE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f57161do     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.iproov.sdk.cameray.Orientation r1 = com.iproov.sdk.cameray.Orientation.REVERSE_PORTRAIT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f57161do     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.iproov.sdk.cameray.Orientation r1 = com.iproov.sdk.cameray.Orientation.REVERSE_LANDSCAPE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.core.C20873if.C20876else.<clinit>():void");
        }
    }

    /* renamed from: com.iproov.sdk.core.if$if */
    /* compiled from: CaptureManager */
    class C20879if implements C22010if.C22012if {
        C20879if() {
        }

        /* renamed from: do */
        private int m43408do(int i) {
            return C20873if.this.f57116I.mo43303do().get(Integer.valueOf(i)) == Boolean.TRUE ? 1 : 0;
        }

        /* access modifiers changed from: private */
        /* renamed from: for  reason: not valid java name */
        public /* synthetic */ void m48136for() {
            C20873if.this.m48125import();
        }

        /* renamed from: do */
        public void mo171505do() {
        }

        /* renamed from: if */
        public void mo171509if() {
        }

        public void onConnected() {
            JSONObject jSONObject = new JSONObject(C22006new.m45189do(C20873if.this.f57136d, C20873if.this.f57137e, C20873if.this.f57138f.f57178if));
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(C21998do.GENUINE_PRESENCE_ASSURANCE);
            C20873if.this.f57116I.m46645for();
            if (C20873if.this.f57116I.mo43306if()) {
                jSONArray.put(C21998do.LIVENESS);
            } else {
                IPLog.m43494w(C20873if.f57107c, "Liveness not available in supported_assurance_types due to sensors lacking");
            }
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(m43408do(1));
            jSONArray2.put(m43408do(10));
            jSONArray2.put(m43408do(4));
            jSONArray2.put(m43408do(9));
            jSONArray2.put(m43408do(11));
            C3680try.m7470do(jSONObject, "avs", (Object) jSONArray2);
            C3680try.m7470do(jSONObject, "supported_assurance_types", (Object) jSONArray);
            C3680try.m7470do(jSONObject, "supported_codecs", (Object) C3680try.m7468do(C1273goto.m990do(C20873if.this.f57145m)));
            C3680try.m7470do(jSONObject, "dal", (Object) Integer.valueOf(C20873if.this.f57152t.f57196do));
            C3680try.m7470do(jSONObject, "opt", (Object) OptionsBridge.toJsonForAnalytics(C20873if.this.m48129try()));
            if (C20873if.this.f57152t != C20897do.UNSUPPORTED) {
                try {
                    String str = C3679throw.m7440do(C20873if.this.f57119L.m48139else().getDer());
                    String str2 = C3679throw.m7440do(C20873if.this.f57119L.mo171529do(C20873if.this.f57137e.getBytes()));
                    C3680try.m7470do(jSONObject, "pky", (Object) str);
                    C3680try.m7470do(jSONObject, "tsg", (Object) str2);
                } catch (C20898for e) {
                    e.printStackTrace();
                    String a = C20873if.f57107c;
                    IPLog.m43494w(a, "Failed to add device assurance info:" + e.getMessage());
                }
            }
            C20873if.this.f57142j.mo181328do(jSONObject);
        }

        public void onConnecting() {
            C20873if.this.f57140h.m46682new();
        }

        public void onError(IProovException iProovException) {
            C20873if.this.f57140h.mo43543do(iProovException);
        }

        /* renamed from: do */
        public void mo171508do(C22005if ifVar) {
            C22005if unused = C20873if.this.f57123P = ifVar;
            C20900do.m43469do(ifVar);
            C20873if.this.m43355j();
            C20873if.this.f57153u.mo171368a(ifVar.m48272final());
            if (ifVar.mo181321if() != null) {
                IPLog.m43494w("iProov", ifVar.mo181321if());
            }
            if (ifVar.mo181316do() == C21998do.GENUINE_PRESENCE_ASSURANCE) {
                C21840for unused2 = C20873if.this.f57111D = new C21840for(ifVar.m48275new(), ifVar.m48276try(), C20873if.this.f57133Z);
                C20873if ifVar2 = C20873if.this;
                C20892try unused3 = ifVar2.f57114G = ifVar2.f57111D;
                C20873if.this.f57142j.mo181325do(C20873if.this.f57114G.mo171466do());
                C20873if ifVar3 = C20873if.this;
                C3650for unused4 = ifVar3.f57109B = new C3654new(ifVar3.f57136d, C20873if.this.f57143k, ifVar.m48268case(), C20873if.this.f57134aa, C20873if.this.f57150r);
                if (C20873if.this.f57122O != null) {
                    String unused5 = C20873if.f57107c;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Focal Length (init2) = ");
                    sb.append(C20873if.this.f57122O.m48218for());
                    C20873if.this.f57109B.mo43464do(C20873if.this.f57122O.m48218for().floatValue());
                }
            }
            if (ifVar.m48274goto() != 0.0d) {
                C20873if.this.f57157y.setOmega(ifVar.m48274goto());
            }
            C20873if.this.f57158z.m46679for();
            if (C20873if.this.f57144l.m46621throw()) {
                C3679throw.m7441do(3000, (Runnable) new Runnable() {
                    public final void run() {
                        C20873if.C20879if.this.m48136for();
                    }
                });
            }
            if (ifVar.mo181316do() == C21998do.LIVENESS) {
                C20873if.this.m43353i();
            }
            C1275new unused6 = C20873if.this.f57118K = new C1275new(ifVar.m48273for());
            C20873if.this.m43357k();
            C20873if.this.f57140h.mo43541do((String) C3679throw.m7439do(C20873if.this.f57138f.f57177do.f56836ui.title, C22006new.m45188do(C20873if.this.f57136d, ifVar)));
        }

        /* renamed from: do */
        public void mo171506do(double d) {
            if (C20873if.this.f57140h.mo43546if() instanceof C3690if.C3691break) {
                C20873if.this.m43329a(d);
            }
        }

        /* renamed from: do */
        public void mo171507do(C20871for forR) {
            C20873if.this.f57140h.mo43539do(forR);
        }
    }

    /* renamed from: com.iproov.sdk.core.if$try */
    /* compiled from: CaptureManager */
    class C20881try implements C3650for.C3651do {
        C20881try() {
        }

        /* renamed from: do */
        public void mo43470do(boolean z) {
            C20873if.this.f57143k.mo171304do(z);
        }

        /* renamed from: do */
        public void mo43469do() {
            C20873if.this.f57143k.mo171299do();
        }
    }

    public C20873if(Context context, String str, String str2, C20886return returnR, IProov.Listener listener) throws IProovException {
        C21836if ifVar = C21833do.m45150do().mo180466if();
        this.f57145m = ifVar;
        this.f57150r = new C20872goto(ifVar);
        this.f57151s = new Object();
        this.f57154v = new LinkedBlockingQueue();
        this.f57155w = new ConcurrentLinkedQueue();
        this.f57156x = new AtomicInteger(0);
        this.f57124Q = Orientation.findByDegrees(270);
        this.f57125R = 0;
        this.f57126S = -1;
        C20875do doVar = new C20875do();
        this.f57129V = doVar;
        this.f57130W = new C20878goto();
        C20879if ifVar2 = new C20879if();
        this.f57131X = ifVar2;
        this.f57132Y = new C20877for();
        this.f57133Z = new C20880new();
        this.f57134aa = new C20881try();
        this.f57135ab = new C20874case();
        this.f57136d = context.getApplicationContext();
        C20899if ifVar3 = null;
        this.f57121N = context instanceof Activity ? (Activity) context : null;
        this.f57138f = returnR;
        this.f57139g = listener;
        this.f57137e = str2;
        this.f57140h = new C3689for(doVar);
        try {
            this.f57157y = C20901do.m43473do(context, returnR.f57177do.capture).getFaceDetector(context, returnR.f57177do.capture);
            new C20782break(context);
            new C20891throw(context);
            IProov.Options.Capture.GenuinePresenceAssurance genuinePresenceAssurance = returnR.f57177do.capture.genuinePresenceAssurance;
            this.f57141i = new C21831for(genuinePresenceAssurance.maxRoll, genuinePresenceAssurance.maxYaw, genuinePresenceAssurance.maxPitch);
            this.f57153u = new C20784c();
            this.f57142j = new C22010if(context, str, str2, returnR.f57177do.network, ifVar2);
            try {
                this.f57158z = new C3686do(context);
            } catch (C3687if unused) {
            }
            this.f57143k = new C20758class(this.f57145m, this.f57132Y, this.f57150r, returnR.f57177do.capture.camera == IProov.Camera.FRONT ? f57105a : f57106b).mo171298do(context);
            C2947if ifVar4 = new C2947if(context);
            this.f57144l = ifVar4;
            this.f57128U = ifVar4.m46613const();
            try {
                this.f57116I = new C3563new(context);
            } catch (C3562if unused2) {
                IPLog.m43494w(f57107c, "Sensor Manager unavailable");
            }
            try {
                C20899if ifVar5 = C20899if.m43463do(context);
                this.f57119L = ifVar5;
                ifVar3 = ifVar5;
            } catch (C20898for e) {
                e.printStackTrace();
                String str3 = f57107c;
                IPLog.m43494w(str3, "Key Store Manager unavailable: " + e.getLocalizedMessage());
                this.f57119L = null;
            } catch (Throwable th) {
                this.f57152t = C20899if.m43462do(this.f57119L);
                throw th;
            }
            this.f57152t = C20899if.m43462do(ifVar3);
        } catch (FaceDetectorException e2) {
            throw new FaceDetectorException(context, e2.getMessage());
        }
    }

    /* renamed from: catch  reason: not valid java name */
    public void m48123catch() {
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m43338b() {
        if (ContextCompat.checkSelfPermission(this.f57136d, Permission.CAMERA) == 0) {
            this.f57120M.mo171555do(this.f57143k, this.f57138f.f57177do.f56836ui, this.f57124Q);
            return;
        }
        C3566do doVar = this.f57110C;
        if (doVar != null) {
            doVar.mo43312do();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m43339b(C21824for forR, boolean z) {
        int i;
        byte[] bArr = forR.mo171342if(this.f57118K.f62275new);
        this.f57155w.add(Long.valueOf(forR.mo171339do()));
        try {
            if (this.f57108A.m46082new()) {
                this.f57108A.mo14140do(bArr);
                if (!z) {
                    this.f57125R++;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("💽 encodeFrame() sent encodedFramesCount=");
                sb.append(this.f57125R);
                sb.append(" ");
                sb.append(z ? C20785case.SUPPLEMENTARY : C20785case.AUTHENTICATION);
                if (this.f57123P.mo181316do() == C21998do.GENUINE_PRESENCE_ASSURANCE) {
                    i = 4;
                } else {
                    i = this.f57114G.mo171466do();
                }
                if (this.f57123P.m48270const() && this.f57125R == i) {
                    this.f57115H = forR.m48215for(1);
                }
            }
        } catch (C1274if e) {
            this.f57140h.mo43543do((IProovException) new UnexpectedErrorException(this.f57136d, (Exception) e));
        }
        if (this.f57125R == this.f57114G.mo171466do()) {
            this.f57108A.mo14139do();
            m43329a(this.f57142j.m48280new());
        }
    }

    /* renamed from: c */
    private void m43340c() {
        this.f57124Q = C3668else.m7416do(this.f57143k.m48075new().m48219new(), this.f57110C.m46648new());
        this.f57140h.mo43546if().m46684for(this.f57110C);
        this.f57121N = null;
        m43355j();
    }

    /* renamed from: d */
    private void m43342d() {
        C3686do doVar = this.f57158z;
        if (doVar != null) {
            doVar.mo43529do();
        }
        C3563new newR = this.f57116I;
        if (newR != null) {
            newR.m46644case();
        }
        OpenGLRenderer openGLRenderer = this.f57120M;
        if (openGLRenderer != null) {
            openGLRenderer.m48145catch();
        }
        synchronized (this.f57151s) {
            FaceDetector faceDetector = this.f57157y;
            if (faceDetector != null) {
                faceDetector.release();
                this.f57157y = null;
            }
        }
        this.f57121N = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m43345e() {
        this.f57147o.execute(new Runnable() {
            public final void run() {
                C20873if.this.m43363n();
            }
        });
        this.f57142j.m48279for();
        C21840for forR = this.f57111D;
        if (forR != null) {
            forR.m48247for();
        }
        C20864const constR = this.f57113F;
        if (constR != null) {
            constR.mo171465c();
        }
        this.f57121N = null;
    }

    /* renamed from: f */
    private void m43347f() {
        C3690if.C3694else elseR;
        StringBuilder sb = new StringBuilder();
        sb.append("*** START FLASHING *** ");
        sb.append(this.f57148p.mo178976do());
        if (this.f57111D != null && this.f57120M != null && (elseR = this.f57140h.m46683try()) != null) {
            this.f57143k.m48074for();
            this.f57153u.mo171367a();
            this.f57111D.mo180489if(this.f57148p.mo178976do(), this.f57120M.getFrameRate());
            m43336a("flashing_start", elseR.m46692try());
            this.f57143k.mo171304do(true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public boolean m43349g() {
        Activity activity = this.f57121N;
        if (activity != null && (activity.isDestroyed() || this.f57121N.isFinishing())) {
            return false;
        }
        Intent intent = new Intent(this.f57136d, m43325a(this.f57138f.f57177do.f56836ui.orientation));
        Activity activity2 = this.f57121N;
        if (activity2 != null && this.f57138f.f57177do.f56836ui.activityCompatibilityRequestCode != null) {
            this.f57121N.startActivityForResult(intent, this.f57138f.f57177do.f56836ui.activityCompatibilityRequestCode.intValue());
        } else if (activity2 != null) {
            this.f57121N.startActivity(intent);
        } else {
            intent.addFlags(268435456);
            this.f57136d.startActivity(intent);
        }
        this.f57121N = null;
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m43351h() {
        this.f57156x.incrementAndGet();
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m43353i() {
        if (this.f57138f.f57177do.f56836ui.orientation != Orientation.PORTRAIT) {
            this.f57140h.mo43543do((IProovException) new InvalidOptionsException(this.f57136d, "Liveness Assurance is currently only supported in portrait orientation"));
        } else if (this.f57113F == null && this.f57122O != null) {
            DisplayMetrics displayMetrics = this.f57136d.getResources().getDisplayMetrics();
            C20864const constR = new C20864const(this.f57136d, this.f57122O, new C21820break(displayMetrics.widthPixels, displayMetrics.heightPixels), this.f57123P.m48271else(), this.f57135ab);
            this.f57113F = constR;
            this.f57114G = constR;
            this.f57142j.mo181325do(constR.mo171466do());
            this.f57143k.mo171300do(new RectF(0.0f, 0.0f, 1.0f, 1.0f));
            C3563new newR = this.f57116I;
            if (newR != null) {
                newR.mo43304do((C3563new.C3564do) this.f57113F.mo171464b());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m43355j() {
        C3679throw.m7442do((Runnable) new Runnable() {
            public final void run() {
                C20873if.this.m43361m();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public void m43357k() {
        C21827new newR;
        if (this.f57118K != null && (newR = this.f57122O) != null) {
            C1269do doVar = new C1269do(newR.mo171312if(), this.f57130W, this.f57118K);
            this.f57108A = doVar;
            doVar.m46081case();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public /* synthetic */ void m43361m() {
        C22005if ifVar;
        C3566do doVar = this.f57110C;
        if (doVar != null && (ifVar = this.f57123P) != null) {
            doVar.mo43315do(ifVar.mo181316do(), this.f57123P.m48272final());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public /* synthetic */ void m43363n() {
        C1269do doVar = this.f57108A;
        if (doVar != null) {
            doVar.mo14139do();
        }
    }

    /* renamed from: break  reason: not valid java name */
    public void m48122break() {
        this.f57140h.mo43543do((IProovException) new CameraPermissionException(this.f57136d));
    }

    /* renamed from: class  reason: not valid java name */
    public void m48124class() {
        this.f57140h.m46681for();
    }

    /* renamed from: import  reason: not valid java name */
    public void m48125import() {
        C3690if ifVar = this.f57140h.mo43546if();
        boolean z = this.f57144l.mo29250do() || this.f57144l.m46621throw();
        if ((this.f57123P != null && this.f57111D != null && z && (ifVar instanceof C3690if.C3697if)) || ifVar.m46685for()) {
            m43347f();
        }
    }

    /* renamed from: new  reason: not valid java name */
    public C21998do m48126new() {
        return this.f57123P.mo181316do();
    }

    /* renamed from: static  reason: not valid java name */
    public void m48127static() {
        this.f57128U = this.f57144l.m46613const();
    }

    /* renamed from: super  reason: not valid java name */
    public synchronized void m48128super() {
        this.f57142j.mo181331if();
    }

    /* renamed from: try  reason: not valid java name */
    public IProov.Options m48129try() {
        return this.f57138f.f57177do;
    }

    /* renamed from: com.iproov.sdk.core.if$do */
    /* compiled from: CaptureManager */
    class C20875do implements C3690if.C3699this {
        C20875do() {
        }

        /* renamed from: do */
        public void mo43568do(C3690if.C3694else elseR) {
        }

        /* renamed from: do */
        public void mo43573do(C3690if ifVar) {
            String unused = C20873if.f57107c;
            StringBuilder sb = new StringBuilder();
            sb.append("🔵 ");
            sb.append(ifVar);
            if (C20873if.this.f57110C != null) {
                ifVar.mo43552if(C20873if.this.f57110C);
            }
        }

        /* renamed from: do */
        public void mo43571do(C3690if.C3698new newR) {
            C20873if.this.f57139g.onConnecting();
        }

        /* renamed from: do */
        public void mo43569do(C3690if.C3695for forR) {
            if (!C20873if.this.m43349g()) {
                C20873if.this.m48124class();
            }
            C20873if.this.f57139g.onConnected();
        }

        /* renamed from: do */
        public void mo43570do(C3690if.C3697if ifVar) {
            C20873if.this.m43336a(ifVar.m46695new().mo43535do(), ifVar.m46696try());
        }

        /* renamed from: do */
        public void mo43565do(C3690if.C3691break breakR) {
            C20873if.this.f57139g.onProcessing(breakR.m46687try(), breakR.m46686new());
        }

        /* renamed from: do */
        public void mo43566do(C3690if.C3692case caseR) {
            C20871for forR = caseR.m46688new();
            C20873if.this.m43345e();
            if (forR.m48121new()) {
                C20873if.this.f57139g.onSuccess(new IProov.SuccessResult(forR.mo171490if(), C20873if.this.m43358l()));
            } else if (forR.m48120for()) {
                C20873if.this.f57139g.onError(new NetworkException(C20873if.this.f57136d, forR.mo171488do(C20873if.this.f57136d)));
            } else {
                C20873if.this.f57139g.onFailure(new IProov.FailureResult(forR.mo171490if(), forR.mo171488do(C20873if.this.f57136d), forR.mo171487do(), C20873if.this.m43358l()));
            }
        }

        /* renamed from: do */
        public void mo43572do(C3690if.C3700try tryR) {
            IProovException iProovException = tryR.m46697new();
            C20873if.this.m43335a(iProovException.getReason());
            C20873if.this.m43345e();
            C20873if.this.f57139g.onError(iProovException);
        }

        /* renamed from: do */
        public void mo43567do(C3690if.C3693do doVar) {
            C20873if.this.m43335a("user_cancelled");
            C20873if.this.m43345e();
            C20873if.this.f57139g.onCancelled();
        }
    }

    /* renamed from: com.iproov.sdk.core.if$for */
    /* compiled from: CaptureManager */
    class C20877for implements C20776try.C20777do {
        C20877for() {
        }

        /* access modifiers changed from: private */
        /* renamed from: for  reason: not valid java name */
        public /* synthetic */ void m48131for() {
            if (C20873if.this.f57109B != null && C20873if.this.f57110C != null) {
                C20873if.this.f57110C.mo43313do(C20873if.this.f57109B.m46662for());
                if (C20873if.this.f57144l.m46613const()) {
                    C20873if.this.f57110C.mo43314do(C20873if.this.f57109B.mo43468if());
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: if */
        public /* synthetic */ void m43396if(C21824for forR) {
            try {
                C3690if.C3697if ifVar = m48130for(forR);
                if (ifVar != null) {
                    C20873if.this.f57140h.mo43542do(ifVar);
                }
                if (C20873if.this.f57149q.mo178978if()) {
                    C20873if.this.f57149q.m48209try();
                } else {
                    C20873if.this.f57149q.m48207for();
                }
                C3679throw.m7442do((Runnable) new Runnable() {
                    public final void run() {
                        C20873if.C20877for.this.m48131for();
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                C20873if.this.f57140h.mo43543do((IProovException) new UnexpectedErrorException(C20873if.this.f57136d, e));
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: new  reason: not valid java name */
        public /* synthetic */ void m48135new() {
            if (C20873if.this.f57110C != null) {
                C20873if.this.f57110C.m46649try();
            }
        }

        /* renamed from: do */
        public void mo171346do(C21827new newR) {
            String unused = C20873if.f57107c;
            if (C20873if.this.f57109B != null) {
                C20873if.this.f57109B.mo43464do(newR.m48218for().floatValue());
            }
            C21827new unused2 = C20873if.this.f57122O = newR;
            C20873if.this.f57120M.m48144break();
            C20873if.this.f57142j.mo181326do(newR.mo171310do(), C20873if.this.f57124Q.angleDegrees);
            C20873if.this.m43357k();
            if (C20873if.this.f57123P != null && C20873if.this.f57123P.mo181316do() == C21998do.LIVENESS) {
                C20873if.this.m43353i();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x003a, code lost:
            if (com.iproov.sdk.core.C20873if.m43354j(r9.f57162do) == null) goto L_0x0061;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0067, code lost:
            if (com.iproov.sdk.core.C20873if.m43299C(r9.f57162do) == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0069, code lost:
            r3 = com.iproov.sdk.core.C20873if.m43299C(r9.f57162do).mo43463do(r0, com.iproov.sdk.core.C20873if.m43311O(r9.f57162do));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x007f, code lost:
            if (com.iproov.sdk.core.C20873if.m43311O(r9.f57162do) == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0081, code lost:
            if (r3 == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0087, code lost:
            if (r3.m46694for() == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0089, code lost:
            r10 = com.iproov.sdk.core.C20873if.m43311O(r9.f57162do).getPose();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0093, code lost:
            if (r10 == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0095, code lost:
            r10 = com.iproov.sdk.core.C20873if.m43314R(r9.f57162do).mo180464do(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x009f, code lost:
            if (r10 == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            return new p098try.C3690if.C3697if(r10, r3.m46696try());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
            return new p098try.C3690if.C3697if(com.iproov.sdk.core.C20873if.m43354j(r9.f57162do).mo171463a(r10, r0, com.iproov.sdk.core.C20873if.m43311O(r9.f57162do), new android.graphics.Rect(0, 0, r0.getWidth(), r0.getHeight())), (p094super.C3655this) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            return null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
            return r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
            return r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
            return r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
            return r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
            return r3;
         */
        /* renamed from: for  reason: not valid java name */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private p098try.C3690if.C3697if m48130for(p235do.C21824for r10) throws p094super.C3647case {
            /*
                r9 = this;
                int r0 = r9.m43395if()
                android.graphics.Bitmap r0 = r10.mo171340do(r0)
                com.iproov.sdk.core.if r1 = com.iproov.sdk.core.C20873if.this
                com.iproov.sdk.cameray.Orientation r1 = r1.f57124Q
                android.graphics.Bitmap r0 = p095switch.C3673for.m7420do(r0, r1)
                if (r0 == 0) goto L_0x00af
                com.iproov.sdk.core.if r1 = com.iproov.sdk.core.C20873if.this
                java.lang.Object r1 = r1.f57151s
                monitor-enter(r1)
                com.iproov.sdk.core.if r2 = com.iproov.sdk.core.C20873if.this     // Catch:{ all -> 0x00ac }
                com.iproov.sdk.face.FaceDetector r2 = r2.f57157y     // Catch:{ all -> 0x00ac }
                r3 = 0
                if (r2 != 0) goto L_0x0026
                monitor-exit(r1)     // Catch:{ all -> 0x00ac }
                return r3
            L_0x0026:
                com.iproov.sdk.core.if r2 = com.iproov.sdk.core.C20873if.this     // Catch:{ all -> 0x00ac }
                com.iproov.sdk.face.FaceDetector r4 = r2.f57157y     // Catch:{ all -> 0x00ac }
                com.iproov.sdk.face.model.FaceFeature r4 = r4.detectFace(r0)     // Catch:{ all -> 0x00ac }
                com.iproov.sdk.face.model.FaceFeature unused = r2.f57112E = r4     // Catch:{ all -> 0x00ac }
                monitor-exit(r1)     // Catch:{ all -> 0x00ac }
                com.iproov.sdk.core.if r1 = com.iproov.sdk.core.C20873if.this
                com.iproov.sdk.core.const r1 = r1.f57113F
                if (r1 == 0) goto L_0x0061
                try.if$if r1 = new try.if$if
                com.iproov.sdk.core.if r2 = com.iproov.sdk.core.C20873if.this
                com.iproov.sdk.core.const r2 = r2.f57113F
                com.iproov.sdk.core.if r4 = com.iproov.sdk.core.C20873if.this
                com.iproov.sdk.face.model.FaceFeature r4 = r4.f57112E
                android.graphics.Rect r5 = new android.graphics.Rect
                int r6 = r0.getWidth()
                int r7 = r0.getHeight()
                r8 = 0
                r5.<init>(r8, r8, r6, r7)
                try.do r10 = r2.mo171463a((p235do.C21824for) r10, (android.graphics.Bitmap) r0, (com.iproov.sdk.face.model.FaceFeature) r4, (android.graphics.Rect) r5)
                r1.<init>(r10, r3)
                r3 = r1
                goto L_0x00ab
            L_0x0061:
                com.iproov.sdk.core.if r10 = com.iproov.sdk.core.C20873if.this
                super.for r10 = r10.f57109B
                if (r10 == 0) goto L_0x00ab
                com.iproov.sdk.core.if r10 = com.iproov.sdk.core.C20873if.this
                super.for r10 = r10.f57109B
                com.iproov.sdk.core.if r1 = com.iproov.sdk.core.C20873if.this
                com.iproov.sdk.face.model.FaceFeature r1 = r1.f57112E
                try.if$if r3 = r10.mo43463do(r0, r1)
                com.iproov.sdk.core.if r10 = com.iproov.sdk.core.C20873if.this
                com.iproov.sdk.face.model.FaceFeature r10 = r10.f57112E
                if (r10 == 0) goto L_0x00ab
                if (r3 == 0) goto L_0x00ab
                boolean r10 = r3.m46694for()
                if (r10 == 0) goto L_0x00ab
                com.iproov.sdk.core.if r10 = com.iproov.sdk.core.C20873if.this
                com.iproov.sdk.face.model.FaceFeature r10 = r10.f57112E
                com.iproov.sdk.face.model.Pose r10 = r10.getPose()
                if (r10 == 0) goto L_0x00ab
                com.iproov.sdk.core.if r0 = com.iproov.sdk.core.C20873if.this
                else.for r0 = r0.f57141i
                try.do r10 = r0.mo180464do(r10)
                if (r10 == 0) goto L_0x00ab
                try.if$if r0 = new try.if$if
                super.this r1 = r3.m46696try()
                r0.<init>(r10, r1)
                r3 = r0
            L_0x00ab:
                return r3
            L_0x00ac:
                r10 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x00ac }
                throw r10
            L_0x00af:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "Bitmap can not be null"
                r10.<init>(r0)
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.core.C20873if.C20877for.m48130for(do.for):try.if$if");
        }

        /* renamed from: do */
        public void mo171348do(Exception exc) {
            if (exc instanceof IProovException) {
                C20873if.this.f57140h.mo43543do((IProovException) exc);
            } else {
                C20873if.this.f57140h.mo43543do((IProovException) new CameraException(C20873if.this.f57136d, exc));
            }
        }

        /* renamed from: do */
        public void mo171344do(C20776try.C20778if ifVar, Exception exc) {
            IPLog.m43494w(C20873if.f57107c, ifVar.toString());
            if (exc != null) {
                exc.printStackTrace();
            }
        }

        /* renamed from: if */
        private int m43395if() {
            return (C20873if.this.f57123P == null || C20873if.this.f57123P.mo181316do() != C21998do.LIVENESS) ? 4 : 3;
        }

        /* renamed from: do */
        public void mo171349do(boolean z) {
            if (C20873if.this.f57109B != null) {
                C20873if.this.f57109B.mo43466do(z);
            }
        }

        /* renamed from: do */
        public void mo171347do(C21828this thisR) {
            if (C20873if.this.f57109B != null) {
                C20873if.this.f57109B.mo43465do(thisR);
            }
        }

        /* renamed from: do */
        public void mo171345do(C21824for forR) {
            if (forR == null) {
                C20873if.this.f57140h.mo43543do((IProovException) new CameraException(C20873if.this.f57136d, "Frame not available, perhaps corrupt"));
            } else if (C20873if.this.f57110C != null) {
                if (C20873if.this.f57148p.mo178978if()) {
                    C20873if.this.f57148p.m48209try();
                } else {
                    C20873if.this.f57148p.m48207for();
                }
                long unused = C20873if.this.f57127T = System.nanoTime();
                if (C20873if.this.f57140h.mo43544do() && C20873if.this.f57123P != null) {
                    C20873if.this.f57146n.execute(new Runnable(forR) {
                        public final /* synthetic */ C21824for f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            C20873if.C20877for.this.m43396if(this.f$1);
                        }
                    });
                }
                if (C20873if.this.f57156x.get() > 0) {
                    C20873if.this.f57156x.decrementAndGet();
                    String unused2 = C20873if.f57107c;
                    C20873if.this.m43334a(forR, false);
                } else {
                    synchronized (C20873if.this.f57153u) {
                        if (C20873if.this.f57153u.mo171369b()) {
                            C3679throw.m7442do((Runnable) new Runnable() {
                                public final void run() {
                                    C20873if.C20877for.this.m48135new();
                                }
                            });
                            String unused3 = C20873if.f57107c;
                            C20873if.this.m43334a(forR, true);
                        }
                    }
                }
                if (C20873if.this.f57144l.m46613const()) {
                    synchronized (C20873if.this.f57151s) {
                        C3679throw.m7442do((Runnable) new Runnable(C20884new.m43430a(C20873if.this.f57109B, C20873if.this.f57123P, C20873if.this.f57112E, C20873if.this.f57120M, C20873if.this.f57143k, C20873if.this.f57122O, C20873if.this.f57157y, C20873if.this.f57108A, C20873if.this.f57120M.getFrameRate(), C20873if.this.f57148p, C20873if.this.f57149q)) {
                            public final /* synthetic */ String f$1;

                            {
                                this.f$1 = r2;
                            }

                            public final void run() {
                                C20873if.C20877for.this.m43394do(this.f$1);
                            }
                        });
                    }
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: do */
        public /* synthetic */ void m43394do(String str) {
            if (C20873if.this.f57110C != null) {
                C20873if.this.f57110C.mo43316do(str);
            }
        }

        /* renamed from: do */
        public void mo171343do() {
            C20873if.this.f57148p.m48208new();
            C20873if.this.f57149q.m48208new();
        }
    }

    /* renamed from: com.iproov.sdk.core.if$case */
    /* compiled from: CaptureManager */
    class C20874case implements C20864const.C20865do {
        C20874case() {
        }

        /* access modifiers changed from: private */
        /* renamed from: if */
        public /* synthetic */ void m43380if(Rect rect, Rect rect2, Rect rect3, Rect rect4) {
            if (C20873if.this.f57110C != null) {
                LivenessDebugOverlay livenessDebugOverlay = C20873if.this.f57110C.mo43319if();
                if (C20873if.this.f57128U) {
                    livenessDebugOverlay.setVisibility(0);
                    livenessDebugOverlay.mo171596if(rect);
                    livenessDebugOverlay.m48152for(rect2);
                    livenessDebugOverlay.mo171593do(rect3);
                    livenessDebugOverlay.m48153new(rect4);
                    livenessDebugOverlay.mo171595if();
                    return;
                }
                livenessDebugOverlay.setVisibility(8);
            }
        }

        /* renamed from: do */
        public void mo171469do(C21824for forR, boolean z, RectF rectF) {
            String unused = C20873if.f57107c;
            synchronized (C20873if.this.f57153u) {
                C20873if.this.f57153u.mo171367a();
                String unused2 = C20873if.f57107c;
                C20873if.this.m43334a(forR, false);
            }
            C20873if.this.f57143k.mo171300do(rectF);
            C3679throw.m7442do((Runnable) new Runnable(z) {
                public final /* synthetic */ boolean f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    C20873if.C20874case.this.m43379do(this.f$1);
                }
            });
        }

        /* access modifiers changed from: private */
        /* renamed from: do */
        public /* synthetic */ void m43379do(boolean z) {
            if (!(C20873if.this.f57110C == null || C20873if.this.f57113F == null)) {
                C20873if.this.f57110C.mo43317do(z);
            }
            if (z) {
                C20873if.this.f57116I.m46644case();
            }
        }

        /* renamed from: do */
        public void mo171468do(Rect rect, RectF rectF) {
            RectF unused = C20873if.this.f57117J = rectF;
            String unused2 = C20873if.f57107c;
            StringBuilder sb = new StringBuilder();
            sb.append("CROPRECTpost=");
            sb.append(rect);
            C3679throw.m7442do((Runnable) new Runnable(rect) {
                public final /* synthetic */ Rect f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    C20873if.C20874case.this.m43378do(this.f$1);
                }
            });
        }

        /* access modifiers changed from: private */
        /* renamed from: do */
        public /* synthetic */ void m43378do(Rect rect) {
            C20873if.this.f57120M.mo171554do(rect);
            if (C20873if.this.f57110C != null) {
                if (C20873if.this.f57113F != null) {
                    C20873if.this.f57110C.mo43317do(false);
                }
                if (C20873if.this.f57144l.m46613const()) {
                    C20873if.this.f57110C.m46647for();
                }
            }
            C20873if.this.f57116I.m46646try();
        }

        /* renamed from: do */
        public void mo171467do(Rect rect, Rect rect2, Rect rect3, Rect rect4) {
            C3679throw.m7442do((Runnable) new Runnable(rect, rect2, rect3, rect4) {
                public final /* synthetic */ Rect f$1;
                public final /* synthetic */ Rect f$2;
                public final /* synthetic */ Rect f$3;
                public final /* synthetic */ Rect f$4;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                    this.f$4 = r5;
                }

                public final void run() {
                    C20873if.C20874case.this.m43380if(this.f$1, this.f$2, this.f$3, this.f$4);
                }
            });
        }

        /* renamed from: do */
        public void mo171470do(Exception exc) {
            C20873if.this.f57140h.mo43543do((IProovException) new UnexpectedErrorException(C20873if.this.f57136d, exc));
        }
    }

    /* renamed from: com.iproov.sdk.core.if$new */
    /* compiled from: CaptureManager */
    class C20880new implements C21840for.C21841do {
        C20880new() {
        }

        /* renamed from: do */
        public void mo171514do(int i, C21839do doVar, int i2) {
            String unused = C20873if.f57107c;
            StringBuilder sb = new StringBuilder();
            sb.append("Flashing ");
            sb.append(doVar);
            sb.append(" (#");
            int i3 = i + 1;
            sb.append(i3);
            sb.append(")");
            int color = C20873if.this.f57136d.getResources().getColor(doVar.mo180485do());
            float f = ((float) i) / ((float) C20873if.this.f57111D.m48248new());
            float f2 = ((float) i3) / ((float) C20873if.this.f57111D.m48248new());
            C20873if.this.f57120M.mo171553do(color, f2, (long) i2);
            C20873if.this.f57111D.mo180487do(C20873if.this.f57148p.mo178976do(), C20873if.this.f57120M.getFrameRate());
            if (((double) i) >= ((double) C20873if.this.f57111D.m48248new()) * 0.8d) {
                C20873if.this.f57120M.m48146this();
            }
            C20873if.this.f57140h.mo43540do(doVar, i2, f, f2);
        }

        /* renamed from: if */
        public void mo171515if() {
            String unused = C20873if.f57107c;
            C20873if.this.m43351h();
        }

        /* renamed from: do */
        public void mo171513do() {
            String unused = C20873if.f57107c;
        }
    }

    /* renamed from: do */
    public void mo171499do(C3566do doVar) {
        if (this.f57110C != doVar) {
            this.f57110C = doVar;
            if (doVar != null) {
                m43340c();
            } else {
                m43342d();
            }
        }
    }

    /* renamed from: do */
    public void mo171498do(OpenGLRenderer openGLRenderer) {
        this.f57120M = openGLRenderer;
        openGLRenderer.setPermissionsDelegate(new OpenGLRenderer.C20903do() {
            /* renamed from: do */
            public final void mo171364do() {
                C20873if.this.m43338b();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m43335a(String str) {
        this.f57142j.mo181327do(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m43336a(String str, C3655this thisR) {
        if (this.f57109B != null && thisR != null) {
            Map<String, Object> map = thisR.mo43475do();
            map.put("time", Long.valueOf(System.currentTimeMillis()));
            map.put("state", str);
            map.put("autoStartEnabled", Double.valueOf(this.f57138f.f57177do.f56836ui.genuinePresenceAssurance.autoStartDisabled ? 0.0d : 1.0d));
            C3686do doVar = this.f57158z;
            if (doVar != null) {
                map.put("sLux", Float.valueOf(doVar.mo43531if()));
            }
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry next : map.entrySet()) {
                try {
                    jSONObject.put((String) next.getKey(), next.getValue());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            this.f57142j.mo181332if(jSONObject);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public Bitmap m43358l() {
        Bitmap bitmap = this.f57115H;
        if (bitmap == null) {
            return null;
        }
        return C3673for.m7420do(bitmap, this.f57124Q);
    }

    /* renamed from: com.iproov.sdk.core.if$goto */
    /* compiled from: CaptureManager */
    public class C20878goto implements C1269do.C1271if {
        public C20878goto() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x005c A[Catch:{ IProovException -> 0x0096 }] */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0068 A[Catch:{ IProovException -> 0x0096 }] */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0089 A[Catch:{ IProovException -> 0x0096 }] */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x008d A[Catch:{ IProovException -> 0x0096 }] */
        /* renamed from: do */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void m43404do(byte[] r11, boolean r12) {
            /*
                r10 = this;
                java.lang.String unused = com.iproov.sdk.core.C20873if.f57107c
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "onFrameEncoded -> streamer 🛒 frame size="
                r0.append(r1)
                int r1 = r11.length
                r0.append(r1)
                com.iproov.sdk.core.if r0 = com.iproov.sdk.core.C20873if.this
                java.util.Queue r0 = r0.f57155w
                java.lang.Object r0 = r0.poll()
                r3 = r0
                java.lang.Long r3 = (java.lang.Long) r3
                com.iproov.sdk.core.if r0 = com.iproov.sdk.core.C20873if.this
                com.iproov.sdk.crypto.do r0 = r0.f57152t
                com.iproov.sdk.crypto.do r1 = com.iproov.sdk.crypto.C20897do.UNSUPPORTED
                r2 = 0
                if (r0 == r1) goto L_0x0048
                com.iproov.sdk.core.if r0 = com.iproov.sdk.core.C20873if.this     // Catch:{ for -> 0x0039 }
                com.iproov.sdk.crypto.if r0 = r0.f57119L     // Catch:{ for -> 0x0039 }
                byte[] r0 = r0.mo171529do((byte[]) r11)     // Catch:{ for -> 0x0039 }
                java.lang.String r0 = p095switch.C3679throw.m7440do((byte[]) r0)     // Catch:{ for -> 0x0039 }
                r6 = r0
                goto L_0x0049
            L_0x0039:
                r0 = move-exception
                r0.printStackTrace()
                java.lang.String r1 = com.iproov.sdk.core.C20873if.f57107c
                java.lang.String r0 = r0.getLocalizedMessage()
                com.iproov.sdk.logging.IPLog.m43494w(r1, r0)
            L_0x0048:
                r6 = r2
            L_0x0049:
                com.iproov.sdk.core.import r0 = com.iproov.sdk.core.C20882import.AND5     // Catch:{ IProovException -> 0x0096 }
                com.iproov.sdk.core.C20893while.m43453do(r0)     // Catch:{ IProovException -> 0x0096 }
                com.iproov.sdk.core.if r0 = com.iproov.sdk.core.C20873if.this     // Catch:{ IProovException -> 0x0096 }
                import.if r1 = r0.f57142j     // Catch:{ IProovException -> 0x0096 }
                com.iproov.sdk.core.if r0 = com.iproov.sdk.core.C20873if.this     // Catch:{ IProovException -> 0x0096 }
                com.iproov.sdk.core.const r0 = r0.f57113F     // Catch:{ IProovException -> 0x0096 }
                if (r0 == 0) goto L_0x0068
                com.iproov.sdk.core.if r0 = com.iproov.sdk.core.C20873if.this     // Catch:{ IProovException -> 0x0096 }
                com.iproov.sdk.core.const r0 = r0.f57113F     // Catch:{ IProovException -> 0x0096 }
                java.util.List r0 = r0.mo171462a()     // Catch:{ IProovException -> 0x0096 }
                r4 = r0
                goto L_0x0069
            L_0x0068:
                r4 = r2
            L_0x0069:
                com.iproov.sdk.core.if r0 = com.iproov.sdk.core.C20873if.this     // Catch:{ IProovException -> 0x0096 }
                android.graphics.RectF r5 = r0.f57117J     // Catch:{ IProovException -> 0x0096 }
                com.iproov.sdk.core.if r0 = com.iproov.sdk.core.C20873if.this     // Catch:{ IProovException -> 0x0096 }
                if.if r0 = r0.f57123P     // Catch:{ IProovException -> 0x0096 }
                case.case r0 = r0.m48273for()     // Catch:{ IProovException -> 0x0096 }
                case.else r7 = r0.mo14136do()     // Catch:{ IProovException -> 0x0096 }
                com.iproov.sdk.core.if r0 = com.iproov.sdk.core.C20873if.this     // Catch:{ IProovException -> 0x0096 }
                com.iproov.sdk.core.c r0 = r0.f57153u     // Catch:{ IProovException -> 0x0096 }
                boolean r0 = r0.mo171370c()     // Catch:{ IProovException -> 0x0096 }
                if (r0 == 0) goto L_0x008d
                com.iproov.sdk.core.case r0 = com.iproov.sdk.core.C20785case.SUPPLEMENTARY     // Catch:{ IProovException -> 0x0096 }
            L_0x008b:
                r8 = r0
                goto L_0x0090
            L_0x008d:
                com.iproov.sdk.core.case r0 = com.iproov.sdk.core.C20785case.AUTHENTICATION     // Catch:{ IProovException -> 0x0096 }
                goto L_0x008b
            L_0x0090:
                r2 = r11
                r9 = r12
                r1.mo181329do(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ IProovException -> 0x0096 }
                goto L_0x00a0
            L_0x0096:
                r11 = move-exception
                com.iproov.sdk.core.if r12 = com.iproov.sdk.core.C20873if.this
                try.for r12 = r12.f57140h
                r12.mo43543do((com.iproov.sdk.core.exception.IProovException) r11)
            L_0x00a0:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.core.C20873if.C20878goto.m43404do(byte[], boolean):void");
        }

        /* renamed from: do */
        public void mo14144do(C1277try tryR) {
            if (C20873if.this.f57140h.mo43546if().mo43553if()) {
                String unused = C20873if.f57107c;
                return;
            }
            C20873if.this.f57154v.offer(tryR);
            if (tryR.mo14148do()) {
                String unused2 = C20873if.f57107c;
                StringBuilder sb = new StringBuilder();
                sb.append("onFrameEncoded held header size=");
                sb.append(tryR.f473do.length);
            } else if (!C20873if.this.f57140h.mo43546if().mo43550do()) {
                String unused3 = C20873if.f57107c;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onFrameEncoded 🕰 too early header=");
                sb2.append(tryR.mo14148do());
                sb2.append(" size=");
                sb2.append(tryR.f473do.length);
            } else {
                while (C20873if.this.f57154v.size() > 1) {
                    C1277try tryR2 = (C1277try) C20873if.this.f57154v.poll();
                    byte[] bArr = tryR2.f473do;
                    if (tryR2.mo14148do()) {
                        C1277try tryR3 = (C1277try) C20873if.this.f57154v.poll();
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            byteArrayOutputStream.write(bArr);
                            byteArrayOutputStream.write(tryR3.f473do);
                            bArr = byteArrayOutputStream.toByteArray();
                        } catch (IOException e) {
                            IPLog.m43494w(C20873if.f57107c, e.getLocalizedMessage());
                        }
                    }
                    m43404do(bArr, false);
                }
            }
        }

        /* renamed from: do */
        public void mo14143do() {
            String unused = C20873if.f57107c;
            while (!C20873if.this.f57154v.isEmpty()) {
                m43404do(((C1277try) C20873if.this.f57154v.poll()).f473do, C20873if.this.f57154v.isEmpty());
            }
        }

        /* renamed from: do */
        public void mo14145do(Exception exc) {
            C20873if.this.f57140h.mo43543do((IProovException) new UnexpectedErrorException(C20873if.this.f57136d, exc.getLocalizedMessage()));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m43329a(double d) {
        if (this.f57126S == -1) {
            this.f57126S = System.currentTimeMillis();
        }
        this.f57140h.mo43538do(d, C22006new.m45187do(this.f57136d, this.f57123P.m48269catch(), d, System.currentTimeMillis() - this.f57126S > 3000, this.f57123P.mo181316do()));
    }

    /* renamed from: a */
    private static Class<? extends C20907do> m43325a(Orientation orientation) {
        int i = C20876else.f57161do[orientation.ordinal()];
        if (i == 2) {
            return IProovLandscapeActivity.class;
        }
        if (i == 3) {
            return IProovReversePortraitActivity.class;
        }
        if (i != 4) {
            return IProovPortraitActivity.class;
        }
        return IProovReverseLandscapeActivity.class;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m43334a(C21824for forR, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("📀 encodeFrame() ");
        sb.append(z ? C20785case.SUPPLEMENTARY : C20785case.AUTHENTICATION);
        if (this.f57108A != null && this.f57114G != null) {
            this.f57147o.execute(new Runnable(forR, z) {
                public final /* synthetic */ C21824for f$1;
                public final /* synthetic */ boolean f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    C20873if.this.m43339b(this.f$1, this.f$2);
                }
            });
        }
    }
}
