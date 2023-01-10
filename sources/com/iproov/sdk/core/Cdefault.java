package com.iproov.sdk.core;

import android.graphics.Point;
import android.graphics.Rect;
import p095switch.C3658case;
import p235do.C21820break;

/* renamed from: com.iproov.sdk.core.default  reason: invalid class name */
/* compiled from: Target */
class Cdefault {

    /* renamed from: a */
    private static final C20868if[] f57077a = {C20868if.MIDDLE_RIGHT, C20868if.BOTTOM_RIGHT, C20868if.BOTTOM_MIDDLE, C20868if.BOTTOM_LEFT, C20868if.MIDDLE_LEFT, C20868if.TOP_LEFT, C20868if.TOP_MIDDLE, C20868if.TOP_RIGHT};

    /* renamed from: b */
    private final C20867for f57078b;

    /* renamed from: c */
    private final C20868if f57079c;

    /* renamed from: d */
    private final Rect f57080d;

    /* renamed from: e */
    private final C20870final f57081e;

    /* renamed from: com.iproov.sdk.core.default$do */
    /* compiled from: Target */
    static /* synthetic */ class C20866do {

        /* renamed from: do */
        static final /* synthetic */ int[] f57082do;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.iproov.sdk.core.default$if[] r0 = com.iproov.sdk.core.Cdefault.C20868if.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f57082do = r0
                com.iproov.sdk.core.default$if r1 = com.iproov.sdk.core.Cdefault.C20868if.TOP_LEFT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f57082do     // Catch:{ NoSuchFieldError -> 0x001d }
                com.iproov.sdk.core.default$if r1 = com.iproov.sdk.core.Cdefault.C20868if.TOP_MIDDLE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f57082do     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.iproov.sdk.core.default$if r1 = com.iproov.sdk.core.Cdefault.C20868if.TOP_RIGHT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f57082do     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.iproov.sdk.core.default$if r1 = com.iproov.sdk.core.Cdefault.C20868if.MIDDLE_LEFT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f57082do     // Catch:{ NoSuchFieldError -> 0x003e }
                com.iproov.sdk.core.default$if r1 = com.iproov.sdk.core.Cdefault.C20868if.MIDDLE_RIGHT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f57082do     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.iproov.sdk.core.default$if r1 = com.iproov.sdk.core.Cdefault.C20868if.BOTTOM_LEFT     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f57082do     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.iproov.sdk.core.default$if r1 = com.iproov.sdk.core.Cdefault.C20868if.BOTTOM_MIDDLE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f57082do     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.iproov.sdk.core.default$if r1 = com.iproov.sdk.core.Cdefault.C20868if.BOTTOM_RIGHT     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.core.Cdefault.C20866do.<clinit>():void");
        }
    }

    /* renamed from: com.iproov.sdk.core.default$for */
    /* compiled from: Target */
    public enum C20867for {
        SMALL,
        LARGE
    }

    /* renamed from: com.iproov.sdk.core.default$if */
    /* compiled from: Target */
    public enum C20868if {
        TOP_RIGHT,
        TOP_MIDDLE,
        TOP_LEFT,
        MIDDLE_LEFT,
        MIDDLE_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_MIDDLE,
        BOTTOM_RIGHT
    }

    Cdefault(Rect rect, Rect rect2, C20870final finalR) {
        this.f57081e = finalR;
        this.f57080d = rect2;
        this.f57078b = ((double) rect.width()) > finalR.m48111case() * ((double) rect2.width()) ? C20867for.SMALL : C20867for.LARGE;
        this.f57079c = f57077a[(int) (((C3658case.m7394do(C3658case.m7403if(rect), C3658case.m7403if(rect2)) + 0.39269908169872414d) % 6.283185307179586d) / 0.7853981633974483d)];
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Rect mo171471a(Rect rect) {
        double d;
        float height = (((float) rect.height()) * 1.0f) / ((float) rect.width());
        if (this.f57078b == C20867for.SMALL) {
            d = this.f57081e.m48110break();
        } else {
            d = this.f57081e.m48114else();
        }
        int width = (int) (((float) this.f57080d.width()) * ((float) d));
        C21820break breakR = new C21820break(width, (int) (((float) width) * height));
        Point point = null;
        switch (C20866do.f57082do[this.f57079c.ordinal()]) {
            case 1:
                point = new Point(0, 0);
                break;
            case 2:
                point = new Point((this.f57080d.width() / 2) - (breakR.mo180435if() / 2), 0);
                break;
            case 3:
                point = new Point(this.f57080d.width() - breakR.mo180435if(), 0);
                break;
            case 4:
                point = new Point(0, (this.f57080d.height() / 2) - (breakR.mo180432do() / 2));
                break;
            case 5:
                point = new Point(this.f57080d.width() - breakR.mo180435if(), (this.f57080d.height() / 2) - (breakR.mo180432do() / 2));
                break;
            case 6:
                point = new Point(0, this.f57080d.height() - breakR.mo180432do());
                break;
            case 7:
                point = new Point((this.f57080d.width() / 2) - (breakR.mo180435if() / 2), this.f57080d.height() - breakR.mo180432do());
                break;
            case 8:
                point = new Point(this.f57080d.width() - breakR.mo180435if(), this.f57080d.height() - breakR.mo180432do());
                break;
        }
        int i = point.x;
        return new Rect(i, point.y, breakR.mo180435if() + i, point.y + breakR.mo180432do());
    }
}
