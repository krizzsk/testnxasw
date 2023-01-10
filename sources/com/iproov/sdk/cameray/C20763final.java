package com.iproov.sdk.cameray;

import java.util.List;
import p235do.C21821case;

/* renamed from: com.iproov.sdk.cameray.final */
/* compiled from: CameraSpecs */
public class C20763final {

    /* renamed from: a */
    private final C20759const f56882a;

    /* renamed from: b */
    private final List<C21821case> f56883b;

    C20763final(C20759const constR, List<C21821case> list) {
        this.f56882a = constR;
        this.f56883b = list;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C21821case mo171317a() {
        if (mo171319if()) {
            return null;
        }
        return this.f56883b.get(0);
    }

    /* renamed from: if */
    public boolean mo171319if() {
        return this.f56883b.isEmpty();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (C21821case next : this.f56883b) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(next.toString());
        }
        return "CameraSpecs{cameraSDK=" + this.f56882a + ", cameras=[" + sb + "]}";
    }

    /* renamed from: do */
    public C21821case mo171318do(C20752break... breakArr) {
        for (C20752break breakR : breakArr) {
            for (C21821case next : this.f56883b) {
                if (next.mo180437do() == breakR) {
                    return next;
                }
            }
        }
        return null;
    }
}
