package com.didichuxing.sdk.alphaface.core.colorliveness;

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
import com.didichuxing.sdk.alphaface.core.AlphaFaceFacade;
import com.didichuxing.sdk.alphaface.core.AlphaFaceNativeProxy;
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

public class ColorfulLivenessManager {
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
    public int f51211A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public IColorfulListener f51212B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public List<PicWithScore> f51213C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public List<PicWithScore> f51214D;

    /* renamed from: E */
    private List<PicWithScore> f51215E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public List<PicWithScore> f51216F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public int f51217G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public int f51218H;
    /* access modifiers changed from: private */

    /* renamed from: I */
    public int f51219I;

    /* renamed from: a */
    int f51220a;

    /* renamed from: b */
    private AlphaFaceNativeProxy f51221b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public HandlerThread f51222c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Handler f51223d;

    /* renamed from: e */
    private AtomicBoolean f51224e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f51225f;

    /* renamed from: g */
    private long f51226g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f51227h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f51228i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public int f51229j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public float f51230k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public float f51231l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public float f51232m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public AtomicInteger f51233n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public long f51234o;

    /* renamed from: p */
    private int f51235p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public int f51236q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public int f51237r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public int f51238s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public int f51239t;

    /* renamed from: u */
    private int f51240u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public int f51241v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public double f51242w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public double f51243x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public boolean f51244y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public int f51245z;

    public interface IColorfulListener {
        void onDetectFace(FaceInfo faceInfo);

        void onFaceError(int i);

        void onFaceQualityError();

        void onFailed(int i, String str);

        void onProcess(int i, int i2);

        void onQualityError(int i);

        void onSuccess(int i, List<PicWithScore> list, List<PicWithScore> list2, List<PicWithScore> list3);
    }

    public static int convertByteToInt(byte b) {
        return (((b >> 4) & 15) * 16) + (b & Ascii.f55148SI);
    }

