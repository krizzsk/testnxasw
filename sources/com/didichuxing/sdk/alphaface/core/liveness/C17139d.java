package com.didichuxing.sdk.alphaface.core.liveness;

import android.graphics.Point;
import android.util.Pair;
import com.didichuxing.sdk.alphaface.core.liveness.ILivenessCallback;
import com.didichuxing.sdk.alphaface.core.liveness.IMirrorCallback;
import com.didichuxing.sdk.alphaface.utils.AFLog;
import com.didichuxing.sdk.alphaface.utils.UIHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/* renamed from: com.didichuxing.sdk.alphaface.core.liveness.d */
/* compiled from: FaceDetect */
class C17139d extends C17136a<Pair<List<ILivenessCallback.PicWithScore>, List<ILivenessCallback.PicWithScore>>> {

    /* renamed from: f */
    private final List<ILivenessCallback.PicWithScore> f51305f;

    /* renamed from: g */
    private final List<ILivenessCallback.PicWithScore> f51306g;

    /* renamed from: h */
    private final List<ILivenessCallback.PicWithScore> f51307h;

    /* renamed from: i */
    private final double f51308i;

    /* renamed from: j */
    private final double f51309j;

    /* renamed from: k */
    private final int f51310k;

    /* renamed from: l */
    private final boolean f51311l;

    /* renamed from: m */
    private final Random f51312m;

    /* renamed from: n */
    private int f51313n;

    /* renamed from: o */
    private final int f51314o;

    /* renamed from: p */
    private final int f51315p;

    /* renamed from: q */
    private final int f51316q;

    /* renamed from: r */
    private boolean f51317r;

    /* renamed from: s */
    private long f51318s;

    /* renamed from: t */
    private int f51319t;

    /* renamed from: u */
    private boolean f51320u;

    /* renamed from: v */
    private int f51321v;

