package com.didichuxing.sdk.alphaface.core.liveness;

import com.didichuxing.sdk.alphaface.core.liveness.ILivenessCallback;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didichuxing.sdk.alphaface.core.liveness.b */
/* compiled from: ActionDetect */
class C17137b extends C17136a<List<ILivenessCallback.PicWithScore>> {

    /* renamed from: f */
    public static final int f51286f = 0;

    /* renamed from: g */
    public static final int f51287g = 1;

    /* renamed from: h */
    private final List<ILivenessCallback.PicWithScore> f51288h = new ArrayList(this.f51289i);

    /* renamed from: i */
    private final int f51289i = 1;

    /* renamed from: j */
    private final int f51290j = this.f51283c.getActionInterruptTime();

    /* renamed from: k */
    private final int f51291k = this.f51283c.getActionTimeout();

    /* renamed from: l */
    private int f51292l = -1;

    /* renamed from: m */
    private int[] f51293m = this.f51283c.getDetectAction();

    /* renamed from: n */
    private long f51294n;

    /* renamed from: o */
    private long f51295o;

    /* renamed from: b */
    public boolean mo127159b() {
        return false;
    }

    public C17137b(LivenessManager livenessManager) {
        super(livenessManager);
    }

    /* renamed from: e */
    public List<ILivenessCallback.PicWithScore> mo127155a() {
        return this.f51288h;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo127158b(byte[] bArr, int i, int i2, int i3, float f, float f2, float f3) {
        if (this.f51292l < 0) {
            m38414f();
            int[] iArr = this.f51293m;
            int i4 = this.f51292l + 1;
            this.f51292l = i4;
            m38413b(0, iArr[i4]);
        }
        float[] livenessDetect = this.f51281a.livenessDetect(bArr, i, i2, i3, f, f2, f3);
        if (livenessDetect != null && livenessDetect.length == 3) {
            if (livenessDetect[0] == 1.0f) {
                m38412a(1, 0);
                int i5 = this.f51292l;
                int[] iArr2 = this.f51293m;
                if (i5 == iArr2.length - 1) {
                    C17138c cVar = this.f51282b;
                    int[] iArr3 = this.f51293m;
                    int i6 = this.f51292l;
                    int i7 = iArr3[i6];
                    int i8 = i6 + 1;
                    this.f51292l = i8;
                    cVar.onActionChange(i7, 5, i8, iArr3.length);
                    this.f51282b.onActionSuccess(this.f51288h);
                } else {
                    int i9 = iArr2[i5];
                    int i10 = i5 + 1;
                    this.f51292l = i10;
                    m38413b(i9, iArr2[i10]);
                }
            } else {
                m38415g();
                if (livenessDetect[1] >= 1.0f && livenessDetect[1] <= 4.0f) {
                    this.f51282b.onActionTip((int) livenessDetect[1]);
                }
                this.f51282b.mo127165c((int) livenessDetect[1]);
                m38411a(livenessDetect[1]);
            }
            SortUtils.sortPicList((double) livenessDetect[2], 1.0d, (double) livenessDetect[2], bArr, i, i2, this.f51289i, this.f51288h);
        }
    }

    /* renamed from: f */
    private void m38414f() {
        this.f51282b.onStartAction(this.f51293m);
    }

    /* renamed from: g */
    private void m38415g() {
        int currentTimeMillis = (int) (System.currentTimeMillis() - this.f51294n);
        this.f51282b.onActionCountdown(currentTimeMillis);
        if (currentTimeMillis >= this.f51291k) {
            m38412a(0, 2);
            this.f51282b.onActionTimeout();
        }
    }

    /* renamed from: a */
    private void m38411a(float f) {
        if (f != 0.0f) {
            this.f51295o = 0;
        } else if (this.f51295o == 0) {
            this.f51295o = System.currentTimeMillis();
        } else if (System.currentTimeMillis() - this.f51295o > ((long) this.f51290j)) {
            m38412a(0, 1);
            this.f51282b.onActionFailed();
        }
    }

    /* renamed from: a */
    private void m38412a(int i, int i2) {
        this.f51282b.onActionInfo(i, i2, this.f51293m[this.f51292l], this.f51281a.livenessProcess(0, this.f51293m[this.f51292l]));
    }

    /* renamed from: b */
    private void m38413b(int i, int i2) {
        this.f51281a.livenessProcess(1, i2);
        this.f51282b.onActionChange(i, i2, this.f51292l, this.f51293m.length);
        this.f51294n = System.currentTimeMillis();
    }

    /* renamed from: c */
    public void mo127160c() {
        this.f51282b.onActionReset();
        this.f51288h.clear();
        this.f51292l = -1;
        this.f51295o = 0;
    }
}
