package com.didichuxing.sdk.alphaface.core;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.os.Handler;
import android.os.HandlerThread;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.sdk.alphaface.AlphaFace;
import com.didichuxing.sdk.alphaface.utils.AFLog;
import com.didichuxing.sdk.alphaface.utils.UIHandler;
import com.google.common.base.Ascii;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class BioassayManager {
    public static final int FACE_BLUR = 6;
    public static final int FACE_ILLUM = 7;
    public static final int FACE_LOST = 0;
    public static final int FACE_NORMAL = -1;
    public static final int FACE_NOT_IN_CENTER = 3;
    public static final int FACE_OCC = 5;
    public static final int FACE_POSE = 4;
    public static final int FACE_TOO_CLOSE = 1;
    public static final int FACE_TOO_FAR = 2;
    /* access modifiers changed from: private */

    /* renamed from: A */
    public int f51180A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public IBioassayListener f51181B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public List<PicWithScore> f51182C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public List<PicWithScore> f51183D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public List<PicWithScore> f51184E;

    /* renamed from: a */
    int f51185a;

    /* renamed from: b */
    private AlphaFaceNativeProxy f51186b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public HandlerThread f51187c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Handler f51188d;

    /* renamed from: e */
    private AtomicBoolean f51189e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f51190f;

    /* renamed from: g */
    private long f51191g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f51192h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f51193i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public int f51194j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public float f51195k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public float f51196l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public float f51197m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public AtomicInteger f51198n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public long f51199o;

    /* renamed from: p */
    private int f51200p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public int f51201q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public int f51202r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public int f51203s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public int f51204t;

    /* renamed from: u */
    private int f51205u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public int f51206v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public double f51207w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public double f51208x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public boolean f51209y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public int f51210z;

    public interface IBioassayListener {
        void onDetectFace(FaceInfo faceInfo);

        void onFaceError(int i);

        void onFaceQualityError();

        void onFailed(int i, String str);

        void onProcess(int i);

        void onSuccess(int i, List<PicWithScore> list, List<PicWithScore> list2, List<PicWithScore> list3);
    }

    public static int convertByteToInt(byte b) {
        return (((b >> 4) & 15) * 16) + (b & Ascii.f55148SI);
    }

    /* renamed from: h */
    static /* synthetic */ int m38318h(BioassayManager bioassayManager) {
        int i = bioassayManager.f51204t;
        bioassayManager.f51204t = i + 1;
        return i;
    }

    public class FaceInfo {
        public Point[] keyPoints;
        public Point leftTop;
        public Point rightBottom;

        public FaceInfo() {
        }

        public String toString() {
            return "FaceInfo{leftTop=" + this.leftTop + ", rightBottom=" + this.rightBottom + ", keyPoints=" + Arrays.toString(this.keyPoints) + '}';
        }
    }

    public class PicWithScore {
        public double attackScore;
        public int height;
        public double qualityOk;
        public double qualityScore;
        public byte[] rgba;
        public int width;

        public PicWithScore() {
        }
    }

    private BioassayManager() {
        this.f51189e = new AtomicBoolean(false);
        this.f51191g = 0;
        this.f51192h = 2;
        this.f51195k = 1.0f;
        this.f51196l = 3.0f;
        this.f51197m = 1.0f;
        this.f51199o = 2000;
        this.f51200p = 0;
        this.f51201q = 3;
        this.f51202r = 1;
        this.f51203s = 1000;
        this.f51204t = 0;
        this.f51205u = 1;
        this.f51206v = 5;
        this.f51207w = 0.0d;
        this.f51208x = 0.0d;
        this.f51209y = false;
        this.f51210z = 0;
        this.f51180A = 0;
        this.f51185a = -1;
        this.f51186b = AlphaFaceFacade.getInstance().getAfNative();
    }

    public void detect(byte[] bArr, int i, int i2, int i3, int i4, float f, float f2, float f3) {
        if (this.f51198n == null) {
            this.f51198n = new AtomicInteger(0);
        }
        if (this.f51198n.get() != this.f51193i && !this.f51189e.get()) {
            HandlerThread handlerThread = this.f51187c;
            if (handlerThread == null || !handlerThread.isAlive()) {
                HandlerThread handlerThread2 = new HandlerThread("bioassay");
                this.f51187c = handlerThread2;
                handlerThread2.start();
                this.f51188d = new Handler(this.f51187c.getLooper());
            }
            long j = this.f51191g + 1;
            this.f51191g = j;
            if (j % ((long) this.f51192h) == 0) {
                final byte[] bArr2 = bArr;
                final int i5 = i;
                final int i6 = i2;
                final int i7 = i3;
                final int i8 = i4;
                final float f4 = f;
                final float f5 = f2;
                final float f6 = f3;
                this.f51188d.post(new Runnable() {
                    public void run() {
                        try {
                            BioassayManager.this.m38296a(bArr2, i5, i6, i7, i8, f4, f5, f6);
                        } catch (Throwable th) {
                            SystemUtils.log(6, "BioassayManager", "realDetect : ", th, "com.didichuxing.sdk.alphaface.core.BioassayManager$1", 208);
                            AlphaFace.throwable(th);
                        }
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x02a2  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x02fd  */
    /* JADX WARNING: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m38296a(byte[] r26, int r27, int r28, int r29, int r30, float r31, float r32, float r33) {
        /*
            r25 = this;
            r0 = r25
            r8 = r27
            r9 = r28
            java.util.concurrent.atomic.AtomicInteger r1 = r0.f51198n
            int r1 = r1.get()
            int r2 = r0.f51193i
            if (r1 != r2) goto L_0x0011
            return
        L_0x0011:
            int r1 = r8 * r9
            r10 = 4
            int r11 = r1 * 4
            byte[] r15 = new byte[r11]
            long r12 = java.lang.System.currentTimeMillis()
            com.didichuxing.sdk.alphaface.core.AlphaFaceNativeProxy r1 = r0.f51186b
            r2 = r29
            int r6 = 360 - r2
            r7 = 0
            r2 = r26
            r3 = r27
            r4 = r28
            r5 = r15
            r1.yuvToRGBA(r2, r3, r4, r5, r6, r7)
            boolean r1 = r0.f51209y
            if (r1 == 0) goto L_0x0034
            r7 = r8
            r6 = r9
            goto L_0x0036
        L_0x0034:
            r6 = r8
            r7 = r9
        L_0x0036:
            long r20 = java.lang.System.currentTimeMillis()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "yuvToRGBA NV21 to Bitmap consume: "
            r1.append(r2)
            long r2 = r20 - r12
            r1.append(r2)
            java.lang.String r5 = "ms"
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            com.didichuxing.sdk.alphaface.utils.AFLog.m38441v(r1)
            com.didichuxing.sdk.alphaface.core.AlphaFaceNativeProxy r12 = r0.f51186b
            r13 = r15
            r14 = r7
            r4 = r15
            r15 = r6
            r16 = r30
            r17 = r31
            r18 = r32
            r19 = r33
            int[] r12 = r12.maxFaceDetect(r13, r14, r15, r16, r17, r18, r19)
            r13 = 0
            if (r12 == 0) goto L_0x0301
            int r1 = r12.length
            if (r1 != 0) goto L_0x006f
            goto L_0x0301
        L_0x006f:
            r1 = r12[r13]
            if (r1 != 0) goto L_0x0077
            r0.m38292a((int) r13)
            return
        L_0x0077:
            r14 = 1
            r1 = r12[r14]
            r15 = 3
            if (r1 != 0) goto L_0x0081
            r0.m38292a((int) r15)
            return
        L_0x0081:
            r3 = 2
            r1 = r12[r3]
            r2 = -1
            if (r1 == 0) goto L_0x0091
            if (r1 != r2) goto L_0x008d
            r0.m38292a((int) r14)
            goto L_0x0090
        L_0x008d:
            r0.m38292a((int) r3)
        L_0x0090:
            return
        L_0x0091:
            java.util.List<com.didichuxing.sdk.alphaface.core.BioassayManager$PicWithScore> r1 = r0.f51184E
            if (r1 == 0) goto L_0x00a4
            int r1 = r1.size()
            if (r1 != 0) goto L_0x009c
            goto L_0x00a4
        L_0x009c:
            r19 = r4
            r22 = r5
            r14 = r6
            r18 = 2
            goto L_0x00ef
        L_0x00a4:
            java.util.List<com.didichuxing.sdk.alphaface.core.BioassayManager$PicWithScore> r1 = r0.f51184E
            if (r1 != 0) goto L_0x00af
            java.util.concurrent.CopyOnWriteArrayList r1 = new java.util.concurrent.CopyOnWriteArrayList
            r1.<init>()
            r0.f51184E = r1
        L_0x00af:
            com.didichuxing.sdk.alphaface.core.BioassayManager$PicWithScore r1 = new com.didichuxing.sdk.alphaface.core.BioassayManager$PicWithScore
            r1.<init>()
            int r10 = r0.f51180A
            r2 = -2
            if (r10 != r2) goto L_0x00c5
            r1.rgba = r4
            r15 = r1
            r19 = r4
            r22 = r5
            r14 = r6
            r1 = 1
            r18 = 2
            goto L_0x00dd
        L_0x00c5:
            byte[] r11 = new byte[r11]
            com.didichuxing.sdk.alphaface.core.AlphaFaceNativeProxy r2 = r0.f51186b
            r15 = r1
            r1 = r2
            r2 = r4
            r18 = 2
            r3 = r7
            r19 = r4
            r4 = r6
            r22 = r5
            r5 = r11
            r14 = r6
            r6 = r10
            int r1 = r1.addWaterMark(r2, r3, r4, r5, r6)
            r15.rgba = r11
        L_0x00dd:
            r2 = 0
            r15.qualityScore = r2
            double r4 = (double) r1
            r15.qualityOk = r4
            r15.attackScore = r2
            r15.width = r7
            r15.height = r14
            java.util.List<com.didichuxing.sdk.alphaface.core.BioassayManager$PicWithScore> r1 = r0.f51184E
            r1.add(r15)
        L_0x00ef:
            com.didichuxing.sdk.alphaface.core.BioassayManager$FaceInfo r1 = r0.m38288a((int[]) r12)
            r0.f51200p = r13
            java.util.concurrent.atomic.AtomicInteger r2 = r0.f51198n
            r3 = 1
            r2.addAndGet(r3)
            long r2 = java.lang.System.currentTimeMillis()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "maxFaceDetect consume: "
            r4.append(r5)
            long r5 = r2 - r20
            r4.append(r5)
            r5 = r22
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            com.didichuxing.sdk.alphaface.utils.AFLog.m38441v(r4)
            r4 = 3
            r6 = r12[r4]
            r4 = 4
            r10 = r12[r4]
            r4 = 5
            r11 = r12[r4]
            r15 = 6
            r12 = r12[r15]
            int r10 = r12 - r10
            double r4 = (double) r10
            r23 = 4605380978949069210(0x3fe999999999999a, double:0.8)
            double r4 = r4 * r23
            int r4 = (int) r4
            int r11 = r11 + r6
            int r11 = r11 / 2
            int r5 = r12 - r4
            int r6 = r4 / 2
            int r10 = r11 - r6
            int r11 = r11 + r6
            r23 = 4587150407657473442(0x3fa8d4fdf3b645a2, double:0.0485)
            r21 = r14
            double r13 = (double) r10
            r10 = r7
            double r6 = (double) r4
            double r6 = r6 * r23
            double r13 = r13 - r6
            int r4 = (int) r13
            double r13 = (double) r5
            double r13 = r13 - r6
            int r5 = (int) r13
            double r13 = (double) r11
            double r13 = r13 + r6
            int r11 = (int) r13
            double r12 = (double) r12
            double r12 = r12 + r6
            int r6 = (int) r12
            int r4 = java.lang.Math.min(r4, r8)
            r7 = 0
            int r4 = java.lang.Math.max(r4, r7)
            int r5 = java.lang.Math.min(r5, r9)
            int r5 = java.lang.Math.max(r5, r7)
            int r8 = java.lang.Math.min(r11, r8)
            int r8 = java.lang.Math.max(r8, r7)
            int r6 = java.lang.Math.min(r6, r9)
            int r9 = java.lang.Math.max(r6, r7)
            int r7 = r8 - r4
            int r11 = r9 - r5
            int r12 = r7 * r11
            r13 = 4
            int r12 = r12 * 4
            byte[] r12 = new byte[r12]
            r26 = r25
            r27 = r19
            r28 = r12
            r29 = r4
            r30 = r5
            r31 = r8
            r32 = r9
            r33 = r10
            r26.m38282a(r27, r28, r29, r30, r31, r32, r33)
            long r4 = java.lang.System.currentTimeMillis()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "crop face from ARGB: "
            r8.append(r9)
            long r4 = r4 - r2
            r8.append(r4)
            r4 = r22
            r8.append(r4)
            java.lang.String r5 = r8.toString()
            com.didichuxing.sdk.alphaface.utils.AFLog.m38441v(r5)
            long r8 = java.lang.System.currentTimeMillis()
            r29 = r7
            r30 = r11
            r31 = r10
            r32 = r21
            float[] r5 = r26.m38299a(r27, r28, r29, r30, r31, r32)
            long r11 = java.lang.System.currentTimeMillis()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r13 = "qualityDetect cost time : "
            r7.append(r13)
            long r11 = r11 - r8
            r7.append(r11)
            r7.append(r4)
            java.lang.String r4 = r7.toString()
            com.didichuxing.sdk.alphaface.utils.AFLog.m38441v(r4)
            if (r5 == 0) goto L_0x0300
            int r4 = r5.length
            if (r4 != 0) goto L_0x01e2
            goto L_0x0300
        L_0x01e2:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r7 = "qualityInfo: "
            r4.append(r7)
            java.lang.String r7 = java.util.Arrays.toString(r5)
            r4.append(r7)
            java.lang.String r4 = r4.toString()
            com.didichuxing.sdk.alphaface.utils.AFLog.m38441v(r4)
            r4 = 0
            r4 = r5[r4]
            r6 = 1
            r6 = r5[r6]
            r7 = r5[r18]
            r8 = 1065353216(0x3f800000, float:1.0)
            int r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r7 != 0) goto L_0x020e
            r7 = 4
            r0.m38305b((int) r7)
        L_0x020c:
            r5 = -1
            goto L_0x0235
        L_0x020e:
            r7 = 4
            r9 = 3
            r9 = r5[r9]
            int r9 = (r9 > r8 ? 1 : (r9 == r8 ? 0 : -1))
            if (r9 != 0) goto L_0x021b
            r9 = 5
            r0.m38305b((int) r9)
            goto L_0x020c
        L_0x021b:
            r9 = 5
            r7 = r5[r7]
            int r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r7 != 0) goto L_0x0226
            r0.m38305b((int) r15)
            goto L_0x020c
        L_0x0226:
            r5 = r5[r9]
            int r5 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r5 != 0) goto L_0x0231
            r5 = 7
            r0.m38305b((int) r5)
            goto L_0x020c
        L_0x0231:
            r5 = -1
            r0.m38305b((int) r5)
        L_0x0235:
            long r7 = java.lang.System.currentTimeMillis()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r11 = "qualityDetect consume: "
            r9.append(r11)
            long r2 = r7 - r2
            r9.append(r2)
            java.lang.String r2 = "ms, qualityScore:"
            r9.append(r2)
            r9.append(r4)
            java.lang.String r2 = r9.toString()
            com.didichuxing.sdk.alphaface.utils.AFLog.m38441v(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "qualityDetect quality_ok: "
            r2.append(r3)
            r2.append(r6)
            java.lang.String r2 = r2.toString()
            com.didichuxing.sdk.alphaface.utils.AFLog.m38441v(r2)
            double r2 = (double) r4
            double r11 = (double) r6
            r26 = r25
            r27 = r19
            r28 = r10
            r29 = r21
            r30 = r2
            r32 = r11
            double r2 = r26.m38278a((byte[]) r27, (int) r28, (int) r29, (double) r30, (double) r32)
            long r9 = java.lang.System.currentTimeMillis()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r11 = "antiAttack consume: "
            r6.append(r11)
            long r9 = r9 - r7
            r6.append(r9)
            java.lang.String r7 = "ms, attackScore: "
            r6.append(r7)
            r6.append(r2)
            java.lang.String r2 = r6.toString()
            com.didichuxing.sdk.alphaface.utils.AFLog.m38441v(r2)
            int r2 = r0.f51185a
            if (r2 != r5) goto L_0x02a5
            r0.m38294a((com.didichuxing.sdk.alphaface.core.BioassayManager.FaceInfo) r1)
        L_0x02a5:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "detectCountMin = "
            r1.append(r2)
            int r2 = r0.f51194j
            r1.append(r2)
            java.lang.String r2 = "  "
            r1.append(r2)
            java.util.concurrent.atomic.AtomicInteger r3 = r0.f51198n
            int r3 = r3.get()
            r1.append(r3)
            java.lang.String r3 = ", bestPicQualityThreshold = "
            r1.append(r3)
            double r5 = r0.f51207w
            r1.append(r5)
            r1.append(r2)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            com.didichuxing.sdk.alphaface.utils.AFLog.m38441v(r1)
            java.util.concurrent.atomic.AtomicInteger r1 = r0.f51198n
            int r1 = r1.get()
            int r2 = r0.f51194j
            if (r1 <= r2) goto L_0x02f0
            float r1 = r0.f51197m
            int r1 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x02f0
            java.util.concurrent.atomic.AtomicInteger r1 = r0.f51198n
            int r2 = r0.f51193i
            r1.getAndSet(r2)
        L_0x02f0:
            r25.m38304b()
            java.util.concurrent.atomic.AtomicInteger r1 = r0.f51198n
            int r1 = r1.get()
            int r2 = r0.f51193i
            if (r1 != r2) goto L_0x0300
            r25.m38309c()
        L_0x0300:
            return
        L_0x0301:
            r1 = 0
            r0.m38292a((int) r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.sdk.alphaface.core.BioassayManager.m38296a(byte[], int, int, int, int, float, float, float):void");
    }

    /* renamed from: a */
    private int m38282a(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, int i5) {
        int i6 = i3 - i;
        int i7 = 0;
        while (i2 < i4) {
            int i8 = i6 * 4;
            System.arraycopy(bArr, (i2 * i5 * 4) + (i * 4), bArr2, i7, i8);
            i7 += i8;
            i2++;
        }
        return 0;
    }

    /* renamed from: a */
    private FaceInfo m38288a(int[] iArr) {
        FaceInfo faceInfo = new FaceInfo();
        faceInfo.leftTop = new Point();
        faceInfo.leftTop.x = iArr[3];
        faceInfo.leftTop.y = iArr[4];
        faceInfo.rightBottom = new Point();
        faceInfo.rightBottom.x = iArr[5];
        faceInfo.rightBottom.y = iArr[6];
        faceInfo.keyPoints = new Point[5];
        for (int i = 0; i < faceInfo.keyPoints.length; i++) {
            faceInfo.keyPoints[i] = new Point();
            faceInfo.keyPoints[i].x = iArr[i + 7];
            faceInfo.keyPoints[i].y = iArr[i + 10 + 2];
        }
        return faceInfo;
    }

    public static void compress(Bitmap bitmap, int i, File file) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(byteArrayOutputStream.toByteArray());
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int[] convertByteToColor(byte[] bArr) {
        int i;
        int length = bArr.length;
        if (length == 0) {
            return null;
        }
        int i2 = 0;
        int i3 = length % 4 != 0 ? 1 : 0;
        int i4 = (length / 4) + i3;
        int[] iArr = new int[i4];
        if (i3 == 0) {
            boolean z = true;
            for (int i5 = 0; i5 < i4; i5++) {
                int i6 = i5 * 4;
                int convertByteToInt = convertByteToInt(bArr[i6 + 0]);
                int convertByteToInt2 = convertByteToInt(bArr[i6 + 1]);
                int convertByteToInt3 = convertByteToInt(bArr[i6 + 2]);
                if (convertByteToInt == 0 && convertByteToInt2 == 0 && convertByteToInt3 == 0 && z) {
                    z = false;
                }
                iArr[i5] = convertByteToInt3 | (convertByteToInt << 16) | (convertByteToInt2 << 8) | -16777216;
            }
        } else {
            while (true) {
                i = i4 - 1;
                if (i2 >= i) {
                    break;
                }
                int i7 = i2 * 3;
                iArr[i2] = (convertByteToInt(bArr[i7 + 2]) << 16) | (convertByteToInt(bArr[i7 + 1]) << 8) | convertByteToInt(bArr[i7]) | -16777216;
                i2++;
            }
            iArr[i] = -16777216;
        }
        return iArr;
    }

    public static Bitmap rgba2Bitmap(byte[] bArr, int i, int i2) {
        int[] convertByteToColor = convertByteToColor(bArr);
        if (convertByteToColor == null) {
            return null;
        }
        return Bitmap.createBitmap(convertByteToColor, 0, i, i, i2, Bitmap.Config.ARGB_8888);
    }

    /* renamed from: a */
    private double m38276a(Bitmap bitmap, byte[] bArr, boolean z) {
        return (double) this.f51186b.compressBitmap(bitmap, 75, bArr, z);
    }

    /* renamed from: a */
    private double m38279a(byte[] bArr, int i, int i2, byte[] bArr2, boolean z) {
        return (double) this.f51186b.compressRGBA(bArr, i, i2, 75, bArr2, z);
    }

    /* renamed from: a */
    private float[] m38299a(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4) {
        float[] qualityDetect = this.f51186b.qualityDetect(bArr2, i, i2);
        if (this.f51182C == null) {
            this.f51182C = new CopyOnWriteArrayList();
        }
        if (!(qualityDetect == null || qualityDetect.length == 0 || ((double) qualityDetect[0]) <= this.f51207w)) {
            m38291a((double) qualityDetect[0], (double) qualityDetect[1], (double) qualityDetect[0], bArr, i3, i4, this.f51205u, this.f51182C);
        }
        return qualityDetect;
    }

    public void quit() {
        m38290a();
        this.f51189e.set(true);
        Handler handler = this.f51188d;
        if (handler != null) {
            handler.post(new Runnable() {
                public void run() {
                    BioassayManager.this.f51188d.removeCallbacksAndMessages((Object) null);
                    AlphaFaceFacade.getInstance().unInitModels();
                    if (BioassayManager.this.f51187c != null) {
                        BioassayManager.this.f51187c.quit();
                    }
                }
            });
        }
    }

    /* renamed from: a */
    private void m38291a(double d, double d2, double d3, byte[] bArr, int i, int i2, int i3, List<PicWithScore> list) {
        PicWithScore picWithScore = new PicWithScore();
        picWithScore.qualityScore = d;
        picWithScore.qualityOk = d2;
        picWithScore.attackScore = d3;
        picWithScore.rgba = bArr;
        picWithScore.width = i;
        picWithScore.height = i2;
        if (list.size() < i3) {
            list.add(picWithScore);
            return;
        }
        int i4 = 0;
        double d4 = list.get(0).attackScore;
        double d5 = d4;
        int i5 = 0;
        for (PicWithScore next : list) {
            if (next.attackScore < d5) {
                d5 = next.attackScore;
                i4 = i5;
            }
            i5++;
        }
        if (picWithScore.attackScore > d5) {
            list.set(i4, picWithScore);
        }
    }

    /* renamed from: a */
    private double m38278a(byte[] bArr, int i, int i2, double d, double d2) {
        double attackDetect = this.f51186b.attackDetect(bArr, i, i2);
        if (attackDetect >= 99.0d) {
            this.f51210z++;
        }
        if (this.f51183D == null) {
            this.f51183D = new CopyOnWriteArrayList();
        }
        if (d > this.f51208x) {
            m38291a(d, d2, attackDetect, bArr, i, i2, this.f51206v, this.f51183D);
        }
        return attackDetect;
    }

    /* renamed from: a */
    private void m38292a(final int i) {
        int i2 = this.f51200p;
        if (i2 == this.f51201q) {
            this.f51200p = 0;
            resetStatus();
            UIHandler.post(new Runnable() {
                public void run() {
                    if (BioassayManager.this.f51181B != null) {
                        BioassayManager.this.f51181B.onFaceError(i);
                    }
                }
            });
            return;
        }
        this.f51200p = i2 + 1;
    }

    public void resetStatus() {
        this.f51185a = -1;
        m38290a();
        AtomicInteger atomicInteger = this.f51198n;
        if (atomicInteger != null) {
            atomicInteger.set(0);
        }
        m38304b();
    }

    /* renamed from: a */
    private void m38290a() {
        List<PicWithScore> list = this.f51182C;
        if (list != null) {
            list.clear();
        }
        List<PicWithScore> list2 = this.f51183D;
        if (list2 != null) {
            list2.clear();
        }
        List<PicWithScore> list3 = this.f51184E;
        if (list3 != null) {
            list3.clear();
        }
    }

    /* renamed from: b */
    private void m38304b() {
        UIHandler.post(new Runnable() {
            public void run() {
                if (BioassayManager.this.f51181B != null && BioassayManager.this.f51198n != null) {
                    BioassayManager.this.f51181B.onProcess((BioassayManager.this.f51198n.get() * 100) / BioassayManager.this.f51193i);
                }
            }
        });
    }

    /* renamed from: a */
    private void m38294a(final FaceInfo faceInfo) {
        UIHandler.post(new Runnable() {
            public void run() {
                if (BioassayManager.this.f51181B != null) {
                    BioassayManager.this.f51181B.onDetectFace(faceInfo);
                }
            }
        });
    }

    /* renamed from: c */
    private void m38309c() {
        UIHandler.post(new Runnable() {
            public void run() {
                if (BioassayManager.this.f51181B == null) {
                    return;
                }
                if (BioassayManager.this.f51204t < BioassayManager.this.f51202r) {
                    BioassayManager.m38318h(BioassayManager.this);
                    if (BioassayManager.this.f51182C == null || BioassayManager.this.f51182C.size() <= 0) {
                        BioassayManager.this.f51181B.onSuccess(BioassayManager.this.f51210z, BioassayManager.this.f51182C, BioassayManager.this.f51183D, BioassayManager.this.f51184E);
                    } else if (Double.compare(((PicWithScore) BioassayManager.this.f51182C.get(0)).qualityOk, 1.0d) != 0) {
                        BioassayManager.this.f51181B.onFaceQualityError();
                        UIHandler.postDelayed((long) BioassayManager.this.f51203s, new Runnable() {
                            public void run() {
                                BioassayManager.this.resetStatus();
                            }
                        });
                    } else {
                        BioassayManager.this.f51181B.onSuccess(BioassayManager.this.f51210z, BioassayManager.this.f51182C, BioassayManager.this.f51183D, BioassayManager.this.f51184E);
                    }
                } else {
                    BioassayManager.this.f51181B.onSuccess(BioassayManager.this.f51210z, BioassayManager.this.f51182C, BioassayManager.this.f51183D, BioassayManager.this.f51184E);
                }
            }
        });
    }

    /* renamed from: b */
    private void m38305b(final int i) {
        if (this.f51185a == i) {
            UIHandler.post(new Runnable() {
                public void run() {
                    if (BioassayManager.this.f51181B != null) {
                        BioassayManager.this.f51181B.onFaceError(i);
                    }
                }
            });
        } else {
            this.f51185a = i;
        }
    }

    /* renamed from: a */
    private void m38293a(final int i, final String str) {
        UIHandler.post(new Runnable() {
            public void run() {
                if (BioassayManager.this.f51181B != null) {
                    BioassayManager.this.f51181B.onFailed(i, str);
                }
            }
        });
    }

    public String toString() {
        return "BioassayManager{fps=" + this.f51190f + ", frameCount=" + this.f51191g + ", frameSkip=" + this.f51192h + ", detectCountMax=" + this.f51193i + ", detectCount=" + this.f51198n + ", detectTime=" + this.f51199o + ", faceErrorCount=" + this.f51200p + ", faceErrorCountMax=" + this.f51201q + ", bestPicCount=" + this.f51205u + ", attackPicCount=" + this.f51206v + '}';
    }

    /* renamed from: a */
    private Bitmap m38286a(byte[] bArr, int i, int i2) {
        long currentTimeMillis = System.currentTimeMillis();
        YuvImage yuvImage = new YuvImage(bArr, 17, i, i2, (int[]) null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        yuvImage.compressToJpeg(new Rect(0, 0, yuvImage.getWidth(), yuvImage.getHeight()), 70, byteArrayOutputStream);
        long currentTimeMillis2 = System.currentTimeMillis();
        AFLog.m38441v("NV21 to YUV in bitmap: " + (currentTimeMillis2 - currentTimeMillis) + "ms");
        long currentTimeMillis3 = System.currentTimeMillis();
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
        long currentTimeMillis4 = System.currentTimeMillis();
        AFLog.m38441v("YUV 2 bitmap : " + (currentTimeMillis4 - currentTimeMillis3) + "ms");
        return decodeByteArray;
    }

    /* renamed from: a */
    private Bitmap m38285a(Bitmap bitmap, int i) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (i == 90 || i == 270) {
            int i2 = height;
            height = width;
            width = i2;
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, height, bitmap.getConfig());
        Canvas canvas = new Canvas(createBitmap);
        Rect rect = new Rect(0, 0, width, height);
        Matrix matrix = new Matrix();
        float exactCenterX = rect.exactCenterX();
        float exactCenterY = rect.exactCenterY();
        matrix.postTranslate((((float) (-bitmap.getWidth())) * 1.0f) / 2.0f, (((float) (-bitmap.getHeight())) * 1.0f) / 2.0f);
        matrix.postRotate(((float) i) * 1.0f);
        matrix.postTranslate(exactCenterX, exactCenterY);
        canvas.drawBitmap(bitmap, matrix, new Paint(7));
        matrix.reset();
        return createBitmap;
    }

    /* renamed from: a */
    private Bitmap m38284a(Bitmap bitmap, float f) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.setRotate(f);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        if (createBitmap.equals(bitmap)) {
            return createBitmap;
        }
        bitmap.recycle();
        return createBitmap;
    }

    /* renamed from: a */
    private byte[] m38298a(Bitmap bitmap) {
        ByteBuffer allocate = ByteBuffer.allocate(bitmap.getByteCount());
        bitmap.copyPixelsToBuffer(allocate);
        return allocate.array();
    }

    public static class Builder {
        private BioassayManager manager = new BioassayManager();

        public Builder setModelLayers(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int i, int i2, int[] iArr5, int i3, int i4) {
            return this;
        }

        public Builder setFrameSkip(int i) {
            int unused = this.manager.f51192h = i;
            return this;
        }

        public Builder setBioassayListener(IBioassayListener iBioassayListener) {
            IBioassayListener unused = this.manager.f51181B = iBioassayListener;
            return this;
        }

        public Builder setDetectTime(int i) {
            long unused = this.manager.f51199o = (long) i;
            return this;
        }

        public Builder setFps(int i) {
            int unused = this.manager.f51190f = i;
            return this;
        }

        public Builder setLandscape(boolean z) {
            boolean unused = this.manager.f51209y = z;
            return this;
        }

        public Builder setActionPicCount(int i) {
            int unused = this.manager.f51206v = i;
            return this;
        }

        public Builder setFaceErrorCountMax(int i) {
            int unused = this.manager.f51201q = i;
            return this;
        }

        public Builder setBestPicQualityThreshold(double d) {
            double unused = this.manager.f51207w = d;
            return this;
        }

        public Builder setFaceQualityErrorMaxTimes(int i) {
            int unused = this.manager.f51202r = i;
            return this;
        }

        public Builder setFaceQualityErrorDelay(int i) {
            int unused = this.manager.f51203s = i;
            return this;
        }

        public Builder setAttackPicQualityThreshold(double d) {
            double unused = this.manager.f51208x = d;
            return this;
        }

        public Builder setDetectTimeMax(float f) {
            float unused = this.manager.f51196l = f;
            return this;
        }

        public Builder setDetectTimeMin(float f) {
            float unused = this.manager.f51195k = f;
            return this;
        }

        public Builder setQualityThreshold(float f) {
            float unused = this.manager.f51197m = f;
            return this;
        }

        public Builder setWaterType(int i) {
            int unused = this.manager.f51180A = i;
            return this;
        }

        public BioassayManager create() {
            if (this.manager.f51199o < 1000) {
                throw new RuntimeException("detect time less than 1000ms");
            } else if (this.manager.f51190f <= 0) {
                throw new RuntimeException("fps is 0 or less than 0");
            } else if (this.manager.f51192h <= this.manager.f51190f) {
                BioassayManager bioassayManager = this.manager;
                int unused = bioassayManager.f51193i = (int) (((float) ((long) (bioassayManager.f51190f / this.manager.f51192h))) * this.manager.f51196l);
                BioassayManager bioassayManager2 = this.manager;
                int unused2 = bioassayManager2.f51194j = (int) (((float) ((long) (bioassayManager2.f51190f / this.manager.f51192h))) * this.manager.f51195k);
                AFLog.m38441v(this.manager.toString());
                return this.manager;
            } else {
                throw new RuntimeException("frameSkip is larger than fps");
            }
        }
    }
}