    public C17139d(LivenessManager livenessManager) {
        super(livenessManager);
        this.f51319t = 0;
        this.f51320u = true;
        this.f51321v = 0;
        this.f51314o = 1;
        this.f51315p = this.f51283c.getAttackPicCount();
        this.f51305f = new ArrayList(this.f51314o);
        this.f51306g = new ArrayList(this.f51315p);
        this.f51307h = new ArrayList();
        this.f51321v = this.f51283c.getWaterType();
        this.f51308i = this.f51283c.getAttackPicQualityThreshold();
        this.f51309j = this.f51283c.getBestPicQualityThreshold();
        this.f51316q = this.f51283c.getDetectTime();
        this.f51310k = this.f51283c.getFaceQualityErrorMaxTimes();
        this.f51313n = this.f51283c.getFaceQualityErrorDelay();
        this.f51311l = this.f51283c.attackEnable();
        this.f51312m = new Random();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo127158b(byte[] bArr, int i, int i2, int i3, float f, float f2, float f3) {
        ILivenessCallback.PicWithScore picWithScore;
        int i4;
        int i5 = i;
        int i6 = i2;
        if (this.f51320u) {
            long currentTimeMillis = System.currentTimeMillis();
            int[] maxFaceDetect = this.f51281a.maxFaceDetect(bArr, i, i2, i3, f, f2, f3);
            if (maxFaceDetect == null || maxFaceDetect.length == 0) {
                m38432b(0);
            } else if (maxFaceDetect[0] == 0) {
                m38432b(0);
            } else if (maxFaceDetect[1] == 0) {
                m38432b(5);
            } else {
                int i7 = maxFaceDetect[2];
                if (i7 == 0) {
                    if (this.f51307h.size() == 0) {
                        ILivenessCallback.PicWithScore picWithScore2 = new ILivenessCallback.PicWithScore();
                        if (this.f51321v == -2) {
                            picWithScore2.rgba = bArr;
                            picWithScore = picWithScore2;
                            i4 = 1;
                        } else {
                            byte[] bArr2 = bArr;
                            byte[] bArr3 = new byte[(i5 * i6 * 4)];
                            picWithScore = picWithScore2;
                            i4 = this.f51281a.addWaterMark(bArr, i, i2, bArr3, this.f51321v);
                            picWithScore.rgba = bArr3;
                        }
                        picWithScore.qualityScore = 0.0d;
                        picWithScore.qualityOk = (double) i4;
                        picWithScore.attackScore = 0.0d;
                        picWithScore.width = i5;
                        picWithScore.height = i6;
                        this.f51307h.add(picWithScore);
                    }
                    IMirrorCallback.FaceInfo a = m38427a(maxFaceDetect);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    AFLog.m38441v("maxFaceDetect consume: " + (currentTimeMillis2 - currentTimeMillis) + "ms");
                    int i8 = maxFaceDetect[3];
                    int i9 = maxFaceDetect[4];
                    int i10 = maxFaceDetect[5];
                    int i11 = maxFaceDetect[6];
                    int i12 = (int) (((double) (i11 - i9)) * 0.8d);
                    int i13 = (i10 + i8) / 2;
                    int i14 = i11 - i12;
                    int i15 = i12 / 2;
                    int i16 = i13 - i15;
                    double d = ((double) i12) * 0.0485d;
                    int max = Math.max(Math.min((int) (((double) i16) - d), i5), 0);
                    int max2 = Math.max(Math.min((int) (((double) i14) - d), i6), 0);
                    int max3 = Math.max(Math.min((int) (((double) (i13 + i15)) + d), i5), 0);
                    int max4 = Math.max(Math.min((int) (((double) i11) + d), i6), 0);
                    int i17 = max3 - max;
                    int i18 = max4 - max2;
                    byte[] bArr4 = new byte[(i17 * i18 * 4)];
                    m38426a(bArr, bArr4, max, max2, max3, max4, i);
                    long currentTimeMillis3 = System.currentTimeMillis();
                    AFLog.m38441v("crop face from ARGB: " + (currentTimeMillis3 - currentTimeMillis2) + "ms");
                    long currentTimeMillis4 = System.currentTimeMillis();
                    float[] a2 = m38431a(bArr, bArr4, i17, i18, i, i2);
                    long currentTimeMillis5 = System.currentTimeMillis();
                    AFLog.m38441v("qualityDetect cost time : " + (currentTimeMillis5 - currentTimeMillis4) + "ms");
                    if (a2 != null && a2.length != 0) {
                        AFLog.m38441v("qualityInfo: " + Arrays.toString(a2));
                        float f4 = a2[0];
                        float f5 = a2[1];
                        if (a2[2] == 1.0f) {
                            m38428a(8);
                        } else if (a2[3] == 1.0f) {
                            m38428a(9);
                        } else if (a2[4] == 1.0f) {
                            m38428a(10);
                        } else if (a2[5] == 1.0f) {
                            m38428a(11);
                        } else {
                            m38428a(-1);
                        }
                        long currentTimeMillis6 = System.currentTimeMillis();
                        AFLog.m38441v("qualityDetect consume: " + (currentTimeMillis6 - currentTimeMillis2) + "ms, qualityScore:" + f4);
                        StringBuilder sb = new StringBuilder();
                        sb.append("qualityDetect quality_ok: ");
                        sb.append(f5);
                        AFLog.m38441v(sb.toString());
                        double a3 = m38425a(bArr, i, i2, (double) f4, (double) f5);
                        long currentTimeMillis7 = System.currentTimeMillis();
                        AFLog.m38441v("antiAttack consume: " + (currentTimeMillis7 - currentTimeMillis6) + "ms, attackScore: " + a3);
                        m38430a(a);
                        if (this.f51318s == 0) {
                            this.f51318s = System.currentTimeMillis();
                        }
                        m38429a(System.currentTimeMillis() - this.f51318s);
                        if (System.currentTimeMillis() - this.f51318s >= ((long) this.f51316q)) {
                            m38433f();
                        }
                    }
                } else if (i7 == -1) {
                    m38432b(6);
                } else {
                    m38432b(7);
                }
            }
        }
    }

    /* renamed from: f */
    private void m38433f() {
        this.f51320u = false;
        int i = this.f51319t;
        if (i < this.f51310k) {
            this.f51319t = i + 1;
            List<ILivenessCallback.PicWithScore> list = this.f51305f;
            if (list == null || list.size() <= 0) {
                this.f51317r = true;
                this.f51282b.onMirrorSuccess(this.f51305f, this.f51306g, this.f51307h);
            } else if (Double.compare(this.f51305f.get(0).qualityOk, 1.0d) != 0) {
                this.f51282b.onMirrorFaceQualityError();
                UIHandler.postDelayed((long) this.f51313n, new FaceDetect$1(this));
            } else {
                this.f51317r = true;
                this.f51282b.onMirrorSuccess(this.f51305f, this.f51306g, this.f51307h);
            }
        } else {
            this.f51317r = true;
            this.f51282b.onMirrorSuccess(this.f51305f, this.f51306g, this.f51307h);
        }
    }

    /* renamed from: a */
    private void m38429a(long j) {
        this.f51282b.onMirrorProcess(j);
    }

    /* renamed from: a */
    private void m38430a(IMirrorCallback.FaceInfo faceInfo) {
        this.f51282b.onDetectFace(faceInfo);
    }

    /* renamed from: a */
    private void m38428a(int i) {
        this.f51282b.mo127163a(i);
    }

    /* renamed from: b */
    private void m38432b(int i) {
        this.f51282b.mo127164b(i);
    }

    /* renamed from: a */
    private IMirrorCallback.FaceInfo m38427a(int[] iArr) {
        IMirrorCallback.FaceInfo faceInfo = new IMirrorCallback.FaceInfo();
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

    /* renamed from: a */
    private int m38426a(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, int i5) {
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
    private double m38425a(byte[] bArr, int i, int i2, double d, double d2) {
        byte[] bArr2 = bArr;
        int i3 = i;
        int i4 = i2;
        double d3 = d;
        if (this.f51311l) {
            double attackDetect = this.f51281a.attackDetect(bArr, i3, i4);
            if (d3 > this.f51308i) {
                SortUtils.sortPicList(d, d2, attackDetect, bArr, i, i2, this.f51315p, this.f51306g);
            }
            return attackDetect;
        }
        ILivenessCallback.PicWithScore picWithScore = new ILivenessCallback.PicWithScore();
        picWithScore.qualityScore = d3;
        picWithScore.qualityOk = d2;
        picWithScore.attackScore = d3;
        picWithScore.rgba = bArr2;
        picWithScore.width = i3;
        picWithScore.height = i4;
        if (d3 <= this.f51308i) {
            return 0.0d;
        }
        int size = this.f51306g.size();
        int i5 = this.f51315p;
        if (size < i5) {
            this.f51306g.add(picWithScore);
            return 0.0d;
        }
        this.f51306g.set(this.f51312m.nextInt(i5), picWithScore);
        return 0.0d;
    }

    /* renamed from: a */
    private float[] m38431a(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4) {
        float[] qualityDetect = this.f51281a.qualityDetect(bArr2, i, i2);
        if (!(qualityDetect == null || qualityDetect.length == 0 || ((double) qualityDetect[0]) <= this.f51309j)) {
            SortUtils.sortPicList((double) qualityDetect[0], (double) qualityDetect[1], (double) qualityDetect[0], bArr, i3, i4, this.f51314o, this.f51305f);
        }
        return qualityDetect;
    }

    /* renamed from: b */
    public boolean mo127159b() {
        return this.f51317r;
    }

    /* renamed from: c */
    public void mo127160c() {
        this.f51282b.onMirrorReset();
        this.f51320u = true;
        this.f51317r = false;
        this.f51306g.clear();
        this.f51305f.clear();
        this.f51307h.clear();
        this.f51318s = 0;
        m38429a(0);
    }

    /* renamed from: e */
    public Pair<List<ILivenessCallback.PicWithScore>, List<ILivenessCallback.PicWithScore>> mo127155a() {
        return new Pair<>(this.f51305f, this.f51306g);
    }
}
