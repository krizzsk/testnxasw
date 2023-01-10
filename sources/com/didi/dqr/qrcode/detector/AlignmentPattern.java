package com.didi.dqr.qrcode.detector;

import com.didi.dqr.ResultPoint;

public final class AlignmentPattern extends ResultPoint {

    /* renamed from: a */
    private final float f20911a;

    AlignmentPattern(float f, float f2, float f3) {
        super(f, f2);
        this.f20911a = f3;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo63557a(float f, float f2, float f3) {
        if (Math.abs(f2 - getY()) > f || Math.abs(f3 - getX()) > f) {
            return false;
        }
        float abs = Math.abs(f - this.f20911a);
        if (abs <= 1.0f || abs <= this.f20911a) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public AlignmentPattern mo63558b(float f, float f2, float f3) {
        return new AlignmentPattern((getX() + f2) / 2.0f, (getY() + f) / 2.0f, (this.f20911a + f3) / 2.0f);
    }
}
