package com.didi.safety.god.p145ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.SparseArray;
import com.didi.safety.god.http.SafetyHttp;
import com.didi.safety.god.http.SafetyTraceEventHandler;
import com.didi.safety.god.manager.GodManager;
import com.didi.safety.god.util.LabelUtils;
import com.didi.safety.god.util.LogUtils;
import com.didi.sec.algo.RawDetectInfo;
import com.didichuxing.dfbasesdk.AppContextHolder;
import java.util.HashMap;
import java.util.Locale;

/* renamed from: com.didi.safety.god.ui.DetectCoreThread */
class DetectCoreThread {

    /* renamed from: e */
    static final /* synthetic */ boolean f37460e = (!DetectCoreThread.class.desiredAssertionStatus());

    /* renamed from: f */
    private static DetectCoreThread f37461f = null;

    /* renamed from: t */
    private static final float f37462t = 0.9f;

    /* renamed from: u */
    private static final float f37463u = 0.99f;

    /* renamed from: v */
    private static final float f37464v = 0.9f;

    /* renamed from: A */
    private boolean f37465A;

    /* renamed from: B */
    private long f37466B;

    /* renamed from: C */
    private int f37467C;

    /* renamed from: D */
    private int f37468D;

    /* renamed from: E */
    private int f37469E;

    /* renamed from: F */
    private int f37470F;

    /* renamed from: G */
    private int f37471G;

    /* renamed from: a */
    boolean f37472a;

    /* renamed from: b */
    boolean f37473b;

    /* renamed from: c */
    boolean f37474c;

    /* renamed from: d */
    PosSizeInfo f37475d;

    /* renamed from: g */
    private boolean f37476g;

    /* renamed from: h */
    private Handler f37477h;

    /* renamed from: i */
    private HandlerThread f37478i;

    /* renamed from: j */
    private int f37479j;

    /* renamed from: k */
    private long f37480k;

    /* renamed from: l */
    private final Object f37481l = new Object();

    /* renamed from: m */
    private boolean f37482m = GodManager.getInstance().getConfig().failCaseSwitch;

    /* renamed from: n */
    private boolean f37483n = GodManager.getInstance().getConfig().successCaseSwitch;

    /* renamed from: o */
    private SparseArray<CollectInfo> f37484o = new SparseArray<>();

    /* renamed from: p */
    private SparseArray<CollectInfo> f37485p = new SparseArray<>();

    /* renamed from: q */
    private int f37486q;

    /* renamed from: r */
    private int f37487r;

    /* renamed from: s */
    private final float f37488s = GodManager.getInstance().getConfig().clearPicProportion;

    /* renamed from: w */
    private RawDetectInfo f37489w;

    /* renamed from: x */
    private RawDetectInfo f37490x;

    /* renamed from: y */
    private RawDetectInfo[] f37491y;

    /* renamed from: z */
    private float f37492z = -1.0f;