    /* renamed from: i */
    static /* synthetic */ int m38376i(ColorfulLivenessManager colorfulLivenessManager) {
        int i = colorfulLivenessManager.f51239t;
        colorfulLivenessManager.f51239t = i + 1;
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

    private ColorfulLivenessManager() {
        this.f51224e = new AtomicBoolean(false);
        this.f51226g = 0;
        this.f51227h = 2;
        this.f51230k = 1.0f;
        this.f51231l = 3.0f;
        this.f51232m = 1.0f;
        this.f51234o = 2000;
        this.f51235p = 0;
        this.f51236q = 3;
        this.f51237r = 1;
        this.f51238s = 1000;
        this.f51239t = 0;
        this.f51240u = 1;
        this.f51241v = 5;
        this.f51242w = 0.0d;
        this.f51243x = 0.0d;
        this.f51244y = false;
        this.f51245z = 0;
        this.f51211A = 0;
        this.f51217G = 6;
        this.f51220a = -1;
        this.f51221b = AlphaFaceFacade.getInstance().getAfNative();
    }

    public void detect(byte[] bArr, int i, int i2, int i3, int i4, float f, float f2, float f3) {
        if (this.f51233n == null) {
            this.f51233n = new AtomicInteger(0);
        }
        if (this.f51233n.get() != this.f51228i && !this.f51224e.get()) {
            HandlerThread handlerThread = this.f51222c;
            if (handlerThread == null || !handlerThread.isAlive()) {
                HandlerThread handlerThread2 = new HandlerThread("bioassay");
                this.f51222c = handlerThread2;
                handlerThread2.start();
                this.f51223d = new Handler(this.f51222c.getLooper());
            }
            long j = this.f51226g + 1;
            this.f51226g = j;
            if (j % ((long) this.f51227h) == 0) {
                final byte[] bArr2 = bArr;
                final int i5 = i;
                final int i6 = i2;
                final int i7 = i3;
                final int i8 = i4;
                final float f4 = f;
                final float f5 = f2;
                final float f6 = f3;
                this.f51223d.post(new Runnable() {
                    public void run() {
                        try {
                            ColorfulLivenessManager.this.m38351a(bArr2, i5, i6, i7, i8, f4, f5, f6);
                        } catch (Throwable th) {
                            SystemUtils.log(6, "BioassayManager", "realDetect : ", th, "com.didichuxing.sdk.alphaface.core.colorliveness.ColorfulLivenessManager$1", 215);
                            AlphaFace.throwable(th);
                        }
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x02a3  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x02b3  */
    /* JADX WARNING: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m38351a(byte[] r26, int r27, int r28, int r29, int r30, float r31, float r32, float r33) {
        /*
            r25 = this;
            r0 = r25
            r8 = r27
            r9 = r28
            java.util.concurrent.atomic.AtomicInteger r1 = r0.f51233n
            int r1 = r1.get()
            int r2 = r0.f51228i
            if (r1 != r2) goto L_0x0011
            return
        L_0x0011:
            int r1 = r8 * r9
            r10 = 4
            int r11 = r1 * 4
            byte[] r15 = new byte[r11]
            long r12 = java.lang.System.currentTimeMillis()
            com.didichuxing.sdk.alphaface.core.AlphaFaceNativeProxy r1 = r0.f51221b
            r2 = r29
            int r6 = 360 - r2
            r7 = 0
            r2 = r26
            r3 = r27
            r4 = r28
            r5 = r15
            r1.yuvToRGBA(r2, r3, r4, r5, r6, r7)
            boolean r1 = r0.f51244y
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
            com.didichuxing.sdk.alphaface.core.AlphaFaceNativeProxy r12 = r0.f51221b
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
            if (r12 == 0) goto L_0x02b7
            int r1 = r12.length
            if (r1 != 0) goto L_0x0070
            goto L_0x02b7
        L_0x0070:
            r1 = r12[r13]
            if (r1 != 0) goto L_0x0078
            r0.m38348a((int) r13)
            return
        L_0x0078:
            r14 = 1
            r1 = r12[r14]
            r15 = 3
            if (r1 != 0) goto L_0x0082
            r0.m38348a((int) r15)
            return
        L_0x0082:
            r3 = 2
            r1 = r12[r3]
            r2 = -1
            if (r1 == 0) goto L_0x0092
            if (r1 != r2) goto L_0x008e
            r0.m38348a((int) r14)
            goto L_0x0091
        L_0x008e:
            r0.m38348a((int) r3)
        L_0x0091:
            return
        L_0x0092:
            java.util.List<com.didichuxing.sdk.alphaface.core.colorliveness.ColorfulLivenessManager$PicWithScore> r1 = r0.f51216F
            if (r1 == 0) goto L_0x00a5
            int r1 = r1.size()
            if (r1 != 0) goto L_0x009d
            goto L_0x00a5
        L_0x009d:
            r19 = r4
            r22 = r5
            r14 = r6
            r18 = 2
            goto L_0x00f0
        L_0x00a5:
            java.util.List<com.didichuxing.sdk.alphaface.core.colorliveness.ColorfulLivenessManager$PicWithScore> r1 = r0.f51216F
            if (r1 != 0) goto L_0x00b0
            java.util.concurrent.CopyOnWriteArrayList r1 = new java.util.concurrent.CopyOnWriteArrayList
            r1.<init>()
            r0.f51216F = r1
        L_0x00b0:
            com.didichuxing.sdk.alphaface.core.colorliveness.ColorfulLivenessManager$PicWithScore r1 = new com.didichuxing.sdk.alphaface.core.colorliveness.ColorfulLivenessManager$PicWithScore
            r1.<init>()
            int r10 = r0.f51211A
            r2 = -2
            if (r10 != r2) goto L_0x00c6
            r1.rgba = r4
            r15 = r1
            r19 = r4
            r22 = r5
            r14 = r6
            r1 = 1
            r18 = 2
            goto L_0x00de
        L_0x00c6:
            byte[] r11 = new byte[r11]
            com.didichuxing.sdk.alphaface.core.AlphaFaceNativeProxy r2 = r0.f51221b
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
        L_0x00de:
            r2 = 0
            r15.qualityScore = r2
            double r4 = (double) r1
            r15.qualityOk = r4
            r15.attackScore = r2
            r15.width = r7
            r15.height = r14
            java.util.List<com.didichuxing.sdk.alphaface.core.colorliveness.ColorfulLivenessManager$PicWithScore> r1 = r0.f51216F
            r1.add(r15)
        L_0x00f0:
            com.didichuxing.sdk.alphaface.core.colorliveness.ColorfulLivenessManager$FaceInfo r1 = r0.m38343a((int[]) r12)
            r0.f51235p = r13
            java.util.concurrent.atomic.AtomicInteger r2 = r0.f51233n
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
            r26.m38337a((byte[]) r27, (byte[]) r28, (int) r29, (int) r30, (int) r31, (int) r32, (int) r33)
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
            float[] r5 = r26.m38354a(r27, r28, r29, r30, r31, r32)
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
            if (r5 == 0) goto L_0x02b6
            int r4 = r5.length
            if (r4 != 0) goto L_0x01e3
            goto L_0x02b6
        L_0x01e3:
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
            if (r7 != 0) goto L_0x020f
            r7 = 4
            r0.m38361b((int) r7)
        L_0x020d:
            r5 = -1
            goto L_0x0236
        L_0x020f:
            r7 = 4
            r9 = 3
            r9 = r5[r9]
            int r9 = (r9 > r8 ? 1 : (r9 == r8 ? 0 : -1))
            if (r9 != 0) goto L_0x021c
            r9 = 5
            r0.m38361b((int) r9)
            goto L_0x020d
        L_0x021c:
            r9 = 5
            r7 = r5[r7]
            int r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r7 != 0) goto L_0x0227
            r0.m38361b((int) r15)
            goto L_0x020d
        L_0x0227:
            r5 = r5[r9]
            int r5 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r5 != 0) goto L_0x0232
            r5 = 7
            r0.m38361b((int) r5)
            goto L_0x020d
        L_0x0232:
            r5 = -1
            r0.m38361b((int) r5)
        L_0x0236:
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
            double r2 = r26.m38333a((byte[]) r27, (int) r28, (int) r29, (double) r30, (double) r32)
            long r9 = java.lang.System.currentTimeMillis()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "antiAttack consume: "
            r4.append(r6)
            long r9 = r9 - r7
            r4.append(r9)
            java.lang.String r6 = "ms, attackScore: "
            r4.append(r6)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            com.didichuxing.sdk.alphaface.utils.AFLog.m38441v(r2)
            int r2 = r0.f51220a
            if (r2 != r5) goto L_0x02a6
            r0.m38349a((com.didichuxing.sdk.alphaface.core.colorliveness.ColorfulLivenessManager.FaceInfo) r1)
        L_0x02a6:
            r25.m38359b()
            java.util.concurrent.atomic.AtomicInteger r1 = r0.f51233n
            int r1 = r1.get()
            int r2 = r0.f51228i
            if (r1 != r2) goto L_0x02b6
            r25.m38365c()
        L_0x02b6:
            return
        L_0x02b7:
            r1 = 0
            r0.m38348a((int) r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.sdk.alphaface.core.colorliveness.ColorfulLivenessManager.m38351a(byte[], int, int, int, int, float, float, float):void");
    }

    /* renamed from: a */
    private int m38337a(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, int i5) {
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
    private FaceInfo m38343a(int[] iArr) {
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
    private double m38331a(Bitmap bitmap, byte[] bArr, boolean z) {
        return (double) this.f51221b.compressBitmap(bitmap, 75, bArr, z);
    }

    /* renamed from: a */
    private double m38334a(byte[] bArr, int i, int i2, byte[] bArr2, boolean z) {
        return (double) this.f51221b.compressRGBA(bArr, i, i2, 75, bArr2, z);
    }

    /* renamed from: a */
    private float[] m38354a(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4) {
        float[] qualityDetect = this.f51221b.qualityDetect(bArr2, i, i2);
        if (this.f51214D == null) {
            this.f51214D = new CopyOnWriteArrayList();
        }
        if (!(qualityDetect == null || qualityDetect.length == 0)) {
            m38347a(qualityDetect[0], qualityDetect[1], qualityDetect[0], bArr, i3, i4, this.f51214D);
        }
        if (!(this.f51233n.get() % this.f51218H != this.f51219I || qualityDetect == null || qualityDetect.length == 0)) {
            SystemUtils.log(3, "martin", "collect bitmap " + this.f51233n.get(), (Throwable) null, "com.didichuxing.sdk.alphaface.core.colorliveness.ColorfulLivenessManager", 540);
            if (this.f51213C == null) {
                this.f51213C = new CopyOnWriteArrayList();
            }
            m38360b(qualityDetect[0], qualityDetect[1], qualityDetect[0], bArr, i3, i4, this.f51213C);
        }
        return qualityDetect;
    }

    /* renamed from: a */
    private void m38347a(float f, float f2, float f3, byte[] bArr, int i, int i2, List<PicWithScore> list) {
        PicWithScore picWithScore = new PicWithScore();
        picWithScore.qualityScore = (double) f;
        picWithScore.qualityOk = (double) f2;
        picWithScore.attackScore = (double) f3;
        picWithScore.rgba = bArr;
        picWithScore.width = i;
        picWithScore.height = i2;
        if (list.size() < 1) {
            list.add(picWithScore);
        } else if (list.get(0).qualityScore < picWithScore.qualityScore) {
            list.set(0, picWithScore);
        }
    }

    /* renamed from: b */
    private void m38360b(float f, float f2, float f3, byte[] bArr, int i, int i2, List<PicWithScore> list) {
        PicWithScore picWithScore = new PicWithScore();
        picWithScore.qualityScore = (double) f;
        picWithScore.qualityOk = (double) f2;
        picWithScore.attackScore = (double) f3;
        picWithScore.rgba = bArr;
        picWithScore.width = i;
        picWithScore.height = i2;
        list.add(picWithScore);
    }

    public void quit() {
        m38345a();
        this.f51224e.set(true);
        Handler handler = this.f51223d;
        if (handler != null) {
            handler.post(new Runnable() {
                public void run() {
                    ColorfulLivenessManager.this.f51223d.removeCallbacksAndMessages((Object) null);
                    AlphaFaceFacade.getInstance().unInitModels();
                    if (ColorfulLivenessManager.this.f51222c != null) {
                        ColorfulLivenessManager.this.f51222c.quit();
                    }
                }
            });
        }
    }

    /* renamed from: a */
    private void m38346a(double d, double d2, double d3, byte[] bArr, int i, int i2, int i3, List<PicWithScore> list) {
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
    private double m38333a(byte[] bArr, int i, int i2, double d, double d2) {
        double attackDetect = this.f51221b.attackDetect(bArr, i, i2);
        if (attackDetect >= 99.0d) {
            this.f51245z++;
        }
        if (this.f51215E == null) {
            this.f51215E = new CopyOnWriteArrayList();
        }
        if (d > this.f51243x) {
            m38346a(d, d2, attackDetect, bArr, i, i2, this.f51241v, this.f51215E);
        }
        return attackDetect;
    }

    /* renamed from: a */
    private void m38348a(final int i) {
        int i2 = this.f51235p;
        if (i2 == this.f51236q) {
            this.f51235p = 0;
            resetStatus();
            UIHandler.post(new Runnable() {
                public void run() {
                    if (ColorfulLivenessManager.this.f51212B != null) {
                        ColorfulLivenessManager.this.f51212B.onFaceError(i);
                    }
                }
            });
            return;
        }
        this.f51235p = i2 + 1;
    }

    public void resetStatus() {
        this.f51220a = -1;
        m38345a();
        AtomicInteger atomicInteger = this.f51233n;
        if (atomicInteger != null) {
            atomicInteger.set(0);
        }
        m38359b();
    }

    /* renamed from: a */
    private void m38345a() {
        List<PicWithScore> list = this.f51214D;
        if (list != null) {
            list.clear();
        }
        List<PicWithScore> list2 = this.f51213C;
        if (list2 != null) {
            list2.clear();
        }
        List<PicWithScore> list3 = this.f51216F;
        if (list3 != null) {
            list3.clear();
        }
    }

    /* renamed from: b */
    private void m38359b() {
        UIHandler.post(new Runnable() {
            public void run() {
                if (ColorfulLivenessManager.this.f51212B != null && ColorfulLivenessManager.this.f51233n != null) {
                    ColorfulLivenessManager.this.f51212B.onProcess((ColorfulLivenessManager.this.f51233n.get() * 100) / ColorfulLivenessManager.this.f51228i, ColorfulLivenessManager.this.f51233n.get() / ColorfulLivenessManager.this.f51218H);
                }
            }
        });
    }

    /* renamed from: a */
    private void m38349a(final FaceInfo faceInfo) {
        UIHandler.post(new Runnable() {
            public void run() {
                if (ColorfulLivenessManager.this.f51212B != null) {
                    ColorfulLivenessManager.this.f51212B.onDetectFace(faceInfo);
                }
            }
        });
    }

    /* renamed from: c */
    private void m38365c() {
        UIHandler.post(new Runnable() {
            public void run() {
                if (ColorfulLivenessManager.this.f51212B == null) {
                    return;
                }
                if (ColorfulLivenessManager.this.f51239t < ColorfulLivenessManager.this.f51237r) {
                    ColorfulLivenessManager.m38376i(ColorfulLivenessManager.this);
                    if (ColorfulLivenessManager.this.f51214D == null || ColorfulLivenessManager.this.f51214D.size() <= 0) {
                        ColorfulLivenessManager.this.f51212B.onSuccess(ColorfulLivenessManager.this.f51245z, ColorfulLivenessManager.this.f51214D, ColorfulLivenessManager.this.f51213C, ColorfulLivenessManager.this.f51216F);
                    } else if (Double.compare(((PicWithScore) ColorfulLivenessManager.this.f51214D.get(0)).qualityOk, 1.0d) != 0) {
                        ColorfulLivenessManager.this.f51212B.onFaceQualityError();
                        UIHandler.postDelayed((long) ColorfulLivenessManager.this.f51238s, new Runnable() {
                            public void run() {
                                ColorfulLivenessManager.this.resetStatus();
                            }
                        });
                    } else {
                        ColorfulLivenessManager.this.f51212B.onSuccess(ColorfulLivenessManager.this.f51245z, ColorfulLivenessManager.this.f51214D, ColorfulLivenessManager.this.f51213C, ColorfulLivenessManager.this.f51216F);
                    }
                } else {
                    ColorfulLivenessManager.this.f51212B.onSuccess(ColorfulLivenessManager.this.f51245z, ColorfulLivenessManager.this.f51214D, ColorfulLivenessManager.this.f51213C, ColorfulLivenessManager.this.f51216F);
                }
            }
        });
    }

    /* renamed from: b */
    private void m38361b(final int i) {
        if (this.f51220a == i) {
            UIHandler.post(new Runnable() {
                public void run() {
                    if (ColorfulLivenessManager.this.f51212B != null) {
                        ColorfulLivenessManager.this.f51212B.onQualityError(i);
                    }
                }
            });
        } else {
            this.f51220a = i;
        }
    }

    public String toString() {
        return "BioassayManager{fps=" + this.f51225f + ", frameCount=" + this.f51226g + ", frameSkip=" + this.f51227h + ", detectCountMax=" + this.f51228i + ", detectCount=" + this.f51233n + ", detectTime=" + this.f51234o + ", faceErrorCount=" + this.f51235p + ", faceErrorCountMax=" + this.f51236q + ", bestPicCount=" + this.f51240u + ", attackPicCount=" + this.f51241v + '}';
    }

    /* renamed from: a */
    private Bitmap m38341a(byte[] bArr, int i, int i2) {
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
    private Bitmap m38340a(Bitmap bitmap, int i) {
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
    private Bitmap m38339a(Bitmap bitmap, float f) {
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
    private byte[] m38353a(Bitmap bitmap) {
        ByteBuffer allocate = ByteBuffer.allocate(bitmap.getByteCount());
        bitmap.copyPixelsToBuffer(allocate);
        return allocate.array();
    }

    public static class Builder {
        private ColorfulLivenessManager manager = new ColorfulLivenessManager();

        public Builder setModelLayers(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int i, int i2, int[] iArr5, int i3, int i4) {
            return this;
        }

        public Builder setFrameSkip(int i) {
            int unused = this.manager.f51227h = i;
            return this;
        }

        public Builder setColorfulListener(IColorfulListener iColorfulListener) {
            IColorfulListener unused = this.manager.f51212B = iColorfulListener;
            return this;
        }

        public Builder setDetectTime(int i) {
            long unused = this.manager.f51234o = (long) i;
            return this;
        }

        public Builder setFps(int i) {
            int unused = this.manager.f51225f = i;
            return this;
        }

        public Builder setLandscape(boolean z) {
            boolean unused = this.manager.f51244y = z;
            return this;
        }

        public Builder setActionPicCount(int i) {
            int unused = this.manager.f51241v = i;
            return this;
        }

        public Builder setFaceErrorCountMax(int i) {
            int unused = this.manager.f51236q = i;
            return this;
        }

        public Builder setBestPicQualityThreshold(double d) {
            double unused = this.manager.f51242w = d;
            return this;
        }

        public Builder setFaceQualityErrorMaxTimes(int i) {
            int unused = this.manager.f51237r = i;
            return this;
        }

        public Builder setFaceQualityErrorDelay(int i) {
            int unused = this.manager.f51238s = i;
            return this;
        }

        public Builder setAttackPicQualityThreshold(double d) {
            double unused = this.manager.f51243x = d;
            return this;
        }

        public Builder setDetectTimeMax(float f) {
            float unused = this.manager.f51231l = f;
            return this;
        }

        public Builder setDetectTimeMin(float f) {
            float unused = this.manager.f51230k = f;
            return this;
        }

        public Builder setQualityThreshold(float f) {
            float unused = this.manager.f51232m = f;
            return this;
        }

        public Builder setColorCount(int i) {
            int unused = this.manager.f51217G = i;
            return this;
        }

        public Builder setWaterType(int i) {
            int unused = this.manager.f51211A = i;
            return this;
        }

        public ColorfulLivenessManager create() {
            if (this.manager.f51234o < 1000) {
                throw new RuntimeException("detect time less than 1000ms");
            } else if (this.manager.f51225f <= 0) {
                throw new RuntimeException("fps is 0 or less than 0");
            } else if (this.manager.f51227h <= this.manager.f51225f) {
                ColorfulLivenessManager colorfulLivenessManager = this.manager;
                int unused = colorfulLivenessManager.f51228i = (int) (((float) ((long) (colorfulLivenessManager.f51225f / this.manager.f51227h))) * this.manager.f51231l);
                ColorfulLivenessManager colorfulLivenessManager2 = this.manager;
                int unused2 = colorfulLivenessManager2.f51228i = colorfulLivenessManager2.f51228i - (this.manager.f51228i % this.manager.f51217G);
                ColorfulLivenessManager colorfulLivenessManager3 = this.manager;
                int unused3 = colorfulLivenessManager3.f51218H = colorfulLivenessManager3.f51228i / this.manager.f51217G;
                ColorfulLivenessManager colorfulLivenessManager4 = this.manager;
                int unused4 = colorfulLivenessManager4.f51219I = (colorfulLivenessManager4.f51218H + 1) / 2;
                SystemUtils.log(3, "martin", "detectCountMax " + this.manager.f51228i + "  singleFrameCount  " + this.manager.f51218H, (Throwable) null, "com.didichuxing.sdk.alphaface.core.colorliveness.ColorfulLivenessManager$Builder", 1002);
                ColorfulLivenessManager colorfulLivenessManager5 = this.manager;
                int unused5 = colorfulLivenessManager5.f51229j = (int) (((float) ((long) (colorfulLivenessManager5.f51225f / this.manager.f51227h))) * this.manager.f51230k);
                AFLog.m38441v(this.manager.toString());
                return this.manager;
            } else {
                throw new RuntimeException("frameSkip is larger than fps");
            }
        }
    }
}
