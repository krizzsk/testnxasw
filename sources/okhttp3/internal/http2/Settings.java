package okhttp3.internal.http2;

import java.util.Arrays;

public final class Settings {

    /* renamed from: a */
    static final int f7339a = 65535;

    /* renamed from: b */
    static final int f7340b = 1;

    /* renamed from: c */
    static final int f7341c = 2;

    /* renamed from: d */
    static final int f7342d = 4;

    /* renamed from: e */
    static final int f7343e = 5;

    /* renamed from: f */
    static final int f7344f = 6;

    /* renamed from: g */
    static final int f7345g = 7;

    /* renamed from: h */
    static final int f7346h = 10;

    /* renamed from: i */
    private int f7347i;

    /* renamed from: j */
    private final int[] f7348j = new int[10];

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo30579a() {
        this.f7347i = 0;
        Arrays.fill(this.f7348j, 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Settings mo30578a(int i, int i2) {
        if (i >= 0) {
            int[] iArr = this.f7348j;
            if (i < iArr.length) {
                this.f7347i = (1 << i) | this.f7347i;
                iArr[i] = i2;
            }
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo30581a(int i) {
        return ((1 << i) & this.f7347i) != 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo30584b(int i) {
        return this.f7348j[i];
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo30583b() {
        return Integer.bitCount(this.f7347i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo30585c() {
        if ((this.f7347i & 2) != 0) {
            return this.f7348j[1];
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo30582a(boolean z) {
        return ((this.f7347i & 4) != 0 ? this.f7348j[2] : z ? 1 : 0) == 1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo30586c(int i) {
        return (this.f7347i & 16) != 0 ? this.f7348j[4] : i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo30588d(int i) {
        return (this.f7347i & 32) != 0 ? this.f7348j[5] : i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public int mo30589e(int i) {
        return (this.f7347i & 64) != 0 ? this.f7348j[6] : i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo30587d() {
        if ((this.f7347i & 128) != 0) {
            return this.f7348j[7];
        }
        return 65535;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo30580a(Settings settings) {
        for (int i = 0; i < 10; i++) {
            if (settings.mo30581a(i)) {
                mo30578a(i, settings.mo30584b(i));
            }
        }
    }
}
