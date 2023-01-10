package com.didi.hawaii.mapsdk.gesture;

/* renamed from: com.didi.hawaii.mapsdk.gesture.a */
/* compiled from: PermittedActionsGuard */
class C9706a {

    /* renamed from: a */
    private static final int f25901a = 8;

    /* renamed from: b */
    private static final int f25902b = 255;

    /* renamed from: c */
    private static final int f25903c = 255;

    C9706a() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo74633a(int i, int i2, int i3) {
        long a = m20484a(i2, i3);
        long j = (long) i;
        if (j == a) {
            return false;
        }
        while (a != 0) {
            if (j == (255 & a)) {
                return false;
            }
            a >>= 8;
        }
        return true;
    }

    /* renamed from: a */
    private long m20484a(int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        if (Math.abs(i - i2) > 1) {
            return 255;
        }
        if (i > i2) {
            return 5;
        }
        if (i < i2) {
            return 255;
        }
        return ((i == 1 ? 1 : 6) << 8) + 2;
    }
}
