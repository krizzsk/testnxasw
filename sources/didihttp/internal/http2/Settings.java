package didihttp.internal.http2;

import java.util.Arrays;

public final class Settings {

    /* renamed from: a */
    static final int f59595a = 65535;

    /* renamed from: b */
    static final int f59596b = 1;

    /* renamed from: c */
    static final int f59597c = 2;

    /* renamed from: d */
    static final int f59598d = 4;

    /* renamed from: e */
    static final int f59599e = 5;

    /* renamed from: f */
    static final int f59600f = 6;

    /* renamed from: g */
    static final int f59601g = 7;

    /* renamed from: h */
    static final int f59602h = 10;

    /* renamed from: i */
    private int f59603i;

    /* renamed from: j */
    private final int[] f59604j = new int[10];

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo179980a() {
        this.f59603i = 0;
        Arrays.fill(this.f59604j, 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Settings mo179979a(int i, int i2) {
        int[] iArr = this.f59604j;
        if (i < iArr.length && i >= 0) {
            this.f59603i = (1 << i) | this.f59603i;
            iArr[i] = i2;
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo179982a(int i) {
        return ((1 << i) & this.f59603i) != 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo179985b(int i) {
        return this.f59604j[i];
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo179984b() {
        return Integer.bitCount(this.f59603i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo179986c() {
        if ((this.f59603i & 2) != 0) {
            return this.f59604j[1];
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo179983a(boolean z) {
        return ((this.f59603i & 4) != 0 ? this.f59604j[2] : z ? 1 : 0) == 1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo179987c(int i) {
        return (this.f59603i & 16) != 0 ? this.f59604j[4] : i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo179989d(int i) {
        return (this.f59603i & 32) != 0 ? this.f59604j[5] : i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public int mo179990e(int i) {
        return (this.f59603i & 64) != 0 ? this.f59604j[6] : i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo179988d() {
        if ((this.f59603i & 128) != 0) {
            return this.f59604j[7];
        }
        return 65535;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo179981a(Settings settings) {
        for (int i = 0; i < 10; i++) {
            if (settings.mo179982a(i)) {
                mo179979a(i, settings.mo179985b(i));
            }
        }
    }
}