    /* renamed from: a */
    static DetectCoreThread m28224a() {
        if (f37461f == null) {
            f37461f = new DetectCoreThread();
        }
        return f37461f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo96317b() {
        mo96318c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo96318c() {
        Handler handler = this.f37477h;
        if (handler != null) {
            handler.removeMessages(0);
        }
    }

    /* renamed from: com.didi.safety.god.ui.DetectCoreThread$CollectInfo */
    static class CollectInfo {
        float bscore;
        byte[] imgBytes;
        int label;
        int labelD;
        float qscore;
        float rscore;
        float score;
        int type;

        CollectInfo(int i) {
            this.type = 2;
            this.label = i;
        }

        CollectInfo(int i, RawDetectInfo rawDetectInfo) {
            this(i, 1, rawDetectInfo);
        }

        CollectInfo(int i, int i2, RawDetectInfo rawDetectInfo) {
            this.label = i;
            this.type = i2;
            this.labelD = rawDetectInfo.label;
            this.score = rawDetectInfo.score;
            this.qscore = rawDetectInfo.qScore;
            this.bscore = rawDetectInfo.bScore;
            this.rscore = rawDetectInfo.rScore;
            this.imgBytes = rawDetectInfo.data;
        }

        /* access modifiers changed from: package-private */
        public void update(RawDetectInfo rawDetectInfo) {
            this.type = 2;
            this.labelD = rawDetectInfo.label;
            this.score = rawDetectInfo.score;
            this.qscore = rawDetectInfo.qScore;
            this.bscore = rawDetectInfo.bScore;
            this.rscore = rawDetectInfo.rScore;
            this.imgBytes = rawDetectInfo.data;
        }

        /* access modifiers changed from: package-private */
        public void updateByDetectNothing(byte[] bArr) {
            if (this.imgBytes == null) {
                LogUtils.m28307d("collect detect nothing case...");
                this.imgBytes = bArr;
                this.labelD = 0;
                this.score = 0.0f;
                this.qscore = 0.0f;
                this.bscore = 0.0f;
                this.rscore = 0.0f;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean needUpload() {
            return this.imgBytes != null;
        }
    }

    private DetectCoreThread() {
        LogUtils.m28307d("DetectCoreThread.ctor, collFailCases===" + this.f37482m + ", collOkCases=" + this.f37483n);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo96315a(long j) {
        LogUtils.m28307d("markBeginCostTime===");
        this.f37480k = j;
        m28230k();
    }

    /* renamed from: k */
    private void m28230k() {
        this.f37489w = null;
        this.f37490x = null;
        this.f37491y = new RawDetectInfo[2];
        this.f37475d = new PosSizeInfo();
        this.f37472a = false;
        this.f37473b = false;
        this.f37474c = false;
        this.f37492z = -1.0f;
        this.f37467C = 0;
        this.f37468D = 0;
        this.f37469E = 0;
        this.f37470F = 0;
        this.f37471G = 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo96314a(int i, byte[] bArr, int i2, int i3) {
        LogUtils.m28307d("sendToDetect, label===" + i);
        if (!this.f37476g) {
            m28231l();
        }
        this.f37476g = true;
        this.f37479j = i;
        if (this.f37482m && this.f37484o.get(i) == null) {
            LogUtils.m28307d("sendToDetect, put fail coll info, label===" + i);
            this.f37484o.put(i, new CollectInfo(i));
        }
        this.f37486q = i2;
        this.f37487r = i3;
        Message obtainMessage = this.f37477h.obtainMessage();
        Bundle bundle = new Bundle();
        bundle.putByteArray("data", bArr);
        bundle.putInt("width", i2);
        bundle.putInt("height", i3);
        obtainMessage.setData(bundle);
        this.f37477h.sendMessage(obtainMessage);
    }

    /* renamed from: l */
    private void m28231l() {
        HandlerThread handlerThread = new HandlerThread("god_detect");
        this.f37478i = handlerThread;
        handlerThread.start();
        this.f37477h = new Handler(this.f37478i.getLooper()) {
            public void handleMessage(Message message) {
                DetectCoreThread.this.m28225a(message);
            }
        };
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0214, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c1, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m28225a(android.os.Message r9) {
        /*
            r8 = this;
            android.os.Bundle r9 = r9.getData()
            java.lang.String r0 = "data"
            byte[] r0 = r9.getByteArray(r0)
            java.lang.String r1 = "height"
            int r1 = r9.getInt(r1)
            java.lang.String r2 = "width"
            int r9 = r9.getInt(r2)
            com.didi.safety.god.manager.GodManager r2 = com.didi.safety.god.manager.GodManager.getInstance()
            com.didi.sec.algo.RawDetectInfo r9 = r2.yuvdetect(r0, r9, r1)
            java.lang.Object r1 = r8.f37481l
            monitor-enter(r1)
            r2 = 1
            r8.f37472a = r2     // Catch:{ all -> 0x0215 }
            com.didi.sec.algo.RawDetectInfo r3 = r8.f37489w     // Catch:{ all -> 0x0215 }
            if (r3 == 0) goto L_0x0076
            int r3 = r8.f37467C     // Catch:{ all -> 0x0215 }
            int r3 = r3 + r2
            r8.f37467C = r3     // Catch:{ all -> 0x0215 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0215 }
            r3.<init>()     // Catch:{ all -> 0x0215 }
            java.lang.String r4 = "during video, allCount==="
            r3.append(r4)     // Catch:{ all -> 0x0215 }
            int r4 = r8.f37467C     // Catch:{ all -> 0x0215 }
            r3.append(r4)     // Catch:{ all -> 0x0215 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0215 }
            com.didi.safety.god.util.LogUtils.m28307d(r3)     // Catch:{ all -> 0x0215 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0215 }
            r3.<init>()     // Catch:{ all -> 0x0215 }
            java.lang.String r4 = "handle is "
            r3.append(r4)     // Catch:{ all -> 0x0215 }
            r3.append(r9)     // Catch:{ all -> 0x0215 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0215 }
            com.didi.safety.god.util.LogUtils.m28307d(r3)     // Catch:{ all -> 0x0215 }
            if (r9 == 0) goto L_0x0071
            int r3 = r9.disState     // Catch:{ all -> 0x0215 }
            if (r3 != 0) goto L_0x0071
            boolean r3 = r9.notCentered     // Catch:{ all -> 0x0215 }
            if (r3 != 0) goto L_0x0071
            float r3 = r9.score     // Catch:{ all -> 0x0215 }
            com.didi.safety.god.manager.GodManager r4 = com.didi.safety.god.manager.GodManager.getInstance()     // Catch:{ all -> 0x0215 }
            com.didi.safety.god.manager.GodManager$Config r4 = r4.getConfig()     // Catch:{ all -> 0x0215 }
            float r4 = r4.dectConf     // Catch:{ all -> 0x0215 }
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 >= 0) goto L_0x0076
        L_0x0071:
            int r3 = r8.f37471G     // Catch:{ all -> 0x0215 }
            int r3 = r3 + r2
            r8.f37471G = r3     // Catch:{ all -> 0x0215 }
        L_0x0076:
            if (r9 == 0) goto L_0x020a
            float r3 = r9.score     // Catch:{ all -> 0x0215 }
            com.didi.safety.god.manager.GodManager r4 = com.didi.safety.god.manager.GodManager.getInstance()     // Catch:{ all -> 0x0215 }
            com.didi.safety.god.manager.GodManager$Config r4 = r4.getConfig()     // Catch:{ all -> 0x0215 }
            float r4 = r4.dectConf     // Catch:{ all -> 0x0215 }
            r5 = 0
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 >= 0) goto L_0x008b
            r3 = 1
            goto L_0x008c
        L_0x008b:
            r3 = 0
        L_0x008c:
            r8.f37473b = r3     // Catch:{ all -> 0x0215 }
            r4 = 1065185444(0x3f7d70a4, float:0.99)
            if (r3 == 0) goto L_0x00b1
            int r3 = r9.label     // Catch:{ all -> 0x0215 }
            boolean r3 = com.didi.safety.god.util.LabelUtils.isQualitySupportedLabel(r3)     // Catch:{ all -> 0x0215 }
            if (r3 == 0) goto L_0x00b1
            float r3 = r9.score     // Catch:{ all -> 0x0215 }
            r6 = 1045220557(0x3e4ccccd, float:0.2)
            int r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r3 <= 0) goto L_0x00b1
            float r3 = r9.qScore     // Catch:{ all -> 0x0215 }
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 <= 0) goto L_0x00b1
            java.lang.String r3 = "label 1/3/6 with very higher qScore, so let it continue..."
            com.didi.safety.god.util.LogUtils.m28307d(r3)     // Catch:{ all -> 0x0215 }
            r8.f37473b = r5     // Catch:{ all -> 0x0215 }
        L_0x00b1:
            boolean r3 = r8.f37473b     // Catch:{ all -> 0x0215 }
            if (r3 == 0) goto L_0x00c2
            r8.m28229a((byte[]) r0)     // Catch:{ all -> 0x0215 }
            int r0 = r8.f37467C     // Catch:{ all -> 0x0215 }
            if (r0 <= 0) goto L_0x00c0
            com.didi.sec.algo.RawDetectInfo[] r0 = r8.f37491y     // Catch:{ all -> 0x0215 }
            r0[r5] = r9     // Catch:{ all -> 0x0215 }
        L_0x00c0:
            monitor-exit(r1)     // Catch:{ all -> 0x0215 }
            return
        L_0x00c2:
            com.didi.sec.algo.RawDetectInfo r0 = r8.f37489w     // Catch:{ all -> 0x0215 }
            if (r0 != 0) goto L_0x0106
            int r0 = r8.f37479j     // Catch:{ all -> 0x0215 }
            int r3 = r9.label     // Catch:{ all -> 0x0215 }
            if (r0 == r3) goto L_0x00cd
            goto L_0x00ce
        L_0x00cd:
            r2 = 0
        L_0x00ce:
            r8.f37474c = r2     // Catch:{ all -> 0x0215 }
            if (r2 == 0) goto L_0x00d7
            r8.m28228a((com.didi.sec.algo.RawDetectInfo) r9)     // Catch:{ all -> 0x0215 }
            monitor-exit(r1)     // Catch:{ all -> 0x0215 }
            return
        L_0x00d7:
            com.didi.safety.god.ui.PosSizeInfo r0 = r8.f37475d     // Catch:{ all -> 0x0215 }
            int r2 = r9.disState     // Catch:{ all -> 0x0215 }
            r0.disState = r2     // Catch:{ all -> 0x0215 }
            com.didi.safety.god.ui.PosSizeInfo r0 = r8.f37475d     // Catch:{ all -> 0x0215 }
            int r0 = r0.disState     // Catch:{ all -> 0x0215 }
            if (r0 <= 0) goto L_0x00ea
            java.lang.String r9 = "first detect size not ok!!!"
            com.didi.safety.god.util.LogUtils.m28307d(r9)     // Catch:{ all -> 0x0215 }
            monitor-exit(r1)     // Catch:{ all -> 0x0215 }
            return
        L_0x00ea:
            com.didi.safety.god.ui.PosSizeInfo r0 = r8.f37475d     // Catch:{ all -> 0x0215 }
            boolean r2 = r9.notCentered     // Catch:{ all -> 0x0215 }
            r0.notCentered = r2     // Catch:{ all -> 0x0215 }
            com.didi.safety.god.ui.PosSizeInfo r0 = r8.f37475d     // Catch:{ all -> 0x0215 }
            boolean r0 = r0.notCentered     // Catch:{ all -> 0x0215 }
            if (r0 == 0) goto L_0x00fd
            java.lang.String r9 = "first detect pos not ok!!!"
            com.didi.safety.god.util.LogUtils.m28307d(r9)     // Catch:{ all -> 0x0215 }
            monitor-exit(r1)     // Catch:{ all -> 0x0215 }
            return
        L_0x00fd:
            java.lang.String r0 = "step1, set firstDetectInfo..."
            com.didi.safety.god.util.LogUtils.m28307d(r0)     // Catch:{ all -> 0x0215 }
            r8.f37489w = r9     // Catch:{ all -> 0x0215 }
            goto L_0x0213
        L_0x0106:
            java.lang.String r0 = "step2, select best pic info during video..."
            com.didi.safety.god.util.LogUtils.m28307d(r0)     // Catch:{ all -> 0x0215 }
            int r0 = r9.label     // Catch:{ all -> 0x0215 }
            int r3 = r8.f37479j     // Catch:{ all -> 0x0215 }
            if (r3 == r0) goto L_0x0118
            java.lang.String r9 = "ignore wrong label during video select..."
            com.didi.safety.god.util.LogUtils.m28307d(r9)     // Catch:{ all -> 0x0215 }
            monitor-exit(r1)     // Catch:{ all -> 0x0215 }
            return
        L_0x0118:
            boolean r3 = com.didi.safety.god.util.LabelUtils.isQualitySupportedLabel(r0)     // Catch:{ all -> 0x0215 }
            if (r3 == 0) goto L_0x01fb
            r3 = 8
            if (r0 != r3) goto L_0x0124
            r0 = 1
            goto L_0x0125
        L_0x0124:
            r0 = 0
        L_0x0125:
            r3 = 1063675494(0x3f666666, float:0.9)
            if (r0 == 0) goto L_0x012b
            goto L_0x012e
        L_0x012b:
            r4 = 1063675494(0x3f666666, float:0.9)
        L_0x012e:
            float r6 = r9.qScore     // Catch:{ all -> 0x0215 }
            if (r0 == 0) goto L_0x0169
            float r0 = r9.bScore     // Catch:{ all -> 0x0215 }
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 > 0) goto L_0x014f
            float r0 = r9.rScore     // Catch:{ all -> 0x0215 }
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 > 0) goto L_0x014f
            int r0 = r8.f37468D     // Catch:{ all -> 0x0215 }
            int r0 = r0 + r2
            r8.f37468D = r0     // Catch:{ all -> 0x0215 }
            float r0 = r8.f37492z     // Catch:{ all -> 0x0215 }
            int r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x01c6
            r8.f37490x = r9     // Catch:{ all -> 0x0215 }
            r8.f37492z = r6     // Catch:{ all -> 0x0215 }
            goto L_0x01c6
        L_0x014f:
            float r0 = r9.bScore     // Catch:{ all -> 0x0215 }
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x015f
            int r0 = r8.f37469E     // Catch:{ all -> 0x0215 }
            int r0 = r0 + r2
            r8.f37469E = r0     // Catch:{ all -> 0x0215 }
            com.didi.sec.algo.RawDetectInfo[] r0 = r8.f37491y     // Catch:{ all -> 0x0215 }
            r0[r5] = r9     // Catch:{ all -> 0x0215 }
            goto L_0x01c6
        L_0x015f:
            int r0 = r8.f37470F     // Catch:{ all -> 0x0215 }
            int r0 = r0 + r2
            r8.f37470F = r0     // Catch:{ all -> 0x0215 }
            com.didi.sec.algo.RawDetectInfo[] r0 = r8.f37491y     // Catch:{ all -> 0x0215 }
            r0[r2] = r9     // Catch:{ all -> 0x0215 }
            goto L_0x01c6
        L_0x0169:
            r0 = 1028443341(0x3d4ccccd, float:0.05)
            float r7 = r9.bScore     // Catch:{ all -> 0x0215 }
            int r7 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r7 > 0) goto L_0x0190
            float r7 = r9.rScore     // Catch:{ all -> 0x0215 }
            int r7 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r7 > 0) goto L_0x0190
            int r7 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r7 < 0) goto L_0x0190
            int r0 = r8.f37468D     // Catch:{ all -> 0x0215 }
            int r0 = r0 + r2
            r8.f37468D = r0     // Catch:{ all -> 0x0215 }
            float r0 = r9.score     // Catch:{ all -> 0x0215 }
            float r2 = r8.f37492z     // Catch:{ all -> 0x0215 }
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x01c6
            r8.f37490x = r9     // Catch:{ all -> 0x0215 }
            float r9 = r9.score     // Catch:{ all -> 0x0215 }
            r8.f37492z = r9     // Catch:{ all -> 0x0215 }
            goto L_0x01c6
        L_0x0190:
            float r7 = r9.bScore     // Catch:{ all -> 0x0215 }
            int r4 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r4 > 0) goto L_0x01bd
            int r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x01a3
            float r4 = r9.bScore     // Catch:{ all -> 0x0215 }
            float r6 = r9.rScore     // Catch:{ all -> 0x0215 }
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 <= 0) goto L_0x01a3
            goto L_0x01bd
        L_0x01a3:
            float r4 = r9.rScore     // Catch:{ all -> 0x0215 }
            int r3 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r3 > 0) goto L_0x01b3
            if (r0 >= 0) goto L_0x01c6
            float r0 = r9.rScore     // Catch:{ all -> 0x0215 }
            float r3 = r9.bScore     // Catch:{ all -> 0x0215 }
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x01c6
        L_0x01b3:
            int r0 = r8.f37470F     // Catch:{ all -> 0x0215 }
            int r0 = r0 + r2
            r8.f37470F = r0     // Catch:{ all -> 0x0215 }
            com.didi.sec.algo.RawDetectInfo[] r0 = r8.f37491y     // Catch:{ all -> 0x0215 }
            r0[r2] = r9     // Catch:{ all -> 0x0215 }
            goto L_0x01c6
        L_0x01bd:
            int r0 = r8.f37469E     // Catch:{ all -> 0x0215 }
            int r0 = r0 + r2
            r8.f37469E = r0     // Catch:{ all -> 0x0215 }
            com.didi.sec.algo.RawDetectInfo[] r0 = r8.f37491y     // Catch:{ all -> 0x0215 }
            r0[r5] = r9     // Catch:{ all -> 0x0215 }
        L_0x01c6:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0215 }
            r9.<init>()     // Catch:{ all -> 0x0215 }
            java.lang.String r0 = "allCount==="
            r9.append(r0)     // Catch:{ all -> 0x0215 }
            int r0 = r8.f37467C     // Catch:{ all -> 0x0215 }
            r9.append(r0)     // Catch:{ all -> 0x0215 }
            java.lang.String r0 = ", okCount="
            r9.append(r0)     // Catch:{ all -> 0x0215 }
            int r0 = r8.f37468D     // Catch:{ all -> 0x0215 }
            r9.append(r0)     // Catch:{ all -> 0x0215 }
            java.lang.String r0 = ", bCount="
            r9.append(r0)     // Catch:{ all -> 0x0215 }
            int r0 = r8.f37469E     // Catch:{ all -> 0x0215 }
            r9.append(r0)     // Catch:{ all -> 0x0215 }
            java.lang.String r0 = ", rCount="
            r9.append(r0)     // Catch:{ all -> 0x0215 }
            int r0 = r8.f37470F     // Catch:{ all -> 0x0215 }
            r9.append(r0)     // Catch:{ all -> 0x0215 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0215 }
            com.didi.safety.god.util.LogUtils.m28307d(r9)     // Catch:{ all -> 0x0215 }
            goto L_0x0213
        L_0x01fb:
            float r0 = r9.score     // Catch:{ all -> 0x0215 }
            float r2 = r8.f37492z     // Catch:{ all -> 0x0215 }
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x0213
            r8.f37490x = r9     // Catch:{ all -> 0x0215 }
            float r9 = r9.score     // Catch:{ all -> 0x0215 }
            r8.f37492z = r9     // Catch:{ all -> 0x0215 }
            goto L_0x0213
        L_0x020a:
            com.didi.sec.algo.RawDetectInfo r9 = r8.f37489w     // Catch:{ all -> 0x0215 }
            if (r9 != 0) goto L_0x0213
            r8.f37473b = r2     // Catch:{ all -> 0x0215 }
            r8.m28229a((byte[]) r0)     // Catch:{ all -> 0x0215 }
        L_0x0213:
            monitor-exit(r1)     // Catch:{ all -> 0x0215 }
            return
        L_0x0215:
            r9 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0215 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.safety.god.p145ui.DetectCoreThread.m28225a(android.os.Message):void");
    }

    /* renamed from: a */
    public void mo96316a(boolean z) {
        if (z) {
            this.f37466B = System.currentTimeMillis();
        }
        this.f37465A = z;
    }

    /* renamed from: a */
    private void m28229a(byte[] bArr) {
        CollectInfo collectInfo;
        if (this.f37482m && (collectInfo = this.f37484o.get(this.f37479j)) != null) {
            collectInfo.updateByDetectNothing(bArr);
        }
    }

    /* renamed from: a */
    private void m28228a(RawDetectInfo rawDetectInfo) {
        CollectInfo collectInfo;
        if (this.f37482m && (collectInfo = this.f37484o.get(this.f37479j)) != null && rawDetectInfo.score > collectInfo.score) {
            LogUtils.m28307d("collect wrong label, find a better score===" + rawDetectInfo.score);
            collectInfo.update(rawDetectInfo);
        }
    }

    /* renamed from: d */
    public boolean mo96319d() {
        return this.f37473b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public Object mo96320e() {
        return this.f37481l;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public RawDetectInfo mo96321f() {
        return this.f37489w;
    }

    /* renamed from: g */
    public int mo96322g() {
        return this.f37467C;
    }

    /* renamed from: h */
    public int mo96323h() {
        return this.f37471G;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public RawDetectInfo mo96324i() {
        LogUtils.m28307d("allCount===" + this.f37467C + ", okCount=" + this.f37468D + ", bCount=" + this.f37469E + ", rCount=" + this.f37470F);
        boolean isQualitySupportedLabel = LabelUtils.isQualitySupportedLabel(this.f37479j);
        RawDetectInfo rawDetectInfo = this.f37490x;
        if (rawDetectInfo == null) {
            rawDetectInfo = this.f37489w;
        }
        if (f37460e || rawDetectInfo != null) {
            boolean z = false;
            if (this.f37490x == null) {
                LogUtils.m28307d("detectInfoDuringVideo is null!!!");
                if (!isQualitySupportedLabel) {
                    rawDetectInfo.qState = 0;
                } else if (this.f37469E >= this.f37470F) {
                    RawDetectInfo rawDetectInfo2 = this.f37491y[0];
                    if (rawDetectInfo2 != null) {
                        rawDetectInfo = rawDetectInfo2;
                    } else {
                        z = true;
                    }
                    rawDetectInfo.qState = 1;
                } else {
                    RawDetectInfo rawDetectInfo3 = this.f37491y[1];
                    if (rawDetectInfo3 != null) {
                        rawDetectInfo = rawDetectInfo3;
                    } else {
                        z = true;
                    }
                    rawDetectInfo.qState = 2;
                }
            } else if (isQualitySupportedLabel) {
                int i = this.f37467C;
                if (i <= 0) {
                    rawDetectInfo.qState = 0;
                } else if ((((float) this.f37468D) * 1.0f) / ((float) i) > this.f37488s) {
                    rawDetectInfo.qState = 0;
                } else if (this.f37469E >= this.f37470F) {
                    RawDetectInfo rawDetectInfo4 = this.f37491y[0];
                    if (rawDetectInfo4 != null) {
                        rawDetectInfo = rawDetectInfo4;
                    } else {
                        z = true;
                    }
                    rawDetectInfo.qState = 1;
                } else {
                    RawDetectInfo rawDetectInfo5 = this.f37491y[1];
                    if (rawDetectInfo5 != null) {
                        rawDetectInfo = rawDetectInfo5;
                    } else {
                        z = true;
                    }
                    rawDetectInfo.qState = 2;
                }
            } else {
                rawDetectInfo.qState = 0;
            }
            if (rawDetectInfo.isGoodQuality()) {
                if (this.f37483n) {
                    LogUtils.m28307d("collect success case...");
                    SparseArray<CollectInfo> sparseArray = this.f37485p;
                    int i2 = this.f37479j;
                    sparseArray.put(i2, new CollectInfo(i2, rawDetectInfo));
                }
            } else if (this.f37482m && !z) {
                CollectInfo collectInfo = this.f37484o.get(this.f37479j);
                if (rawDetectInfo.score > collectInfo.score) {
                    LogUtils.m28307d("collect no good quality, find a better score===" + rawDetectInfo.score);
                    collectInfo.update(rawDetectInfo);
                }
            }
            return rawDetectInfo;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo96325j() {
        LogUtils.m28307d("DetectCoreThread.destroy, started===" + this.f37476g);
        if (this.f37476g) {
            this.f37477h.removeMessages(0);
            this.f37478i.quit();
            m28232m();
        }
        this.f37476g = false;
        f37461f = null;
    }

    /* renamed from: m */
    private void m28232m() {
        if (this.f37482m) {
            int size = this.f37484o.size();
            for (int i = 0; i < size; i++) {
                CollectInfo valueAt = this.f37484o.valueAt(i);
                if (valueAt.needUpload()) {
                    m28226a(valueAt);
                }
            }
        }
        this.f37484o.clear();
        if (this.f37483n) {
            int size2 = this.f37485p.size();
            for (int i2 = 0; i2 < size2; i2++) {
                CollectInfo valueAt2 = this.f37485p.valueAt(i2);
                if (valueAt2.needUpload()) {
                    m28226a(valueAt2);
                }
            }
        }
        this.f37485p.clear();
    }

    /* renamed from: a */
    private void m28226a(CollectInfo collectInfo) {
        if (AppContextHolder.getAppContext() != null) {
            HashMap hashMap = new HashMap(SafetyHttp.getCommonBodyParams());
            hashMap.put("cmd", "ALGRESULT");
            hashMap.put("type", Integer.valueOf(collectInfo.type));
            hashMap.put("label", String.valueOf(collectInfo.label));
            hashMap.put("labelD", String.valueOf(collectInfo.labelD));
            hashMap.put("score", String.format(Locale.CHINA, "%.6f", new Object[]{Float.valueOf(collectInfo.score)}));
            hashMap.put("qscore", String.format(Locale.CHINA, "%.6f", new Object[]{Float.valueOf(collectInfo.qscore)}));
            hashMap.put("bscore", String.format(Locale.CHINA, "%.6f", new Object[]{Float.valueOf(collectInfo.bscore)}));
            hashMap.put("rscore", String.format(Locale.CHINA, "%.6f", new Object[]{Float.valueOf(collectInfo.rscore)}));
            SafetyTraceEventHandler.trace(hashMap);
        }
    }
}
